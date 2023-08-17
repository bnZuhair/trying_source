#include <iostream>;
using namespace std;

int main()
{
	string str1, str2;
	cin >> str1 >> str2;

	bool isSuffix = true;
	for (int i = str2.size() - 1, j = str1.size() -1; i <= 0; i--, j--)
	{
		if (str1[j] != str2[i])
		{
			isSuffix = false;
			break;
		}
	}

	if (isSuffix)
		cout << "YES";
	else
		cout << "NO";
	return 0;
}