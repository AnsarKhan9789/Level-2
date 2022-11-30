import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Matrix {

	public static void main(String[] args) {
		 int[][] scores = new int[2][4];
	       
	        scores[0][0] = 2; scores[0][1] = 1; scores[0][2] = 2;scores[0][3] = 1;
	       
	        scores[1][0] = 1;scores[1][1] = 2;scores[1][2] = 1;scores[1][3] = 2;
	       
	        
		MatrixAnswer matrix=new MatrixAnswer();
		//matrix.transpose(scores, 4);
		//matrix.rotate(scores);
		//matrix.diagnol(scores);
		matrix.rotationGame(scores, 2);

	}

}
class MatrixAnswer{
	 int sumOfMatrix(int N, int M, int[][] Grid) {
		
		 int total=0;
		 for(int i=0;i<N;i++) {
			 for(int j=0;j<M;j++) {
				 total+=Grid[i][j];
				 
			 }
		 }
		 
		return total;
	     
	    }
	   void rotate(int matrix[][]) 
	    {
	        int len=matrix.length;
	        for(int i=0;i<len;i++) {
		    	  for(int j=0;j<len;j++) {
		    		  System.out.print(matrix[i][j]);
		    	  }
		    	  System.out.println();
		      }
	        System.out.println();
	        for(int i=0;i<len/2;i++) {
	        	for(int j=i;j<len-1-i;j++) {
	        		int temp=matrix[i][j];
	        		matrix[i][j]=matrix[j][len-i-1];
	        		matrix[j][len-i-1]=matrix[len-i-1][len-j-1];
	        		matrix[len-i-1][len-j-1]=matrix[len-j-1][i];
	        		matrix[len-j-1][i]=temp;
	        	}
	        }
	      for(int i=0;i<len;i++) {
	    	  for(int j=0;j<len;j++) {
	    		  System.out.print(matrix[i][j]);
	    	  }
	    	  System.out.println();
	      }
	      
	    }
	   static void transpose(int matrix[][], int n)
	    {
		   for(int i=0;i<n;i++) {
		    	  for(int j=0;j<n;j++) {
		    		  System.out.print(matrix[i][j]);
		    	  }
		    	  System.out.println();
		      }
	       for(int i=0;i<n-1;i++) {
	    	   for(int j=i+1;j<n;j++) {
	    		   int temp=matrix[i][j];
	    		   matrix[i][j]= matrix[j][i];
	    		   matrix[j][i]=temp;
	    		  
	    	   }
	       }
	       for(int i=0;i<n;i++) {
		    	  for(int j=0;j<n;j++) {
		    		  System.out.print(matrix[i][j]);
		    	  }
		    	  System.out.println();
		      }
	    
	    }
	   
	   void convertToOne(int matrix[][]) {
		   
		   int len=matrix.length;
		   int index=-1;
		   int max=0;
		   for(int i=0;i<len;i++) {
			   int count=0;
			   for(int j=0;j<len;j++) {
				   if(matrix[i][j]==1) {
					   count++;
					   if(max<count) {
						   max=count;
						   index=i;
					   }
					   
					   
				   }
				   
			   }
		   }
		  
		   
	   }
public void changeColumn(int[][] matrix, int column) {
			for(int i=0;i<matrix.length;i++) {
				matrix[i][column]=0;
			}
	   }
	   public void changeRow(int[][] matrix, int row) {
		   for(int i=0;i<matrix[0].length;i++) {
			   matrix[row][i]=0;
		   }
	   }
	   public void setZeroes(int[][] matrix,int n,int m) {
	        boolean[][] zero=new boolean[n][m];
	        for(int i=0;i<n;i++) {
	        	for(int j=0;j<m;j++) {
	        		if(matrix[i][j]==0) {
	        			zero[i][j]=true;
	        		}
	        	}
	        }
	        for(int i=0;i<n;i++) {
	        	for(int j=0;j<m;j++) {
	        		if(zero[i][j]==true) {
	        			changeRow(matrix,i);
	        			changeColumn(matrix,j);
	        			
	        		}
	        	}
	        }
	    }
	   void diagnol(int[][] matrix ) {
		   int len=matrix.length;
		   int[] arr=new int[len];
		   for(int i=0;i<len;i++) {
			   arr[i]=matrix[i][i];
		   }
		   Arrays.sort(arr);
		   for(int i=0;i<len;i++) {
			  matrix[i][i]= arr[i];
		   }
		   
		   for(int i=0;i<len;i++) {
		    	  for(int j=0;j<len;j++) {
		    		  System.out.print(matrix[i][j]);
		    	  }
		    	  System.out.println();
		      }
	   }
	   public static ArrayList<ArrayList<Integer>> uniqueRow(int a[][],int r, int c)
	      {
	          Set<ArrayList<Integer>> set= new LinkedHashSet<>();
	          ArrayList<Integer>list;
	          for(int i=0;i<r;i++) {
	        	  list=new ArrayList<>();
	        	  for(int j=0;j<c;j++) {
	        		  list.add(a[i][j]); 
	        	  }
	        	  set.add(list);
	          }
	          return new ArrayList<ArrayList<Integer>>(set);
	          
	      }
	   void evenRotation(int a[][],int index) {
		   int len=a[0].length;
		   int temp=a[index][0];
		   for(int i=0;i<a[0].length-1;i++) {
			   a[index][i]=a[index][i+1];
			   
		   }
		   a[index][len-1]=temp;
	   }
	   void oddRotation(int a[][],int index) {
		   int len=a[0].length;
		   int temp=a[index][len-1];
		   for(int i=a[0].length-1;i>0;i--) {
			   a[index][i]=a[index][i-1];
			   
		   }
		   a[index][0]=temp;
	   }
	   public boolean rotationGame(int matrix[][],int x) {
		   int len=matrix.length;
		   int colLen=matrix[0].length;
		   for(int i=0;i<len;i++) {
		    	  for(int j=0;j<colLen;j++) {
		    		  System.out.print(matrix[i][j]);
		    	  }
		    	  System.out.println();
		      }
		   int[][] copy=new int [matrix.length][matrix[0].length];
		   for(int i=0;i<matrix.length;i++) {
			   for(int j=0;j<matrix[0].length;j++) {
				   copy[i][j]=matrix[i][j];
			   }
		   }
		   for(int i=0;i<x;i++) {
			   for(int j=0;j<matrix.length;j++) {
				   if(j%2==0) {
					   evenRotation(matrix,j);
				   }
				   else {
					   oddRotation(matrix,j) ;
				   }
			   }
		   }
		   for(int i=0;i<len;i++) {
		    	  for(int j=0;j<colLen;j++) {
		    		  System.out.print(matrix[i][j]);
		    	  }
		    	  System.out.println();
		      }
		   for(int i=0;i<len;i++) {
			   for(int j=0;j<colLen;j++) {
				   if(matrix[i][j]!=copy[i][j]) {
					   return false;
				   }
				   
			   }
		   }
		return true;
		   
	   }
}
