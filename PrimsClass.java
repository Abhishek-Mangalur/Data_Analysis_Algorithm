import java.util.Scanner;

public class PrimsClass
{
	static final int MAX = 20;
	static int n;
	static int cost[][] = new int[MAX][MAX];
	static Scanner sobj = new Scanner(System.in);

	public static void main(String[] args) 
	{
		ReadMatrix();
		Prims();
	}

	static void ReadMatrix()
	{
		System.out.print("Enter the number of nodes: ");
		n = sobj.nextInt();
		System.out.println("\nEnter the adjacency matrix:");
		for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
		{
			cost[i][j] = sobj.nextInt();
			if (cost[i][j] == 0)
				cost[i][j] = 999;
		}
	}

	static void Prims()
	{
		int visited[] = new int[10];
		int ne = 1, i, j, min, a = 0, b = 0, u = 0, v = 0;
		int mincost = 0;
		visited[1] = 1;
		while (ne < n)
		{
			for (i = 0,min = 999; i < n; i++)
				for (j = 0; j < n; j++)
					if (cost[i][j] < min)
						if (visited[i] != 0)
						{
							min = cost[i][j];
							a = u = i;
							b = v = j;
						}
						
			if (visited[u] == 0 || visited[v] == 0) 
			{
			    System.out.println("Edge" + ne++ + ":(" + a + "," + b + ")" + " cost:" + min);
				mincost += min;
				visited[b] = 1;
			}
			cost[a][b] = cost[b][a] = 999;
		}
		System.out.println("\nMinimun cost is: " + mincost);
	}
}
