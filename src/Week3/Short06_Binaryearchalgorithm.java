package Week3;

import java.util.Random;

public class Short06_Binaryearchalgorithm {
    private int[] array;

    public Short06_Binaryearchalgorithm(int n) {
        this.array = new int[n];
    }
    
    public int[] getArray() {
        return array;
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

    
    int binarySearch(int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
