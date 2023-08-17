/* my recursve array maximum value
*/

#include <iostream>
#include <math.h>
using namespace std;

int arr_max(int arr[], int length)
{
	if (length == 1)
		return arr[0];
	return max(arr[length - 1], arr_max(arr, length - 1));
}

int main()
{
	int arr[] = { 1, 3, 6, 9, 10 };
	cout << arr_max(arr, 5);

	return 0;
}
