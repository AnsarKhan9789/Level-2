import java.io.*;
import java.util.*;
public class GFG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            ArrayList<String> arr=new ArrayList <String>();
           arr.add("ab");
           arr.add("bcd");
           arr.add("b");
           arr.add("a");
           System.out.println("Enter String");
                    String line = sc.next();
                    Sol obj = new Sol();  
                    System.out.println(Sol.wordBreak(line,arr));  
                    
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int wordBreak(String A, ArrayList<String> B )
    {
    	Collections.sort(B, Comparator.comparingInt(String::length).reversed());
    	for(int i=0;i<B.size();i++) {
    		
    		String newString=B.get(i);
    		if(A.contains(newString)) {
    			A=A.replaceAll(newString, "");
    		}
    		

    	}
    	
    	if(A.equals("")) {
    		return 1;
    	}
    	return 0;
    
        //code here
    }
}