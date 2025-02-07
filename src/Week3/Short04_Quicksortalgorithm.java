package Week3;

import java.util.Random;

public class Short04_Quicksortalgorithm {
    private int[] array;

    public Short04_Quicksortalgorithm(int n) {
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
    
    void quickSort(int left, int right) {
        if (left < right) {
            int pivotIndex = partition(left, right);
            quickSort(left, pivotIndex - 1);
            quickSort(pivotIndex + 1, right);
        }
    }
    
    int partition(int left, int right) {
        int pivot = array[left + (right - left) / 2];
        int i = left, j = right;
        while (i <= j) {
            while (array[i] < pivot) i++;
            while (array[j] > pivot) j--;
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        return i;
    }
}