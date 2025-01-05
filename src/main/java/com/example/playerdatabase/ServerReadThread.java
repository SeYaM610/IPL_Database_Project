package com.example.playerdatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class ServerReadThread extends Thread {
    private final SocketWrapper socketWrapper;
    private String currentUser;

    // Reference to centralized resources
    private final ArrayList<SocketWrapper> SockList;

    public ServerReadThread(SocketWrapper socketWrapper,ArrayList<SocketWrapper> SockList) {
        this.socketWrapper = socketWrapper;
        this.SockList = SockList;

        Thread thr = new Thread(this);
        thr.start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Read inputs

                Object o = socketWrapper.read();
                if(o != null) {
                    Player player = (Player) o; // Player being sold
//                    System.out.println("In ServerRead Sold Player - " + player.getName());
                    broadcastPlayerUpdate(player);
                }
            }
        } catch (Exception e) {
            System.out.println("Error in ServerReadThread: " + e.getMessage());
        } finally {
            try {
                socketWrapper.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Notify all other clients about the updated player list
    private void broadcastPlayerUpdate(Player player) throws IOException {
        synchronized (SockList) {
//            System.out.println("Debug: Broadcasting player - " + player.getName());
            for (SocketWrapper s : SockList) {
//                new Thread(() -> {
                    try {
                        s.write(player); // Write player data to the client socket
                    } catch (IOException e) {
//                        System.out.println("Error broadcasting player update: " + e.getMessage());
                    }
//                }).start();
            }
        }
    }
}
