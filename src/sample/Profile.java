package sample;

import java.util.*;

public class Profile {
    private String username;
    private String expense;
    private String value;
    private String date;
    private String budget;
    private String budgetdate;

    HashMap<String, LinkedList<String>> adjList = new HashMap<>();
    ArrayList<Profile> users = new ArrayList<>();
    int count = 0;

    public Profile(){
    }

    public Profile(String username)
    {
        this.username=username;
        this.expense="";
        this.value="";
        this.date="";
        this.budget="";
        this.budgetdate="";
    }

    public LinkedList<String> getProfile(String name){return adjList.get(name);}

    public String getUsername()
    {
        return username;
    }

    public String getExpense() {
        return expense;
    }

    public String getBudget(){
        return budget;
    }

    public String getValue() {
        return value;
    }

    public void setExpense(String expense) {
        this.expense = expense;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<String> getExpenses() {
        return adjList.get(this.username);
    }

    public void addExpense(String expense, String value, String date) {
        LinkedList<String>nodes = adjList.get(username);
        nodes.add(expense);
        nodes.add(value);
        nodes.add(date);
        adjList.put(username, nodes);
    }

    public void addBudget(String budget, String budgetdate){
        LinkedList<String>nodes = adjList.get(username);
        nodes.add(budget);
        nodes.add(budgetdate);
        adjList.put(username, nodes);
    }

    public void removeExpense(String expense, String value, String date)
    {
        LinkedList<String>nodes = adjList.get(username);
        if ((nodes.contains(value)) && (nodes.contains(expense)) && (nodes.contains(date))) {
            nodes.remove(expense);
            nodes.remove(value);
            nodes.remove(date);
            adjList.put(username, nodes);
        }
    }

    public void removeBudget(String budget, String budgetdate)
    {
        LinkedList<String> nodes = adjList.get(username);
        if ((nodes.contains(budget)) && (nodes.contains(budgetdate))) {
            nodes.remove(expense);
            nodes.remove(value);
            nodes.remove(date);
            adjList.put(username, nodes);
        }
    }

    public String getDate() {
        return date;
    }

    public String getBudgetDate(){
        return budgetdate;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setBudgetDate(String budgetdate){
        this.budgetdate=budgetdate;
    }

    void addNode(String src){
        adjList.put(src, new LinkedList<>());
    }


}
