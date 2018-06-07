
package pkgfinal;

/**
 * 
 * @author sylviamarin
 */
public class Producto {
    private String Codigo; // no se incrementa
    private String Nombre;
    private double Precio;
    private String tipo;
    private boolean color; //si se trata de un producto de color o no
/**
 * 
 * @param Codigo
 * @param Nombre
 * @param Precio
 * @param tipo
 * @param color 
 */
    public Producto(String Codigo, String Nombre, double Precio, String tipo, 
            boolean color) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.tipo = tipo;
        this.color = color;
    }
/**
 * 
 * @return 
 */
    public String getCodigo() {
        return Codigo;
    }
/**
 * 
 * @param Codigo 
 */
    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }
/**
 * 
 * @return 
 */
    public String getNombre() {
        return Nombre;
    }
/**
 * 
 * @param Nombre 
 */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
/**
 * 
 * @return 
 */
    public double getPrecio() {
        return Precio;
    }
/**
 * 
 * @param Precio 
 */
    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }
/**
 * 
 * @return 
 */
    public String getTipo() {
        return tipo;
    }
/**
 * 
 * @param tipo 
 */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
/**
 * 
 * @return 
 */
    public boolean isColor() {
        return color;
    }
/**
 * 
 * @param color 
 */
    public void setColor(boolean color) {
        this.color = color;
    }  
    public Producto(){
        
    }
}
