import java.util.Scanner;
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> SpecialList = new ArrayList<String>();
		Scanner in = new Scanner(System.in);
		
		while(true) {
			System.out.println("please enter a word");
			String word = in.next();
			if (word.equals("#") ) 
				break;
			else if (word.matches("[a-zA-Z1-9]+"))
				list.add(word);
			else
				SpecialList.add(word);
		}
		System.out.printf("%-6s %-20s%n", "count", "words");
		pirntVlaues(list.size(), list);
		pirntVlaues(SpecialList.size(), SpecialList);

	}
	private static void pirntVlaues(int counter, ArrayList list) {
		System.out.print(list.size());
		for(int i = 0 ; i < list.size(); i++) {
			if (i == list.size() -1)
				System.out.print(" " + list.get(i) );
			else	
			System.out.print(" " + list.get(i) + "," );
		}
		System.out.println();

	}
}