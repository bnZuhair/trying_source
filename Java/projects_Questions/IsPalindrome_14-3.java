import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean isPalindrome = false;
		System.out.println("please enter a word");

		String word = in.next();

		if (word.length() % 2 == 0) {
			for (int i = 0, j = word.length() - 1; i < (word.length() / 2); i++, j--) {
				if (word.toLowerCase().charAt(i) == word.toLowerCase().charAt(j))
					isPalindrome = true;
				else {
					isPalindrome = false;
					break;
				}
			}
		} else {
			for (int i = 0, j = word.length() - 1; i < ((word.length() - 1) / 2); i++, j--) {
				if (word.toLowerCase().charAt(i) == word.toLowerCase().charAt(j))
					isPalindrome = true;
				else {
					isPalindrome = false;
					break;
				}
			}
		}
		if (isPalindrome == true)
			System.out.println("this word is a palindrome");
		else
			System.out.println("this word is not a Palindrome");
	}
}