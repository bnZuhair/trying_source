/* printing a sequence and returning the length of the sequence
*/

#include <iostream>
using namespace std;

int printSequence(int n)
{
	static int length = 0;
	length++;
	cout << n << " ";
	if (n == 1)
		return length;
	else if (n % 2 == 0)
		printSequence(n / 2);
	else
		 printSequence(n * 3 + 1);
}

int main() 
{
	cout << endl << printSequence(6);

	return 0;
}
