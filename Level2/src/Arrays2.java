import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Arrays2 {
	public static void main(String args[])  {
		Answer ans = new Answer();
		int[] intArray = new int[]{17 ,85, 23, 60};
		 Integer a[] = new Integer[] {1, 2, 5, 3, 8, 9 };
		 Integer b[] = new Integer[] { 1, 7, 5, 8, 8 };
		 List<Integer> list1=Arrays.asList(a);
		 List<Integer>list2=Arrays.asList(b);

//System.out.println(ans.findMinimum(intArray, 5));
		//ans.findMinimumPossiblity(intArray, 54);
		//ans.rotate(intArray);
		//ans.findTheDuplicate(intArray);
		//ans.findUnion();
		 //ans.findTheGreatSubSeq(intArray);
		 //System.out.println(ans.findTheDigit(15));
		 ans.sortByDigits(intArray);
		
	}

}
class Answer{
	int findMinimum(int[] intArray,int key) {
		Arrays.sort(intArray);
		int minimum=Integer.MAX_VALUE;
		for(int i=0;i<=intArray.length-key;i++) {
			int total=intArray[key+i-1]-intArray[i];
			if(minimum>total) {
				minimum=total;
			}
			
		}
	
		
		return minimum;
		
	}
	void findMinimumPossiblity(int[] intArray,int find) {
		int i=0;
		
		int len=intArray.length;
		int j=len-1;
		
		int minimum=Integer.MAX_VALUE;
		int[] arr=new int[2];
		
		while(i<len-1) {
			if(i==j) {
				i++;
				j=len-1;
			}
		int total=intArray[i]+intArray[j];
		int min=Math.abs(total-find);
		if(min<minimum) {
			minimum=min;
			arr[0]=intArray[i];
			arr[1]=intArray[j];
		}
		j--;
		}
		System.out.println(arr[0]+" "+arr[1]);
	}
	
	int[] rotate(int[] intArray) {
		
		int temp=intArray[intArray.length-1];
		for(int i=intArray.length-1;i>=1;i--) {
			intArray[i]=intArray[i-1];
		}
		intArray[0]=temp;
		for(int i=0;i<intArray.length;i++) {
			System.out.print(intArray[i]);
		}
		return intArray;
		
	}
	void findTheDuplicate(int[] intArray) {
		
		for(int i=0;i<intArray.length;i++) {
			int count=1;
			for(int j=i+1;j<intArray.length;j++) {
				
				 if(intArray[i]==intArray[j] && intArray[i]!=-1  ) {
					count++;
					intArray[j]=-1;
				}
				else {
					continue;
				}
			}
			if(intArray[i]!=-1) {
				System.out.println(intArray[i]+"-"+count);
			}
		
		}
	}
	void findUnion(List<Integer> list1,List<Integer> list2) {
		List<Integer> union=new ArrayList<>();
		List<Integer> excerpt=new ArrayList<>();
		List<Integer> intersect=new ArrayList<>();
		for(int i=0;i<list1.size();i++) {
			int first=list1.get(i);
			if(!union.contains(first)) {
				union.add(first);
			}
			if(first%2==0) {
				if(!excerpt.contains(first)) {
					excerpt.add(first);
				}
				
			}
			
				
			
		}
		for(int i=0;i<list2.size();i++) {
			int first=list2.get(i);
			if(!union.contains(first)) {
				union.add(first);
			}
			if(first%2!=0) {
				if(!excerpt.contains(first)) {
					excerpt.add(first);
				}
				
			}
			if(list1.contains(first)) {
				if(!intersect.contains(first)) {
					intersect.add(first);
				}
				
			}
		}
		System.out.println(union);
		System.out.println(excerpt);
		System.out.println(intersect);
		
		
	}
	//failed
	void findTheGreatSubSeq(int[] arr) {
		List<Integer> list=new ArrayList<>();
		List<Integer> list1=new ArrayList<>();
		list1.add(arr[0]);
		int i=0;
		int j=0;
		int len=arr.length;
		while(i<len-2) {
			if(j==len-2) {
				if((arr[j]<arr[j+1])) {
					list1.add(arr[j+1]);
				}
				list.addAll(list1);
				list1.clear();
				i++;
				j=i;
				list1.add(arr[j]);
			}
			else if(arr[j]<arr[j+1] ) {
				list1.add(arr[j+1]);
				j++;
				
				
			}
			else {
				list.addAll(list1);
				list1.clear();
				list1.add(arr[i]);
				j++;
				list1.add(arr[j]);
				
				
			}
			
			System.out.println(list1);
			
		}
	
	}
	//largest product
	boolean isEqualSubSet(int[] arr) {
		int mid=arr.length/2;
		int total1=0;
		int total2=0;
		for(int i=0;i<=mid;i++) {
			total1+=arr[i];
		}
		return false;
		
	}
	int getHighestProduct(int[] arr) {
		int n=arr.length;
		Arrays.sort(arr);
		int max1=arr[n-1]*arr[n-2]*arr[n-3];
		int max2=arr[0]*arr[1]*arr[n-1];
		return Math.max(max1, max2);
		
	}
	int findTheDigit(int n) {
		String total=String.valueOf(n);
		int returnValu=0;
		if(n<9) {
			int remain=10-n;
			total+=remain;
			returnValu=Integer.parseInt(total);
		}
		else {
			int temp2=sumTheDigit(n);
			int remain=10-temp2;
			total+=remain;
			returnValu=Integer.parseInt(total);
		}
		
		
		return returnValu;
		
	}
	int sumTheDigit(int n) {
		int temp=0,temp2=0;
		while(n>0) {
			temp=n%10;
			temp2+=temp;
			n=n/10;
			
		}
		return temp2;
	}
	List sortByDigits(int[] arr) {
		int len=arr.length;
		int sum=0;
		for(int i=0;i<len;i++) {
			int index=i;
			for(int j=i+1;j<len;j++) {
				sum=sumTheDigit(arr[i]);
				int sum2=sumTheDigit(arr[j]);
				if(sum2<sum){
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
					}
			}
		}
    for(int i=0;i<len;i++) {
    	System.out.println(arr[i]);
    }
			
		
		return null;
		
	}
	
	
}
