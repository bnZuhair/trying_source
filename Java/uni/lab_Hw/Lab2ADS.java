package ADS;

import java.security.SecureRandom;
import java.util.Vector;

public class Lab2ADS{
    public static void main(String[] args) {
        SecureRandom randomNums = new SecureRandom();
        Vector<Integer> list = new Vector<Integer>();

        for (int i = 0; i < 5; i++)
            list.add(randomNums.nextInt(11));
        System.out.printf("Capacity of the list: %d%nSize of the list: %d%nCurrent elements of the list: %s%n%n", list.capacity(), list.size(), list);




        list.add(2, randomNums.nextInt(11));
        list.insertElementAt(randomNums.nextInt(11), 3);
        System.out.printf("The last element is: %s%nFirst element is: %s%nElement at 3 index: %s%n%n",
                list.lastElement(), list.firstElement(), list.elementAt(3));

        System.out.printf("Capacity of the list: %d%nSize of the list: %d%nCurrent elements of the list: %s", list.capacity(), list.size(), list);
    }

}


