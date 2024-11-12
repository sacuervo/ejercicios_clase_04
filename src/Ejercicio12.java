/*
 * ## Ejercicio 12 - Conversión de segundos
### Definir el Problema:
Necesitamos convertir una cantidad de segundos ingresada por el usuario en días, horas, minutos y segundos.
### Estructura del Programa:
Crear un método separado que realice la conversión de segundos a días, horas, minutos y segundos.
### Interacción con el Usuario:
Pedir al usuario que ingrese la cantidad de segundos.
### Mostrar Resultados:
Después de realizar la conversión, mostrar los resultados al usuario en la consola.  
 */

import java.util.Scanner;

public class Ejercicio12 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        var segundos = solicitarSegundos();
        imprimirConversion(segundos);
    }

    private static int solicitarSegundos() {

        var segundos = 0;
        var segundosValidos = false;

        while (!segundosValidos) {
            try {
                System.out.print("Ingrese la cantidad de segundos: ");
                segundos = Integer.parseInt(sc.nextLine());
                if (segundos < 0) {
                    throw new IllegalArgumentException(
                            "La cantidad de segundos debe ser mayor o igual a cero. Por favor vuelva a intentar.");
                }
                segundosValidos = true;
            } catch (NumberFormatException ex) {
                System.err.println(ex.getMessage() + "\n");
            } catch (IllegalArgumentException ex) {
                System.err.println(ex.getMessage() + "\n");
            }
        }

        return segundos;

    };

    private static void imprimirConversion(int segundos) {
        var dias = 0;
        var horas = 0;
        var minutos = 0;

        var segundosEnUnDia = 60 * 60 * 24;
        var segundosEnUnaHora = 60 * 60;
        var segundosEnUnMinuto = 60;

        dias = (int) Math.floor(segundos / segundosEnUnDia);
        segundos %= segundosEnUnDia;
        System.out.println(segundos);

        horas = (int) Math.floor(segundos / segundosEnUnaHora);
        segundos %= segundosEnUnaHora;
        System.out.println(segundos);

        minutos = (int) Math.floor(segundos / segundosEnUnMinuto);
        segundos %= segundosEnUnMinuto;
        System.out.println(segundos);

        System.out.println("");

        System.out.printf("Dias: %d%nHoras: %d%nMinutos: %d%nSegundos: %d%n", dias, horas, minutos, segundos);

    }
}
