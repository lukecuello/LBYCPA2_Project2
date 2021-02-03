package sample;

import java.io.IOException;
import java.util.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;

public class tdController {
    public Button addToList;
    public TextField expense, amount;
    public ListView<String> screen;
    public ChoiceBox<String> date;
    public Label system;
    public ListView<String> list;
    public Profile profile;
    HashMap<String,LinkedList<ArrayList<String>>> adjList = new HashMap<>();
    ArrayList<Integer> payments = new ArrayList<>();
    String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};

    public void initialize(){
        for(String i:months){
            list.getItems().add(i);
            date.getItems().add(i);
        }
    }

    public void addClick() {
        if(expense.getText().isEmpty() || amount.getText().isEmpty()) {
            system.setText("Please fill in all the fields.");
        } else {
            ArrayList<String> userInput = new ArrayList<>();
            userInput.add(expense.getText());
            userInput.add(amount.getText());
            int value = Integer.parseInt(amount.getText());
            payments.add(value);
            addEdge(date.getSelectionModel().getSelectedItem(),userInput);

            system.setText("Item added to list.");
            expense.setText("");
            amount.setText("");

        }
    }

    public void addEdge(String src, ArrayList<String> dest){
        Boolean containsValue = false;
        ArrayList<String> temp = dest;

        if(adjList.get(src) != null) {
            for (ArrayList<String> i : adjList.get(src)) {
                if (temp.get(0).equals(i.get(0))) {
                    containsValue = true;
                    break;
                } else {
                    containsValue = false;
                }

            }
        }
        if(!adjList.containsKey(src)){
            LinkedList<ArrayList<String>> nodes= new LinkedList<>();
            nodes.add(dest);
            adjList.put(src,nodes);
        }else if(containsValue){
            for (ArrayList<String> i : adjList.get(src)) {
                if(temp.get(0).equals(i.get(0))){
                    int tempnum = Integer.parseInt(temp.get(1)) + Integer.parseInt(i.get(1));
                    i.set(1,String.valueOf(tempnum));
                    break;
                }
            }
        }else{
            LinkedList<ArrayList<String>> nodes = adjList.get(src);
            nodes.add(dest);
            adjList.put(src,nodes);
        }
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
        setter.setArray(payments);
        app.setRoot(root);
    }

    public void display() {
        String selected = list.getSelectionModel().getSelectedItem();
        LinkedList<ArrayList<String>> edge = adjList.get(selected);
        System.out.println(edge);
        if(adjList.get(selected) != null) {
            screen.getItems().clear();
            for (ArrayList<String> i : edge) {
                String td;
                td = i.get(0) + "\t\t\t" + "Php"+i.get(1);
                screen.getItems().add(td);
            }
        }else{
            screen.getItems().clear();
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
