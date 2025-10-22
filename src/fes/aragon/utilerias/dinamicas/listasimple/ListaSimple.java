package fes.aragon.utilerias.dinamicas.listasimple;

public class ListaSimple<E> {
    protected Nodo<E> cabeza, cola;
    protected int longitud = 0;

    public ListaSimple() {
        cabeza = cola = null;
    }

    public void agregarEnCabeza(E dato) {
        cabeza = new Nodo<E>(dato, cabeza);
        if (cola == null) {
            cola = cabeza;
        }
        longitud++;
    }

    public void agregarEnCola(E dato) {
        if (cabeza == null) {
            cabeza = cola = new Nodo<E>(dato);
        } else {
            cola.setSiguiente(new Nodo<E>(dato));
            cola = cola.getSiguiente();
        }
        longitud++;
    }

    public void imprimirElementos() {
        for (Nodo<E> tmp = cabeza; tmp != null; tmp = tmp.getSiguiente()) {
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
        boolean borrado = false;
        if (cabeza != null) {
            if (cabeza == cola && dato.equals(cabeza.getDato())) {
                cabeza = cola = null;
                borrado = true;
                longitud--;
            } else if (dato.equals(cabeza.getDato())) {
                cabeza = cabeza.getSiguiente();
                borrado = true;
                longitud--;
            } else {
                Nodo<E> prd, tmp;
                for (prd = cabeza, tmp = cabeza.getSiguiente(); tmp != null
                        && !tmp.getDato().equals(dato); prd = prd.getSiguiente(), tmp = tmp.getSiguiente())
                    ;
                if (tmp != null) {
                    borrado = true;
                    longitud--;
                    prd.setSiguiente(tmp.getSiguiente());
                    if (tmp == cola) {
                        cola = prd;
                    }
                }
            }
        }
        return borrado;
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
        if (cabeza != null) {
            if (cabeza == cola) {
                cabeza = cola = null;
                longitud--;
            } else {
                cabeza = cabeza.getSiguiente();
                longitud--;
            }
        }
    }

    @SuppressWarnings("unused")
    public void eliminarEnCola() {
        if (cabeza != null) {
            if (cabeza == cola) {
                cabeza = cola = null;
                longitud--;
            } else {
                Nodo<E> prd, tmp;
                for (prd = cabeza, tmp = cabeza.getSiguiente(); tmp != null; prd = prd.getSiguiente(), tmp = tmp
                        .getSiguiente())
                    ;
                if (tmp != null) {
                    if (prd == cabeza) {
                        cabeza.setSiguiente(null);
                        cola = cabeza;
                    } else {
                        prd.setSiguiente(null);
                        cola = prd;
                    }
                }
            }
        }
    }

    public E obtenerNodo(int indice) {
        Nodo<E> tmp = null;
        if (indice >= 0 && indice <= longitud - 1) {
            tmp = cabeza;
            for (int contador = 0; contador < indice && tmp != null; contador++, tmp = tmp.getSiguiente())
                ;
        }
        return tmp != null ? tmp.getDato() : null;
    }

    public int estaEnLista(E dato) {
        int indice = 0;
        Nodo<E> tmp = cabeza;
        while (tmp != null) {
            if (tmp.getDato().equals(dato)) {
                return indice;
            }
            indice++;
            tmp = tmp.getSiguiente();
        }
        return -1;
    }

    public boolean eliminarEnIndice(int indice) {
        boolean borrado = false;
        if (indice >= 0 && indice <= longitud - 1 && cabeza != null) {
            if (cabeza == cola && indice == 0) {
                cabeza = cola = null;
                borrado = true;
                longitud--;
            } else if (indice == 0) {
                cabeza = cabeza.getSiguiente();
                borrado = true;
                longitud--;
            } else {
                Nodo<E> prd, tmp;
                int contador = 1;
                for (prd = cabeza, tmp = cabeza.getSiguiente(); contador < indice; prd = prd
                        .getSiguiente(), tmp = tmp.getSiguiente(), contador++)
                    ;
                if (tmp != null) {
                    borrado = true;
                    longitud--;
                    prd.setSiguiente(tmp.getSiguiente());
                    if (tmp == cola) {
                        cola = prd;
                    }
                }
            }
        }
        return borrado;
    }

    public boolean insertarEnIndice(E dato, int indice) {
        boolean seInserto = false;
        if (indice >= 0 && indice <= longitud) {
            if (indice == 0) {
                this.agregarEnCabeza(dato);
                seInserto = true;
            } else if (indice == longitud) {
                this.agregarEnCola(dato);
                seInserto = true;
            } else {
                Nodo<E> prv = null, tmp = cabeza;
                int contador = 0;
                for (; contador < indice; contador++, prv = tmp, tmp = tmp.getSiguiente())
                    ;
                prv.setSiguiente(new Nodo<E>(dato, tmp));
                longitud++;
                seInserto = true;
            }
        }
        return seInserto;
    }

    public boolean asignar(E dato, int indice) {
        Nodo<E> tmp = null;
        if (indice >= 0 && indice <= longitud - 1) {
            tmp = cabeza;
            for (int contador = 0; contador < indice && tmp != null; contador++, tmp = tmp.getSiguiente())
                ;
        }
        if (tmp != null) {
            tmp.setDato(dato);
            return true;
        } else {
            return false;
        }
    }

    public void asignar(E dato, E nuevoDato, boolean todos) {
        Nodo<E> tmp = null;
        if (!todos) {
            for (tmp = cabeza; tmp != null; tmp = tmp.getSiguiente()) {
                if (tmp.getDato().equals(dato)) {
                    tmp.setDato(nuevoDato);
                    return;
                }
            }
        } else {
            for (tmp = cabeza; tmp != null; tmp = tmp.getSiguiente()) {
                if (tmp.getDato().equals(dato)) {
                    tmp.setDato(nuevoDato);
                }
            }
        }
    }


    public void setIndice(E dato, int indiceUsuario) {
        int indice = 0;
        if (indiceUsuario >= 0 && indiceUsuario <= longitud - 1) {
            for (Nodo<E> tmp = cabeza; tmp != null; tmp = tmp.getSiguiente()) {
                if (indice == indiceUsuario) {
                    tmp.setDato(dato);
                    break;
                }
                indice++;
            }
        } else {
            System.out.println("Indice fuera del rango");
        }
    }


    public E getIndice(int indiceUsuario) {
        int indice = 0;
        E valor = null;
        if (indiceUsuario >= 0 && indiceUsuario <= longitud - 1) {
            for (Nodo<E> tmp = cabeza; tmp != null; tmp = tmp.getSiguiente()) {
                if (indice == indiceUsuario) {
                    valor = tmp.getDato();
                    break;
                }
                indice++;
            }
        } else {
            System.out.println("Indice fuera del rango");
        }
        return valor;
    }
}
