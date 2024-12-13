module org.example.devoirblanc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    exports org.example.devoirblanc.View;
    exports org.example.devoirblanc.Model;
    exports org.example.devoirblanc.Dao;
    exports org.example.devoirblanc.DaoImpl;
    opens org.example.devoirblanc to javafx.fxml;
    exports org.example.devoirblanc;
}