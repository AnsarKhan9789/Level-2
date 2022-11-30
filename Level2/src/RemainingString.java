
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RemainingString {
	public static void main(String args[]) throws IOException {
		//		String s="qe";
		//		char ch='e';
		//		int count=1;

		Solution ob = new Solution();
		String str = "ansrdf xyz g";
				int k = 14;
	
		//Solution.printPermutn("abcd", "");
//		String s = "codeleet"; 
//		int[] indices = {4,5,6,7,0,2,1,3};
//		String result=ob.restoreString(s, indices);
//		String[] word1 = {"k", "e", "q","e", "d", "p" ,"e" ,"s", "x", "k", "d","k", "g", "d"};
//		String[] word2 = {"a", "bcd"};
//		System.out.println(ob.Anagrams(word1));
				System.out.println(ob.find_permutation("AB"));
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
	public static List<String> list1;
    public List<String> find_permutation(String S) {
    	list1=new ArrayList<String>();
        char[] arr=S.toCharArray();
        permutation(arr,0,arr.length);
        Collections.sort(list1);
        return list1;
    }
    public static void permutation(char[] str,int start,int end){
        if(start==end){
            String string=String.valueOf(str);
            if(!list.contains(string)){
            	list1.add(string);
            }
        }
        else{
            for(int i=start;i<end;i++){
                swap(str,i,start);
                permutation(str,start+1,end);
                swap(str,i,start);
            }
        }
    }
    public static void swap(char[] strArr,int first,int second){
        char temp=strArr[first];
        strArr[first]=strArr[second];
        strArr[second]=temp;
    }
	String printString(String S, char ch, int count) {

		for(int i=0;i<count;i++) {
			int index=S.indexOf(ch);
			if(index==-1) {
				S="Empty string";
				return S;

			}
			else {
				if(index<S.length()-1) {
					S=S.substring(index+1);
				}
				else {
					S="Empty string";
					return S;


				}
			}


			// code here

		}
		return S;

	}
	public int CountWays(String str)
	{
		int possibleWays=0;
		String position ="";
		int numbers=0;
		if(str.charAt(0)=='0') {
			return 0;
		}
		if(str=="") {
			return 1;
		}
		char[] ch = str.toCharArray();
		for(int i=0;i<ch.length-1;i++) {
			String firstLetter=String.valueOf(ch[i]);
	         int first=Integer.parseInt(firstLetter);
	         String secondLetter=String.valueOf(ch[i+1]+ch[i+2]);
	         int second=Integer.parseInt(secondLetter);
	         if(first==0||second==0) {
	        	 return 0;
	         }
	         else {
	        	 if(first<26) {
	        		 possibleWays+=1;
	        	 }
	        	 else if(second<26) {
	        		 possibleWays+=1;
	        	 }
	         }
	        
		
			
		

		}	




		return possibleWays;


	}
	 public String reverseWords(String S)
	    {
		 String reverseString;
		 boolean flag=true;
		 String[] result=S.split("\\.");
	
		 for(int i=0;i<result.length;i++) {
			 String reverse=result[i];
			 result[i]=reverseString(reverse);
			 
		 }
		 reverseString=String.join(".", result);
		 int inputLength=S.length();
		 while(flag)
	        {
	            if (S.charAt(inputLength-1) == '.')
	            {
	            	reverseString = reverseString + ".";
	                inputLength--;
	            }
	            else
	            {
	                flag = false;
	            }
	        }
		
		return reverseString;
	      
	    }
	 public String reverseString(String reverse) {
		 char ch;
		 String reversedString ="";
		 for (int i=0; i<reverse.length(); i++)
	      {
	        ch= reverse.charAt(i);
	        reversedString= ch+reversedString; 
	      }
		return reversedString;
		 
	 }
	 
	 String reverseWithSpacesIntact(String S)
	    {
		
		 StringBuilder sb =new StringBuilder();
		 List<Integer> index =new ArrayList<Integer>();
		 int i=0;
		 while(i<S.length()) {
			 if(S.charAt(i)!=' ') {
				 sb.append(S.charAt(i));
				 
			 }
			 else {
				 index.add(i);
			 }
			 i++;
		 }
		 sb.reverse();
		 for(int j=0;j<index.size();j++) {
			 int pos=index.get(j);
			 sb.insert(pos, " ");
			
		 }
		 return sb.toString();
	      
	    }
	 
	 
	 static String crossPattern(String S){
		
		 int length=S.length();
	       StringBuilder sBuilder=new StringBuilder();
	       for(int i=0;i<length;i++){
	           int mid=length-1-i;
	           for(int j=0;j<length;j++){
	               if(i==j||j==mid){
	                   sBuilder.append(S.charAt(j));
	               }
	               else{
	                   sBuilder.append(" ");
	               }
	           }
	       }
	       return sBuilder.toString();
	 }
	 boolean kPangram(String str, int k) 
	    {
		  HashSet<Character> set=new HashSet<Character>();  
		 String newStr=str.replaceAll(" ", "");
		
		 if(newStr.length()>=26) {
			 if(newStr.length()==k) {
				 return true;
			 }
			 for(int i=0;i<newStr.length();i++) {
				 char newChar=newStr.charAt(i);
				 set.add(newChar);
				 
			 }
			 int setLength=set.size();
			 int len=26-setLength;
			 if(setLength==26) {
				 return true;
			 }
			 else {
				 if(k>=len) {
					 return true;
				 }
				 else {
					 return false; 
				 }
			 }
		 }
		 else {
			 return false;
		 }

	    }
	 public int maxChars(String s)
	    {
		 int maxInt=-1;
		 for(int i=0;i<s.length();i++) 
		 {
			
			 char character=s.charAt(i);
			 int firstIndex=s.indexOf(character);
			 int lastIndex=s.lastIndexOf(character);
			 if(firstIndex!=lastIndex) {
				 int len=lastIndex-firstIndex-1;
				 if(maxInt<=len) {
					 maxInt=len;
				 }
				 
			 }
			 
		 }
			return maxInt;
	       
	    }
	 public static List list=new ArrayList();
	  static void printPermutn(String str, String ans)
	    {
		  	 
	        // If string is empty
	        if (str.length() == 0) {
	         list.add(ans);
	       
	            return;
	        }
	 
	        for (int i = 0; i < str.length(); i++) {
	 
	            // ith character of str
	            char ch = str.charAt(i);
	 
	            // Rest of the string after excluding
	            // the ith character
	            String ros = str.substring(0, i) +
	                        str.substring(i + 1);
	 
	            // Recursive call
	            printPermutn(ros, ans + ch);
	        }
	    }
	  
	  //convert array index to new String
	  public String restoreString(String s, int[] indices) {
		  
		  char[] newString =new char[s.length()];
		  for(int i=0;i<s.length();i++) {
			  int index=indices[i];
			  char tempChar=s.charAt(i);
			  newString[index]=tempChar;
		  }
		  s=String.valueOf(newString);
		return s;
	        
	    }
	  public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		  
		  String result = String.join("", word1);
		  String result2=String.join("", word2);
		  if(result.equals(result2)) {
			  return true;
		  }
		return false;
	        
	    }
	  public List<List<String>> Anagrams(String[] string_list) {
		  List<List<String>> anangram= new ArrayList<List<String>>();
		  String[] newList=new String[string_list.length];
		  
		  for(int i=0;i<newList.length;i++) {
			  char[] reg=string_list[i].toCharArray();
			  Arrays.sort(reg);
			  newList[i]=String.valueOf(reg);
	  }
		  for(int i=0;i<newList.length;i++) {
			 String newStr= newList[i];
			 List<String> matching=new ArrayList<String>();
			 boolean flag=true;
			 boolean noMatch=true;
			 for(int j=0;j<newList.length;j++) {
				 String again=newList[j];
				
				 
				 if(!again.isEmpty()&& !newStr.isEmpty()) {
				
					 if(newStr.equals(again)) {
						 if(string_list[j].equals(string_list[i])) {
							 matching.add(string_list[i]);
							 newList[j]="";
							 flag=false;
							 noMatch=false;
							
							
						 }	
						 else {
							 matching.add(string_list[j]);
							 newList[j]="";
							 flag=false;
							
						 }
						
						
					 }
				 }
			 }
			 if(flag==false) {
				
					 anangram.add(matching);
				 
				
			 }
			 
			
		  }

		  
		  
		return anangram;
		
	      
	    }
}
