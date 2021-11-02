package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Temperatures {

    byte weeks, measurements;
    float[][] temps;
    float[] highTemps, lowTemps, averageTemps;

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
        //Make the arrays for taking total data
        highTemps = new float[weeks];
        lowTemps = new float[weeks];
        averageTemps = new float[weeks];

        //Write the output to the console for each week
        for(byte week = 0; week < weeks; week++)
            System.out.println("Vecka: " + (week+1) + ", Högsta temperaturen: " + highestTemperature(week) + ", Lägsta temperaturen: " + lowestTemperature(week) + ", Medeltemperaturen: " + averageTemperature(week));

        //Sort the arrays
        Arrays.sort(highTemps);
        Arrays.sort(lowTemps);

        System.out.println("Totalt, Högsta temperaturen: " + highTemps[highTemps.length-1] + ", Lägsta temperaturen: " + lowTemps[0] + ", Medeltemperaturen: " + average(averageTemps));

    }

    //Get the highest temperature for the week
    private float highestTemperature(byte weekNumber) {
        //Get the last value from the sorted array
        float highestTemp = sortTemps(weekNumber)[sortTemps(weekNumber).length-1];

        //Add the highestTemp into the highTemps array
        highTemps[weekNumber] = highestTemp;
        
        return highestTemp;
    }
    
    //Get the lowest temperature for the week
    private float lowestTemperature(byte weekNumber) {
        //Get the first value from the sorted array
        float lowestTemp = sortTemps(weekNumber)[0];

        //Add the lowestTemp into the lowTemps array
        lowTemps[weekNumber] = lowestTemp;

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

        //Add the average temp to the averageTemps list
        averageTemps[weekNumber] = tempsSum / measurements;

        //Divide the total temperatures with the amount of measurements
        return tempsSum / measurements;
    }

    //Get the average of the list
    private float average(float[] array) {

        float sum = 0;

        //Add all the data together
        for(byte i = 0; i < array.length; i++)
            sum += array[i];

        return sum/array.length;
    }
}
