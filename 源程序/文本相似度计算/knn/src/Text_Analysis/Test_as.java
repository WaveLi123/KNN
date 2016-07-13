package Text_Analysis;

import java.io.File;
import java.io.IOException;

public class Test_as {

	public static void main_20() throws IOException{	
		Text_Analysis ta = new Text_Analysis();
		String t_string = "";
		//get the contents from the articles
		File fileroot = new File("F:/Course/Npl/Resources");
		File files [] = fileroot.listFiles();
		System.out.println("files.length = "+files.length);
		for(File file : files){
			t_string += ta.text_parse("F:/Course/Npl/Resources/"+file.getName());
		}
		//calculate
		ta.C_vocabulary(t_string);		
		//get top20 		
		System.out.println(ta.SelectSort(ta.vocabulary,(ta.vocabulary.size()-1),"F:/Course/Npl/Results"));
		//ta.Test(ta.vocabulary);
	}
	public static void main_80() throws IOException{	
		Text_Analysis ta = new Text_Analysis();
		String t_string = "";
		//get the contents from the articles
		File fileroot = new File("F:/Course/Npl/Resources");
		File files [] = fileroot.listFiles();
		System.out.println("files.length = "+files.length);
		for(File file : files){
			t_string += ta.text_parse("F:/Course/Npl/Resources/"+file.getName());
		}			
		//calculate
		ta.C_vocabulary(t_string);
		//get 80%
		String content = ta.R_80(ta.vocabulary,"F:/Course/Npl/Results");
		System.out.println(content);
	}
	public static void main_xv() throws IOException{	
		Text_Analysis ta = new Text_Analysis();
		String t_string = "";
		//get the contents from the articles
		File fileroot = new File("F:/Course/Npl/Resources");
		File files [] = fileroot.listFiles();
		System.out.println("files.length = "+files.length);
		for(File file : files){
			t_string += ta.text_parse("F:/Course/Npl/Resources/"+file.getName());
		}			
		//calculate
		ta.C_vocabulary(t_string);
		
		//get 信息熵
		String content = ta.C_comentropy(ta.vocabulary,"F:/Course/Npl/Results");
		System.out.println(content);
	}
	public static void main_ppq() throws IOException{	
		Text_Analysis ta = new Text_Analysis();
		String t_string = "";
		//get the contents from the articles
		File fileroot = new File("F:/Course/Npl/Resources");
		File files [] = fileroot.listFiles();
		System.out.println("files.length = "+files.length);
		for(File file : files){
			t_string += ta.text_parse("F:/Course/Npl/Resources/"+file.getName());
		}			
		//calculate
		ta.C_vocabulary(t_string);
		//get 困惑度				
		String temp_v = ta.Cpp_q(ta.vocabulary,"F:/Course/Npl/Results/");
		System.out.println(temp_v);
	}
}
