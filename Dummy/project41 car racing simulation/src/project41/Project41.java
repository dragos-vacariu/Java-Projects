/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project41;

import java.util.Scanner;

/**
 *
 * @author Black2
 */
public class Project41 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner myscanner = new Scanner(System.in);
        int money = 5000;
        boolean playAgain=true;
        do{
            for(int i=0; i<80;i++) {System.out.println();}
            Car Mustang = new Car("Ford Mustang GT", 300.0f, 1.2f);
            Car Lancer = new Car("Mitsubishi Lancer Evolution IX", 320f, 1.1f);
            Track Drag = new Track("Highway", 40f);
            System.out.printf("\nYour money: %d\n\n", money);
            System.out.printf("%s is facing %s\n", Mustang.getCarName(), Lancer.getCarName());
            System.out.printf("Statistics:\n%s - Top Speed: %4.2f \tAcceleration: %4.2f\n", Lancer.getCarName(), 
            Lancer.getCarTopSpeed(),Lancer.getCarAcceleration());
            System.out.printf("%s - Top Speed: %4.2f \tAcceleration: %4.2f\n", Mustang.getCarName(), 
            Mustang.getCarTopSpeed(),Mustang.getCarAcceleration()); 
            char a;
            int bet=0;
            int choice=0;
            do{
                System.out.printf("Place a bet? Y/N\n");
                a = myscanner.next().charAt(0);
                a = Character.toTitleCase(a);
            }while(a!='Y' && a!='N');
            if(a=='Y')
            {
                System.out.printf("Type in your bet:\n");
                do{
                    bet = myscanner.nextInt();
                    if(money<bet)
                    {
                        System.out.printf("You do not have this amount of money!\n");
                    }
                }while(bet>money);
                System.out.printf("Which car are you betting to? 1/2\n");
                do{
                    choice=myscanner.nextInt();
                }while(choice>2&&choice<0);
            }
            while(Drag.isRaceFinished()==false)
            {
                Mustang.IncreaseSpeed();
                Lancer.IncreaseSpeed();
                Drag.calculateDistanceUntilFinish(Mustang, Lancer);
            }
            if(Mustang.isWinner() && choice==1)
            {
                money+=bet;
                bet=0;
            }
            else if(Lancer.isWinner() && choice ==2)
            {
                money+=bet;
                bet=0;
            }
            else
            {
                money-=bet;
                bet=0;
            }
            do{
                System.out.printf("Do you wish to play again? Y/N\n");
                a = myscanner.next().charAt(0);
                a = Character.toTitleCase(a);
            }while(a!='Y' && a!='N');
            playAgain = (a=='Y')? true : false;
        }while(playAgain==true);
        //keep the console open until the next button pressed.
        System.out.println("Press any key to quit!");
        myscanner.next();
    }
    
    
}
