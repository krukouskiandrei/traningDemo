package by.krukouski.sorting;

/**
 * Created by Krukouski Andrei on 14.09.2015.
 */
public class Sort {
    public Sort(){

    }

    public static void hybridSort(int[] arr){
        if(arr.length<310){
            insertSort(arr);
        }
        else{
            quickSort(arr, 0, arr.length-1);
        }
    }

    public static void insertSort(int[] arr){

        for(int i=0; i<arr.length; i++){
            int x = arr[i];
            int flac = i;
            for(int j=i-1; j>=0; j--){
                if(x>arr[j]){
                    break;
                }
                int temp = arr[j];
                arr[j] = x;
                arr[flac] = temp;
                flac--;


            }


        }

    }

    public static void margeSort(int[] arr, int left, int rigth){
        int flac = 1;
        for (int i = 0; i<(rigth-left-1)/2; i++){
            for(int j = 0; j<rigth;){
                if(j+flac>=rigth){
                    break;
                }
                if(rigth-j-flac < flac){
                    margeArray(arr, j, j+flac, flac, rigth-j-flac);
                    break;
                }

                margeArray(arr, j, j+flac, flac, flac);
                j+=flac*2;
            }
            flac*=2;
        }


    }

    private static void margeArray(int[] arr, int start1, int start2, int lengh1, int lengh2){
        int [] A = (int[])arr.clone();
        int flac1 = start1;
        int flac2 = start2;
        for(int i = start1; i<(start1+lengh1+lengh2); i++){

            if (flac1>=start1+lengh1){
                arr[i] = A[flac2];
                flac2++;
                continue;
            }

            if (flac2>=start2+lengh2){
                arr[i] = A[flac1];
                flac1++;
                continue;
            }

            if(A[flac1] <= A[flac2]){
                arr[i] = A[flac1];
                flac1++;
                continue;
            }
            if (A[flac1] > A[flac2]){
                arr[i] = A[flac2];
                flac2++;
                continue;
            }



        }

    }


    public static void  quickSort(int[] arr, int left, int right){

        int flac = findq(arr, left, right );
        if(left<flac-1){
            quickSort(arr, left, flac-1);
        }
        if(flac<right){
            quickSort(arr, flac, right);
        }

    }

    private static int findq(int[] arr, int left, int right) {

        int i =left, j =right;
        int tmp;
        int p = arr[left + (int)Math.random()*((right-left)+1)];
        while (i<=j){

            while (arr[i] < p){ i++;}
            while (arr[j] > p){j--;}
            if(i<=j){
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        };
        return i;
    }
}
