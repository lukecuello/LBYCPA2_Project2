package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;


public class allController {
    @FXML
    ListView<String> lv;
    @FXML
    TextField screen;

    public void initialize(){
        lv.getItems().add("January");
        lv.getItems().add("February");
        lv.getItems().add("March");
        lv.getItems().add("April");
        lv.getItems().add("May");
        lv.getItems().add("June");
        lv.getItems().add("July");
        lv.getItems().add("August");
        lv.getItems().add("September");
        lv.getItems().add("October");
        lv.getItems().add("November");
        lv.getItems().add("December");
    }

    public void displaySelected(){
        String selected = lv.getSelectionModel().getSelectedItem();
        if(selected.equals("woop")){
            screen.setText("HAHAHAH");
        }
    }

    public void goBack() throws IOException {
        Main app = new Main();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainMenu.fxml"));
        app.setRoot(loader.load());
    }
}
