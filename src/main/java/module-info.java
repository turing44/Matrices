module org.example.matrices {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.matrices to javafx.fxml;
    exports org.example.matrices;
}