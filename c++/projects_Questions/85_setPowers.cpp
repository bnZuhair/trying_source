/*
*/

#include <iostream>
using namespace std;


void set_powers(int array[], int length = 5, int m = 2)
{
	array[0] = 1;
	for (int i = 1; i < length; i++)
	{
		array[i] = array[i - 1] * m;
	}
}

int main() {
	int array[6], i;
	set_powers(array );
	for (int i = 0; i < 6; i++)
		cout << array[i] << " ";

	return 0;
}
