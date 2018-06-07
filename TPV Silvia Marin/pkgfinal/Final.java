
package pkgfinal;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import com.apple.eawt.Application;
import com.sun.org.glassfish.gmbal.Impact;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Final {

    
    public static void main(String[] args) {
        
        //Declaramos una nueva tienda llamada MAC
        
        Tienda tiendaMAC= new Tienda();
        tiendaMAC.setDireccion("C/San Miguel nº3 Palma");
        tiendaMAC.setCIF("B29805314");
        tiendaMAC.setTelefono("971-431080");
        tiendaMAC.setIdTienda(01);
        
        /*Declaramos un nuevo empleado que insertaremos en el Array para que 
        podamos visualizar el método verEmpleados sin añadir uno nuevo*/
        
        Fijo Empleado1=new Fijo("Silvia", "Marin",
                "43205118D", 1500, 30, "600450406", 2018, "fijo");
        
        tiendaMAC.getLista_empleados().add(Empleado1);
        
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        int opcion; 
        
        System.out.println(" ===== Gestor de tienda =====");
        System.out.println("|                            |");
        System.out.println("|  1. Información tienda     |");
        System.out.println("|  2. Gestionar empleados    |");
        System.out.println("|  3. Ver empleados          |");
        System.out.println("|  4. Buscar empleado        |");
        System.out.println("|  5. Ver Stock en tienda    |");
        System.out.println("|  6. Realizar Pedido        |");
        System.out.println("|  7. Actualizar Stock       |");
        System.out.println("|  8. Salir                  |");
        System.out.println(" ============================");
        
        while (!salir){
            System.out.println("\nSelecciona opción: ");
            opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        tiendaMAC.mostrarInfoTienda(tiendaMAC);
                        break;
                    case 2:
                        Tienda.gestionEmpleados(tiendaMAC);   
                        break;
                    case 3:
                        Empleado.verEmpleados(tiendaMAC);  
                        break;
                    case 4: //En este caso buscaremos el empleado por el DNI
                        System.out.println("Introduce N.I.F: ");
                        String nif;
                        Boolean correcto=false;
                        while (correcto!=true){
                                nif=sc.next();
                                for (Empleado i: tiendaMAC.getLista_empleados()){
                                    if (nif.equals(i.getDNI())){
                                    i.buscadorEmpleados(tiendaMAC);
                                    correcto=false;   
                                    } 
                                    else {
                                        System.out.println("Incorrecto, "
                                             + "introdúcelo de nuevo: "); 
                                        correcto =true;}    
                                }
                        }
                    
                    break;
                    case 5:
                        try {
                            Datos.mostrarTabla();
                        } 
                        catch (SQLException ex) {
                            Logger.getLogger(Final.class.getName()).log(Level.
                                    SEVERE, null, ex);
                        } 
                        
                    break;
                    case 6:
                        try {
                            Datos.hacerPedido(tiendaMAC);
                         } catch (IOException ex) {
                                Logger.getLogger(Final.class.getName()).
                                        log(Level.SEVERE, null, ex);
                        }
                    
                    break;
                    
                    case 7:
                        try {
                            Datos.actualizarStock();
                        } catch (SQLException excep) {
                            excep.getErrorCode();
                        }
                        break;
                        
                    case 8:
                        salir = true;
                    break;
                    default:
                        System.out.println("Solo números entre 1 y ");
                    
                }
        }
    }}








    