/*
## Ejercicio 4 - Números Primos
### Definir el Problema:
Un número primo es un número entero mayor que 1 que solo es divisible por 1 y por sí mismo.  
Ejemplos de números primos: 2, 3, 5, 7, 11, 13, etc.
### Estructura del Programa:
Crear un método separado que realice la verificación de si un número es primo.
### Interacción con el Usuario:
Pedir al usuario que ingrese un número entero positivo.
### Mostrar Resultados:
Después de verificar si el número es primo, mostrar el resultado al usuario en la consola.  
 */

import java.util.Scanner;

public class Ejercicio04 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        var numero = 0;
        var numeroValido = false;

        do {
            try {
                System.out.print("Ingrese un número: ");
                numero = Integer.parseInt(sc.nextLine());
                numeroValido = true;
            } catch (NumberFormatException ex) {
                System.out.println("Numero errado. Por favor intente de nuevo con un número entero.");
            }
        } while (!numeroValido);

        var resultado = esPrimo(numero);

        System.out.printf("%d %s primo.", numero, resultado ? "es" : "no es");

        sc.close();

    }

    private static boolean esPrimo(int numero) {

        var esPrimo = true;
        var contador = 2;

        while (esPrimo && contador <= Math.sqrt(numero)) {
            esPrimo = numero % contador == 0 ? false : true;
            contador++;
        }

        return esPrimo;

    }
}
