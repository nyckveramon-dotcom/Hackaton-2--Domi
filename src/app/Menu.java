package app;

import servicio.DomiService;

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

            switch (opcion) {
                case "1":
                    System.out.println("Opción 1: registrar cliente (pendiente)");
                    break;
                case "2":
                    System.out.println("Opción 2: listar clientes (pendiente)");
                    break;
                case "3":
                    System.out.println("Opción 3: editar cliente (pendiente)");
                    break;
                case "4":
                    System.out.println("Opción 4: eliminar cliente (pendiente)");
                    break;
                case "5":
                    System.out.println("Opción 5: registrar repartidor (pendiente)");
                    break;
                case "6":
                    System.out.println("Opción 6: listar repartidores (pendiente)");
                    break;
                case "7":
                    System.out.println("Opción 7: cambiar disponibilidad (pendiente)");
                    break;
                case "8":
                    System.out.println("Opción 8: crear pedido (pendiente)");
                    break;
                case "9":
                    System.out.println("Opción 9: entregar pedido (pendiente)");
                    break;
                case "10":
                    System.out.println("Opción 10: cancelar pedido (pendiente)");
                    break;
                case "11":
                    System.out.println("Opción 11: listar pedidos (pendiente)");
                    break;
                case "12":
                    System.out.println("Opción 12: lluvia (pendiente)");
                    break;
                case "13":
                    System.out.println("Opción 13: cierre del día (pendiente)");
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
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
    }
}
