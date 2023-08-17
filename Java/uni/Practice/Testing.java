import java.security.SecureRandom;
import java.util.Arrays;

public class Testing {
    public static void main (String[] args) throws InterruptedException {
        SecureRandom generator = new SecureRandom();
        int ar[] = generator.ints(15, 0, 21).toArray();
        System.out.printf("the array %s%n", Arrays.toString(ar));
        
        
        System.out.printf("the index of the number 6 in the array: %d%n", linearSearch(ar, 6)); 

        mergeSort(ar);
        System.out.printf("the array after sorting %s%n", Arrays.toString(ar));

        System.out.printf("the index of the number 6 in the array: %d%n", binarySearchUsinRecursion(ar, 6));
	}   
    public static int linearSearch(int ar[], int value) {
        for (int i = 0; i < ar.length; i++)
            if (value == ar[i])
                return i;

        return -1;
    }

    public static int binarySearch(int ar[], int value) {
        int high = ar.length - 1, low = 0, mid = (high + low) / 2;
        while (low <= high) {
            if(value == ar[mid])
                return mid;
            else if (value < ar[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return mid;
    }

    public static void insertionSort(int ar[]) {
        for (int i = 1; i < ar.length; i++) {
            int temp = ar[i];
            for (int j = i; j > 0 ; j--) {
                if (temp < ar[j - 1]){
                    ar[j] = ar[j - 1];
                    if (j == 1)
                        ar[j - 1] = temp;
                }

                else {
                    ar[j] = temp;
                    break;
                }
            }
        }
    }

    public static void selectionSort(int ar[]) {
        for (int startingIndex = 0; startingIndex < ar.length - 1; startingIndex++) {
            int minIndex = startingIndex;
            for (int i = startingIndex + 1; i < ar.length; i++) {
                if (ar[minIndex] > ar[i])
                    minIndex = i;
            }
            swap(ar, startingIndex, minIndex);
        }
    }

    public static void bubbleSort(int ar[]) {
        boolean isSwaped = true;
        for (int endingIndex = ar.length - 1; isSwaped; endingIndex--) {
            isSwaped = false;
            int counter = 0;
            while (counter < endingIndex) {
                if (ar[counter] > ar[counter + 1]) {
                    swap(ar, counter, counter + 1);
                    isSwaped = true;
                }
                counter++;
            }
        }
    }

    public static int binarySearchUsinRecursion(int ar[], int value) {
        return binarySearchUsinRecursion(ar, value, 0, (ar.length - 1));
    }
    public static int binarySearchUsinRecursion(int ar[], int value, int lowIndex, int highIndex) {
        if (lowIndex > highIndex)
            return -1;
        int mid = (lowIndex + highIndex) / 2;
        if (value == ar[mid])
            return mid;
        else if (value < ar[mid])
            return binarySearchUsinRecursion(ar, value, lowIndex, mid - 1);
        else
            return binarySearchUsinRecursion(ar, value, mid + 1, highIndex);
    }
    
    public static void quickSort(int ar[]) {
        quickSort(ar, 0, (ar.length - 1));
    }
    public static void quickSort(int ar[], int startingIndex, int endingIndex) {
        //base case
        if (endingIndex - startingIndex <= 0)
            return;

        //sorting using the pivot(the value of the bound (selected value))
        int pivotIndex = endingIndex;
        int swapingIndex = startingIndex - 1;
        for (int i = 0; i < endingIndex; i++) {
            if (ar[i] < ar[pivotIndex]) {
                swapingIndex++;
                swap(ar, swapingIndex, i);
            }
        }

        //swap the pivot to the middle of the values in which its right is bigger and its lefft is smaller
        swapingIndex++;
        swap(ar, pivotIndex, swapingIndex);
        pivotIndex = swapingIndex;

        //sort the right and left of the pivot
        quickSort(ar, startingIndex, pivotIndex - 1);
        quickSort(ar, pivotIndex + 1, endingIndex);

    }
    

    public static void mergeSort(int ar[]){
        int length = ar.length;

        if (length < 2)
            return;

        int mid =  length / 2;
        int leftAr[] = new int[mid];
        int rightAr[] = new int[length - mid];
        
        for (int i = 0; i < mid; i++) {
            leftAr[i] = ar[i];
        }
        for (int i = mid ; i < rightAr.length; i++) {
            rightAr[i - mid] = ar[i];
        }


        mergeSort(leftAr);
        mergeSort(rightAr);

        merge(ar, leftAr, rightAr);
    }
    public static void merge(int ar[], int leftAr[], int rightAr[]){
        int counter = 0,  rightCounter = 0, leftCounter = 0;

        while (rightCounter < rightAr.length && leftCounter < leftAr.length) {//adding values to the array tell either left array or right array become empty
            if(leftAr[leftCounter] <= rightAr[rightCounter]){
                ar[counter] = leftAr[leftCounter];
                leftCounter++;
            }
            else {
                ar[counter] = rightAr[rightCounter];
                rightCounter++;
            }
            counter++;
        }
        while (leftCounter < leftAr.length) {//if left is still not empty
            ar[counter] = leftAr[leftCounter];
            leftCounter++;
            counter++;
        }
        while (rightCounter < rightAr.length) {//if right is still not empty
            ar[counter] = rightAr[rightCounter];
            rightCounter++;
            counter++;
        }
    }
    // public static void bubbleSort(int ar[]) {
    //     boolean isSwaped = true;
    //     for (int j = ar.length - 1; isSwaped; j--) {
    //         isSwaped = false;
    //         for (int i = 0; i < j; i++)
    //             if (ar[i] > ar[i + 1]) {
    //                 isSwaped = true;
    //                 swap(ar, i, i + 1);
    //             }
    //     }
    // }
    // public static void selectionSort(int ar[]) {
    //     int minIndex;
    //     // boolean isSwaped = true;
    //     for (int j = 0; j < ar.length; j++) {
    //         minIndex = j;
    //         for (int i = j; i < ar.length; i++) {
    //             if (ar[minIndex] > ar[i])
    //                 minIndex = i;
    //         }
    //         swap(ar, minIndex, j);
    //     }
    // }
    // public static void insertionSort(int ar[]) {
    //     for (int i = 1; i < ar.length; i++) {
    //         int temp = i;
    //         for (int j = i - 1; j >= 0; j--) {
    //             if (ar[temp] < ar[j]) {
    //                 swap(ar, temp, j);
    //                 temp--;
    //             } else
    //                 break;
    //         }
    //     }
    // }
    
    public static void swap(int ar[], int ind1, int ind2) {
        int temp = ar[ind1];
        ar[ind1] = ar[ind2];
        ar[ind2] = temp;
    }
    
}