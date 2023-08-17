#include <iostream>;
using namespace std;

int main()
{
	int length, nums[200 + 1] = { 0 };
	cin >> length;
	
	int totZeros = 0, totOnes = 0;
	for (int i = 1; i <= length; i++)
	{
		cin >> nums[i];
		if (nums[i])
			nums[i] = 1, totOnes++;
		else
			totZeros++;

		nums[i] += nums[i - 1];
	}

	int subLength;
	if (totOnes < totZeros)
		subLength = totOnes * 2;
	else
		subLength = totZeros * 2;
	
	int lastIndex = subLength ;
	while (subLength)
	{
		int currOnes = nums[lastIndex] - nums[lastIndex - subLength], currZeros = subLength - currOnes;
		if (currOnes == currZeros)
			break;
		else if (lastIndex == length)
			subLength--, lastIndex = subLength;
		else 
			lastIndex++;
	}

	cout << subLength;

	return 0;
}