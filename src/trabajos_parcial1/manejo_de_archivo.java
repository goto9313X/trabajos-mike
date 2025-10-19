package trabajos_parcial1;
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
                //System.out.println("la longitud es "+longitud);
                for(i=0; i<longitud; i++) {
                    numeros[cuenta][i] = Integer.parseInt(datos[i]);

                }
                cuenta++;

            }
            acomodar(numeros,cuenta,i);
            in.close();
            System.out.println("se encontro el archivo");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public static void acomodar(int[][] a, int n1,int n2) {
        //System.out.println(n1);
        int i=0;
        for(int t=0; t<n1; t++) {
            for (int k = 0; k < n1; k++) {
                for (int j = 0; j < n1; j++) {
                    for (i = 0; i < n2 - 1; i++) {
                        if (a[j][i] > a[j][i + 1]) {
                            int temp = a[j][i];
                            a[j][i] = a[j][i + 1];
                            a[j][i + 1] = temp;
                            //  System.out.println("\n"+temp+"anterior "+a[j][i]+" posterior"+ a[j][i+1]);
                        }

                        //System.out.println("\n");
                    }
                    if (j + 1 < n1) {
                        if (a[j][i] > a[j + 1][0]) {
                            int temp = a[j + 1][0];
                            a[j + 1][0] = a[j][i];
                            a[j][i] = temp;
                            //System.out.println("temporal"+temp+"anterior "+a[j][i]+" posterior"+ a[j+1][0]);
                            //System.out.println("pasa por aqui");
                        }
                    }

                }
            }
        }
        repeticiones(a,n1,n2);
       double ressultado=promedio(a,n1,n2);
        System.out.println("el promedio es:"+ressultado);
    }
    public static void repeticiones(int[][] a,int n1,int n2) {
        int[] promedio= new int[100];
        int[] numero= new int[100];
        for(int numerob=0;numerob<100;numerob++){
            for (int k = 0; k < n1; k++) {
                for (int l = 0; l < n2; l++) {
                 if(numerob+1==a[k][l]){
                     promedio[numerob]++;
                     numero[numerob]=a[k][l];
                 }
                }
            }
        }
        for (int i=0;i<100;i++){
            System.out.println("numero: "+numero[i]+" se repite; "+promedio[i]);
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
