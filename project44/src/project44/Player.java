/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project44;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Black2
 */
public class Player implements Serializable{
    private Car PlayerCar;
    private ArrayList <Car> playerGarageCars;
    private int Money;
    private int PlayerCollisions;
    private int PlayerPerfectShifts;
    private int PlayerRacesWon;
    private int PlayerRacesLost;
    private int PlayerRacesDrawed;
    private int PlayerExperience;
    private String savingTimeAndDate;
    private String PlayerProfileName;
    private final GameOpponents gameRivals;
    private int CurrentOpponent;
    public Player()
    {
        PlayerProfileName = "";
        savingTimeAndDate = "";
        CurrentOpponent = 0;
        PlayerExperience = 0;
        this.Money = 7000;
        this.PlayerCar = null;
        playerGarageCars = new ArrayList();
        gameRivals = new GameOpponents();
    }
    public Car getPlayerCar()
    {
        return this.PlayerCar;
    }
    public int getPlayerMoney()
    {
        return this.Money;
    }
    public void decreasePlayerMoney(int amount)
    {
        this.Money-=amount;
    }
    public void increasePlayerMoney(int amount)
    {
        this.Money+=amount;
    }
    public void increasePlayerExperience(int amount)
    {
        this.PlayerExperience+=amount;
    }
    public void changePlayerCar(Car playerCar)
    {
        if(playerCar!=null)
        {
            this.PlayerCar=playerCar;
            this.playerGarageCars.add(PlayerCar);
        }
    }
    public void increasePlayerCollision()
    {
        this.PlayerCollisions++;
    }
    public void increasePlayerPerfectShifts()
    {
        this.PlayerPerfectShifts++;
    }
    public void increasePlayerRacesWon()
    {
        this.PlayerRacesWon++;
    }
    public void increasePlayerRacesLost()
    {
        this.PlayerRacesLost++;
    }
    public void increasePlayerRacesDrawed()
    {
        this.PlayerRacesDrawed++;
    }
    public int getPlayerRacesWon()
    {
        return this.PlayerRacesWon;
    }
    public int getPlayerRacesLost()
    {
        return this.PlayerRacesLost;
    }
    public int getPlayerRacesDrawed()
    {
        return this.PlayerRacesDrawed;
    }
    public int getPlayerPerfectShifts()
    {
        return this.PlayerPerfectShifts;
    }
    public int getPlayerCollisions()
    {
        return this.PlayerCollisions;
    }
    public int getPlayerNumberOfCars()
    {
        return this.playerGarageCars.size();
    }
    public Car getPlayerCarFromList(int index)
    {
        return this.playerGarageCars.get(index);
    }
    public GameOpponents getCurrentRival()
    {
        return this.gameRivals.allGameOpponents.get(this.CurrentOpponent);
    }
    public int getCurrentOpponentIndex()
    {
        return this.CurrentOpponent;
    }
    public int getPlayerExperience()
    {
        return this.PlayerExperience;
    }
    public void unlockNextRival()
    {
        this.CurrentOpponent++;
    }
    public int getIndexOf(String RivalName)
    {
        for(int i=0;i<this.gameRivals.allGameOpponents.size();i++)
        {
            if(this.gameRivals.allGameOpponents.get(i).getOpponentName().compareTo(RivalName)==0)
            {
                return i;
            }
        }
        return -1;
    }
    public GameOpponents getRivalAt(int index)
    {
        if(index>0)
        {
            return this.gameRivals.allGameOpponents.get(index);
        }
        return this.gameRivals.allGameOpponents.get(0);
    }
    public void savingGameTimeAndDate()
    {
        Date date = Calendar.getInstance().getTime();
        //Convert the date into Months/days/years/hours/minutes/seconds/
        SimpleDateFormat cDate = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.");
        this.savingTimeAndDate = cDate.format(date);
    }
    public String getSavingTimeAndDate()
    {
        return this.savingTimeAndDate;
    }
    public String getPlayerProfileName()
    {
        return this.PlayerProfileName;
    }
    public void setPlayerProfileName(String Name)
    { 
        this.PlayerProfileName = Name;
    }
}
