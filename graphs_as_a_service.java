import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
import java.util.*;
public class Main 
{ 
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
  
    public static void main(String[] args) 
    { 
        FastReader sc=new FastReader(); 
		int t=sc.nextInt();
		for( int ll=1;ll<=t;ll++)
		{
			int n=sc.nextInt();
			int m=sc.nextInt();
			long graph[][]=new long[n][n];
			long graph1[][]=new long[n][n];
            long mod=1000000007;
            for (long[] row: graph)
            Arrays.fill(row, mod);
            for (long[] row: graph1)
            Arrays.fill(row, mod);
			
			ArrayList<Integer> a1=new ArrayList<>();
			ArrayList<Integer> a2=new ArrayList<>();
			ArrayList<Long> values=new ArrayList<>();
			for( int i=0;i<m;i++)
			{
				int x=sc.nextInt();
				int y=sc.nextInt();
				long val=sc.nextLong();
				x--;
				y--;
                graph[x][y]=val;
                graph[y][x]=val;
                graph1[x][y]=val;
                graph1[y][x]=val;
				a1.add(x);
				a2.add(y);
				values.add(val);
			}
			for( int k=0;k<n;k++)
			{
				for( int i=0;i<n;i++)
				{
					for( int j=0;j<n;j++)
					{
						if(graph[i][j]>=(graph[i][k]+graph[k][j]))
						{
							graph[i][j]=graph[i][k]+graph[k][j];
						}
					}
				}
            }
            /*for( int i=0;i<n;i++)
            {
                for( int j=0;j<n;j++)
                {
                    if(graph[i][j]==mod)
                    System.out.print(0+"  ");
                    else
                    System.out.print(graph[i][j]+" ");
                }
                System.out.println();
            }
            for( int i=0;i<n;i++)
            {
                for( int j=0;j<n;j++)
                {
                    if(graph1[i][j]==mod)
                    System.out.print(0+"  ");
                    else
                    System.out.print(graph1[i][j]+"  ");
                }
                System.out.println();
            }*/
            int f=0;
            
			for( int i=0;i<a1.size();i++)
			{
				if(graph1[a1.get(i)][a2.get(i)]!=graph[a1.get(i)][a2.get(i)])
				{
					f=1;
					break;
				}
			}
			if(f==0)
			{
                System.out.println("Case #"+ll+": "+a1.size());
				for( int i=0;i<m;i++)
				{

					System.out.println((a1.get(i)+1)+" "+(a2.get(i)+1)+" "+values.get(i));
				}
			}
			else
				System.out.println("Case #"+ll+": "+"Impossible");
		}
	}
}
