
public class Pattern {

	public static void main(String[] args) {

		PatternSolution ps= new PatternSolution();
		//ps.pyramidPattern(6);
		//ps.diamond(6);
		//ps.zPattern(6);
		ps.fill0X(4, 4);
	}

}
class PatternSolution{
	void pyramidPattern(int row) {
		int i,j;

		for (i=0; i<row; i++)   
		{      
			for (j=row-i; j>1; j--)   
			{  
				//prints space between two stars  
				System.out.print(" ");   
			}   
			//inner loop for columns  
			for (j=0; j<=i; j++ )   
			{   
				//prints star      
				System.out.print("* ");   
			}   
			//throws the cursor in a new line after printing each line  
			System.out.println();   
		}
	}
	void rightAngle(int row) {
		int i,j;
		for(i=0;i<row;i++) {
			for(j=0;j<=i;j++) {
				System.out.print("*"); 
			}
			System.out.println();
		}
	}
	void leftAngle(int row) {
		int i,j;
		for(i=0;i<row;i++) {
			for(j=2*(row-i);j>1;j--) {
				System.out.print(" ");


			}
			for(j=0;j<=i;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}

	}
	void rightPascalTriangle(int row) {
		int i,j;
		for(i=0;i<row;i++) {
			for(j=0;j<row;j++) {
				System.out.print(" ");
			}
			for(j=0;j<i;j++) {
				System.out.print("* "); 
			}
			System.out.println();
		}
		for(i=row-1;i>0;i--) {
			for(j=0;j<row;j++) {
				System.out.print(" ");
			}
			for(j=i-1;j>0;j--) {
				System.out.print("* "); 
			}
			System.out.println();
		}
	}
	void sandGlass(int rows) {
		int i,j,k;

		for (i = 0 ; i <= rows - 1; i++ ) 
		{
			for (j = 0 ; j < i; j++ ) 
			{
				System.out.print(" ");
			}
			for(k = i; k <= rows - 1; k++) 
			{
				System.out.print("* ");
			}
			System.out.println();
		}

		for (i = rows - 1; i >= 0; i-- ) 
		{
			for (j = 0 ; j < i; j++ ) 
			{
				System.out.print(" ");
			}
			for(k = i; k <= rows - 1; k++) 
			{
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	void diamond(int rows) {
		int i,j;
		for( i=1;i<=rows;i++) {
			for(j=0;j<2*(rows-i);j++) {
				System.out.print(" ");
			}
			for(j=0;j<(2*i)-1;j++) {
				System.out.print("* ");
			}

			System.out.println();

		}
		for( i=rows-1;i>=0;i--) {
			for(j=0;j<2*(rows-i);j++) {
				System.out.print(" ");
			}
			for(j=0;j<2*i-1;j++) {
				System.out.print("* ");
			}

			System.out.println();

		}
	}
	void outerTriangle(int rows) {
		int i,j;
		for(i=1;i<=rows;i++) {
			for(j=i;j<rows;j++) {
				System.out.print(" ");
			}
			for(int k=1;k<=(2*i-1);k++) {
				if(k==1  || k==(2*i-1)|| i == rows)   
				{  
					System.out.print("*");  
				}  
				else   
				{  
					System.out.print(" ");  
				}  
			}  
			System.out.println(); 


		}

	}
	void outerDiamond(int rows) {
		int i,j;
		for(i=1;i<=rows;i++) {
			for(j=i;j<rows;j++) {
				System.out.print(" ");
			}
			for(int k=1;k<=(2*i-1);k++) {
				if(k==1  || k==(2*i-1))   
				{  
					System.out.print("*");  
				}  
				else   
				{  
					System.out.print(" ");  
				}  
			}  
			System.out.println(); 


		}
		for(i=rows-1;i>0;i--) {
			for(j=i;j<rows;j++) {
				System.out.print(" ");
			}
			for(int k=1;k<=(2*i-1);k++) {
				if(k==1  || k==(2*i-1))   
				{  
					System.out.print("*");  
				}  
				else   
				{  
					System.out.print(" ");  
				}  
			}  
			System.out.println(); 


		}

	}
	void numPyramid(int rows) {
		int i,j;
		for(i=1;i<=rows;i++) {
			for(j=i;j<rows;j++) {
				System.out.print(" ");
			}
			for(j=1;j<=i;j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	void numDiamond(int rows) {
		int i,j,k,l;
		for (i = 1 ; i <= rows; i++ ) 
		{
			for (j = i ; j <= rows-1; j++ ) 
			{
				System.out.print(" ");	
			}
			for (k = i ; k >= 1; k-- ) 
			{
				System.out.print(k);
			}
			for (l = 2 ; l <= i; l++) 
			{
				System.out.print(l);
			}
			System.out.println();
		}
		
		for (i = rows - 1 ; i > 0; i-- ) 
		{
			for (j = i ; j <= rows -1; j++ ) 
			{
				System.out.print(" ");
			}
			for (k = i ; k >= 1; k-- ) 
			{
				System.out.print(k);
			}
			for (l = 2 ; l <= i; l++) 
			{
				System.out.print(l);
			}
			System.out.println();
		}
	}
	void zPattern(int row) {
		int i,j;
		for(i=0;i<row;i++) {
			for(j=row-1;j>=0;j--) {
				if(i==j||i==0||i==row-1) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	 static void fill0X(int m, int n)
	 {
	     
	     int i, k = 0, l = 0;
	  
	     int r = m, c = n;
	  
	    
	     char a[][] = new char[m][n];
	  
	    
	     char x = 'X';
	  
	 
	     while (k < m && l < n)
	     {
	      
	         for (i = l; i < n; ++i) {
	        	  a[k][i] = x;
	         }
	           
	         k++;
	  
	   
	         for (i = k; i < m; ++i) {
	        	 a[i][n-1] = x;
	         }
	            
	         n--;
	  
	
	         if (k < m)
	         {
	             for (i = n-1; i >= l; --i) {
	            	 a[m-1][i] = x;
	             }
	                
	             m--;
	         }
	  
	         if (l < n)
	         {
	             for (i = m-1; i >= k; --i) {
	            	  a[i][l] = x;
	             }
	               
	             l++;
	         }
	  
	        
	         x = (x == '0')? 'X': '0';
	     }
	     for(int aa=0;aa<a.length;aa++) {
	    	 for(int b=0;b<a[0].length;b++) {
	    		 System.out.print(a[aa][b]);
	    	 }
	    	 System.out.println();
	     }
	  
	 }
}


