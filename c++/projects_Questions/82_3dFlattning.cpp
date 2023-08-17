/* flattning a 3d array
* 
*/

#include <iostream>
using namespace std;

int main()
{
	int dep , row , col , option;

	cin >> dep >> row >> col >> option;

	if (option == 1)
	{
		int cDep, cRow, cCol;
		cin >> cDep >> cRow >> cCol;
		cout << cDep * row * col + cRow * col + cCol;


	}
	else if (option == 2)
	{	
		int index;
		cin >> index;
		 
		cout << index / (row * col) << " " << (index % (row * col) - index %  col) / row << " " << index % col;
	}


    return 0;
}

