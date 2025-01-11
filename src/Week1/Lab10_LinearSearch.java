package Week1;

import java.util.Random;

public class Lab10_LinearSearch {
    private int[] array;

    public Lab10_LinearSearch(int n) {
        this.array = new int[n];
    }
    
    void addValue(){
        //Tạo giá trị cho mỗi phần tử của array
        Random rd = new Random();
        for(int i = 0; i < array.length; i++){
            array[i] = rd.nextInt(10) + 1;
        }
    }
    
    void showArray(){
        // In ra các phần tử của array
        System.out.print("Array:{");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("}");
    }
    
    int searchValue(int value){
        for(int i = 0; i < array.length; i++){
            if(array[i] == value) return i;
        }
        return -1;
    }
}
