/* my recursve array accmulation 
* witch make the value of the index is the sum of it and all the prevous values
*/

#include <iostream>
using namespace std;

void accm_arr(int arr[], int length)
{
	if (length == 2)
	{
		arr[length - 1] += arr[length - 2];
		return;
	}

	accm_arr(arr, length - 1);
	arr[length - 1] += arr[length - 2];

}

int main()
{
	int arr[] = { 1, 1, 1, 1, 1 };
	accm_arr(arr, 5);
	// cout << inc_arr(arr, 4);
	for (int i = 0; i < 5; i++)
		cout << arr[i] << " ";

	return 0;
}
