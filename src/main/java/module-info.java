module com.example.demoproj {
    requires javafx.controls;
    requires javafx.fxml;


    opens proj.ContactBook to javafx.fxml;
    exports proj.ContactBook;
}