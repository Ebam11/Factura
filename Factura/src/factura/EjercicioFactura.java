/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package factura;

import java.util.Date;

/**
 *
 * @author Feli2
 */
public class EjercicioFactura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Agapito Piedralisa", "c/ Rio Seco, 2", "123456789");

        // 2. Crear una nueva Factura
        // Usamos new Date() para obtener la fecha actual.
        // Si necesitas una fecha específica como 18/4/2011, tendrías que parsear una cadena:
        // SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        // Date fechaEspecifica = sdf.parse("18/04/2011"); // Manejar ParseException
        Factura factura = new Factura(cliente, new Date()); // Fecha actual del sistema

        // 3. Añadir productos (Líneas) a la factura
        // Los valores son: cantidad, descripción, precio unitario
        factura.addLinea(1, "Raton USB", 8.43f); // El precio total de la línea es 8.43
        factura.addLinea(2, "Memoria RAM 2GB", 15.42f); // El precio total de la línea es 30.84
        factura.addLinea(1, "Altavoces", 12.66f); // El precio total de la línea es 12.66

        // 4. Imprimir la factura
        factura.imprimirFactura();

        // Puedes crear otra factura para ver cómo sigId se incrementa
        // Factura factura2 = new Factura(cliente, new Date());
        // System.out.println("\n--- Segunda Factura (solo ID para demostración) ---");
        // System.out.println("Factura nº: " + factura2.getId());
    }
}