package by.krukouski.sorting;

/**
 * Created by Krukouski Andrei on 15.09.2015.
 */
public class Runner {
    public static void main(String[] arg){

        int [] arr = {3, 2, 5, 2, 8, 9, 1, 0, 0, 0, 13};
        Sort.margeSort(arr, 0, arr.length);
        for(int c: arr){
            System.out.print(c + " ");
        }
    }
}
