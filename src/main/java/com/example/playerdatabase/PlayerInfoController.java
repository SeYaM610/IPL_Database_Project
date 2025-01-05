//package com.example.playerdatabase;
//
//import javafx.beans.Observable;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.geometry.Pos;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.ResourceBundle;
//
//public class PlayerInfoController  {
//
//    Main obj;
//
//    public void setObj(Main obj) {
//        this.obj = obj;
//    }
//
//    public void PlayerInfoTable(ArrayList<Player> playerlist) throws IOException {
//
//        ObservableList<Player> players = FXCollections.observableArrayList(playerlist);
//
//        TableView<Player> PlayerTable = new TableView<>();
//
//        TableColumn<Player, String> Name = new TableColumn<>("Name");
//        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
//
//
//        TableColumn<Player, String> Country = new TableColumn<>("Country");
//        Country.setCellValueFactory(new PropertyValueFactory<>("Country"));
//
//
//        TableColumn<Player, Integer> Age = new TableColumn<>("Age");
//        Age.setCellValueFactory(new PropertyValueFactory<>("Age"));
//
//
//         TableColumn<Player, Integer> Height = new TableColumn<>("Height");
//         Height.setCellValueFactory(new PropertyValueFactory<>("Height"));
//
//
//         TableColumn<Player, String> CLub  = new TableColumn<>("CLub");
//         CLub.setCellValueFactory(new PropertyValueFactory<>("CLub"));
//
//
//         TableColumn<Player, String> Position = new TableColumn<>("Position");
//        Position.setCellValueFactory(new PropertyValueFactory<>("Position"));
//
//
//         TableColumn<Player, Integer> Jersey_Number = new TableColumn<>("Jersey_Number");
//         Jersey_Number.setCellValueFactory(new PropertyValueFactory<>("Jersey_Number"));
//
//
//         TableColumn<Player, Integer> Weekly_Salary = new TableColumn<>("Weekly_Salary");
//         Weekly_Salary.setCellValueFactory(new PropertyValueFactory<>("Weekly_Salary"));
//
//         PlayerTable.getColumns().add(Name);
//        PlayerTable.getColumns().add(Country);
//        PlayerTable.getColumns().add(Age);
//        PlayerTable.getColumns().add(Height);
//        PlayerTable.getColumns().add(CLub);
//        PlayerTable.getColumns().add(Position);
//        PlayerTable.getColumns().add(Jersey_Number);
//        PlayerTable.getColumns().add(Weekly_Salary);
//
//        PlayerTable.setItems(players);
//    }
//}
//package com.example.playerdatabase;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.geometry.Pos;
//import javafx.scene.Cursor;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableCell;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import javafx.application.Platform;

//public class PlayerInfoController {
//
//
//    CricketPlayerDatabase database = new CricketPlayerDatabase();
////    public TableColumn status;
//    String username;
//    void setUsername(String name)
//    {
//        username = name;
//    }
//
//    private Main obj;
//
//    @FXML
//    private TableColumn<Player, Void> Status = new TableColumn<>("Status");
//
//    // Link FXML elements to the controller using @FXML
//    @FXML
//    private TableView<Player> PlayerTable  = new TableView<>();
//
//    @FXML
//    private TableColumn<Player, String> Name= new TableColumn<>("Name");
//
//    @FXML
//    private TableColumn<Player, String> Country= new TableColumn<>("Country");
//
//    @FXML
//    private TableColumn<Player, Integer> Age= new TableColumn<>("Age");
//
//    @FXML
//    private TableColumn<Player, Double> Height = new TableColumn<>("Height");
//
//    @FXML
//    private TableColumn<Player, String> CLub = new TableColumn<>("CLub");
//
//    @FXML
//    private TableColumn<Player, String> Position= new TableColumn<>("Position");
//
//    @FXML
//    private TableColumn<Player, Integer> Jersey_Number= new TableColumn<>("Jersey_Number");
//
//    @FXML
//    private TableColumn<Player, Integer> Weekly_Salary = new TableColumn<>("Weekly_Salary");
//
//    public void setObj(Main obj) {
//        this.obj = obj;
//    }
//
//    // Call this method to populate the table with data
//    public void PlayerInfoTable(ArrayList<Player> playerlist) {
//        ObservableList<Player> players = FXCollections.observableArrayList(playerlist);
//
//
//
//        // Bind columns to Player class fields
//        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
//        Country.setCellValueFactory(new PropertyValueFactory<>("country"));
//        Age.setCellValueFactory(new PropertyValueFactory<>("age"));
//        Height.setCellValueFactory(new PropertyValueFactory<>("height"));
//        CLub.setCellValueFactory(new PropertyValueFactory<>("club"));
//        Position.setCellValueFactory(new PropertyValueFactory<>("position"));
//        Jersey_Number.setCellValueFactory(new PropertyValueFactory<>("jerseyNumber"));
//        Weekly_Salary.setCellValueFactory(new PropertyValueFactory<>("weeklySalary"));
//
//        alignColumnCenter(Name);
//        alignColumnCenter(Country);
//        alignColumnCenter(Age);
//        alignColumnCenter(Height);
//        alignColumnCenter(CLub);
//        alignColumnCenter(Position);
//        alignColumnCenter(Jersey_Number);
//        alignColumnCenter(Weekly_Salary);
//        alignColumnCenter(Status);
//        // Set the data to the table
//        PlayerTable.setItems(players);
//
//        addSellButtonColumn(players);
//    }
//
//    private void addSellButtonColumn(ObservableList<Player> players) {
//        Status.setCellFactory(tc -> new TableCell<>() {
//            private final Button sellButton = new Button("Sell");
//
//            {
//                sellButton.setOnAction(event -> {
//                    Player player = getTableView().getItems().get(getIndex());
//                    try {
//                        sellPlayer(player, players);
//                    } catch (Exception e) {
//                        throw new RuntimeException(e);
//                    }
//                });
//
//                // Style the button (optional)
//                sellButton.setStyle("-fx-background-color: #ff6666; -fx-text-fill: white; -fx-font-weight: bold;");
//
//                // Set cursor to hand when hovering over the button
//                sellButton.setCursor(Cursor.HAND);
//            }
//
//            @Override
//            protected void updateItem(Void item, boolean empty) {
//                super.updateItem(item, empty);
//                if (empty) {
//                    setGraphic(null);
//                } else {
//                    setGraphic(sellButton);
//                    setAlignment(Pos.CENTER);
//                }
//            }
//        });
//
//        PlayerTable.getColumns().add(Status); // Add the column to the table
//    }
//
//    private void sellPlayer(Player player, ObservableList<Player> players) throws Exception {
//        // Perform selling logic (e.g., remove player, update backend)
//        players.remove(player); // Remove from the table view
//        database.deletePlayer(player,"None");
//        new MainWriteThread(player,"None");
//
//
//        // Optionally update other club/player data
//        System.out.println("Sold player: " + player.getName());
//    }
//
//
//
//
//
//    private <T> void alignColumnCenter(TableColumn<Player, T> column) {
//        column.setCellFactory(tc -> {
//            TableCell<Player, T> cell = new TableCell<>() {
//                @Override
//                protected void updateItem(T item, boolean empty) {
//                    super.updateItem(item, empty);
//                    if (empty || item == null) {
//                        setText(null);
//                        setGraphic(null);
//                    } else {
//                        setText(item.toString());
//                    }
//                }
//            };
//            cell.setAlignment(Pos.CENTER); // Center alignment
//            return cell;
//        });
//    }
//
//    public void OnCLickBack(ActionEvent actionEvent) throws IOException {
//        obj.gotoMainMenuClub(username);
//    }
//
//    public void updatePlayerInfoTable(ArrayList<Player> availablePlayers) {
//        // Assuming you have a TableView named playerTable in your FXML
//        PlayerTable.getItems().clear();
//        PlayerTable.getItems().addAll(availablePlayers);
//    }
//}

package com.example.playerdatabase;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;

public class PlayerInfoController {
    public Label ClubName;
    public ImageView clubLogo;
    String UserName;
    public void setUsername(String username) {
        this.UserName = username;
    }

    public void setImageClubName(String username) {
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


    private Main obj; // Reference to Main for navigation
    private final ObservableList<Player> players = FXCollections.observableArrayList(); // List for table data

    @FXML
    private TableView<Player> PlayerTable; // Table to display player data

    @FXML
    private TableColumn<Player, String> Name;

    @FXML
    private TableColumn<Player, String> Country;

    @FXML
    private TableColumn<Player, String> Position;

    public void setObj(Main obj) {
        this.obj = obj;
    }

    // Populate the table with players
    public void PlayerInfoTable(ArrayList<Player> playerList) {
        players.setAll(playerList); // Update observable list

        // Bind table columns to Player class fields
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Country.setCellValueFactory(new PropertyValueFactory<>("country"));
        Position.setCellValueFactory(new PropertyValueFactory<>("position"));

        alignColumnsToCenter();

        PlayerTable.setItems(players); // Set observable list to table
    }


    SocketWrapper socketWrapper;
    void setSocketWrapper(SocketWrapper socketWrapper)
    {
        this.socketWrapper = socketWrapper;
    }

    // Align all table columns to the center
    private void alignColumnsToCenter() {
        alignColumnToCenter(Name);
        alignColumnToCenter(Country);
        alignColumnToCenter(Position);
    }

    // Helper method to center-align column content
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
        if(UserName.equals("admin") ) obj.gotoMainMenuServer();
        else obj.gotoMainMenuClub(UserName);
    }

}
