package mx.unam.aragon.interfija_a_posfija_evaluar.modelo;

import mx.unam.aragon.pila.Pila;

public class Convertidor {
    public static String convertirInfijaAPosfija(String expresion) {
        Pila pila = new Pila();
        StringBuilder salida = new StringBuilder();

        for (int i = 0; i < expresion.length(); i++) {
            char simbolo = expresion.charAt(i);

            if (simbolo == ' ') continue;

            if (Character.isLetterOrDigit(simbolo)) {
                salida.append(simbolo);
            } else if (simbolo == '(') {
                pila.insertar(simbolo);
            } else if (simbolo == ')') {
                while (!pila.estaVacia() && (char) pila.elementoSuperior() != '(') {
                    salida.append(pila.extraer());
                }
                if (!pila.estaVacia() && (char) pila.elementoSuperior() == '(') {
                    pila.extraer();
                }
            } else if (esOperador(simbolo)) {
                while (!pila.estaVacia() &&
                        precedencia((char) pila.elementoSuperior()) >= precedencia(simbolo)) {
                    salida.append(pila.extraer());
                }
                pila.insertar(simbolo);
            }
        }

        while (!pila.estaVacia()) {
            salida.append(pila.extraer());
        }

        return salida.toString();
    }

    private static int precedencia(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    private static boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}


