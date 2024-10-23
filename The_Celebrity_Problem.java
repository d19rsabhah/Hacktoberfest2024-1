
import java.io.*;
import java.util.*; 

class The_Celebrity_Problem{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	Stack<Integer> matrix = new Stack<>();
    	for(int i = 0; i < n; i++)
    	{
    	    matrix.push(i);
    	}
    	while(matrix.size() >= 2)
    	{
    	    int i = matrix.pop();
    	    int j = matrix.pop();
    	    if(M[i][j] == 1)
    	    {
    	        matrix.push(j);
    	    }
    	    else
    	    {
    	        matrix.push(i);
    	    }
    	}
    	int x = matrix.pop();
    	for(int i = 0; i < n; i++)
    	{
    	    if(i != x)
    	    {
    	        if(M[i][x] == 0 || M[x][i] == 1)
    	        {
    	            return -1;
    	        }
    	    }
    	}
    	return x;
    }
}
