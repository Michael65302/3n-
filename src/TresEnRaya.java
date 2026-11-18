import java.util.Scanner;

public class TresEnRaya {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String tablero = "         ";
        char turno = 'X';
        boolean hayGanador = false;

        System.out.println("== TRES EN RAYA ==");

        // Tuve q ultilizar el for, sin el no me dejaba, sufrí, y le pregunté a la IA y me obligó (mentira) a incluirle el for.
        // si lo hacía solo sin condicionales, me imprimía solo la primera jugada xd
        for (int i = 0; i < 9; i++) {

            System.out.println("\n " + tablero.charAt(0) + " | " + tablero.charAt(1) + " | " + tablero.charAt(2) + " ");
            System.out.println("-----------");
            System.out.println(" " + tablero.charAt(3) + " | " + tablero.charAt(4) + " | " + tablero.charAt(5) + " ");
            System.out.println("-----------");
            System.out.println(" " + tablero.charAt(6) + " | " + tablero.charAt(7) + " | " + tablero.charAt(8) + " ");

            System.out.println("\nTurno de " + turno + ". Elige casilla (1-9): ");

            if (scanner.hasNextInt()) {
                int eleccion = scanner.nextInt();
                int indice = eleccion - 1;

                if (indice < 0 || indice > 8) {
                    System.out.println("Error! \n No valido. Solo del 1 al 9. \n Intentalo de nuevo :|");
                    i--;

                } else if (tablero.charAt(indice) != ' ') {
                    System.out.println("Esa casilla ya está ocupada :|");
                    i--;

                } else {
                    tablero = tablero.substring(0, indice) + turno + tablero.substring(indice + 1);

                    boolean ganaFila1 = (tablero.charAt(0) == turno && tablero.charAt(1) == turno && tablero.charAt(2) == turno);
                    boolean ganaFila2 = (tablero.charAt(3) == turno && tablero.charAt(4) == turno && tablero.charAt(5) == turno);
                    boolean ganaFila3 = (tablero.charAt(6) == turno && tablero.charAt(7) == turno && tablero.charAt(8) == turno);

                    boolean ganaCol1  = (tablero.charAt(0) == turno && tablero.charAt(3) == turno && tablero.charAt(6) == turno);
                    boolean ganaCol2  = (tablero.charAt(1) == turno && tablero.charAt(4) == turno && tablero.charAt(7) == turno);
                    boolean ganaCol3  = (tablero.charAt(2) == turno && tablero.charAt(5) == turno && tablero.charAt(8) == turno);

                    boolean ganaDiag1 = (tablero.charAt(0) == turno && tablero.charAt(4) == turno && tablero.charAt(8) == turno);
                    boolean ganaDiag2 = (tablero.charAt(2) == turno && tablero.charAt(4) == turno && tablero.charAt(6) == turno);

                    if (ganaFila1 || ganaFila2 || ganaFila3 || ganaCol1 || ganaCol2 || ganaCol3 || ganaDiag1 || ganaDiag2) {
                        System.out.println("\n " + tablero.charAt(0) + " | " + tablero.charAt(1) + " | " + tablero.charAt(2) + " ");
                        System.out.println("-----------");
                        System.out.println(" " + tablero.charAt(3) + " | " + tablero.charAt(4) + " | " + tablero.charAt(5) + " ");
                        System.out.println("-----------");
                        System.out.println(" " + tablero.charAt(6) + " | " + tablero.charAt(7) + " | " + tablero.charAt(8) + " ");

                        System.out.println("\n Felicidades! \n Jugador " + turno + " gana :)");
                        hayGanador = true;
                        break;
                    } else {
                        if (turno == 'X') {
                            turno = 'O';
                        } else {
                            turno = 'X';
                        }
                    }
                }
            } else {
                System.out.println(" Error! introduce un número válido >>:|");
                scanner.next();
                i--;
            }
        }

        if (!hayGanador) {
            System.out.println("\n Nadie gana >:|");
        }
    }
}