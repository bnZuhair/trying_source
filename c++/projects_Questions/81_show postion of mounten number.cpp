//mountain is a number that all it's surroundings are less that it.
//this program will give you the indices of the mountains in the array.


#include <iostream>;
using namespace std;

int main()
{
	int nums[100][100], rows, cols;
	cin >> rows >> cols;

	for (int i = 0; i < rows; i++)
		for (int j = 0; j < cols; j++)
			cin >> nums[i][j];

	const int dirN = 8,
		rowDir[dirN] = { -1, -1, -1, 0, 0, 1, 1, 1 },
		colDir[dirN] = { -1, 0, 1, -1, 1, -1, 0, 1 };

	for (int row = 0; row < rows; row++)
	{
		bool is_mountain = true;
		for (int col = 0; col < cols; col++)
		{
			is_mountain = true;
			for (int i = 0; i < dirN; i++)
			{
				int crrRowDir = row + rowDir[i],
					crrColDir = col + colDir[i];

				bool validDirection = crrColDir >= 0 && crrRowDir >= 0 && crrRowDir < rows && crrColDir < cols;
				if (validDirection)
					if (nums[row][col] < nums[crrRowDir][crrColDir])
					{
						is_mountain = false;
						break;
					}
			}
			if (is_mountain)
			{
				cout << row << " " << col << "\n";
				col++;
			}
		}


	}



	return 0;
}