package fes.aragon.utilerias.dinamicas.listasimple;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class manejo_de_archivo {
    public static void leerArchivo(String Narchivo) {
        File archi = new File(Narchivo);
        int[][] numeros= new int[100][100];
        int i=0;
        try{
            BufferedReader in = new BufferedReader(new FileReader(archi));
            String cadena;
            int cuenta = 0;
            while((cadena= in.readLine())!=null){
                String[] datos = cadena.split(",");
                int longitud = datos.length;
                for(i=0; i<longitud; i++) {
                    numeros[cuenta][i] = Integer.parseInt(datos[i]);

                }
                cuenta++;

            }
            double valorTotal = promedio(numeros,cuenta,i);
            System.out.println("el promedio es: "+valorTotal);
            in.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public static double promedio(int[][] a, int n1, int n2){
        double promedio=0;
        for (int k = 0; k < n1; k++) {
            for (int l = 0; l < n2; l++) {
                promedio+=a[k][l];
            }
        }
        promedio=promedio/(n2*n1);
        return promedio;
    }
}
