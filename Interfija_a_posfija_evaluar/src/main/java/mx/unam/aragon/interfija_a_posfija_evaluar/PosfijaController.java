package mx.unam.aragon.interfija_a_posfija_evaluar;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mx.unam.aragon.interfija_a_posfija_evaluar.modelo.Evaluador;

public class PosfijaController {

    @FXML private TextField txtPosfija;
    @FXML private Label lblResultado;
    @FXML private Button btnEvaluar;

    @FXML
    private void initialize() {
        btnEvaluar.setOnAction(e -> {
            String expresion = txtPosfija.getText();
            double resultado = Evaluador.evaluarPosfija(expresion);
            lblResultado.setText("Resultado: " + resultado);
        });
    }
}