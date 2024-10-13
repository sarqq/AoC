/* 
 * Advent of Code 2021 - Day 1
 * Exercise description here: https://adventofcode.com/2021/day/1
 *
 * -sarqq 
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;


public class aoc202101{
	static final String DEFAULT_FILENAME = "input.txt";

	public static ArrayList<Integer> read_file(String filename){
		ArrayList<Integer> depths = null;
		
		try{
			//reading input file
			File file = new File(filename);
			Scanner reader = new Scanner(file);
			
			//list for input file values
			depths = new ArrayList<Integer>();
			
			//populating value list
			while(reader.hasNextLine()){
				depths.add(reader.nextInt());
			}

			//close reader after use
			reader.close();
		}
		catch(Exception e){
			//file could not be read
			System.out.println("Error: " + e.getMessage());
		}
		
		return depths;
	}
	
	public static void part1(ArrayList<Integer> depths){
		
		int increments = 0;
		int depth = 0;

		//comparing integers
		for(int current : depths){
			//current depth > previous depth -> depth increased
			if(current>depth && depth!=0){
				increments++;
			}
			
			depth = current;
		}

		//output result
		System.out.printf("Part 1 - Depth increased %d times.\n", increments);
	}

	public static void part2(ArrayList<Integer> depths){

		int increments = 0;
		int sumPrev = 0;

		//comparing sums of three adjacent integers
		for(int i=0; (i+2)<depths.size(); i++){
			int sumCurr = depths.get(i) + depths.get(i+1) + depths.get(i+2);
			
			if(sumCurr>sumPrev && sumPrev!=0){
				increments++;
			}
			
			sumPrev = sumCurr;
		}
		
		//print result
		System.out.printf("Part 2 - Sum of three consecutive values " +
				"increased %d times.\n", increments);
	}

	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter file name: ");
		String filename = reader.nextLine();

		if(filename.isEmpty()){
			filename = DEFAULT_FILENAME;
		}

		ArrayList<Integer> depths = read_file(filename);

		if(depths != null){
			part1(depths);
			part2(depths);
		}
	}
}
