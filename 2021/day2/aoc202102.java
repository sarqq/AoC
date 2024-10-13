/* 
 * Advent of Code 2021 - Day 2
 * Exercise description here: https://adventofcode.com/2021/day/2
 *
 * -sarqq 
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class aoc202102{
	static final String DEFAULT_FILENAME = "input.txt";
	
	public static ArrayList<String> read_file(String filename){
		ArrayList<String> lines = null;
		
		try{
			//reading input file
			File file = new File("input.txt");
			Scanner reader = new Scanner(file);
			
			lines = new ArrayList<String>();

			//storing lines into list
			while(reader.hasNextLine()){
				lines.add(reader.nextLine());
			}

			reader.close();
		}
		catch(Exception e){
			System.out.println("Error: " + e.getMessage());
		}

		return lines;
	}

	public static void move(ArrayList<String> instructions){
		//variables for coordinates
		int x1, y1, x2, y2, aim;
		x1 = y1 = x2 = y2 = aim	= 0;
		
		//reading commands from file
		for(String line : instructions){
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
			else{
				System.out.println("Invalid command!");
				continue;
			}
		}

		//part 1
		System.out.printf("Part 1\nx: %d, y: %d\nx*y: %d\n", x1, y1, x1*y1);
		
		//part 2
		System.out.printf("\nPart 2\nx: %d, y: %d\nx*y: %d\n", x2, y2, x2*y2);
	}

	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter filename: ");
		String filename = reader.nextLine();

		if(filename.isEmpty()){
			filename = DEFAULT_FILENAME;
		}

		ArrayList<String> instructions = read_file(filename);
		
		if(instructions != null){
			move(instructions);
		}
	}

}
