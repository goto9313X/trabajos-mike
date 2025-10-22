package fes.aragon.unam.mx.ejercicio_1_2;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Ejercicio_2 {

    public static void main(String[] args) {
        String nombreArchivo = "numeros_aleatorios_nodos.txt";

        // Mapa para contar las repeticiones (TreeMap -> mantiene los números ordenados)
        Map<Integer, Integer> conteo = new TreeMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;

            // Leer el archivo línea por línea
            while ((linea = reader.readLine()) != null) {
                // Dividir cada línea por comas
                String[] numeros = linea.split(",");

                for (String numStr : numeros) {
                    // Evitar cadenas vacías
                    if (numStr.trim().isEmpty()) {
                        continue;
                    }

                    int numero = Integer.parseInt(numStr.trim());

                    // Filtrar solo los números en el rango 30–150
                    if (numero >= 30 && numero <= 150) {
                        // Incrementar el contador de ese número en el mapa
                        conteo.put(numero, conteo.getOrDefault(numero, 0) + 1);
                    }
                }
            }

            // Mostrar el reporte en consola
            System.out.println("REPORTE DE NÚMEROS ENTRE 30 Y 150");
            System.out.println("==================================");

            for (Map.Entry<Integer, Integer> entry : conteo.entrySet()) {
                System.out.println(entry.getKey() + " - salió " + entry.getValue() + " veces.");
            }

            // Calcular el total de números dentro del rango
            int total = conteo.values().stream().mapToInt(Integer::intValue).sum();
            System.out.println("\nTotal de números en el rango (30–150): " + total);

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error de formato en los datos: " + e.getMessage());
        }
    }
}
