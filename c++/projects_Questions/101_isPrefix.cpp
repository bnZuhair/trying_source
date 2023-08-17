/* my recursve function to ditermine if a substring is a prefix or not
*/
#include <iostream>
using namespace std;

bool is_prefix(const string& main,const string& suffix, int startPos = 0)
{
	if (startPos == suffix.size())
		return true;

	if (main[startPos] == suffix[startPos])
		return true * is_prefix(main, suffix, startPos + 1);
	else
		return false;
}

int main()
{
	string main = "abcdefgh";

	cout << is_prefix(main, "bc") << "\n";
	cout << is_prefix(main, "") << "\n";
	cout << is_prefix(main, "adcd") << "\n";


	return 0;
}
