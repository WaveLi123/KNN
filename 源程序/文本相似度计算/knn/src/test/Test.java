package test;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	/**
	 * @param args
	 */
		public static void main(String[] args) {
			double a = 2;
			double b = 209;
			System.out.println("a = "+ a);
			System.out.println("b = "+ b);
			System.out.println("2/209 = "+ (1-(a/b)));
			
			if("/서울/n".contains("/")){
				System.out.println("I love china!");
			}
			ArrayList<String> lib = new ArrayList<String>();
			lib.add("abcd");
			lib.add("abc");			
			if(lib.contains("ab")){
				System.out.println("ab");
			}
			if(lib.contains("abc")){
				System.out.println("abc");
			}
						
		    
			  if(isHave("购买ab","出售AssBC"))
			   System.out.println("true"); //返回true
			  else 
			   System.out.println("false");
			  } 
			  // public static String reg = "[`~!#$%^&*()+=|{}':;',\\[\\].<>/?~！#￥%……&*（）——+|{}【】‘；：”“’。，、？]"; 
			     public static boolean isHave(String strs,String s){ 
			         for (int i = 0; i < strs.length()-1; i++) { 
			             for (int j = i+1; j < strs.length(); j++) { 
			               if(s.toLowerCase().contains(strs.toLowerCase().substring(i, j))){ 
			                     return true; 
			                 } 
			             } 
			         } 
			         return false;

			     }}
