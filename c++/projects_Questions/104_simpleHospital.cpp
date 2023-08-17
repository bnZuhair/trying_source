/* project #1
*	small hospital system
*/
#include <iostream>
using namespace std;

const int MAX_PATIENTS = 5, SPECILAZATION = 20, MAX_INFO = 2;
string patientsInfo[SPECILAZATION + 1][MAX_PATIENTS + 1][MAX_INFO];
int patientsNum[SPECILAZATION + 1] = { 0 };

bool isFull(int& specilazation) {
	return patientsNum[specilazation] >= MAX_PATIENTS;
}

void shiftListR(int specilazation) {
	for (int i = 0, pos = patientsNum[specilazation]; i < patientsNum[i]; i++, pos--) {
		patientsInfo[specilazation][pos + 1][0] = patientsInfo[specilazation][pos][0];
		patientsInfo[specilazation][pos + 1][1] = patientsInfo[specilazation][pos][1];
	}
}

void saveInfo(int& specilazation, const  string& name, int& priority) {
	if (priority)
	{
		shiftListR(specilazation);
		patientsInfo[specilazation][0][0] = name;
		patientsInfo[specilazation][0][1] = "urgent";
	}
	else {

		patientsInfo[specilazation][patientsNum[specilazation]][0] = name;
		patientsInfo[specilazation][patientsNum[specilazation]][1] = "regular";
	}
}

void shiftListL(int specilazation) {
	for (int i = 0; i < patientsNum[specilazation]; i++) {
		patientsInfo[specilazation][i][0] = patientsInfo[specilazation][i + 1][0];
		patientsInfo[specilazation][i][1] = patientsInfo[specilazation][i + 1][1];

	}
}

void removeInfo(int specilazation) {
	patientsNum[specilazation]--;
	shiftListL(specilazation);
}

int menu() {
	cout << "please pick a choice: \n";
	cout << "1) add a patient \n";
	cout << "2) print all patients \n";
	cout << "3) Get next patients \n";
	cout << "4) Exit \n";

	int choice;
	cin >> choice;
	return choice;
}

void addPatient() {

	cout << "Enter specilazation, name, status\n";
	int specilazation, priority;
	string name;
	cin >> specilazation >> name >> priority;

	if (isFull(specilazation))
		cout << "sorry we can't \n";
	else {
		patientsNum[specilazation]++;
		saveInfo(specilazation, name, priority);
	}
}

void printPatient() {
	cout << "\n***************************************************\n";
	for (int i = 0; i < 21; i++) {
		if (patientsNum[i] > 0) {
			cout << "there are " << patientsNum[i] << " in specilazation " << i << "\n";
			for (int j = 0; j < MAX_PATIENTS; j++)
				cout << patientsInfo[i][j][0] << " " << patientsInfo[i][j][1] << endl;
		}
	}
}

void pickingPatient() {
	cout << "Enter specilazation: \n";
	int specilazation;
	cin >> specilazation;

	if (patientsNum[specilazation]) {
		cout << patientsInfo[specilazation][0][0] << " please go with Dr\n";
		removeInfo(specilazation);
	}
	else
		cout << "No patients at the moment\n";

}


int main()
{
	while (true)
	{
		int choice = menu();

		if (choice == 1)
			addPatient();
		else if (choice == 2)
			printPatient();
		else if (choice == 3)
			pickingPatient();
		else if (choice == 4)
			return 0;
		else
			cout << "Invalid choice \n";
	}
	return 0;
}
