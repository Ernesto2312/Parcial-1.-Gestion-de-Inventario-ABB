public interface IArbolBinario<T extends Comparable<T>> {

    // Inserción de un nodo con todos los atributos
    void insertar(T id, String nombre, double precio, int cantidad);

    // Eliminación por clave primaria (id)
    void eliminar(T id);

    // Búsqueda por clave primaria (id)
    boolean buscar(T id);

    // Recorridos básicos
    void preOrden();
    void inOrden();
    void postOrden();

}
