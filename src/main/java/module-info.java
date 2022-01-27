module com.nikita.weather_app {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;


    opens com.nikita.weather_app to javafx.fxml;
    exports com.nikita.weather_app;
}