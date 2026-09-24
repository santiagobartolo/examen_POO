package uniquindio.edu.co;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Compra {

    private String codigoCompra;
    private LocalDateTime fechaHora;
    private MetodoPago metodoPago;
    private double valorTotal;
    private Cliente cliente;
    //lista
    private List<DetalleCompra> listaDetalles;

    public Compra(String codigoCompra, MetodoPago metodoPago, Cliente cliente) {
        this.codigoCompra = codigoCompra;
        this.metodoPago = metodoPago;
        this.valorTotal = valorTotal;
        this.cliente = cliente;

        this.fechaHora = LocalDateTime.now();
        this.valorTotal = valorTotal;
        this.listaDetalles = new ArrayList<>();
    }


    public String getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(String codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalleCompra> getListaDetalles() {
        return listaDetalles;
    }

    public void setListaDetalles(List<DetalleCompra> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }

    public boolean agregarDetalle(DetalleCompra detalle) {
        boolean exito = false;
        Producto producto = detalle.getProducto();
        int cantidad = detalle.getCantidadSolicitada();

        // esto verifica que el producto tenga stock suficiente
        if (producto.tieneStockSuficiente(cantidad)) {
            //despues de verificar obviamente hay que descontar la cantidad del stock actual
            int nuevoStock = producto.getCantidadDisponible() - cantidad;
            producto.setCantidadDisponible(nuevoStock);

            this.listaDetalles.add(detalle);
            this.valorTotal = calcularValorTotal();

            exito = true; // Proceso exitoso
        } else {
            System.out.println("El stock es insuficiente en este momento para el producto: " + producto.getNombre());
        }

        return exito;
    }

    public double calcularValorTotal() {
        double acumuladorTotal = 0.0; //solo es para iniciar la acumulacion del precio total

        //esto recorre la lista de compras teniendo encuenta lo que si tiene stock
        for (DetalleCompra detalle : this.listaDetalles) {
            acumuladorTotal += detalle.getSubtotal();
        }

        // esto solo actualiza el valor total por el acumulado que esta al inicio
        this.valorTotal = acumuladorTotal;

        return this.valorTotal;//y ya solo retorna
    }

    @Override
    public String toString() {
        return "Compra{" +
                "codigoCompra='" + codigoCompra + '\'' +
                ", fechaHora=" + fechaHora +
                ", metodoPago=" + metodoPago +
                ", valorTotal=" + valorTotal +
                ", cliente=" + cliente +
                ", listaDetalles=" + listaDetalles +
                '}';
    }
}
