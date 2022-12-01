/* 
 * Advent of Code 2021 - Day 4
 * Exercise description here: https://adventofcode.com/2021/day/4
 *
 * -sarqq 
 */

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class AoC202104{
	public static void main(String[] args){
		try{
			//filling the 5x5 grids
			Scanner reader = new Scanner(new File("input_grids.txt"));
			ArrayList<BingoCard> cards = new ArrayList<BingoCard>();
			ArrayList<String> card = new ArrayList<String>();
			
			while(reader.hasNextLine()){
				for(int i = 0; i<5; i++){
					String line = reader.nextLine().trim();
					if(line!=null && line.length()>0){
						card.add(line);
					}
					else{
						break;
					}
				}
				
				//add filled cards to collection
				if(!card.isEmpty()){
					cards.add(new BingoCard(card));
				}
				card.clear();
			}
			
			//calling numbers
			reader.reset();
			reader = new Scanner(new File("input_calls.txt"));
			String[] calls = new String[1000];
			while(reader.hasNextLine()){
				calls = reader.nextLine().split(",");
			}
			
			ArrayList<BingoCard> winners = new ArrayList<BingoCard>();
			
			boolean winner = false;
			for(int i = 0; i<calls.length; i++){
				String call = calls[i];
				for(BingoCard curr : cards){
					curr.mark(call);
					winner = curr.checkWin();
					if(winner && !winners.contains(curr)){
						curr.score(call);
						winners.add(curr);
					}
				}
			}
			
			/*
			 * Part 1
			 */
			System.out.println("First card to win, score: " + winners.get(0).score);
			
			/*
			 * Part 2
			 */
			System.out.println("Last card to win, score: " + winners.get(winners.size()-1).score);
		}
		catch(Exception e){
			System.out.println("Error: " + e.getMessage());
		}
	}
}