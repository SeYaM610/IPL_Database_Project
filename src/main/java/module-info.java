module com.example.playerdatabase {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;
    requires java.net.http;

    opens com.example.playerdatabase to javafx.fxml;
    exports com.example.playerdatabase;
//    opens com.example.playerdatabase.client to javafx.fxml;
//    opens com.example.playerdatabase.Controllers to javafx.fxml;
}