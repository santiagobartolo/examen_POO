package uniquindio.edu.co;

public class DetalleCompra {
    private int cantidadSolicitada;
    private Producto producto;

    public DetalleCompra(int cantidadSolicitada, Producto producto) {
        this.cantidadSolicitada = cantidadSolicitada;
        this.producto = producto;
    }

    public int getCantidadSolicitada() {
        return cantidadSolicitada;
    }

    public void setCantidadSolicitada(int cantidadSolicitada) {
        this.cantidadSolicitada = cantidadSolicitada;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "DetalleCompra{" +
                "cantidadSolicitada=" + cantidadSolicitada +
                ", producto=" + producto +
                '}';
    }
}
