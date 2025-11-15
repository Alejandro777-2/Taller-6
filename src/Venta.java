import java.util.ArrayList;
import java.util.List;

public class Venta {

    private int mes;
    private int cantidad ;
    private Producto producto;
    private float total ;




    public Venta(int mes, int cantidad, Producto producto) {
        this.mes = mes;
        this.cantidad = cantidad;
        this.producto = producto;
        this.total = this.cantidad*producto.getPrecio();
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Venta " +
                " mes " + mes +
                "cantidad " + cantidad +
                "producto " + producto.toString() +
                " total " + total ;
    }
}
