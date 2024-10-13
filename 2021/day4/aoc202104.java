/* 
 * Advent of Code 2021 - Day 4
 * Exercise description here: https://adventofcode.com/2021/day/4
 *
 * -sarqq
 *
 *  TODO: Debug!
 */

import java.util.Scanner;
import java.io.File;
import java.util.Arrays;
import java.util.ArrayList;

public class aoc202104{
	static final String DEFAULT_CARDS = "input_cards.txt";
	static final String DEFAULT_DRAWS = "input_draws.txt";
	static final int ROWS = 5;
	static final int COLUMNS = 5;

	public static ArrayList<BingoCard> read_cards(String filename){
		ArrayList<BingoCard> cards = null;
		
		try{
			//read file
			Scanner reader = new Scanner(new File(filename));
			cards = new ArrayList<BingoCard>();
			ArrayList<String> card = new ArrayList<String>();

			//filling ROWS x COLUMNS bingo cards
			while(reader.hasNextLine()){
				
				for(int i=0; i<ROWS; i++){
					String line = reader.nextLine().trim();
					
					//line not empty, add row to card
					if(line != null && line.length()>0){
						card.add(line);
					}
					//empty row
					else break;
				}

				//create card and add to card list
				if(!card.isEmpty()){
					cards.add(new BingoCard(card));
				}
				
				//reset card
				card.clear();
			}
			
			//close reader
			reader.close();
		}
		catch(Exception e){
			System.out.println("Error: " + e.getMessage());
		}

		//return list of cards
		return cards;
	}

	public static String[] read_draws(String filename){
		String[] draws = null;

		try{
			//read file
			Scanner reader = new Scanner(new File(filename));

			//filling list with draws from file
			while(reader.hasNextLine()){
				draws = reader.nextLine().split(",");
			}

			//close reader
			reader.close();
		}
		catch(Exception e){
			System.out.println("Error: " + e.getMessage());
		}

		return draws;
	}

	public static void playBingo(ArrayList<BingoCard> cards, String[] draws){
		ArrayList<BingoCard> leaderboard = new ArrayList<BingoCard>();
		
		//start drawing numbers
		for(String draw : draws){
			//check every card for hits
			for(BingoCard card : cards){
				card.hit(draw);
				
				//bingo! new winning card is added to the leaderboard
				if(card.checkWin() && !leaderboard.contains(card)){
					card.setScore(draw);
					leaderboard.add(card);
				}
			}
		}

		//first to win, last to win
		BingoCard firstPlace = leaderboard.get(0);
		BingoCard lastPlace = leaderboard.get(leaderboard.size()-1);
		
		//Part 1
		System.out.printf("Part 1 - First card to win, score: %d\n", firstPlace.getScore());
		
		//Part 2
		System.out.printf("Part 2 - Last card to win, score: %d\n", lastPlace.getScore());
	}


	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Enter filename of bingo card data: ");
		String filename_cards = reader.nextLine();
		if(filename_cards.isEmpty()){
			filename_cards = DEFAULT_CARDS;
		}

		System.out.println("Enter filename of draw data: ");
		String filename_draws = reader.nextLine();
		if(filename_draws.isEmpty()){
			filename_draws = DEFAULT_DRAWS;
		}

		ArrayList<BingoCard> cards = read_cards(filename_cards);
		String[] draws = read_draws(filename_draws);

		if(cards != null && draws != null){
			playBingo(cards, draws);
		}
	}
}
