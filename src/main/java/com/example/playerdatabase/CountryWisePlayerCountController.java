package com.example.playerdatabase;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

class CountryPlayerData {
    private String country;
    private Integer playerCount;

    public CountryPlayerData(String country, Integer playerCount) {
        this.country = country;
        this.playerCount = playerCount;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(Integer playerCount) {
        this.playerCount = playerCount;
    }
}

public class CountryWisePlayerCountController {
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

    @FXML
    private TableView<CountryPlayerData> PlayerTable; // Table to display player data

    @FXML
    private TableColumn<CountryPlayerData, String> Country;

    @FXML
    private TableColumn<CountryPlayerData, Integer> playerCount;

    // Setter for the main application object
    public void setObj(Main obj) {
        this.obj = obj;
    }

    // Method to populate the table with data
    public void PlayerInfoTable(Map<String, Integer> CountryWiseCount) {
        // Create an ObservableList to hold table data
        ObservableList<CountryPlayerData> tableData = FXCollections.observableArrayList();

        // Populate ObservableList from the map
        for (Map.Entry<String, Integer> entry : CountryWiseCount.entrySet()) {
            tableData.add(new CountryPlayerData(entry.getKey(), entry.getValue()));
        }

        // Bind table columns to data model fields
        Country.setCellValueFactory(new PropertyValueFactory<>("country"));
        playerCount.setCellValueFactory(new PropertyValueFactory<>("playerCount"));

        // Set the data to the TableView
        PlayerTable.setItems(tableData);

        alignColumnsToCenter(); // Assuming this method aligns columns to center
    }

    // Data model for the table rows
    public static class CountryPlayerData {
        private final String country;
        private final Integer playerCount;

        public CountryPlayerData(String country, Integer playerCount) {
            this.country = country;
            this.playerCount = playerCount;
        }

        public String getCountry() {
            return country;
        }

        public Integer getPlayerCount() {
            return playerCount;
        }
    }


    SocketWrapper socketWrapper;
    void setSocketWrapper(SocketWrapper socketWrapper)
    {
        this.socketWrapper = socketWrapper;
    }

    // Align all table columns to the center
    private void alignColumnsToCenter() {

        alignColumnToCenter(Country);
        alignColumnToCenter(playerCount);
    }

    // Helper method to center-align column content
    private <T> void alignColumnToCenter(TableColumn<CountryPlayerData, T> column) {
        column.setCellFactory(tc -> {
            TableCell<CountryPlayerData, T> cell = new TableCell<>() {
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
