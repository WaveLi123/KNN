package Text_Participle;

import java.io.File;
import java.io.IOException;

public class Test_tp {
 	
	//method
	public static void main_tp_20() throws IOException{	
		Text_Participle ta = new Text_Participle();
		String t_string = "";
				
		//get the contents from the articles
		File fileroot = new File("F:/Course/Npl/Analysis");
		File files [] = fileroot.listFiles();
		for(File file : files){			
			//t_string += ta.text_parse("F:/Course/Npl/Analysis/"+file.getName());
			try {
				Thread.sleep(1000*6);
			} 
			catch (InterruptedException e){
				e.printStackTrace();
			}
			t_string = ta.text_parse("F:/Course/Npl/Analysis/"+file.getName());
			ta.T_S(t_string);
			
		}
		System.out.println(t_string.length());
		System.out.println(t_string);
		
		//show
		String content = ta.SelectSort(ta.s_vocabulary,ta.s_vocabulary.size()-1,"F:/Course/Npl/Results");
		System.out.println(content);
	
	}
	
	public static void main_tp_80() throws IOException{	
		Text_Participle ta = new Text_Participle();
		String t_string = "";
				
		//get the contents from the articles
		File fileroot = new File("F:/Course/Npl/Analysis");
		File files [] = fileroot.listFiles();
		for(File file : files){			
			t_string += ta.text_parse("F:/Course/Npl/Analysis/"+file.getName());
		}
		//to participle		
		ta.T_S(t_string);
		
		//show				
		System.out.println(ta.R_80(ta.s_vocabulary,"F:/Course/Npl/Results"));
	}
	
	public static void main_tp_xv() throws IOException{	
		Text_Participle ta = new Text_Participle();
		String t_string = "";
				
		//get the contents from the articles
		File fileroot = new File("F:/Course/Npl/Analysis");
		File files [] = fileroot.listFiles();
		for(File file : files){			
			t_string += ta.text_parse("F:/Course/Npl/Analysis/"+file.getName());
		}
		//to participle		
		ta.T_S(t_string);
		
		//show		
		System.out.println(ta.C_comentropy(ta.s_vocabulary,"F:/Course/Npl/Results"));
	}
	
	public static void main_tp_ppq() throws IOException{	
		Text_Participle ta = new Text_Participle();
		String t_string = "";
				
		//get the contents from the articles
		File fileroot = new File("F:/Course/Npl/Analysis");
		File files [] = fileroot.listFiles();
		for(File file : files){			
			t_string += ta.text_parse("F:/Course/Npl/Analysis/"+file.getName());
		}
		//to participle		
		ta.T_S(t_string);
		
		//show
		//get the 困惑度				
		System.out.println(ta.Cpp_q(ta.s_vocabulary,"F:/Course/Npl/Results"));
	}
}
