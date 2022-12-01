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

public class AoC202103{
	//function to filter the bits counting towards energy to oxygen
	public static List<String> filterOxy(List<String> list, int idx){
		int ones = 0;
		int zeroes = 0;
		
		for(String bits : list){
			if(bits.charAt(idx) == '1'){
				ones++;
			}
			else{
				zeroes++;
			}
		}
		
		//bit to be filtered
		final char bitOxy = (ones >= zeroes ? '0' : '1');
		List<String> filtered = list.stream()
		.filter(s -> s.charAt(idx)==bitOxy).collect(Collectors.toList());
		
		return filtered;
	}
	
	//function to filter the bits counting towards energy to CO2
	public static List<String> filterCO(List<String> list, int idx){
		int ones = 0;
		int zeroes = 0;
		
		for(String bits : list){
			if(bits.charAt(idx) == '1'){
				ones++;
			}
			else{
				zeroes++;
			}
		}
		
		//bit to be filtered
		final char bitCO = (ones >= zeroes ? '1' : '0');
		List<String> filtered = list.stream()
		.filter(s -> s.charAt(idx)==bitCO).collect(Collectors.toList());
		
		return filtered;
	}
	
	//working code below
	public static void main(String[] args){
		try{
			//load file
			File file = new File("input.txt");
			Scanner reader = new Scanner(file);
			ArrayList<String> input = new ArrayList<String>();
			
			//store number of ones and zeroes
			int[] ones = new int[12];
			int[] zeroes = new int[12];
			
			//read file
			while(reader.hasNextLine()){
				String bits = reader.nextLine();
				input.add(bits);
				
				for(int i = 0; i<bits.length(); i++){
					int bit = Character.getNumericValue(bits.charAt(i));
					if(bit == 1){
						ones[i] += 1;
					}
					else{
						zeroes[i] += 1;
					}
				}
			}

			reader.close();
			String gamma = "";
			String epsilon = "";
			
			//compare number of ones and zeroes
			for(int i = 0; i<12; i++){
				//if more ones than zeroes, add bit to gamma
				gamma += (ones[i]>=zeroes[i] ? "1" : "0");
				//if more zeroes than ones, add bit to epsilon
				epsilon += (ones[i]<zeroes[i] ? "1" : "0");
			}
			
			int gInt = Integer.parseInt(gamma, 2);
			int eInt = Integer.parseInt(epsilon, 2);
			
			//output results
			System.out.println("Part 1: ");
			System.out.println("Gamma: " + gInt + ", Epsilon: " + eInt);
			System.out.println("Power consumption: " + eInt*gInt);
			
			/*
			 * Part 2
			 */
			final char gam = gamma.charAt(0);
			final char eps = epsilon.charAt(0);
			
			List<String> powerToOxy = input
			.stream()
			.filter(a -> a.charAt(0) == eps)
			.collect(Collectors.toList());
			
			List<String> powerToCO = input
			.stream()
			.filter(b -> b.charAt(0) == gam)
			.collect(Collectors.toList());
			//code still works
			
			int i = 1;
			while(powerToOxy.size()>1 && powerToCO.size()>1){
				powerToOxy = filterOxy(powerToOxy, i);
				i++;
			}
			
			i = 1;
			while(powerToCO.size()>1){
				powerToCO = filterCO(powerToCO, i);
				i++;
			}
			
			int o2 = Integer.parseInt(powerToOxy.get(0), 2);
			int CO = Integer.parseInt(powerToCO.get(0), 2);
			
			//output results
			System.out.println("\nPart 2: ");
			System.out.println("Power to O2: " + o2 + ", power to CO2: " + CO);
			System.out.println("Life support rating: " + o2*CO);
		}
		catch(Exception e){
			System.out.println("Error: " + e.getMessage());
		}
	}
}