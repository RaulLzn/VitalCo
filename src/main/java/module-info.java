module juli.vitalco {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires jdk.jfr;
    requires static lombok;
    requires com.google.gson;
    requires java.logging;
    requires javafx.base;

    opens juli.vitalco to javafx.fxml, com.google.gson;
    exports juli.vitalco;

    opens juli.vitalco.model.crud.shared to com.google.gson;
    exports juli.vitalco.model.crud.shared;

    opens juli.vitalco.model.crud.repository to com.google.gson;
    exports juli.vitalco.model.crud.repository;

    opens juli.vitalco.model.domain to com.google.gson;
    exports juli.vitalco.model.domain;

    opens juli.vitalco.Pruebas to com.google.gson;
    exports juli.vitalco.Pruebas;

    exports juli.vitalco.controller to com.google.gson;

    opens juli.vitalco.controller to javafx.fxml;

    opens juli.vitalco.misEstructuras to com.google.gson;
    exports juli.vitalco.misEstructuras;

}