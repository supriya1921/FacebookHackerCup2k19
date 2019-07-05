import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;


import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
  
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
	public static int check(char a,int value_of_x)
	{
		if(a=='1')
			return 1;
		if(a=='0')
			return 0;
		if(a=='X')
			return (1-value_of_x);
		if(a=='x')
			return value_of_x;
		return -1;
	}
	public static char check_ans(int ans)
	{
		if(ans==0)
			return '0';
		if(ans==1)
			return '1';
		return 'a';
	}
    public static void main(String[] args) 
    { 
        FastReader sc=new FastReader(); 
        
		int t=sc.nextInt();
		for(int j=0;j<t;j++)
		{
			char s[]=sc.next().toCharArray();
			if(s.length==1)
			{
				if(s[0]=='1'||s[0]=='0')
				{
					System.out.println("Case #" + (j+1) + ": " + 0);
					continue;
				}
				else
				{
					System.out.println("Case #" + (j+1) + ": " + 1);
					continue;
				}
			}
			Stack<Character> stack1=new Stack<>();
			Stack<Character> stack2=new Stack<>();
			//for x=1
			int ans=0;
			for(int i=0;i<s.length;i++)
			{
				if(s[i]==')')
				{
					char a=stack1.pop();
					char b=stack1.pop();
					char c=stack1.pop();
					int a1,b1;
					a1=check(a,1);
					b1=check(c,1);
					if(b=='&')
						ans=a1&b1;
					else if(b=='|')
						ans=a1|b1;
					else if(b=='^')
						ans=a1^b1;
					stack1.pop();
					char ch=check_ans(ans);
					stack1.push(ch);
				}
					
				else if(s[i]=='(')
				{
					stack1.push(s[i]);
				}
				else
				{
					stack1.push(s[i]);
				}
			}
			int value1=0,value2=0;
      if(!stack1.isEmpty())
		value1=stack1.pop();
	//x=0
	for(int i=0;i<s.length;i++)
			{
				if(s[i]==')')
				{
					char a=stack2.pop();
					char b=stack2.pop();
					char c=stack2.pop();
					int a1,b1;
					a1=check(a,0);
					b1=check(c,0);
					if(b=='&')
						ans=a1&b1;
					else if(b=='|')
						ans=a1|b1;
					else if(b=='^')
						ans=a1^b1;
					stack2.pop();
					char ch=check_ans(ans);
					stack2.push(ch);
				}
					
				else if(s[i]=='(')
				{
					stack2.push(s[i]);
				}
				else
				{
					stack2.push(s[i]);
				}
			}
			if(!stack2.isEmpty())
			value2=stack2.pop();
			if(value1!=value2)
				System.out.println("Case #" + (j+1) + ": " + 1);
			else 
				System.out.println("Case #" + (j+1) + ": " + 0);
	          
        }
        
    } 
} 

