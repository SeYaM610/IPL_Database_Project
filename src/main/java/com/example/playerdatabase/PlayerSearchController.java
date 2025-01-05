package com.example.playerdatabase;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.Map;

public class PlayerSearchController {
    String username;

    public void setUsername(String username) {
        this.username = username;
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
        obj.gotoPlayerSearchByCountry();

    }

    public void OnClickPosition(ActionEvent actionEvent) throws IOException {
        obj.gotoPlayerSearchByPosition();
    }

    public void OnClickSalaryRange(ActionEvent actionEvent) throws IOException {
        obj.gotoPlayerSearchBySalaryRange();
    }

    public void OnClickPlayerCount(ActionEvent actionEvent) throws Exception {
        CricketPlayerDatabase database = new CricketPlayerDatabase();
        Map<String, Integer> players = database.CountryWiseCountPlayers();
        obj.gotoCountrywiseCount(players,username);

    }
}
