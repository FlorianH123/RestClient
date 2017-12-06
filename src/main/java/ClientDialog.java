import java.util.InputMismatchException;
import java.util.Scanner;

public class ClientDialog {
    private static final String HEADER = "--- Primzahl Abfrage ---\n";
    private static final String N_PRIMZAHLEN_ANZAHL = "Geben Sie die Anzahl der Primzahlen an, die Sie erhalten möchten: ";
    private static final String FALSCHE_EINGABE = "Falsche Eingabe!\n";
    private static final String STRING_NEUE_ANZAHL_PRIMZAHLEN = "Neue Anzahl an Primzahlen festlegen\t\t\t\t\t\t\t\t<1>";


    private static final int NEUE_ANZAHL_PRIMZAHL = 1;
    private static final int PRIMZAHLEN_ALS_STRING = 2;
    private static final int PRIMZAHLEN_ALS_ARRAY = 3;
    private static final int PRIMZAHLEN_ALS_STRUKTUR = 4;

    private Scanner scanner;
    private int nPrimzahlen;

    private ClientDialog() {
        nPrimzahlen = 0;
        scanner = new Scanner(System.in);
    }

    private void switchTask(int auswahl) {
        switch (auswahl) {
            case NEUE_ANZAHL_PRIMZAHL:
                System.out.print(N_PRIMZAHLEN_ANZAHL);
                nPrimzahlen = scanner.nextInt();
                System.out.println();
                break;

            case PRIMZAHLEN_ALS_STRING:
                break;

            case PRIMZAHLEN_ALS_ARRAY:
                break;

            case PRIMZAHLEN_ALS_STRUKTUR:
                break;

            default:
                System.out.println(FALSCHE_EINGABE);
                break;
        }
    }

    private void startDialog() {
        int auswahl = 0;

        while (auswahl != -1) {
            try {
                System.out.println(HEADER);
                System.out.print(N_PRIMZAHLEN_ANZAHL);

                nPrimzahlen = scanner.nextInt();

                System.out.println();


                System.out.println(STRING_NEUE_ANZAHL_PRIMZAHLEN);
                System.out.println("Erste(n) " + nPrimzahlen + " Primzahlen als String abfragen\t\t\t\t\t\t<2>");
                System.out.println("Erste(n) " + nPrimzahlen + " Primzahlen als Array abfragen\t\t\t\t\t\t<3>");
                System.out.println("Erste(n) " + nPrimzahlen + " Primzahlen als Struktur (String + Array) abfragen\t<4>\n");


                System.out.print("> ");
                auswahl = scanner.nextInt();
                System.out.println();

                switchTask(auswahl);
            } catch (InputMismatchException ex) {
                System.out.println(FALSCHE_EINGABE);
                scanner.next();

            }
        }
    }
    public static void main(String[] args) {
        new ClientDialog().startDialog();
    }
}
