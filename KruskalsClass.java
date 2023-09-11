import java.util.Scanner;

public class KruskalsClass 
{

	static final int MAX = 20;
	static int n; 
	static int cost[ ][ ]; 
	static int parent[] = new int[9];    
	static Scanner sobj = new Scanner(System.in);

	public static void main(String[ ] args) 
	{
		ReadMatrix();    
		Kruskals();   
	}

	static void ReadMatrix() 
	{

		int i, j;
		cost = new int[MAX][MAX];    

		System.out.print("Enter the no. of vertices: ");
		n = sobj.nextInt();   

		System.out.println("\nEnter the cost adjacency matrix:");
		for (i = 1; i <= n; i++)  
		{
			for (j = 1; j <= n; j++) 
			{
				cost[i][j] = sobj.nextInt();   
				if (cost[i][j] == 0)       
					cost[i][j] = 999;    
			}
		}
	}

	static void Kruskals()
	{

		int a = 0, b = 0, u = 0, v = 0, i, j, ne = 1, min, mincost = 0;  
    
		System.out.println("\nThe edges of Minimum Cost Spanning Tree are:");
		while (ne < n) 
		{
			for (i = 1, min = 999; i <= n; i++)   
			{
				for (j = 1; j <= n; j++) 
				{
					if ((cost[i][j] < min))
					{
						min = cost[i][j];
						a = u = i;
						b = v = j;
					}
				}
			}
			u = find(u);    
			v = find(v);     
			
			if ((u != v) )   
			{
				
				uni(u, v);
				if(parent[u]==parent[v])  
					continue;    		
				System.out.println("u = "+parent[u]+"  v = "+parent[v]);
				System.out.println("Edge" +ne++ +" (" + a + "," + b + ") = " + min);
				System.out.println();
				mincost += min;
			}
			cost[a][b] = cost[b][a] = 999;   
		}
		System.out.println("\nMinimum cost: " + mincost);
	}

	static int find(int i)  
	{ 
		while (parent[i]!=0)
			i = parent[i];
		return i;
	}

	static void uni(int i, int j) 
	{
		parent[j] = i;
	}
}
