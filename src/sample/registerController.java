package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class registerController {
    @FXML
    Button confirm;
    @FXML
    PasswordField password, password1;
    @FXML
    TextField username;
    @FXML
    Text rText,errorText;

    public Profile profile;

    public void register() throws IOException {
        String userN = username.getText();
        String pass = password.getText();
        if(pass.equals(password1.getText())){
            errorText.setVisible(false);
            rText.setVisible(true);
            try{
                FileWriter f = new FileWriter("src\\sample\\usernames.txt",true);
                f.append("|"+userN);
                f.close();
            }catch(IOException e) {
                e.printStackTrace();
            }
            addPass(pass);
            profile.addNode(userN);

        }else{
            errorText.setVisible(true);
            rText.setVisible(false);
        }

    }

    public void addPass(String pass){
        try{
            FileWriter f = new FileWriter("src\\sample\\passwords.txt",true);
            f.append("|"+pass);
            f.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void goBack() throws IOException{
        Main app = new Main();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        app.setRoot(loader.load());
    }
}
