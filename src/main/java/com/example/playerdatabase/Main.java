package com.example.playerdatabase;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Main extends Application {

    private Stage stage;

    public static void main(String[] args) {

                CricketPlayerDatabase database = new CricketPlayerDatabase();
            try {
                database.AddingPlayersToDatabase();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        launch(args);
    }


    SocketWrapper socketWrapper;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
                try {
                    System.out.println("Starting client ");

                     socketWrapper = new SocketWrapper("127.0.0.1", 44444);

                    System.out.println("Client connected to Server");

                } catch (Exception e) {
                    System.out.println("Error starting client #"  + ": " + e.getMessage());
                    e.printStackTrace();
                }
        gotoHome();
    }

    public void gotoHome() throws  IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("HomePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1550, 780);

        HomePageController HPage = fxmlLoader.getController();
        HPage.setObj(this);

        stage.setTitle("Welcome!");
        stage.setScene(scene);
        stage.show();
    }

    public void gotoMainMenuServer() throws  IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AdminMainMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1550, 780);

        AdminMainMenuController MMenu = fxmlLoader.getController();
        MMenu.setObj(this);
        MMenu.setSocketWrapper(socketWrapper);

        stage.setTitle("MainMenu");
        stage.setScene(scene);
        stage.show();
    }
    public void gotoMainMenuClub(String username) throws Exception
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ClubMainMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1550, 780);

        ClubMainMenuController MMenu = fxmlLoader.getController();
        MMenu.setObj(this,username);
        MMenu.setImage(username);
        MMenu.setJersey(username);
        MMenu.setStage(stage);
        MMenu.setSocketWrapper(socketWrapper);

        MMenu.PlayerInfoTable(username);

        stage.setTitle("MainMenu");
        stage.setScene(scene);
        stage.show();
    }


    public void gotoPlayerSearch(String username) throws  IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("PlayerSearch.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1550, 780);

        PlayerSearchController PSearch = fxmlLoader.getController();
        PSearch.setObj(this);
        PSearch.setUsername(username);
        PSearch.setImage(username);

        stage.setTitle("Player Search");
        stage.setScene(scene);
        stage.show();
    }

    public void gotoPlayerSearchByName(String username) throws  IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SearchingByPlayerName.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1550, 780);

        SearchingByPlayerNameController PSearchName = fxmlLoader.getController();
        PSearchName.setObj(this);
        PSearchName.setUsername(username);

        stage.setTitle("Player Search By Name");
        stage.setScene(scene);
        stage.show();
    }

    public void gotoPlayerSearchByCountry(String username) throws  IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SearchingByCountry.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1550, 780);

        SearchingByCountryController PSearchCountry = fxmlLoader.getController();
        PSearchCountry.setObj(this);
        PSearchCountry.setUsername(username);

        stage.setTitle("Player Search By Country");
        stage.setScene(scene);
        stage.show();
    }

    public void gotoPlayerSearchByPosition(String username) throws  IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SearchingByPosition.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1550, 780);

        SearchingByPositionController PSearchPosition = fxmlLoader.getController();
        PSearchPosition.setObj(this);
        PSearchPosition.setUsername(username);

        stage.setTitle("Player Search By Position");
        stage.setScene(scene);
        stage.show();
    }

    public void gotoPlayerSearchBySalaryRange(String username) throws  IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SearchingBySalaryRange.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1550, 780);

        SearchingBySalaryRangeController PSearchSalary = fxmlLoader.getController();
        PSearchSalary.setObj(this);
        PSearchSalary.setUsername(username);

        stage.setTitle("Player Search By Salary Range");
        stage.setScene(scene);
        stage.show();
    }



    public void gotoMaxSalaryPlayer(String username) throws  IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MaxSalarySearch.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1550, 780);

        MaxSalarySearchController MaxSalary = fxmlLoader.getController();
        MaxSalary.setObj(this);
        MaxSalary.setUsername(username);

        stage.setTitle("Player Search By Max Salary");
        stage.setScene(scene);
        stage.show();
    }
    public void gotoMaxAgePlayer(String username) throws  IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MaxAgeSearch.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1550, 780);

        MaxAgeSearchController MaxAge = fxmlLoader.getController();
        MaxAge.setObj(this);
        MaxAge.setUsername(username);

        stage.setTitle("Player Search By Max Age");
        stage.setScene(scene);
        stage.show();
    }
    public void gotoMaxHeightPlayer(String username) throws  IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MaxHeightSearch.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1550, 780);

        MaxHeightSearchController MaxHeight = fxmlLoader.getController();
        MaxHeight.setObj(this);
        MaxHeight.setUsername(username);

        stage.setTitle("Player Search By Max Height");
        stage.setScene(scene);
        stage.show();
    }

    private PlayerAvailableController playerInfoController;

//    public void setPlayerInfoController(PlayerAvailableController controller) {
//        this.playerInfoController = controller;
//    }
//
//    public PlayerAvailableController getPlayerInfoController() {
//        return playerInfoController;
//    }

    public void gotoPlayerInfo(ArrayList<Player> players , String Username) throws  IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("PlayerInfo.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1550, 780);

        PlayerInfoController PInfo = fxmlLoader.getController();
        PInfo.setObj(this);
        PInfo.PlayerInfoTable((players));
        PInfo.setUsername(Username);
        PInfo.setImageClubName(Username);
        PInfo.setSocketWrapper(socketWrapper);

//        setPlayerInfoController(PInfo);

        stage.setTitle("Player Info");
        stage.setScene(scene);
        stage.show();
    }

    public void gotoCountrywiseCount(Map<String, Integer> players, String Username) throws  IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("CountryWisePlayerCount.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1550, 780);

        CountryWisePlayerCountController PInfo = fxmlLoader.getController();
        PInfo.setObj(this);
        PInfo.PlayerInfoTable((players));
        PInfo.setUsername(Username);
        PInfo.setImageClubName(Username);
        PInfo.setSocketWrapper(socketWrapper);

//        setPlayerInfoController(PInfo);

        stage.setTitle("Country Wise Player Count");
        stage.setScene(scene);
        stage.show();
    }

    public void gotoClubwiseSalary(Map<String, Integer> players, String Username) throws  IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ClubWiseSalary.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1550, 780);

        ClubWiseSalaryController PInfo = fxmlLoader.getController();
        PInfo.setObj(this);
        PInfo.PlayerInfoTable((players));
        PInfo.setUsername(Username);
        PInfo.setImageClubName(Username);
        PInfo.setSocketWrapper(socketWrapper);

//        setPlayerInfoController(PInfo);

        stage.setTitle("Club Wise Salary");
        stage.setScene(scene);
        stage.show();
    }

    public void gotoPlayerDetails(Player player,String user) {
        try {
            // Load the new FXML file for the player details window
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("PlayerDetails.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1550, 780);

            // Get the controller of the new scene and pass player data
            PlayerDetailsController controller = fxmlLoader.getController();
            controller.LoadPlayerDetails(player,user);
            controller.setObj(this);

            // Create a new stage for the player details window

            stage.setTitle("Player Details");
            stage.setScene(scene);
//            stage.initModality(Modality.APPLICATION_MODAL); // Block interaction with other windows
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void gotoAvailablePlayerInfo(ArrayList<Player> players , String Username) throws  IOException
    {
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Player_Available.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 1550, 780);
//
//        PlayerAvailableController PInfo = fxmlLoader.getController();
//        PInfo.setObj(this);
//        PInfo.PlayerInfoTable((players));
//        PInfo.setUsername(Username);
//        PInfo.setImage(Username);
//
////        setPlayerInfoController(PInfo);
//
//        stage.setTitle("Available Player Info");
//        stage.setScene(scene);
//        stage.show();
    }

    public void gotoClubSearch(String username) throws  IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ClubSearch.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1550, 780);

        ClubSearchController CSearch = fxmlLoader.getController();
        CSearch.setObj(this);
        CSearch.setUsername(username);
        CSearch.setImage(username);

        stage.setTitle("Club Search");
        stage.setScene(scene);
        stage.show();
    }

}