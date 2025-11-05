package mx.unam.aragon.interfija_a_posfija_evaluar.modelo;

import mx.unam.aragon.pila.Pila;

public class Evaluador {

    public static double evaluarPosfija(String expresion) {
        Pila pila = new Pila();

        for (int i = 0; i < expresion.length(); i++) {
            char simbolo = expresion.charAt(i);

            if (simbolo == ' ') continue;

            // Si el símbolo es un número, se apila
            if (Character.isDigit(simbolo)) {
                pila.insertar((double) (simbolo - '0')); // Convertimos char → número
            }
            // Si es un operador, se desapilan dos operandos y se aplica la operación
            else if (esOperador(simbolo)) {
                double operando2 = (double) pila.extraer();
                double operando1 = (double) pila.extraer();
                double resultado = aplicarOperacion(operando1, operando2, simbolo);
                pila.insertar(resultado);
            }
        }

        // Al final debe quedar solo el resultado
        return (double) pila.extraer();
    }

    private static boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static double aplicarOperacion(double op1, double op2, char operador) {
        switch (operador) {
            case '+':
                return op1 + op2;
            case '-':
                return op1 - op2;
            case '*':
                return op1 * op2;
            case '/':
                return op1 / op2;
            default:
                throw new IllegalArgumentException("Operador inválido: " + operador);
        }
    }
}
