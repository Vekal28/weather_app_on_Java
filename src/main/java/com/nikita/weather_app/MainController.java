package com.nikita.weather_app;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.json.JSONObject;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Town;

    @FXML
    private Button btn;

    @FXML
    private Text pressure;

    @FXML
    private Text temp;

    @FXML
    private Text temp_os;

    @FXML
    private Text tempmax;

    @FXML
    private Text tempmin;

    @FXML
    void initialize() {
        btn.setOnAction(e -> {
            //btn.setText("Результат");
            String town = Town.getText();
            //System.out.println(town);
            Requests weather = new Requests();
            String key = "38f8bd22606860d976e5dd9f30c5f9cc";
            String urlAdress = "https://api.openweathermap.org/data/2.5/weather?q=" + town + "&units=metric&lang=ru&appid=" + key;
            String output = weather.get_wether(urlAdress);
            if(!output.isEmpty()){
                JSONObject obj = new JSONObject(output);
                temp.setText("ТЕМПЕРАТУРА: " + obj.getJSONObject("main").getDouble("temp") + "°C");
                
                temp_os.setText("ОЩУЩАЕТСЯ: " + obj.getJSONObject("main").getDouble("feels_like") + "°C");
                tempmax.setText("МАКСИМУМ: " + obj.getJSONObject("main").getDouble("temp_max") + "°C");
                tempmin.setText("МИНИМУМ: " + obj.getJSONObject("main").getDouble("temp_min") + "°C");
                pressure.setText("ДАВЛЕНИЕ: " + obj.getJSONObject("main").getDouble("pressure") + " мм рт");
                Town.setText("");
                /*System.out.println("ТЕМПЕРАТУРА: " + String.valueOf(obj.getJSONObject("main").getDouble("temp")) + "°C");
                System.out.println("ОЩУЩАЕТСЯ: " + String.valueOf(obj.getJSONObject("main").getDouble("feels_like")));
                System.out.println("МАКСИМАЛЬНАЯ: " + String.valueOf(obj.getJSONObject("main").getDouble("temp_max")));
                System.out.println("МИНИМАЛЬНАЯ: " + String.valueOf(obj.getJSONObject("main").getDouble("temp_min")));
                System.out.println("ДАВЛЕНИЕ: " + String.valueOf(obj.getJSONObject("main").getDouble("pressure")));*/
            }
        });
    }

}
