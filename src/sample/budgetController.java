package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class budgetController {
    @FXML
    ListView lv;
    @FXML
    TextField budget;
    @FXML
    Button remove,confirm,back;
    @FXML
    Text bon,bn;
    @FXML
    ChoiceBox<String> choiceBox;

    String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
    String[][] testArray = {{"0","1"},{"2","3"},{"1","3"},{"5","3"},{"3","3"},{"6","7"},{"3","1"},{"346","23"},{"214","323"},{"12421","421"},{"1241","123"},{"123","123"}};
    String[] budgets;

    public void initialize() throws IOException {
        BufferedReader userRead = new BufferedReader(new FileReader("src\\sample\\monthlyBudgets.txt"));
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
        String[] values = testArray[choiceBox.getSelectionModel().getSelectedIndex()];
        lv.getItems().clear();
        for(int i = 0; i < values.length; i++){
            lv.getItems().add(values[i]);
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

    public void select(){
        remove.setDisable(false);
    }
}