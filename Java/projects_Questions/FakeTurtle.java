/*
 * this program is something like the turtle who draw in your screen but more simplified version\
 * however, i didn't make it to the end Idk what is wrong with the it.
 */
import java.util.Scanner;
public class Test{
	enum State {UP, DOWN};
	static State penState = State.UP;//Default value
	
	enum Direction {RIGHT, DOWN, LEFT, UP};
	static Direction turtleDirection = Direction.RIGHT;//default value
	
	private static  int turtleRow = 0, turtleColumn = 0;//turtle position
	private static  int rowSize = 20, columnSize = 20;//board size 
	private static char printedSymbol = '*';
	//static int[][] floor = new int[rowSize][columnSize];
	static char[][] floor = new char[rowSize][columnSize];

	
	public static void main(String[] args) {
		for (int i = 0 ; i < floor.length ; i++)
			for (int j = 0 ; j < floor[i].length  ; j ++) {
				floor[i][j] = ' ';
			}
		Scanner in = new Scanner(System.in);
		boolean validValue = false;
		printHelp();
		while (true) {
			System.out.println("Enter your Command:\n");
			String valueEntered = in.next().trim();
			char cutted = valueEntered.charAt(0);
			if ( cutted == '0' || cutted == '1' || cutted == '2' || cutted == '3' || cutted == '4' || cutted == '5' ||
					cutted == '6' || cutted == '9') 
				validValue = true;
			else {
			while(validValue == false) {
				System.out.println("please Enter a valid value:\n");
					valueEntered = in.next().trim();
					cutted = valueEntered.charAt(0);
					if ( cutted == '0' || cutted == '1' || cutted == '2' || cutted == '3' || cutted == '4' || cutted == '5' ||
							cutted == '6' || cutted == '9')  
						validValue = true;
				}
			}
			if ( cutted == '0' )
				printHelp();
			else if (cutted == '1' || cutted == '2')
				changePenState(cutted);
			else if (cutted == '3' || cutted == '4')
				changeDirection(cutted);
			else if ( cutted == '5' )
				if (valueEntered.startsWith("5,"))
					movingForword(Integer.parseInt(valueEntered.substring(2, 4)));
				else
					System.out.println("wrong command");
			else if (cutted == '6' )
				printBoard();
			else if (cutted == '9') {
				System.out.println("\n\ncya...");
				System.exit(0);
			}
				


				
			
			
		}
		
	}
	static void printHelp() {
		System.out.printf("%-5s-->%s%n%-5s-->%s%n%-5s-->%s%n%-5s-->%s%n%-5s-->%s%n%-5s-->%s%n%-5s-->%s%n%-5s-->%s%n%n",
				"0", "To get main commands",
				"1", "To Lift the pen up",
				"2", "To Put the pen down",
				"3", "To turn right",
				"4", "To turn left",
				"5,[i]", "to move forward by the number you put in the place of i",
				"6", "Display the board",
				"9", "Stop the program");
	}
	static void changePenState (int EnteredStated) {
		if (EnteredStated == 1 ) 
			penState = State.UP;
		
		else if (EnteredStated == 2 ) 
			penState = State.DOWN;
		
	}
	static void printBoard () {
		for (int row = 0 ; row < floor.length ; row++) {
			for (int colmn = 0 ; colmn < floor[row].length ; colmn++) {
			/*	if (floor[row][colmn] == 1)
					System.out.print(printedSymbol);
				else
					System.out.print(" ");
					*/
				System.out.println(floor[row][colmn]);
			}
		System.out.println();
		}

			
	}
	static void changeDirection (int EnteredChange) {
		if (EnteredChange == 3) {//to the right
			if (turtleDirection == Direction.RIGHT)
				turtleDirection = Direction.DOWN;
			else if (turtleDirection == Direction.DOWN)
				turtleDirection = Direction.LEFT;
			else if (turtleDirection == Direction.LEFT)
				turtleDirection = Direction.UP;
			else if (turtleDirection == Direction.UP)
				turtleDirection = Direction.RIGHT;
			
		}
		else {//to the left
			if (turtleDirection == Direction.RIGHT)
				turtleDirection = Direction.UP;
			else if (turtleDirection == Direction.DOWN)
				turtleDirection = Direction.RIGHT;
			else if (turtleDirection == Direction.LEFT)
				turtleDirection = Direction.DOWN;
			else if (turtleDirection == Direction.UP)
				turtleDirection = Direction.LEFT;
		
		
		
		}
	}
	static void movingForword (int EnteredSteps) {
		if (penState == State.DOWN) {
			if (turtleDirection == Direction.RIGHT)//Change in the columns
				for (int i = 0 ; i < EnteredSteps ; i++) {
					if (i > columnSize)
						break;
					else {
						floor[turtleRow][i] = printedSymbol;
						turtleColumn++;
					}			
				}
			else if (turtleDirection == Direction.DOWN)
				for (int i = 0 , j = turtleColumn; i < EnteredSteps ; j--, i++) {
					if (j < 0)
						break;
					else {
						floor[j][turtleColumn] = printedSymbol;
						turtleRow--;
					}
				}
			else if (turtleDirection == Direction.LEFT)
				for (int i = 0 , j = turtleColumn; i < EnteredSteps ; j--, i++) {
					if (j < 0)
						break;
					else {
						floor[turtleRow][j] = printedSymbol;
						turtleColumn--;
					}
				}
			else if (turtleDirection == Direction.UP)
				for (int i = 0 ; i < EnteredSteps ; i++) {
					if (i > rowSize)
						break;
					else {
						floor[i][turtleColumn] = printedSymbol;
						turtleRow++;
					}			
				}

		}else {
			if (turtleDirection == Direction.RIGHT)//Change in the columns
				for (int i = 0 ; i < EnteredSteps ; i++) {
					if (i > columnSize)
						break;
					else {
						
						turtleColumn++;
					}			
				}
			else if (turtleDirection == Direction.DOWN)
				for (int i = 0 , j = turtleColumn; i < EnteredSteps ; j--, i++) {
					if (j < 0)
						break;
					else {
						
						turtleRow--;
					}
				}
			else if (turtleDirection == Direction.LEFT)
				for (int i = 0 , j = turtleColumn; i < EnteredSteps ; j--, i++) {
					if (j < 0)
						break;
					else {
						
						turtleColumn--;
					}
				}
			else if (turtleDirection == Direction.UP)
				for (int i = 0 ; i < EnteredSteps ; i++) {
					if (i > rowSize)
						break;
					else {
						
						turtleRow++;
					}			
				}
		}
		
	}
}