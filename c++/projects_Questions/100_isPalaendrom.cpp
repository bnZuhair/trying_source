/* my recursve array function to ditermine if the array is palandrom or not
the doctor made a lot better second slotion in 144
*/
#include <iostream>
using namespace std;

bool is_palandrom(int arr[], int length)
{
	static int cont = length / 2;
	if (cont == 0)
		return 1;

	if (arr[0] == arr[length - 1])
	{
		cont--;
		return 1 * is_palandrom(arr + 1, length - 2);
	}
	else
		return 0;
}

int main()
{
	int arr[] = { 1, 1, 0, 1, 1 };
	//(arr, 5);
	cout << is_palandrom(arr, 5) << " \n";
	for (int i = 0; i < 5; i++)
		cout << arr[i] << " ";

	return 0;
}
