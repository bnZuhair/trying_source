/* my recursve function to ditermine the number of primes
*/
#include <iostream>
using namespace std;

bool is_divisible(const int& dividend, const int& divisor)
{
	if (dividend % divisor == 0)
		return true;

	return false;
}
bool is_prime(const int& n, const int& divisor = 3)
{
	if (n == 2)
		return true;
	else if (is_divisible(n, 2) || n <= 1)//to divide even numbers
		return false;
	else if (is_divisible(n, divisor))//to divide odd numbers
		return false;

	if (divisor > (int)sqrt(n))//to see if we passed the biggest facotor or not because the biggest factor is always sqrt(n)
		return true;

	return true * is_prime(n, divisor + 2);
}
int cont_primes(const int& start, const int& end)
{
	if (start > end)
		return 0;

	if (is_prime(start))
		return  1 + cont_primes(start + 1, end);

	return cont_primes(start + 1, end);
}


int main()
{
	cout << cont_primes(10, 20) << " \n";
	cout << cont_primes(10, 200) << " \n";
	cout << cont_primes(10, 5000000) << " \n";



	return 0;
}
