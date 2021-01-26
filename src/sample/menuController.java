package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;


public class menuController{

    LinkedList<FXMLLoader> llist = new LinkedList<>();
    public Button button;

    public void initialize(){
        FXMLLoader todo = new FXMLLoader(getClass().getResource("todo.fxml"));
        FXMLLoader expensesPaid = new FXMLLoader(getClass().getResource("expenses.fxml"));
        FXMLLoader monthly = new FXMLLoader(getClass().getResource("monthly.fxml"));


        llist.add(todo);
        llist.add(monthly);
    }

    public void button1(ActionEvent event){
        FXMLLoader loader = (FXMLLoader) llist.get(0);
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = (Stage) button.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void button3(ActionEvent event){
        FXMLLoader loader = (FXMLLoader) llist.get(1);
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = (Stage) button.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
