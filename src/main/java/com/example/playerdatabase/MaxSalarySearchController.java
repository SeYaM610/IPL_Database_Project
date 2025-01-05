package com.example.playerdatabase;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class MaxSalarySearchController {
    CricketPlayerDatabase database = new CricketPlayerDatabase();

    Main obj;
    String username;
    public void setUsername(String username) {
        this.username = username;
    }

    public MaxSalarySearchController() throws IOException {
    }

    public void setObj(Main obj) {
        this.obj = obj;
    }

    public TextField CLubName;

    public void OnEnteringCLub(ActionEvent actionEvent) throws Exception {
        PlayerInfoController info = new PlayerInfoController();

        ArrayList<Player> players = database.MaxSalaryInClub(CLubName.getText());
        obj.gotoPlayerInfo(players,username);
    }
}
