/* A consle n * n tic tac toe game
*/
#include <iostream>
using namespace std;

int main() {
	cout << "Enter the size \n";
	int size;
	cin >> size;
	char field[9][9];


	for (int i = 0; i < size; i++)
		for (int j = 0; j < size; j++)
			field[i][j] = '*';

	for (int i = 0; i < size * size; i++)
	{
		char currTurnSymbol;
		if (i % 2 == 0)
			currTurnSymbol = 'X';
		else
			currTurnSymbol = 'O';
		int rowPos, colPos;
		while (true)
		{
			cout << "Player " << currTurnSymbol << " turn. pelase Enter a postion \n";
			cin >> rowPos >> colPos;
			rowPos -= 1, colPos -= 1;

			if (field[rowPos][colPos] == 'X' || field[rowPos][colPos] == 'O' || rowPos < 0 || rowPos >= size || colPos < 0 || colPos >= size)
				cout << "invalid input. please try again\n";

			else
			{
				field[rowPos][colPos] = currTurnSymbol;
				cout << endl;
				break;
			}
		}
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
				cout << field[i][j] << " ";
			cout << endl;
		}

		//for varifying the winner
		// the directions    right, downleft, down, downright
		//indecies for dire     0,     1,        2,      3;
		const int dirSize = 4;
		int rowDir[dirSize] = { 0, 1, 1, 1 },
			colDir[dirSize] = { 1, -1, 0, 1 };

		bool isWinner = false, isPossToWin = i >= ((size - 1) * 2);
		if (isPossToWin)
		{
			bool isRowSimilar = true, isColSimilar = true, isRDgnlSimilar = true, isLDgnlSimilar = true;
			int currRow, currCol;
			if (isRowSimilar) {
				currRow = rowPos;
				currCol = 0;//in order to start from left to right
				for (int i = 0; i < size; i++)
				{
					if (field[currRow][currCol] != currTurnSymbol)
					{
						isRowSimilar = false;
						break;
					}
					currRow += rowDir[0], currCol += colDir[0];
				}
			}
			if (isColSimilar)
			{
				currRow = 0;//in order to start from top 
				currCol = colPos;

				for (int i = 0; i < size; i++)
				{
					if (field[currRow][colPos] != currTurnSymbol)
					{
						isColSimilar = false;
						break;
					}
					currRow += rowDir[2], currCol += colDir[2];
				}
			}

			if (isRDgnlSimilar)
			{
				currCol = size - 1, currRow = 0;

				for (int i = 0; i < size; i++)
				{
					if (field[currCol][currRow] != currTurnSymbol)
					{
						isRDgnlSimilar = false;
						break;
					}
					currCol += colDir[1], currRow += rowDir[1];
				}
			}
			if (isLDgnlSimilar)
			{
				currCol = 0, currRow = 0;
				for (int i = 0; i < size; i++)
				{
					if (field[currCol][currRow] != currTurnSymbol)
					{
						isLDgnlSimilar = false;
						break;
					}
					currCol += colDir[3], currRow += rowDir[3];
				}
			}

			if (isRowSimilar || isColSimilar || isLDgnlSimilar || isRDgnlSimilar)
			{
				isWinner = true;
			}

		}
		if (isWinner)
		{
			cout << "player " << currTurnSymbol << " is the winner \n";
			return 0;
		}

	}
	cout << "the game is tie";
	return 0;
}
