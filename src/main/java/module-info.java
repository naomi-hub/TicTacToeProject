module com.example.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires org.testng;
    requires org.junit.jupiter.api;

    opens com.example.tictactoe to javafx.fxml;
    exports com.example.tictactoe;
}