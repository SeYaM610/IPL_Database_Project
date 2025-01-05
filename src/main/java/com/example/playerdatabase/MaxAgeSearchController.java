package com.example.playerdatabase;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class MaxAgeSearchController {
    CricketPlayerDatabase database = new CricketPlayerDatabase();
//    HomePageController HPCon = new HomePageController();

    Main obj;

    public MaxAgeSearchController() throws IOException {
    }

    public void setObj(Main obj) {
        this.obj = obj;
    }

    public TextField CLubName;
    public void OnEnteringCLub(ActionEvent actionEvent) throws Exception {
//        PlayerInfoController info = new PlayerInfoController();


        ArrayList<Player> players = database.MaxAgeInClub(CLubName.getText());
//        obj.gotoPlayerInfo(players,username);
    }
}
