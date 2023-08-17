/* printing trianle using recursive function
*/

#include <iostream>
using namespace std;

void triangle(int n, int i = 1)
{
	if (i == n)
		return;

	for (int j = 0; j < i; j++)
		cout << '*';
	cout << endl;

	triangle(n, ++i);
}

int main() {

	triangle(73);

	return 0;
}
