/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factura;

/**
 *
 * @author Feli2
 */
public class Linea {
    int cantidad;
    String descripcion;
    float precio;
    
    public Linea(){
        this.cantidad = 0;
        this.descripcion = "";
        this.precio = 0.0f;
    }

    public Linea(int cantidad, String descripcion, float precio) {
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    
    // Métodos Getter
    public int getCantidad() {
        return cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    // Calcular el subtotal de esta línea (cantidad * precio unitario)
    public float getSubtotal() {
        return cantidad * precio;
    }

    // Métodos Setter
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    // Método toString para representar la línea en texto
    @Override
    public String toString() {
        // Formato: Cantidad;Producto;Precio ud.;Precio total
        return String.format("%d;%s;%.2f;%.2f", cantidad, descripcion, precio, getSubtotal());
    }
}

    

