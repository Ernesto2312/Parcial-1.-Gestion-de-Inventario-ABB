public class ArbolBinarioBusqueda<T extends Comparable<T>> implements IArbolBinario<T> {

    private NodoBinario<T> raiz;

    public ArbolBinarioBusqueda() {
        this.raiz = null;
    }

    // Metodos de insercion. Coloca cada producto donde le corresponde usando recursividad
    //  si es necesario para llegar a la posicion correcta dentro del arbol
    @Override
    public void insertar(T id, String nombre, double precio, int cantidad) {
        raiz = insertarRec(raiz, new NodoBinario<>(id, nombre, precio, cantidad));
    }

        private NodoBinario<T> insertarRec(NodoBinario<T> actual, NodoBinario<T> nuevo) {
            if (actual == null) return nuevo;

            if (nuevo.getId().compareTo(actual.getId()) < 0) {
                actual.setIzquierdo(insertarRec(actual.getIzquierdo(), nuevo));
            } else if (nuevo.getId().compareTo(actual.getId()) > 0) {
                actual.setDerecho(insertarRec(actual.getDerecho(), nuevo));
            } else {
                System.out.println("No se permiten IDs duplicados: " + nuevo.getId());
            }
            return actual;
        }

    // Buscar por ID
    @Override
    public boolean buscar(T id) {
        return buscarRec(raiz, id);
    }

        private boolean buscarRec(NodoBinario<T> actual, T id) {
            if (actual == null) return false;
            if (actual.getId().equals(id)) return true;

            if (id.compareTo(actual.getId()) < 0)
                return buscarRec(actual.getIzquierdo(), id);
            else
                return buscarRec(actual.getDerecho(), id);
        }

    // Eliminar por ID
    @Override
    public void eliminar(T id) {
        raiz = eliminarRec(raiz, id);
    }

        private NodoBinario<T> eliminarRec(NodoBinario<T> actual, T id) {
            if (actual == null) return null;

            if (id.compareTo(actual.getId()) < 0) {
                actual.setIzquierdo(eliminarRec(actual.getIzquierdo(), id));
            } else if (id.compareTo(actual.getId()) > 0) {
                actual.setDerecho(eliminarRec(actual.getDerecho(), id));
            } else {
                // Caso encontrado
                if (actual.getIzquierdo() == null) return actual.getDerecho();
                if (actual.getDerecho() == null) return actual.getIzquierdo();

                NodoBinario<T> sucesor = encontrarMinimo(actual.getDerecho());
                actual.setId(sucesor.getId());
                actual.setNombre(sucesor.getNombre());
                actual.setPrecio(sucesor.getPrecio());
                actual.setCantidad(sucesor.getCantidad());
                actual.setDerecho(eliminarRec(actual.getDerecho(), sucesor.getId()));
            }
            return actual;
        }

    public NodoBinario<T> getRaiz() {
        return raiz;
    }


    private NodoBinario<T> encontrarMinimo(NodoBinario<T> nodo) {
        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
        }
        return nodo;
    }

    // Recorridos
    @Override
    public void preOrden() {
        preOrdenRec(raiz);
    }

    private void preOrdenRec(NodoBinario<T> nodo) {
        if (nodo == null) return;
        mostrarNodo(nodo);
        preOrdenRec(nodo.getIzquierdo());
        preOrdenRec(nodo.getDerecho());
    }

    @Override
    public void inOrden() {
        inOrdenRec(raiz);
    }

    private void inOrdenRec(NodoBinario<T> nodo) {
        if (nodo == null) return;
        inOrdenRec(nodo.getIzquierdo());
        mostrarNodo(nodo);
        inOrdenRec(nodo.getDerecho());
    }

    @Override
    public void postOrden() {
        postOrdenRec(raiz);
    }

    private void postOrdenRec(NodoBinario<T> nodo) {
        if (nodo == null) return;
        postOrdenRec(nodo.getIzquierdo());
        postOrdenRec(nodo.getDerecho());
        mostrarNodo(nodo);
    }

    // Auxiliar para imprimir nodo
    private void mostrarNodo(NodoBinario<T> nodo) {
        System.out.println("ID: " + nodo.getId() +
                ", Nombre: " + nodo.getNombre() +
                ", Precio: " + nodo.getPrecio() +
                ", Cantidad: " + nodo.getCantidad());
    }
}
