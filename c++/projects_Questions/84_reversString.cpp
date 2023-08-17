/* 
*/

#include <iostream>
using namespace std;
string reverse_str(const string& str)
{
	string reversed = "";
	for (int i = str.size() - 1; i >= 0; i--)
		reversed += str[i];
	return reversed;
}

int main() {
	string name = "Saleh";
	cout << reverse_str(name);

	return 0;
}
