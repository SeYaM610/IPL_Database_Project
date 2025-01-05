package com.example.playerdatabase;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server extends Application {
    private final ArrayList<SocketWrapper> SockList = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        System.out.println("Server starting...");

//        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(44444);
                System.out.println("Server started on port 44444...");
                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Client Connected");
                    serve(clientSocket);
                }
            } catch (Exception e) {
//                System.out.println("Error in server: " + e.getMessage());
            }
//        }).start();
    }
    public void serve(Socket clientSocket) throws IOException, ClassNotFoundException {
        SocketWrapper socketWrapper = new SocketWrapper(clientSocket);
        SockList.add(socketWrapper);
        new ServerReadThread(socketWrapper,SockList);
    }
}