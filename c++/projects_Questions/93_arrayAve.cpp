/* my recursve array average
*/

#include <iostream>
#include <math.h>
using namespace std;

int arr_avg(int arr[], int length)
{
	const static int maxLength = length;
	if (length == 1)
		return arr[length - 1] / maxLength;
	return arr[length - 1] / maxLength + arr_avg(arr, length - 1);
}

int main()
{
	int arr[] = { 4, 4, 4, 4 };
	cout << arr_avg(arr, 4);

	return 0;
}
