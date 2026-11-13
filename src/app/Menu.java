package app;

import modelo.Cliente;
import modelo.Repartidor;
import servicio.DomiService;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private final DomiService service;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.service = new DomiService();
    }

    public void iniciar() {
        String opcion = "";
        while (!opcion.equals("0")) {
            mostrarMenu();
            opcion = scanner.nextLine().trim();

            try {
                switch (opcion) {
                    case "1":
                        opcionRegistrarCliente();
                        break;
                    case "2":
                        opcionListarClientes();
                        break;
                    case "3":
                        opcionEditarCliente();
                        break;
                    case "4":
                        opcionEliminarCliente();
                        break;
                    case "5":
                        opcionRegistrarRepartidor();
                        break;
                    case "6":
                        opcionListarRepartidores();
                        break;
                    case "7":
                        opcionCambiarDisponibilidad();
                        break;
                    case "8":
                        opcionCrearPedido();
                        break;
                    case "9":
                        System.out.println("Opción 9: entregar pedido (pendiente nivel 2)");
                        break;
                    case "10":
                        System.out.println("Opción 10: cancelar pedido (pendiente nivel 2)");
                        break;
                    case "11":
                        System.out.println("Opción 11: listar pedidos (pendiente nivel 2)");
                        break;
                    case "12":
                        System.out.println("Opción 12: lluvia (pendiente nivel 3)");
                        break;
                    case "13":
                        System.out.println("Opción 13: cierre del día (pendiente nivel 3)");
                        break;
                    case "0":
                        break;
                    default:
                        System.out.println("Opción no válida, intenta de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage());
            }
        }
        System.out.println("Hasta luego");
    }

    private void mostrarMenu() {
        System.out.println("══════════════════ DOMI · OPERADOR ══════════════════");
        System.out.println(" CLIENTES      1. Registrar   2. Listar");
        System.out.println("               3. Editar      4. Eliminar");
        System.out.println(" REPARTIDORES  5. Registrar   6. Listar");
        System.out.println("               7. Cambiar disponibilidad");
        System.out.println(" PEDIDOS       8. Crear pedido (cotiza y asigna)");
        System.out.println("               9. Entregar    10. Cancelar");
        System.out.println("               11. Listar pedidos");
        System.out.println(" OPERACIÓN     12. Activar / desactivar lluvia");
        System.out.println("               13. Cierre del día");
        System.out.println("               0. Salir");
        System.out.println("═════════════════════════════════════════════════════");
        System.out.print("Seleccione una opción: ");
    }

    private void opcionRegistrarCliente() {
        System.out.println("\n--- Registrar Nuevo Cliente ---");
        System.out.print("Cédula: ");
        String cedula = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Teléfono (7 a 10 dígitos): ");
        String telefono = scanner.nextLine();
        System.out.println("Barrios con cobertura: " + service.getBarriosConCobertura());
        System.out.print("Barrio: ");
        String barrio = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        service.registrarCliente(cedula, nombre, telefono, barrio, direccion);
        System.out.println("Cliente registrado exitosamente.");
    }

    private void opcionListarClientes() {
        System.out.println("\n--- Lista de Clientes ---");
        Collection<Cliente> lista = service.listarClientes();
        if (lista.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        for (Cliente c : lista) {
            System.out.println("• " + c);
        }
    }

    private void opcionEditarCliente() {
        System.out.println("\n--- Editar Cliente ---");
        System.out.print("Ingrese la cédula del cliente a editar: ");
        String cedula = scanner.nextLine();
        Cliente actual = service.buscarClientePorCedula(cedula);
        System.out.println("Editando a: " + actual.getNombre());

        System.out.print("Nuevo teléfono: ");
        String telefono = scanner.nextLine();
        System.out.println("Barrios con cobertura: " + service.getBarriosConCobertura());
        System.out.print("Nuevo barrio: ");
        String barrio = scanner.nextLine();
        System.out.print("Nueva dirección: ");
        String direccion = scanner.nextLine();

        service.editarCliente(cedula, telefono, barrio, direccion);
        System.out.println("Cliente actualizado con éxito.");
    }

    private void opcionEliminarCliente() {
        System.out.println("\n--- Eliminar Cliente ---");
        System.out.print("Ingrese la cédula del cliente a eliminar: ");
        String cedula = scanner.nextLine();
        service.eliminarCliente(cedula);
        System.out.println("Cliente eliminado correctamente.");
    }

    private void opcionRegistrarRepartidor() {
        System.out.println("\n--- Registrar Repartidor ---");
        System.out.print("Código (ej. R-04): ");
        String codigo = scanner.nextLine();
        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();
        System.out.println("Tipo de vehículo: 1. Bici | 2. Moto | 3. Carro");
        System.out.print("Seleccione tipo: ");
        int tipo = Integer.parseInt(scanner.nextLine().trim());

        service.registrarRepartidor(codigo, nombre, tipo);
        System.out.println("Repartidor registrado exitosamente.");
    }

    private void opcionListarRepartidores() {
        System.out.println("\n--- Lista de Repartidores ---");
        List<Repartidor> lista = service.listarRepartidores();
        if (lista.isEmpty()) {
            System.out.println("No hay repartidores registrados.");
            return;
        }
        for (Repartidor r : lista) {
            System.out.println("• " + r);
        }
    }

    private void opcionCambiarDisponibilidad() {
        System.out.println("\n--- Cambiar Disponibilidad ---");
        System.out.print("Ingrese el código del repartidor: ");
        String codigo = scanner.nextLine();
        Repartidor r = service.cambiarDisponibilidad(codigo);
        System.out.println("Estado actualizado: " + r);
    }


    private void opcionCrearPedido() {
        System.out.println("══════════════════ Crear Nuevo Pedido ══════════════════");
        System.out.print("Cédula del cliente: ");
        String cedula = scanner.nextLine();

        System.out.print("Descripción del pedido: ");
        String descripcion = scanner.nextLine();
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía.");
        }

        System.out.print("¿El pedido es grande? (si/no): ");
        String respuestaGrande = scanner.nextLine().trim().toLowerCase();
        boolean esGrande;

        if (respuestaGrande.equals("si") || respuestaGrande.equals("sí")) {
            esGrande = true;
        } else if (respuestaGrande.equals("no")) {
            esGrande = false;
        } else {
            throw new IllegalArgumentException("Debe responder exactamente 'si' o 'no'.");
        }

        service.crearPedido(cedula, descripcion.trim(), esGrande);
    }
}