module com.example.mojara {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.mojara to javafx.fxml;
    exports com.example.mojara;
    opens modelos;
}