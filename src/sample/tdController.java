package sample;

import java.util.*;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class tdController {
    public Button addToList;
    public Text expenseTxt, amountTxt, dateTxt;
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
            userInput.add(date.getValue().toString());
            queue.add(userInput.toString());

            system.setText("Item added to list.");
            expense.setText("");
            amount.setText("");
            date.setAccessibleText("");
        }
    }

    public ArrayList objectToArrayList(Queue myQueue){
        var item = (ArrayList) myQueue.peek();
        return item;
    }

    public void loadItem(ArrayList item) {
        expenseTxt.setText(item.get(0).toString());
        amountTxt.setText(item.get(1).toString());
        dateTxt.setText(item.get(3).toString());
    }
}
