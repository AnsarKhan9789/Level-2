import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondPdf {
	public static void main(String args[])  {

		String string1 = "practice";
		String string2 = "cat";

		Solution1 ob = new Solution1();
		// System.out.println(ob.modify(string1) );
		//System.out.println(ob.romanToInt("MCMXCIV"));
		//System.out.println(ob.firstAlphabet("bad is good"));
		//System.out.println(ob.encryptString("aaaabc"));
		//System.out.println(ob.checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
		//System.out.println(ob.isValid("){"));
		//System.out.println(ob.areIsomorphic("aab", "xyy"));
		//System.out.println(ob.isRotated("amazon", "onamaz"));
		//System.out.println(ob.checkInclusion("ab", "eidbaooo"));
		//System.out.println(ob.isValidIp("a.b.c.d"));
		//System.out.println(ob.lps("madma"));
		//System.out.println(ob.areKAnagrams("qufefzniwrhar", "lzvnmuhlexhec", 7));
		//System.out.println(ob.longestUniqueSubsttr("geeksforgeeks"));
		System.out.println(ob.countAndSay(4));

	}
}



// } Driver Code Ends


//User function Template for Java
class Solution1{
	static String removeChars(String string1, String string2){
		for(int i=0;i<string2.length();i++) {
			String alter=String.valueOf(string2.charAt(i));
			string1=string1.replaceAll(alter, "");
		}
		return string1;

	}
	String modify (String s)
	{
		StringBuilder sb =new StringBuilder();
		StringBuilder vowels =new StringBuilder();
		List<Integer> index =new ArrayList<Integer>();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u') {
				vowels.append(s.charAt(i));
				index.add(i);
			}
			else {
				sb.append(s.charAt(i));
			}

		}
		vowels.reverse();
		for(int i=0;i<vowels.length();i++) {
			char character=vowels.charAt(i);
			int pos=index.get(i);
			sb.insert(pos, character);
		}
		return sb.toString();
	}
	public int romanToInt(String s) {

		Map<Character,Integer> roman=new HashMap<Character,Integer>();
		roman.put('I', 1);
		roman.put('V', 5);
		roman.put('X', 10);
		roman.put('L', 50);
		roman.put('C', 100);
		roman.put('D', 500);
		roman.put('M', 1000);
		List<Integer> romanConvert=new ArrayList<Integer>();
		int total=0;
		for(int i=0;i<s.length();i++) {

			if(i<s.length()-1) {
				int first=roman.get(s.charAt(i));
				int second=roman.get(s.charAt(i+1));
				if(first<second) {
					int arr=second-first;
					romanConvert.add(arr);
					i=i+1;
				}
				else {
					romanConvert.add(first);
				}
			}
			else {
				int first=roman.get(s.charAt(i));


				romanConvert.add(first);

			}

		}
		for(int i=0;i<romanConvert.size();i++) {
			total=total+romanConvert.get(i);
		}



		return total;

	}
	String firstAlphabet(String S) {
		String[] arr=S.split(" ");
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<arr.length;i++) {
			char var=arr[i].charAt(0);
			sb.append(var);


		}
		return sb.toString();

	}
	String encryptString(String S){
		char string[] = S.toCharArray();  
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

				finalOutput=hex + sa+finalOutput;

			}

		}

		return finalOutput;
		// code here
	}
	public boolean checkIfPangram(String sentence) {
		int len=sentence.length();
		if(len<26) {
			return false;
		}
		else {
			HashSet<Character> set=new HashSet<Character>();  
			for(int i=0;i<len;i++) {
				set.add(sentence.charAt(i));
			}
			if(set.size()==26) {
				return true;
			}
		}

		return false;
	}
	public boolean isValid(String s) {
		List<Character> newList=new ArrayList<Character>();
		if(s.length()%2!=0) {
			return false;
		}
		for(int i=0;i<s.length();i++) {
			char temp=s.charAt(i);
			if(temp=='{'||temp=='['||temp=='(') {
				newList.add(temp);
			}
			else if(temp=='}'||temp==']'||temp==')') {
				if(newList.size()==0) {
					return false;
				}
				else {
					int index=newList.size()-1;
					char val=newList.get(index);
					switch(val) {
					case '{':
						if(temp=='}') {
							newList.remove(index);
						}
						else {
							return false;
						}
						break;
					case '[':
						if(temp==']') {
							newList.remove(index);
						}
						else {
							return false;
						}
						break;
					case '(':
						if(temp==')') {
							newList.remove(index);
						}
						else {
							return false;
						}
						break;
					}
				}

			}
		}
		if(newList.size()==0) {
			return true;
		}
		else {
			return false;
		}




	}

	public boolean areIsomorphic(String str1,String str2)
	{
		Map<Character,Character> isomorphic=new HashMap<Character,Character>();
		if(str1.length()!=str2.length()) {
			return false;
		}
		for(int i=0;i<str1.length();i++) {
			char first=str1.charAt(i);
			char last=str2.charAt(i);
			if(isomorphic.containsKey(first)) {
				if(isomorphic.get(first)!=last) {
					return false;
				}
			}
			else {
				if(isomorphic.containsValue(last)) {
					return false;
				}
				isomorphic.put(first, last);
			}
		}

		return true;


	}
	public  boolean isRotated(String str1, String str2)
	{
		String check=str1.substring(2)+str1.substring(0,2);
		String check2=str1.substring(str1.length()-2,str1.length())+str1.substring(0,str1.length()-2);
		if(str2.equals(check) || str2.equals(check2)) {
			return true;
		}
		return false;

	}
	public boolean checkInclusion(String s1, String s2) {
		if(s1.length()>s2.length()) {
			return false;
		}
		char[] temp=s1.toCharArray();
		Arrays.sort(temp);
		String check=String.valueOf(temp);
		int length=check.length();

		for(int i=0;i<s2.length()-length+1;i++) {

			String pos=s2.substring(i,i+length);
			char[] posArr=pos.toCharArray();
			Arrays.sort(posArr);
			pos=String.valueOf(posArr);
			if(check.equals(pos)) {
				return true;
			}

		}


		return false;

	}
	public boolean isValidIp(String s) {
		if(s.charAt(0)=='.'|| s.charAt(s.length()-1)=='.' ) {
			return false;
		}
		String[] arr=s.split("\\.");
		if(arr.length>=5|| arr.length<4 ) {
			return false;
		}
		for(String array:arr) {
			if(array.isEmpty()) {
				return false;
			}
			char[] chars = array.toCharArray();

			for(char c : chars){
				if(Character.isLetter(c)){
					return false;
				}
			}
			if(array.length()>1) { 
				if(array.charAt(0)=='0') {
					return false;
				}
			}


			int ipNum=Integer.parseInt(array);
			if((ipNum>255 || ipNum<0)) {
				return false;
			}

		}
		return true;

	}
	int lps(String s) {
		int i=0;
		int j=1;
		int len=s.length();
		while(j<len) {
			char first=s.charAt(i);
			char second=s.charAt(j);
			if(first==second) {
				j++;
				i++;
			}
			else {
				j=j-i+1;
				i=0;
				
			}
		}
		return i;

	}
	 boolean areKAnagrams(String s1, String s2, int k) {
		 int[] asciiValues=new int[26];
		 char[] Str1=s1.toCharArray();
		 char[] Str2=s2.toCharArray();
		 int count=0;
		 if(Str1.length!=Str2.length) {
			 return false;
		 }
		 for(int i=0;i<Str1.length;i++) {
			 asciiValues[Str1[i]-97]++;
		 }
		 for(int i=0;i<Str1.length;i++) {
			 if(asciiValues[Str2[i]-97]!=0) {
				 asciiValues[Str2[i]-97]--; 
			 }
			 else {
				 count++;
			 }
		 }
		 if(count<=k) {
			 return true;
		 }
		 
		return false;
		
	
		
	       
	    }
	 int longestUniqueSubsttr(String S){
		    String test = "";
		    

	        int maxLength = -1;
	 
	      
	        if (S.isEmpty()) {
	            return 0;
	        }
	      
	        else if (S.length() == 1) {
	            return 1;
	        }
	        for (char c : S.toCharArray()) {
	            String current = String.valueOf(c);
	            if (test.contains(current)) {
	            	int index=test.indexOf(current)+1;
	            	
	            	
	                test = test.substring(index);
	                System.out.println(test);
	            }
	           
	            
	            test = test + String.valueOf(c);
	        
	          
	            
	            if(maxLength<test.length()) {
	            	maxLength=test.length();
	            }
	           
	        }
	 
	        return maxLength;
	
	        
	    }
	 String countAndSay(int index) {
		 String first="1";
		 if(index==1) {
			 return first;
		 }
		
		 String input="11";
		 int count=1;
		 if(index==2) {
			 return input;
		 }
		 for(int i=2;i<index;i++) {
			 String temp="";
			
			 
			 for(int j=0;j<input.length();j++) {
				 if(j==input.length()-1) {
					 temp+=count+""+input.charAt(j);
				 }
				 
				 else if(input.charAt(j)==input.charAt(j+1)) {
					 count++;
				 }
				 else {
					 temp+=count+""+input.charAt(j);
					 count=0;
				 } 
			 }

			 input=temp;
			 
		 }
		 
		return input;
		 
	 }
	 
}























