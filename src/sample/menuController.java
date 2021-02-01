package sample;

import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.LinkedList;


public class menuController{
    Main app = new Main();
    LinkedList<FXMLLoader> llist = new LinkedList<>();

    public void initialize(){
        FXMLLoader todo = new FXMLLoader(getClass().getResource("todo.fxml"));
        FXMLLoader expensesPaid = new FXMLLoader(getClass().getResource("expenses.fxml"));
        FXMLLoader allexp = new FXMLLoader(getClass().getResource("all.fxml"));

        llist.add(todo);
        llist.add(expensesPaid);
        llist.add(allexp);
    }

    public void todo() throws IOException{
        app.setRoot(llist.get(0).load());
    }

    public void paid() throws IOException{
        app.setRoot(llist.get(1).load());
    }

    public void all() throws IOException{
        app.setRoot(llist.get(2).load());
    }
}
