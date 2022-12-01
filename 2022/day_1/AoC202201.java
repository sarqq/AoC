/* 
 * Advent of Code 2022 - Day 1
 * Exercise description here: https://adventofcode.com/2022/day/1
 *
 * -sarqq 
 */

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class AoC202201 {
    public static void main(String[] args){
        try{
            //reading file
            File input = new File("input.txt");
            Scanner reader = new Scanner(input);

            //variable for storing calories
            int currentCalories = 0;
            ArrayList<Integer> calories = new ArrayList<Integer>();

            //read input and add calories to list
            while(reader.hasNextLine()){
                String line = reader.nextLine();

                if(line.isEmpty()){
                    calories.add(currentCalories);
                    currentCalories = 0;
                }else{
                    currentCalories += Integer.valueOf(line);
                }
            }
            reader.close();

            //finding out the elf carrying the most calories
            Collections.sort(calories, Collections.reverseOrder());

            /*
             * Part 1
             */
            System.out.println("The largest amount of calories carried is: " + calories.get(0));
            
            /*
             * Part 2
             */
            int topThreeSum = calories.get(0)+calories.get(1)+calories.get(2);
            System.out.println("The total amount of calories carried by the top three elves is: " + topThreeSum);
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}