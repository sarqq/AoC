/*
 * @sarqq
 * Advent of Code 2015 - day 2
 */

import java.util.Scanner;
import java.lang.Math;
import java.io.File;

public class aoc201502{
	public static final String DEFAULT_FILENAME = "input.txt";

	public static int getVolume(int length, int width, int height){
		return length * width * height;
	}
	
	public static int getArea(int side1, int side2, int side3){
		return (2*side1) + (2*side2) + (2*side3);
	}
	
	public static int getSmallestPeri(int length, int width, int height){
		int smallest = getSmallestSide(length*width, length*height, width*height);
		
		if(smallest == length*width) return (2*length) + (2*width);
		else if(smallest == length*height) return (2*length) + (2*height);
		else return (2*width) + (2*height);
	}
	
	public static int getSmallestSide(int side1, int side2, int side3){
		return Math.min(side1, Math.min(side2, side3));
	}
	
    public static void main(String[] args){
		int length, width, height, totalPaper, totalRibbon;
		totalPaper = totalRibbon = 0;
		
		try{
			Scanner reader = new Scanner(new File(DEFAULT_FILENAME));

			while(reader.hasNextLine()){
				String[] dimensions = reader.nextLine().split("x");
				
				length = Integer.valueOf(dimensions[0]);
				width = Integer.valueOf(dimensions[1]);
				height = Integer.valueOf(dimensions[2]);

				int sideA = length*width;
				int sideB = length*height;
				int sideC = width*height;
				
				totalPaper += getArea(sideA, sideB, sideC) + getSmallestSide(sideA, sideB, sideC);
				totalRibbon += getSmallestPeri(length, width, height) + getVolume(length, width, height);
			}

			reader.close();
		}
		catch(Exception e){
			System.out.println("Error! " + e.getMessage());
		}

        System.out.printf("Part 1 - Total paper required: %d square feet.\n", totalPaper);
		System.out.printf("Part 2 - Total ribbon required: %d square feet.\n", totalRibbon);
    }
}