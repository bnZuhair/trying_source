//Read a string of letters and then compress each group of same letter
// E.g. if the sub - string is cccc ? c4 ccccDDDxxxxxxxxe ? c4_D3_x8_e1
// Use _ between each group
#include <iostream>;
using namespace std;

int main()
{
	string str;
	cin >> str;

	int cnt = 1;
	for (int i = 0; i <= str.size(); i++)
	{
		if (i == 0 )
			cout << str[i]; 
		else if (str[i] == str[i - 1])
			cnt++;
		else
		{
			cout << cnt, cnt = 1;
			if (i < str.size())
				cout << "_" << str[i];
		}
	}

	return 0;
}