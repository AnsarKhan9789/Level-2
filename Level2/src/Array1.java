import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Array1 {
	public static void main(String args[])  {
		Solution3 ob = new Solution3();
		int[] intArray = new int[]{ 1,2,3,7,5};

		//System.out.println(ob.findPeakElement(intArray));
//ob.common_digits(intArray);
		//System.out.println(ob.findSum(intArray, 3, 2));
		//ob.addLastIndex(intArray);
		//System.out.println(ob.getUniqueValue(intArray));
		//System.out.println(ob.get7up(intArray));
		//System.out.println(ob.getLocalMinima(intArray));
		ob.findSubArray(intArray, 6);
	}

}
class Solution3{
	int celebrity(int M[][], int n)
	{
		int celebrity=-1;
		int count=0;
		outer:
			for(int i=0;i<n;i++) {
				inner:
					for(int j=0;j<n;j++) {
						if(M[i][j]!=0) {
							count=0;
							break inner;
						}
						else {
							count++;
							if(count==n) {
								celebrity=i;
								count=0;
								break outer;
							}


						}
					}
			}
		if(celebrity==-1) {

			return -1;
		}
		for(int i=0;i<n;i++) {
			if( M[i][celebrity]==1) {
				count++;

			}




		}
		if(count==n-1) {
			return celebrity;
		}
		else {
			return -1;
		}


	}

	int remove_duplicate(int a[],int N){
		int j=0;
		for(int i=0;i<N-1;i++){
			if(a[i]!=a[i+1]){
				a[j]=a[i];
				j++;
			}
		}
		a[j]=a[N-1];
		return ++j;
	}
	// code here
	public int findExtra(int a[], int b[], int n) {
		for(int i=0;i<n-1;i++){
			if(a[i]!=b[i]){
				return i;
			}
		}
		return n-1;
	}
	String encode(String str)
	{
		char string[] = str.toCharArray();  
		String finalOutput="";
		for(int i = 0; i <string.length; i++) {   
			int count=1;
			for(int j = i+1; j <string.length; j++) { 
				if(string[i] != string[j]) {
					break;
				}
				else if(string[i]=='0') {
					break;
				}
				else if(string[i] == string[j]) {  
					count++;  
					string[j] = '0';  
				}  
			}
			if(count >= 1 && string[i] != '0')  {
				String hex=Integer.toHexString(count);

				char sa=string[i];

				finalOutput=finalOutput+hex + sa;

			}

		}

		return finalOutput;
	}
	long maxSubarraySum(int arr[], int n){
		int total=0;
		long maximumValue=Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			total+=arr[i];
			if(maximumValue<total) {
				maximumValue=total;
			}
			if(total<0) {
				total=0;
			}
		}

		return maximumValue;



	}
	public static int doUnion(int a[], int n, int b[], int m) 
	{
		Set<Integer> unionSet=new HashSet<>();
		for(Integer first:a) {
			unionSet.add(first);
		}
		for(Integer second:b) {
			unionSet.add(second);
		}
		return unionSet.size();


	}
	boolean hasArrayTwoCandidates(int arr[], int n, int x) {

		Arrays.sort(arr);
		int start=0;
		int last=arr.length-1;
		while(start<last) {
			if(arr[start]+arr[last]==x) {
				return true;
			}
			else if(arr[start]+arr[last]<x) {
				start++;
			}
			else {
				last--;
			}
		}
		return false;
	}
	public int jump(int[] nums) {
		int jumps=0;
		int index=0;
		int jumpPosition=0;
		for(int i=0;i<nums.length-1;i++) {
			jumpPosition=Math.max(jumpPosition, i+nums[i]);
			if(index==i) {
				jumps++;
				index=jumpPosition;
			}
		}
		return jumps;

	}
	public int findPeakElement(int[] nums) {
		if(nums.length==2){
			if(nums[0]>nums[1]){
				return 0;
			}
			else{
				return 1;
			}

		}
		if(nums.length==1){
			return 0;
		}
		for(int i=1;i<nums.length-1;i++) {

			if(nums[i]>nums[i-1]&&nums[i]>nums[i+1]) {

				return i;
			}
			else {
				if(i==nums.length-2) {
					if(nums[i]<nums[i+1]) {
						return i+1;
					}
				}
				continue;
			}
		}
		return 0;

	}
	public int searchInsert(int[] nums, int target) {
		 int insertIndex=nums.length;
			for(int i=0;i<nums.length;i++) {
				if(target==nums[i]) {
					return i;
				}
				if(target<nums[i]) {
					insertIndex=i;
					break;
				}
				



			}
			return insertIndex;

	}
	 public int[] common_digits(int[] nums)
	    {
		 List<Character> list=new ArrayList<>();
		
		for(int i=0;i<nums.length;i++) {
			String num=String.valueOf(nums[i]);
			for(int j=0;j<num.length();j++) {
				if(list.contains(num.charAt(j))){
					continue;
				}
				else {
					list.add(num.charAt(j));
					
				}
			}
			
			
		}
		
		 int[] newArr=new int[list.size()];
		 for(int i=0;i<list.size();i++) {
			 newArr[i]=list.get(i)-'0';
		 }
		 Arrays.sort(newArr);
		return newArr;
	       
	    }
	 public int findSum(int[] nums,int k,int n) {
		 Arrays.sort(nums);
		 int total=0;
		 
		int first= nums[k-1];
		int last=nums[nums.length-n];
		total=first+last;
		return total;
		 
	 }
	 public int[] addLastIndex(int[] nums) {
		 String digit="";
		 for(int i=0;i<nums.length;i++) {
			 digit+=nums[i];
		 }
		 int total=Integer.parseInt(digit);
		 total=total+1;
		 char[] totalVal=String.valueOf(total).toCharArray();
		 int[] digitArr=new int[totalVal.length];
		 for(int i=0;i<totalVal.length;i++) {
			 digitArr[i]=totalVal[i]-'0';
			 System.out.print(digitArr[i]);
		 }
		return digitArr;
		 
	 }
	 public int getUniqueValue(int[] arr) {
		 Set<Integer> list=new HashSet<>();
		 for(int i=0;i<arr.length;i++) {
			 if(list.contains(arr[i])) {
				 list.remove(arr[i]);
			 }
			 else {
				 list.add(arr[i]);
			 }
		 }
		 System.out.println(list);
		 return 0;
		
		 
	 }
	 public List get7up(int[] arr) {
		 List<Integer> list =new ArrayList<>();
		 list.add(arr[0]);
		 for(int i=1;i<arr.length;i++) {
			 if(arr[i-1]%7==0) {
				 list.add(arr[i]);
			 }
			 else {
				 continue;
			 }
		 }
		 System.out.println(list);
		return list;
		 
	 }
	 public List getLocalMinima(int[] arr) {
		 List<Integer> list =new ArrayList<>();
		 if(arr.length>2) {
			 if(arr[0]<arr[1]) {
				 list.add(arr[0]);
			 } 
		 }
		 for(int i=1;i<arr.length-1;i++) {
				if(arr[i]<arr[i-1]&&arr[i]<arr[i+1]) {

					list.add(arr[i]);
				}
				else {
					if(i==arr.length-2) {
						if(arr[i+1]<arr[i]) {
							list.add(arr[i+1]);
						}
					}
					continue;
				}
		 }
		 System.out.println(list);
		return list;
		 
	 }
	 public void findSubArray(int[] arr,int k) {
		 int i=0;
		 int j=0;
		 int len=arr.length;
		 int total=0;
		 
		 while(j<len+1) {
			 total+=arr[j];
			 j++;
			 if(total==k) {
				 System.out.println(i+1+" "+j );
				 return;
			 }
			 if(total>k) {
				 total=0;
				 i++;
				 j=i;
			 }
			 
		 }
		 System.out.println(i+1+" "+j );
	 }
	 

}
