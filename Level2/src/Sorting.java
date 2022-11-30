import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Sorting {
	public static void main(String args[])  {
		long[] intArray = new long[]{0, 1, 2, 3, 4, 5, 6, 7};
		SortingAns ans = new SortingAns();
	//ans.selectionSort(intArray);
		//ans.bubbleSort(intArray);
		//ans.bubbleSort(intArray);
		//ans.quickSort(intArray, 0, intArray.length-1);
		//ans.closestToZero(intArray, 3);
		//ans.toyCount(7,50,intArray);
		ans.bitonicGenerator(intArray, 8);
	}
}
class SortingAns{
	int[] selectionSort(int[] arr) {
		int len=arr.length;
		for(int i=0;i<len-1;i++) {
			for(int j=i+1;j<len;j++) {
				if(arr[j]<arr[i]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
				
			}
			
			
		}
		System.out.println(Arrays.toString(arr));
		return arr;
		
	}
	void bubbleSort(int[] arr) {
		int len=arr.length;
		for(int i=0;i<len;i++) {
			for(int j=0;j<len-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=arr[j];
					
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	void insertionSort(int[] arr) {
		int len=arr.length;
		for(int i=1;i<len;i++) {
			int key=arr[i];
			int j=i-1;
			while(j>=0 && arr[j]>key) {
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=key;
		}
	}
	   void merge(int arr[], int l, int m, int r)
	    {
	        // Find sizes of two subarrays to be merged
	        int n1 = m - l + 1;
	        int n2 = r - m;
	 
	        /* Create temp arrays */
	        int L[] = new int[n1];
	        int R[] = new int[n2];
	 
	        /*Copy data to temp arrays*/
	        for (int i = 0; i < n1; ++i)
	            L[i] = arr[l + i];
	        for (int j = 0; j < n2; ++j)
	            R[j] = arr[m + 1 + j];
	 
	        /* Merge the temp arrays */
	 
	        // Initial indexes of first and second subarrays
	        int i = 0, j = 0;
	 
	        // Initial index of merged subarray array
	        int k = l;
	        while (i < n1 && j < n2) {
	            if (L[i] <= R[j]) {
	                arr[k] = L[i];
	                i++;
	            }
	            else {
	                arr[k] = R[j];
	                j++;
	            }
	            k++;
	        }
	 
	        /* Copy remaining elements of L[] if any */
	        while (i < n1) {
	            arr[k] = L[i];
	            i++;
	            k++;
	        }
	 
	        /* Copy remaining elements of R[] if any */
	        while (j < n2) {
	            arr[k] = R[j];
	            j++;
	            k++;
	        }
	    }
	 
	    // Main function that sorts arr[l..r] using
	    // merge()
	    void sort(int arr[], int l, int r)
	    {
	        if (l < r) {
	           
	            int m = l + (r - l) / 2;
	            sort(arr, l, m);
	            sort(arr, m + 1, r);
	 
	            // Merge the sorted halves
	            merge(arr, l, m, r);
	        }
	    }
	     void swap(int[] arr, int i, int j)
	    {
	        int temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    }
	  
	    /* This function takes last element as pivot, places
	       the pivot element at its correct position in sorted
	       array, and places all smaller (smaller than pivot)
	       to left of pivot and all greater elements to right
	       of pivot */
	     int partition(int[] arr, int low, int high)
	    {
	  
	     
	        int pivot = arr[high];
	  
	        int i = (low - 1);
	  
	        for (int j = low; j <= high - 1; j++) {
	  
	           
	            if (arr[j] < pivot) {
	  
	              
	                i++;
	                swap(arr, i, j);
	            }
	        }
	        swap(arr, i + 1, high);
	        return (i + 1);
	    }
	  
	    /* The main function that implements QuickSort
	              arr[] --> Array to be sorted,
	              low --> Starting index,
	              high --> Ending index
	     */
	     void quickSort(int[] arr, int low, int high)
	    {
	        if (low < high) {
	  
	            // pi is partitioning index, arr[p]
	            // is now at right place
	            int pi = partition(arr, low, high);
	  
	            // Separately sort elements before
	            // partition and after partition
	            quickSort(arr, low, pi - 1);
	            quickSort(arr, pi + 1, high);
	        }
	    }
	     public static int kthSmallest(int[] arr, int l, int r, int k) 
	     {
	    	 Arrays.sort(arr);
	    	 
			return arr[k-1]; 
	      
	     } 
	     public static boolean isAnagram(String a,String b)
	     {
	    	 char[] aChar=a.toCharArray();
	    	 char[] bChar=b.toCharArray();
	    	 Arrays.sort(aChar);
	    	 Arrays.sort(bChar);
	    	 boolean flag=Arrays.equals(aChar, bChar);
			return flag;
	         
	         
	         
	     }
	     public static boolean check(long A[],long B[],int N)
	     {
	         Arrays.sort(A);
	         Arrays.sort(B);
	         return Arrays.equals(A, B);
	     }
	     boolean arraySortedOrNot(int[] arr, int n) {
	    	 for(int i=0;i<n-1;i++) {
	    		 if(arr[i+1]<arr[i]) {
	    			 return false;
	    		 }
	    		 else {
	    			 continue;
	    		 }
	    	 }
			return true;
	    	 
			
	         
	     }
	     public  int closestToZero (int arr[], int n)
	     {
	    	 Arrays.sort(arr);

	    	    int min = Integer.MAX_VALUE;
	    	    int total=0;
	    	    int i=0;
	    	    int j=n-1;
	    	    while(i<n-1) {
	    	    	
	    	    	 if (Math.abs(arr[j] + arr[i]) <= min)
		    	        {
		    	             
		    	        	total = arr[j] + arr[i];
		    	        	min=Math.abs(total);
		    	           
		    	        }
	    	    	 j--;
	    	    	 if(j==i) {
		    	    		i++;
		    	    		j=n-1;
		    	    	}
	    	    }
	    	    
	    	   return total;
	    	
	         
	          
	       }
	      int toyCount(int N, int K, int arr[])
	     {
	    	 Arrays.sort(arr);
	    	 int count=0;
	    	 for(int i=0;i<N;i++) {
	    		
	    		 if(K>arr[i]) {
	    			 K=K-arr[i];
	    			count++;
	    		 }
	    		 
	    	 }
			return count;
	     }
	      void bitonicGenerator(long arr[], int n)
	      {
	          List<Long> odd=new ArrayList<Long>();
	          List<Long> even=new ArrayList<Long>();
	          for(int i=0;i<n;i++) {
	        	  if(arr[i]%2==0) {
	        		  even.add(arr[i]);
	        	  }
	        	  else {
	        		  odd.add(arr[i]);
	        	  }
	          }
	          
	          Collections.sort(odd, Collections.reverseOrder());
	          Collections.sort(even);
	          int k=0;
	          for(int i=0;i<even.size();i++) {
	        	  arr[k]=even.get(i);
	        	  k++;
	          }
	          for(int i=0;i<odd.size();i++) {
	        	  arr[k]=odd.get(i);
	        	  k++;
	          }
	         System.out.println( Arrays.toString(arr));
	          
	      }
	      static ArrayList<Integer> candyStore(int candies[],int N,int K){
	    	  ArrayList<Integer> list=new ArrayList<Integer> ();
	    	  if(N==0) {
	    		  int min=findMin(candies,N,K);
	    		  list.add(min);
	    		  list.add(min);
	    	  }
	    	  else {
	    		  int min=findMin(candies,N,K);
	    		  int max=findMax(candies,N,K);
	    		  list.add(min);
	    		  list.add(max);
	    	  }
			return list;
	    	  
	      }
	      
	      static int findMin(int candies[],int N,int K) {
	    	  int temp=0;
	    	  int size=N;
	    	  for(int i=0;i<size;i++) {
	    		  temp+=candies[i];
	    		  size-=K;
	    	  }
	    	  return temp;
	      }
	      static int findMax(int candies[],int N,int K) {
	    	  int temp=0;
	    	  int size=0;
	    	  for(int i=N-1;i>=size;i--) {
	    		  temp+=candies[i];
	    		  size+=K;
	    	  }
	    	  return temp;
	      }
	      
	
}