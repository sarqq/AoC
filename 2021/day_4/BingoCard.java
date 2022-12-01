import java.util.ArrayList;

class BingoCard{
	String[][] numbers;
	int score;
	
	public BingoCard(ArrayList<String> rows){
		this.numbers = new String[5][5];
		
		for(int i = 0; i<rows.size(); i++){
			String[] row = rows.get(i).split("\\s+");
			for(int j = 0; j<5; j++){
				if(row[j]!=null){
					this.numbers[i][j] = new String(row[j]);
				}
			}
		} 
	}
	
	public void score(String call){
		int sum = 0;
		for(int i = 0; i<this.numbers.length; i++){
			for(int j = 0; j<this.numbers[0].length; j++){
				if(!(this.numbers[i][j].equals("x"))){
					sum += Integer.valueOf(this.numbers[i][j]);
				}
			}
		}
		this.score = sum*Integer.valueOf(call);
	}
	
	public boolean checkWin(){
		boolean win	= false;
		
		//checking rows
		for(int i = 0; i<this.numbers.length; i++){
			win = true;
			for(int j = 0; j<this.numbers[0].length; j++){
				if(!(this.numbers[i][j].equals("x"))){
					win = false;
					break;
				}
			}
			if(win){
				return win;
			}
		}
		
		//checking columns
		for(int i = 0; i<this.numbers.length; i++){
			win = true;
			for(int j = 0; j<this.numbers[0].length; j++){
				if(this.numbers[j][i].equals("x") == false){
					win = false;
					break;
				}
			}
			if(win){
				return win;
			}
		}
		
		return false;
	}
	
	public void mark(String call){
		for(int i = 0; i<this.numbers.length; i++){
			for(int j = 0; j<this.numbers[0].length; j++){
				if(this.numbers[i][j].equals(call)){
					this.numbers[i][j] = "x";
				}
			}
		}
	}
	
	@Override
	public String toString(){
		String result = "";
		for(int i = 0; i<this.numbers.length; i++){
			for(int j = 0; j<this.numbers[0].length; j++){
				result += this.numbers[i][j]+ " ";
			}
			result += "\n";
		}
		result.trim();
		return result;
	}
}