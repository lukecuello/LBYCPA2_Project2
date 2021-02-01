package sample;

import java.io.IOException;
import java.util.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class tdController {
    public Button addToList;
    public Text expenseTxt, amountTxt, dateTxt;
    public TextField expense, amount, date, screen;
    public Label system;
    public ListView<String> list;
    public ArrayList<String> userInput = new ArrayList<>();
    public Queue<String> queue = new LinkedList<>();

    public void addClick() {
        if(expense.getText().isEmpty() || amount.getText().isEmpty() || date.getText().isEmpty()) {
            system.setText("Please fill in all the fields.");
        } else {
            userInput.add(expense.getText());
            userInput.add(amount.getText());
            userInput.add(date.getText());
            queue.add(userInput.toString());

            list.getItems().add(userInput.toString());

            system.setText("Item added to list.");
            expense.setText("");
            amount.setText("");
            date.setText("");

        }
    }

    public void goBack() throws IOException {
        Main app = new Main();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainMenu.fxml"));
        app.setRoot(loader.load());
    }

    // Don't mind this muna, still fixing stuff
    public void display() {
        String selected = list.getSelectionModel().getSelectedItem();
        if(selected.equalsIgnoreCase("January")) {
            if(queue.contains("January")) {
                screen.setText(queue.toString());
            }
        } else if(selected.equalsIgnoreCase("February")) {
            if (queue.contains("February")) {
                screen.setText(queue.toString());
            }
        } else if(selected.equalsIgnoreCase("March")) {
            if (queue.contains("March")) {
                screen.setText(queue.toString());
            }
        } else if(selected.equalsIgnoreCase("April")) {
            if (queue.contains("April")) {
                screen.setText(queue.toString());
            }
        } else if(selected.equalsIgnoreCase("May")) {
            if (queue.contains("May")) {
                screen.setText(queue.toString());
            }
        } else if(selected.equalsIgnoreCase("June")) {
            if (queue.contains("June")) {
                screen.setText(queue.toString());
            }
        } else if(selected.equalsIgnoreCase("July")) {
            if (queue.contains("July")) {
                screen.setText(queue.toString());
            }
        } else if(selected.equalsIgnoreCase("August")) {
            if (queue.contains("August")) {
                screen.setText(queue.toString());
            }
        } else if(selected.equalsIgnoreCase("September")) {
            if (queue.contains("September")) {
                screen.setText(queue.toString());
            }
        } else if(selected.equalsIgnoreCase("October")) {
            if (queue.contains("October")) {
                screen.setText(queue.toString());
            }
        } else if(selected.equalsIgnoreCase("November")) {
            if (queue.contains("November")) {
                screen.setText(queue.toString());
            }
        } else if(selected.equalsIgnoreCase("December")) {
            if (queue.contains("December")) {
                screen.setText(queue.toString());
            }
        }

    }

//    public ArrayList objectToArrayList(Queue myQueue){
//        var item = (ArrayList) myQueue.peek();
//        return item;
//    }
//
//    public void loadItem(ArrayList item) {
//        expenseTxt.setText(item.get(0).toString());
//        amountTxt.setText(item.get(1).toString());
//        dateTxt.setText(item.get(3).toString());
//    }
}
