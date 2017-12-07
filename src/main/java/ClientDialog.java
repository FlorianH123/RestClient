import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ClientDialog {
    private static final String STRING_HEADER           = "--- Primzahl Abfrage ---\n";
    private static final String STRING_N_PRIMES         = "Geben Sie die Anzahl der Primzahlen an, die Sie erhalten möchten: ";
    private static final String STRING_INPUT_MISMATCH   = "Falsche Eingabe!\n";
    private static final String STRING_NEW_N_PRIMES     = "Neue Anzahl an Primzahlen festlegen\t\t\t\t\t\t\t\t<1>";

    private static final int INT_NEW_N_PRIMES       = 1;
    private static final int INT_PRIMES_AS_STRING   = 2;
    private static final int INT_PRIMES_AS_ARRAY    = 3;
    private static final int INT_PRIMES_AS_STRUCT   = 4;

    private Scanner scanner;
    private int nPrimes;
    private String baseUrl;

    private ClientDialog(String baseUrl) {
        this.baseUrl = baseUrl;
        nPrimes = 0;
        scanner = new Scanner(System.in);
    }

    private void switchTask(int selection) {
        ClientApp clientApp = new ClientApp(baseUrl);

        switch (selection) {
            case INT_NEW_N_PRIMES:
                System.out.print(STRING_N_PRIMES);
                nPrimes = scanner.nextInt();
                System.out.println();
                break;

            case INT_PRIMES_AS_STRING:
                System.out.println(clientApp.getPrimesAsString(nPrimes));
                break;

            case INT_PRIMES_AS_ARRAY:
                System.out.println(Arrays.toString(clientApp.getPrimesAsArray(nPrimes)));
                break;

            case INT_PRIMES_AS_STRUCT:
                System.out.println(clientApp.getPrimesAsObject(nPrimes));
                break;

            default:
                System.out.println(STRING_INPUT_MISMATCH);
                break;
        }
    }

    private void startDialog() {
        int selection = 0;

        while (selection != -1) {
            try {
                System.out.println(STRING_HEADER);
                System.out.print(STRING_N_PRIMES);

                nPrimes = scanner.nextInt();

                System.out.println();
                System.out.println(STRING_NEW_N_PRIMES);
                System.out.println("Erste(n) " + nPrimes + " Primzahlen als String abfragen\t\t\t\t\t\t<2>");
                System.out.println("Erste(n) " + nPrimes + " Primzahlen als Array abfragen\t\t\t\t\t\t<3>");
                System.out.println("Erste(n) " + nPrimes + " Primzahlen als Struktur (String + Array) abfragen\t<4>\n");


                System.out.print("> ");
                selection = scanner.nextInt();
                System.out.println();

                switchTask(selection);
            } catch (InputMismatchException ex) {
                System.out.println(STRING_INPUT_MISMATCH);
                scanner.next();
            }
        }
    }

    public static void main(String[] args) {
        new ClientDialog(args[1]).startDialog();
    }
}