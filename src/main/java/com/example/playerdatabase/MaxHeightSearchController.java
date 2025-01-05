package com.example.playerdatabase;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class MaxHeightSearchController {
    CricketPlayerDatabase database = new CricketPlayerDatabase();
//    HomePageController HPCon = new HomePageController();
    Main obj;
    String username;
    public void setUsername(String username) {
        this.username = username;
    }

    public MaxHeightSearchController() throws IOException {
    }

    public void setObj(Main obj) {
        this.obj = obj;
    }

    public TextField CLubName;

    public void OnEnteringCLub(ActionEvent actionEvent) throws Exception {
//        PlayerInfoController info = new PlayerInfoController();
//        String username = HPCon.getUserName();
        ArrayList<Player> players = database.MaxHeightInClub(CLubName.getText());
        obj.gotoPlayerInfo(players,username);
    }
}
