package GUI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void searchclick(ActionEvent actionEvent) {
    }
}
