package fes.aragon.utilerias.dinamicas.listasimple;

public interface funciones {
    public void insertar(Object valor, Object[] l); //Objet[] l es un arreglo que se solicita
    public int localiza(int pos, Object[] l); //pos es la posicion que se solicita
    public Object recuperar(int pos, Object[] l); //valor es un dato solicitado
    public void suprimir (int pos, Object[] l);
    public Object siguiente (int pos, Object[] l);
    public Object anterior (int pos, Object[] l);
    public void limpiar(Object[] l);
    public Object primero (Object[] l);
    public void imprime (Object[] l);
    public void asignar(int pos,Object valor);
}
