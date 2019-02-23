/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project44;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Black2
 */
public class GameOpponents implements Serializable{
    private String Name;
    private Car car;
    private int DefeatedTimes;
    private int WinTimes;
    private int RivalWon;
    private int PlayerWon;
    private int Experience; //should be between 200 and 1000;
    ArrayList<GameOpponents> allGameOpponents = new ArrayList();
    public GameOpponents()
    {
        this.getAllGameOpponents();
    }
    private GameOpponents(String OpponentName, Car OpponentCar, int exp, 
            int CarNitrousLevel, int CarTransmissionLevel, int CarTurboLevel, int CarEngineLevel)
    {
        this.DefeatedTimes = 0;
        this.WinTimes = 0;
        this.RivalWon = 0;
        this.PlayerWon = 0;
        this.Name = OpponentName;
        this.car = OpponentCar;
        this.Experience = exp;
        switch(CarNitrousLevel)
        {
            case 1:{this.car.NitrousLevel1Upgrade();break;}
            case 2:{this.car.NitrousLevel2Upgrade();break;}
            case 3:{this.car.NitrousLevel3Upgrade();break;}
            default: {break;}
        }
        switch(CarTransmissionLevel)
        {
            case 1:{this.car.TransmissionLevel1Upgrade();break;}
            case 2:{this.car.TransmissionLevel2Upgrade();break;}
            case 3:{this.car.TransmissionLevel3Upgrade();break;}
            default: {break;}
        }
        switch(CarTurboLevel)
        {
            case 1:{this.car.TurboLevel1Upgrade();break;}
            case 2:{this.car.TurboLevel2Upgrade();break;}
            case 3:{this.car.TurboLevel3Upgrade();break;}
            default: {break;}
        }
        switch(CarEngineLevel)
        {
            case 1:{this.car.EngineLevel1Upgrade();break;}
            case 2:{this.car.EngineLevel2Upgrade();break;}
            case 3:{this.car.EngineLevel3Upgrade();break;}
            default: {break;}
        }
    }
    public String getOpponentName()
    {
        return this.Name;
    }
    public Car getOpponentCar()
    {
        return this.car;
    }
    public int getOpponentExp()
    {
        return this.Experience;
    }
    private void getAllGameOpponents()
    {
        CarLot cars = new CarLot();
        allGameOpponents.add(new GameOpponents ("Richard Marx", cars.getCarFromLot("Toyota Corolla"),
        200, 0, 0, 0, 0));
        allGameOpponents.add(new GameOpponents ("Adam Lennox", cars.getCarFromLot("BMW 650i"),
        210, 0, 0, 0, 0));
        allGameOpponents.add(new GameOpponents ("Rachel Fortran", cars.getCarFromLot("Chrysler 300C SRT-8"),
        220, 0, 0, 0, 0));
        allGameOpponents.add(new GameOpponents ("Alexis Quatez", cars.getCarFromLot("Ford Flex"),
        260, 0, 0, 0, 0));
        allGameOpponents.add(new GameOpponents ("Dina Angel", cars.getCarFromLot("Renault Clio RS"),
        300, 0, 0, 0, 0));
        allGameOpponents.add(new GameOpponents ("Viktor Carten", cars.getCarFromLot("Voltzwagen Golf GTI"),
        200, 0, 0, 0, 0));
        allGameOpponents.add(new GameOpponents ("John Flanagan", cars.getCarFromLot("Toyota Supra"),
        225, 0, 0, 0, 0));
        allGameOpponents.add(new GameOpponents ("Remus Fiore", cars.getCarFromLot("Mitsubishi Eclipse"),
        240, 0, 0, 0, 0));
        allGameOpponents.add(new GameOpponents ("John Lampard", cars.getCarFromLot("Porche Cayman S"),
        270, 0, 0, 0, 0));
        allGameOpponents.add(new GameOpponents ("Liam Shephard", cars.getCarFromLot("Renault Megane"),
        280, 0, 0, 0, 0));
        allGameOpponents.add(new GameOpponents ("Theodore Migel", cars.getCarFromLot("Audi TT"),
        230, 0, 0, 0, 0));
        allGameOpponents.add(new GameOpponents ("Rick Endel", cars.getCarFromLot("Aston Martin DB9"),
        240, 0, 0, 0, 0));
        allGameOpponents.add(new GameOpponents ("Maria Lavigne", cars.getCarFromLot("Mazda RX-8"),
        230, 0, 0, 0, 0));
        allGameOpponents.add(new GameOpponents ("Deni Flack", cars.getCarFromLot("Chevrolet Camaro"),
        300, 0, 0, 0, 0));
        allGameOpponents.add(new GameOpponents ("Darren Smith", cars.getCarFromLot("BMW 650i"),
        240, 1, 0, 1, 0));
        allGameOpponents.add(new GameOpponents ("Jeene Solomon", cars.getCarFromLot("Voltzwagen Golf GTI"),
        410, 1, 0, 1, 0));
        allGameOpponents.add(new GameOpponents ("Danny Fail", cars.getCarFromLot("Mitsubishi Eclipse"),
        300, 1, 0, 1, 0));
        allGameOpponents.add(new GameOpponents ("Alicia Fino", cars.getCarFromLot("Toyota Supra"),
        250, 1, 0, 1, 0));
        allGameOpponents.add(new GameOpponents ("Andrew Wolf", cars.getCarFromLot("Renault Megane"),
        240, 1, 0, 1, 1));
        allGameOpponents.add(new GameOpponents ("Dennis Dew", cars.getCarFromLot("Nissan 350z Coupe"),
        310, 1, 0, 1, 1));
        allGameOpponents.add(new GameOpponents ("Sonny Fee", cars.getCarFromLot("Mitsubishi Eclipse"),
        290, 1, 0, 1, 1));
        allGameOpponents.add(new GameOpponents ("Johnny Tango", cars.getCarFromLot("Porche Cayman S"),
        320, 1, 0, 1, 1));
        allGameOpponents.add(new GameOpponents ("Michelle Rodriguez", cars.getCarFromLot("Mazda RX-8"),
        290, 1, 0, 1, 1));
        allGameOpponents.add(new GameOpponents ("Emmanuel Syndrome", cars.getCarFromLot("Chevrolet Camaro"),
        305, 1, 0, 1, 1));
        allGameOpponents.add(new GameOpponents ("Tina Head", cars.getCarFromLot("Ferrari 458"),
        315, 1, 1, 0, 1));
        allGameOpponents.add(new GameOpponents ("Mark Train", cars.getCarFromLot("Chevrolet Camaro Concept"),
        335, 1, 1, 0, 1));
        allGameOpponents.add(new GameOpponents ("Rico Rodrigo", cars.getCarFromLot("Toyota Supra"),
        345, 1, 2, 1, 1));
        allGameOpponents.add(new GameOpponents ("Adam Mecer", cars.getCarFromLot("Subaru Impreza WRX STI"),
        325, 1, 2, 1, 1));
        allGameOpponents.add(new GameOpponents ("Alexis Alegro", cars.getCarFromLot("Aston Martin DB9"),
        365, 0, 2, 1, 1));
        allGameOpponents.add(new GameOpponents ("Jean Sedan", cars.getCarFromLot("Nissan 350z Coupe"),
        405, 1, 2, 2, 1));
        allGameOpponents.add(new GameOpponents ("Jimmy Boy", cars.getCarFromLot("Chevrolet Camaro Concept"),
        395, 0, 2, 2, 2));
        allGameOpponents.add(new GameOpponents ("Dan Alanovic", cars.getCarFromLot("BMW M3"),
        405, 1, 2, 2, 2));
        allGameOpponents.add(new GameOpponents ("Sean Reno", cars.getCarFromLot("Porche Cayman S"),
        355, 2, 2, 0, 2));
        allGameOpponents.add(new GameOpponents ("Denis Flocky", cars.getCarFromLot("Ferrari 458"),
        390, 2, 2, 0, 2));
        allGameOpponents.add(new GameOpponents ("Maria Karren", cars.getCarFromLot("Audi TT"),
        425, 2, 2, 1, 2));
        allGameOpponents.add(new GameOpponents ("Radu Florinov", cars.getCarFromLot("Voltzwagen Golf GTI"),
        445, 2, 2, 2, 2));
        allGameOpponents.add(new GameOpponents ("Anie Richman", cars.getCarFromLot("Nissan Skyline GT-R"),
        485, 2, 0, 0, 1));
        allGameOpponents.add(new GameOpponents ("Adam Swing", cars.getCarFromLot("Porche 911 Turbo S"),
        345, 2, 0, 0, 1));
        allGameOpponents.add(new GameOpponents ("Fino Andonic", cars.getCarFromLot("Porche Cayman S"),
        445, 2, 1, 1, 1));
        allGameOpponents.add(new GameOpponents ("Anton Flore", cars.getCarFromLot("Subaru Impreza WRX STI"),
        495, 2, 3, 1, 1));
        allGameOpponents.add(new GameOpponents ("Anna Diello", cars.getCarFromLot("Ford Flex"),
        475, 3, 3, 1, 1));
        allGameOpponents.add(new GameOpponents ("Adam Limbo", cars.getCarFromLot("Toyota Corolla"),
        435, 3, 3, 1, 1));
        allGameOpponents.add(new GameOpponents ("Eric Duenno", cars.getCarFromLot("BMW M3"),
        335, 3, 0, 1, 1));
        allGameOpponents.add(new GameOpponents ("Anthony Parking", cars.getCarFromLot("Chrysler 300C SRT-8"),
        435, 2, 2, 2, 1));
        allGameOpponents.add(new GameOpponents ("Annie Bee", cars.getCarFromLot("Dodge Viper GTS"),
        425, 0, 0, 0, 0));
        allGameOpponents.add(new GameOpponents ("Anatoly Shring", cars.getCarFromLot("Nissan Skyline GT-R"),
        465, 0, 3, 0, 3));
        allGameOpponents.add(new GameOpponents ("Denny Queen", cars.getCarFromLot("Renault Clio RS"),
        485, 0, 3, 1, 3));
        allGameOpponents.add(new GameOpponents ("Gerrard Lorren", cars.getCarFromLot("Ferrari 458"),
        495, 0, 3, 1, 2));
        allGameOpponents.add(new GameOpponents ("Harry Joggin", cars.getCarFromLot("Chevrolet Camaro Concept"),
        465, 2, 3, 1, 2));
        allGameOpponents.add(new GameOpponents ("Dean Anderson", cars.getCarFromLot("Subaru Legacy Concept"),
        495, 2, 3, 1, 2));
        allGameOpponents.add(new GameOpponents ("Diana Fluffy", cars.getCarFromLot("Subaru Impreza WRX STI"),
        520, 2, 3, 1, 2));
        allGameOpponents.add(new GameOpponents ("Ricky Povelic", cars.getCarFromLot("Chevrolet Corvette Z06"),
        530, 0, 0, 1, 0));
        allGameOpponents.add(new GameOpponents ("Mickey Ronckey", cars.getCarFromLot("Toyota Supra"),
        515, 1, 3, 3, 3));
        allGameOpponents.add(new GameOpponents ("Giovanni Freedom", cars.getCarFromLot("Ferrari 458"),
        455, 1, 3, 3, 3));
        allGameOpponents.add(new GameOpponents ("Nick Feeno", cars.getCarFromLot("BMW M3"),
        555, 1, 0, 0, 3));
        allGameOpponents.add(new GameOpponents ("Angel Duma", cars.getCarFromLot("Dodge Viper GTS"),
        455, 1, 0, 0, 3));
        allGameOpponents.add(new GameOpponents ("Dragomir Erendem", cars.getCarFromLot("Mitsubishi Eclipse"),
        490, 3, 2, 3, 3));
        allGameOpponents.add(new GameOpponents ("Edward Sunrise", cars.getCarFromLot("Lamborghini Gallardo"),
        540, 0, 0, 0, 0));
        allGameOpponents.add(new GameOpponents ("Eddie Sindie", cars.getCarFromLot("Chrysler 300C SRT-8"),
        595, 2, 3, 3, 2));
        allGameOpponents.add(new GameOpponents ("Tom Ender", cars.getCarFromLot("Chevrolet Camaro Concept"),
        575, 3, 1, 2, 2));
        allGameOpponents.add(new GameOpponents ("Andy Torres", cars.getCarFromLot("Lamborghini Aventador"),
        580, 0, 0, 0, 0));
        allGameOpponents.add(new GameOpponents ("George Lee", cars.getCarFromLot("Audi TT"),
        590, 2, 2, 3, 3));
        allGameOpponents.add(new GameOpponents ("Paul Luk", cars.getCarFromLot("Nissan Skyline GT-R"),
        600, 2, 2, 3, 3));
        allGameOpponents.add(new GameOpponents ("Lauren Amy", cars.getCarFromLot("Chevrolet Corvette Z06"),
        600, 0, 1, 1, 1));
        allGameOpponents.add(new GameOpponents ("Sean Frozy", cars.getCarFromLot("Ford Mustang GT"),
        610, 2, 1, 1, 1));
        allGameOpponents.add(new GameOpponents ("Alan Waste", cars.getCarFromLot("Porche Cayman S"),
        620, 2, 3, 3, 2));
        allGameOpponents.add(new GameOpponents ("Sean Laure", cars.getCarFromLot("Renault Megane"),
        650, 3, 3, 3, 2));
        allGameOpponents.add(new GameOpponents ("Rickard Samuel", cars.getCarFromLot("Dodge Viper GTS"),
        630, 3, 2, 2, 2));
        allGameOpponents.add(new GameOpponents ("Louie Erren", cars.getCarFromLot("Mitsubishi Lancer Evolution IX"),
        660, 1, 2, 2, 2));
        allGameOpponents.add(new GameOpponents ("Erick Delta", cars.getCarFromLot("Chevrolet Camaro Concept"),
        655, 3, 2, 3, 2));
        allGameOpponents.add(new GameOpponents ("Larra Elwin", cars.getCarFromLot("Subaru Impreza WRX STI"),
        655, 3, 3, 3, 2));
        allGameOpponents.add(new GameOpponents ("Adrian Shea", cars.getCarFromLot("Lamborghini Gallardo"),
        685, 3, 0, 0, 2));
        allGameOpponents.add(new GameOpponents ("Ady Shock", cars.getCarFromLot("Ferrari 458"),
        680, 3, 2, 0, 2));
        allGameOpponents.add(new GameOpponents ("Laura Rock", cars.getCarFromLot("Mitsubishi Lancer Evolution IX"),
        685, 3, 2, 0, 2));
        allGameOpponents.add(new GameOpponents ("Sarrah Belle", cars.getCarFromLot("Ford Mustang GT"),
        670, 3, 2, 1, 2));
        allGameOpponents.add(new GameOpponents ("Paris Sand", cars.getCarFromLot("Chevrolet Corvette Z06"),
        695, 3, 2, 2, 2));
        allGameOpponents.add(new GameOpponents ("Theo Sick", cars.getCarFromLot("Dodge Viper GTS"),
        705, 3, 2, 0, 0));
        allGameOpponents.add(new GameOpponents ("Larry Glew", cars.getCarFromLot("Lamborghini Gallardo"),
        715, 3, 2, 1, 1));
        allGameOpponents.add(new GameOpponents ("Kyle Harington", cars.getCarFromLot("Ferrari 575 GTC"),
        715, 3, 2, 3, 1));
        allGameOpponents.add(new GameOpponents ("Denise Robinson", cars.getCarFromLot("Lamborghini Haracan"),
        735, 3, 1, 3, 1));
        allGameOpponents.add(new GameOpponents ("Angie Flores", cars.getCarFromLot("Audi A7"),
        735, 3, 3, 3, 3));
        allGameOpponents.add(new GameOpponents ("Sonia Fleor", cars.getCarFromLot("BMW Z4"),
        750, 3, 1, 3, 3));
        allGameOpponents.add(new GameOpponents ("Ricky Simppie", cars.getCarFromLot("Ferrari 575 GTC"),
        740, 3, 1, 3, 3));
        allGameOpponents.add(new GameOpponents ("Flavia Wiener", cars.getCarFromLot("Lamborghini Spyder"),
        780, 2, 1, 3, 3));
        allGameOpponents.add(new GameOpponents ("Erika Weifeller", cars.getCarFromLot("Dodge Challenger"),
        760, 2, 3, 3, 3));
        allGameOpponents.add(new GameOpponents ("Dianna Climp", cars.getCarFromLot("Audi A5"),
        790, 3, 3, 3, 3));
        allGameOpponents.add(new GameOpponents ("Dilon Edhampton", cars.getCarFromLot("BMW X6M"),
        790, 3, 3, 3, 3));
        allGameOpponents.add(new GameOpponents ("Michael Fodge", cars.getCarFromLot("Mitsubishi Outlander"),
        790, 3, 3, 3, 3));
        allGameOpponents.add(new GameOpponents ("Trevor Wayne", cars.getCarFromLot("Toyota Yaris"),
        810, 3, 3, 3, 3));
        allGameOpponents.add(new GameOpponents ("Frank Cisco", cars.getCarFromLot("Lamborghini Spyder"),
        810, 3, 1, 2, 3));
        allGameOpponents.add(new GameOpponents ("Demi Mayre", cars.getCarFromLot("Lamborghini Haracan"),
        810, 2, 3, 2, 3));
        allGameOpponents.add(new GameOpponents ("Philip Spectre", cars.getCarFromLot("BMW X1"),
        860, 3, 3, 3, 3));
        allGameOpponents.add(new GameOpponents ("Elder Melloni", cars.getCarFromLot("Subaru Impreza WRX STI"),
        825, 3, 3, 3, 3));
        allGameOpponents.add(new GameOpponents ("Aaron Pierce", cars.getCarFromLot("Porche Cayman S"),
        825, 3, 3, 3, 3));
        allGameOpponents.add(new GameOpponents ("Cramp Lee", cars.getCarFromLot("Mitsubishi Outlander"),
        825, 3, 3, 3, 3));
        allGameOpponents.add(new GameOpponents ("Alee Simson", cars.getCarFromLot("Voltzwagen Jetta"),
        845, 3, 3, 3, 3));
        allGameOpponents.add(new GameOpponents ("Angeline Sorrielle", cars.getCarFromLot("Lexus LS 460"),
        845, 3, 3, 3, 3));
        allGameOpponents.add(new GameOpponents ("Ral Deskton", cars.getCarFromLot("Honda Civic"),
        855, 3, 3, 3, 3));
        allGameOpponents.add(new GameOpponents ("Sonia Renno", cars.getCarFromLot("Audi A7"),
        895, 3, 3, 3, 3));
        allGameOpponents.add(new GameOpponents ("Emper Sword", cars.getCarFromLot("BMW Z4"),
        885, 3, 3, 3, 3));
        allGameOpponents.add(new GameOpponents ("Allan Speedster", cars.getCarFromLot("Lamborghini Gallardo"),
        895, 3, 3, 3, 3));
        allGameOpponents.add(new GameOpponents ("Hector Oracle", cars.getCarFromLot("Voltzwagen Jetta"),
        905, 3, 3, 3, 3));
        allGameOpponents.add(new GameOpponents ("Francois Junior", cars.getCarFromLot("Dodge Challenger"),
        905, 3, 3, 3, 3));
        allGameOpponents.add(new GameOpponents ("Charles Logan", cars.getCarFromLot("Lamborghini Spyder"),
        895, 3, 3, 3, 3));
        allGameOpponents.add(new GameOpponents ("Wee Saller", cars.getCarFromLot("Toyota Yaris"),
        925, 3, 3, 3, 3));
        allGameOpponents.add(new GameOpponents ("Miguel Farken", cars.getCarFromLot("BMW X1"),
        920, 3, 3, 3, 3));
        allGameOpponents.add(new GameOpponents ("Ellias Beside", cars.getCarFromLot("Dodge Viper GTS"),
        935, 3, 3, 3, 3));
        allGameOpponents.add(new GameOpponents ("Erik Climbman", cars.getCarFromLot("Audi A7"),
        925, 3, 3, 3, 3));
        allGameOpponents.add(new GameOpponents ("Marko Lopez", cars.getCarFromLot("Chevrolet Corvette Z06"),
        955, 3, 3, 3, 3));
        allGameOpponents.add(new GameOpponents ("Edward Fiores", cars.getCarFromLot("Mitsubishi Lancer Evolution IX"),
        985, 3, 3, 3, 3));
        //110 opponnents:
    }
    public int getDefeatedTimes()
    {
        return this.DefeatedTimes;
    }
    public int getWinTimes()
    {
        return this.WinTimes;
    }
    public boolean processInformation(Player p1)
    {
        if(this.getOpponentCar().isWinner())
        {
            this.RivalWon++;
            this.WinTimes++;
        }
        else if(p1.getPlayerCar().isWinner())
        {
            this.PlayerWon++;
            this.DefeatedTimes++;
        }
        if(PlayerWon==2)
        {
            PlayerWon = 0;
            RivalWon = 0;
            //this will unlock the next rival.
            return true;
        }
        else if(RivalWon==2)
        {
            PlayerWon = 0;
            RivalWon = 0;
        }
        return false;
    }
    public int getPlayerWonTimes()
    {
        return this.PlayerWon;
    }
}