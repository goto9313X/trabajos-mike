module com.example.segundo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires Herramientaskit;
    requires java.management;
    requires java.desktop;

    opens com.example.segundo to javafx.fxml;
    exports com.example.segundo;
}
