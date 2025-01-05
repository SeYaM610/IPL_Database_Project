package com.example.playerdatabase;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ClubMainMenuController {
    private String UserName;

    public ImageView jersey;
    public Label owner;
    public Label coach;
    public Label venue;
    public Label years;
    public Label ClubName;

    @FXML
    private TableView<Player> PlayerTable; // Table to display player data

    @FXML
    private TableColumn<Player, String> Name;

    @FXML
    private TableColumn<Player, String> Position;

    @FXML
    private TableColumn<Player, Integer> Weekly_Salary;

    @FXML
    private TableColumn<Player, Void> Status;

    CricketPlayerDatabase database = new CricketPlayerDatabase();
    Main obj;
    public void setObj(Main obj,String UserName) {
        this.obj = obj;
        this.UserName = UserName;
    }
    private final ObservableList<Player> players = FXCollections.observableArrayList();

    public void PlayerInfoTable(String ClubName) throws Exception {
        this.ClubName.setText(ClubName);;
        ArrayList<Player> playerList = database.SearchingByClub(ClubName);
        players.setAll(playerList); // Update observable list

        // Bind table columns to Player class fields
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Position.setCellValueFactory(new PropertyValueFactory<>("position"));
        Weekly_Salary.setCellValueFactory(new PropertyValueFactory<>("weeklySalary"));

        alignColumnsToCenter();

        addSellButtonColumn(); // Add "Sell" button to each row

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
    private void alignColumnsToCenter() {
        alignColumnToCenter(Name);
        alignColumnToCenter(Position);
        alignColumnToCenter(Weekly_Salary);
        alignColumnToCenter(Status);
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

    // Add a "Sell" button to the Status column
    private void addSellButtonColumn() {
        Status.setCellFactory(tc -> new TableCell<>() {
            private final Button sellButton = new Button("Sell");

            {
                sellButton.setOnAction(event -> {
                    Player player = (Player) getTableView().getItems().get(getIndex());
                    try {
                        sellPlayer(player);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

                sellButton.setStyle("-fx-background-color: #ff6666; -fx-text-fill: white; -fx-font-weight: bold;");
                sellButton.setAlignment(Pos.CENTER);
            }

//            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(sellButton);
                }
            }
        });
    }
    private void sellPlayer(Player player) throws Exception {
        players.remove(player); // Remove player from local list
        CricketPlayerDatabase database = new CricketPlayerDatabase();
        database.deletePlayer(player,"None");

        socketWrapper.write(player);

//        Platform.runLater(() -> obj.showAlert("Player Sold", "Player " + player.getName() + " has been sold."));
    }
    public ImageView image;

    @FXML
    public void setJersey(String userName)
    {
        this.UserName = userName;
        if(userName.equals("Chennai Super Kings") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/csk_jersey.jpg").toExternalForm());
            jersey.setImage(img);
            jersey.setFitWidth(300); // Resize
            jersey.setFitHeight(310);
            owner.setText("Chennai Super Kings Cricket Ltd.");
            coach.setText("Stephen Fleming");
            venue.setText("M. A. Chidambaram Stadium");
            years.setText(" 2010, 2011, 2018, 2021, 2023 ");
        }
        if(userName.equals("Delhi Capitals") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/dc_jersey.jpg").toExternalForm());
            jersey.setImage(img);
            jersey.setFitWidth(300); // Resize
            jersey.setFitHeight(310);
            owner.setText("GMR Sports Pvt. Ltd & JSW Sports Pvt Ltd");
            coach.setText("Hemang Badani");
            venue.setText("Arun Jaitley Stadium");
            years.setText("     -    ");
        }
        if(userName.equals("Gujarat Titans") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/gt_jersey.jpg").toExternalForm());
            jersey.setImage(img);
            jersey.setFitWidth(300); // Resize
            jersey.setFitHeight(310);
            owner.setText("CVC Capital Partners");
            coach.setText("Ashish Nehra");
            venue.setText("Narendra Modi Stadium");
            years.setText(" 2022 ");
        }
        if(userName.equals("Kolkata Knight Riders") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/kkr_jersey.jpg").toExternalForm());
            jersey.setImage(img);
            jersey.setFitWidth(300); // Resize
            jersey.setFitHeight(310);
            owner.setText("Knight Riders Sports Private Ltd");
            coach.setText("Chandrakant Pandit");
            venue.setText("Eden Gardens");
            years.setText(" 2012, 2014, 2024 ");
        }
        if(userName.equals("Lucknow Super Giants") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/lsg_jersey.jpg").toExternalForm());
            jersey.setImage(img);
            jersey.setFitWidth(300); // Resize
            jersey.setFitHeight(310);
            owner.setText("RPSG Group");
            coach.setText("Justin Langer");
            venue.setText("BRSABV Ekana Cricket Stadium");
            years.setText("     -    ");
        }
        if(userName.equals("Mumbai Indians") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/mi_jersey.png").toExternalForm());
            jersey.setImage(img);
            jersey.setFitWidth(300); // Resize
            jersey.setFitHeight(310);
            owner.setText("Indiawin Sports Pvt. Ltd");
            coach.setText("Mahela Jayawardene");
            venue.setText("Wankhede Stadium");
            years.setText(" 2013, 2015, 2017, 2019, 2020 ");
        }
        if(userName.equals("Punjab Kings") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/pk_jersey.jpg").toExternalForm());
            jersey.setImage(img);
            jersey.setFitWidth(300); // Resize
            jersey.setFitHeight(310);
            owner.setText("KPH Dream Cricket Private Limited");
            coach.setText("Ricky Ponting");
            venue.setText("PCA New Stadium, Mullanpur");
            years.setText("     -    ");
        }
        if(userName.equals("Rajasthan Royals") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/rr_jersey.jpg").toExternalForm());
            jersey.setImage(img);
            jersey.setFitWidth(300); // Resize
            jersey.setFitHeight(310);
            owner.setText("The Royals Sports Group");
            coach.setText("Rahul Dravid");
            venue.setText("Sawai Mansingh Stadium");
            years.setText(" 2008 ");
        }
        if(userName.equals("Royal Challengers Bangalore") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/rcb_jersey.jpg").toExternalForm());
            jersey.setImage(img);
            jersey.setFitWidth(300); // Resize
            jersey.setFitHeight(310);
            owner.setText("United Spirits Limited (USL)");
            coach.setText("Andy Flower");
            venue.setText("M. Chinnaswamy Stadium");
            years.setText("     -    ");
        }
        if(userName.equals("Sunrisers Hyderabad") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/srh_jersey.jpg").toExternalForm());
            jersey.setImage(img);
            jersey.setFitWidth(300); // Resize
            jersey.setFitHeight(310);
            owner.setText("SUN TV Network");
            coach.setText("Daniel Vettori");
            venue.setText("Rajiv Gandhi Intl. Cricket Stadium");
            years.setText(" 2016 ");
        }

    }

    @FXML
    public void setImage(String username) {
        UserName = username;

        if(username.equals("Chennai Super Kings") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/csk.png").toExternalForm());
            image.setImage(img);
            image.setFitWidth(320); // Resize
            image.setFitHeight(240);
        }
        if(username.equals("Delhi Capitals") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/dc.png").toExternalForm());
            image.setImage(img);
            image.setFitWidth(320); // Resize
            image.setFitHeight(240);
        }
        if(username.equals("Gujarat Titans") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/gt.png").toExternalForm());
            image.setImage(img);
            image.setFitWidth(320); // Resize
            image.setFitHeight(240);
        }
        if(username.equals("Kolkata Knight Riders") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/kkr.png").toExternalForm());
            image.setImage(img);
            image.setFitWidth(320); // Resize
            image.setFitHeight(240);
        }
        if(username.equals("Lucknow Super Giants") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/Lsg.png").toExternalForm());
            image.setImage(img);
            image.setFitWidth(320); // Resize
            image.setFitHeight(240);
        }
        if(username.equals("Mumbai Indians") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/mi.png").toExternalForm());
            image.setImage(img);
            image.setFitWidth(320); // Resize
            image.setFitHeight(240);
        }
        if(username.equals("Punjab Kings") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/pk.png").toExternalForm());
            image.setImage(img);
            image.setFitWidth(320); // Resize
            image.setFitHeight(240);
        }
        if(username.equals("Rajasthan Royals") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/rr.png").toExternalForm());
            image.setImage(img);
            image.setFitWidth(320); // Resize
            image.setFitHeight(240);
        }
        if(username.equals("Royal Challengers Bangalore") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/rcb.png").toExternalForm());
            image.setImage(img);
            image.setFitWidth(320); // Resize
            image.setFitHeight(240);
        }
        if(username.equals("Sunrisers Hyderabad") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/srh.png").toExternalForm());
            image.setImage(img);
            image.setFitWidth(320); // Resize
            image.setFitHeight(240);
        }


    }

    public void OnClickSearchPlayer(ActionEvent actionEvent) throws IOException {
        obj.gotoPlayerSearch(UserName);
    }

    public void OnClickSearchClub(ActionEvent actionEvent) throws IOException {
        obj.gotoClubSearch(UserName);
    }

    public void OnCllickLogOut(ActionEvent actionEvent) throws IOException {
        obj.gotoHome();
    }
    Stage stage;
    public void setStage(Stage stage)
    {
        this.stage = stage;
    }

    SocketWrapper socketWrapper;
    void setSocketWrapper(SocketWrapper socketWrapper)
    {
        this.socketWrapper = socketWrapper;
    }

    public void OnClickAvailablePlayers(ActionEvent actionEvent) throws Exception {

        PlayerAvailableController pa = new PlayerAvailableController();
        pa.LoadAvailablePlayer(UserName,stage,socketWrapper,obj);
    }
}
