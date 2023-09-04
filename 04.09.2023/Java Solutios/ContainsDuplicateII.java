import java.util.*;

public class MoveAllZeroAtEnd {
    // Bruteforce
    public static void moveZeroAtEnd(int arr[], int n) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<n; i++) {
            if(arr[i] != 0) {
                list.add(arr[i]);
            }
        }

        // Pust into orginal array
        Arrays.fill(arr, 0);
        for(int i=0; i<list.size(); i++) {
            arr[i] = list.get(i);
        }

    }
    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void pushZerosToEnd(int[] arr, int n) {
        // find first zero index
        int zero = -1;

        for(int i=0; i<n; i++) {
            if(arr[i] == 0) {
                zero = i;
                break;
            }
        }

        if(zero == -1) {  // non zero array
            return;
        }

        // swap

        for(int i=zero+1; i<n; i++) {
            if(arr[i] != 0) {
                swap(arr, i, zero);
                zero++;
            }
        }

        /*
        int i=0;
        int j=0;
        for(int j=0; j<n; j++) {
            if(arr[j] != 0) {
                swap(arr[i],arr[j]);
                i++;
            }
        }
         */
    }

    

    public static void main(String[] args) {
        int Arr[] = {3, 5, 0, 0, 4};
        int n = Arr.length;

        // moveZeroAtEnd(Arr, n);

        pushZerosToEnd(Arr, n);


        for (int i : Arr) {
            System.out.print(i+" ");
        }
    }
}
