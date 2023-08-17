#include <iostream>;
using namespace std;

int main()
{
	int nums[100][100], size;
	cin >> size ;

	for (int i = 0; i < size; i++)
		for (int j = 0; j < size; j++)
		cin >> nums[i][j];

	int sum = 0;
	for (int row = 0; row < size; row++)
		for (int col = row; col < size; col++)
			sum += nums[row][col];


	cout << sum <<endl;

	int cnt = 1;
	sum = 0;
	for (int row = 0; row < size; row++, cnt++)
		for (int col = 0; col < cnt; col++)
			sum += nums[row][col];


	cout << sum;
	return 0;
}