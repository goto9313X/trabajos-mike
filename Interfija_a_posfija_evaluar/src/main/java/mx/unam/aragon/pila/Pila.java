package mx.unam.aragon.pila;

import java.util.ArrayList;


public class Pila {
    private ArrayList<Object> elementos;

    public Pila() {
        elementos = new ArrayList<>();
    }


    public void insertar(Object elemento) {
        elementos.add(elemento);
    }


    public Object extraer() {
        if (!estaVacia()) {
            return elementos.remove(elementos.size() - 1);
        }
        return null;
    }


    public Object elementoSuperior() {
        if (!estaVacia()) {
            return elementos.get(elementos.size() - 1);
        }
        return null;
    }


    public boolean estaVacia() {
        return elementos.isEmpty();
    }


    public int tamanio() {
        return elementos.size();
    }

    @Override
    public String toString() {
        return elementos.toString();
    }
}