#include <iostream>;
using namespace std;

int main()
{
	int nums[100][100], rows, col;
	cin >> rows >> col;

	for (int i = 0; i < rows; i++)
		for (int j = 0; j < col; j++)
		cin >> nums[i][j];

	bool is_prime[100][100];
	for (int i = 0; i < rows; i++)
		for (int j = 0; j < col; j++)
		{
			if (nums[i][j] == 1)
			{
				is_prime[i][j] = 0;
				continue;
			}
			else 
			{
				is_prime[i][j] = 1;
			for (int cont = 2; cont < nums[i][j]; cont++)
			{
				if (nums[i][j] % cont == 0)
				{
					is_prime[i][j] = 0;
					break;
				}
			}
			}
			
		}

	int queries;
	cin >> queries;

	while (queries)
	{
		int currR, currC, maxR, maxC, sum = 0;
		cin >> currR >> currC >> maxR >> maxC;
		maxR += currR, maxC += currC;

		if (maxR > rows || maxC > col || currR > rows || currC > col)
		{
			cout << "invalid size postion";
			break;
		}

		for (int i = currR; i < maxR; i++)
			for (int j = currC; j < maxC; j++)
				if (is_prime[i][j])
					sum += 1;

		cout << sum << endl;
		queries--;
	}
	
	



	return 0;
}