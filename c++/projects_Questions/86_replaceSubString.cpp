/* a method that replaces the sub string if it's similar
*/

#include <iostream>
using namespace std;

bool starts_with(const string& input, const string& patren, int startPos)
{
	if (startPos + patren.size() > input.size())
		return false;

	for (int i = startPos, j = 0; j < patren.size(); i++, j++)
	{
		if (input[i] != patren[j])
			return false;
	}
	return true;
}

string replace_str(const string& input, const string& patren, const string& to)
{
	string replaced = "";
	int patrenSize = (int)patren.size();

	for (int i = 0; i < input.size(); i += patrenSize)
	{
		if (starts_with(input, patren, i))
			replaced += to;
		else
			for (int j = i; j <i + patren.size(); j++)
				replaced += input[j];

	}
	return replaced;
}


int main() {

	cout << replace_str("aabcabaaad", "aa", "x") << "\n";
	cout << replace_str("aabcabaaad", "aa", "aaaa") << "\n";
	cout << replace_str("aabcabaaad", "aa", "") << "\n";

	return 0;
}
