package com.example.playerdatabase;

import java.io.Serializable;
import java.lang.String;

public class Player implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String country;
    private int age;
    private double height;
    private String club;
    private String position;
    private int jerseyNumber;
    private int weeklySalary;

    Player(String Name,String Country,int Age,double Height,String CLub,String Position,int Jersey_Number,int Weekly_Salary)
    {
        this.name = Name;
        this.country = Country;
        this.age = Age;
        this.height = Height;
        this.club = CLub;
        this.position = Position;
        this.jerseyNumber = Jersey_Number;
        this.weeklySalary = Weekly_Salary;
    }
//    @Override
//    public java.lang.String toString() {
//        return "\nName : " + Name + "\nCountry : " + Country + "\nAge : " + Age +  "\nHeight : " + Height + "\nClub : " + CLub + "\nPosition : " + Position + "\nJersey Number : " + Jersey_Number + "\nWeekly Salary : " + Weekly_Salary + "\n";
//    }
public String getName() { return name; }
    public String getCountry() { return country; }
    public int getAge() { return age; }
    public double getHeight() { return height; }
    public String getClub() { return club; }
    public String getPosition() { return position; }
    public int getJerseyNumber() { return jerseyNumber; }
    public int getWeeklySalary() { return weeklySalary; }

    public void setClub(String Club)
    {
        this.club = Club;
    }
}
