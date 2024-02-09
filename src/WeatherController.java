import com.sun.tools.javac.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.simple.JSONObject;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class WeatherController implements Initializable {


    public TextField searchbar;
    public ImageView weatherimage;
    public Label degreeslbl;
    public ImageView windimage;
    public Label conditionlbl;
    public ImageView humiimage;
    public Label humdata;
    public Label winddata;
    public Label citylbl;
    public ImageView searchimage;
    private JSONObject weatherData;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }


    public void searchclick(ActionEvent actionEvent) {
        String usercountry = searchbar.getText();
        citylbl.setText(usercountry);

        if(usercountry.replaceAll("\\s", "").length() <= 0){
            return;
        }

        weatherData = API.getWeatherData(usercountry);


        String weatherCondition = (String) weatherData.get("weather_condition");

        // depending on the condition, we will update the weather image that corresponds with the condition
        switch(weatherCondition){
            case "Clear":
                File file = new File("src/GUI/Images/clear.png");
                Image image1 = new Image(file.toURI().toString());
                weatherimage.setImage(image1);
                break;
            case "Cloudy":
                File file2 = new File("src/GUI/Images/cloudy.png");
                Image image2 = new Image(file2.toURI().toString());
                weatherimage.setImage(image2);
                break;
            case "Rain":
                File file3 = new File("src/GUI/Images/rain.png");
                Image image3 = new Image(file3.toURI().toString());
                weatherimage.setImage(image3);
                break;
            case "Snow":
                File file4 = new File("src/GUI/Images/snow.png");
                Image image4 = new Image(file4.toURI().toString());
                weatherimage.setImage(image4);
                break;
        }

        // update temperature text
        double temperature = (double) weatherData.get("temperature");
        degreeslbl.setText(temperature + " °C");

        // update weather condition text
        conditionlbl.setText(weatherCondition);

        // update humidity text
        long humidity = (long) weatherData.get("humidity");
        humdata.setText(humidity + "%" );

        // update windspeed text
        double windspeed = (double) weatherData.get("windspeed");
        winddata.setText(windspeed + "km/h");
    }
}

