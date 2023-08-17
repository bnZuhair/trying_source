/* my recursve array sumution 
*/

#include <iostream>
#include <math.h>
using namespace std;

int arr_sum(int arr[], int length)
{
	if (length == 1)
		return arr[0];
	return arr[length - 1] + arr_sum(arr, length - 1);
}

int main()
{
	int arr[] = { 1, 10, 10, 9, 10 };
	cout << arr_sum(arr, 5);

	return 0;
}
