#include <iostream>;
using namespace std;

int main()
{
	string s1;
	cin >> s1;

	char s2[100];
	int currVal = 0, currAdd = 5555, currIndex = 0;
	for (int i = s1.size() - 1; i >= 0 || currAdd ; i--)
	{
		currIndex = i + 6;
		if (currAdd == 0)
			s2[currIndex] = s1[i];
		else if (i < 0)
			s2[currIndex] = currAdd % 10 + '0', currAdd /= 10;
		else
		{
			currVal = (int) (s1[i] - '0') + currAdd;
			s2[currIndex] = currVal % 10 + '0';
			currAdd = currVal / 10;

		}

	}
	for (int i = currIndex; i < s1.size() + 6; i++)
	{
		if (s2[i] >= '0' && s2[i] <= '9' )
			cout << s2[i];
	}


	return 0;
}