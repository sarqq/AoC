import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.HashMap;

public int solve(HashMap<Integer, Integer> map, int days){
	ArrayList<Integer> list = new ArrayList<Integer>();
	for(int i = 0; i<map.size(); i++){
		list.add(map.get(i));
	}
	for(int i = 0; i<days; i++){
		list.get((i+7)%9) += list.get(i%9);
	}
}

public class AoC202106{
	public static void main(String[] args){
		try{
			Scanner reader = new Scanner(new File("AoC202106-input.txt"));
			List<Integer> fish = new ArrayList<Integer>();
			
			while(reader.hasNextLine()){
				String line = reader.nextLine();
				String[] age = line.split(",");
				for(int i = 0; i<age.length; i++){
					fish.add(Integer.valueOf(age[i]));
				}
			}
			
			System.out.println(fish);
			//toimii tähän asti
			
			//for(int i = 0; i<256; i++){
			//	ListIterator<Integer> itr = fish.listIterator();
			//	while(itr.hasNext()){
			//		int timer = itr.next();
			//		itr.set(timer-1);
			//		if(timer == 0){
			//			itr.set(6);
			//			itr.add(8);
			//		}
			//	}
			//}
			
			HashMap<Integer, Integer> test = new HashMap<Integer, Integer>();
			
			System.out.println(fish.size());
		}
		catch(Exception e){
			System.out.println("Error: " + e.getMessage());
		}
	}
}