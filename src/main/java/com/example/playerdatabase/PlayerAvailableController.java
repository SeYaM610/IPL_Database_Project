package com.example.playerdatabase;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import kotlin.jvm.Synchronized;

import java.io.IOException;
import java.util.ArrayList;

public class PlayerAvailableController  {

    public Label ClubName;
    private Stage stage;

    public ImageView clubLogo;
    String UserName;

    Main obj;

    public void setUsername(String username) {
        this.UserName = username;
    }
    public void setImage(String username) {
        UserName = username;

        if(username.equals("Chennai Super Kings") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/csk.png").toExternalForm());
            clubLogo.setImage(img);
            clubLogo.setFitWidth(320); // Resize
            clubLogo.setFitHeight(240);
            ClubName.setText(username);
        }
        if(username.equals("Delhi Capitals") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/dc.png").toExternalForm());
            clubLogo.setImage(img);
            clubLogo.setFitWidth(320); // Resize
            clubLogo.setFitHeight(240);
            ClubName.setText(username);
        }
        if(username.equals("Gujarat Titans") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/gt.png").toExternalForm());
            clubLogo.setImage(img);
            clubLogo.setFitWidth(320); // Resize
            clubLogo.setFitHeight(240);
            ClubName.setText(username);
        }
        if(username.equals("Kolkata Knight Riders") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/kkr.png").toExternalForm());
            clubLogo.setImage(img);
            clubLogo.setFitWidth(320); // Resize
            clubLogo.setFitHeight(240);
            ClubName.setText(username);
        }
        if(username.equals("Lucknow Super Giants") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/lsg.png").toExternalForm());
            clubLogo.setImage(img);
            clubLogo.setFitWidth(320); // Resize
            clubLogo.setFitHeight(240);
            ClubName.setText(username);
        }
        if(username.equals("Mumbai Indians") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/mi.png").toExternalForm());
            clubLogo.setImage(img);
            clubLogo.setFitWidth(320); // Resize
            clubLogo.setFitHeight(240);
            ClubName.setText(username);
        }
        if(username.equals("Punjab Kings") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/pk.png").toExternalForm());
            clubLogo.setImage(img);
            clubLogo.setFitWidth(320); // Resize
            clubLogo.setFitHeight(240);
            ClubName.setText(username);
        }
        if(username.equals("Rajasthan Royals") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/rr.png").toExternalForm());
            clubLogo.setImage(img);
            clubLogo.setFitWidth(320); // Resize
            clubLogo.setFitHeight(240);
            ClubName.setText(username);
        }
        if(username.equals("Royal Challengers Bangalore") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/rcb.png").toExternalForm());
            clubLogo.setImage(img);
            clubLogo.setFitWidth(320); // Resize
            clubLogo.setFitHeight(240);
            ClubName.setText(username);
        }
        if(username.equals("Sunrisers Hyderabad") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/srh.png").toExternalForm());
            clubLogo.setImage(img);
            clubLogo.setFitWidth(320); // Resize
            clubLogo.setFitHeight(240);
            ClubName.setText(username);
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

        Name.setCellFactory(column -> {

            return new TableCell<Player, String>() {

                @Override
                protected void updateItem(String item, boolean empty) {

                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                        setGraphic(null);
                        setCursor(Cursor.DEFAULT); // Default cursor for empty cells
                    } else {
                        setText(item);
                        setGraphic(null);
                        setCursor(Cursor.HAND); // Change cursor to hand on hover
                        setOnMouseClicked(event -> {
                            if (event.getClickCount() == 1) {
                                Player selectedPlayer = getTableView().getItems().get(getIndex());
                                obj.gotoPlayerDetails(selectedPlayer,UserName); // Handle click event
                            }
                        });
                    }
                }
            };
        });
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
                buyButton.setOnMouseEntered(event -> buyButton.setCursor(Cursor.HAND));
                buyButton.setOnMouseExited(event -> buyButton.setCursor(Cursor.DEFAULT));
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
    SocketWrapper socketWrapper;
    void setSocketWrapper(SocketWrapper socketWrapper)
    {
        this.socketWrapper = socketWrapper;
    }

    // Buy a player
    private void buyPlayer(Player player) throws Exception {
        players.remove(player); // Remove player from local list
        CricketPlayerDatabase database = new CricketPlayerDatabase();
        database.deletePlayer(player,UserName);
        socketWrapper.write(player);
        socketWrapper.write("Buy");
    }

    public void  updatePlayerTable(ArrayList<Player> updatedPlayerList) {
        System.out.println("Updating Players");
        Platform.runLater(() -> {

            players.setAll(updatedPlayerList); // Update observable list on the JavaFX thread
//            PlayerTable.getItems().clear();
            PlayerTable.setItems(players);
            PlayerTable.refresh();
        });
    }

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
