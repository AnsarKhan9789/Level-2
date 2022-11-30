
import java.util.Scanner;
import java.lang.*;
class MiddlePattern
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter the num");
        int t=sc.nextInt();
        while(t>0)
        {
            String s=sc.next();
            GfG g=new GfG();
            g.printPattern(s);
            System.out.println();
            t--;
        }
    }
}


// } Driver Code Ends


class GfG
{
/*method prints the given pattern in a single line */
	void printPattern(String s)
	{
	    int len=s.length();
	    int middle=len/2;
	    String newString=s.charAt(middle)+"$";
	    System.out.print(newString);
	    for(int i=0;i<len-1;i++) {
	    	middle+=1;
	    	if(middle==len) {
	    		middle=0;
	    	}
	    	newString=newString.substring(0,newString.length()-1)+s.charAt(middle)+newString.substring(newString.length()-1);
	    	System.out.print(" "+newString);
	    	
	    }
	    
	    
    }
}
