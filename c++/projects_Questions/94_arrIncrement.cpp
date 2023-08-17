/* my recursve array increment value by it's index 
*/

#include <iostream>
#include <math.h>
using namespace std;

void inc_arr(int arr[], int length)
{
	if (length == 1)
	{
		cout << arr[length - 1] + length - 1 << " ";
		return ;
	}

	inc_arr(arr, length - 1);
	cout << arr[length - 1] + length - 1  <<  " ";
	
}

int main()
{
	int arr[] = { 0, 0, 0, 0, 0 };
	inc_arr(arr, 5);
	// cout << inc_arr(arr, 4);

	return 0;
}
