/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project39;

import java.util.Scanner;

/**
 *
 * @author Black2
 */
public class Project39 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int Current_day = 1;
        int Current_month =1;
        int Current_year = 2017;
        int Current_week_day = 6; //because the last day of the last year was saturday.
        Scanner myscanner = new Scanner(System.in);
        System.out.printf("Enter the day of the month: ");
        int User_day = myscanner.nextInt();
        System.out.printf("Enter the month of the year: ");
        int User_month = myscanner.nextInt();
        System.out.printf("Enter the year: ");
        int User_year = myscanner.nextInt();
        String week_day = "";
        String user_month_name = "";
        int k;
        System.out.printf("You have entered: day-%d month-%d year-%d\n", User_day, User_month, User_year);
        for(int j=1;j<User_month+1;j++)
        {
            for(int i=1;i<Project39.getMaxOfDaysInMonth(j, Current_year)+1;i++)
            {
                Current_week_day++;
                if(Current_week_day==8)
                {
                    Current_week_day = 1;
                }
                if(i==User_day&&j==User_month)
                {
                    System.out.printf("Entered here: \n");
                    break;
                }
            }
        }
        Current_week_day=Project39.getValueOfYear(Current_year, User_year, Current_week_day);
        week_day = Project39.getWeekDayName(Current_week_day);
        switch(User_month)
        {
            case 1: {user_month_name = "January"; break;}
            case 2: {user_month_name = "February"; break;} 
            case 3: {user_month_name = "March"; break;} 
            case 4: {user_month_name = "April"; break;} 
            case 5: {user_month_name = "May"; break;} 
            case 6: {user_month_name = "June"; break;} 
            case 7: {user_month_name = "July"; break;} 
            case 8: {user_month_name = "August"; break;} 
            case 9: {user_month_name = "September"; break;} 
            case 10: {user_month_name = "October"; break;} 
            case 11: {user_month_name = "November"; break;} 
            case 12: {user_month_name = "December"; break;} 
        }
        System.out.printf("The day %d of %s in %d will be on a %s.\n", 
                User_day, user_month_name, User_year, week_day);
        
        //Keep the console opened until the next button pressed!
        myscanner.nextInt();
    }
    public static int getMaxOfDaysInMonth(int month, int year)
    {
        boolean isLeap = (year%4==0)? true : false;
        switch(month)
        {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12: {return 31;}
            case 4: case 6: case 9: case 11: {return 30;}
            case 2: {return (isLeap==true)? 29: 28;}
        }
        return 0;
    }
    public static String getWeekDayName(int week_day_number)
    {
        if(week_day_number%7==0)
        {
            
            return "Sunday";
        }
        else if(week_day_number%6==0)
        {
            return "Saturday";
        }
        else if(week_day_number%5==0)
        {
            return "Friday";
        }
        else if(week_day_number%4==0)
        {
            return "Thursday";
        }        
        else if(week_day_number%3==0)
        {
            return "Wednesday";
        }
        else if(week_day_number%2==0)
        {
            return "Tuesday";
        }
        else
        {
            return "Monday";
        }
    }
    public static int getValueOfYear(int Current_year, int User_year, int Current_week_day)
    {
        if(User_year>Current_year)
        {
            int a = User_year-Current_year;
            while(a>0)
            {
                if(a%4==0)
                {
                    Current_week_day+=2;

                }
                else
                {
                     Current_week_day++;
                }
                if(Current_week_day==8)
                {
                     Current_week_day=1;
                }
                a--;
            }
         }
         else if(Current_year>User_year)
         {
            int a = Current_year-User_year;
            while(a>0)
            {
                if(a%4==0)
                {
                    Current_week_day-=2;

                }
                else
                {
                     Current_week_day--;
                }
                if(Current_week_day==8)
                {
                     Current_week_day=1;
                }
                a--;
            }
         }
        if(Current_week_day<1)
        {
            Current_week_day+=7;
        }
        else if(Current_week_day>7)
        {
            Current_week_day-=7;
        }
        return Current_week_day;
    }
    
}
