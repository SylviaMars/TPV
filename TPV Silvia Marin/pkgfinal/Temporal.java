
package pkgfinal;

import java.util.Scanner;

/**
 * 
 * @author sylviamarin
 */
public class Temporal extends Empleado{
    private String turno; //Mañana/Tarde/Partido
    private String fechaFinContrato; // fecha formato dd/mm/aaaa (parse int)

    public Temporal(){
        
    }
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
    public Temporal(String nombre, String apellido, String DNI, double salario,
            double horas, String telefono, int añoIncorporacion, 
            String tipoEmpleado) { super(nombre, apellido, DNI, salario, 
                    horas, telefono, añoIncorporacion, tipoEmpleado);
    }
    /**
     * 
     * @param turno
     * @param fechaFinContrato 
     */
    public Temporal(String turno, String fechaFinContrato) {
        this.turno = turno;
        this.fechaFinContrato = fechaFinContrato;
    }
    /**
     * 
     * @return 
     */
    public String getTurno() {
        return turno;
    }
    /**
     * 
     * @param turno 
     */
    public void setTurno(String turno) {
        this.turno = turno;
    }
    /**
     * 
     * @return 
     */
    public String getFechaFinContrato() {
        return fechaFinContrato;
    }
    /**
     * 
     * @param fechaFinContrato 
     */
    public void setFechaFinContrato(String fechaFinContrato) {
        this.fechaFinContrato = fechaFinContrato;
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
        System.out.println("| Introduce tipo de jornada                     |");
        this.setTurno(sc.nextLine());
        System.out.println("| Introduce fecha de fin de contrato            |");
        this.setFechaFinContrato(sc.nextLine());
        System.out.println(" ===============================================");
        
}
    /**
     * 
     * @param tiendaMAC 
     */
    @Override
    public void buscadorEmpleados(Tienda tiendaMAC){
        super.buscadorEmpleados(tiendaMAC);
        System.out.println("| Tipo de jornada (mañanas/tardes): "+
                this.getTurno());
        System.out.println("| Fin de contrato: "+this.getFechaFinContrato());

        
    }
}
