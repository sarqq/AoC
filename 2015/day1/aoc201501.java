/*
 * @sarqq
 * Advent of Code 2015 - day 1
 */

import java.util.Scanner;
import java.io.File;

public class aoc201501{
	public static final String DEFAULT_FILENAME = "input.txt";
    
	public static void main(String[] args){
		int floor = 0;
		int basement = 0;
		boolean basementVisited = false;

		try{
			Scanner reader = new Scanner(new File(DEFAULT_FILENAME));
		
			while(reader.hasNextLine()){
				String instructions = reader.nextLine();
				
				for(int i = 0; i<instructions.length(); i++){
					floor += (instructions.charAt(i)=='(') ? 1 : -1;
				
					if(floor<0 && !basementVisited){
						basement = i+1;
						basementVisited = true;
					}
				}
			}

			reader.close();
		}
		catch(Exception e){
			System.out.println("Error! " + e.getMessage());
		}

		System.out.printf("Part 1 - Santa will arrive on floor %d\n", floor);
		System.out.printf("Part 2 - Position to basement: %d\n", basement);    
    }
}
