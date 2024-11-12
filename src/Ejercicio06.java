/*
## Ejercicio 6 - Conversión de Unidades
### Definir el Problema:
Necesitamos convertir unidades de longitud (metros a kilómetros y viceversa) y unidades de masa (gramos a kilogramos y viceversa).
### Estructura del Programa:
Crear métodos separados para cada tipo de conversión (metros a kilómetros, kilómetros a metros, gramos a kilogramos, kilogramos a gramos).
### Interacción con el Usuario:
Pedir al usuario que ingrese el valor y el tipo de conversión que desea realizar.
### Mostrar Resultados:
Después de realizar la conversión, mostrar el resultado al usuario en la consola.
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class Ejercicio06 {

    private static Scanner sc = new Scanner(System.in);
    private static DecimalFormat df = new DecimalFormat("#.###");

    public static void main(String[] args) {

        var tipoOperacion = solicitarOperacion();

        var unidadDeOrigen = "";
        var unidadResultado = "";

        switch (tipoOperacion) {
            // 1. Convertir metros a kilómetros 2. Convertir kilómetros a metros
            // 3. Convertir gramos a kilogramos 4. Convertir kilogramos a gramos
            case 1:
                unidadDeOrigen = "metros";
                unidadResultado = "kilómetros";
                break;
            case 2:
                unidadDeOrigen = "kilómetros";
                unidadResultado = "metros";
                break;
            case 3:
                unidadDeOrigen = "gramos";
                unidadResultado = "kilogramos";
                break;
            case 4:
                unidadDeOrigen = "kilogramos";
                unidadResultado = "gramos";
        }

        var cantidadAConvertir = solicitarCantidadAConvertir(tipoOperacion, unidadDeOrigen);

        var resultado = convertirUnidades(tipoOperacion, cantidadAConvertir);

        System.out.printf("%s %s equivale a %s %s.", df.format(cantidadAConvertir), unidadDeOrigen, resultado,
                unidadResultado);

        sc.close();

    }

    private static int solicitarOperacion() {

        int tipoOperacion = 0;
        boolean tipoOperacionValido = false;
        int operacion = 0;
        boolean operacionValida = false;

        while (!operacionValida) {
            try {
                if (!tipoOperacionValido) {
                    System.out.println(
                            "Ingrese el tipo de operación que desea ejecutar:\n1. Conversión de unidades de longitud\n2. Conversión de unidades de masa");
                    tipoOperacion = Integer.parseInt(sc.nextLine());
                    tipoOperacionValido = true;
                }

                switch (tipoOperacion) {
                    case 1:
                        System.out
                                .println(
                                        "Ingrese la operación que desea ejecutar:\n1. Convertir metros a kilómetros\n2. Convertir kilómetros a metros");
                        operacion = Integer.parseInt(sc.nextLine());
                        operacionValida = true;
                        break;
                    case 2:
                        System.out
                                .println(
                                        "Ingrese la operación que desea ejecutar:\n1. Convertir gramos a kilogramos\n2. Convertir kilogramos a gramos");
                        operacion = Integer.parseInt(sc.nextLine());
                        operacionValida = true;
                }

            } catch (NumberFormatException ex) {
                System.err.println("Opción errada. Por favor vuelva a intentar.\n");
            }
        }

        if (tipoOperacion == 1) {
            return operacion;
        } else {
            return operacion == 1 ? 3 : 4;
        }

    }

    private static double solicitarCantidadAConvertir(int tipoOperacion, String unidadDeOrigen) {

        var cantidadAConvertir = Double.MIN_VALUE;
        var cantidadAConvertirValida = false;

        while (!cantidadAConvertirValida) {
            try {
                System.out.printf("Ingrese la cantidad de %s que necesita convertir: ", unidadDeOrigen);
                cantidadAConvertir = Double.parseDouble(sc.nextLine());
                cantidadAConvertirValida = true;
            } catch (NumberFormatException ex) {
                System.err.println("Cantidad errada. Por favor vuelva a intentar.\n");
            }
        }

        return cantidadAConvertir;

    }

    private static String convertirUnidades(int tipoOperacion, double cantidadAConvertir) {
        return tipoOperacion == 1 || tipoOperacion == 3 ? df.format(cantidadAConvertir / 1000)
                : df.format(cantidadAConvertir * 1000);
    }

}
