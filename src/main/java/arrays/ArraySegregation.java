package arrays;

/**
 * Created by rajeevprasanna on 01/04/15.
 *
 * http://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 */
public class ArraySegregation {

    public static void main(String[] args){

        int[] a = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};

        int left = 0;
        int middle = 0;
        int right = a.length-1;

        while (middle <= right){
            switch (a[middle]){
                case 0: swap(a, left++, middle++);
                        break;
                case 1: middle++;
                        break;
                case 2:swap(a, middle, right--);
                        break;
            }
        }

        for(int i=0; i< a.length; i++){
            System.out.println(a[i]);
        }
        
    }

    static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
