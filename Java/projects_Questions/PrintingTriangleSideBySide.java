import java.util.Scanner;
//Scanner in = new Scanner(System.in);
public class Test{	
	public static void main(String[] args){
		
		for (int i = 1, j = 10 ; i <= 10 && j >= 0 ; i++, j--) {
			for (int k = 1 ; k <= 4 ; k++) {
				if (k == 1) {
					for (int l = 1 ; l <= i ; l++)
						System.out.print("*");
					for (int l = 1 ; l < j ; l++)
						System.out.print(' ');
					System.out.print("   ");
				}
				else if (k == 2) {
					for(int l = 1 ; l <= j ; l++)
						System.out.print("*");
					for (int l = 1 ; l < i ; l++)
						System.out.print(' ');
					System.out.print("   ");
				}
				else if (k == 3) {
					for (int l = 1 ; l < i ; l++)
						System.out.print(' ');
					for(int l = 1 ; l <= j ; l++)
						System.out.print("*");
					System.out.print("   ");

				}
				else if (k == 4) {
					for (int l = 1 ; l < j ; l++)
						System.out.print(' ');
					for (int l = 1 ; l <= i ; l++)
						System.out.print("*");
					System.out.print("   ");
				}
			}
			System.out.println();
		}


				
			

	}
	
}
