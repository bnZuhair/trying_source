#include <iostream>;
using namespace std;

int main()
{
	string str;
	cin >> str;

	const int numsSize = 11;
	char nums[numsSize] = { '0','1', '2', '3', '4', '5', '6', '7','8', '9', '\0'};
	
	int num = 0, digitConverter = 1;
	for (int i = str.size() - 1; i >= 0; i--)
	{
		for (int j = 0; j < numsSize; j++)
		{
			if ( str[i] == nums[j] )
			{
				num += j * digitConverter;
				digitConverter *= 10;
			}
		}
	}
	cout << num << " " << num * 3;
	return 0;
}