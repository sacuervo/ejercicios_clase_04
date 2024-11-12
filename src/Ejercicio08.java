/*
## Ejercicio 8 - Cálculo de Áreas
### Definir el Problema:
Necesitamos calcular el área de un círculo, un cuadrado y un triángulo utilizando las fórmulas matemáticas correspondientes.  
Fórmulas de Cálculo:
- **Área de un Círculo**: La fórmula es `A = pi * r ^ 2`, donde `r` es el radio del círculo.
- **Área de un Cuadrado**: La fórmula es `A = l ^ 2`, donde `l` es la longitud del lado del cuadrado.
- **Área de un Triángulo**: La fórmula es `A = (b * h) / 2`, donde `b` es la base y `h` es la altura del triángulo.
### Estructura del Programa:
Crear métodos separados para calcular el área de cada figura geométrica.  
Puede utilizar la función creada en el **ejercicio 7** para calcular los cuadrados en las formulas.
### Interacción con el Usuario:
Pedir al usuario que ingrese los valores necesarios (radio, lado, base y altura) para calcular el área de cada figura.
### Mostrar Resultados:
Después de calcular el área, mostrar el resultado al usuario en la consola.
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class Ejercicio08 {
    private static Scanner sc = new Scanner(System.in);
    private static DecimalFormat df = new DecimalFormat("#.##");
    private static String nombreFigura = "";

    public static void main(String[] args) {

        var operacion = solicitarOperacion();
        var resultado = 0D;

        switch (operacion) {
            case 1:
                nombreFigura = "círculo";
                resultado = calcularAreaCirculo();
                break;
            case 2:
                nombreFigura = "cuadrado";
                resultado = calcularAreaCuadrado();
                break;
            case 3:
                nombreFigura = "triángulo";
                resultado = calcularAreaTriangulo();
                break;
            default:
                System.err.println("Operación errada.");
                System.exit(0);
        }

        System.out.printf("El área del %s es %s.", nombreFigura, df.format(resultado));

        sc.close();

    }

    private static int solicitarOperacion() {

        int operacion = 0;
        boolean operacionValida = false;

        while (!operacionValida) {
            try {
                System.out.println(
                        "Ingrese la operación que desea ejecutar:\n1. Calcular área de un círculo\n2. Calcular área de un cuadrado\n3. Calcular área de un triángulo");
                operacion = Integer.parseInt(sc.nextLine());
                operacionValida = true;

            } catch (NumberFormatException ex) {
                System.err.println("Opcion errada. Por favor vuelva a intentar.\n");
            }
        }

        return operacion;

    }

    private static double solicitarMedida(String nombreMedida) {
        var medida = 0D;
        var medidaValida = false;

        while (!medidaValida) {
            try {
                System.out.printf("Ingrese %s del %s: ", nombreMedida, nombreFigura);
                medida = Double.parseDouble(sc.nextLine());
                medidaValida = true;
            } catch (NumberFormatException ex) {
                System.err.println("Medida errada. Por favor vuelva a intentar.\n");
            }
        }

        return medida;

    }

    private static double calcularAreaCirculo() {
        double radio = solicitarMedida("radio");
        return Math.PI * (Math.pow(radio, 2));
    }

    private static double calcularAreaCuadrado() {
        double lado = solicitarMedida("lado");
        return Math.pow(lado, 2);
    }

    private static double calcularAreaTriangulo() {
        double base = solicitarMedida("base");
        double altura = solicitarMedida("altura");
        return base * altura / 2;
    }
}
