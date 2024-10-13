import java.util.ArrayList;

class BingoCard{
	private final int ROWS = 5;
	private final int COLUMNS = 5;
	private String[][] numbers;
	private int score;
	
	public BingoCard(ArrayList<String> numbers){
		this.score = 0;
		this.numbers = new String[ROWS][COLUMNS];
		
		//fill card
		for(int i = 0; i<ROWS; i++){
			String[] row = numbers.get(i).split("\\s+");
			for(int j = 0; j<COLUMNS; j++){
				if(row[j] != null){
					this.numbers[i][j] = new String(row[j]);
				}
			}
		}
	}
	
	public void setScore(String winning_draw){
		for(String[] row : this.numbers){
			for(String number : row){
				if(!number.equals("x")){
					this.score += Integer.valueOf(number);
				}
			}
		}
		this.score *= Integer.valueOf(winning_draw);
	}

	public int getScore(){
		return this.score;
	}
	
	public boolean checkWin(){
		//checking rows and colmuns
		for(int i = 0; i<ROWS; i++){
			String row = "";
			String column = "";
			
			for(int j = 0; j<COLUMNS; j++){
				row += this.numbers[i][j];
				column += this.numbers[j][i];
			}
			
			//winning row or column
			if(row.equals("xxxxx") || column.equals("xxxxx")){
				return true;
			}
		}

		//no winning rows or columns
		return false;
	}
	
	public void hit(String draw){
		for(int i = 0; i<ROWS; i++){
			for(int j = 0; j<COLUMNS; j++){
				if(this.numbers[i][j].equals(draw)){
					this.numbers[i][j] = "x";
				}
			}
		}
	}
	
	@Override
	public String toString(){
		String result = "";

		for(String[] row : this.numbers){
			for(String num : row){
				result += num + " ";
			}
			result += "\n";
		}
		result.trim();
		
		return result;
	}
}
