/* my simple queue
*/

#include <iostream>
using namespace std;

struct Queue {
	int values[100], len ;

	Queue() {
		len = 0;
	}

	void add_end( const int& value) {
		values[len] = value;
		len++;
	}

	void shiftR() {
		for (int i = len; i >= 0; i--)
			values[i + 1] = values[i];

	}

	void add_front(const int& value) {
		shiftR();
		values[0] = value;
		len++;
	}

	void shiftL() {
		for (int i = 0; i < len; i++)
			values[i] = values[i + 1];
	}

	int remove_front() {
		int value = values[0];
		shiftL();
		len--;

		return value;
	}

	void print() {
		for (int i = 0; i < len; i++)
			cout << values[i] << " ";
		cout << endl;
	}

};
int main() {
	Queue q;
	q.add_end(10);
	q.add_end(20);
	q.add_end(30);
	q.print();

	q.add_front(1);
	q.add_front(4);
	q.print();

	cout << q.remove_front();

	return 0;
}