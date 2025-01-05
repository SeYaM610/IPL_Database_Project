package com.example.playerdatabase;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.Map;

public class ClubSearchController {
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

    public void OnClickMaxSalary(ActionEvent actionEvent) throws IOException {
        obj.gotoMaxSalaryPlayer();
    }

    public void OnClickMaxAge(ActionEvent actionEvent) throws IOException {
        obj.gotoMaxAgePlayer();
    }

    public void OnClickMaxHeight(ActionEvent actionEvent) throws IOException {
        obj.gotoMaxHeightPlayer();
    }

    public void OnClickYearlySalaryOfCLub(ActionEvent actionEvent) throws Exception {
        CricketPlayerDatabase database = new CricketPlayerDatabase();
        Map<String, Integer> players = database.ClubWiseSalary();
        obj.gotoClubwiseSalary(players,username);
    }
}
