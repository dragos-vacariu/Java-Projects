/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project41;

import java.util.Random;

/**
 *
 * @author Black2
 */
public class Track {
    private String _track_name;
    private float Car1_distance;
    private float Car2_distance;
    private boolean isRaceOver;
    public Track (String new_Track_name, float new_distance)
    {
        this.Car1_distance = new_distance;
        this.Car2_distance = new_distance;
        this._track_name = new_Track_name;
        this.isRaceOver = false;
    }
    public void calculateDistanceUntilFinish(Car car1, Car car2)
    {
        int effect_Car1=0;
        int effect_Car2=0;
        if(this.Car1_distance>0)
        {
            Random rand = new Random ();
            effect_Car1 = rand.nextInt(500)+1;
            this.Car1_distance -= car1.getCarCurrentSpeed()/1000+effect_Car1/500;
            switch(effect_Car1)
            {
                case 1: {car1.increaseNrOfColision(); car1.setIsCollisionFlagTrue(); break;}
                case 50: {car1.increaseNrOfPerfectShifts(); car1.setPerfectShiftFlagTrue(); break;}
                default: {break;}
            }
        }
        if(this.Car2_distance>0)
        {
            Random rand = new Random ();
            effect_Car2 = rand.nextInt(500)+1;
            this.Car2_distance -= car2.getCarCurrentSpeed()/1000+effect_Car2/500;
            switch(effect_Car2)
            {
                case 1: {car2.increaseNrOfColision(); car2.setIsCollisionFlagTrue();break;}
                case 50: {car2.increaseNrOfPerfectShifts(); car2.setPerfectShiftFlagTrue(); break;}
                default: {break;}
            }
            if(effect_Car1==effect_Car2 && effect_Car1>0 && effect_Car2>0)
            {
                car1.increaseNrOfDrafts();
                car2.increaseNrOfDrafts();
            }
        }
        if(this.Car1_distance<=0 && this.Car2_distance<=0)
        {
            if(this.Car1_distance<this.Car2_distance)
            {
                System.out.printf("%s has won the race!\n", car1.getCarName());
                System.out.printf("%s has %4.2f until it reach the finish!\n", car2.getCarName(), this.Car2_distance);
                car1.setIsWinnerToTrue();
            }
            else if(this.Car2_distance<this.Car1_distance)
            {
                System.out.printf("%s has won the race!\n", car2.getCarName());
                System.out.printf("%s has %4.2f until it reach the finish!\n", car1.getCarName(), this.Car1_distance);
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
            System.out.printf("%s has won the race!\n", car1.getCarName());
            System.out.printf("%s has %4.2f until it reach the finish!\n", car2.getCarName(), this.Car2_distance);
            isRaceOver=true;
            car1.setIsWinnerToTrue();
        }
        else if(this.Car2_distance<=0)
        {
            System.out.printf("%s has won the race!\n", car2.getCarName());
            System.out.printf("%s has %4.2f until it reach the finish!\n", car1.getCarName(), this.Car1_distance);
            isRaceOver=true;
            car2.setIsWinnerToTrue();
        }
        if(isRaceOver)
        {
            System.out.printf("\n%s Statistics:\n", car1.getCarName());
            System.out.printf("PerfShifts\tDrafts\tCollisions\n");
            System.out.printf("%d\t\t%d\t%d\n", car1.getNrOfPerfectShifts(),
                    car1.getNrOfDrafts(), car1.getNrOfCollision());
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
}
