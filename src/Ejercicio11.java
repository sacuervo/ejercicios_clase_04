/*
 * ## Ejercicio 11 - Cálculo de Índice de Masa Corporal
### Definir el Problema:
El Índice de Masa Corporal (IMC) es una medida que se utiliza para determinar si una persona tiene un peso saludable en relación con su altura.  
La fórmula para calcular el IMC es: `IMC = (peso_kg / altura_m) ^ 2`.
#### Categorías del IMC:
- **Bajo peso**: IMC < 18.5
- **Peso normal**: IMC entre 18.5 y 24.9
- **Sobrepeso**: IMC entre 25 y 29.9
- **Obesidad**:
    - **Grado I**: IMC entre 30 y 34.9
    - **Grado II**: IMC entre 35 y 39.9
    - **Grado III**: IMC ≥ 401
### Estructura del Programa:
- Crear un método separado que realice el cálculo del IMC.
- Crear un método separado que determine la categoría del IMC basado en el valor calculado.
### Interacción con el Usuario:
Pedir al usuario que ingrese su peso en kilogramos y su altura en metros.
### Mostrar Resultados:
Después de calcular el IMC y determinar la categoría, mostrar los resultados al usuario en la consola.  
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class Ejercicio11 {
    private static Scanner sc = new Scanner(System.in);
    private static DecimalFormat df = new DecimalFormat("#.00");

    public static void main(String[] args) {

        var IMC = calcularIMC();
        var categoria = determinarCategoria(IMC);

        System.out.println("");

        System.out.printf("Tu IMC es: %s%n", df.format(IMC));
        System.out.printf("Categoria: %s%n", categoria);
        sc.close();

    }

    public static double calcularIMC() {
        var peso = 0D;
        var pesoValido = false;
        var altura = 0D;
        var alturaValida = false;
        var IMC = 0D;

        while (!pesoValido || !alturaValida) {
            try {
                if (!pesoValido) {
                    System.out.print("Ingrese su peso en kilogramos: ");
                    peso = Double.parseDouble(sc.nextLine());

                    if (peso <= 0) {
                        throw new IllegalArgumentException(
                                "Su peso no puede ser menor o igual a 0 kg. Por favor vuelva a intentar.\n");
                    }
                    pesoValido = true;
                }

                if (!alturaValida) {
                    System.out.print("Ingrese su altura en metros: ");
                    altura = Double.parseDouble(sc.nextLine());

                    if (altura <= 0) {
                        throw new IllegalArgumentException(
                                "Su altura no puede ser menor o igual a 0 kg. Por favor vuelva a intentar.\n");
                    }
                    alturaValida = true;
                }
            } catch (NumberFormatException ex) {
                System.err.println(ex.getMessage() + "\n");
            } catch (IllegalArgumentException ex) {
                System.err.println(ex.getMessage() + "\n");
            }
        }

        IMC = peso / Math.pow(altura, 2);
        return IMC;

    };

    public static String determinarCategoria(double IMC) {

        if (IMC < 18.5) {
            return "Bajo peso";
        } else if (IMC <= 24.9) {
            return "Peso normal";
        } else if (IMC <= 29.9) {
            return "Sobrepeso";
        } else if (IMC <= 34.9) {
            return "Obesidad grado I";
        } else if (IMC <= 39.9) {
            return "Obesidad grado II";
        } else {
            return "Obesidad grado III";
        }

    };
}
