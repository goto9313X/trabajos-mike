package mx.unam.aragon.interfija_a_posfija_evaluar;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mx.unam.aragon.interfija_a_posfija_evaluar.modelo.Convertidor;

public class ConvertidorController {

    @FXML private TextField txtInfija;
    @FXML private Label lblPosfija;
    @FXML private Button btnConvertir;

    @FXML
    private void initialize() {
        btnConvertir.setOnAction(e -> {
            String expresion = txtInfija.getText();
            if (expresion.isEmpty()) {
                lblPosfija.setText("Por favor ingresa una expresión");
                return;
            }
            String resultado = Convertidor.convertirInfijaAPosfija(expresion);
            lblPosfija.setText("Posfija: " + resultado);
        });
    }
}