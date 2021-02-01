package sample;

import java.io.*;

public class checkLogin {

    public int CheckUser(String User, String Pass) throws IOException {


        BufferedReader userRead = new BufferedReader(new FileReader("src\\sample\\usernames.txt"));
        String line = userRead.readLine();
        String[] arr = line.split("\\|");

        BufferedReader passRead = new BufferedReader(new FileReader("src\\sample\\passwords.txt"));
        String line1 = passRead.readLine();
        String[] arr1 = line1.split("\\|");

        for(int i = 0; i < arr.length;i++){
            if(User.equals(arr[i])){
                if(Pass.equals(arr1[i])){
                    return 1;
                }
            }
        }
        return -1;
    }
}
