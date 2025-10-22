module com.example.ejercicio_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens fes.aragon.unam.mx.ejercicio_1_2 to javafx.fxml;
    exports fes.aragon.unam.mx.ejercicio_1_2;
}