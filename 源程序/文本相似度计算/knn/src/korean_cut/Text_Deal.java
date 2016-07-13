package korean_cut;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class Text_Deal {
	//data
	//method
	//信息获取
	public String get_str(String pathName) throws IOException{			
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
        reader.close();
        return line;
	}
     
	//断句
//	public ArrayList<String> Sentence_Cut(String str){
//		ArrayList<String> corpus = new ArrayList<String>();
//		for(String sentence : str.split(.)){
//			
//		}
//		return str.split(".");
//	}
	
//分词
	//获取语料词典
	public String[] get_word_l(ArrayList<Word_L> list){
		String[] words = new String[list.size()];
		for(int i = 0; i < list.size(); i ++){
			words[i] = list.get(i).word_content; 
		}
		return words;
	}
	//获取相应单词的词性
	public String get_word_s(String value,ArrayList<Word_L> list){
		
		for(int i = 0; i < list.size(); i ++){
			if(value.equalsIgnoreCase(list.get(i).word_content)){
				return list.get(i).word_speech;
			}
		}
		return "";
	}
	public boolean isWord(String str_t,String words[]){
		for(String word : words){
			//单词匹配成功
			if(word.equalsIgnoreCase(str_t)){
				return true;
			}
		}
		//单词匹配失败
		return false;
	}
	public ArrayList<String> Word_Cut(String str,ArrayList<Word_L> word,int length){
		ArrayList<String> list = new ArrayList<String>();
		String[] words = get_word_l(word);//获取语料词典
		String value = "";
//		for(String val : words){
//			System.out.println(val);
//		}		
		System.out.println(str);
		int w_s = 0;
		int w_e = length;
		//正向最大匹配法		
		//特殊情况处理(待处理的字符串过短)
		if(str.length() <= length){
			w_e = (str.length()-1);
			length = (str.length()-1);
		}
		//正常处理
//		System.out.println(w_s+"**"+w_e+"**"+str.length());		
//		while(!(w_s >= str.length() || w_e >= str.length())){
		while(!(w_s == w_e && w_s == (str.length()-1))){
//			System.out.println("w_s ="+w_s+"w_e ="+ w_e);
			if(isWord(str.substring(w_s,w_e),words)){
				value = str.substring(w_s,w_e);
				value = "/"+value+"/"+get_word_s(value,word);
				list.add(value);
//				System.out.println("value23 ="+value);
				w_s = w_e;					
			}
			else if((w_e == (w_s+1))){					
				value = "/"+str.substring(w_s,w_e)+"/*";				
				list.add(value);
//				System.out.println("value24 ="+value);
				w_s = w_e;
			}				
			else{					
				if(w_e == w_s){
					if((w_s + length) >= str.length()){
						w_e = str.length()-1;
					}
					else{
						w_e = w_s + length;
					}																
				}else{
					w_e --;
				}				
			}							
		}
//		System.out.println("The end!");
		return list;
	}	
	//地名提取
	//前缀或后缀识别
	public int Suffix_Test(String prefix,String cotent,String pathName,ArrayList<Word_L> list) throws IOException{			
			ArrayList<String> map = new ArrayList<String>();
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
	    	for (String value : parts){	    		
	    		//获取地名后缀内容
	    		map.add(value);
	        }            	                      
	        reader.close();
	        
	        	       
	        for(String val : map){	        		        	
        		if(cotent.split("/")[1].contains(val)){
        			System.out.println(val+"?"+cotent.split("/")[1]);
//		        	System.out.print(val.length());
//		        	System.out.print(cotent.split("/")[1].length());
	        		//完全匹配
	        		if(val.length() == cotent.split("/")[1].length()){
	        			if(get_word_s(prefix.split("/")[1],list).equalsIgnoreCase("n")){
	    	        		return 2;
	    	        	}
	        			else{	        		
	    	        		return 1;
	    	        	}
	        		}
	    	        //部分匹配
	        		else{
	        			return 1;
	        		}	        		
	        	}	        			        		        	
	        }	        		        
	        //匹配失败
	        return 0;
	}
	
	public ArrayList<String> Org_Get(String str,ArrayList<Word_L> word,int length) throws IOException{
		ArrayList<String> content = new ArrayList<String>();
		content = Word_Cut(str,word,length);		
		String filepath = "KoreanPlaceSuffix.txt";
		//特殊情况处理
//		switch(Suffix_Test("",content.get(0),filepath,word)){
//			case 0:	;
//					break;
//			case 1:	content.set(1,(content.get(1)+"【Place】"));
//					break;
//			case 2:	;					
//					break;
//			default:;
//					break;								
//		}
		//正常处理
//		System.out.println(content.size());		
		for(int i = 1; i < content.size(); i ++){
//			System.out.println(content.get(i-1));
//			System.out.println(content.get(i));
			switch(Suffix_Test(content.get(i-1),content.get(i),filepath,word)){
				case 0:	;
						break;
				case 1:	content.set(i,(content.get(i)+"【Place】"));
						break;
				case 2:	content.set(i,(content.get(i).split("/")[1]+"/"+content.get(i).split("/")[2]+"【Place】"));
						content.set(i-1,("/"+content.get(i-1).split("/")[1]));
						break;
			}
		}
		return content;
	}	
	
	public ArrayList<String> Key_Words(String str,ArrayList<Word_L> word,int length) throws IOException{
		ArrayList<String> content = new ArrayList<String>();
		content = Word_Cut(str,word,length);
		ArrayList<String> Key_Words = new ArrayList<String>();
		
		String filepath = "KoreanPlaceSuffix.txt";
		
		for(int i = 0; i < content.size(); i ++){
			if((!content.get(i).split("/")[2].equalsIgnoreCase("*")) && (!content.get(i).split("/")[2].equalsIgnoreCase("u"))){
				Key_Words.add(content.get(i).split("/")[1]);
			}
		}
		return Key_Words;
	}
	
	
	public boolean Write_File(String filepath,String content) throws IOException{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String timeofwrite=df.format(new Date()).toString();
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filepath+"朝鲜文地名识别_"+timeofwrite+".txt")));
		writer.write(content);
		writer.close();
		return true;
	}
	public boolean Corpus_Dev(String filepath,String content) throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("wordsDic.txt"),true));//追加写
		writer.write("\r\n");
		writer.write(content);
		writer.close();
		return true;
	}
	
	public ArrayList<String> main_test(String filePath) throws IOException {
		Corpus_Deal corpus_deal = new Corpus_Deal();	
		ArrayList<Word_L> map = new ArrayList<Word_L>();		
		map = corpus_deal.corpus_f("wordsDic.txt");
		int length = corpus_deal.get_word_L(map);
		
		Text_Deal text_deal = new Text_Deal();				
		ArrayList<String> list = text_deal.Key_Words(get_str(filePath), map, length);
		return list;
		
	}
	public String To_String(ArrayList<String> list){
		String temp = "";
		for(int j = 0; j < list.size(); j ++){
			temp += list.get(j)+"\r\n";
		}
		return temp;
	} 
	
}
