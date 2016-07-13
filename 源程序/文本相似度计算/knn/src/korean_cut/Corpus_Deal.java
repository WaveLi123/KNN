package korean_cut;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Word_L{
	String word_content;
	String word_speech;
	String word_meaning;
}

public class Corpus_Deal {
	//data
	//method
	public void corpus_s(String pathName) throws IOException{
        // Open the file
        BufferedReader reader = new BufferedReader(new FileReader(pathName));                     
        BufferedWriter writer = new BufferedWriter(new FileWriter("藏文词典.txt"));
        
        // For each line in the file ...
        String line;
        while ((line = reader.readLine()) != null) {        	        	
            // ... sum each row of numbers
            String[] parts = line.split("\t");       
            
            //added by jkd,16st Oct in 2014            
        	for (int l = 0; l < parts.length; l ++){
        		//单词行
        		if(parts[l].charAt(0) == '【'){
        			String temp = parts[l].substring(1,(parts[l].length()-1));   
        			writer.write(temp);
        			writer.write("\n");
        		}
        		//单词解释行
        		else{
        			writer.write(parts[l]);
        			writer.write("\n");
        		}
            }                                                  
        }        
        reader.close();		
        writer.close();
	}
	
	public ArrayList<Word_L> corpus_f(String pathName) throws IOException{		
		ArrayList<Word_L> map = new ArrayList<Word_L>();
		Word_L word = new Word_L();
        // Open the file
        BufferedReader reader = new BufferedReader(new FileReader(pathName));                                     
        // For each line in the file ...
        String line_t = "";
        String line = "";
        line_t = reader.readLine();
        while(line_t != null){
        	line += line_t+"\n";
        	line_t = reader.readLine();
        }                	        
        // ... sum each row of numbers
        String[] parts = line.split("\n");                   
		//获取词内容
		String word_t = null;
		//获取词性及中文释义
		String word_s = null;
		String word_c = null;   		
        //added by jkd,16st Oct in 2014  
		int test_i = 0;
    	for (String value : parts){
    		word = new Word_L();
    		//获取词内容
    		word_t = value.split(" ")[0];
    		word_s = value.split(" ")[1];
    		word.word_content = word_t;
    		word.word_speech = word_s;
    		word.word_meaning = word_c;			
    		map.add(word);
        }            	                      
        reader.close();        
		return map;		        
	}
	public char get_word_s(String content){
		char word_s = 0;
		for(int i = 0; i < content.length(); i++){
			if(content.charAt(i) == '[' || content.charAt(i) == '﹝' 
					|| content.charAt(i) == '（'
					|| content.charAt(i) == '('
					|| content.charAt(i) == '<'){
				word_s = content.charAt((i+1));
				break;
			}
		}
		return word_s;
	}	
	public int get_word_L(ArrayList<Word_L> list){
		int length = 0;
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).word_content.length() > length){
				length = list.get(i).word_content.length();
			}
		}
		return length;
	}
	public static String main_test(String args,String filePath) throws IOException {
		Corpus_Deal corpus_deal = new Corpus_Deal();	
		ArrayList<Word_L> map = new ArrayList<Word_L>();		
		map = corpus_deal.corpus_f("wordsDic.txt");
		int length = corpus_deal.get_word_L(map);
		
		Text_Deal text_deal = new Text_Deal();				
//		System.out.println(text_deal.get_str("korean_test.txt"));
		ArrayList<String> list = text_deal.Org_Get(args, map, length);
		
		String temp = "";
//		System.out.println("size = "+list.size());
		for(int j = 0; j < list.size(); j ++){
			temp += list.get(j);
		}
		text_deal.Write_File(filePath,temp);
		System.out.println(temp);
		return temp;
	}
	
	public static void main(String[] args) throws IOException {
		Corpus_Deal corpus_deal = new Corpus_Deal();	
		ArrayList<Word_L> map = new ArrayList<Word_L>();		
		map = corpus_deal.corpus_f("wordsDic.txt");
		int length = corpus_deal.get_word_L(map);
		
		Text_Deal text_deal = new Text_Deal();				
//		System.out.println(text_deal.get_str("korean_test.txt"));
		ArrayList<String> list = text_deal.Org_Get(text_deal.get_str("korean_test.txt"), map, length);
		
		String temp = "";
//		System.out.println("size = "+list.size());
		for(int j = 0; j < list.size(); j ++){
			temp += list.get(j);
		}
		text_deal.Write_File("F:/Course/Npl/Results",temp);
		System.out.println(temp);			
	}
}
