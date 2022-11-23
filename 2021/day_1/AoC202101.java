/* 
 * Advent of Code 2021 - Day 1
 * Exercise description here: https://adventofcode.com/2021/day/1
 *
 * -sarqq 
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class AoC202101{
	public static void main(String[] args){
		try{
			//reading input file
			File file = new File("input.txt");
			Scanner reader = new Scanner(file);
			
			//variables for handling integers from file
			ArrayList<Integer> values = new ArrayList<Integer>();
			int increments = 0;
			int comparison = 0;

			/*
			 * Part 1
			 */
			//comparing integers
			while(reader.hasNextLine()){
				int current = reader.nextInt();
				values.add(current);
				
				if(current>comparison && comparison!=0){
					increments++;
				}
				
				comparison = current;
			}

			//output result, reset variables
			System.out.println("Depth increased " + increments + " times");

			increments = 0;
			comparison = 0;

			/*
			 * Part 2
			 */
			//comparing sums of three adjacent integers
			for(int i=0; (i+2)<values.size(); i++){
				int sumCurr = values.get(i)+values.get(i+1)+values.get(i+2);
				
				if(sumCurr>comparison && comparison!=0){
					increments++;
				}
				
				comparison = sumCurr;
			}
			
			//output result, close reader
			System.out.println("Sum increased " + increments + " times");
			reader.close();
		}
		catch(Exception e){
			System.out.println("Error: " + e.getMessage());
		}
	}
}