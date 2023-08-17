import java.util.Scanner;
public class Test{	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		for ( int i = 0 ; i < 10 ; i++) {
			for (int j = 0 ; j <= i ; j++)
				System.out.print("*");
			System.out.println();
		}
		System.out.println();

		for ( int i = 0 ; i < 10 ; i++) {
			for (int j = 9 ; j >= i ; j--)
				System.out.print("*");
			System.out.println();
		}
		System.out.println();

		for ( int i = 0 ; i < 10 ; i++) {
			if (i != 0)
				for (int k = 0 ; k < i ; k++)
					System.out.print(" ");
			for (int j = 9 ; j >= i ; j--)
				System.out.print("*");
			System.out.println();
		}
		System.out.println();

		for ( int i = 10 ; i > 0 ; i--) {
			if (i != 1)
				for (int k = 1 ; k < i ; k++)
					System.out.print(" ");
			for (int j = 10 ; j >= i ; j--)
				System.out.print("*");
			System.out.println();
		}

	}
	
}
