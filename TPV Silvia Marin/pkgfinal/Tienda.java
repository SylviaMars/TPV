
package pkgfinal;

import java.util.*;
import javax.swing.*;
        

/*{Debido a que se trata de un programa a baja escala he creado la clase tienda 
con una única tienda y un identificador global que se aplicaría a más tiendas en
el caso de que quisieramos crear más tiendas.}*/

public class Tienda {
    public static int id=0; //Id Global en caso de crear método para más tiendas
    private int idTienda; //Id de la tienda
    private String direccion;
    private String CIF;
    private String telefono;
    
    /*Nuestra tienda tendrá dos listas (además de acceso a la base de datos)
    que nos darán acceso rápido a los empleados y productos que podemos pedir a 
    nuestros proveedores.
    */
    
    static ArrayList<Producto> lista_productos = new ArrayList<Producto>();
    private ArrayList<Empleado> lista_empleados;

    public ArrayList<Empleado> getLista_empleados() {
        return lista_empleados;
    }

    public void setLista_empleados(ArrayList<Empleado> lista_empleados) {
        this.lista_empleados = lista_empleados;
    }
    
    public static ArrayList<Producto> getLista_productos() {
        return lista_productos;
    }

    public static void setLista_productos(ArrayList<Producto> lista_productos) {
        Tienda.lista_productos = lista_productos;
    }
    
    public Tienda() {
        this.lista_empleados = new ArrayList<Empleado>();
        idTienda= Tienda.id++;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }
    

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Tienda.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Tienda(String direccion, String CIF, String telefono, 
            ArrayList<Empleado> lista_empleados ) {
        this.direccion = direccion;
        this.CIF = CIF;
        this.telefono = telefono;
        this.lista_empleados = lista_empleados;
    }

    
    
    public static void gestionEmpleados(Tienda tiendaMAC) {
        Scanner sc=new Scanner(System.in);
       /*Este menú nos permite agregar y quitar empleados de nuestro Arraylist.
         Dependiendo del tipo de empleado que queramos añadir nos dirigirá a un 
         menú u otro*/
        int opcion;
        int id;
        String tipo;
        System.out.println(" ==== Bienvenido al gestor de empleados     ====");
        System.out.println("|                                               |");
        System.out.println("| Opción 1: Añadir nuevo empleado               |");
        System.out.println("| Opción 2: Eliminar empleado                   |");
        System.out.println(" ===============================================");
        opcion= sc.nextInt();
        
        if (opcion == 1) {
            System.out.println("| Introduce clase de trabajador: fijo/temporal  "
                    + "|");
            
            tipo=sc.next();
            
            if (tipo.equals("fijo")){
                Fijo nuevoEmpleado= new Fijo();
                nuevoEmpleado.altaEmpleado(tiendaMAC);
                tiendaMAC.lista_empleados.add(nuevoEmpleado);
            }
            else if (tipo.equals("temporal")){
                Temporal nuevoEmpleado= new Temporal();
                nuevoEmpleado.altaEmpleado(tiendaMAC);
                tiendaMAC.lista_empleados.add(nuevoEmpleado);
            }
            
            else {System.out.println("Tipo no válido"); }
        }
        else if (opcion == 2) {
            System.out.println("| Introduce el id del trabajador a eliminar |");
            id=sc.nextInt();
            for (int i = 0; i < tiendaMAC.lista_empleados.size(); i++) {
                if (tiendaMAC.lista_empleados.get(i).getIdEmpleado() == id) {
                    tiendaMAC.lista_empleados.remove(i);
                    break;
                }
                else {System.out.println("Id no existente en la lista");}
            }
        }
        else {System.out.println("Introduce una opción válida");}
  }
    
    public void mostrarInfoTienda(Tienda tiendaMAC){
        int contador=0;
        System.out.println("== Visualizador de tiendas MAC Cosmetics "
                + "==");
        System.out.println(" ------------------------------------------------");
        System.out.println("| Identificador: "+tiendaMAC.getIdTienda());
        System.out.println("| Dirección: "+tiendaMAC.getDireccion());
        System.out.println("| Teléfono: "+tiendaMAC.getTelefono());
        System.out.println("| CIF: "+tiendaMAC.getCIF());
        for (int i=0; i<lista_empleados.size(); i++){
            contador=contador+1;
        }
        System.out.println("| Número de empleados: "+contador);
        System.out.println(" ------------------------------------------------");
        
    }
        
}
            
       
        
            
                        
                        
        
        
    


    

            
            

