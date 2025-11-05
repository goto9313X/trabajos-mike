module mx.unam.aragon.interfija_a_posfija_evaluar {
    requires javafx.controls;
    requires javafx.fxml;


    opens mx.unam.aragon.interfija_a_posfija_evaluar to javafx.fxml;
    exports mx.unam.aragon.interfija_a_posfija_evaluar;
}