/* 
 * Advent of Code 2021 - Day 3
 * Exercise description here: https://adventofcode.com/2021/day/3
 *
 * -sarqq 
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.util.stream.*;
import java.util.List;

public class aoc202103{
	static final String DEFAULT_FILENAME = "input.txt";

	//store lines of input file to list
	public static ArrayList<String> read_file(String filename){
		ArrayList<String> bytes = null;
		
		try{
			//load file
			File file = new File(filename);
			Scanner reader = new Scanner(file);
			
			bytes = new ArrayList<String>();
			
			//read file
			while(reader.hasNextLine()){
				bytes.add(reader.nextLine());
			}

			reader.close();
		}
		catch(Exception e){
			System.out.println("Error: " + e.getMessage());
		}

		//return list
		return bytes;
	}

	public static List<String> filterPower(List<String> bytes, int idx, char gas){
		List<String> filtered = null;
		
		int ones = 0;
	       	int zeroes = 0;

		for(String bits : bytes){
			if(bits.charAt(idx) == '1') ones++; else zeroes++;
		}

		final char filteredGas = (gas == '1' ? (ones >= zeroes ? '0' : '1') :
				(ones >= zeroes ? '1' : '0'));

		filtered = bytes.stream()
			.filter(s -> s.charAt(idx)==filteredGas)
			.collect(Collectors.toList());

		return filtered;
	}

	public static String[] part1(ArrayList<String> bytes){
		int[] ones = new int[12];
	      	int[] zeroes = new int[12];

		for(String line : bytes){
			//read single character from line
			for(int i = 0; i<line.length(); i++){
				//character == '1'
				if(Character.getNumericValue(line.charAt(i)) == 1){
					ones[i]++;
				}
				//character == '0'
				else if(Character.getNumericValue(line.charAt(i)) == 0){
					zeroes[i]++;
				}
				else continue;
			}
		}

		String gamma = "";
		String epsilon = "";

		//compare number of ones and zeroes
		for(int i = 0; i<12; i++){
			//if more ones than zeroes, add bit to gamma
			gamma += (ones[i] >= zeroes[i] ? "1" : "0");
			//if more zeroes than ones, add bit to epsilon
			epsilon += (ones[i] < zeroes[i] ? "1" : "0");
		}
		
		int g = Integer.parseInt(gamma, 2);
		int e = Integer.parseInt(epsilon, 2);
		
		//output results
		System.out.printf("Part 1\nGamma: %d, Epsilon: %d\n", g, e);
		System.out.printf("Power consumption: %d\n", e*g);

		return new String[]{gamma, epsilon};
	}

	public static void part2(ArrayList<String> bytes, final char G, final char E){
	
		//filter which numbers indicate power to O2
		List<String> powerO2 = bytes.stream()
			.filter(a -> a.charAt(0) == E).collect(Collectors.toList());
		
		//filter which numbers indicate power to CO
		List<String> powerCO = bytes.stream()
			.filter(b -> b.charAt(0) == G).collect(Collectors.toList());
		
		int i = 1;
		while(powerO2.size()>1){
			powerO2 = filterPower(powerO2, i, E);
			i++;
		}
		
		i = 1;
		while(powerCO.size()>1){
			powerCO = filterPower(powerCO, i, G);
			i++;
		}
		
		if(powerO2 != null && powerCO != null){
			int o2 = Integer.parseInt(powerO2.get(0), 2);
			int co = Integer.parseInt(powerCO.get(0), 2);
		
			//output results
			System.out.printf("\nPart 2\nPower to O2: %d, power to CO2: %d\n", o2, co);
			System.out.printf("Life support rating: %d\n", o2*co);
		}
		else{
			System.out.println("Unknown error.");
		}
	}
	
	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter filename: ");
		String filename = reader.nextLine();

		if(filename.isEmpty()){
			filename = DEFAULT_FILENAME;
		}

		ArrayList<String> bytes = read_file(filename);
		
		if(bytes != null){
			//part1
			String[] values = part1(bytes);
			
			//part2
			String gamma = values[0];
			String epsilon = values[1];

			part2(bytes, gamma.charAt(0), epsilon.charAt(0));
		}	
	}
}
