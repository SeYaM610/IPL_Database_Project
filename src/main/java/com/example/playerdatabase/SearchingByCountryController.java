package com.example.playerdatabase;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class SearchingByCountryController {
    CricketPlayerDatabase database = new CricketPlayerDatabase();
    public TextField CountryName;
    Main obj;
    String username;
    public void setUsername(String username) {
        this.username = username;
    }

    public SearchingByCountryController() throws IOException {
    }

    public void setObj(Main obj) {
        this.obj = obj;
    }
    public void OnEnteringCountry(ActionEvent actionEvent) throws Exception {

        PlayerInfoController info = new PlayerInfoController();

        ArrayList<Player> players = database.SearchingByCountry(CountryName.getText());
        obj.gotoPlayerInfo(players,username);
    }
}
