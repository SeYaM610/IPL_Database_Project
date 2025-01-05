package com.example.playerdatabase;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
//import org.json.JSONArray;
//import org.json.JSONObject;

public class PlayerDetailsController {

    public ImageView jersey;
    public Label ClubName;
    public Label name;
    public Label country;
    public Label age;
    public Label height;
    public Label Position;
    public Label jerseyNum;
    public Label salary;
    public ImageView playerPic;
    public ImageView flag;
    public ImageView position;
    public ImageView ClubLogo;
    String UserName;

    private Main obj; // Reference to Main for navigation
    public void setObj(Main obj) {
        this.obj = obj;
    }
    SocketWrapper socketWrapper;
    void setSocketWrapper(SocketWrapper socketWrapper)
    {
        this.socketWrapper = socketWrapper;
    }


    void LoadPlayerDetails(Player p ,String UserName)
    {
        this.UserName = UserName;
        ClubName.setText(UserName);
        name.setText(p.getName());
        country.setText(p.getCountry());
        age.setText(String.valueOf(p.getAge()) + " years old");
        height.setText("Height " +String.valueOf(p.getHeight()) + " meter");
        Position.setText(p.getPosition());
        jerseyNum.setText("Jersey No. " +String.valueOf(p.getJerseyNumber()));
        salary.setText("Weekly Salary "+String.valueOf(p.getWeeklySalary())+" Rupees");

        if(p.getPosition().equals("Wicketkeeper"))
        {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/keeper.jpg").toExternalForm());
            position.setImage(img);
            position.setFitWidth(146); // Resize
            position.setFitHeight(119);
        }
        if(p.getPosition().equals("Batsman"))
        {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/batsman.png").toExternalForm());
            position.setImage(img);
            position.setFitWidth(146); // Resize
            position.setFitHeight(119);
        }
        if(p.getPosition().equals("Bowler"))
        {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/bowler.jpg").toExternalForm());
            position.setImage(img);
            position.setFitWidth(146); // Resize
            position.setFitHeight(119);
        }
        if(p.getPosition().equals("Allrounder"))
        {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/allrounder.jpg").toExternalForm());
            position.setImage(img);
            position.setFitWidth(146); // Resize
            position.setFitHeight(119);
        }


        if(UserName.equals("Chennai Super Kings") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/csk_jersey.jpg").toExternalForm());
            jersey.setImage(img);
            jersey.setFitWidth(302); // Resize
            jersey.setFitHeight(313);
            Image im = new Image(getClass().getResource("/com/example/playerdatabase/images/csk.png").toExternalForm());
            ClubLogo.setImage(im);
            ClubLogo.setFitWidth(308); // Resize
            ClubLogo.setFitHeight(201);
            ClubName.setText(UserName);
        }
        if(UserName.equals("Delhi Capitals") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/dc_jersey.jpg").toExternalForm());
            jersey.setImage(img);
            jersey.setFitWidth(302); // Resize
            jersey.setFitHeight(313);
            Image im = new Image(getClass().getResource("/com/example/playerdatabase/images/dc.png").toExternalForm());
            ClubLogo.setImage(im);
            ClubLogo.setFitWidth(308); // Resize
            ClubLogo.setFitHeight(201);
            ClubName.setText(UserName);
        }
        if(UserName.equals("Gujarat Titans") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/gt_jersey.jpg").toExternalForm());
            jersey.setImage(img);
            jersey.setFitWidth(302); // Resize
            jersey.setFitHeight(313);
            Image im = new Image(getClass().getResource("/com/example/playerdatabase/images/gt.png").toExternalForm());
            ClubLogo.setImage(im);
            ClubLogo.setFitWidth(308); // Resize
            ClubLogo.setFitHeight(201);
            ClubName.setText(UserName);
        }
        if(UserName.equals("Kolkata Knight Riders") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/kkr_jersey.jpg").toExternalForm());
            jersey.setImage(img);
            jersey.setFitWidth(302); // Resize
            jersey.setFitHeight(313);
            Image im = new Image(getClass().getResource("/com/example/playerdatabase/images/kkr.png").toExternalForm());
            ClubLogo.setImage(im);
            ClubLogo.setFitWidth(308); // Resize
            ClubLogo.setFitHeight(201);
            ClubName.setText(UserName);
        }
        if(UserName.equals("Lucknow Super Giants") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/lsg_jersey.jpg").toExternalForm());
            jersey.setImage(img);
            jersey.setFitWidth(302); // Resize
            jersey.setFitHeight(313);
            Image im = new Image(getClass().getResource("/com/example/playerdatabase/images/Lsg.png").toExternalForm());
            ClubLogo.setImage(im);
            ClubLogo.setFitWidth(308); // Resize
            ClubLogo.setFitHeight(201);
            ClubName.setText(UserName);
        }
        if(UserName.equals("Mumbai Indians") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/mi_jersey.png").toExternalForm());
            jersey.setImage(img);
            jersey.setFitWidth(302); // Resize
            jersey.setFitHeight(313);
            Image im = new Image(getClass().getResource("/com/example/playerdatabase/images/mi.png").toExternalForm());
            ClubLogo.setImage(im);
            ClubLogo.setFitWidth(308); // Resize
            ClubLogo.setFitHeight(201);
            ClubName.setText(UserName);
        }
        if(UserName.equals("Punjab Kings") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/pk_jersey.jpg").toExternalForm());
            jersey.setImage(img);
            jersey.setFitWidth(302); // Resize
            jersey.setFitHeight(313);
            Image im = new Image(getClass().getResource("/com/example/playerdatabase/images/pk.png").toExternalForm());
            ClubLogo.setImage(im);
            ClubLogo.setFitWidth(308); // Resize
            ClubLogo.setFitHeight(201);
            ClubName.setText(UserName);
        }
        if(UserName.equals("Rajasthan Royals") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/rr_jersey.jpg").toExternalForm());
            jersey.setImage(img);
            jersey.setFitWidth(302); // Resize
            jersey.setFitHeight(313);
            Image im = new Image(getClass().getResource("/com/example/playerdatabase/images/rr.png").toExternalForm());
            ClubLogo.setImage(im);
            ClubLogo.setFitWidth(308); // Resize
            ClubLogo.setFitHeight(201);
            ClubName.setText(UserName);
        }
        if(UserName.equals("Royal Challengers Bangalore") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/rcb_jersey.jpg").toExternalForm());
            jersey.setImage(img);
            jersey.setFitWidth(302); // Resize
            jersey.setFitHeight(313);
            Image im = new Image(getClass().getResource("/com/example/playerdatabase/images/rcb.png").toExternalForm());
            ClubLogo.setImage(im);
            ClubLogo.setFitWidth(308); // Resize
            ClubLogo.setFitHeight(201);
            ClubName.setText(UserName);
        }
        if(UserName.equals("Sunrisers Hyderabad") ) {
            Image img = new Image(getClass().getResource("/com/example/playerdatabase/images/srh_jersey.jpg").toExternalForm());
            jersey.setImage(img);
            jersey.setFitWidth(302); // Resize
            jersey.setFitHeight(313);
            Image im = new Image(getClass().getResource("/com/example/playerdatabase/images/srh.png").toExternalForm());
            ClubLogo.setImage(im);
            ClubLogo.setFitWidth(308); // Resize
            ClubLogo.setFitHeight(201);
            ClubName.setText(UserName);
        }
    }



    public void OnCLickBack(ActionEvent actionEvent) throws Exception {
        if(UserName.equals("admin") ) obj.gotoMainMenuServer();
        else obj.gotoMainMenuClub(UserName);
    }


//    private static final String API_KEY = "YOUR_BING_API_KEY"; // Replace with your Bing API key
//    private static final String ENDPOINT = "https://api.bing.microsoft.com/v7.0/images/search";
//
//    public static String searchImageUrl(String playerName) {
//        try {
//            HttpClient client = HttpClient.newHttpClient();
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create(ENDPOINT + "?q=" + playerName.replace(" ", "+") + "+cricket"))
//                    .header("Ocp-Apim-Subscription-Key", API_KEY)
//                    .build();
//
//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//            JSONObject json = new JSONObject(response.body());
//
//            // Get the first image result
//            JSONArray imageResults = json.getJSONArray("value");
//            if (imageResults.length() > 0) {
//                return imageResults.getJSONObject(0).getString("contentUrl");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null; // Return null if no image found or an error occurs
//    }
}
