package com.example.playerdatabase;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class PlayerAvailableController  {

    public Label ClubName;
    public ImageView clubLogo;
    private Stage stage;

    public ImageView image;
    String UserName;

    Main obj;

    public void setUsername(String username) {
        this.UserName = username;
    }
    public void setImage(String username) {
        UserName = username;

        if(username.equals("Rajasthan Royals") ) {
            javafx.scene.image.Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/rr.png").toExternalForm());
            image.setImage(img);
            image.setFitWidth(200); // Resize
            image.setFitHeight(150);
        }
        if(username.equals("Gujarat Titans") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/gt.png").toExternalForm());
            image.setImage(img);
            image.setFitWidth(200); // Resize
            image.setFitHeight(150);
        }
        if(username.equals("Chennai Super Kings") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/csk.png").toExternalForm());
            image.setImage(img);
            image.setFitWidth(200); // Resize
            image.setFitHeight(150);
        }
        if(username.equals("Mumbai Indians") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/mi.png").toExternalForm());
            image.setImage(img);
            image.setFitWidth(200); // Resize
            image.setFitHeight(150);
        }
        if(username.equals("Kolkata Knight Riders") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/kkr.png").toExternalForm());
            image.setImage(img);
            image.setFitWidth(200); // Resize
            image.setFitHeight(150);
        }
    }

//    private Main obj; // Reference to Main for navigation
    private final ObservableList<Player> players = FXCollections.observableArrayList(); // List for table data

    @FXML
    private TableView<Player> PlayerTable; // Table to display player data

    @FXML
    private void initialize() {

        if (PlayerTable != null) {
            Name.setCellValueFactory(new PropertyValueFactory<>("name"));
            Country.setCellValueFactory(new PropertyValueFactory<>("country"));

            Position.setCellValueFactory(new PropertyValueFactory<>("position"));

            Weekly_Salary.setCellValueFactory(new PropertyValueFactory<>("weeklySalary"));

        }
    }

    MainReadThread readThread;
    public void LoadAvailablePlayer(String UserName,Stage stage,SocketWrapper socketWrapper,Main obj) throws Exception {
//        this.obj =obj;
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Player_Available.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1550, 780);


        PlayerAvailableController controller = fxmlLoader.getController();
        controller.setUsername(UserName);
        controller.setImage(UserName);
        controller.setObj(obj);

        if (readThread == null) {
            readThread = new MainReadThread(socketWrapper);
            readThread.start();
        }
//        this.playerList = readThread.getAvailablePlayers();
        controller.PlayerInfoTable(readThread.getAvailablePlayers());

        stage.setTitle("Available Player Info");
        stage.setScene(scene);
        stage.show();

    }


    @FXML
    private TableColumn<Player, String> Name;

    @FXML
    private TableColumn<Player, String> Country;

    @FXML
    private TableColumn<Player, String> Position;

    @FXML
    private TableColumn<Player, Integer> Weekly_Salary;

    @FXML
    private TableColumn<Player, Void> Status; // Column for "Sell" button

    public void setObj(Main obj) {
        this.obj = obj;
    }

    public void PlayerInfoTable(ArrayList<Player> playerList) {
        players.setAll(playerList);

        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Country.setCellValueFactory(new PropertyValueFactory<>("country"));
        Position.setCellValueFactory(new PropertyValueFactory<>("position"));

        Weekly_Salary.setCellValueFactory(new PropertyValueFactory<>("weeklySalary"));

        alignColumnsToCenter();

        addBuyButtonColumn();

        PlayerTable.setItems(players); // Set observable list to table
    }

    private void addBuyButtonColumn() {
        Status.setCellFactory(tc -> new TableCell<>() {
            private final Button buyButton = new Button("Buy");

            {
                buyButton.setOnAction(event -> {
                    Player player = getTableView().getItems().get(getIndex());
                    try {
                        buyPlayer(player);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

                buyButton.setStyle("-fx-background-color: #ff6666; -fx-text-fill: white; -fx-font-weight: bold;");
                buyButton.setAlignment(Pos.CENTER);
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(buyButton);
                }
            }
        });
    }

    // Buy a player
    private void buyPlayer(Player player) throws Exception {
        players.remove(player); // Remove player from local list
        CricketPlayerDatabase database = new CricketPlayerDatabase();
        database.deletePlayer(player,UserName);
   }


//    public void updatePlayerTable(ArrayList<Player> updatedPlayerList) {
//        Platform.runLater(() -> {
//            players.setAll(updatedPlayerList); // Update observable list on the JavaFX thread
//        });
//    }

    private void alignColumnsToCenter() {
        alignColumnToCenter(Name);
        alignColumnToCenter(Country);
        alignColumnToCenter(Position);
        alignColumnToCenter(Weekly_Salary);
        alignColumnToCenter(Status);
    }

    private <T> void alignColumnToCenter(TableColumn<Player, T> column) {
        column.setCellFactory(tc -> {
            TableCell<Player, T> cell = new TableCell<>() {
                @Override
                protected void updateItem(T item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                        setGraphic(null);
                    } else {
                        setText(item.toString());
                    }
                }
            };
            cell.setAlignment(Pos.CENTER); // Align content to center
            return cell;
        });
    }

    public void OnCLickBack(ActionEvent actionEvent) throws Exception {

        obj.gotoMainMenuClub(UserName);
    }
}
