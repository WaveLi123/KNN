package Text_Participle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;



import edu.hit.ir.ltpService.LTML;
import edu.hit.ir.ltpService.LTPOption;
import edu.hit.ir.ltpService.LTPService;
import edu.hit.ir.ltpService.SRL;
import edu.hit.ir.ltpService.Word;


import Text_Analysis.Text_Analysis;


class Words{
	Word value;
	int number;
	double percent;
	double pp_q;
}
public class Text_Participle {
	
	//data
	public ArrayList<Words> s_vocabulary = new ArrayList<Words> ();
	public int W_length;
	public Words temp_W;	
	
	//method
	public static String text_parse(String pathName) throws  IOException{	
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
	public void C_svocabulary(Word temp_word){
        //one loop values        
		int loop_2;		  
													
		//to form words' library		
		//to be continued ...(习主席习主席)
		for(loop_2 = 0; loop_2 < s_vocabulary.size(); loop_2 ++){
			if( temp_word.getWS().equals(s_vocabulary.get(loop_2).value.getWS()) ){				
				break;
			}
		}				
		//there is no similar word in the vocabulary
		if(loop_2 == s_vocabulary.size()){			
			if(Test_Char(temp_word.getWS().charAt(0))){
				temp_W = new Words();			
				temp_W.value = temp_word;			
				temp_W.number = 1;				
				temp_W.percent = ((float)temp_W.number/(float)W_length);
				s_vocabulary.add(temp_W);
			}			
		}	
		//there is some word in the vocabulary,to calculate the number and the percent
		else{
			temp_W = new Words();
			temp_W = s_vocabulary.get(loop_2);
			temp_W.number += 1;				
			temp_W.percent = ((float)temp_W.number/(float)W_length);
			s_vocabulary.set(loop_2, temp_W);
		}		
	}
	
	//get the words from string
    public void T_S(String str) {
        LTPService ls = new LTPService("wavejkd@163.com:j8aeHog9"); 
        
        try {
            ls.setEncoding(LTPOption.UTF8);
            LTML ltml = ls.analyze(LTPOption.PARSER,str);

            int sentNum = ltml.countSentence();
            //get the length of all words
            for(int i = 0; i< sentNum; ++i){
            	ArrayList<Word> wordList_temp = ltml.getWords(i);
            	W_length += wordList_temp.size();
            }
            
            for(int i = 0; i< sentNum; ++i){
                ArrayList<Word> wordList = ltml.getWords(i);                
//                System.out.println(ltml.getSentenceContent(i));
                for(int j = 0; j < wordList.size(); ++j){
                	C_svocabulary(wordList.get(j));                	
//                    System.out.print("\t" + wordList.get(j).getWS());
//                    System.out.print("\t" + wordList.get(j).getPOS());
//                    System.out.print("\t" + wordList.get(j).getNE());
//                    System.out.print("\t" + wordList.get(j).getParserParent() + 
//                            "\t" + wordList.get(j).getParserRelation());
                    if(ltml.hasSRL() && wordList.get(j).isPredicate()){
                        ArrayList<SRL> srls = wordList.get(j).getSRLs();
//                        System.out.println();
                        for(int k = 0; k <srls.size(); ++k){
//                            System.out.println("\t\t" + srls.get(k).type + 
//                                    "\t" + srls.get(k).beg +
//                                    "\t" + srls.get(k).end);
                        }
                    }
//                    System.out.println();
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            ls.close();
        }
    }
    	
	//remove the character like:1,2...、a,A...、，。 ？！...
	static boolean Test_Char(char ch){
		boolean valid = true;
		
		if((ch >= '0' && ch <= '9')
				|| (ch >= 'a' && ch <= 'z')
				|| (ch >= 'A' && ch <= 'Z')
				|| ch == '，' || ch == '。' || ch == '？' || ch == '！' || ch == '、' || ch == '；'  || ch == '：' || ch == '“' || ch == '”' || ch == '~' || ch == '@' || ch == '#' || ch == '￥' || ch == '%' || ch == '&' || ch == '*' || ch == '（' || ch == '）' || ch == '{' || ch == '}' || ch == '【' || ch == '】' || ch == '《' || ch == '》'                
				|| ch == ',' || ch == '.' || ch == '?' || ch == '!' || ch == '/' || ch == ';' || ch == ':'  || ch == '"' || ch == ' ' || ch == '~' || ch == '@' || ch == '#' || ch == '$' || ch == '%' || ch == '^' || ch == '&' || ch == '*' || ch == '(' || ch == ')' || ch == '{' || ch == '}' || ch == '[' || ch == ']'              
				){
				
			valid = false;
		}
		
		return valid;		
	}

	void SelectSort_Base(ArrayList<Words> R,int n){
		int i,j,k = 0;
		Words temp = new Words();
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
	public String SelectSort(ArrayList<Words> R,int n,String filepath){
		SelectSort_Base(R,n);
		int i = 0;
	    //show top 20
		if(R.size() < 20){
			for(i = 0; i < R.size(); i ++){
		    	System.out.print(i+": value = "+R.get(i).value.getWS()+","+"\t"+"number = "+R.get(i).number+","+"\t"+"percent = "+R.get(i).percent+"\n");
		    }
		}
		else{
			for(i = 0; i < 20; i ++){
		    	System.out.print(i+": value = "+R.get(i).value.getWS()+","+"\t"+"number = "+R.get(i).number+","+"\t"+"percent = "+R.get(i).percent+"\n");
		    }
		}	    
	    
	  //write the results to the document
	    String filename = filepath+"/词处理_1_Top20_";
	    String content =	"allwords = "+this.W_length+"\n"+
							"differentwords = "+this.s_vocabulary.size()+"\n"+
							"****************************************************"+"\n";
	    for(i = 0; i < 20; i ++){
	    	content += (String)(i+": value = "+R.get(i).value.getWS()+","+"\t"+"number = "+R.get(i).number+","+"\t"+"percent = "+R.get(i).percent+"\n");	    	
	    }
	    content += "****************************************************"+"\n";
	    try {
			Writer_Results(filename,content,"");
		}
	    catch (IOException e) {
			e.printStackTrace();
		}
	    
	    //form GUI
	    return content;
	}
	//To recover the 80% contents
	public String R_80(ArrayList<Words> R,String filepath){
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
			System.out.print(j+": value = "+R.get(j).value.getWS()+","+"\t"+"number = "+R.get(j).number+","+"\t"+"percent = "+R.get(j).percent+"\n");
		}
		System.out.println("P = "+P);
		System.out.println("Length = "+j);
		
		//write results to the document
		String filename = filepath+"/词处理_2_80%_";
		String content = "allwords = "+this.W_length+"\n"+
				"differentwords = "+this.s_vocabulary.size()+"\n"+
				"****************************************************"+"\n";
		for(j = 0;j < i; j ++){
			content +=(String)(j+": value = "+R.get(j).value.getWS()+","+"\t"+"number = "+R.get(j).number+","+"\t"+"percent = "+R.get(j).percent+"\n");
		}
		String other = (String)("P = "+P)+"  "+(String)("Length = "+j);
		content += "****************************************************"+"\n";
		content += other;
		try {
			Writer_Results(filename,content,other);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}		
		return content;
	}
	
	//Caculate the comentropy,logx(y) =loge(x) / loge(y)
	public String C_comentropy(ArrayList<Words> R,String filepath){
		int i = 0; 
		float H = 0;
		
		for(i = 0; i < R.size(); i ++){
			H += (-R.get(i).percent)*(Math.log(R.get(i).percent)/Math.log(2));
		}
		
		//write results to the document 
		String filename = filepath + "/词处理_1_信息熵_";
		String content = "allwords = "+this.W_length+"\n"+
				"differentwords = "+this.s_vocabulary.size()+"\n"+
				"****************************************************"+"\n";
		content += "信息熵 : "+H+"\n"+
				"****************************************************"+"\n";
		try {
			Writer_Results(filename,content,"");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return content;	
	}
	
	//compute the pp_q
	public String Cpp_q(ArrayList<Words> R,String filepath){
		SelectSort_Base(R,(R.size()-1));
		
		int  i = 0;		
		for(i = 0; i < R.size(); i ++){
			Words temp = new Words();
			temp.value = new Word();
			temp.value = R.get(i).value;
			temp.number = R.get(i).number;
			temp.percent = R.get(i).percent;
			temp.pp_q = Math.pow(temp.percent,((double)1/(double)temp.number));
			R.set(i,temp);			
		}
		
		//write results to the document
		String filename = filepath + "/词处理_1_困惑度_";
		String content = "allwords = "+this.W_length+"\n"+
				"differentwords = "+this.s_vocabulary.size()+"\n"+
				"****************************************************"+"\n";
		for(i = 0; i < R.size(); i ++){			
			content += (String)(i+": value = "+R.get(i).value.getWS()+","+"\t"+"number = "+R.get(i).number+","+"\t"+"percent = "+R.get(i).percent+"\t" + "困惑度："+R.get(i).percent+"\n");
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
	//show the 困惑度
    static void Test_PPq(ArrayList<Words> R){    	
        for(int j = 0; j < R.size(); ++j){        	        	
        	System.out.println(j+": value = "+R.get(j).value.getWS()+","+"\t"+"number = "+R.get(j).number+","+"\t"+"percent = "+R.get(j).percent+"\t" + "困惑度："+R.get(j).percent+"/r/n");            
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

	//show the words
    static void Test(ArrayList<Words> words){    	
        for(int j = 0; j < words.size(); ++j){        	
        	System.out.print(j);
            System.out.print("\t" + words.get(j).value.getWS());
            System.out.print("\t" + words.get(j).value.getPOS());
            System.out.print("\t" + words.get(j).value.getNE());
            System.out.print("\t" + words.get(j).value.getParserParent() + 
                    "\t" + words.get(j).value.getParserRelation());
            System.out.print("\t" + words.get(j).number);
            System.out.print("\t" + words.get(j).percent+"\n");
        }
    }
}
