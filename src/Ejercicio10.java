/*
 * ## Ejercicio 10 - Generación de Tablas de Multiplicar
### Definir el Problema:
Necesitamos generar la tabla de multiplicar de un número dado por el usuario, mostrando los resultados desde 1 hasta 10.
### Estructura del Programa:
Crear un método separado que genere y muestre la tabla de multiplicar.  
Usa `printf` para formatear la salida del programa.
### Interacción con el Usuario:
Pedir al usuario que ingrese el número para el cual desea generar la tabla de multiplicar.
### Mostrar Resultados:
Después de generar la tabla de multiplicar, mostrar los resultados al usuario en la consola.  
Por ejemplo:: 
 */

import java.util.Scanner;

public class Ejercicio10 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        var numero = solicitarNumero();
        mostrarTablaDeMultiplicar(numero);

    }

    private static int solicitarNumero() {

        var numero = Integer.MIN_VALUE;
        var numeroValido = false;

        while (!numeroValido) {
            try {
                System.out.print("Ingrese un número: ");
                numero = Integer.parseInt(sc.nextLine());
                if (numero <= 0) {
                    throw new IllegalArgumentException("El número debe se mayor o igual que uno.");
                }
                numeroValido = true;
            } catch (NumberFormatException ex) {
                System.err.println("Número errado. Por favor intente de nuevo.\n");
            } catch (IllegalArgumentException ex) {
                System.err.println(ex.getMessage() + "\n");
            }
        }

        return numero;

    }

    private static void mostrarTablaDeMultiplicar(int numero) {
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d * %d = %d%n", numero, i, numero * i);
        }
    }
}
