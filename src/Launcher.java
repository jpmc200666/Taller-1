
import java.util.InputMismatchException;
import java.util.Scanner;


public class Launcher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) { // Bucle infinito para reiniciar el código
            try {
                // Solicitar primera fracción
                System.out.println("Ingrese el numerador de la primera fraccion:");
                int num1 = scanner.nextInt();
                System.out.println("Ingrese el denominador de la primera fraccion:");
                int den1 = scanner.nextInt();

                Racional fraccion1 = new Racional(num1, den1);

                // Solicitar segunda fracción
                System.out.println("Ingrese el numerador de la segunda fraccion:");
                int num2 = scanner.nextInt();
                System.out.println("Ingrese el denominador de la segunda fraccion:");
                int den2 = scanner.nextInt();

                Racional fraccion2 = new Racional(num2, den2);

                // Realizar operaciones
                Racional suma = fraccion1.sumar(fraccion2);
                Racional resta = fraccion1.restar(fraccion2);
                Racional multiplicacion = fraccion1.multiplicar(fraccion2);
                Racional division = fraccion1.dividir(fraccion2);

                // Solicitar la precisión de decimales al usuario
                System.out.println("Ingrese la precision de decimales para los resultados:");
                int precision = scanner.nextInt();

                // Mostrar resultados con la precisión especificada
                System.out.println("La suma de las fracciones es: " + suma + " = " + suma.decimal(precision));
                System.out.println("La resta de las fracciones es: " + resta + " = " + resta.decimal(precision));
                System.out.println("La multiplicacion de las fracciones es: " + multiplicacion + " = " + multiplicacion.decimal(precision));
                System.out.println("La division de las fracciones es: " + division + " = " + division.decimal(precision));

                // Preguntar al usuario si desea continuar o salir
                System.out.println("Desea realizar otra operacion? (si/no):");
                String respuesta = scanner.next();

                if (!respuesta.equalsIgnoreCase("si")) {
                    System.out.println("Saliendo del programa...");
                    break; // Sale del bucle y finaliza el programa
                }

            } catch (IllegalArgumentException e) {
                // Captura la excepción del denominador cero
                System.out.println("Error: " + e.getMessage());
                System.out.println("Reiniciando el programa...");
                scanner.nextLine(); // Limpiar el buffer del scanner
            } catch (InputMismatchException e) {
                // Captura la excepción si el usuario ingresa un valor no numérico
                System.out.println("Error: Ingreso no valido. Solo se permiten numeros enteros.");
                System.out.println("Reiniciando el programa...");
                scanner.nextLine(); // Limpiar el buffer del scanner
            }
        }
    }
} 
