/* my recursve array sum the number of the elements form the syfix of the array
*/
#include <iostream>
using namespace std;

int sum_syffix(int arr[], int numForSum, int length)
{
	if (numForSum == 0)
		return 0;

	return arr[length - 1] + sum_syffix(arr, --numForSum, length - 1);

}

int main()
{
	int arr[] = { 1, 4, 0, 2, 1 };
	//sum_syffix(arr, 5);
	cout << sum_syffix(arr, 3, 5) << " \n";
	for (int i = 0; i < 5; i++)
		cout << arr[i] << " ";

	return 0;
}
