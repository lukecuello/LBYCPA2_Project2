package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;

public class loginController {
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    Button confirm,register;
    @FXML
    Text error;

    Main app = new Main();

    public void login() throws IOException {
        checkLogin check = new checkLogin();
        String usernameText = username.getText();
        String pass = password.getText();

        int action = check.CheckUser(usernameText,pass);
        if(action > -1){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mainMenu.fxml"));
            app.setRoot(loader.load());
        }else{
            error.setText("Username or Password is Incorrect");
        }
    }

    public void register() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("register.fxml"));
        app.setRoot(loader.load());
    }
}
