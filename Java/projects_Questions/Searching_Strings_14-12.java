import java.util.Scanner;


public class Test {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int lettersListOcc[] = new int[28];
		char lettersList[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
				'u', 'v', 'w', 'x', 'y', 'z'};
		System.out.println("please enter a text ");
		String text = in.nextLine();
		int count = 0;
		while (count < lettersList.length) {
			
			for ( int i = 0, j ; i < text.length() ; i++ ){
				if((j = text.toLowerCase().indexOf(lettersList[count] , i)) != -1 ) {
					lettersListOcc[count] += 1;
					i = j;
				}
				else
					break;
			}
			count++;
		}
		
		
		System.out.printf("the text you have entered is:%s%nLetter	occurrence%n", text );
		for(int i = 0 ; i < lettersList.length ; i++) {
			System.out.printf("%-8s%s%n", lettersList[i], lettersListOcc[i]);			
		}
		
	

	}

}