/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project44;

import java.util.Random;

/**
 *
 * @author Black2
 */
public class Track {
    private final String _track_name;
    private float Car1_distance;
    private float Car2_distance;
    private final float Distance;
    private boolean isRaceOver;
    public Track (String new_Track_name, float new_distance)
    {
        this.Car1_distance = new_distance;
        this.Car2_distance = new_distance;
        this.Distance = new_distance;
        this._track_name = new_Track_name;
        this.isRaceOver = false;
    }
    public void calculateDistanceUntilFinish(GameOpponents rival, Car car2)
    {
        int effect_Car1=0;
        int effect_Car2=0;
        if(this.Car1_distance>0)
        {
            Random rand = new Random ();
            effect_Car1 = rand.nextInt(rival.getOpponentExp())+1;
            this.Car1_distance -= rival.getOpponentCar().getCarCurrentSpeed()/1000+effect_Car1/500;
            switch(effect_Car1)
            {
                case 1: {
                            rival.getOpponentCar().increaseNrOfColision();
                            rival.getOpponentCar().dicreaseCarCurrentSpeed();
                            rival.getOpponentCar().dicreaseCarAcceleration(); 
                            break;
                        }
                default: {break;}
            }
            rival.getOpponentCar().decreaseGearsNumber();
            if(rival.getOpponentCar().isPerfectShift())
            {
                int factor = 3+ (1000/rival.getOpponentExp());
                effect_Car1=rand.nextInt(factor)+1;
                if(effect_Car1==5)
                {
                    rival.getOpponentCar().increaseCurrentSpeed();
                    rival.getOpponentCar().increaseAcceleration();
                    rival.getOpponentCar().increaseNrOfPerfectShifts();
                }
                rival.getOpponentCar().setPerfectShiftFlagFalse();
            }
        }
        if(this.Car2_distance>0)
        {
            Random rand = new Random ();
            effect_Car2 = rand.nextInt(500)+1;
            this.Car2_distance -= car2.getCarCurrentSpeed()/1000+effect_Car2/500;
            switch(effect_Car2)
            {
                case 1: {car2.setCollisionFlagTrue();break;}
                default: {break;}
            }
            car2.decreaseGearsNumber(); //this function will gear up.
            if(effect_Car1==effect_Car2 && effect_Car1>0 && effect_Car2>0)
            {
                rival.getOpponentCar().increaseNrOfDrafts();
                car2.increaseNrOfDrafts();
            }
        }
        if(this.Car1_distance<=0 && this.Car2_distance<=0)
        {
            if(this.Car1_distance<this.Car2_distance)
            {
                System.out.printf("%s has won the race!\n", rival.getOpponentCar().getCarName());
                System.out.printf("%s has %4.2f until it reach the finish!\n", car2.getCarName(), this.Car2_distance);
                rival.getOpponentCar().setIsWinnerToTrue();
            }
            else if(this.Car2_distance<this.Car1_distance)
            {
                System.out.printf("%s has won the race!\n", car2.getCarName());
                System.out.printf("%s has %4.2f until it reach the finish!\n", rival.getOpponentCar().getCarName(), this.Car1_distance);
                car2.setIsWinnerToTrue();
            }
            else
            {
                System.out.printf("Race has finished as a draw!\n");
                System.out.printf("Both cars has passed the line at the same time!\n");
            }
            isRaceOver=true;
        }
        else if(this.Car1_distance<=0)
        {
            System.out.printf("%s has won the race!\n", rival.getOpponentCar().getCarName());
            System.out.printf("%s has %4.2f until it reach the finish!\n", car2.getCarName(), this.Car2_distance);
            isRaceOver=true;
            rival.getOpponentCar().setIsWinnerToTrue();
        }
        else if(this.Car2_distance<=0)
        {
            System.out.printf("%s has won the race!\n", car2.getCarName());
            System.out.printf("%s has %4.2f until it reach the finish!\n", rival.getOpponentCar().getCarName(), this.Car1_distance);
            isRaceOver=true;
            car2.setIsWinnerToTrue();
        }
        if(isRaceOver)
        {
            System.out.printf("\n%s Statistics:\n", rival.getOpponentCar().getCarName());
            System.out.printf("PerfShifts\tDrafts\tCollisions\n");
            System.out.printf("%d\t\t%d\t%d\n", rival.getOpponentCar().getNrOfPerfectShifts(),
                    rival.getOpponentCar().getNrOfDrafts(), rival.getOpponentCar().getNrOfCollision());
            System.out.printf("\n%s Statistics:\n", car2.getCarName());
            System.out.printf("PerfShifts\tDrafts\tCollisions\n");
            System.out.printf("%d\t\t%d\t%d\n", car2.getNrOfPerfectShifts(),
                    car2.getNrOfDrafts(), car2.getNrOfCollision());
        }
    }
    public boolean isRaceFinished()
    {
        return this.isRaceOver;
    }
    public float getCar1Distance()
    {
        return this.Car1_distance;
    }
    public float getCar2Distance()
    {
        return this.Car2_distance;
    }
    public void Reset()
    {
        this.Car1_distance = this.Distance;
        this.Car2_distance = this.Distance;
        this.isRaceOver = false;
    }
    public int getCar1Progress()
    {
        return 100-(int)this.Car1_distance;
    }
    public int getCar2Progress()
    {
        return 100-(int)this.Car2_distance;
    }
}
