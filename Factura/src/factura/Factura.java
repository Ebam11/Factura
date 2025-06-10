/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factura;
import java.util.ArrayList;
import java.util.Date; // Para la fecha
import java.text.SimpleDateFormat; // Para formatear la fecha
import java.util.List; // Para la lista de líneas

/**
 *
 * @author Feli2
 */
public class Factura {
    static int sigId = 1;
    final float IVA_CONSTANT = 0.18f;
    
    int id;
    Date fecha;
    Cliente cliente;
    List<Linea> lineas;

    public Factura(Cliente cliente, Date fecha) {
        this.id = getSigId();
        this.cliente = cliente;
        this.fecha = fecha;
        this.lineas = new ArrayList<>();
    }
    public static int getSigId(){
        return sigId++;
    }
    public void addLinea(int cantidad, String descripcion, float precio){
        Linea nuevaLinea = new Linea(cantidad, descripcion, precio);
        this.lineas.add(nuevaLinea);
    }

    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Linea> getLineas() {
        return lineas;
    }
    public float getSubtotalFactura(){
        float subtotal = 0.0f;
        for (Linea linea : lineas) {
            subtotal += linea.getSubtotal();           
        }
        return subtotal;       
    }
    public float getIVA(){
        return getSubtotalFactura() * IVA_CONSTANT;
    }
    public float getTotalFactura(){
        return getSubtotalFactura() + getIVA();
    }
    public void imprimirFactura(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        
        System.out.println("Factura nº: " + this.getId());
        System.out.println("Fecha: " + sdf.format(this.getFecha()));
        System.out.println("\n-----------");
        System.out.println("Datos del cliente");
        System.out.println("-----------");
        System.out.println("Nombre: " + this.getCliente().getNombre());
        System.out.println("Direccion: " + this.getCliente().getDireccion());
        System.out.println("Telefono: " + this.getCliente().getTelefono());

        System.out.println("\n-----------");
        System.out.println("Detalle de la factura");
        System.out.println("-----------");
        System.out.println("Linea;Producto;Cantidad;Precio ud.;Precio total");
        System.out.println("---");

        int lineNumber = 1;
        for (Linea linea : lineas) {
            System.out.println(String.format("%d;%s;%d;%.2f;%.2f",
                               lineNumber++, linea.getDescripcion(), linea.getCantidad(), linea.getPrecio(), linea.getSubtotal()));
        }

        System.out.println("\nSubtotal: " + String.format("%.2f", getSubtotalFactura()) + " €");
        System.out.println("IVA (" + String.format("%.0f", IVA_CONSTANT * 100) + "%): " + String.format("%.2f", getIVA()) + " €");
        System.out.println("TOTAL: " + String.format("%.4f", getTotalFactura()) + " €");
    }
}
    

