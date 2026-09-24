package uniquindio.edu.co;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Compra {
    //atributos y bueno relaciones tambien
    private String codigo;
    private LocalDateTime fechaHora;
    private Cliente cliente;
    //listas, bueno solo es una
    private List<DetalleCompra> listDetalleCompras;

    public Compra(String codigo, LocalDateTime fechaHora, Cliente cliente, List<DetalleCompra> listDetalleCompras) {
        this.codigo = codigo;
        this.fechaHora = fechaHora;
        this.cliente = cliente;
        this.listDetalleCompras = listDetalleCompras;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalleCompra> getListDetalleCompras() {
        return listDetalleCompras;
    }

    public void setListDetalleCompras(List<DetalleCompra> listDetalleCompras) {
        this.listDetalleCompras = listDetalleCompras;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "codigo='" + codigo + '\'' +
                ", fechaHora=" + fechaHora +
                ", cliente=" + cliente +
                ", listDetalleCompras=" + listDetalleCompras +
                '}';
    }
}
