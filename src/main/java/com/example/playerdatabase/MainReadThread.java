package com.example.playerdatabase;

import javafx.application.Platform;

//import javafx.scene.control.TableView;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class MainReadThread extends Thread {

    private SocketWrapper socketWrapper;
    private CricketPlayerDatabase dt;
    private ArrayList<Player> availablePlayers;
    PlayerAvailableController controller;


    public MainReadThread(SocketWrapper socketWrapper,PlayerAvailableController controller) throws Exception {
        this.socketWrapper = socketWrapper;

        this.controller = controller;

        this.dt = new CricketPlayerDatabase();
        this.availablePlayers = dt.SearchingByClub("None");
    }

    @Override
    public void run() {
        try {
            while (true) {

                Object obj = socketWrapper.read();
                Object obj2 = socketWrapper.read();
                if (obj != null && obj instanceof Player && obj2 != null) {
                    Player player = (Player) obj;
                    String msg = (String) obj2;
                    System.out.println("Received player update: " + player.getName());

                    // Update the available players list
                    synchronized (obj){
                    Platform.runLater(() -> {
                        try {
                            // Refresh the entire available players list
//                            availablePlayers = dt.SearchingByClub("None");
                            if(msg.equals("Sell")) {
                                availablePlayers.add(player);
                            }
                            else {
                                availablePlayers.remove(player);
                            }
                            controller.updatePlayerTable(availablePlayers);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                }
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
