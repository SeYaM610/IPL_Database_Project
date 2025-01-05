package com.example.playerdatabase;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

//import javafx.scene.control.TableView;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MainReadThread extends Thread {

    private SocketWrapper socketWrapper;
    private CricketPlayerDatabase dt;
    private ArrayList<Player> availablePlayers;


    public MainReadThread(SocketWrapper socketWrapper) throws Exception {
        this.socketWrapper = socketWrapper;
        this.dt = new CricketPlayerDatabase();
        this.availablePlayers = dt.SearchingByClub("None");
    }

    @Override
    public void run() {
        try {
            while (true) {

                Object obj = socketWrapper.read();
                if (obj != null && obj instanceof Player) {
                    Player player = (Player) obj;
//                    System.out.println("Received player update: " + player.getName());

                    // Update the available players list
                    Platform.runLater(() -> {
                        try {
                            // Refresh the entire available players list
                            availablePlayers = dt.SearchingByClub("None");

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                }
            }
        } catch (Exception e) {
//            System.out.println("Error in MainReadThread: " + e.getMessage());
        }
    }
    public ArrayList<Player> getAvailablePlayers() {
        return availablePlayers;
    }

}
