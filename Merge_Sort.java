import java.util.*;

public class Merge_Sort 
{
    static int a[];

    public static void main(String[] args) 
    {
        int n, low = 0, high;
        long start, end, elapsed;

        System.out.print("Enter the no. of elements: ");
        Scanner sobj = new Scanner(System.in);
        n = sobj.nextInt();

        Random random = new Random();

        high = n - 1;
        a = new int[n];

        for (int i = 0; i < n; i++) 
            a[i] = random.nextInt(n);

        System.out.println("\nThe Random Generated Numbers are: ");
        for (int i = 0; i < n; i++)
        {
            System.out.print(a[i]);
            System.out.print(" ");
        }
            
        start = System.currentTimeMillis();
        mergesort(a, low, high, n);
        end = System.currentTimeMillis();

        elapsed = (end - start);
        System.out.println("\n\nThe Sorted Numbers are: ");
        for (int i = 0; i < n; i++) 
        {
            System.out.print(a[i]);
            System.out.print(" ");
        }
        System.out.println("\n\nThe total time elapsed in sorted is: " + elapsed + " Time in millisecond");
    }

    static void mergesort(int a[], int low, int high, int n)
    {
        int mid;

        if (low < high) 
        {
            mid = (low + high) / 2;
            mergesort(a, low, mid, n);
            mergesort(a, mid+1, high, n);
            merge(a, low, mid, high, n);
        }
    }

    static void merge(int a[], int low, int mid, int high, int n)
    {
        int h, i, j, k = 0;
        int b[] = new int[n];
        h = i = low;
        j = mid + 1;

        while (h <= mid && j <=high) 
        {
            if (a[h] <= a[j])
                b[i++] = a[h++];
                
            else
                b[i++] = a[j++];
        }

        if (h > mid)
            for (k = j; k <= high; k++)
                b[i++] = a[k];

        else 
            for (k = h; k <= mid; k++)
                b[i++] = a[k];

        for (k = low; k <= high; k++)
            a[k] = b[k];
    }
}