package Text_Analysis_2;

import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

class Word_T{
	String value;
	int number;
	double percent;
	double pp_q;		//困惑度
}

public class Text_Participle_2{
	//data
	public ArrayList<Word_T> vocabulary = new ArrayList<Word_T> ();
	public int length;
	public Word_T temp_R;	
	
	//method
	public String text_parse(String pathName) throws  IOException{	
		// Open the file
		InputStreamReader read = new InputStreamReader(new FileInputStream(pathName),"UTF-8");           
        BufferedReader reader = new BufferedReader(read);		
                            
        // For each line in the file
        String line;
        String all_line = new String();    
        //get all the words from an article,string
        while ((line = reader.readLine()) != null) {
        	all_line += line;
        }        
        //close the file 
        reader.close();
		return all_line;         
	}
	
	//form vocabulary
	public void C_vocabulary(String all_line){
        //two loop values
        int loop_1;
		int loop_2;		  
        //get all the words from an article,char
		String [] words = all_line.split(" ");
		length += words.length;
		
		for(loop_1 = 0; loop_1 < words.length; loop_1 ++){							
			//to form words' library		
			for(loop_2 = 0; loop_2 < vocabulary.size(); loop_2 ++){
				if(words[loop_1].equalsIgnoreCase(vocabulary.get(loop_2).value)){
					break;
				}
			}				
			//there is no similar word in the vocabulary
			if(loop_2 == vocabulary.size()){				
					temp_R = new Word_T();
					temp_R.value = words[loop_1];
					temp_R.number = 1;				
					temp_R.percent = ((double)temp_R.number/(double)length);
					vocabulary.add(temp_R);				
			}	
			//there is some word in the vocabulary,to calculate the number and the percent
			else{
				temp_R = new Word_T();
				temp_R = vocabulary.get(loop_2);
				temp_R.number += 1;				
				temp_R.percent = ((double)temp_R.number/(double)length);
				vocabulary.set(loop_2, temp_R);
			}
		}
	}		
//	//remove the character like:1,2...、a,A...、，。 ？！...
//	boolean Test_Char(char ch){
//		boolean valid = true;
//		
//		if((ch >= '0' && ch <= '9')
//				|| (ch >= 'a' && ch <= 'z')
//				|| (ch >= 'A' && ch <= 'Z')
//				|| ch == '，' || ch == '。' || ch == '？' || ch == '！' || ch == '、' || ch == '；'  || ch == '：' || ch == '“' || ch == '”' || ch == '~' || ch == '@' || ch == '#' || ch == '￥' || ch == '%' || ch == '&' || ch == '*' || ch == '（' || ch == '）' || ch == '{' || ch == '}' || ch == '【' || ch == '】' || ch == '《' || ch == '》'                
//				|| ch == ',' || ch == '.' || ch == '?' || ch == '!' || ch == '/' || ch == ';' || ch == ':'  || ch == '"' || ch == ' ' || ch == '~' || ch == '@' || ch == '#' || ch == '$' || ch == '%' || ch == '^' || ch == '&' || ch == '*' || ch == '(' || ch == ')' || ch == '{' || ch == '}' || ch == '[' || ch == ']'              
//				){
//				
//			valid = false;
//		}
//		
//		return valid;		
//	}

	void SelectSort_Base(ArrayList<Word_T> R,int n){
		int i,j,k = 0;
		Word_T temp = new Word_T();
	    for(i=0;i<n;i++){
	        k=i;      //选择具有最小排序码的对象
	        for(j=i+1;j<=n;j++){
				if(R.get(j).percent < R.get(k).percent){
					k=j;    //当前具最小排序码的对象
				}
			}
	        if(k!=i){     //对换到第 i 个位置
	        	temp = R.get(i);
	        	R.set(i, R.get(k));
	        	R.set(k, temp);
			}
	    }	    
	    Collections.reverse(R);
	}
	//get top20
	public String SelectSort(ArrayList<Word_T> R,int n,String filepath){
		SelectSort_Base(R,n);		
		int i = 0;
	    //show top 20
		if(R.size() < 20){
			for(i = 0; i < R.size(); i ++){
		    	System.out.println(i+": value = "+R.get(i).value+",number = "+R.get(i).number+",percent = "+R.get(i).percent);
		    }
		}
		else{
			for(i = 0; i < 20; i ++){
		    	System.out.println(i+": value = "+R.get(i).value+",number = "+R.get(i).number+",percent = "+R.get(i).percent);
		    }
		}	    
	    
	    //write the results to the document
	    String filename = filepath+"/词处理_2_Top20_";
	    String content = "allwords = "+this.length+"\n"+
				"differentwords = "+this.vocabulary.size()+"\n"+
				"****************************************************"+"\n";
	    if(R.size() < 20){
	    	for(i = 0; i < 20; i ++){
		    	content += (String)(i+": value = "+R.get(i).value+",number = "+R.get(i).number+",percent = "+R.get(i).percent+"\n");	    	
		    }
	    }
	    else{
	    	for(i = 0; i < 20; i ++){
		    	content += (String)(i+": value = "+R.get(i).value+",number = "+R.get(i).number+",percent = "+R.get(i).percent+"\n");	    	
		    }
	    }
	    content += "****************************************************"+"\n";
	    try {
			Writer_Results(filename,content,"");
		}
	    catch (IOException e) {
			e.printStackTrace();
		}
	    
	    //show GUI
	    return content;
	}
	
	//To recover the 80% contents
	public String R_80(ArrayList<Word_T> R,String filepath){
		SelectSort_Base(R,(R.size()-1));
		int i,j = 0; 
		float P = 0;				
		
		for(i = 0; i < R.size(); i ++){
			if(P >= 0.8){
				break;
			}
			P += R.get(i).percent;
		}		
		for(j = 0;j < i; j ++){
			System.out.println(j+": value = "+R.get(j).value+",number = "+R.get(j).number+",percent = "+R.get(j).percent);
		}
		System.out.println("P = "+P);
		System.out.println("Length = "+j);
		
		//write results to the document
		String filename = filepath +"/词处理_2_80%_";
	    String content = "allwords = "+this.length+"\n"+
				"differentwords = "+this.vocabulary.size()+"\n"+
				"****************************************************"+"\n";
		for(j = 0;j < i; j ++){
			content +=(String)(j+": value = "+R.get(j).value+",number = "+R.get(j).number+",percent = "+R.get(j).percent+"\n");
		}
		String other = (String)("P = "+P)+"  "+(String)("Length = "+j);
		content += "****************************************************"+"\n"+ other+"\n";
		try {
			Writer_Results(filename,content,other);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		//show GUI
		return content;
	}
	//Caculate the comentropy,logx(y) =loge(x) / loge(y)
	public String C_comentropy(ArrayList<Word_T> R,String filepath){
		int i = 0; 
		float H = 0;
		
		for(i = 0; i < R.size(); i ++){
			H += (-R.get(i).percent)*(Math.log(R.get(i).percent)/Math.log(2));
		}
		//write results to the document 
		String filename = filepath+ "/词处理_2_信息熵_";
	    String content = "allwords = "+this.length+"\n"+
				"differentwords = "+this.vocabulary.size()+"\n"+
				"****************************************************"+"\n";
		content += "信息熵 : "+H+"\n";
		content += "****************************************************"+"\n";
		try {
			Writer_Results(filename,content,"");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}		
		return content;
	}
	
	//compute the pp_q
	public String Cpp_q(ArrayList<Word_T> R,String filepath){
		SelectSort_Base(R,(R.size()-1));
		int  i = 0;
		float value = 0;
		for(i = 0; i < R.size(); i ++){
			Word_T temp = new Word_T();
			temp.value = R.get(i).value;
			temp.number = R.get(i).number;
			temp.percent = R.get(i).percent;
			temp.pp_q = Math.pow(temp.percent,((double)1/(double)temp.number));
			value += temp.pp_q;
			R.set(i,temp);			
		}
		//平均困惑度
		value = value/(float)R.size();
		//write results to the document
		String filename = filepath + "/词处理_2_困惑度_";
	    String content = "allwords = "+this.length+"\n"+
				"differentwords = "+this.vocabulary.size()+"\n"+
				"****************************************************"+"\n";
		String other = "";
		for(i = 0; i < R.size(); i ++){			
			content += (String)(i+": value = "+R.get(i).value+",number = "+R.get(i).number+",percent = "+R.get(i).percent+",困惑度 = "+R.get(i).pp_q+"\n");
		}
		other = "平均困惑度："+value;
		content += "****************************************************"+"\n"+ other + "\n";
		try {
			Writer_Results(filename,content,other);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		//show GUI
		return content;
	}
	//output the 困惑度
	void Test_PPq(ArrayList<Word_T> R) {
		int i = 0;
		System.out.println("length = "+length);
		for(i = 0; i < R.size(); i ++){			
			System.out.println(i+": value = "+R.get(i).value+",number = "+R.get(i).number+",percent = "+R.get(i).percent+",困惑度 = "+R.get(i).pp_q);
		}		
	}
	
	//write resultes to the txt
	void Writer_Results(String filename,String content,String other) throws IOException{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//设置日期格式
		String timeofwrite=df.format(new Date()).toString();
		
		String[] str = content.split("\n");
	    File file = new File(filename+timeofwrite+".txt");
		FileWriter fo = new FileWriter(file);
		for(int i = 0; i < str.length; i ++){			
			fo.write(str[i]);
			fo.write("\r\n");
		}
		fo.write(other);
		fo.close();
	}
	
	//temp_test
	void Test(ArrayList<Word_T> R) {
		int i = 0;
		System.out.println("length = "+length);
		for(i = 0; i < R.size(); i ++){			
			System.out.println(i+": value = "+R.get(i).value+",number = "+R.get(i).number+",percent = "+R.get(i).percent);
		}		
	}	
}