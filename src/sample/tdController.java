package sample;

import java.util.*;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class tdController {
    public Button addToList;
    public TextField expense, amount;
    public DatePicker date;
    public Label system;
    public Queue<String> queue = new LinkedList<>();

    public void addClick() {
        if(expense.getText().isEmpty() || amount.getText().isEmpty() || date.getAccessibleText().isEmpty()) {
            system.setText("Please fill in all the fields.");
        } else {
            ArrayList<String> userInput = new ArrayList<>();
            userInput.add(expense.getText());
            userInput.add(amount.getText());
            userInput.add(date.getAccessibleText());

        }
    }
}
