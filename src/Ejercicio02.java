/*
## Ejercicio 2 - Verificación de Palíndromos
### Definir el Problema:
Un palíndromo es una palabra, frase o secuencia de caracteres que se lee igual de izquierda a derecha que de derecha a izquierda, ignorando espacios, puntuación y mayúsculas.  
Ejemplos: 
- radar
- anilina
- A man, a plan, a canal, Panama
### Estructura del Programa:
Crear un método separado que realice la verificación de si una cadena es un palíndromo.
### Interacción con el Usuario:
Pedir al usuario que ingrese una cadena de texto.
### Mostrar Resultados:
Después de verificar si la cadena es un palíndromo, mostrar el resultado al usuario en la consola.  
 */

import java.util.Scanner;

public class Ejercicio02 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Ingrese una cadena de texto: ");

        var cadena = sc.nextLine();

        var respuesta = esPalindromo(cadena) ? "es" : "no es";

        System.out.printf("La cadena %s un palíndromo.", respuesta);

        sc.close();

    }

    private static boolean esPalindromo(String cadena) {

        cadena = cadena.trim().toLowerCase();
        char[] charArrCadena = cadena.toCharArray();
        var cadenaProcesada = "";

        for (char letra : charArrCadena) {
            cadenaProcesada += Character.isLetter(letra) ? letra : "";
        }

        var cadenaInversa = new StringBuilder(cadenaProcesada).reverse().toString();

        return cadenaProcesada.equals(cadenaInversa);

    }

}
