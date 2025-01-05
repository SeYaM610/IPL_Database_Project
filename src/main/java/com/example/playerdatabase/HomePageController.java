package com.example.playerdatabase;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageController {
    Image backgroundImage = new Image(getClass().getResource("/com/example/playerdatabase/images/ball.jpg").toExternalForm());

    public TextField UserName;
    public PasswordField Password;
    Main obj;

//    public  String getUserName() {
//       if(UserName.getText()!=null) return UserName.getText();
//       else return null;
//    }

//    void pageLoader(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("HomePage.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 1550, 780);
//
////        HomePageController HPage = fxmlLoader.getController();
////        HPage.setObj(this);
//
//        stage.setTitle("Welcome!");
//        stage.setScene(scene);
//        stage.show();
//    }

    public void setObj(Main obj)  throws IOException
    {
        this.obj = obj;
    }

    public void OnClickingLogin(ActionEvent actionEvent) throws Exception {
        String username = UserName.getText();
        String password = Password.getText();
//        new MainWriteThread(username);
//        new MainReadThread(username);
//        new ServerReadThread(String.valueOf(UserName));

        if (isValid(username, password)) {
            // If login is successful
           if(username.equals("admin")) obj.gotoMainMenuServer();
           else obj.gotoMainMenuClub(username);
        } else {
            //  error alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText("Invalid Username or Password");
            alert.setContentText("Please try again.");
            alert.showAndWait();
        }
    }

    private boolean isValid(String username, String password) {
        // Hardcoded username and password for demonstration
        return ("admin".equals(username) && "ad".equals(password)) ||
                ("Rajasthan Royals".equals(username) && "rr".equals(password)) ||
                ("Gujarat Titans".equals(username) && "gt".equals(password)) ||
                ("Chennai Super Kings".equals(username) && "csk".equals(password)) ||
                ("Delhi Capitals".equals(username) && "dc".equals(password)) ||
                ("Mumbai Indians".equals(username) && "mi".equals(password)) ||
                ("Kolkata Knight Riders".equals(username) && "kkr".equals(password)) ||
                ("Royal Challengers Bangalore".equals(username) && "rcb".equals(password)) ||
                ("Lucknow Super Giants".equals(username) && "lsg".equals(password)) ||
                ("Punjab Kings".equals(username) && "pk".equals(password)) ||
                ("Sunrisers Hyderabad".equals(username) && "sh".equals(password)) ;
    }

    public void OnCLickExit(ActionEvent actionEvent) {
        Platform.exit();
        System.exit(0);
    }
//    private void exitApplication() {
//        try {
//            // Close network sockets
//            if (socketWrapper != null) {
//                socketWrapper.closeConnection();
//            }
//
//            // Stop threads
//            if (readThread != null && readThread.isAlive()) {
//                readThread.interrupt();
//            }
//
//            // Exit the JavaFX application
//            Platform.exit();
//
//            // Optional: Ensure JVM termination
//            System.exit(0);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
