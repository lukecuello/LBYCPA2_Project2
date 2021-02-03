package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


public class menuController{
    Main app = new Main();
    LinkedList<FXMLLoader> llist = new LinkedList<>();
    ArrayList<Integer> payments;
    HashMap<String,LinkedList<ArrayList<String>>> adjList;

    public void initialize(){
        FXMLLoader todo = new FXMLLoader(getClass().getResource("todo.fxml"));
        FXMLLoader budgetTracker = new FXMLLoader(getClass().getResource("budgetTracker.fxml"));
        FXMLLoader allexp = new FXMLLoader(getClass().getResource("all.fxml"));

        llist.add(todo);
        llist.add(budgetTracker);
        llist.add(allexp);
    }
    public void setMap(HashMap<String,LinkedList<ArrayList<String>>> map){
        this.adjList = map;
    }
    public void setArray(ArrayList<Integer> array){this.payments = array;}
    public void todo() throws IOException{
        app.setRoot(llist.get(0).load());
    }

    public void budget() throws IOException{
        FXMLLoader loader = llist.get(1);
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        budgetController setter = loader.getController();
        setter.setMap(adjList);
        app.setRoot(root);
    }

    public void all() throws IOException{
        FXMLLoader loader = llist.get(2);
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        allController setter = loader.getController();
        setter.setMap(adjList);
        setter.setArray(payments);
        app.setRoot(root);
    }

}
