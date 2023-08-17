/* my recursve array sum the number of the elements form the prefix of the array
*/
#include <iostream>
using namespace std;

int sum_prefix(int arr[], int numForSum)
{
	if (numForSum == 1)
		return arr[0];

	return arr[numForSum - 1] + sum_prefix(arr, numForSum - 1);

}

int main()
{
	int arr[] = { 1, 4, 0, 2, 1 };
	//sum_syffix(arr, 5);
	cout << sum_prefix(arr, 3) << " \n";
	for (int i = 0; i < 5; i++)
		cout << arr[i] << " ";

	return 0;
}
