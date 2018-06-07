
package pkgfinal;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.Savepoint;

/**
 * 
 * @author sylviamarin
 */
public class Datos {
    
    static String bd="PRODUCTOS";
    static String usuario="Productos";
    static String contraseña="Productos";
    static String url="jdbc:derby://localhost:1527/Productos"; 
    
    /**
     * 
     * @return 
     */
    public static String getBd() {
        return bd;
    }
    /**
     * 
     * @param bd 
     */
    public static void setBd(String bd) {
        Datos.bd = bd;
    }
    /**
     * 
     * @return 
     */
    public static String getUsuario() {
        return usuario;
    }
    /**
     * 
     * @param usuario 
     */
    public static void setUsuario(String usuario) {
        Datos.usuario = usuario;
    }
    /**
     * 
     * @return 
     */
    public static String getContraseña() {
        return contraseña;
    }
    /**
     * 
     * @param contraseña 
     */
    public static void setContraseña(String contraseña) {
        Datos.contraseña = contraseña;
    }
    /**
     * 
     * @return 
     */
    public static String getUrl() {
        return url;
    }
    /**
     * 
     * @param url 
     */
    public static void setUrl(String url) {
        Datos.url = url;
    }
    public Datos() {
        
    }
    /** Nos hace un select de todos los productos disponibles, sea cual sea 
     * la cantidad
     * 
     * @throws SQLException
     * @throws IOException 
     */
    public static void mostrarTabla() throws SQLException{ 
        Connection c =null;
        c=(Connection) DriverManager.getConnection(url,usuario,contraseña);
        Statement sentencia=c.createStatement();
        System.out.println(" =========================");
        System.out.println("| Productos Mac Cosmetics |");
        System.out.println(" =========================");
        String query="SELECT * FROM PRODUCTOS";
        ResultSet resultado=sentencia.executeQuery(query);
        while(resultado.next()){
            if (resultado.getBoolean(5) == false){
               System.out.println("CÓDIGO: "+resultado.getString(1)+", NOMBRE: "+
                    resultado.getString(2)+", PRECIO: "+
                    resultado.getString(3)+"€,  TIPO: "+resultado.getString(4)+
                    ", CANTIDAD: "+resultado.getString(6));
            }
            else {
                System.out.println("CÓDIGO: "+resultado.getString(1)+", NOMBRE: "+
                    resultado.getString(2)+", PRECIO: "+
                    resultado.getString(3)+"€,  TIPO: "+resultado.getString(4)+
                    ", CANTIDAD: "+resultado.getString(6)+" (PRODUCTO DE COLOR) ");
            }
        }
        resultado.close();
        c.close();
        
}
    /** Método que nos crea un txt con los productos y unidades que queremos
     * 
     * @param tiendaMAC
     * @throws IOException 
     */
    public static void hacerPedido(Tienda tiendaMAC) throws IOException{ 
        
        Scanner sc= new Scanner (System.in);
        System.out.println("======= Elaborar Pedido =============");
        System.out.println("Indica la url donde guardar el pedido: ");
        String direccion=sc.nextLine();
        File archivo = new File(direccion);
        // /Users/sylviamarin/Desktop/pedido.txt
        FileWriter select = new FileWriter(direccion);
        PrintWriter pw = new PrintWriter(select);
        pw.println("Mac Cosmetics: "+tiendaMAC.getCIF());
        pw.println("=================================Productos:");
        
        boolean salir= false;
            while (salir != true){
                System.out.println("Indica código del producto: ");
                String ref= sc.next();
                pw.print(ref+" ");
                System.out.println(" ");
                System.out.println("Indica cuántas unidades quieres añadir: ");
                int unidades=sc.nextInt();
                pw.println(unidades+" ");
                System.out.println("¿Quieres añadir más unidades?");
                String valor =sc.next();
                System.out.println("-----------------------------");
                if (valor.equals("no")){
                    salir=true;
                }
                else {
                    salir=false;
                }
            }
        pw.close();
            
    }
    
    /** Método que nos actualiza la Base de datos al leer el mismo archivo que 
     * hemos guardado como pedido, ahora albarán.
     * 
     * @throws SQLException
     * @throws IOException
     * @throws FileNotFoundException 
     */
    public static void actualizarStock() throws SQLException { 
        
        Connection c = null;
        Savepoint savepoint = null;
        
        try {
            c=(Connection) DriverManager.getConnection(url,usuario,contraseña);
            c.setAutoCommit(false);
            Scanner sc= new Scanner (System.in);
            System.out.println("Introduce el archivo del albarán: ");
            String albaran=sc.next();
            File archivo = new File(albaran);
            FileReader entrada=new FileReader(archivo);
            BufferedReader buffer= new BufferedReader (entrada);
            
            //Nos cuenta las lineas que hay en el documento a partir del primer 
            //producto (quitando los datos fiscales).
            buffer.readLine();
            buffer.readLine();
            String linea;
            while ((linea = buffer.readLine()) != null){  
                String vector []= linea.split(" ");
                String uds = vector [0];
                String codigo = vector [1];
                String actualizar= "update PRODUCTOS set CANTIDAD= CANTIDAD + ?"
                        + " where CÓDIGO = ? ";
                PreparedStatement sentencia=c.prepareStatement(actualizar);
                sentencia.setString(1, uds);
                sentencia.setString(2, codigo);
                sentencia.executeUpdate();
                System.out.println("Producto actualizado");   
                }
            
            entrada.close();
            c.commit();
        
        }
       
        catch (SQLException excep){
            System.out.println("No se ha podido establecer la conexión");
            c.rollback(savepoint);
            excep.getSQLState();
        }
        catch (IOException excep){
            System.out.println("No se encuentra el archivo");
            excep.getCause();
        }
        finally{
            
            c.close();
            
        }
}
}