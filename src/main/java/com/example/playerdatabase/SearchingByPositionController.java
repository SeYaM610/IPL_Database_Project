package com.example.playerdatabase;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
public class SearchingByPositionController {
    CricketPlayerDatabase database = new CricketPlayerDatabase();

    Main obj;
    String username;
    public void setUsername(String username) {
        this.username = username;
    }

    public SearchingByPositionController() throws IOException {
    }

    public void setObj(Main obj) {
        this.obj = obj;
    }
    public TextField PositionName;


    public void OnEnteringPosition(ActionEvent actionEvent) throws Exception {
        PlayerInfoController info = new PlayerInfoController();

        ArrayList<Player> players = database.SearchingByPosition(PositionName.getText());
        obj.gotoPlayerInfo(players,username);
    }
}
