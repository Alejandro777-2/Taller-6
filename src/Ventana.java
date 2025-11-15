import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Ventana {
    private JPanel Principal;
    private JTabbedPane tabbedPane1;
    private JComboBox cmbProducto;
    private JComboBox cmbMes;
    private JSpinner spnCantidad;
    private JButton btnAgregar;
    private JList lstVentasM;
    private JButton mostrarRegistroUltimos3Button;
    private JButton btnEditar;
    private JTextField txtID;
    private JTextField txtNombreA;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel lblTotal;
    private JButton btnBuscar;
    private JTextArea txtBuscar;
    private JTextField txtNuevoP;
    Tienda cordero = new Tienda();

    public Ventana() {
        cordero.iniciar();
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int mes = cmbMes.getSelectedIndex()+1;
                int cantidad = Integer.parseInt(spnCantidad.getValue().toString());

                String nombre =  cmbProducto.getSelectedItem().toString();
                List<Producto> productos = cordero.obtenerProductos();

                for(Producto producto : productos ){
                    if (producto.getNombre().equals(nombre)){
                        Venta venta = new Venta(mes, cantidad, producto);
                        cordero.agregarVenta(venta);
                        lblTotal.setText("Total:  " + venta.getTotal());
                        JOptionPane.showMessageDialog(null, " Se registro la venta");
                    }
                }


            }
        });
        mostrarRegistroUltimos3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                List<Venta>ventas = cordero.obtenerVentas();
                DefaultListModel dml = new DefaultListModel<>();

                for(Venta j : ventas){
                    if( j.getMes()<= 11 && j.getMes()>=9 ){
                        dml.addElement(j.toString());
                    }
                }
                lstVentasM.setModel(dml );
            }
        });
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Producto> productos = cordero.obtenerProductos();
                int id = Integer.parseInt(txtID.getText().toString());
                String nombre = txtNombreA.getText();
                float Nuevoprecio = Float.parseFloat(txtNuevoP.getText().toString());
                for (Producto p : productos){
                    if(id == p.getId() && nombre.equals(p.getNombre())){
                        p.setPrecio(Nuevoprecio);
                        JOptionPane.showMessageDialog(null, " Se actualizó el precio");
                    }
                }

            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Producto> productos = cordero.obtenerProductos();
                int id = Integer.parseInt(txtID.getText().toString());
                String nombre = txtNombreA.getText();

                for (Producto p : productos){
                    if(id == p.getId() && nombre.equals(p.getNombre())){
                        txtBuscar.setText(p.toString());
                        JOptionPane.showMessageDialog(null, " Se encontró el producto");
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
