/*
## Ejercicio 5 - Cálculo de Promedio de tres números
### Definir el Problema:
El promedio de tres números se calcula sumando los tres números y dividiendo el resultado entre 3.
### Estructura del Programa:
Crear un método separado que realice el cálculo del promedio.
### Interacción con el Usuario:
Pedir al usuario que ingrese tres números.
### Mostrar Resultados:
Después de calcular el promedio, mostrar el resultado al usuario en la consola. 
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class Ejercicio05 {

    private static Scanner sc = new Scanner(System.in);
    private static DecimalFormat df = new DecimalFormat("#.##");
    private static int counter = 0;

    public static void main(String[] args) {
        var num1 = solicitarNumero();
        var num2 = solicitarNumero();
        var num3 = solicitarNumero();
        System.out.println();

        System.out.printf("El promedio de los tres números es %s", promediarTresNumeros(num1, num2, num3));
    }

    private static double solicitarNumero() {

        counter++;
        var numero = Double.MIN_VALUE; // Un valor por defecto que el usuario no ingresaría normalmente, puede indicar
                                       // un error
        var numeroValido = false;
        var counterString = "";

        switch (counter) {
            case 1:
                counterString = "primer";
                break;
            case 2:
                counterString = "segundo";
                break;
            case 3:
                counterString = "tercer";
                break;
        }

        while (!numeroValido) {
            try {
                System.out.printf("Ingrese el %s número: ", counterString);
                numero = Double.parseDouble(sc.nextLine());
                numeroValido = true;
            } catch (NumberFormatException ex) {
                System.err.println("\nNúmero errado. Por favor intente de nuevo.\n");
            }
        }

        return numero;
    }

    private static String promediarTresNumeros(double num1, double num2, double num3) {
        return df.format((num1 + num2 + num3) / 3);
    }

}
