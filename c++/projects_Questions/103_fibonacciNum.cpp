/* my recursve function to ditermine the fibonacci number
*/
#include <iostream>
using namespace std;

int fibonacci(int n)
{
	if (n == 1 || n == 2)
		return 1;

	return fibonacci(n - 1) + fibonacci(n - 2);
}

int main()
{
	cout << fibonacci(2);
	cout << fibonacci(3);
	cout << fibonacci(4);
	return 0;
}
