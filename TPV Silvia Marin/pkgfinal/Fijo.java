
package pkgfinal;

import java.util.Scanner;

/**
 * 
 * @author sylviamarin
 */
public class Fijo extends Empleado {
    private double incentivo; // Euros que se añaden en la nómina
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
    public Fijo(String nombre, String apellido, String DNI, 
            double salario, double horas, String telefono, int añoIncorporacion,
            String tipoEmpleado) { super(nombre, apellido, DNI, salario, 
                    horas, telefono, añoIncorporacion, tipoEmpleado);
    }

    public Fijo() {
    }
    /**
     * 
     * @return 
     */
    public double getIncentivo() {
        return incentivo;
    }
    /**
     * 
     * @param incentivo 
     */
    public void setIncentivo(double incentivo) {
        this.incentivo = incentivo;
    }
    /**
     * 
     * @param incentivo 
     */
    public Fijo(double incentivo) {
        this.incentivo = incentivo;
    }
    
    /**
     * 
     * @param tiendaMAC 
     */
    @Override
    public void altaEmpleado(Tienda tiendaMAC) { 
        super.altaEmpleado(tiendaMAC);
        Scanner sc=new Scanner(System.in);
        this.setTipoEmpleado("Temporal");
        System.out.println("| Introduce incentivo en euros:                 |");
        this.setIncentivo(sc.nextDouble());
        System.out.println(" ===============================================");
        
}
    /**
     * 
     * @param tiendaMAC 
     */
    @Override
    public void buscadorEmpleados(Tienda tiendaMAC){
    
        System.out.println("| Incentivo: "+this.getIncentivo()+"€");
  
    }
}

