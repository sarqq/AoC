/* 
 * Advent of Code 2021 - Day 2
 * Exercise description here: https://adventofcode.com/2021/day/2
 *
 * -sarqq 
 */

import java.util.Scanner;
import java.io.File;

public class AoC202102{
	public static void main(String[] args){
		try{
			//reading input file
			File file = new File("input.txt");
			Scanner reader = new Scanner(file);
			
			//variables for coordinates
			int x1=0, y1=0, x2=0, y2=0, aim = 0;
			
			//reading commands from file
			while(reader.hasNextLine()){
				String line = reader.nextLine();
				String[] commands = line.split("\s");
				String command = commands[0];
				int value = Integer.valueOf(commands[1]);
				
				//adjusting coordinates
				if(command.equals("forward")){
					x1 += value;
					x2 += value;
					y2 += aim*value;
				}
				else if(command.equals("up")){
					y1 -= value;
					aim -= value;
				}
				else if(command.equals("down")){
					y1 += value;
					aim += value;
				}
				
			}

			//output results, close reader
			reader.close();

			/*
			 * Part 1
			 */
			System.out.println("Part 1: ");
			System.out.println("x: " + x1 + ", y: " + y1);
			System.out.println("x*y: " + x1*y1 + "\n");

			/*
			 * Part 2
			 */
			System.out.println("Part 2: ");
			System.out.println("x: " + x2 + ", y: " + y2);
			System.out.println("x*y: " + x2*y2);
			
		}
		catch(Exception e){
			System.out.println("Error: " + e.getMessage());
		}
	}
}