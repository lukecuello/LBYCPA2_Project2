package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class budgetController {
    @FXML
    ListView lv;
    @FXML
    TextField budget;
    @FXML
    Button remove,confirm,back;
    @FXML
    Text bon,bn,errorTxt;
    @FXML
    ChoiceBox<String> choiceBox;

    HashMap<String,LinkedList<ArrayList<String>>> adjList;
    String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
    String[] budgets;

    public void initialize() throws IOException {
        BufferedReader userRead = new BufferedReader(new FileReader("src/sample/monthlyBudgets.txt"));
        String line = userRead.readLine();
        budgets = line.split("\\|");

        for(int i = 0; i<months.length;i++) {
            choiceBox.getItems().add(months[i]);
        }
        choiceBox.setOnAction((Action) ->{
            if(!budgets[choiceBox.getSelectionModel().getSelectedIndex()].equals("0")) {
                bon.setText(budgets[choiceBox.getSelectionModel().getSelectedIndex()]);
            }else{
                bon.setText("--");
            }
            printtoLV();
        });
    }

    public void printtoLV(){
        int budget = 0;
        System.out.println(adjList.keySet());
        lv.getItems().clear();
        String selected = choiceBox.getSelectionModel().getSelectedItem();
        System.out.println(adjList.keySet());
        System.out.println(adjList.get(selected));
        LinkedList<ArrayList<String>> edge = adjList.get(selected);
        for (ArrayList<String> i : edge) {
            String td;
            td = i.get(0) + "\t\t\t" + "Php"+i.get(1);
            budget += Integer.parseInt(i.get(1));
            lv.getItems().add(td);
        }
        bn.setText(String.valueOf(budget));
        if(Integer.parseInt(budgets[choiceBox.getSelectionModel().getSelectedIndex()]) < Integer.parseInt(bn.getText())){
            errorTxt.setVisible(true);
        }
    }

    public void conf() throws IOException {
        String bInput = budget.getText();
        int updated = Integer.parseInt(budgets[choiceBox.getSelectionModel().getSelectedIndex()]) + Integer.parseInt(bInput);
        budgets[choiceBox.getSelectionModel().getSelectedIndex()] = String.valueOf(updated);
        updateBudgets();
    }

    private void updateBudgets() throws IOException{
        FileWriter text = new FileWriter("src\\sample\\monthlyBudgets.txt");
        FileWriter update = new FileWriter("src\\sample\\monthlyBudgets.txt",true);
        text.write("");
        text.close();
        for(String i:budgets){
            update.append(i+"|");
        }
        update.close();
        bon.setText(budgets[choiceBox.getSelectionModel().getSelectedIndex()]);
    }

    public void setMap(HashMap<String,LinkedList<ArrayList<String>>> map){
       this.adjList = map;
    }

    public void select(){
        remove.setDisable(false);
    }

    public void goBack() {
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