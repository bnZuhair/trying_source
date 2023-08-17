/* my recursve array left max
witch change the value with the value of the max between the value and the value before it
*/
#include <iostream>
using namespace std;

void left_max_arr(int arr[], int length)
{
	if (length == 1)
		return;

	left_max_arr(arr, length - 1);
	arr[length - 1] = max (arr[length -1], arr[length - 2]);

}

int main()
{
	int arr[] = { 1, 2, 0, 5, 1 };
	left_max_arr(arr, 5);
	// cout << inc_arr(arr, 4);
	for (int i = 0; i < 5; i++)
		cout << arr[i] << " ";

	return 0;
}
