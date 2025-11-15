import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private List<Producto> listado;
    private List<Venta> ventas;
    public Tienda(){
        listado=new ArrayList<>();
        ventas = new ArrayList<>();
    }

    public void iniciar(){
        listado.add(new Producto(1, "Levadura", 1.3f));
        listado.add(new Producto(2, "Harina", 0.50f));
        listado.add(new Producto(3, "Mantequilla", 1.29f));
    }
    public void agregarVenta (Venta venta){
        ventas.add(venta);
    }


    public  boolean buscarEditar(int id, float  precio){
        int i=0;
        int s=listado.size();
        int c;

        while(i<=s){
            c=(i+s)/2;
            if (id==listado.get(c).getId()){
                listado.get(c).setPrecio(precio);
                return true;
            } else if (id<listado.get(c).getId()) {
                s=c-1;

            }else{
                i=c+1;
            }
        }
        return false;
    }

    public List<Producto> obtenerProductos(){
        return listado;
    }
    public List<Venta> obtenerVentas(){
        return ventas;
    }

}
