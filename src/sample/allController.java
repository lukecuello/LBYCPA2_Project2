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
import javafx.scene.text.Text;

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
    @FXML
    Text money;


    Stack<Integer> stack = new Stack<>();
    String[] choices = {"Month", "Price", "Expense"};
    String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    String[] prices = {"100000","75000", "56250","42180", "31640", "23730", "17790","13340", "10000","7500","5620","4210","3160","2370","1780","1330","1000","750","560","420","310","230","170","50"};
    String[] expense = {"Electricity", "Water", "Groceries", "Tax", "Insurance", "Food", "Luxury", "Apparel","Gasoline","Internet", "Miscellaneous"};


   HashMap<String, LinkedList<ArrayList<String>>> adjList;
   ArrayList<Integer> paymentz;


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
           if(selected.equals(expense[j])){
               sortByExpense(selected);
           }
       }
       for(int k=0;k<prices.length;k++){
           if(selected.equals(prices[k])){
               expenseSelSort(selected);
           }
       }


    }

    public void sortByExpense(String expense){
        stack.removeAllElements();
        Integer total=0;
        String stotal;
        screen.getItems().clear();

        adjList.forEach((key,value)->{
                LinkedList<ArrayList<String>> llist = adjList.get(key);
                for(int i = 0; i<llist.size(); i++){
                    ArrayList<String> expenses = llist.get(i);
                    if(expenses.get(0).equals(expense)){
                        screen.getItems().add(expenses.toString() + "   " + key);
                        String s = expenses.get(1);
                        stack.push(Integer.parseInt(s));
                        System.out.println(stack.size());
                    }
                }
        });

        for(int i=0; i<=stack.size(); i++){
            Integer top = stack.peek();
            stack.pop();
            total = total + top;
        }
        stotal = Integer.toString(total);
        String totals = "PHP" + stotal;
        screen.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        money.setText(totals);

    }


    public void sortByInstance(String month){
        Integer total=0;
        String stotal;
        screen.getItems().clear();

        LinkedList<ArrayList<String>> edge = adjList.get(month);

        if(edge!=null) {
            for (int j = 0; j<edge.size(); j++) {
                ArrayList<String> i = edge.get(j);
                String sorted = i.toString();
                screen.getItems().add(sorted);
                String s = i.get(1);
                stack.push(Integer.parseInt(s));
            }
        }
        for(int i=0; i<=stack.size(); i++){
            Integer top = stack.peek();
            total = total + top;
            stack.pop();
        }
        stotal = Integer.toString(total);
        String totals = "PHP" + stotal;
        screen.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        money.setText(totals);
    }

    public void expenseSelSort(String amount)
    {
        stack.removeAllElements();
        int p = Integer.parseInt(amount);
        Integer total=0;
        String stotal;
        screen.getItems().clear();

        adjList.forEach((key,value)->{
                LinkedList<ArrayList<String>> llist = adjList.get(key);
                for(int i = 0; i<llist.size(); i++){
                    ArrayList<String> expenses = llist.get(i);
                    int price = Integer.parseInt(expenses.get(1));
                    if((price >= p) && (price < (p*4/3)) ){
                        screen.getItems().add(expenses.toString() + "   " + key);
                        String s = expenses.get(1);
                        stack.push(Integer.parseInt(s));
                    }
                }
        });

        for(int i=0; i<=stack.size(); i++){
            Integer top = stack.peek();
            stack.pop();
            total = total + top;
        }
        stotal = Integer.toString(total);
        String totals = "PHP" + stotal;
        screen.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        money.setText(totals);
    }

    public void setMap(HashMap<String,LinkedList<ArrayList<String>>> map){
        this.adjList = map;
    }

    public void setArray(ArrayList<Integer> array){this.paymentz = array;}



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
        setter.setArray(paymentz);
        app.setRoot(root);
    }
}
