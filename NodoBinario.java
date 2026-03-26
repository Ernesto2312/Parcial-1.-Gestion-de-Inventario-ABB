public class NodoBinario<T extends Comparable<T>> {
    T id;                  //primary key
    String nombre;
    double precio;
    int cantidad;
    NodoBinario<T> izquierdo;
    NodoBinario<T> derecho;

    public NodoBinario(T id, String nombre, double precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.izquierdo = null;
        this.derecho = null;
    }

    public NodoBinario(T id) {
        this(id, "", 0.0, 0);
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public NodoBinario<T> getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoBinario<T> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoBinario<T> getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoBinario<T> derecho) {
        this.derecho = derecho;
    }

    @Override
    public String toString() {
        return "NodoBinario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", izquierdo=" + izquierdo +
                ", derecho=" + derecho +
                '}';
    }
}

