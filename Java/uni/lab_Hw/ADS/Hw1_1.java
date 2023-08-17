package ADS;

import java.security.SecureRandom;
import java.util.Vector;

public class Hw1_1 {
    public static void main(String[] args) {
        SecureRandom randomNums = new SecureRandom();
        Vector<Integer> list = new Vector<Integer>();

        for (int i = 0; i < 5; i++)
            list.add(randomNums.nextInt(11));
        System.out.printf("Capacity of the list: %d%nSize of the list: %d%nCurrent elements of the list: %s%n%n", list.capacity(), list.size(), list);


        for (int i = 0; i < 5; i++)
            list.add(randomNums.nextInt(11));
        System.out.printf("Capacity of the list: %d%nSize of the list: %d%nCurrent elements of the list: %s%n%n", list.capacity(), list.size(), list);


        for (int i = 0; i < 4; i++)
            list.remove(0);
        System.out.printf("Current elements after removeing 4 elements: %s%n%n", list);

        list.remove(3);
        list.add(2, randomNums.nextInt(11));

        System.out.printf("Capacity of the list: %d%nSize of the list: %d%nCurrent elements of the list: %s", list.capacity(), list.size(), list);
    }
}


