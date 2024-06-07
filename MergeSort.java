public class MergeSort {




    public static int[] Sort(int[] A ,int l, int r)
    {
         l=1;
         r=A.length;

        if(l<r)
        {
           int  m=(l+r)/2;
           if(l<m) {
               Sort(A, l, m);
           }
           if(m+1<r) {
               Sort(A, m + 1, r);
           }
            Merge(A,l,m,r);
        }
        return A;
    }
    public static int[] Merge(int[] A,int l ,int m, int r)
    {
        int n1=m-l+1;
        int n2=r-m;
        int[] L=new int[n1];
        int [] R=new int[n2];
        for(int i=1 ;i<=n1;i++)
        {
            L[i]=A[(l-1)+i];
        }
        for(int i=1 ;i<=n2;i++)
        {
            R[i]=A[m+1+i];

        }
        int i=1;
        int j=1;
        for(int k=l ;k<=r;k++)
        {
            if(L[i]<=R[j])
            {
                A[k]=L[i];
                i=i+1;
            }
            else
            {
               A[k]=R[j];
               j=j+1;
            }
        }
        return A;
    }
}
