
package pkgfinal;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author sylviamarin
 */
public class Empleado {
    public static int id=1;
    private int idEmpleado; //id de empleado autoincremental
    private String nombre;
    private String apellido;
    private String DNI;
    private double salario; //bruto en euros 
    private double horas; //totales a la semana
    private String telefono; //formato xxxxxxxxx
    private int añoIncorporacion;
    private String tipoEmpleado;
    
    /**
     * 
     * @param nombre
     * @param apellido
     * @param DNI
     * @param salario
     * @param horas
     * @param telefono
     * @param añoIncorporacion
     * @param tipoEmpleado 
     */
    public Empleado( String nombre, String apellido, String DNI, double 
            salario, double horas, String telefono, int añoIncorporacion, 
            String tipoEmpleado) {
        
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.salario = salario;
        this.horas = horas;
        this.telefono = telefono;
        this.añoIncorporacion = añoIncorporacion;
        this.tipoEmpleado = tipoEmpleado;
    }
    
    public Empleado() {
       idEmpleado = Empleado.id++;
    }
    /**
     * 
     * @return 
     */
    public int getIdEmpleado() {
        return idEmpleado;
    }
    /**
     * 
     * @param idEmpleado 
     */
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
   
    /**
     * 
     * @return 
     */
    public String getTipoEmpleado() {
        return tipoEmpleado;
    }
    /**
     * 
     * @param tipoEmpleado 
     */
    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    } 
    /**
     * 
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * 
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * 
     * @return 
     */
    public String getApellido() {
        return apellido;
    }
    /**
     * 
     * @param apellido 
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    /**
     * 
     * @return 
     */
    public String getDNI() {
        return DNI;
    }
    /**
     * 
     * @param DNI 
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    /**
     * 
     * @return 
     */
    public double getSalario() {
        return salario;
    }
    /**
     * 
     * @param salario 
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }
    /**
     * 
     * @return 
     */
    public double getHoras() {
        return horas;
    }
    /**
     * 
     * @param horas 
     */
    public void setHoras(double horas) {
        this.horas = horas;
    }
    /**
     * 
     * @return 
     */
    public String getTelefono() {
        return telefono;
    }
    /**
    * 
    * @param telefono 
    */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    /**
     * 
     * @return 
     */
    public int getAñoIncorporacion() {
        return añoIncorporacion;
    }
    /**
     * 
     * @param añoIncorporacion 
     */
    public void setAñoIncorporacion(int añoIncorporacion) {
        this.añoIncorporacion = añoIncorporacion;
    }
 
    /**Método para dar de alta al empleado
     * 
     * @param tiendaMAC 
     */
    public void altaEmpleado(Tienda tiendaMAC) {  
        
        Scanner sc= new Scanner(System.in);
        
        System.out.println(" ==== Sistema de nuevo empleado ================");
        System.out.println("|                                               |");
        System.out.println("| Introduce el DNI del trabajador               |");
        this.setIdEmpleado(idEmpleado);
        this.setDNI(sc.nextLine());
        System.out.println("| Introduce su nombre                           |");
        this.setNombre(sc.nextLine());
        System.out.println("| Introduce el primer apellido                  |");
        this.setApellido(sc.nextLine());
        System.out.println("| Introduce el teléfono                         |");
        this.setTelefono(sc.nextLine());
        System.out.println("| Introduce su salario base                     |");
        this.setSalario(sc.nextDouble());
        System.out.println("| Introduce cantidad de horas semanales         |");
        this.setHoras(sc.nextDouble());
        System.out.println("| Introduce año de incorporación en la compañía |");
        this.setAñoIncorporacion(sc.nextInt());
        
} 
    /** Nos muestra una lista completa de empleados
     * 
     * @param tiendaMAC 
     */
    public static void verEmpleados(Tienda tiendaMAC){
        System.out.println("==== Listado de empleados de la tienda ====");
        for (int i = 0; i < tiendaMAC.getLista_empleados().size(); i++) {
            System.out.println(" --------------------------------------------");
            System.out.println("| ID: "+tiendaMAC.getLista_empleados().get(i)
                    .getIdEmpleado());
            System.out.println("| DNI: "+tiendaMAC.getLista_empleados().
                    get(i).getDNI());
            System.out.println("| Nombre: "+tiendaMAC.getLista_empleados().
                    get(i).getNombre()+" "+tiendaMAC.getLista_empleados()
                    .get(i).getApellido());
            
            System.out.println("| Teléfono: "+tiendaMAC.getLista_empleados().
                    get(i).getTelefono());
            
            System.out.println(" --------------------------------------------");
    }
    }   
    /**Nos muestra información adicional del empleado que hayamos introducido
     * 
     * @param tiendaMAC 
     */  
    public void buscadorEmpleados(Tienda tiendaMAC){
        
        System.out.println(" ====  Información adicional empleado  ====");
        System.out.println("| Nombre: "+this.getNombre()+" "+this.getApellido());
        System.out.println("| Salario: "+this.getSalario()+"€");
        System.out.println("| Horas: "+this.getHoras()+ "/semana");
        System.out.println("| Año incorporación: "+this.getAñoIncorporacion());
        System.out.println("| Tipo contrato: "+this.getTipoEmpleado());
}

}
