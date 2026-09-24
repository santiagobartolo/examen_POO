package uniquindio.edu.co;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Supermercado {
    private String nombreComercial;
    private String direccion;
    private String telefono;
    //listas
    private List<Producto> listaProductos;
    private List<Compra> listaCompras;
    private List<Cliente> listaClientes;

    public Supermercado(String nombreComercial, String direccion, String telefono) {
        this.nombreComercial = nombreComercial;
        this.direccion = direccion;
        this.telefono = telefono;

        this.listaProductos = new ArrayList<>();
        this.listaCompras = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
    }


    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
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

    public List<Compra> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(List<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    // Verificar si existe un cliente por documento
    public boolean existeCliente(String documento) {
        for (Cliente c : this.getListaClientes()) {
            if (c.getDocumentoIdentidad().equalsIgnoreCase(documento)) {
                return true;
            }
        }
        return false;
    }

    //el crud del cliente

    // Buscar cliente por documento
    public Cliente buscarClientePorDocumento(String documento) {
        for (Cliente c : this.getListaClientes()) {
            if (c.getDocumentoIdentidad().equalsIgnoreCase(documento)) {
                return c;
            }
        }
        return null;
    }

    // Añadir client esto solo si el cliente no existe ojito con eso
    public boolean registrarCliente(Cliente cliente) {
        if (!existeCliente(cliente.getDocumentoIdentidad())) {
            this.getListaClientes().add(cliente);
            return true; // Se registró con éxito
        }
        return false; // Ya existía
    }

    // Eliminar cliente existente
    public boolean eliminarCliente(String documento) {
        Cliente cliente = buscarClientePorDocumento(documento);
        if (cliente != null) {
            this.getListaClientes().remove(cliente);
            return true; // Eliminado exitosamente
        }
        return false; // No se encontró para eliminar
    }

    // Actualizar cliente existente
    public boolean actualizarCliente(String documento, String nuevoNombre, String nuevoTelefono, String nuevoCorreo) {
        Cliente cliente = buscarClientePorDocumento(documento);
        if (cliente != null) {
            cliente.setNombreCompleto(nuevoNombre);
            cliente.setTelefono(nuevoTelefono);
            cliente.setCorreoElectronico(nuevoCorreo);
            return true; // Actualización exitosa
        }
        return false; // No existe
    }

    //el crud de producto

    // Agrega un producto si su código no existe
    public boolean registrarProducto(Producto producto) {
        if (buscarProductoPorCodigo(producto.getCodigoProducto()) == null) {
            this.getListaProductos().add(producto);
            return true; // Registrado exitosamente
        }
        return false; // El producto ya existía
    }

    // esto es el corazon del producto, literalmente JAJAJAJAJAJA
    public Producto buscarProductoPorCodigo(String codigoProducto) {
        for (Producto p : this.getListaProductos()) {
            if (p.getCodigoProducto().equalsIgnoreCase(codigoProducto)) {
                return p;
            }
        }
        return null; // No encontrado
    }

    // Verifica si el producto si tiene el stock necesario
    public boolean verificarStockProducto(String codigoProducto, int cantidadSolicitada) {
        Producto p = buscarProductoPorCodigo(codigoProducto);
        if (p != null) {
            return p.tieneStockSuficiente(cantidadSolicitada); // esto reutiliza un pequeño metodo que esta en producto que verifica el stock
        }
        return false;
    }

    // actualiza los datos basicos de un producto osea nombre y precio pero el codigo de este mismo qued intacto
    public boolean actualizarProducto(String codigoProducto, String nuevoNombre, double nuevoPrecio) {
        Producto p = buscarProductoPorCodigo(codigoProducto);
        if (p != null) {
            p.setNombre(nuevoNombre);
            p.setPrecioUnitario(nuevoPrecio);
            return true; // Actualizado con éxito
        }
        return false; // No se encontró
    }

    // reabastece el stok
    public boolean sumarStockProducto(String codigoProducto, int cantidadASumar) {
        Producto p = buscarProductoPorCodigo(codigoProducto);
        if (p != null && cantidadASumar > 0) {
            int stockActual = p.getCantidadDisponible();
            p.setCantidadDisponible(stockActual + cantidadASumar); // Suma las nuevas unidades
            return true;
        }
        return false;
    }

    // eliminar producto, yap solo hace eso que mas esperabas, que volara?
    public boolean eliminarProducto(String codigoProducto) {
        Producto p = buscarProductoPorCodigo(codigoProducto);
        if (p != null) {
            this.getListaProductos().remove(p);
            return true; // Eliminado exitosamente
        }
        return false; // No existía
    }

    // esto registra y prosesa la compra realizada
    public boolean registrarCompra(Compra compra) {
        if (compra != null && !compra.getListaDetalles().isEmpty()) {
            this.getListaCompras().add(compra);
            return true; // Compra registrada con éxito
        }
        return false; // Compra inválida o vacía
    }

    // esto da el historial de compras del cliente
    public List<Compra> obtenerComprasPorCliente(String documentoIdentidad) {
        List<Compra> historialCliente = new ArrayList<>();

        for (Compra c : this.getListaCompras()) {
            // Comparamos el documento del cliente asignado a la compra
            if (c.getCliente().getDocumentoIdentidad().equalsIgnoreCase(documentoIdentidad)) {
                historialCliente.add(c);
            }
        }

        return historialCliente;
    }

    //bueno esto solo busca la fecha espesifica y dice que se compro en esa fecha y el valor total de la fecha y sie eso, tengo sueño 

    public double obtenerTotalVendidoEnFecha(LocalDate fechaConsulta) {
        double totalAcumulado = 0.0;

        for (Compra c : this.getListaCompras()) {
            //esto ignora la ora solo toma la fecha osea dia mes y año
            if (c.getFechaHora() != null && c.getFechaHora().toLocalDate().equals(fechaConsulta)) {
                totalAcumulado += c.getValorTotal();
            }
        }

        return totalAcumulado;
    }



    @Override
    public String toString() {
        return "Supermercado{" +
                "nombreComercial='" + nombreComercial + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", listaProductos=" + listaProductos +
                ", listaCompras=" + listaCompras +
                ", listaClientes=" + listaClientes +
                '}';
    }
}
