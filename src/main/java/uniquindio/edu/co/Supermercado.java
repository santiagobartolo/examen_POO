package uniquindio.edu.co;

import java.util.List;

public class Supermercado {
    //atributos del supermercado
    private String nombre;
    private String direccion;
    private String telefono;
    //listas
    private List<Producto> listaProductos;
    private List<Compra> listCompras;

    public Supermercado(String nombre, String direccion, String telefono, List<Producto> listaProductos, List<Compra> listCompras) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.listaProductos = listaProductos;
        this.listCompras = listCompras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public List<Compra> getListCompras() {
        return listCompras;
    }

    public void setListCompras(List<Compra> listCompras) {
        this.listCompras = listCompras;
    }

    @Override
    public String toString() {
        return "Supermercado{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", listaProductos=" + listaProductos +
                ", listCompras=" + listCompras +
                '}';
    }

}
