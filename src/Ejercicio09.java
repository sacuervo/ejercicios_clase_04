/*
## Ejercicio 9 - Cálculo de Intereses (simple y compuesto)
### Definir el Problema:
- **Interés Simple**: El interés se calcula solo sobre el capital inicial durante todo el período.
- **Interés Compuesto**: El interés se calcula sobre el capital inicial más los intereses acumulados en cada período.
#### Fórmulas de Cálculo:
- **Interés Simple**: La fórmula es `I = P * r * t`, donde:
    - `I` es el interés.
    - `P` es el capital inicial.
    - `r` es la tasa de interés anual.
    - `t` es el tiempo en años.
- **Interés Compuesto**: La fórmula es `A = P * (1 + (r / n) ^ (n * t))`, donde:
    - `A` es el monto total después del tiempo `t`.
    - `P` es el capital inicial.
    - `r` es la tasa de interés anual.
    - `n` es el número de veces que se aplica el interés compuesto por año.
    - `t` es el tiempo en años.
### Estructura del Programa:
Crear métodos separados para calcular el interés simple y el interés compuesto.  
Puede utilizar la función creada en el **ejercicio 7** para calcular los cuadrados en las formulas.
### Interacción con el Usuario:
Pedir al usuario que ingrese el capital inicial, la tasa de interés, el tiempo y, en el caso del interés compuesto, el número de veces que se aplica el interés por año.
### Mostrar Resultados:
Después de calcular los intereses, mostrar los resultados al usuario en la consola.  
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class Ejercicio09 {

    private static Scanner sc = new Scanner(System.in);
    private static DecimalFormat formatoDinero = new DecimalFormat("#.00");
    private static DecimalFormat df = new DecimalFormat("#.###");

    public static void main(String[] args) {

        var operacion = solicitarOperacion();
        System.out.println(operacion == 1 ? calcularInteresSimple() : calcularInteresCompuesto());
        sc.close();

    }

    private static int solicitarOperacion() {
        int operacion = 0;
        boolean operacionValida = false;

        while (!operacionValida) {
            try {
                System.out.println(
                        "Ingrese el tipo de interés que desea calcular:\n1. Interés simple\n2. Interés compuesto");
                operacion = Integer.parseInt(sc.nextLine());

                if (operacion > 2 || operacion < 1) {
                    throw new IllegalArgumentException("Opción errada. Por favor vuelva a intentar ingresando 1 o 2.");
                }

                operacionValida = true;
            } catch (NumberFormatException ex) {
                System.err.println("Opción errada. Por favor vuelva a intentar.\n");
            } catch (IllegalArgumentException ex) {
                System.err.println(ex.getMessage());
            }
        }

        return operacion;
    }

    private static String calcularInteresSimple() {
        double capital = pedirMontoCapital();
        double tasaInteresAnual = pedirTasaInteres() / 100;
        int tiempo = pedirTiempoEnAnios();
        double interesSimple = capital * tasaInteresAnual * tiempo;

        return "El interés simple es: $" + formatoDinero.format(interesSimple);
    };

    private static String calcularInteresCompuesto() {
        double capital = pedirMontoCapital();
        double tasaInteresAnual = pedirTasaInteres() / 100;
        int tiempo = pedirTiempoEnAnios();
        int numeroDeAplicaciones = pedirVecesQueSeAplicaInteresAnualmente();
        double montoTotal = capital
                * Math.pow((1 + (tasaInteresAnual / numeroDeAplicaciones)), (numeroDeAplicaciones * tiempo));
        double interesCompuesto = montoTotal - capital;

        return "El monto total después de " + tiempo + " años es: $" + formatoDinero.format(montoTotal)
                + "\nEl interés compuesto es: $" + formatoDinero.format(interesCompuesto);

    };

    private static double pedirMontoCapital() {
        var capital = Double.MIN_VALUE;
        var capitalValido = false;

        while (!capitalValido) {
            try {
                System.out.print("Ingrese el monto de capital: ");
                capital = Double.parseDouble(sc.nextLine());
                capitalValido = true;
            } catch (NumberFormatException ex) {
                System.err.print("Monto de capital errado. Por favor vuelva a intentar.\n");
            }
        }

        return capital;

    }

    private static double pedirTasaInteres() {

        var tasaInteres = Double.MIN_VALUE;
        var tasaInteresValida = false;

        while (!tasaInteresValida) {
            try {
                System.out.print("Ingrese la tasa de interés anual (en porcentaje): ");
                tasaInteres = Double.parseDouble(sc.nextLine());
                if (tasaInteres < 0 || tasaInteres > 100) {
                    throw new IllegalArgumentException("Tasa de interés errada. Por favor vuelva a intentar.\n");
                }
                tasaInteresValida = true;
            } catch (NumberFormatException ex) {
                System.err.print("Tasa de interés errada. Por favor vuelva a intentar.\n");
            } catch (IllegalArgumentException ex) {
                System.err.println(ex.getMessage());
            }
        }

        return tasaInteres;

    }

    private static int pedirTiempoEnAnios() {

        var anios = Integer.MIN_VALUE;
        var aniosValidos = false;

        while (!aniosValidos) {
            try {
                System.out.print("Ingrese el tiempo (en años): ");
                anios = Integer.parseInt(sc.nextLine());
                if (anios < 0 || anios > 20) {
                    throw new IllegalArgumentException("Número de años errado. Por favor vuelva a intentar.\n");
                }
                aniosValidos = true;
            } catch (NumberFormatException ex) {
                System.err.print("Número de años errado. Por favor vuelva a intentar.\n");
            } catch (IllegalArgumentException ex) {
                System.err.println(ex.getMessage());
            }
        }

        return anios;
    }

    private static int pedirVecesQueSeAplicaInteresAnualmente() {

        var veces = Integer.MIN_VALUE;
        var vecesValidas = false;

        while (!vecesValidas) {
            try {
                System.out.print("Ingrese el número de veces que se aplica el interés por año: ");
                veces = Integer.parseInt(sc.nextLine());
                if (veces < 0 || veces > 11) {
                    throw new IllegalArgumentException("Número de veces errado. Por favor vuelva a intentar.\n");
                }
                vecesValidas = true;
            } catch (NumberFormatException ex) {
                System.err.print("Número de veces errado. Por favor vuelva a intentar.\n");
            } catch (IllegalArgumentException ex) {
                System.err.println(ex.getMessage());
            }
        }

        return veces;
    }

}
