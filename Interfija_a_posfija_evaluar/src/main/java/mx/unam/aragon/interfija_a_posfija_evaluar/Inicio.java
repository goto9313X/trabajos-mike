package mx.unam.aragon.interfija_a_posfija_evaluar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Inicio extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Ventana 1: Convertidor Infija → Posfija
        Parent root1 = FXMLLoader.load(getClass().getResource("/mx/unam/aragon/interfija_a_posfija_evaluar/convertidor.fxml"));
        Stage ventanaConvertidor = new Stage();
        ventanaConvertidor.setTitle("Conversión Infija → Posfija");
        ventanaConvertidor.setScene(new Scene(root1, 400, 250));
        ventanaConvertidor.show();

        // Ventana 2: Evaluar Posfija
        Parent root2 = FXMLLoader.load(getClass().getResource("/mx/unam/aragon/interfija_a_posfija_evaluar/posfija.fxml"));
        Stage ventanaEvaluador = new Stage();
        ventanaEvaluador.setTitle("Evaluar Expresión Posfija");
        ventanaEvaluador.setScene(new Scene(root2, 400, 250));
        ventanaEvaluador.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}