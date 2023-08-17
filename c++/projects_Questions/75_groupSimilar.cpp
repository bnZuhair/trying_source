#include <iostream>;
using namespace std;

int main()
{
	string str;
	cin >> str;

	bool isFirst = true;
	for (int i = 0; i < str.size(); i++)
	{
		if (isFirst)
		{
			cout << str[i];
			isFirst = false;
		}
		else if (str[i] == str[i - 1])
			cout << str[i];
		else
			cout << " " << str[i] ;
	}


	return 0;
}