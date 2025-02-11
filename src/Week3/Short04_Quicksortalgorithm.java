package Week3;

import java.util.Arrays;
import java.util.Random;

public class Short04_Quicksortalgorithm {
     private int[] array;

    public int[] getArray() {
        return array;
    }

    public Short04_Quicksortalgorithm(int n) {
        this.array = new int[n];
    }
    
    public void addValues() {
        Random rd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt(100) + 1; 
        }
    }
    
    public void showArray() {
        System.out.println(Arrays.toString(array));
    }
    
    public void quickSort(int []array, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(array,left, right);
            quickSort(array, left, partitionIndex - 1);
            quickSort(array, partitionIndex, right);
        }
    }
    
    public int partition(int []array,int left, int right){
        int pivot = array[left + (right - left) / 2];
        int i = left;
        int j = right;
        while(i <= j){
            while(array[i] < pivot) i++;
            while(array[j] > pivot) j--;
            if(i <= j){
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
