/*
 * Clase Productos: Representa un articulo dentro del inventario de una tienda.
 * Su proposito es gestionar la informacion basica del producto y sus movimientos de inventario.
 */
public class Productos {

    // Atributos: Definimos los datos que describen a cada producto.
    // Se usa 'private' para encapsular la informacion.
    private String nombreproducto;
    private double precio;
    private int cantidad;

    /*
     * Constructor: Se ejecuta al crear un nuevo objeto 'Productos'.
     * Sirve para asignar los valores iniciales a los atributos del objeto.
     */
    public Productos(String nombreproducto, double precio, int cantidad) {
        this.nombreproducto = nombreproducto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // --- Métodos: Definen las acciones que puede realizar el objeto ---

    /*
     * Metodo para mostrar los detalles del producto en la consola.
     */
    public void mostrarInformacion() {
        // Se añadieron espacios y separadores para mejorar la legibilidad en consola
        System.out.println("Nombre: " + nombreproducto + " | Precio: $" + precio + " | Stock: " + cantidad);
    }

    /*
     * Metodo para simular una venta.
     * Incluye una validacion logica para no vender si no hay stock suficiente.
     */
    public void vender(int cantidadVendida) {
        if (cantidadVendida <= this.cantidad) {
            this.cantidad -= cantidadVendida;
            System.out.println("Venta exitosa: " + cantidadVendida + "x " + nombreproducto);
        } else {
            System.out.println("Error: Stock insuficiente para vender " + cantidadVendida + " de " + nombreproducto);
        }
    }

    /*
     * Metodo para reabastecer el inventario sumando al stock actual.
     */
    public void agregarStock(int cantidadAgregada) {
        this.cantidad += cantidadAgregada;
        System.out.println("Se agregaron " + cantidadAgregada + " unidades de " + nombreproducto + " al stock.");
    }

    /*
     * Metodo principal (Main): Punto de entrada de la aplicacion.
     * Aqui instanciamos los objetos y probamos los metodos.
     */
    public static void main(String[] args) {
        System.out.println("--- INICIALIZANDO SISTEMA DE PRODUCTOS ---");

        // 1. Instanciacion de objetos a partir de la clase Productos
        Productos producto1 = new Productos("Laptop", 12500.50, 10);
        Productos producto2 = new Productos("Mouse", 350.00, 5);

        // 2. Mostrar datos iniciales
        System.out.println("\n[Inventario Inicial]");
        producto1.mostrarInformacion();
        producto2.mostrarInformacion();

        // 3. Prueba de métodos y logica de negocio
        System.out.println("\n[Simulación de Movimientos]");
        producto1.vender(3); // Venta exitosa (hay 10)
        producto2.vender(10); // Error: no hay suficiente stock (solo hay 5)
        producto2.agregarStock(15); // Reabastecemos
        producto2.vender(10); // Venta exitosa (ahora hay 20)

        // 4. Mostrar estado final
        System.out.println("\n[Inventario Final]");
        producto1.mostrarInformacion();
        producto2.mostrarInformacion();
    }
}