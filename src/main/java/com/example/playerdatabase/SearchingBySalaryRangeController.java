package com.example.playerdatabase;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class SearchingBySalaryRangeController {
    CricketPlayerDatabase database = new CricketPlayerDatabase();

    Main obj;
    String username;
    public void setUsername(String username) {
        this.username = username;
    }

    public SearchingBySalaryRangeController() throws IOException {
    }

    public void setObj(Main obj) {
        this.obj = obj;
    }
    public TextField LowRange;
    public TextField HighRange;

    public void OnEnteringLowRange(ActionEvent actionEvent) {
    }

    public void OnEnteringHighRange(ActionEvent actionEvent) throws Exception {

         int low = Integer.parseInt(LowRange.getText());
         int high = Integer.parseInt(HighRange.getText());

        ArrayList<Player> players = database.SearchingBySalary(low,high);
        obj.gotoPlayerInfo(players,username);
    }
}
