package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;


public class allController {
    @FXML
    ListView<String> lv;
    @FXML
    TextField screen;
    @FXML
    ChoiceBox<String> sort;

    String[] choices = {"Month", "Price", "Expense"};


    public void sortBy(){
        for(int i = 0; i<choices.length;i++){
            sort.getItems().add(choices[i]);
        }
    }
    public void initialize(){
       //Sorting algorithm to be displayed on the List View
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
