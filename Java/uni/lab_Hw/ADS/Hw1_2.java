package ADS;

import java.util.Scanner;
import java.util.Vector;

public class Hw1_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the number fo prime numbers to generate");
        int numOfPrimes = in.nextInt();

        Vector<Integer> primes = new Vector<Integer>(numOfPrimes);

        addPrimes(numOfPrimes, primes);

        for (int i = 0; i < numOfPrimes; i++) {
            if ( i != 0)
                System.out.print(", ");
            System.out.print(primes.get(i));
        }

    }

    private static void addPrimes(int numOfPrimes, Vector<Integer> primes) {
        int num = 2;
        while (primes.size() == numOfPrimes) {
            boolean isPrime = isPrime(num);
            if (isPrime)
                primes.add(num);
            num++;
        }
    }

    private static boolean isPrime(int num ) {
        if (num == 2)
            return true;
        else{
        int  maxLimit = (int) Math.sqrt(num);
        for (int i = 2; i < maxLimit; i++)
            if (num % i == 0) {
                return false;
            }
        return true;
        }
    }

}
