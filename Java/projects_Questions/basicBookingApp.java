import java.util.Scanner;
public class Test{	
	private static boolean seatsAvailablity[] = new boolean[11];
	static Scanner in = new Scanner(System.in);	

	public static void main(String[] args){
		//for testing
		/*
		for (int i = 0 ; i <= 5 ; i++)
			seatsAvailablity[i] = true;
		*/
		
		boolean validValue = false;
		System.out.println("Please type 1 for First Class and Please type 2 for Economy.");
		int numEntered = in.nextInt();
		if (numEntered == 1 || numEntered == 2)
			validValue = true;
		
		while (validValue == false) {
			System.out.println("you enterd an unvalid value\nPlease type 1 for First Class and Please type 2 for Economy.");
			numEntered = in.nextInt();
			if (numEntered == 1 || numEntered == 2)
				validValue = true;
		}
		booking(numEntered);
		
		
		
	
	
			
	}
	private static void booking(int type) {
		if(type == 1) {
			for(int i = 1 ; i <=5 ; i++) {
				if (seatsAvailablity[i] == false) {
					seatsAvailablity[i] = true;
					System.out.printf("Book complete%nThere are %d seats available", 5 - i);
					break;
				}
				if ( i < 5 && seatsAvailablity[i] == true)
					continue;
				else {
					System.out.println("The first class if full do you want to change it to economy class??");
					String answer = in.next().trim();
					if (answer.equals("yes") || answer.equals("Yes") || answer.equals("yeah") || answer.equals("Yeah"))
						booking(2);
					else
						System.out.println("Next flight leaves in 3 hours.");
				}
			}
		}
		else if (type == 2) {
			for (int i = 6 ; i <= 10 ; i++) {
				if (seatsAvailablity[i] == false) {
					seatsAvailablity[i] = true;
					System.out.printf("Book complete%nThere are %d seats available", 10 - i);
					break;
				}
				if ( i < 5 && seatsAvailablity[i] == true)
					continue;
				else {
					System.out.println("The economy class if full do you want to change it to first class??");
					String answer = in.next().trim();
					if (answer.equals("yes") || answer.equals("Yes") || answer.equals("yeah") || answer.equals("Yeah"))
						booking(2);
					else
						System.out.println("Next flight leaves in 3 hours.");
				}
			}
		}
			

	}
	
}
	