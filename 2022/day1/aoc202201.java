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

public class aoc202201 {
    public static void main(String[] args){
        int currentCalories = 0;
        ArrayList<Integer> calories = new ArrayList<Integer>();
        
        try{
            //reading file
            Scanner reader = new Scanner(new File("input.txt"));

            //read input and add calories to list
            while(reader.hasNextLine()){
                String line = reader.nextLine();

                if(line.isEmpty()){
                    calories.add(currentCalories);
                    currentCalories = 0;
                }
                else{
                    currentCalories += Integer.valueOf(line);
                }
            }
            reader.close();

            //finding out the elf carrying the most calories
            Collections.sort(calories, Collections.reverseOrder());

            //print results
            System.out.printf("Part 1 - The largest amount of calories carried is: %d\n", calories.get(0));

            int topThreeSum = calories.get(0)+calories.get(1)+calories.get(2);
            System.out.printf("Part 2 - The total amount of calories carried by the top three elves is: %d\n", topThreeSum);
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}