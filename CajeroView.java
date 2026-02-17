import java.util.Scanner;

public class CajeroView {
    private Scanner scanner = new Scanner(System.in);
    private CajeroController controller = new CajeroController();

    public void iniciar() {
        if (login()) {
            menuPrincipal();
        }
    }

    private boolean login() {
        int intentos = 0;
        while (intentos < 3) {
            System.out.print("Ingrese su PIN: ");
            String pin = scanner.nextLine();
            if (controller.autenticar(pin)) {
                System.out.println("Bienvenido, " + controller.getNombreUsuario());
                return true;
            }
            intentos++;
            System.out.println("PIN incorrecto.");
        }
        System.out.println("Cajero bloqueado.");
        return false;
    }

    private void menuPrincipal() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n1. Ver saldo\n2. Retirar\n3. Depositar\n4. Salir");
            int op = scanner.nextInt();
            switch (op) {
                case 1 -> System.out.println("Saldo: $" + controller.consultarSaldo());
                case 2 -> {
                    System.out.print("Cantidad: ");
                    if (controller.retirar(scanner.nextDouble())) System.out.println("Éxito");
                    else System.out.println("Saldo insuficiente");
                }
                case 3 -> {
                    System.out.print("Cantidad: ");
                    controller.depositar(scanner.nextDouble());
                }
                case 4 -> salir = true;
            }
        }
    }
}