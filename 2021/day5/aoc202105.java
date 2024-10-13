/*
 * Advent of Code 2021 - day 5
 * -sarqq
 */

import java.io.File;
import java.util.*;

public class aoc202105{
	static final String DEFAULT_FILENAME = "input.txt";

	public static ArrayList<String> read_file(String filename){
		ArrayList<String> lines = null;

		try{
			Scanner reader = new Scanner(new File(filename));
			lines = new ArrayList<>();

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

	public static void mapDangerousNodes(ArrayList<String> data){
		ArrayList<Node> vents = new ArrayList<>();
		int x1, y1, x2, y2;

		//iterate through node data
		for(String entry : data){
			String[] points = entry.trim().split(" -> ");
			String[] point1 = points[0].trim().split(",");
			String[] point2 = points[1].trim().split(",");
		
			//terminal coordinates
			x1 = Integer.valueOf(point1[0]);
			y1 = Integer.valueOf(point1[1]);
			x2 = Integer.valueOf(point2[0]);
			y2 = Integer.valueOf(point2[1]);

			//create Nodes in range x1,y1 -> x2,y2
			//if x1 == x2, no x movement; otherwise negative/positive
			int directionX = ((x1 == x2) ? 0 : ((x1 > x2) ? -1 : 1));
			//if y1 == y2, no y movement; otherwise negative/positive
			int directionY = ((y1 == y2) ? 0 : ((y1 > y2) ? -1 : 1));

			//move from x1,y1 to x2,y2
			while(true){
				Node vent = new Node(x1, y1);
				
				//add new vent
				if(!vents.contains(vent)){
					vents.add(vent);
				}
				else{
					for(Node v : vents){
						if(v.equals(vent)){
							v.increaseRating();
							System.out.println(v);
							break;
						}
					}
				}
				
				//stop if arrived at x2,y2
				if(x1==x2 && y1==y2) break;

				//move
				x1 += directionX;
				y1 += directionY;
			}
		}

		//read node danger levels
		int hotspots = (int) vents.stream().filter(v -> v.getRating()>=2).count();

		System.out.printf("Part 2 - Number of hotspots: %d\n", hotspots);
	}

	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter filename: ");
		String filename = reader.nextLine();
		reader.close();

		if(filename.isEmpty()){
			filename = DEFAULT_FILENAME;
		}

		ArrayList<String> nodeData = read_file(filename);
		
		if(nodeData != null){
			mapDangerousNodes(nodeData);
		}
		else{
			System.out.println("Error in input file!");
		}

	}
}
