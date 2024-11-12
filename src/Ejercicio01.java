
/*
 ## Ejercicio 1 - Conversión de Temperaturas
### Definir el Problema:
Necesitamos convertir temperaturas de Celsius a Fahrenheit y viceversa.  
Operaciones para las conversiones:
- **Celsius a Fahrenheit**: La fórmula es `F = (C * (9 / 5)) + 32`.
- **Fahrenheit a Celsius**: La fórmula es `C = (F - 32) / (9 / 5)`.
### Estructura del Programa:
Crear métodos separados para cada conversión.
### Interacción con el Usuario:
Pedir al usuario que ingrese la temperatura y el tipo de conversión que desea realizar.
### Mostrar Resultados:
Mostrar el resultado de la conversión.   
 */
import java.text.DecimalFormat;
import java.util.Scanner;

public class Ejercicio01 {

    private static Scanner sc = new Scanner(System.in);
    private static DecimalFormat df = new DecimalFormat("#.#");

    public static void main(String[] args) {

        var conversion = solicitarOperacionDeConversion();
        var valorAConvertir = solicitarValorAConvertir(conversion);
        var resultado = conversion == 1 ? convertirAFahrenheit(valorAConvertir) : convertirACelsius(valorAConvertir);

        System.out.printf("La temperatura en %s es %s°.", (conversion == 1 ? "fahrenheit" : "celsius"), resultado);

        sc.close();
    }

    private static int solicitarOperacionDeConversion() {

        var operacionValida = false;
        var operacion = 0;

        do {
            try {

                if (!operacionValida) {
                    try {
                        System.out.print(
                                "Ingrese la operación que desea realizar. 1 para convertir de °C a °F, o 2 para convertir de °F a °C: ");

                        operacion = Integer.parseInt(sc.nextLine());

                        if (operacion < 1 || operacion > 2) {
                            throw new IllegalArgumentException("Por favor seleccione 1 o 2.");
                        } else {
                            operacionValida = true;
                        }
                    } catch (NumberFormatException ex) {
                        throw new IllegalArgumentException(
                                "Opción errada. Por favor ingrese 1 para convertir de °C a °F, o 2 para convertir de °F a °C.\n");
                    }
                }

            } catch (IllegalArgumentException ex) {
                System.err.println(ex.getMessage() + "\n");
            }

        } while (!operacionValida);

        return operacion;
    }

    private static String convertirACelsius(double temperaturaFahrenheit) {

        return df.format((temperaturaFahrenheit - 32) * 5 / 9);

    };

    private static String convertirAFahrenheit(double temperaturaCelsius) {

        return df.format(temperaturaCelsius * 9 / 5 + 32);

    };

    private static double solicitarValorAConvertir(int operacion) {

        var valorAConvertir = 0D;
        var valorAConvertirValido = false;

        do {
            try {
                System.out.printf("Ingresa el valor en %s a convertir: ", operacion == 1 ? "celsius" : "fahrenheit");
                valorAConvertir = Double.parseDouble(sc.nextLine());
                valorAConvertirValido = true;
            } catch (NumberFormatException ex) {
                System.out.println("Temperatura a convertir errada. Por favor intente de nuevo.");
            }

        } while (!valorAConvertirValido);

        return valorAConvertir;

    }

}
