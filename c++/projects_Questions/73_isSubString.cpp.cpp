#include <iostream>;
using namespace std;

int main()
{
	string str1, str2;
	cin >> str1 >> str2;

	bool isSubstring = true;
	int firstIndex = 0, lastIndex = str2.size();
	for (int startPoint = 0; startPoint <= str1.size() - str2.size(); startPoint++)
	{
		for (int i = startPoint, j = firstIndex; j < lastIndex; i++, j++)
		{
			isSubstring = true;
			if (str1[i] != str2[j])
			{
				isSubstring = false;
				break;
			}
		}
			if (isSubstring)
				break;
	}

	if (isSubstring)
		cout << "YES";
	else
		cout << "NO";
	return 0;
}