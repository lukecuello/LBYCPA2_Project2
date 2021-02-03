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
import java.awt.event.MouseEvent;
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
    String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    String[] prices = {"100,000","75,000", "50,000","25,000", "10,000", "5,000", "1,000", "500", "300"};
    String[] expense = {"Electricity", "Water", "Groceries", "Tax", "Insurance"};

   public Profile profile;



    public void initialize(){
        for(String i:choices){
            sort.getItems().add(i);
        }
        sort.setOnAction((Action) -> {
            String selected = sort.getSelectionModel().getSelectedItem();
            if (selected.equals("Month")) {
                lv.getItems().clear();
                lv.getItems().addAll(months);
                lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            } else if (selected.equals("Price")) {
                lv.getItems().clear();
                lv.getItems().addAll(prices);
                lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            } else if (selected.equals("Expense")) {
                lv.getItems().clear();
                lv.getItems().addAll(expense);
                lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            } else {
                lv.getItems().clear();
                lv.getItems().add("None");
                lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            }
        });
    }

    public void displaySelected(){
       String selected = lv.getSelectionModel().getSelectedItem();
       for(int i =0; i < months.length;i++){
           if(selected.equals(months[i]) || selected.equals(expense[i])){
               lv.setOnContextMenuRequested(e -> perMonth());
           }
           else if(selected.equals(prices[i])){
               lv.setOnContextMenuRequested(e -> expenseBubbleSort());
           }
           else{
               continue;
           }
       }

    }

    public void perMonth(){

    }

    public void expenseBubbleSort()
    {
        boolean swapped = true;
        int a;
        int b = 0;
        StackPane tmp;
        while (swapped)
        {
            swapped = false;
            b++;
            for (a = 0; a < stackPane.length - b; a++)
            {
                if (getNum(getText(stackPane[a]).getText()) > getNum(getText(stackPane[a+1]).getText()))
                {
                    swapPanes(stackPane[a], stackPane[a+1]);
                    tmp = stackPane[a];
                    stackPane[a] = stackPane[a + 1];
                    stackPane[a + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }




    public void goBack() throws IOException {
        Main app = new Main();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainMenu.fxml"));
        app.setRoot(loader.load());
    }
}
