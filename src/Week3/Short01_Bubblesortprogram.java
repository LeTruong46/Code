package Week3;
import java.util.Random;
import java.util.Scanner;

public class Short01_Bubblesortprogram {
    private int[] array;

    public Short01_Bubblesortprogram(int n) {
        this.array = new int[n];
    }
    
    void addValues() {
        Random rd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt(100) + 1; 
        }
    }
    
    void showArray() {
        System.out.print("Array: { ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println("}");
    }
    
    void bubbleSort() {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; 
        }
    }
}
