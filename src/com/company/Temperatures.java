package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Temperatures {

    byte weeks, measurements;
    float[][] temps;

    public void input() {
        //Scanner for input
        Scanner in = new Scanner(System.in);

        //Get the amount of weeks
        System.out.print("Antal veckor: ");
        weeks = in.nextByte();

        //The amount of measurements/week
        System.out.print("Antal mätningar per vecka: ");
        measurements = in.nextByte();

        //Make a two dimensional array for temps
        temps = new float[weeks][measurements];
        
        //Loop through the weeks
        for(byte week = 0; week < weeks; week++) {
            
            System.out.println("Vecka: " + (week+1));
            
            //Loop through the measurements
            for(byte measurement = 0; measurement < measurements; measurement++) {
                
                //Add the measurement data into the array
                temps[week][measurement] = in.nextFloat();
            }
        }
        
    }

    public void output() {
        //Write the output to the console for each week
        for(byte week = 0; week < weeks; week++)
            System.out.println("Vecka: " + (week+1) + ", Högsta temperaturen: " + highestTemperature(week) + ", Lägsta temperaturen: " + lowestTemperature(week) + ", Medeltemperaturen: " + averageTemperature(week));
    }

    //Get the highest temperature for the week
    private float highestTemperature(byte weekNumber) {
        //Get the last value from the sorted array
        float highestTemp = sortTemps(weekNumber)[sortTemps(weekNumber).length-1];
        
        return highestTemp;
    }
    
    //Get the lowest temperature for the week
    private float lowestTemperature(byte weekNumber) {
        //Get the first value from the sorted array
        float lowestTemp = sortTemps(weekNumber)[0];
        
        return lowestTemp;
    }
    
    //Sort the temperatures in the array
    private float[] sortTemps(byte weekNumber) {
        float[] sortedTemps = new float[temps.length+1];
    
        //Add all the temperature elements from the week into an array
        for(byte measurement = 0; measurement < measurements; measurement++) {
            sortedTemps[measurement] = temps[weekNumber][measurement];
        }
        //Sort the array
        Arrays.sort(sortedTemps);
        
        return(sortedTemps);
    }
    
    //Get the average temperature of the week
    private float averageTemperature(byte weekNumber) {
        
        float tempsSum = 0;
        
        //Add all the temperatures together
        for(byte i = 0; i < measurements; i++)
            tempsSum += temps[weekNumber][i];
        
        //Divide the total temperatures with the amount of measurements
        return tempsSum / measurements;
    }
}
