/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project44;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Black2
 */
//This class needs to be serializable as well because Player Class has an object of this class, in
//its composition.
public class Car extends Parts implements Serializable{
    private final String _car_Name;
    private final int Price;
    private float MaxSpeed;
    private float CurrentSpeed;
    private float CarAcceleration;
    private float Acceleration;
    private int Collisions;
    private int Perfect_Shifts;
    private boolean isPerfectShift;
    private boolean isCollision;
    private boolean isWinner;
    private int Gearing;
    private final String CarPhotoPath;
    private int Drafts;
    public Car(String CarName, float CarSpeed, float car_Acceleration, String CarPhoto, int carPrice)
    {
        super();
        this._car_Name = CarName;
        this.MaxSpeed = CarSpeed;
        this.Acceleration = car_Acceleration;
        this.CarAcceleration = car_Acceleration;
        this.CurrentSpeed=0.0f;
        this.Collisions=0;
        this.Drafts=0;
        this.Perfect_Shifts=0;
        this.isPerfectShift = false;
        this.isCollision = false;
        this.isWinner = false;
        this.CarPhotoPath = CarPhoto;
        this.Price = carPrice;
        this.Gearing = 5;
    }
    public float getCarCurrentSpeed()
    {
        return this.CurrentSpeed;
    }
    public float getCarAcceleration()
    {
        return this.CarAcceleration;
    }
    public String getCarName()
    {
        return this._car_Name;
    }
    public void IncreaseSpeed()
    {
        if(this.CurrentSpeed<this.MaxSpeed)
        {
            //Changing 0.3 will generate higher acceleration, so the race will run faster.
            this.CurrentSpeed+=this.Acceleration*0.3;
        }
        else
        {
            this.CurrentSpeed-=2;
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
    public void setCollisionFlagTrue()
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
    public String getCarPhotoPath()
    {
        return this.CarPhotoPath;
    }
    public void Reset()
    {
        this.Collisions = 0;
        this.Drafts = 0;
        this.Perfect_Shifts = 0;
        this.isWinner = false;
        this.CurrentSpeed = 0.0f;
        this.Gearing = 5;
        this.isPerfectShift = false;
        this.Acceleration = this.CarAcceleration;
    }
    public int getCarPrice()
    {
        return this.Price;
    }
    public boolean isCollision()
    {
        return this.isCollision;
    }
    public boolean isPerfectShift()
    {
        return this.isPerfectShift;
    }
    public void setCollisionFlagFalse()
    {
        this.isCollision = false;
    }
    public void setPerfectShiftFlagFalse()
    {
        this.isPerfectShift = false;
    }
    public void dicreaseCarCurrentSpeed() //this is called when the car gets crashed
    {
        Random rand = new Random();
        int factor = rand.nextInt(4)+2;
        if(this.CurrentSpeed >= factor*20)
        {
            this.CurrentSpeed -= factor*20;
        }
        else
        {
            this.CurrentSpeed = 0.0f;
        }
        if(this.CurrentSpeed < this.MaxSpeed/10)
        {
            this.Gearing=5;
        }
        else if(this.CurrentSpeed > this.MaxSpeed/6 && 
                this.CurrentSpeed < this.MaxSpeed/5.5f)
        {
            this.Gearing=4;
        }
        else if(this.CurrentSpeed > this.MaxSpeed/4 && 
                this.CurrentSpeed < this.MaxSpeed/3.6f)
        {
            this.Gearing=3;
        }
        else if(this.CurrentSpeed > this.MaxSpeed/2.8f && 
                this.CurrentSpeed < this.MaxSpeed/2.6f)
        {
            this.Gearing=2;
        }
        else if(this.CurrentSpeed > this.MaxSpeed/1.7 && 
                this.CurrentSpeed < this.MaxSpeed/1.65f)
        {
            this.Gearing=1;
        }
    }
    public void dicreaseCarAcceleration()
    {
        this.Acceleration-=0.02;
    }
    public void increaseAcceleration()
    {
        this.Acceleration+=0.1;  
    }
    public void increaseCurrentSpeed()
    {
        if(this.CurrentSpeed+20<this.MaxSpeed)
        {
            this.CurrentSpeed+=5;
        }
        else if(this.CurrentSpeed<this.MaxSpeed)
        {
            this.CurrentSpeed+=this.MaxSpeed-this.CurrentSpeed;
        }
    }
    public void decreaseGearsNumber()
    {
        if(this.CurrentSpeed > this.MaxSpeed/12 && 
                this.CurrentSpeed < this.MaxSpeed/10 && this.Gearing==5)
        {
            this.Gearing--;
            this.setPerfectShiftFlagTrue();
        }
        else if(this.CurrentSpeed > this.MaxSpeed/6 && 
                this.CurrentSpeed < this.MaxSpeed/5.5f && this.Gearing ==4)
        {
            this.Gearing--;
            this.setPerfectShiftFlagTrue();
        }
        else if(this.CurrentSpeed > this.MaxSpeed/4 && 
                this.CurrentSpeed < this.MaxSpeed/3.6f && this.Gearing ==3)
        {
            this.Gearing--;
            this.setPerfectShiftFlagTrue();
        }
        else if(this.CurrentSpeed > this.MaxSpeed/2.8f && 
                this.CurrentSpeed < this.MaxSpeed/2.6f && this.Gearing ==2)
        {
            this.Gearing--;
            this.setPerfectShiftFlagTrue();
        }
        else if(this.CurrentSpeed > this.MaxSpeed/1.7 && 
                this.CurrentSpeed < this.MaxSpeed/1.65f && this.Gearing ==1)
        {
            this.Gearing--;
            this.setPerfectShiftFlagTrue();
        }
    }
    public void EngineLevel1Upgrade()
    {
        this.MaxSpeed+=15.0f;
        super.EngineLevel=1;
    }
    public void EngineLevel2Upgrade()
    {
        this.MaxSpeed+=35.0f;
        super.EngineLevel=2;
    }
    public void EngineLevel3Upgrade()
    {
        this.MaxSpeed+=50.0f;
        super.EngineLevel=3;
    }
    public void TransmissionLevel1Upgrade()
    {
        this.CarAcceleration+=0.01f;
        this.MaxSpeed+=5.0f;
        super.TransmissionLevel=1;
    }
    public void TransmissionLevel2Upgrade()
    {
        this.CarAcceleration+=0.03f;
        this.MaxSpeed+=8.0f;
        super.TransmissionLevel=2;
    }
    public void TransmissionLevel3Upgrade()
    {
        this.CarAcceleration+=0.045;
        this.MaxSpeed+=12.0f;
        super.TransmissionLevel=3;
    }
    public void TurboLevel1Upgrade()
    {
        this.CarAcceleration+=0.07f;
        super.TurboLevel=1;
    }
    public void TurboLevel2Upgrade()
    {
        this.CarAcceleration+=0.13f;
        super.TurboLevel=2;
    }
    public void TurboLevel3Upgrade()
    {
        this.CarAcceleration+=0.19f;
        super.TurboLevel=3;
    }
    public void NitrousLevel1Upgrade()
    {
        this.CarAcceleration+=0.02f;
        this.MaxSpeed+=10.0f;
        super.NitrousLevel=1;
    }
    public void NitrousLevel2Upgrade()
    {
        this.CarAcceleration+=0.04f;
        this.MaxSpeed+=15.0f;
        super.NitrousLevel=2;
    }
    public void NitrousLevel3Upgrade()
    {
        this.CarAcceleration+=0.055f;
        this.MaxSpeed+=22.0f;
        super.NitrousLevel=3;
    }
}
