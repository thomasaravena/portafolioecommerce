package cl.thomas.mojitosecommerce.entity;

/**
 * Clase de apoyo que representa un elemento individual dentro del carrito de compras.
 * No es una entidad persistente en la base de datos; su propósito es encapsular 
 * la relación entre un {@link Producto} y la cantidad seleccionada durante la sesión del usuario.
 * * @author Thomas Aravena
 * @version 1.0
 */
public class ItemCarrito {

    /** El producto seleccionado por el usuario. */
    private Producto producto;

    /** La cantidad de unidades de este producto en el carrito. */
    private int cantidad;

    /**
     * Constructor por defecto para la creación de instancias vacías.
     */
    public ItemCarrito() {
        super();
    }

    /**
     * Constructor con parámetros para inicializar un ítem del carrito.
     * * @param producto El producto asociado.
     * @param cantidad Cantidad inicial del producto.
     */
    public ItemCarrito(Producto producto, int cantidad) {
        super();
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Calcula el subtotal multiplicando el precio del producto por la cantidad.
     * * @return El costo total de este ítem.
     */
    public double getSubtotal() {
        if (this.producto == null) return 0;
        return this.producto.getPrecio() * this.cantidad;
    }
    
}