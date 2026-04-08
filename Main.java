public class Main {
    public static void main(String[] args) {
        InventarioController controller = new InventarioController();

         System.out.println("Marcolina");

        controller.agregarProducto(10, "Arroz", 25.0, 50);
        controller.agregarProducto(5, "Frijoles", 30.0, 40);
        controller.agregarProducto(15, "Aceite", 120.0, 20);
        controller.agregarProducto(3, "Azúcar", 40.0, 35);

        controller.mostrarInventario();
        controller.buscarProducto(5);
        controller.eliminarProducto(10);
        controller.mostrarInventario();
        controller.mostrarValorTotal();
        controller.mostrarStockBajo(30);
    }
}

