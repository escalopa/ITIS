module com.example.lab02 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires lombok;
    requires com.example.lab01;

    opens com.example.lab02 to javafx.fxml;
    exports com.example.lab02;
    exports com.example.lab02.services;
    exports com.example.lab02.models;
    exports com.example.lab02.controllers;
    opens com.example.lab02.controllers to javafx.fxml;
    opens com.example.lab02.services to javafx.fxml;
    exports com.example.lab02.utils;
    opens com.example.lab02.utils to javafx.fxml;

}