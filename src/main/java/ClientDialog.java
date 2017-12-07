import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ClientDialog {
    private static final String STRING_USAGE            = "Sie muessen die IP des Server als Argument uebergeben!\n";

    private static final String STRING_HEADER           = "--- Primzahl Abfrage ---\n";
    private static final String STRING_N_PRIMES         = "Geben Sie die Anzahl der Primzahlen an, die Sie erhalten moechten: ";
    private static final String STRING_INPUT_MISMATCH   = "Falsche Eingabe!\n";
    private static final String STRING_NEW_N_PRIMES     = "Neue Anzahl an Primzahlen festlegen\t\t\t\t\t\t\t<1>";
    private static final String STRING_PRIMES_AS_STRING = "Erste %d Primzahlen als String abfragen\t\t\t\t\t\t<2>";
    private static final String STRING_PRIMES_AS_ARRAY  = "Erste %d Primzahlen als Array abfragen\t\t\t\t\t\t<3>";
    private static final String STRING_PRIMES_AS_OBJECT = "Erste %d Primzahlen als Objekt (String + Array) abfragen\t<4>";
    private static final String STRING_END              = "Programm Ende \t\t\t\t\t\t\t\t\t\t\t\t<5>\n";
    private static final String STRING_PROMPT           = "> ";

    private static final int INT_NEW_N_PRIMES       = 1;
    private static final int INT_PRIMES_AS_STRING   = 2;
    private static final int INT_PRIMES_AS_ARRAY    = 3;
    private static final int INT_PRIMES_AS_OBJECT   = 4;
    private static final int INT_END                = 5;

    private Scanner scanner;
    private int nPrimes;
    private String baseUrl;

    private ClientDialog(String baseUrl) {
        this.baseUrl = baseUrl;
        nPrimes = 0;
        scanner = new Scanner(System.in);
    }

    private void startDialog() {
        int selection = 0;
        boolean firstIteration = true;

        System.out.println(STRING_HEADER);

        while (selection != INT_END) {
            try {
                if (firstIteration) {
                    System.out.print(STRING_N_PRIMES);
                    nPrimes = scanner.nextInt();
                    System.out.println();

                    firstIteration = false;
                }

                selection = printDialogAndGetUserInput();
                switchTask(selection);

            } catch (InputMismatchException ex) {
                System.out.println(STRING_INPUT_MISMATCH);
                scanner.next();

            } catch (Exception ex) {
                 ex.printStackTrace();
            }
        }
    }

    private int printDialogAndGetUserInput() {
        int selection;

        System.out.println(STRING_NEW_N_PRIMES);
        System.out.println(String.format(STRING_PRIMES_AS_STRING, nPrimes));
        System.out.println(String.format(STRING_PRIMES_AS_ARRAY, nPrimes));
        System.out.println(String.format(STRING_PRIMES_AS_OBJECT, nPrimes));
        System.out.println(STRING_END);

        System.out.print(STRING_PROMPT);
        selection = scanner.nextInt();
        System.out.println();

        return selection;
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

            case INT_PRIMES_AS_OBJECT:
                System.out.println(clientApp.getPrimesAsObject(nPrimes));
                break;

            case INT_END:
                break;

            default:
                System.out.println(STRING_INPUT_MISMATCH);
                break;
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println(STRING_USAGE);
            System.exit(1);
        }

        new ClientDialog(args[0]).startDialog();
    }
}