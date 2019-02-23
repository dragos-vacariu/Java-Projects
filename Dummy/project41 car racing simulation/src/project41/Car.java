package project41;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Black2
 */
public class Car {
    private String _car_Name;
    private float MaxSpeed;
    private float CurrentSpeed;
    private float Acceleration;
    private int Collisions;
    private int Perfect_Shifts;
    private boolean isPerfectShift;
    private boolean isCollision;
    private boolean isWinner;
    private int Drafts;
    public Car(String CarName, float CarSpeed, float CarAcceleration)
    {
        this._car_Name = CarName;
        this.MaxSpeed = CarSpeed;
        this.Acceleration = CarAcceleration;
        this.CurrentSpeed=0.0f;
        this.Collisions=0;
        this.Drafts=0;
        this.Perfect_Shifts=0;
        this.isPerfectShift = false;
        this.isWinner = false;
    }
    public float getCarCurrentSpeed()
    {
        return this.CurrentSpeed;
    }
    public float getCarAcceleration()
    {
        return this.Acceleration;
    }
    public String getCarName()
    {
        return this._car_Name;
    }
    public void IncreaseSpeed()
    {
        if(this.CurrentSpeed<this.MaxSpeed)
        {
            if(this.isPerfectShift==true)
            {
                this.Acceleration+=0.1;
                this.CurrentSpeed+=20;
                this.isPerfectShift=false;
            }
            else if(this.isCollision==true)
            {
                this.Acceleration-=0.1;
                this.CurrentSpeed-=30;
                this.isCollision=false;
            }
            this.CurrentSpeed+=this.Acceleration;
        }
    }
    public int getNrOfCollision()
    {
        return this.Collisions;
    }
    public int getNrOfPerfectShifts()
    {
        return this.Perfect_Shifts;
    }
    public int getNrOfDrafts()
    {
        return this.Drafts;
    }
    public void increaseNrOfColision()
    {
        this.Collisions++;
    }
    public void increaseNrOfDrafts()
    {
        this.Drafts++;
    }
    public void increaseNrOfPerfectShifts()
    {
        this.Perfect_Shifts++;
    }
    public void setPerfectShiftFlagTrue()
    {
        this.isPerfectShift = true;
    }
    public void setIsCollisionFlagTrue()
    {
        this.isCollision = true;
    }
    public float getCarTopSpeed()
    {
        return this.MaxSpeed;
    }
    public boolean isWinner()
    {
        return this.isWinner;
    }
    public void setIsWinnerToTrue()
    {
        this.isWinner = true;
    }
}
