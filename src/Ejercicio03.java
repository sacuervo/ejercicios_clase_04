/*
### Definir el Problema:
El factorial de un número entero positivo `n` (denotado como `n!`) es el producto de todos los enteros positivos desde 1 hasta `n`.  
Por ejemplo:  
```
3! = 3 * 2 * 1 = 6
5! = 5 * 4 * 3 * 2 * 1 = 120
```
### Estructura del Programa:
Crear un método separado que realice el cálculo del factorial.
### Interacción con el Usuario:
Pedir al usuario que ingrese un número entero positivo.
### Mostrar Resultados:
Después de calcular el factorial, mostrar el resultado al usuario en la consola.
 */

import java.util.Scanner;

public class Ejercicio03 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println(calcularFactorial());
        sc.close();

    }

    private static int calcularFactorial() {

        var numero = 0;
        var numeroFactorialValido = false;
        var resultado = 1;

        do {
            try {
                System.out.print("Ingrese el número factorial: ");
                numero = Integer.parseInt(sc.nextLine());
                numeroFactorialValido = true;
            } catch (NumberFormatException ex) {
                System.out.println("Numero factorial errado. Por favor intente de nuevo con un número entero.");
            }
        } while (!numeroFactorialValido);

        for (int i = 1; i < numero; i++) {
            resultado *= i + 1;
        }

        return resultado;

    }
}
