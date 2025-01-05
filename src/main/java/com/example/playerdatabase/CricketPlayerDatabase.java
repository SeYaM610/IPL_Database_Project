package com.example.playerdatabase;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


public class CricketPlayerDatabase {
    private static final String INPUT_FILE_NAME = "D:\\Java_Project\\PlayerDatabase\\src\\players.txt";
     ArrayList<Player> playerList = new ArrayList<>();
    public CricketPlayerDatabase() {
        this.playerList = new ArrayList<>();
    }

    public  void AddingPlayersToDatabase()  throws Exception
    {
//        this.playerList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));

        while (true)
        {
            String line = br.readLine();
            if (line == null)
                break;

            String[] info = line.split(",");
            String name = info[0];
            String country = info[1];
            int age = Integer.parseInt(info[2]);
            double height = Double.parseDouble(info[3]);
            String club = info[4];
            String position = info[5];
            int number = -1;

            if (info.length > 6 && !info[6].isEmpty()) {
                number = Integer.parseInt(info[6]);
            }

            int salary = Integer.parseInt(info[info.length - 1]);
            Player p = new Player(name, country, age, height, club, position, number, salary);
            playerList.add(p); // Adding the player to the list

        }

        br.close();
    }

    public void deletePlayer(Player PlayerName, String NewClub) throws Exception {

        File inputFile = new File(INPUT_FILE_NAME);
        File tempFile = new File("temp_players.txt");

        // Ensure the input file exists
        if (!inputFile.exists()) {
            throw new FileNotFoundException("Players file not found: " + INPUT_FILE_NAME);
        }

        boolean success = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String currentLine;
            boolean playerFound = false;

            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.startsWith(PlayerName.getName() + ",") &&
                        currentLine.contains("," + PlayerName.getCountry() + ",")) {
                    // Write the updated player information
                    writer.write(formatPlayerLine(PlayerName, NewClub));
                    playerFound = true;
                } else {
                    writer.write(currentLine);
                    writer.write(System.lineSeparator());
                }
            }

            if (!playerFound) {
                // If player wasn't found, append them to the end
                writer.write(formatPlayerLine(PlayerName, NewClub));
            }

            success = true;
        } catch (IOException e) {
            throw new IOException("Error while processing the file: " + e.getMessage(), e);
        }

        // Only proceed with file replacement if the write was successful
        if (success) {
            try {
                // Make sure the original file is closed and writable
                if (inputFile.exists() && !inputFile.delete()) {
                    throw new IOException("Could not delete the original file");
                }
                if (!tempFile.renameTo(inputFile)) {
                    throw new IOException("Could not rename temp file to original file");
                }
            } catch (Exception e) {
                // If something goes wrong, try to restore the original file
                if (tempFile.exists()) {
                    tempFile.delete();
                }
                throw new IOException("Failed to update the player file: " + e.getMessage(), e);
            }
        }
    }

    private String formatPlayerLine(Player player, String newClub) {
        return String.format("%s,%s,%d,%.2f,%s,%s,%d,%d%n",
                player.getName(),
                player.getCountry(),
                player.getAge(),
                player.getHeight(),
                newClub,
                player.getPosition(),
                player.getJerseyNumber(),
                player.getWeeklySalary()
        );
    }




    ArrayList<Player> SearchingByName(String Name) throws Exception {
        AddingPlayersToDatabase();
        ArrayList<Player> playersName = new ArrayList<>();

        for(Player p : playerList)
        {
            if(p.getName().toLowerCase().contains(Name.toLowerCase()))
            {
                playersName.add(p);
            }
        }
        return playersName;
    }
    ArrayList<Player> SearchingByCountry(String Country) throws Exception {
        AddingPlayersToDatabase();
        ArrayList<Player> playersName = new ArrayList<>();

        for(Player p : playerList)
        {
            if(p.getCountry().equalsIgnoreCase(Country))
            {
                playersName.add(p);
            }
        }
        return playersName;
    }
    ArrayList<Player> SearchingByClub(String Club) throws Exception {
        AddingPlayersToDatabase();
        ArrayList<Player> playersName = new ArrayList<>();

        for(Player p : playerList)
        {
            if(p.getClub().equalsIgnoreCase(Club))
            {
                playersName.add(p);
            }
        }
        return playersName;
    }

    ArrayList<Player> SearchingByPosition(String Position) throws Exception {
        AddingPlayersToDatabase();
        ArrayList<Player> PlayersInPosition = new ArrayList<>();
        for(Player p : playerList)
        {
            if(p.getPosition().equalsIgnoreCase(Position))
            {
                PlayersInPosition.add(p);
            }
        }
        return PlayersInPosition;
    }

    ArrayList<Player> SearchingBySalary(int low,int high) throws Exception {
        AddingPlayersToDatabase();
        ArrayList<Player> PlayersWithSalary = new ArrayList<>();
        for(Player p : playerList)
        {
            if(p.getWeeklySalary() >=low && p.getWeeklySalary() <= high)
            {
                PlayersWithSalary.add(p);
            }
        }
        return PlayersWithSalary;
    }

    Map<String,Integer> CountryWiseCountPlayers() throws Exception {
        AddingPlayersToDatabase();
        Map<String,Integer> CountryWiseCount = new HashMap<>() ;
        for(Player p : playerList)
        {
            String country = p.getCountry();
            CountryWiseCount.put(country, CountryWiseCount.getOrDefault(country, 0)+1);
        }

        return CountryWiseCount;
    }

    Map<String,Integer> ClubWiseSalary() throws Exception {
        AddingPlayersToDatabase();
        Map<String,Integer> ClubWiSalary = new HashMap<>() ;
        for(Player p : playerList)
        {
            String club = p.getClub();
            ClubWiSalary.put(club, ClubWiSalary.getOrDefault(club, 0)+(p.getWeeklySalary()));
        }

        return ClubWiSalary;
    }


    ArrayList<Player> MaxSalaryInClub(String Club) throws Exception {
        AddingPlayersToDatabase();
        ArrayList<Player> PlayersWithMaxSalary = new ArrayList<>();
        int maxSalary=0;
        for(Player p : playerList)
        {
            if((p.getClub().equalsIgnoreCase(Club)) && (p.getWeeklySalary()> maxSalary)) {
                maxSalary = p.getWeeklySalary();
            }
        }
        for(Player p : playerList)
        {
            if((p.getClub().equalsIgnoreCase(Club)) && (p.getWeeklySalary()== maxSalary))
                PlayersWithMaxSalary.add(p);
        }
        return PlayersWithMaxSalary;
    }
    ArrayList<Player> MaxAgeInClub(String Club) throws Exception {
        AddingPlayersToDatabase();
        ArrayList<Player> PlayersWithMaxAge = new ArrayList<>();
        int maxAge=0;
        for(Player p : playerList)
        {
            if(p.getClub().equalsIgnoreCase(Club) && p.getAge()> maxAge)
                maxAge = p.getAge();
        }
        for(Player p : playerList)
        {
            if(p.getClub().equalsIgnoreCase(Club) && p.getAge() == maxAge)
                PlayersWithMaxAge.add(p);
        }
        return PlayersWithMaxAge;
    }
    ArrayList<Player> MaxHeightInClub(String Club) throws Exception {
        AddingPlayersToDatabase();
        ArrayList<Player> PlayersWithMaxHeight = new ArrayList<>();
        double maxHeight=0;
        for(Player p : playerList)
        {
            if(p.getClub().equalsIgnoreCase(Club) && p.getHeight()> maxHeight)
                maxHeight = p.getHeight();
        }
        for(Player p : playerList)
        {
            if(p.getClub().equalsIgnoreCase(Club) && p.getHeight() == maxHeight)
                PlayersWithMaxHeight.add(p);
        }
        return PlayersWithMaxHeight;
    }

    void AddingPlayersToFile(Player pl) throws Exception
    {
        AddingPlayersToDatabase();
        playerList.add(pl);
        BufferedWriter bw = new BufferedWriter(new FileWriter(INPUT_FILE_NAME));

        for(Player p : playerList) {
            if(p == pl)
            {
                bw.write(p.getName() + "," + p.getCountry() + "," + p.getAge() + "," + p.getHeight() + "," + "None" + "," + p.getPosition() + "," + p.getJerseyNumber() + "," + p.getWeeklySalary());
                bw.write(System.lineSeparator());
            }
            else {
                bw.write(p.getName() + "," + p.getCountry() + "," + p.getAge() + "," + p.getHeight() + "," + p.getClub() + "," + p.getPosition() + "," + p.getJerseyNumber() + "," + p.getWeeklySalary());
                bw.write(System.lineSeparator());
            }
        }
        bw.close();

        System.out.println("The data successfully written to the file.");
    }
}
