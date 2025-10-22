package fes.aragon.unam.mx.ejercicio_1_2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Ejercicio_1 {

    // Clase Nodo: representa un elemento de la lista enlazada
    static class nodo {
        int valor;
        nodo siguiente;

        nodo(int valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        nodo cabeza = null;
        nodo actual = null;


        for (int i = 0; i < 10000; i++) {
            nodo nuevo = new nodo(random.nextInt(300) + 1);

            if (cabeza == null) {
                cabeza = nuevo;
                actual = cabeza;
            } else {
                actual.siguiente = nuevo;
                actual = nuevo;
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("numeros_aleatorios_nodos.txt"))) {
            nodo temp = cabeza;
            int contador = 0;

            while (temp != null) {
                writer.write(Integer.toString(temp.valor));
                contador++;

                if (contador % 1000 == 0) {
                    writer.write(System.lineSeparator());
                } else {
                    writer.write(",");
                }
                temp = temp.siguiente;
            }

            System.out.println("✅ Archivo 'numeros_aleatorios_nodos.txt' creado correctamente.");
        } catch (IOException e) {
            System.out.println("❌ Error al escribir el archivo: " + e.getMessage());
        }


        System.out.println("\nPrimeros 1000 números generados (primera fila):");
        nodo temp2 = cabeza;
        for (int i = 0; i < 1000 && temp2 != null; i++) {
            System.out.print(temp2.valor);
            if (i < 999) System.out.print(",");
            temp2 = temp2.siguiente;
        }

    }
}