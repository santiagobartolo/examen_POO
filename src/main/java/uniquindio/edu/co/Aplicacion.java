package uniquindio.edu.co;

import java.util.Scanner;

public class Aplicacion {

    public static void main() {

        Scanner sc = new Scanner(System.in);

        // Instanciación con el constructor de 3 parámetros
        Supermercado supermercado = new Supermercado("MarketPlus", "Carrera 15 #12-30", "31242526");

        int opcion = -1;
        do {
            System.out.println("\n====== Menú Supermercado MarketPlus =======");
            System.out.println("-------Cliente-------");
            System.out.println("1. Agregar cliente.");
            System.out.println("2. Actualizar cliente.");
            System.out.println("3. Eliminar cliente.");
            System.out.println("4. Mostrar clientes.");

            System.out.println("--------Producto-----------");
            System.out.println("5. Agregar producto.");
            System.out.println("6. Actualizar producto.");
            System.out.println("7. Eliminar producto.");
            System.out.println("8. Mostrar productos.");
            System.out.println("9. Reabastecer stock de producto.");

            System.out.println("--------Compra / Venta-----------");
            System.out.println("10. Realizar compra.");
            System.out.println("11. Mostrar historial de compras.");

            System.out.println("0. Salir.");

            System.out.print("Seleccione la opción: ");
            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un número válido.");
                continue;
            }

            switch (opcion) {

                // ============= CLIENTE =============
                case 1:
                    System.out.println("\n------Agregar cliente----");

                    System.out.print("Documento identidad: ");
                    String docCliente = sc.nextLine();

                    System.out.print("Nombre completo: ");
                    String nombreCliente = sc.nextLine();

                    System.out.print("Teléfono: ");
                    String telefonoCliente = sc.nextLine();

                    System.out.print("Correo electrónico: ");
                    String correoCliente = sc.nextLine();

                    Cliente cliente = new Cliente(docCliente, nombreCliente, telefonoCliente, correoCliente);

                    if (supermercado.registrarCliente(cliente)) {
                        System.out.println("Cliente agregado correctamente.");
                    } else {
                        System.out.println("El cliente ya existe.");
                    }
                    break;

                case 2:
                    System.out.println("\n------Actualizar cliente-----");

                    System.out.print("Documento cliente a actualizar: ");
                    String docActualizar = sc.nextLine();

                    System.out.print("Nuevo nombre completo: ");
                    String nuevoNombreCliente = sc.nextLine();

                    System.out.print("Nuevo teléfono: ");
                    String nuevoTelefonoCliente = sc.nextLine();

                    System.out.print("Nuevo correo electrónico: ");
                    String nuevoCorreoCliente = sc.nextLine();

                    if (supermercado.actualizarCliente(docActualizar, nuevoNombreCliente, nuevoTelefonoCliente, nuevoCorreoCliente)) {
                        System.out.println("Cliente actualizado correctamente.");
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("\n------Eliminar cliente------");

                    System.out.print("Documento del cliente a eliminar: ");
                    String docEliminar = sc.nextLine();

                    if (supermercado.eliminarCliente(docEliminar)) {
                        System.out.println("El cliente ha sido eliminado correctamente.");
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("\n-------Lista clientes------");
                    if (supermercado.getListaClientes().isEmpty()) {
                        System.out.println("No hay clientes registrados.");
                    } else {
                        for (Cliente clienteLista : supermercado.getListaClientes()) {
                            System.out.println(clienteLista);
                        }
                    }
                    break;

                // ============= PRODUCTO =============
                case 5:
                    System.out.println("\n------Agregar producto----");

                    System.out.print("Código del producto: ");
                    String codProducto = sc.nextLine();

                    System.out.print("Nombre producto: ");
                    String nombreProducto = sc.nextLine();

                    System.out.print("Precio unitario: ");
                    double precioProducto = Double.parseDouble(sc.nextLine().replace(",", "."));

                    System.out.print("Cantidad disponible inicial: ");
                    int cantidadInicial = Integer.parseInt(sc.nextLine().trim());

                    // Selección interactiva de categoría
                    System.out.println("\nSeleccione la categoría del producto:");
                    System.out.println("1. Alimentos");
                    System.out.println("2. Bebidas");
                    System.out.println("3. Aseo");
                    System.out.print("Opción: ");
                    int opCat = Integer.parseInt(sc.nextLine().trim());

                    Categoria categoriaSeleccionada;
                    switch (opCat) {
                        case 1:
                            categoriaSeleccionada = Categoria.ALIMENTOS;
                            break;
                        case 2:
                            categoriaSeleccionada = Categoria.BEBIDAS;
                            break;
                        case 3:
                            categoriaSeleccionada = Categoria.ASEO;
                            break;
                        case 4:
                            categoriaSeleccionada = Categoria.CUIDADO_PERSONAL;
                        default:
                            System.out.println("Opción no válida. Se asignará ALIMENTOS por defecto.");
                            categoriaSeleccionada = Categoria.ALIMENTOS;
                    }

                    Producto producto = new Producto(codProducto, nombreProducto, categoriaSeleccionada, precioProducto, cantidadInicial);

                    if (supermercado.registrarProducto(producto)) {
                        System.out.println("Producto agregado correctamente.");
                    } else {
                        System.out.println("El producto ya existe.");
                    }
                    break;

                case 6:
                    System.out.println("\n------Actualizar producto-----");

                    System.out.print("Código del producto a actualizar: ");
                    String codActualizar = sc.nextLine();

                    System.out.print("Nuevo nombre producto: ");
                    String nuevoNombreProd = sc.nextLine();

                    System.out.print("Nuevo precio unitario: ");
                    double nuevoPrecioProd = Double.parseDouble(sc.nextLine().replace(",", "."));

                    if (supermercado.actualizarProducto(codActualizar, nuevoNombreProd, nuevoPrecioProd)) {
                        System.out.println("Producto actualizado correctamente.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 7:
                    System.out.println("\n------Eliminar producto------");

                    System.out.print("Código del producto a eliminar: ");
                    String codEliminar = sc.nextLine();

                    if (supermercado.eliminarProducto(codEliminar)) {
                        System.out.println("El producto ha sido eliminado correctamente.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 8:
                    System.out.println("\n-------Lista productos------");
                    if (supermercado.getListaProductos().isEmpty()) {
                        System.out.println("No hay productos en el inventario.");
                    } else {
                        for (Producto productoLista : supermercado.getListaProductos()) {
                            System.out.println(productoLista);
                        }
                    }
                    break;

                case 9:
                    System.out.println("\n------Reabastecer stock producto------");

                    System.out.print("Código del producto: ");
                    String codStock = sc.nextLine();

                    System.out.print("Cantidad de unidades a sumar: ");
                    int cantSumar = Integer.parseInt(sc.nextLine().trim());

                    if (supermercado.sumarStockProducto(codStock, cantSumar)) {
                        System.out.println("Stock actualizado correctamente.");
                    } else {
                        System.out.println("Producto no encontrado o cantidad inválida.");
                    }
                    break;

                // ============= COMPRA / VENTA =============
                case 10:
                    System.out.println("\n------Realizar compra----");

                    System.out.print("Documento cliente comprador: ");
                    String docComprador = sc.nextLine();

                    Cliente clienteComprador = supermercado.buscarClientePorDocumento(docComprador);

                    if (clienteComprador != null) {
                        System.out.println("\nSeleccione el método de pago:");
                        System.out.println("1. Efectivo");
                        System.out.println("2. Tarjeta");
                        System.out.println("3. Transferencia");
                        System.out.print("Opción: ");
                        int opPago = Integer.parseInt(sc.nextLine().trim());

                        MetodoPago pagoSeleccionado;
                        switch (opPago) {
                            case 1:
                                pagoSeleccionado = MetodoPago.EFECTIVO;
                                break;
                            case 2:
                                pagoSeleccionado = MetodoPago.TARJETA;
                                break;
                            case 3:
                                pagoSeleccionado = MetodoPago.TRANSFERENCIA;
                                break;
                            default:
                                System.out.println("Opción no válida. Se asignará EFECTIVO por defecto.");
                                pagoSeleccionado = MetodoPago.EFECTIVO;
                        }

                        Compra nuevaCompra = new Compra("C-" + (supermercado.getListaCompras().size() + 1), pagoSeleccionado, clienteComprador);

                        boolean agregando = true;
                        while (agregando) {
                            System.out.print("\nCódigo del producto a comprar (o '0' para finalizar): ");
                            String codProdCompra = sc.nextLine();

                            if (codProdCompra.equalsIgnoreCase("0")) {
                                agregando = false;
                            } else {
                                Producto prodSeleccionado = supermercado.buscarProductoPorCodigo(codProdCompra);

                                if (prodSeleccionado != null) {
                                    System.out.print("Cantidad a llevar de [" + prodSeleccionado.getNombre() + "]: ");
                                    int cantLlevar = Integer.parseInt(sc.nextLine().trim());

                                    if (prodSeleccionado.tieneStockSuficiente(cantLlevar)) {
                                        DetalleCompra detalle = new DetalleCompra(cantLlevar, prodSeleccionado);
                                        nuevaCompra.agregarDetalle(detalle);

                                        System.out.println("-> Producto agregado al carrito. Quedan " + prodSeleccionado.getCantidadDisponible() + " unidades en stock.");
                                    } else {
                                        System.out.println("Stock insuficiente. Disponibles: " + prodSeleccionado.getCantidadDisponible());
                                    }
                                } else {
                                    System.out.println("Producto no encontrado.");
                                }
                            }
                        }

                        if (supermercado.registrarCompra(nuevaCompra)) {
                            System.out.println("\n========================================");
                            System.out.println("       COMPRA REALIZADA EXITOSAMENTE    ");
                            System.out.println("Cliente: " + clienteComprador.getNombreCompleto());
                            System.out.println("Método de pago: " + nuevaCompra.getMetodoPago());
                            System.out.println("Valor total a pagar: $" + nuevaCompra.getValorTotal());
                            System.out.println("========================================");
                        } else {
                            System.out.println("Compra cancelada (no se agregaron productos al carrito).");
                        }

                    } else {
                        System.out.println("El cliente no está registrado.");
                    }
                    break;

                case 11:
                    System.out.println("\n-------Lista compras realizadas------");
                    if (supermercado.getListaCompras().isEmpty()) {
                        System.out.println("No se han registrado compras.");
                    } else {
                        for (Compra compraLista : supermercado.getListaCompras()) {
                            System.out.println(compraLista);
                        }
                    }
                    break;
                case 12:
                    System.out.println("\n------- Reporte de Ventas por Fecha ------");
                    System.out.print("Ingrese la fecha a consultar (AAAA-MM-DD, ej: 2026-09-24): ");
                    String fechaStr = sc.nextLine();

                    try {
                        java.time.LocalDate fechaConsulta = java.time.LocalDate.parse(fechaStr);
                        double totalVendido = supermercado.obtenerTotalVendidoEnFecha(fechaConsulta);

                        System.out.println("========================================");
                        System.out.println("Total vendido el día " + fechaConsulta + ": $" + totalVendido);
                        System.out.println("========================================");
                    } catch (Exception e) {
                        System.out.println("Formato de fecha inválido. Debe usar AAAA-MM-DD.");
                    }
                    break;

                case 0:
                    System.out.println("Programa finalizado.....");
                    break;

                default:
                    System.out.println("Opción no válida....");
            }

        } while (opcion != 0);

        sc.close();
    }
}