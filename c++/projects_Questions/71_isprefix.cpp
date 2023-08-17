#include <iostream>;
using namespace std;

int main()
{
	string str1, str2;
	cin >> str1 >> str2;

	bool isPrefix = true;
	for (int i = 0; i < str2.size(); i++)
	{
		if (str1[i] != str2[i])
		{
			isPrefix = false;
			break;
		}
	}

	if (isPrefix)
		cout << "YES";
	else
		cout << "NO";
	return 0;
}