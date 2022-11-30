import java.util.ArrayList;
import java.util.List;

public class NumbersClass {
	public static void main(String[] args) {

		NumberSolution ns=new NumberSolution();
		//ns.balancedNumber("1234123");
		ns.numberOfPaths(3,3);
	}

}
class NumberSolution{
	int findDigit(int num) {
		int digit;int total=0;
		while(num>0) {
			digit=num%10;
			total+=digit;
			num=num/10;
		}

		return total;
	}
	Boolean balancedNumber(String s)
	{
		int Leftsum = 0;
		int Rightsum = 0;


		for(int i = 0; i < s.length() / 2; i++)
		{
			Leftsum += (int)(s.charAt(i) - '0');
			Rightsum += (int)(s.charAt(
					s.length() - 1 - i) - '0');
		}

		if (Leftsum == Rightsum){
			return true;
		}

		else{
			return false; 
		}

	}
	public static int counter = 2;
	// not working
    static boolean isLucky(int n)
    {
        if (counter > n)
            return true;
        if (n % counter == 0)
            return false;
        int next_position = n - (n / counter);
 
        counter++;
        return isLucky(next_position);
    }
    static long isPallindrome(long N){
    	StringBuilder sb=new StringBuilder();
    	while(N>0) {
    		int value=(int) (N%2);
    		sb.append(value);
    		N=N/2;
    	}
    	
    	String first=sb.toString();
    	String reverse=sb.reverse().toString();
    	if(reverse.equals(first)) {
    		return 1;
    	}
    	
		return 0;
    	
    
    }
    static int isPerfectNumber(Long N) {
    	Long total=0l; 
    	Long mid=N/2;
    	int i=1;
    	while(i<=mid) {
    		if(N%i==0) {
    			total+=i;
    		}
    		i++;
    		
    	}
    	if(N==total) {
    		return 1;
    	}
    	return 0;
		
       
    }
    long findFactorial(int num){
        if(num==1){
            return 1;
        }
        long total=1;
        for(int i=2;i<=num;i++){
            total*=i;
        }
        return total;
    }
    
    long numberOfPaths(int m, int n) {
        int numerator=m+n-2;
        int denomenator1=m-1;
        int denomenator2=n-1;
        long total=findFactorial(numerator);
        long total1=findFactorial(denomenator1);
        long total2=findFactorial(denomenator2);
      long mainTotal=total/(total1*total2);
      System.out.println(mainTotal);
      return mainTotal;
        
    }
}
