package fes.aragon.dinamica.listadoble;

public class ListaDoble<E> {
    protected NodoDoble<E> cabeza, cola;
    protected int longitud = 0;

    public ListaDoble() {
        cabeza = cola = null;
    }

    public void agregarEnCabeza(E dato) {
        NodoDoble<E> nuevo = new NodoDoble<>(dato, null, cabeza);
        if (cabeza != null) {
            cabeza.setAnterior(nuevo);
        }
        cabeza = nuevo;
        if (cola == null) {
            cola = cabeza;
        }
        longitud++;
    }

    public void agregarEnCola(E dato) {
        NodoDoble<E> nuevo = new NodoDoble<>(dato, cola, null);
        if (cola != null) {
            cola.setSiguiente(nuevo);
        }
        cola = nuevo;
        if (cabeza == null) {
            cabeza = cola;
        }
        longitud++;
    }

    public void imprimirElementos() {
        for (NodoDoble<E> tmp = cabeza; tmp != null; tmp = tmp.getSiguiente()) {
            System.out.println(tmp.getDato());
        }
    }

    public E obtenerCabeza() {
        return cabeza != null ? cabeza.getDato() : null;
    }

    public E obtenerCola() {
        return cola != null ? cola.getDato() : null;
    }

    public boolean eliminar(E dato) {
        if (cabeza == null) {
            return false;
        }
        for (NodoDoble<E> tmp = cabeza; tmp != null; tmp = tmp.getSiguiente()) {
            if (tmp.getDato().equals(dato)) {
                if (tmp == cabeza && tmp == cola) { // único nodo
                    cabeza = cola = null;
                } else if (tmp == cabeza) {
                    cabeza = cabeza.getSiguiente();
                    cabeza.setAnterior(null);
                } else if (tmp == cola) {
                    cola = cola.getAnterior();
                    cola.setSiguiente(null);
                } else {
                    tmp.getAnterior().setSiguiente(tmp.getSiguiente());
                    tmp.getSiguiente().setAnterior(tmp.getAnterior());
                }
                longitud--;
                return true;
            }
        }
        return false;
    }

    public int getLongitud() {
        if (longitud < 0) {
            longitud = 0;
        }
        return longitud;
    }

    public boolean esVacia() {
        return cabeza == null;
    }

    public void eliminarEnCabeza() {
        if (cabeza == null) return;
        if (cabeza == cola) {
            cabeza = cola = null;
        } else {
            cabeza = cabeza.getSiguiente();
            cabeza.setAnterior(null);
        }
        longitud--;
    }

    public void eliminarEnCola() {
        if (cola == null) return;
        if (cabeza == cola) {
            cabeza = cola = null;
        } else {
            cola = cola.getAnterior();
            cola.setSiguiente(null);
        }
        longitud--;
    }

    public E obtenerNodo(int indice) {
        if (indice < 0 || indice >= longitud) return null;
        NodoDoble<E> tmp;
        int mitad = longitud / 2;
        if (indice <= mitad) {
            tmp = cabeza;
            for (int i = 0; i < indice; i++) tmp = tmp.getSiguiente();
        } else {
            tmp = cola;
            for (int i = longitud - 1; i > indice; i--) tmp = tmp.getAnterior();
        }
        return tmp != null ? tmp.getDato() : null;
    }

    public int estaEnLista(E dato) {
        int indice = 0;
        for (NodoDoble<E> tmp = cabeza; tmp != null; tmp = tmp.getSiguiente(), indice++) {
            if (tmp.getDato().equals(dato)) return indice;
        }
        return -1;
    }

    public boolean eliminarEnIndice(int indice) {
        if (indice < 0 || indice >= longitud || cabeza == null) return false;
        if (indice == 0) {
            eliminarEnCabeza();
            return true;
        }
        if (indice == longitud - 1) {
            eliminarEnCola();
            return true;
        }
        NodoDoble<E> tmp;
        int mitad = longitud / 2;
        if (indice <= mitad) {
            tmp = cabeza;
            for (int i = 0; i < indice; i++) tmp = tmp.getSiguiente();
        } else {
            tmp = cola;
            for (int i = longitud - 1; i > indice; i--) tmp = tmp.getAnterior();
        }
        tmp.getAnterior().setSiguiente(tmp.getSiguiente());
        tmp.getSiguiente().setAnterior(tmp.getAnterior());
        longitud--;
        return true;
    }

    public boolean insertarEnIndice(E dato, int indice) {
        if (indice < 0 || indice > longitud) return false;
        if (indice == 0) {
            agregarEnCabeza(dato);
            return true;
        }
        if (indice == longitud) {
            agregarEnCola(dato);
            return true;
        }
        NodoDoble<E> tmp;
        int mitad = longitud / 2;
        if (indice <= mitad) {
            tmp = cabeza;
            for (int i = 0; i < indice; i++) tmp = tmp.getSiguiente();
        } else {
            tmp = cola;
            for (int i = longitud - 1; i >= indice; i--) tmp = tmp.getAnterior();
        }
        NodoDoble<E> nuevo = new NodoDoble<>(dato, tmp.getAnterior(), tmp);
        tmp.getAnterior().setSiguiente(nuevo);
        tmp.setAnterior(nuevo);
        longitud++;
        return true;
    }

    public boolean asignar(E dato, int indice) {
        if (indice < 0 || indice >= longitud) return false;
        NodoDoble<E> tmp;
        int mitad = longitud / 2;
        if (indice <= mitad) {
            tmp = cabeza;
            for (int i = 0; i < indice; i++) tmp = tmp.getSiguiente();
        } else {
            tmp = cola;
            for (int i = longitud - 1; i > indice; i--) tmp = tmp.getAnterior();
        }
        tmp.setDato(dato);
        return true;
    }

    public void asignar(E dato, E nuevoDato, boolean todos) {
        for (NodoDoble<E> tmp = cabeza; tmp != null; tmp = tmp.getSiguiente()) {
            if (tmp.getDato().equals(dato)) {
                tmp.setDato(nuevoDato);
                if (!todos) return;
            }
        }
    }

    public void setIndice(E dato, int indiceUsuario) {
        asignar(dato, indiceUsuario);
    }

    public E getIndice(int indiceUsuario) {
        return obtenerNodo(indiceUsuario);
    }
}