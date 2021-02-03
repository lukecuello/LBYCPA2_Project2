package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
import java.util.*;


public class allController {
    @FXML
    ListView<String> lv, screen;
    @FXML
    ChoiceBox<String> sort;

    String[] choices = {"Month", "Price", "Expense"};
    String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    String[] prices = {"100000","75000", "50000","25000", "10000", "5000", "2500","1000", "500"};
    String[] expense = {"Electricity", "Water", "Groceries", "Tax", "Insurance", "Food", "Luxury", "Apparel","Miscellaneous"};


   HashMap<String, LinkedList<ArrayList<String>>> adjList;
   LinkedList<ArrayList<String>> node;



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
           if(selected.equals(months[i])){
               sortByInstance(selected);
           }
       }
       for(int j=0; j<expense.length;j++){
           if(selected.equalsIgnoreCase(expense[j])){
               lv.setOnMouseClicked(e -> sortByExpense(selected));
           }
       }
       for(int k=0;k<prices.length;k++){
           if(selected.equals(prices[k])){
               lv.setOnMouseClicked(e -> expenseQuickSort(selected));
           }
       }


    }

    public void sortByExpense(String expense){
//        lv.getSelectionModel().selectedItemProperty().addListener((Action) ->{
//            ArrayList<String> expenses = node.element(expense);
//            LinkedList<ArrayList<String>> edge = adjList.get(months);
//            for(ArrayList<String> i: edge){
//                String sorted = i.toString();
//                screen.getItems().add(sorted);
//            }
//            screen.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//
//        });
    }

    public void sortByInstance(String month){
        screen.getItems().clear();
        LinkedList<ArrayList<String>> edge = adjList.get(month);
        if(edge!=null) {
            for (ArrayList<String> i : edge) {
                String sorted = i.toString();
                screen.getItems().add(sorted);
            }
        }
        screen.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }

    public void expenseQuickSort(String amount)
    {
//        int expense=Integer.parseInt(amount);
//        lv.getSelectionModel().selectedItemProperty().addListener((Action) ->{
//            ArrayList<String> expenses = node.element(expense);
//            LinkedList<ArrayList<String>> edge = adjList.get(months);
//            for(ArrayList<String> i: edge){
//               for(Iterator<String> it = expenses.iterator();it.hasNext();){
//                   Collections.sort(expenses);
//               }
//            }
//            screen.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//
//        });
    }

    public void setMap(HashMap<String,LinkedList<ArrayList<String>>> map){
        this.adjList = map;
    }



    public void goBack() throws IOException {
        Parent root = null;
        Main app = new Main();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainMenu.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        menuController setter = loader.getController();
        setter.setMap(adjList);
        app.setRoot(root);
    }
}
