package com.example.playerdatabase;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class SearchingByPlayerNameController {
    String username;

    public SearchingByPlayerNameController() throws IOException {
    }

    public void setUsername(String username) {
        this.username = username;
    }

    CricketPlayerDatabase database = new CricketPlayerDatabase();


    public TextField PlayerName;
    Main obj;

    public void setObj(Main obj) {
        this.obj = obj;
    }
    public void OnEnteringName(ActionEvent actionEvent) throws Exception
    {
//        database.AddingPlayersToDatabase();
//        PlayerInfoController info = new PlayerInfoController();

        ArrayList<Player> players = database.SearchingByName(PlayerName.getText());
        obj.gotoPlayerInfo(players,username);



    }

}
