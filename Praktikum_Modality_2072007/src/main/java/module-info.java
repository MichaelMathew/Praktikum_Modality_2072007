module com.example.praktikum_modality_2072007 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.praktikum_modality_2072007 to javafx.fxml;
    exports com.example.praktikum_modality_2072007;
    exports com.example.praktikum_modality_2072007.model;
    exports com.example.praktikum_modality_2072007.Controller;
}