
package Beans;

/**
 *
 * @author BMO
 */
public class Producto {
    private int idProducto;
    private String nombre;
    private double valorProducto; 

    public Producto(int idProducto, String nombre, double valorProducto) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.valorProducto = valorProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValorProducto() {
        return valorProducto;
    }

    public void setValorProducto(double valorProducto) {
        this.valorProducto = valorProducto;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", valorProducto=" + valorProducto + '}';
    }
    
    
}
