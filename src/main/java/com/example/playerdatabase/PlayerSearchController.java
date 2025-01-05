package com.example.playerdatabase;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.Map;

public class PlayerSearchController {
    public ImageView clubLogo;
    public Label ClubName;
    String username;
    public void setUsername(String username) {
        this.username = username;
    }

    public void setImage(String username) {
//        UserName = username;

        if(username.equals("Chennai Super Kings") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/csk.png").toExternalForm());
            clubLogo.setImage(img);
            clubLogo.setFitWidth(320); // Resize
            clubLogo.setFitHeight(240);
            ClubName.setText(username);
        }
        if(username.equals("Delhi Capitals") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/dc.png").toExternalForm());
            clubLogo.setImage(img);
            clubLogo.setFitWidth(320); // Resize
            clubLogo.setFitHeight(240);
            ClubName.setText(username);
        }
        if(username.equals("Gujarat Titans") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/gt.png").toExternalForm());
            clubLogo.setImage(img);
            clubLogo.setFitWidth(320); // Resize
            clubLogo.setFitHeight(240);
            ClubName.setText(username);
        }
        if(username.equals("Kolkata Knight Riders") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/kkr.png").toExternalForm());
            clubLogo.setImage(img);
            clubLogo.setFitWidth(320); // Resize
            clubLogo.setFitHeight(240);
            ClubName.setText(username);
        }
        if(username.equals("Lucknow Super Giants") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/lsg.png").toExternalForm());
            clubLogo.setImage(img);
            clubLogo.setFitWidth(320); // Resize
            clubLogo.setFitHeight(240);
            ClubName.setText(username);
        }
        if(username.equals("Mumbai Indians") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/mi.png").toExternalForm());
            clubLogo.setImage(img);
            clubLogo.setFitWidth(320); // Resize
            clubLogo.setFitHeight(240);
            ClubName.setText(username);
        }
        if(username.equals("Punjab Kings") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/pk.png").toExternalForm());
            clubLogo.setImage(img);
            clubLogo.setFitWidth(320); // Resize
            clubLogo.setFitHeight(240);
            ClubName.setText(username);
        }
        if(username.equals("Rajasthan Royals") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/rr.png").toExternalForm());
            clubLogo.setImage(img);
            clubLogo.setFitWidth(320); // Resize
            clubLogo.setFitHeight(240);
            ClubName.setText(username);
        }
        if(username.equals("Royal Challengers Bangalore") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/rcb.png").toExternalForm());
            clubLogo.setImage(img);
            clubLogo.setFitWidth(320); // Resize
            clubLogo.setFitHeight(240);
            ClubName.setText(username);
        }
        if(username.equals("Sunrisers Hyderabad") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/srh.png").toExternalForm());
            clubLogo.setImage(img);
            clubLogo.setFitWidth(320); // Resize
            clubLogo.setFitHeight(240);
            ClubName.setText(username);
        }
    }

    Main obj;

    public void setObj(Main obj) {
        this.obj = obj;
    }

    public void OnClickBack(ActionEvent actionEvent) throws Exception
    {
        if(username.equals("admin")) obj.gotoMainMenuServer();
        else obj.gotoMainMenuClub(username);
    }

    public void OnClickName(ActionEvent actionEvent) throws IOException
    {
        obj.gotoPlayerSearchByName(username);
    }

    public void OnClickCountry(ActionEvent actionEvent) throws IOException {
        obj.gotoPlayerSearchByCountry(username);

    }

    public void OnClickPosition(ActionEvent actionEvent) throws IOException {
        obj.gotoPlayerSearchByPosition(username);
    }

    public void OnClickSalaryRange(ActionEvent actionEvent) throws IOException {
        obj.gotoPlayerSearchBySalaryRange(username);
    }

    public void OnClickPlayerCount(ActionEvent actionEvent) throws Exception {
        CricketPlayerDatabase database = new CricketPlayerDatabase();
        Map<String, Integer> players = database.CountryWiseCountPlayers();
        obj.gotoCountrywiseCount(players,username);

    }
}
