public class InventarioController {
    private ArbolBinarioBusqueda<Integer> inventario;

    public InventarioController() {
        inventario = new ArbolBinarioBusqueda<>();
    }

    // --- Operaciones básicas sobre el inventario ---

    public void agregarProducto(int id, String nombre, double precio, int cantidad) {
        inventario.insertar(id, nombre, precio, cantidad);
        System.out.println("Producto agregado: " + nombre);
    }

    public void buscarProducto(int id) {
        boolean encontrado = inventario.buscar(id);
        System.out.println(encontrado
                ? "Producto con ID " + id + " encontrado."
                : "Producto con ID " + id + " no existe.");
    }

    public void eliminarProducto(int id) {
        inventario.eliminar(id);
        System.out.println("Producto con ID " + id + " eliminado.");
    }

    public void mostrarInventario() {
        System.out.println("\nInventario en orden:");
        inventario.inOrden();
    }

    // metodos auxiliarles de inventario

    public void mostrarValorTotal() {
        double total = calcularValorTotal();
        System.out.println("\nValor total del inventario: $" + total);
    }

    private double calcularValorTotal() {
        return calcularValorTotalRec(inventario.getRaiz());
    }

    private double calcularValorTotalRec(NodoBinario<Integer> nodo) {
        if (nodo == null) return 0;
        double valorNodo = nodo.getPrecio() * nodo.getCantidad();
        return valorNodo
                + calcularValorTotalRec(nodo.getIzquierdo())
                + calcularValorTotalRec(nodo.getDerecho());
    }

    public void mostrarStockBajo(int limite) {
        System.out.println("\nProductos con stock menor a " + limite + ":");
        mostrarStockBajoRec(inventario.getRaiz(), limite);
    }

    private void mostrarStockBajoRec(NodoBinario<Integer> nodo, int limite) {
        if (nodo == null) return;
        mostrarStockBajoRec(nodo.getIzquierdo(), limite);
        if (nodo.getCantidad() < limite) {
            System.out.println("ID: " + nodo.getId() +
                    ", Nombre: " + nodo.getNombre() +
                    ", Precio: " + nodo.getPrecio() +
                    ", Cantidad: " + nodo.getCantidad());
        }
        mostrarStockBajoRec(nodo.getDerecho(), limite);
    }
}
