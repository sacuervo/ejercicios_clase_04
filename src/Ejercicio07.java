/*
## Ejercicio 7 - Cálculo de Potencias
### Definir el Problema:
Necesitamos calcular la potencia de un número dado una base y un exponente. La fórmula general es `resultado = base ^ exponente`.  
Esto significa que hay que multiplicar la `base` por si mismo `exponente` veces.  
Por ejemplo:
- `2 ^ 4` = `2 * 2 * 2 * 2` = `16`
- `5 ^ 2` = `5 * 5` = `25`
- `27 ^ 1` = `27`
- `325 ^ 0` = `1`
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class Ejercicio07 {
    private static Scanner sc = new Scanner(System.in);
    private static DecimalFormat df = new DecimalFormat("#.#####");
    private static int counter = 0;

    public static void main(String[] args) {
        var numero = solicitarNumero();
        var potencia = solicitarNumero();

        System.out.printf("%s ^ %s = %s", df.format(numero), df.format(potencia),
                df.format(Math.pow(numero, potencia)));
    }

    private static double solicitarNumero() {

        counter++;
        var numero = Double.MIN_VALUE; // Un valor por defecto que el usuario no ingresaría normalmente, puede indicar
                                       // un error
        var numeroValido = false;
        var counterString = "";

        switch (counter) {
            case 1:
                counterString = "un número";
                break;
            case 2:
                counterString = "una potencia";
                break;
        }

        while (!numeroValido) {
            try {
                System.out.printf("Ingrese %s: ", counterString);
                numero = Double.parseDouble(sc.nextLine());
                numeroValido = true;
            } catch (NumberFormatException ex) {
                System.err.println("\nNúmero errado. Por favor intente de nuevo.\n");
            }
        }

        return numero;
    }
}
