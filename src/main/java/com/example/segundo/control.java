package com.example.segundo;

import fes.aragon.pila.PilaH;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


public class control extends PilaH {
    @FXML
    private Label welcomeText;
    @FXML
    private TextArea textArea;
    @FXML
    private Label alerta;
    @FXML
    protected void onHelloButtonClick() {
        int[] cierre= new int[100],abertura= new int[100];
        alerta.setText("");
        String textos = textArea.getText();
        int posul;
        int longitud = textos.length();
        for (int i = 0; i < longitud; i++) {
            insertar(textos.charAt(i));
        }
        posul=ultimapos();
        vincular(posul);

        StringBuffer sb=new StringBuffer();
        String[] mostrar=new String[longitud()];
          for (int i = longitud()-1; i>=0; i--) {
              mostrar[i]=String.valueOf(recuperar(i));
              sb.append(mostrar[i]);
          }
          welcomeText.setText(sb.toString());
          borrar();
    }
    public int valormaximo(){
        String dato=")";
        int contador=0,contador2=0;
        String dato2;

        for (int p=longitud()-1; p>=0; p--){                                 //inversa del ultimo al primero
            dato2= String.valueOf(recuperar(p));
            if ("(".equals(dato2)) {
                contador++;
            }
        }
        for (int p=0;p<longitud();p++){
            dato2= String.valueOf(recuperar(p));
            if (")".equals(dato2)) {
                contador2++;
            }
        }
        if(contador2==contador){
            return contador;
        }
        else{
            alerta.setText("no hay suficientes parentesis en pareja");
            return 0;
        }

    }
    public int ultimapos(){
        String dato=")";
        int contador=0,pos=0,contador2=0;
        String dato2;
        for(int l=0; l< longitud(); l++){                                     //del primero al ultimo
            dato2= String.valueOf(recuperar(l));
            if(dato.equals(dato2) && contador2==0){
                pos=l;
                contador2++;
            }
        }
        return pos;
    }
    public void vincular(int pos) {
        int[] cierre = new int[100], abertura = new int[100];
        int contador = 0;
        String dato = ")";
        String dato2;
        for (int l = longitud()-1; l >=0; l--) {                                     //del primero al ultimo
            dato2 = String.valueOf(recuperar(l));
            if (dato.equals(dato2) && l!=pos) {
                cierre[contador-1] = l;
            } else if ("(".equals(dato2)) {
                abertura[contador]=l;
                contador++;
            }
            else if(dato.equals(dato2) && pos==l){
                cierre[0]=l;
            }
        }
        acomoda(cierre,abertura,pos);
    }
    public void acomoda(int[] cierre,int[] abertura,int pos) {
        for(int i= valormaximo()-1; i>=0; i--){
            int aux=0;
            String temp;
            int aux2=1;
            for (int k= cierre[i]; cierre[i]+aux2<abertura[i]-aux2; k++){
                aux=abertura[i]-aux2;
                temp= String.valueOf(recuperar(aux));
                asignar(String.valueOf(recuperar(k+1)), aux);
                asignar(String.valueOf(temp), k+1);
                aux2++;
            }
            elimina(abertura[i]);
            elimina(cierre[i]);
            int  contador = 0;
            String dato = ")";
            String dato2;
            for (int l = longitud()-1; l >=0; l--) {                                     //del primero al ultimo
                dato2 = String.valueOf(recuperar(l));
                if (dato.equals(dato2) && l!=pos) {
                    cierre[contador-1] = l;
                } else if ("(".equals(dato2)) {
                    abertura[contador]=l;
                    contador++;
                }
                else if(dato.equals(dato2) && pos==l){
                    cierre[0]=l;
                }
            }
        }
    }
}
