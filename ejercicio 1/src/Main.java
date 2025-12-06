import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
// Se usa Queue porque respeta el orden FIFO (primero en entrar, primero en salir),
        // ideal para un sistema de turnos de atención.
        Queue<String> filaDeTurnos = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        
        do {
            System.out.println("\n--- Sistema de Turnos ---");
            System.out.println("1. Registrar nuevo cliente");
            System.out.println("2. Atender siguiente cliente");
            System.out.println("3. Mostrar fila actual");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombreCliente = scanner.nextLine();
                    filaDeTurnos.offer(nombreCliente);
                    System.out.println(nombreCliente + " ha sido registrado en la fila.");
                    break;

                case 2:
                    String clienteAtendido = filaDeTurnos.poll();
                    if (clienteAtendido != null) {
                        System.out.println("Atendiendo a: " + clienteAtendido);
                    } else {
                        System.out.println("No hay clientes en la fila.");
                    }
                    break;

                case 3:
                    System.out.println("Clientes en espera: " + filaDeTurnos);
                    break;

                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 4);

        scanner.close();
    }
}