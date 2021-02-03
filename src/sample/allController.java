package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


public class allController {
    @FXML
    ListView<String> lv;
    @FXML
    TextField screen;
    @FXML
    ChoiceBox<String> sort;

    String[] choices = {"Month", "Price", "Expense"};

   public Profile profile;



    public void initialize(){
        for(String i:choices){
            sort.getItems().add(i);
        }
        sort.setOnAction((Action) -> {
            String selected = sort.getSelectionModel().getSelectedItem();
            if (selected.equals("Month")) {
                lv.getItems().clear();
                lv.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
                lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            } else if (selected.equals("Price")) {
                lv.getItems().clear();
                lv.getItems().addAll("100,000", "50,000", "75,000", "10,000", "5,000", "1,000", "500", "300");
                lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            } else if (selected.equals("Expense")) {

            } else {
                lv.getItems().clear();
                lv.getItems().add("None");
                lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            }
        });
    }

    public void displaySelected(){
        //For showing the expenses
    }

//    public void clickBubbleSort()
//    {
//        boolean swapped = true;
//        int a;
//        int b = 0;
//        StackPane tmp;
//        while (swapped)
//        {
//            swapped = false;
//            b++;
//            for (a = 0; a < stackPane.length - b; a++)
//            {
//                if (getNum(getText(stackPane[a]).getText()) > getNum(getText(stackPane[a+1]).getText()))
//                {
//                    swapPanes(stackPane[a], stackPane[a+1]);
//                    tmp = stackPane[a];
//                    stackPane[a] = stackPane[a + 1];
//                    stackPane[a + 1] = tmp;
//                    swapped = true;
//                }
//            }
//        }
//    }




    public void goBack() throws IOException {
        Main app = new Main();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainMenu.fxml"));
        app.setRoot(loader.load());
    }
}
