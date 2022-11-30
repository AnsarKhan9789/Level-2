import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThirdPdf {
	public static void main(String args[])  {
		Solution2 ob = new Solution2();
		//ob.convertToString(1911);
		//System.out.println(ob.isRotated("amazon", "onamaz"));
		//String s="he did good deed nair malayalam ma";
		//char[] palindrome=s.toCharArray();
		//ob.isPalindrome(palindrome);
		//ob.isSubString("abcddefgikom", "abdcdeffgklm");
		System.out.println(ob.isNonRepeated("character"));
	}

	
}
class Solution2{
	void convertToString(int num) {
		
		char[] numValues=String.valueOf(num).toCharArray();
		Map<Character,String>ones = new HashMap<Character,String>();
		ones.put('0', "zero");
		ones.put('1', "One");
		ones.put('2', "Two");
		ones.put('3', "Three");
		ones.put('4', "Four");
		ones.put('5', "Five");
		ones.put('6', "Six");
		ones.put('7', "Seven");
		ones.put('8', "Eight");
		ones.put('9', "Nine");
		Map<String,String>twos = new HashMap<String,String>();
		twos.put("10", "Ten");
		twos.put("11", "Eleven");
		twos.put("12", "Twelve");
		twos.put("13", "Thirteen");
		twos.put("14", "Fourteen");
		twos.put("15", "Fifteen");
		twos.put("16", "Sixteen");
		twos.put("17", "Seventeen");
		twos.put("18", "Eighteen");
		twos.put("19", "Nineteen");
		Map<Character,String>threes = new HashMap<Character,String>();
		threes.put('2', "Twenty");
		threes.put('3', "Thirty");
		threes.put('4', "Forty");
		threes.put('5', "Fifty");
		threes.put('6', "Sixty");
		threes.put('7', "Seventy");
		threes.put('8', "Eighty");
		threes.put('9', "Ninty");
		int len=numValues.length;
		String changes="";
		StringBuilder actualValue= new StringBuilder();
		boolean flag=false;
		
		if(len==1) {
			actualValue.append(ones.get(numValues[0]));
			System.out.println(actualValue);
			return;
		}
		if(len>4 || len<=0) {
			System.out.println("invalid");
			return;
		}
		for(int i=0;i<len;i++) {
			char check=numValues[i];
			
			if(len==4 ) {
				switch(i) {
				case 0:
					if(check!='0') {
						actualValue.append(ones.get(check));
						actualValue.append(" ");
						actualValue.append("Thousand");
						actualValue.append(" ");
						
					}
					break;
				case 1:
					if(check!='0') {
						actualValue.append(ones.get(check));
						actualValue.append(" ");
						actualValue.append("Hundred");
						actualValue.append(" ");
						actualValue.append("and");
						actualValue.append(" ");
						
					}
					break;
				case 2:
					if(check!='0') {
						if(check=='1') {
							 changes+=check;
							 flag=true;
						}
						else {
							actualValue.append(threes.get(check));
							actualValue.append(" ");
						}
					}
					break;
				case 3:
					if(flag==true) {
						changes+=check;
						actualValue.append(twos.get(changes));
					}
					else {
						if(check!='0') {
							actualValue.append(ones.get(check));
						}
						
					}
					break;
				}
			}
			else {
				if(len==3) {
					switch(i) {
					
					case 0:
						if(check!='0') {
							actualValue.append(ones.get(check));
							actualValue.append(" ");
							actualValue.append("Hundred");
							actualValue.append(" ");
							actualValue.append("and");
							actualValue.append(" ");
							
						}
						break;
					case 1:
						if(check!='0') {
							if(check=='1') {
								 changes+=check;
								 flag=true;
							}
							else {
								actualValue.append(threes.get(check));
								actualValue.append(" ");
							}
						}
						break;
					case 2:
						if(flag==true) {
							changes+=check;
							actualValue.append(twos.get(changes));
						}
						else {
							if(check!='0') {
								actualValue.append(ones.get(check));
							}
							
						}
						break;
					}
				}
				else {
					switch(i) {
					case 0:
						if(check!='0') {
							if(check=='1') {
								 changes+=check;
								 flag=true;
							}
							else {
								actualValue.append(threes.get(check));
								actualValue.append(" ");
							}
						}
						break;
					case 1:
						if(flag==true) {
							changes+=check;
							actualValue.append(twos.get(changes));
						}
						else {
							if(check!='0') {
								actualValue.append(ones.get(check));
							}
							
						}
						break;
					
					}
				}
				
			}
			
		}
		
		
		System.out.println(actualValue);
		
	}
	boolean isRotated(String str1,String str2) {
		String first=str1+str1;
		System.out.println(first);
		if(first.contains(str2)) {
			return true;
		}
		return false;
		
	}
	String reverse(String str) {
		String reverse="";
		for(int i=0;i<str.length();i++) {
			reverse=str.charAt(i)+reverse;
		}
		
		return reverse;
		
	}
	void replaces(char[] palindrome, int index,String str) {
		for(int i=0;i<str.length();i++) {
			palindrome[index]=str.charAt(i);
			index++;
		}
		palindrome[index]=' ';
		
		
	}
	



	
	char[] isPalindrome(char[] palindrome) {
		String first="";
		int index=0;
		for(int i=0;i<palindrome.length;i++) {
			if(i<palindrome.length-1) {
				if(palindrome[i]!=' ') {
					first+=palindrome[i];
				}
				
				else {
					String second=reverse(first);
					if(!first.equals(second)) {
						replaces(palindrome,index,first);
						index=index+first.length()+1;
						
					}
					else {
						
					}
					first="";
				}
			}
			else {
				if(palindrome[i]!=' ') {
					first+=palindrome[i];
				}
				
				
					String second=reverse(first);
					if(!first.equals(second)) {
						replaces(palindrome,index,first);
						index=index+first.length()+1;
						
					}
				
			}
			
			
		}
		palindrome[index]='\0';
		
		for(int i=0;i<palindrome.length;i++) {
			System.out.print(palindrome[i]);
		}
		return palindrome;
	}
	
	List isSubString(String str1,String str2) {
		List<String> list=new ArrayList();
		
		StringBuilder first=new StringBuilder();
		StringBuilder second=new StringBuilder();
		for(int i=0;i<str1.length();i++) {
			if(str1.charAt(i)!=str2.charAt(i)) {
				first.append(str1.charAt(i));
				second.append(str2.charAt(i));
			}
			
			else if(!first.isEmpty()){
				
				list.add(first.toString());
				list.add(second.toString());
				first.setLength(0);
				second.setLength(0);
				
			}
			
		}
		System.out.println(list);
		return list;
		
	}
	String isNonRepeated(String str) {
		String returnValue="No such character";
		for(int i=0;i<str.length();i++) {
			char check=str.charAt(i);
			int first=str.indexOf(check);
			int last =str.lastIndexOf(check);
			if(first==last) {
				return String.valueOf(check);
			}
			
		}
		return returnValue;
	
		
	}
	
	
	
	
	
	
	
	
	
	
	

	
}