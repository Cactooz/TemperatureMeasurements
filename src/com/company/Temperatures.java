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
			System.out.println("Vecka: " + (week+1) + ", Högsta temperaturen: " + getLastArrayValue(sortArray(getSingleArrayDimension(week))) + ", Lägsta temperaturen: " + getFirstArrayValue(sortArray(getSingleArrayDimension(week))) + ", Medeltemperaturen: " + averageArray(getSingleArrayDimension(week)));
		
		//Sort the arrays
		Arrays.sort(highTemps);
		Arrays.sort(lowTemps);
		
		System.out.println("Totalt, Högsta temperaturen: " + highTemps[highTemps.length-1] + ", Lägsta temperaturen: " + lowTemps[0] + ", Medeltemperaturen: " + average(averageTemps));
		
	}
	
	//Get a single week of data
	private float[] getSingleArrayDimension(byte dimension) {
		//A new array for a single week
		float[] singleWeekTemps = new float[temps.length+1];
		
		//Add all the measurements from the week into the new array
		for(byte measurement = 0; measurement < measurements; measurement++) {
			singleWeekTemps[measurement] = temps[dimension][measurement];
		}
		
		return singleWeekTemps;
	}
	
	//Sort the temperatures in the array
	private float[] sortArray(float[] inputArray) {
		//Sort the array
		Arrays.sort(inputArray);
		
		return inputArray;
	}
	
	//Get the highest temperature for the week
	private float getLastArrayValue(float[] inputArray) {
		return inputArray[inputArray.length-1];
	}
	
	//Get the lowest temperature for the week
	private float getFirstArrayValue(float[] inputArray) {
		return inputArray[0];
	}
	
	//Get the sum of all values in an array
	private float getArrayValueSum(float[] inputArray) {
		float sum = 0;
		
		//Add all array values together
		for(byte i = 0; i < inputArray.length; i++)
			sum += inputArray[i];
		
		return sum;
	}
	
	//Get the average of an array
	private float averageArray(float[] inputArray) {
		//Divide the total with the amount of divisions
		return getArrayValueSum(inputArray) / inputArray.length;
	}
}
