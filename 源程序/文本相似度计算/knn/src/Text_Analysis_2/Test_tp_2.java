package Text_Analysis_2;

import java.io.File;
import java.io.IOException;

public class Test_tp_2 {

	public static void main_20() throws IOException{	
		Text_Participle_2 ta = new Text_Participle_2();
		String t_string = "";
		//get the contents from the articles
		File fileroot = new File("F:/Course/Npl/Mid_Resources");
		File files [] = fileroot.listFiles();
		System.out.println("files.length = "+files.length);
		for(File file : files){
			t_string += ta.text_parse("F:/Course/Npl/Mid_Resources/"+file.getName());
		}			
		//calculate
		ta.C_vocabulary(t_string);
		System.out.println("allwords = "+ta.length);
		System.out.println("differentwords = "+ta.vocabulary.size());
		System.out.println("****************************************************************");
		
		//get top20 
		ta.SelectSort(ta.vocabulary,(ta.vocabulary.size()-1),"F:/Course/Npl/Results");
		System.out.println("****************************************************************");
	}
	public static void main_80() throws IOException{	
		Text_Participle_2 ta = new Text_Participle_2();
		String t_string = "";
		//get the contents from the articles
		File fileroot = new File("F:/Course/Npl/Mid_Resources");
		File files [] = fileroot.listFiles();
		System.out.println("files.length = "+files.length);
		for(File file : files){
			t_string += ta.text_parse("F:/Course/Npl/Mid_Resources/"+file.getName());
		}			
		//calculate
		ta.C_vocabulary(t_string);
		System.out.println("allwords = "+ta.length);
		System.out.println("differentwords = "+ta.vocabulary.size());
		System.out.println("****************************************************************");
		//get 80%
		ta.R_80(ta.vocabulary,"F:/Course/Npl/Results");
		System.out.println("****************************************************************");
	}
	public static void main_xv() throws IOException{	
		Text_Participle_2 ta = new Text_Participle_2();
		String t_string = "";
		//get the contents from the articles
		File fileroot = new File("F:/Course/Npl/Mid_Resources");
		File files [] = fileroot.listFiles();
		System.out.println("files.length = "+files.length);
		for(File file : files){
			t_string += ta.text_parse("F:/Course/Npl/Mid_Resources/"+file.getName());
		}			
		//calculate
		ta.C_vocabulary(t_string);
		System.out.println("allwords = "+ta.length);
		System.out.println("differentwords = "+ta.vocabulary.size());
		System.out.println("****************************************************************");
		
		//get 信息熵
		System.out.println("信息熵 "+ta.C_comentropy(ta.vocabulary,"F:/Course/Npl/Results"));
		System.out.println("****************************************************************");
	}
	public static void main_ppq() throws IOException{	
		Text_Participle_2 ta = new Text_Participle_2();
		String t_string = "";
		//get the contents from the articles
		File fileroot = new File("F:/Course/Npl/Mid_Resources");
		File files [] = fileroot.listFiles();
		System.out.println("files.length = "+files.length);
		for(File file : files){
			t_string += ta.text_parse("F:/Course/Npl/Mid_Resources/"+file.getName());
		}			
		//calculate
		ta.C_vocabulary(t_string);
		System.out.println("allwords = "+ta.length);
		System.out.println("differentwords = "+ta.vocabulary.size());
		//get 困惑度
		System.out.println("困惑度");
		System.out.println("****************************************************************");				
		String temp_v = ta.Cpp_q(ta.vocabulary,"F:/Course/Npl/Results");
		ta.Test_PPq(ta.vocabulary);
		System.out.println("平均困惑度："+temp_v);
		System.out.println("****************************************************************");
	}
}
