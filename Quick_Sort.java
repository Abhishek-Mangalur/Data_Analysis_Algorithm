import java.util.*;

public class Quick_Sort
{
	static int[] a;
	
    public static void main(String[] args)
	{
		Scanner sobj = new Scanner(System.in);
		System.out.print("Enter Max array size: ");
		int n = sobj.nextInt();
		a = new int[n];
		Random random = new Random();
		
        for (int i = 0; i < n; i++)
		    a[i] = random.nextInt(n);                               
		
		System.out.println("\nRandom Generated Numbers are:");
		for (int i = 0; i < n; i++)
		{
			System.out.print(a[i]);
			System.out.print(" ");
		}
		
		long startTime = System.currentTimeMillis();    
		QuickSortAlgorithm(0, n - 1);    
		long stopTime = System.currentTimeMillis();    
		
        long elapsedTime = stopTime - startTime;   
		System.out.println("\n\nSorted Numbers are:");
		
        for (int i = 0; i < n; i++)
		{
			System.out.print(a[i]);
			System.out.print(" ");
		}
	    System.out.println("\n\nTime Complexity in seconds for " + n + " elements is: " + (double) elapsedTime / 1000+" seconds");
	}

	public static void QuickSortAlgorithm(int p, int r)
	{
		int i, j, temp, pivot;
		
        if (p < r)
		{
			i = p;
			j = r + 1;
			pivot = a[p];
			
            while (true) 
			{
				i++;
				
                while (a[i] < pivot && i < r)
					i++;
				j--;
				
                while (a[j] > pivot)
					j--;
				
                    if (i < j) 
				{
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				} 
                else
					break;
			}
			
            a[p] = a[j];
			a[j] = pivot;
			QuickSortAlgorithm(p, j - 1);
			QuickSortAlgorithm(j + 1, r);
		}
	}
}
