#include <iostream>;
using namespace std;

int main()
{
	string str1, str2;
	cin >> str1 >> str2;

	int similar[1000] = { 0 };
	for (int i = 0, j = 0; i < str1.size() && j < str2.size(); i++)
	{
		if (str1[i] == str2[j])
		{
			similar[j] = 1;
			j++;
		}
	}

	bool isSubsequence = true;
	for (int i = 0; i < str2.size(); i++)
	{
		if (similar[i] != 1)
		{
			isSubsequence = false;
			break;
		}

	}
	if (isSubsequence )
		cout << "YES";
	else
		cout << "NO";
	return 0;
}