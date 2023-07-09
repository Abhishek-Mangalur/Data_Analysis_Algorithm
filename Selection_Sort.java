import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Selection_Sort
{
	static final int MAX = 1000000;
	static int[] a = new int[MAX];
	
    public static void main(String[] args)
	{
		Scanner sobj = new Scanner(System.in);
		System.out.print("Enter Max array size: ");
		int n = sobj.nextInt();
		Random random = new Random();
		
		for(int p = 0; p < n; p++)
	        a[p] = random.nextInt(n); 

		System.out.println("\nInput Array:");
		for (int i = 0; i < n; i++)
        {
			System.out.print(a[i]);
            System.out.print(" ");
        }
		
		long startTime = System.currentTimeMillis();
		Selection_sort(a,0,n);
		long stopTime = System.currentTimeMillis();
		
		long elapsedTime = stopTime - startTime;
		System.out.println("\n\nSorted Array:");
		for (int i = 0; i < n; i++)
        {
			System.out.print(a[i]);
            System.out.print(" ");
        }
	    System.out.println("\n\nTime Complexity in seconds for " + n + " elements is: " + (double) elapsedTime/1000 );
	}
	
	public static void Selection_sort(int a[],int p,int r )
	{
	  	int min,temp;
		for(int i=p;i<=r-2;i++)
	  	{
	  		min=i;
	   		for(int j=i+1;j<=r-1;j++)
	   		{
	   			if(a[j]<a[min])
	   			min=j;
	   		}
	  		temp=a[min];
	  		a[min]=a[i];
	  		a[i]=temp;
	 	}
	}
}