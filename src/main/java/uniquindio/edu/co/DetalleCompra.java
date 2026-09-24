package uniquindio.edu.co;

public class DetalleCompra {

    private int cantidadSolicitada;
    private double precioUnitarioHistorico;
    private double subtotal;
    private Producto producto;


    public DetalleCompra(int cantidadSolicitada, Producto producto) {
        this.cantidadSolicitada = cantidadSolicitada;
        this.producto = producto;

        // esto hace que al momento de hacer una compra congele el precio actual
        //esto sirve para ver el precio si despues aumenta y compara entre dieferentes fechas
        this.precioUnitarioHistorico = producto.getPrecioUnitario();

        // esto esta invocando un metodo como respuesta pues subtotal como el nombre dice
        // es un total pero solo un total unitario osea de un solo tipo de producto
        this.subtotal = calcularSubtotal();
    }



    public int getCantidadSolicitada() {
        return cantidadSolicitada;
    }

    public void setCantidadSolicitada(int cantidadSolicitada) {
        this.cantidadSolicitada = cantidadSolicitada;
        this.subtotal = calcularSubtotal();
    }

    public double getPrecioUnitarioHistorico() {
        return precioUnitarioHistorico;
    }

    public void setPrecioUnitarioHistorico(double precioUnitarioHistorico) {
        this.precioUnitarioHistorico = precioUnitarioHistorico;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public double calcularSubtotal() {
        return this.cantidadSolicitada * this.precioUnitarioHistorico;
    }

    @Override
    public String toString() {
        return "DetalleCompra{" +
                "producto=" + producto.getNombre() +
                ", cantidad=" + cantidadSolicitada +
                ", precioUnitarioHistorico=" + precioUnitarioHistorico +
                ", subtotal=" + subtotal +
                '}';
    }
}
