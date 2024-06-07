import java.util.Arrays;

public class insertionSort {
    public static void insertion(int[] A)
    {
    for(int j=2;j<A.length;j++)
        {
            int key=A[j];
            int i=j-1;
            while (i>0 && A[i]>key)
            {
                A[i+1]=A[i];
                i=i-1;
                A[i+1]=key;
            }
        }
    System.out.println(Arrays.toString(A));


    }

    public static boolean isSorted(int [] array)

    {

        for(int i=0;i<array.length;i++)
        {
            if(array[i]>array[i+1])
            {
                return false;
            }
        } return true;
    }


}
