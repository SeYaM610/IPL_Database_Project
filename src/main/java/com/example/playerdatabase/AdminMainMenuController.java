package com.example.playerdatabase;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminMainMenuController {
    public javafx.scene.control.Label label;

//    public ImageView logo;
    public javafx.scene.image.ImageView image;
    public ImageView csk;
    public ImageView dc;
    public ImageView gt;
    public ImageView kkr;
    public ImageView lsg;
    public ImageView mi;
    public ImageView pk;
    public ImageView rr;
    public ImageView rcb;
    public ImageView srh;
    public TextField name;
    public TextField country;
    public TextField age;
    public TextField height;
    public TextField position;
    public TextField jersey;
    public TextField salary;

    @FXML
    public void setImage(String username) {
        // Ensure correct path for image
    }
    SocketWrapper socketWrapper;
    void setSocketWrapper(SocketWrapper socketWrapper)
    {
        this.socketWrapper = socketWrapper;
    }

    Main obj;
    CricketPlayerDatabase dt = new CricketPlayerDatabase();

    public void setObj(Main obj) {
        this.obj = obj;
    }

    public void OnClickSearchPlayer(ActionEvent actionEvent) throws IOException
    {
        obj.gotoPlayerSearch("admin");
    }

    public void OnClickSearchClub(ActionEvent actionEvent)throws IOException
    {
        obj.gotoClubSearch("admin");
    }

    public void OnCllickLogOut(ActionEvent actionEvent) throws IOException {
        obj.gotoHome();
    }

    public void OnClickEnlist(ActionEvent actionEvent) throws Exception {

    try{
        Player p = new Player(name.getText(),country.getText(),Integer.parseInt(age.getText()),Double.parseDouble(height.getText()),"None",position.getText(),Integer.parseInt(jersey.getText()),Integer.parseInt(salary.getText()));
        dt.AddingPlayersToFile(p);

        socketWrapper.write(p);
        socketWrapper.write("Sell");

        // Show a congratulations alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Player Enlisted");
        alert.setHeaderText("Congratulations!");
        alert.setContentText("Player " + name.getText() + " has been successfully added to the cricket database.");

        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.setWidth(500);
        stage.setHeight(200);
        stage.setX(400);
        stage.setY(350);

        alert.showAndWait(); // Wait for user interaction

        // Clear all TextFields after the alert is closed
        name.clear();
        country.clear();
        age.clear();
        height.clear();
        position.clear();
        jersey.clear();
        salary.clear();

    } catch (NumberFormatException e) {
        // Handle invalid number inputs
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText("Invalid Data");
        alert.setContentText("Please ensure all numerical fields are entered correctly.");
        alert.showAndWait();
    } catch (Exception e) {
        // Handle other exceptions
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Operation Failed");
        alert.setContentText("An unexpected error occurred while enlisting the player.");
        alert.showAndWait();
        e.printStackTrace();
    }

    }

    public void OnCLickExit(ActionEvent actionEvent) {
        Platform.exit();
        System.exit(0);
    }
}
