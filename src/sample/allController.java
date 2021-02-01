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
        for(int i = 0; i < 20; i++){
            lv.getItems().add("woop");
        }
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
