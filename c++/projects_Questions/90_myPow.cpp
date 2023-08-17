/* my recurseve power function
*/

#include <iostream>
using namespace std;

int my_pow(int value, int p = 2)
{
	if (p == 0)
		return 1;
	else if (p >= 1)
		return value * my_pow(value, --p);
}

int main()
{
	cout << endl << my_pow(5, 0);

	return 0;
}
