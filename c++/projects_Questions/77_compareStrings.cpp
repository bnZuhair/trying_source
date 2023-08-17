#include <iostream>;
using namespace std;

int main()
{
	string s1, s2;
	cin >> s1 >> s2;


	int maxSize;
	if (s1.size() > s2.size())
		maxSize = s1.size();
	else
		maxSize = s2.size();

	int s1Value = 0, s2Value = 0;
	for (int i = 0; i < maxSize; i++)
	{
		if (i >= s1.size() && i >= s2.size())
			s1Value += 0, s2Value += 0;
		else if ((i >= s1.size()) || (i >= s2.size()))
		{
			if (i >= s1.size())
				s1Value += 0, s2Value += s2[i];
			else
				s2Value += 0, s1Value += s1[i];
		}
		else
			s1Value += s1[i], s2Value += s2[i];
		if (s1Value < s2Value)
			break;
		else if (s1Value > s2Value)
		{
			cout << "No";
			return 0;
		}
	}
	cout << "Yes";
	return 0;
}