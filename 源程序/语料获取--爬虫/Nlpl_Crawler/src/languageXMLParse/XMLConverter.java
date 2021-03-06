package languageXMLParse;

import java.io.File;   
import java.io.FileWriter;   
import java.io.IOException;   
import java.io.StringReader;
import java.io.Writer;   
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;   
import java.util.Locale;
import java.util.Map;

import org.dom4j.Document;   
import org.dom4j.DocumentException;   
import org.dom4j.DocumentHelper;   
import org.dom4j.Element;   
import org.dom4j.io.SAXReader;   
import org.dom4j.io.XMLWriter;   

public class XMLConverter {

//定义一些xml节点
//xml文件	
String file=" ";
//
String domainname=" ";
String chinesename=" ";
String pinyin=" ";
String webencoding=" ";
String language=" ";
String encodingtype=" ";
String registrationnumber=" ";
String provider=" ";
String corpustype=" ";
String filename=" ";
String title=" "; 
String subtitle=" ";
String author=" ";
String timeofpublish=" ";
String timeofdownload=" ";
String url=" ";
String clicktimes=" ";
String codeofclassification=" ";
String nameofclassification=" ";
String methodofclassification=" ";
String keywordsofclassification=" ";
String content=" ";
String column=" ";
String[] imageUrls=new String[]{};
	
	
	
	  /**  
		*   
		* @author  Roger Chu
		* 把所有数据存入xml中
		* @param 无参 存xml
		* @return 返回保存xml封装后的字符串
		* 
		*/ 
        //无参传入 无实际用途，只做模版
		protected void ConvertToXML() {
			
			
			//在无参数情况下，下载时间为保存时间
			if(timeofdownload==" ")
				{
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//设置日期格式
				//System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
				timeofdownload=df.format(new Date()).toString();
				}
			
			//创建xml文件
			Document document = DocumentHelper.createDocument();
			//创建xml文档样式 并存入数据 ，如果没有数据则留空白
			Element E_file=document.addElement("file");   
			Element E_domainname=E_file.addElement("domainname");  
			E_domainname.setText(domainname);
			Element E_chinesename= E_file.addElement("chinesename");		
			E_chinesename.setText(chinesename);
			Element E_pinyin= E_file.addElement("pinyin");		
			E_pinyin.setText(pinyin);
			Element E_language= E_file.addElement("language");		
			E_language.setText(language);
			Element E_encodingtype= E_file.addElement("encodingtype");		
			E_encodingtype.setText(encodingtype);
			Element E_registrationnumber= E_file.addElement("registrationnumber");		
			E_registrationnumber.setText(registrationnumber);
			Element E_provider= E_file.addElement("provider");		
			E_provider.setText(provider);
			Element E_corpustype= E_file.addElement("corpustype");		
			E_corpustype.setText(corpustype);
			Element E_filename= E_file.addElement("filename");		
			E_filename.setText(filename);
			Element E_title= E_file.addElement("title");		
			E_title.setText(title);
			Element E_subtitle= E_file.addElement("subtitle");		
			E_subtitle.setText(subtitle);
			Element E_author= E_file.addElement("author");		
			E_author.setText(author);
			Element E_timeofpublish= E_file.addElement("timeofpublish");		
			E_timeofpublish.setText(timeofpublish);
			Element E_timeofdownload= E_file.addElement("timeofdownload");		
			E_timeofdownload.setText(timeofdownload);
			Element E_url= E_file.addElement("url");		
			E_url.setText(url);
			Element E_clicktimes= E_file.addElement("clicktimes");		
			E_clicktimes.setText(clicktimes);
			Element E_codeofclassification= E_file.addElement("codeofclassification");		
			E_codeofclassification.setText(codeofclassification);
			Element E_nameofclassification= E_file.addElement("nameofclassification");		
			E_nameofclassification.setText(nameofclassification);
			Element E_methodofclassification= E_file.addElement("methodofclassification");		
			E_methodofclassification.setText(methodofclassification);
			Element E_keywordsofclassification= E_file.addElement("keywordsofclassification");		
			E_keywordsofclassification.setText(keywordsofclassification);
			Element E_content= E_file.addElement("content");		
			E_content.setText(content);
			Element E_column= E_file.addElement("column");		
			E_column.setText(column);
			
			
			
			
			try {   
			Writer fileWriter=new FileWriter("D:\\XHSDATA\\XMLFile\\"+pinyin+timeofdownload+".xml");   
			XMLWriter xmlWriter=new XMLWriter(fileWriter);   
			xmlWriter.write(document);   
			xmlWriter.close();   
			} catch (IOException e) {   
			System.out.println(e.getMessage());
			}   	
			} 
	  
		/**  
		*   
		* @author  Roger Chu
		* 把所有数据存入xml中
		* @param 多参数 不带下载时间
		* @return 返回保存xml封装后的字符串
		* 
		*/ 
		 public void ConvertToXML(String title,String author,String timeofpublish,String content,String domainname,String provider,String chinesename,String pinyin,String webencoding,String language,String encodingtype) {
				
        	 //在无参数情况下，下载时间为保存时间
   			if(timeofdownload==" ")
   				{
   				SimpleDateFormat df = new SimpleDateFormat("HH:mm, yyyy.MMMMM.dd");//设置日期格式
   				//System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
   				timeofdownload=df.format(new Date()).toString();
   				}
			
			//创建xml文件
			Document document = DocumentHelper.createDocument();
			//创建xml文档样式 并存入数据 ，如果没有数据则留空白
			Element E_file=document.addElement("file");   
			Element E_domainname=E_file.addElement("domainname");  
			E_domainname.setText(domainname);
			Element E_chinesename= E_file.addElement("chinesename");		
			E_chinesename.setText(chinesename);
			Element E_pinyin= E_file.addElement("pinyin");		
			E_pinyin.setText(pinyin);
			Element E_language= E_file.addElement("language");		
			E_language.setText(language);
			Element E_encodingtype= E_file.addElement("encodingtype");		
			E_encodingtype.setText(encodingtype);
			Element E_registrationnumber= E_file.addElement("registrationnumber");		
			E_registrationnumber.setText(registrationnumber);
			Element E_provider= E_file.addElement("provider");		
			E_provider.setText(provider);
			Element E_corpustype= E_file.addElement("corpustype");		
			E_corpustype.setText(corpustype);
			Element E_filename= E_file.addElement("filename");		
			E_filename.setText(filename);
			Element E_title= E_file.addElement("title");		
			E_title.setText(title);
			Element E_subtitle= E_file.addElement("subtitle");		
			E_subtitle.setText(subtitle);
			Element E_author= E_file.addElement("author");		
			E_author.setText(author);
			Element E_timeofpublish= E_file.addElement("timeofpublish");		
			E_timeofpublish.setText(timeofpublish);
			Element E_timeofdownload= E_file.addElement("timeofdownload");		
			E_timeofdownload.setText(timeofdownload);
			Element E_url= E_file.addElement("url");		
			E_url.setText(url);
			Element E_clicktimes= E_file.addElement("clicktimes");		
			E_clicktimes.setText(clicktimes);
			Element E_codeofclassification= E_file.addElement("codeofclassification");		
			E_codeofclassification.setText(codeofclassification);
			Element E_nameofclassification= E_file.addElement("nameofclassification");		
			E_nameofclassification.setText(nameofclassification);
			Element E_methodofclassification= E_file.addElement("methodofclassification");		
			E_methodofclassification.setText(methodofclassification);
			Element E_keywordsofclassification= E_file.addElement("keywordsofclassification");		
			E_keywordsofclassification.setText(keywordsofclassification);
			Element E_content= E_file.addElement("content");		
			E_content.setText(content);
			Element E_column= E_file.addElement("column");		
			E_column.setText(column);
			
			
			
			
			try {   
			Writer fileWriter=new FileWriter("D:\\XHSDATA\\XMLFile\\"+pinyin+timeofdownload+".xml");   
			XMLWriter xmlWriter=new XMLWriter(fileWriter);   
			xmlWriter.write(document);   
			xmlWriter.close();   
			} catch (IOException e) {   
			System.out.println(e.getMessage());
			}   	
			} 	
		
		
		 /**  
			*   
			* @author  Roger Chu
			* 把所有数据存入xml中
			* @param 多参数  同时1带有下载时间，2带有多图片地址保存
			* @return 返回保存xml封装后的字符串
		 * @throws ParseException 
			* 
			*/ 
           public void ConvertToXML(String title,String author,String timeofpublish,String content,
        		   String domainname,String provider,String chinesename,String pinyin,String webencoding,
        		   String language,String encodingtype,String timeofdownload,ArrayList<String> imageUrls) throws ParseException {
			
        	 //在无参数情况下，下载时间为保存时间
   			if(timeofdownload==" ")
   				{
   				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//设置日期格式
   				//System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
   				timeofdownload=df.format(new Date()).toString();
   				}
			
			//创建xml文件
			Document document = DocumentHelper.createDocument();
			//创建xml文档样式 并存入数据 ，如果没有数据则留空白
			Element E_file=document.addElement("file");   
			Element E_domainname=E_file.addElement("domainname");  
			E_domainname.setText(domainname);
			Element E_chinesename= E_file.addElement("chinesename");		
			E_chinesename.setText(chinesename);
			Element E_pinyin= E_file.addElement("pinyin");		
			E_pinyin.setText(pinyin);
			Element E_language= E_file.addElement("language");		
			E_language.setText(language);
			Element E_encodingtype= E_file.addElement("encodingtype");		
			E_encodingtype.setText(encodingtype);
			Element E_registrationnumber= E_file.addElement("registrationnumber");		
			E_registrationnumber.setText(registrationnumber);
			Element E_provider= E_file.addElement("provider");		
			E_provider.setText(provider);
			Element E_corpustype= E_file.addElement("corpustype");		
			E_corpustype.setText(corpustype);
			Element E_filename= E_file.addElement("filename");		
			E_filename.setText(filename);
			Element E_title= E_file.addElement("title");		
			E_title.setText(title);
			Element E_subtitle= E_file.addElement("subtitle");		
			E_subtitle.setText(subtitle);
			Element E_author= E_file.addElement("author");		
			E_author.setText(author);
			Element E_timeofpublish= E_file.addElement("timeofpublish");		
			E_timeofpublish.setText(timeofpublish);
			Element E_timeofdownload= E_file.addElement("timeofdownload");		
			E_timeofdownload.setText(timeofdownload);
			
			//创建node节点，存储多图片地址
			Iterator<String> it=imageUrls.iterator();
			        int j=0;								
					while(it.hasNext())
					{
						Element E_Url= E_file.addElement("imageUrl"+j);	
						E_Url.setText((String)it.next());
						j++;						
					}
					
				
			
			
			Element E_url= E_file.addElement("url");		
			E_url.setText(url);
			Element E_clicktimes= E_file.addElement("clicktimes");		
			E_clicktimes.setText(clicktimes);
			Element E_codeofclassification= E_file.addElement("codeofclassification");		
			E_codeofclassification.setText(codeofclassification);
			Element E_nameofclassification= E_file.addElement("nameofclassification");		
			E_nameofclassification.setText(nameofclassification);
			Element E_methodofclassification= E_file.addElement("methodofclassification");		
			E_methodofclassification.setText(methodofclassification);
			Element E_keywordsofclassification= E_file.addElement("keywordsofclassification");		
			E_keywordsofclassification.setText(keywordsofclassification);
			Element E_content= E_file.addElement("content");		
			E_content.setText(content);
			Element E_column= E_file.addElement("column");		
			E_column.setText(column);
			
			
			
			
			try {   
			    //获取的发布时间并转换成simpleDataFormat格式                     
                //模版 09:38, September 19, 2014，里面存在英文所以要locale 英文
                SimpleDateFormat dfpt = new SimpleDateFormat("HH:mm, MMMMM dd, yyyy",Locale.ENGLISH);//设置日期格式
                Date dateOfPublish=dfpt.parse(timeofpublish);
               // System.out.println("获取格式检查"+dateOfPublish+"\n");
                
	       @SuppressWarnings("deprecation")
	       String path="D:\\XHSDATA\\"+language+"\\"+chinesename+"\\"+(dateOfPublish.getYear()+1900)+"\\"+(dateOfPublish.getMonth()+1)+"\\"+dateOfPublish.getDate();
                 // 创建 多层目录 
	           File fp = new File(path);  	                          
	          if (!fp.exists()) {  
	               fp.mkdirs();// 目录不存在的情况下，创建目录。  
	            }        
			Writer fileWriter=new FileWriter(path+"\\"+pinyin+dateOfPublish.getTime()+".xml");
			XMLWriter xmlWriter=new XMLWriter(fileWriter);   
			xmlWriter.write(document);   
			xmlWriter.close();   
			} catch (IOException e) {   
			System.out.println(e.getMessage());
			}   	
			} 
		
		
		
		
           /**  
			*   
			* @author  Roger Chu
			* 把所有数据存入xml中
			* @param 多参数  同时1带有下载时间，2带有多图片地址保存3带下载日期格式模版
			* @return 返回保存xml封装后的字符串
		 * @throws ParseException 
			* 
			*/ 
          public void ConvertToXML(String title,String author,String timeofpublish,String content,
       		   String domainname,String provider,String chinesename,String pinyin,String webencoding,
       		   String language,String encodingtype,String timeofdownload,ArrayList<String> imageUrls,String publishtimeFormation) throws ParseException {
			
       	 //在无参数情况下，下载时间为保存时间
  			if(timeofdownload==" ")
  				{
  				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//设置日期格式
  				//System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
  				timeofdownload=df.format(new Date()).toString();
  				}
			
			//创建xml文件
			Document document = DocumentHelper.createDocument();
			//创建xml文档样式 并存入数据 ，如果没有数据则留空白
			Element E_file=document.addElement("file");   
			Element E_domainname=E_file.addElement("domainname");  
			E_domainname.setText(domainname);
			Element E_chinesename= E_file.addElement("chinesename");		
			E_chinesename.setText(chinesename);
			Element E_pinyin= E_file.addElement("pinyin");		
			E_pinyin.setText(pinyin);
			Element E_language= E_file.addElement("language");		
			E_language.setText(language);
			Element E_encodingtype= E_file.addElement("encodingtype");		
			E_encodingtype.setText(encodingtype);
			Element E_registrationnumber= E_file.addElement("registrationnumber");		
			E_registrationnumber.setText(registrationnumber);
			Element E_provider= E_file.addElement("provider");		
			E_provider.setText(provider);
			Element E_corpustype= E_file.addElement("corpustype");		
			E_corpustype.setText(corpustype);
			Element E_filename= E_file.addElement("filename");		
			E_filename.setText(filename);
			Element E_title= E_file.addElement("title");		
			E_title.setText(title);
			Element E_subtitle= E_file.addElement("subtitle");		
			E_subtitle.setText(subtitle);
			Element E_author= E_file.addElement("author");		
			E_author.setText(author);
			Element E_timeofpublish= E_file.addElement("timeofpublish");		
			E_timeofpublish.setText(timeofpublish);
			Element E_timeofdownload= E_file.addElement("timeofdownload");		
			E_timeofdownload.setText(timeofdownload);
			
			//创建node节点，存储多图片地址
			Iterator<String> it=imageUrls.iterator();
			        int j=0;								
					while(it.hasNext())
					{
						Element E_Url= E_file.addElement("imageUrl"+j);	
						E_Url.setText((String)it.next());
						j++;						
					}
					
				
			
			
			Element E_url= E_file.addElement("url");		
			E_url.setText(url);
			Element E_clicktimes= E_file.addElement("clicktimes");		
			E_clicktimes.setText(clicktimes);
			Element E_codeofclassification= E_file.addElement("codeofclassification");		
			E_codeofclassification.setText(codeofclassification);
			Element E_nameofclassification= E_file.addElement("nameofclassification");		
			E_nameofclassification.setText(nameofclassification);
			Element E_methodofclassification= E_file.addElement("methodofclassification");		
			E_methodofclassification.setText(methodofclassification);
			Element E_keywordsofclassification= E_file.addElement("keywordsofclassification");		
			E_keywordsofclassification.setText(keywordsofclassification);
			Element E_content= E_file.addElement("content");		
			E_content.setText(content);
			Element E_column= E_file.addElement("column");		
			E_column.setText(column);
			
			
			
			
			try {   
			    //获取的发布时间并转换成simpleDataFormat格式                     
               //模版 09:38, September 19, 2014，里面存在英文所以要locale 英文
               SimpleDateFormat dfpt = new SimpleDateFormat(publishtimeFormation);//设置日期格式
               Date dateOfPublish=dfpt.parse(timeofpublish);
              // System.out.println("获取格式检查"+dateOfPublish+"\n");
               
	       @SuppressWarnings("deprecation")
	       String path="D:\\XHSDATA\\"+language+"\\"+chinesename+"\\"+(dateOfPublish.getYear()+1900)+"\\"+(dateOfPublish.getMonth()+1)+"\\"+dateOfPublish.getDate();
                	 // 创建 多层目录 
                  File fp = new File(path);  	                          
                 if (!fp.exists()) {  
                      fp.mkdirs();// 目录不存在的情况下，创建目录。  
                   }                
                
	       
	       
			Writer fileWriter=new FileWriter(path+"\\"+pinyin+dateOfPublish.getTime()+".xml");
			XMLWriter xmlWriter=new XMLWriter(fileWriter);   
			xmlWriter.write(document);   
			xmlWriter.close();   
			} catch (IOException e) {   
			System.out.println(e.getMessage());
			}   	
			} 
		
		
		
		
	
}



/**
 * 
 * <?xml version="1.0" encoding="UTF-8"?>
<file>
<domainname>http://www.qhtb.cn</domainname>
<chinesename>青海藏语广播网</chinesename>
<pinyin>qhzygbw</pinyin>
<webencoding>utf-8</webencoding>
<language>藏文</language>
<encodingtype>Himalaya</encodingtype>
<registrationnumber>默认</registrationnumber>
<provider>http://www.qhtb.cn</provider>
<corpustype>网络</corpustype>
<filename>0_qhzygbw_0_1_2012-02-06_24_1.xml</filename>
<title />
<subtitle />
<author>ཨ་སྐལ་རྒྱམ་གྱིས་ཕུལ།</author>
<timeofpublish>2012-02-06</timeofpublish>
<timeofdownload>2012-08-24</timeofdownload>
<url>C:\_webBug_Backup\藏文\qhtb.cn\2012\index172a.html</url>
<clicktimes>0</clicktimes>
<codeofclassification>0</codeofclassification>
<nameofclassification>无类</nameofclassification>
<methodofclassification>无法分类</methodofclassification>
<keywordsofclassification></keywordsofclassification>
<content> འཛའ་ཞིང་བརྩེ་བའི་མཚོ་སྔོན་རླུང་འཕྲིན་ཁང་གི་ལེ་ཚན་མགོ་འཛིན་པ་རྣམས་པ་ལགས།&#xD;
ཕྲན་ནི་རྨ་ཀླུང་རིང་མོ་དལ་གྱི་འབབ་པའི་ཁུགས་སོ་དང་པོ་འདའ་མོ་གཡང་རྫོང་གི་གནས་མཆོག་གཅན་ཚ་ནས་ཡིན་ཞིང་།ཕྲན་གྱི་མང་ལ་ལྷུན་གྲུབ་རྡོ་རྗེ་ཟེར།ད་ཐེངས་ཕྲན་གྱི་སྐུད་མེད་གློག་ལམ་འདི་རགྱུད་དེ་རི་ཁ་བ་ཅན་གྱི་ཡུལ་མི་སྤུན་ཟླ་རྣམས་གཙོ་བྱས་ཏེ་རིག་པའི་རལ་གྲི་དགུང་ལ་འཕྱར་བའི་སྐལ་ལྡན་སློབ་མ་དག་གི་མ་ཡུམ་སློབ་གྲྭ་འགྲུམས་དུས་མི་ལུས་ནད་མེད་བདེ་ཐང་དང་བྱ་བ་ཐམས་བཅད་ལེགས་འགྲུབ་བྱུང་དེ་སྐུ་བསོད་རླུང་རྟ་དར་བའི་བཀྲ་ཤིས་སྨོན་འདུན་ཞུ་བ་དང་བསྡོངས་ཏེ་ཁྱེད་མགོ་འཛིན་པས་གླུ་དང་རྡུང་ལེན་གང་རུང་ཞིག་འབུལ་བར་སྙིང་ཁུངས་རུས་པས་དགའ་བསུ་བྱས་པ་ཡིན། ངོ་སོ་བསྟོད་ཡག་གི་ཡ ། ལྷག་བསམ་དང་སྙིང་སྟོབས་ཀྱིས་ཕྱུགས་པས་མཚོ་སྔོན་བོད་སྐད་རླུང་འཕྲིན་གྱི་ལས་བྱེད་ཡོངས་དང་། ལྷག་དོན་སློབ་རྭའི་&#xD;
འགྱུར་ཁུགས་ཀྱི་མདོ་འཛིན་པ་ལགས། ཉེ་ལམ་ཁྱོད་ཚོའི་སྐུ་བདེ་འམ། བདག་གི་མིང་ལ་རྡོ་རྗེ་དོན་འགྲུབ་ཟེར། བདག་གིས&#xD;
་སྐུད་མེད་རླབས་རགྱུན་འདི་དང་ལྡོངས་ནས་བདག་གི་ཕ་མ་གཉིས་གཙོ་བོའི་ཡུལ་མི་ཉེ་འབྲེལ་ཡོངས་དང་། ཁྱད་པར་བདག་ལ་བཀྲ་དྲིན་ཆེ་བའི་དགེ་རགན་དག་གིས་ཅི་བསམ་ལྷུན་འགྲུབ་ཡོང་བའི་སྨོན་འདུན་དུ་གླུ་དང་རྡུང་ལེན་གང་རུང་ཞིག་བཀོད་བསགྲིག་བྱེད་རགྱུ་མཁྱེན་མཁྱེན་ལགས། ། རོང་འབྲོག་མང་ཚོགས་ཀྱི་སྤྲོ་སེམས་མེ་ལྕེ་དགོང་དུ་སྦར་བའི་མཚོ་སྔོན་བོད་སྐད་བརྙན་འཕྲིན་ལ་བཀྲིས་བདེ་ལེགས་ཞུ། མཚོ་སྔོན་བོད་སྐད་རགྱང་སགྲོག་བརྙན་འཕྲིན་གྱི་མདོ་འཛིན་པ་ལགས།&#xD;
ཕྲན་ནི་ཀན་སུའུ་ཞིང་ཆེན་མདོ་ལྷོ་ཁུལ་གཙོས་གྲོང་ཁྱེར་རྔོག་རགྱལ་མོ་དགོན་གྱི་ཡིན་ལ།བདག་གིས་བོད་ཆུ་ཕོ་འབྲུག་ལོའི་གནམ་ལོ་གསར་བའི་སྐྱ་རེངས་དང་བསྡོངས་ཏེ་རགྱལ་ཁབ་ཕྱི་ནང་ཀུན་ན་བཞུགས་པའི་གཞིས་བྱེས་བོད་མི་ལྷན་རགྱས་ཡོངས་ཀྱི་ཚེ་བསོད་རླུང་རྟ་དར་ཞིང་བྱ་གཞག་མ་ལུས་གེགས་མེད་ལྷུན་འགྲུབ་ཡོང་བའི་སྨོན་འདུན་དུ་གླུ་དང་གླུ་དབྱངས།རྡུང་ལེན་གང་རུང་ཞིག་འབུལ་བར་བཀའ་དྲིན་ཆེ། ས་མཐོའི་རི་ཀློང་འདི་ཡི་བར་ཐག་ཐོད་ཀྱིས་བརགལ་ཞིང་། མཛའ་མཐུན་གྲོགས་ཀྱི་བརྩེ་འཕྲིན་འགོར་མིན་ཡུད་ཀྱིས་བསྐྱེལ་བའི་སློབ་རྭའི་འགྱུར་ཁུག་གི་མདོ་འཛིན་པ་ལགས་ཉེ་ལམ་སྐུ་བདེ་འམ། ཕྲན་ནི་རྨ་ཀླུང་དགུ་ཁུག་རིང་མོ་གླིང་ས་མཐོང་ཀུན་སྨོན་ནས་འབྱུང་འདུས་ཀྱི་ན་ཚོད་སྨིན་པའི་འབྲོག་ཕྲུག་དཀྱེས་མ་ཞིག་ལགས། ཕྲན་གྱི་སློབ་རྭའི་འགྱུར་ཁུག་གི་སྐུད་མེད་འཕྲིན་ལམ་འདི་བརགྱུད་ནས་རེབ་གོང་གསེར་མོ་ལྗོངས་ཀྱི་སེང་གེ་གཞུང་མ་འགོ་དགོན་གྱི་ཆོས་གྲོགས་དམ་པ་བློ་བཟང་སྙན་གྲགས་ལགས་ལ་སྐུ་བདེ་ཐང་དང་། ཇི་བསམ་ལྷུན་འགྲུབ་ཡོོང་བའི་ལེགས་སྐྱེས་སུ་འགོ་འཛིན་པས་གླུ་དང་རྡུང་ལེན་གང་རུང་ཞིག་བཀོད་སགྲིགས་བྱེད་རོགས།&#xD;
ཞེས་ཆུ་དབལ་མའི་གྲོགས་འཇམ་དཔལ་ནས། སློབ་རའི་འགྱུར་ཁུག་གི་མགོ་འཛིན་པ་སགྲོལ་མ་གཙོས་སློབ་རའི་འགྱུར་ཁུག་གི་མགོ་འཛིན་པ་དག་ཉེ་ལམ་སྐུ་བདེ་འམ།གནམ་ལོ་གསར་བའི་ནང་ཁ་བ་གངས་རིའི་བསྐོར་བའི་བོད་རིགས་སྤུན་ཟླ་རྣམས་ལ་བཀྲ་ཤིས་བདེ་ལེགས་ཞུ་བ་དང་ཆབས་ཅིག་རགན་པ་རྣམས་ཚེ་ཐག་རིང་བ་དང་།གཞོན་པ་རྣམས་བློ་རིག་བཀྲ་བའི་སྨོན་འདུན་ཞུ། གངས་དཀར་ལྷུན་པའི་འདབ་རོལ་ན་ཡིག་དྲུག་གི་དབྱངས་རྟ་མཁའ་དབྱིངས་ལ་གྱེར་བའི། བོད་མི་སྤུན་ཟླ་ཡོངས་ཀྱི་སྐུ་ལུས་བདེ་ཞིང་བསམ་དོན་གྱི་རི་མོ་འགྲུབ་པའི་སྨོན་འདུན་དང་ཆབ་གཅིག མཚོ་སྔོན་བོད་སྨན་ཁང་གི་ལྷ་རྗེ་པདྨ་དབང་གྲགས་མཆོག་ཐུགས་བཞེད་མཐའ་དག་ལྷུན་གྲུབ་ཡོངས་པའི་སྨོནའདུན་དུ་་་་་་་་་་་་ ༄༅།།མཛའ་བརྩེ་ཁྲི་ཕྲག་གི་སྨོན་འདུན་བར་ན་ཤེས་རིག་གི་འོ་མཚོ་ལ་དུང་བ་ཟབ་ཅིང་། སྙིང་ཉེ་བའི་ཏིང་ཀྱྰ་ལྔ་རིག་ཉི་ཤར་དར་རགྱས་སློབ་གླིང་གི་ཆོས་གྲོགས་དོན་ཡོད་རྣམ་རགྱལ་དང་། ལུང་རྟོགས། སྐལ་བཟང་སྙན་གྲགས། བཀྲ་ཤིས་འོད་ཟེར་སོགས་གཙོས་ཆོས་གྲོགས་ཡོངས་ལགས་ཉེ་ལམ་སྐུ་བདེའམ། གནམ་ལོ་གསར་བའི་ནང་དུ་ཁྱེད་རྣམ་པའི་སྐུ་ལུས་ལ་ན་ཚ་མེད་ཅིང་ཅི་བསམ་ལྷུན་གྱི་འགྲུབ་པའི་སྨོན་འདུན་དུ་མདོ་འཛིན་པའི་གླུ་དང་རྡུང་གང་རུང་ཞིག་གཏོང་རགྱུ་བཀའ་དྲིན་ཆེ།ཞེ་ཏིང་ཀྱྰ་དགོན་གསང་སྔགས་ཆོས་འཁོར་གླིང་གི་ཐུབ་བསྟན་རིན་ཆེན་གྱིས། གངས་དཀར་ཀྱི་ཞིང་ན་ལྷག་བསམ་གྱི་འོད་སྣང་མཚེར་བའི་སློབ་རའི་འགྱུར་ཁུག་གི་མགོ་འཛིན་པ་ལེགས་ཉེ་ལམ&#xD;
སྐུ་བདེ་འམ་བདག་ནི་ཕ་ཡུལ་རྨ་ལྷོ་ཁུལ་རྨ་ལྷོ་རྫོང་ཉིན་ཐ་ཞང་གཙང་ལྷ་སྡེ་གི་ཡིན་ལ་བདག་གི་མིང་ལ་ཤེས་རབ&#xD;
ཟེར་ཐེངས་འདིར་ངས་གཟུགས་མེད་ཀྱི་གློག་རླབས་འདི་བརགྱུད་དེ་བཀྲ་ཤིས་པའི་གནམ་ལོ་གསར་བ་འདིའི་ནང་དུ&#xD;
ཁྱེད་སློབ་རའི་འགྱུར་ཁུག་གི་མགོ་འཛིན་ཡོངས་གཙོ་བྱས་ཏེ་ཕ་ཡུལ་གཙང་ལྷ་སྡེ་གི་ཕ་བཀྲ་ཤིས་དོན་འགྲུབ་དང་&#xD;
མ་བཀྲ་ཤིས་མཚོ་གཙོ་བྱས་བའི་གཟའ་མི་ཡོངས་དང་ཤ་ཉེ་འབྲེལ་ཡོངས་ཀྱི་སྐུ་ལས་ལ་ན་ཚ་མུ་འབྱུང་བ་དང&#xD;
བསམ་དོན་ཀྱི་རི་མོ་འགྲུབ་པའི་སྨོན་མདུན་དུ་གདུ་བྷའི་རྡུང་ལེན་ཞིག་འབུལ་གྱི་མཁྱེན འཛམ་གླིང་མི་རིགས་ཡོངས་ལ་ལོ་གསར་བའི་ནང་བཀྲ་ཤིས་བདེ་ལེགས་ཡོངབའིསྨོན་འདུན་ཞུ མི་རིགས་ལས་དོན་ལ་རང་ནུས་ཡུད་ཚད་འབུལ་བཞིན་པའི་མཚོ་སྔོན་བོད་སྐད་རླུང་འཕྲིན་ལས་ཁུངས་ཀྱི་ལས་བཟོ་བ་ཡོངས་དང་།སགོས་སུ་སློབ་རའི་འགྱུར་ཁུགས་ཀྱི་འགོ་འཛིན་པ་ཡོངས་ལགས།ཁྱེད་རྣམ་པའི་སྐུ་ཁམས་བཟང་ངམ།&#xD;
ཕྲན་ནི་བ་ཡན་རྫོང་གཤོང་གཤན་ཡུལ་ཚོའི་དགེ་རགན་དཀྱུས་མ་ཞིག་ཡིན།བདག་གིས་ཁྱེད་ཅག་གི་སྐུད་མེད་གློག་གི་རླབས་རགྱུན་འདི་གཡར་ནས།ཕ་ཡུལ་མཚོ་ལྷོ་ཁུལ་མང་རྫོང་བན་ཤུལ་སྡེ་བའི་ཕ་མ་གཉིས་གཙོ་བྱས་པའི་ཕུ་ནུ་སྤུན་མཆེད་ཡོངས་ཀྱི་བྱ་བ་ལམ་འགྲོ་ཡོང་བ་དང་།དགེ་གྲགས་སོག་རུ་འགུ་རུ་རགྱལ་དང་།དོ་རགྱ་དབང་ཆེན་ཚེ་རིང་།སྨད་པ་རྡོ་རྗེ་རྣམ་རགྱལ།བ་ཡན་པད་མ་རྡོ་རྗེ།རྡོ་སྦིས་རྡོ་རྗེ།མགོ་མང་འབྲུག་འབུམ་སོགས་ཀྱི་དགུན་གནང་གི་འཚོ་བར་སྤྲོ་སྐྱིད་འབྱུང་ཞིང་ཅི་བསམ་ཐམས་ཅད་ཡིད་བཞིན་འགྲུབ་པའི་སྨོན་འདུན་དུ་འགོ་འཛིན་པས་གླུ་དང་རྡུང་ལེན་གང་རུང་ཞིག་བཀོད་སགྲིག་བྱེད་པར་མཁྱེན། དྲི་མེད ་དྭངས ་གཙང ་གི ་ཁ་བཏགས་སྐུད་མེད ་གློག ་གི ་རླུང་འཕྲིན ་བརགྱུད ་ནས ་ཡུལ ་ཁ ་བའི ་ལྗོངས ་ཀྱི་ཉན ་མཁན ་དག ་ལ ་འབུལ ་བཞིན་པའི ་སློབ་རའི་འགྱུར ་ཁུགས ་ཀྱི ་ལེ ་ཚན་འགོ་འཛིན་པ་ཡོངས ་ལགས ། ཉེ་ལམ ་སྐུ་བདེ་འམ། ཕྲན་གྱི་མིང་ལ་མཁའ ་འབུམ་ཚེ་རིང ་ཟེར་ལ ་ད་ལྟ་སི་ཁྲོན་ཞིང་ཆེན་ལྷོ་ནུབ་མི་རིགས་སློབ་གྲྭ་ཆེན་མོ་ན་དཔའ་འབྱོར་རིག་པའི་ཆེད་ལས་ཀྱི་ཞིབ་འཇུག་སློབ་མར་སློབ་གཉེར་བྱེད་བཞིན་ཡོད། སྤྱི་ལོ་ཉིས་སྟོང་བཅུ་གཉིས་ཐོན་ལ་ཉེ་བའི་བཀྲ་ཤིས་སྐལ་བཟང་གི་ཉིན་མོ་འདི་ལ་འགོ་འཛིན་པའི་གླུ་དང ་རྡུང་ལེན་སོགས་གང་རུང་ཞིག་བཀོད་སགྲིག་བྱེད་ནས་མཚོ་སྔོན་མི་རིགས་སློབ་གྲྭ་ཆེན་མོའི་བོད་རིག་པའི་སློབ་གླིང་གི་དགེ་རགན་མ་ནེ་འབུམ་ལགས་གཙོ་བྱས་ནས་ཉིས་སྟོང་དགུ་ལོར་བོད་དབྱིན་འཛིན་གྲྭ་ནས་མཐར་ཕྱིན་པའི་སློབ་གྲོགས་དག་གི་བྱ་བ་གོང་འཕེལ་དང་ནད་མེད་ཚེ་རིང་ཡོང་བར་བཀྲ་ཤིས་སྨོན་འདུན་ཞུ་བ་ཡིན། སློབ་རའི་འགྱུར་ཁུག་གི་མགོ་འཛིན་པ་སགྲོལ་མ་གཙོས་སློབ་རའི་འགྱུར་ཁུག་གི་མགོ་འཛིན་ལགས་ཉེ་ལམ་སྐུ་བདེ་འམ། ང་རླུང་འཕྲིན་དང་སྐུད་ཐག་ཆེ་ཉེ་བའི་གྲོགས་པོ་ཞིག་ཏེ་མིང་ལ་ཆབ་བུ་མེ་སགྲོན་ཟེར། ཁྱེད་རླུང་འཕྲིན་ཁང་གི་ལས་བྱེད་མི་སྣ་ཡོངས་ཀྱི་འཚོ་བ་རྟག་བརྟན་ཡོང་བའི་སྨོན་འདུན་དང་ཆབ་ཅིག འཆོལ་གསུམ་བོད་མིའི་བསམ་དོན་ཀྱི་རི་མོ་མྱུར་འགྲུབ་ཡོང་བའི་སྨོན་འདུན་དུ་་་་་་་་་་་་་་་ ༺༺ ཀྲུང་དབྱང་མི་རིགས་སློབ་ཆེན་ནས་བསྐུར་བའི་སློབ་རའི་གསར་འགྱུར།&#xD;
མདོ་སྨད་ས་ཡི་ལྟེ་བ་ཙོང་ཁ་བདེ་ཁམས་བཅོ་བརགྱད་དུ་འབོད་པའི་སྲིད་འབྱོར་རིག་གསུམ་གྱི་ལྟེ་བ་གནམ་མཁར་ཟི་ལིང་གྲོང་དུ་མི་རིགས་ཤིག་གི་ལས་དོན་ལ་ཁ་མིན་སེམས་ཀྱི་གཞོལ་བའི་མཚོ་སྔོན་བོད་སྐད་རགྱང་སགྲོག་བརྙན་འཕྲིན་ལས་ཁུངས་ཀྱི་ལས་བཟོ་བ་ཡོངས་ལ་ཐོག་མར་བཀྲ་ཤིས་བདེ་ལེགས་ཀྱི་ཁམས་བདེ་འཚམས་འདྲི་བྱས་པ་ཡིན།&#xD;
ཟླ་འདིའི་ཚེ་བཅུ་སྟེ་རེས་གཟའ་པ་སངས་ཉིན་ལ། ཀྲུང་དབྱང་མི་རིགས་སློབ་ཆེན་དུ་ལོ་རེར་སྐབས་རེ་བསྡུ་བའི་བོད་ཀྱི་སྤྱི་སྐད་གཏམ་བཤད་འགྲན་བསྡུར་སྐབས་བཞི་བ་དེ་གཟབ་རགྱས་ངང་སློབ་གྲྭའི་འདིའི་རིག་གནས་ཐོག་ཁང་གི་ནུབ་ཀྱི་ཐོག་བརྩེགས་དང་པོའི་རིག་གཞུང་སྙན་ཞུ་ཁང་དུ་འཚོགས། ཐེངས་འདིའི་ཚོགས་འདུ་ལ་ཁྱོན་བསྡོམས་དགེ་སློབ་ཉིས་བརགྱ་ལྷག་འཛོམས་ཤིང་། འགྲན་ཞུགས་སློབ་མ་ལ་མཚོན་ནའང་བོད་ཡུལ་ཆོལ་ཁ་སོ་སོ་ནས་ཕེབས་པའི་སློབ་གྲོགས་ཉི་ཤུ་ལྷག་ཞུགས་འདུག ཁོང་ཚོའི་དབུས་གཙང་ཡུལ་སྐད་ཀྱི་སགྲ་གདངས་རྨང་གཞི་བྱས་ཤིང་། ཡིག་སྐད་ཀྱི་ཐ་སྙད་བེད་སྤྱོད་གཏོང་བའི་རྩ་དོན་གཞིར་བཟུང་ནས་གྲྭ་དང་ཟུར་མི་འདྲ་བ་ནས་རང་ཅག་བོད་ལ་སྤྱི་སྐད་ཅིག་དགོས་པའི་གལ་ཆེན་རང་བཞིན་དང། སྤྱི་སྐད་ཇི་ལྟར་ཁྱབ་བརྡལ་དུ་གཏོང་བའི་ཚུལ། ན་གཞོན་གསར་བ་ཞིག་ལ་འཛོམས་དགོས་པའི་སྙིང་སྟོབས་སོགས་རྗོད་གཞི་མི་འདྲ་རེ་རེ་རང་རང་་སོ་སོའི་རིག་པའི་རྩལ་དུ་བཏོན་ནས་གཏམ་བཤད་ཤིན་ཏུ་རྨད་པ་མང་དུ་སྤེལ་བྱུང་ལ། འདི་དག་ལས་ཕ་ཡུལ་མདོ་སྨད་གཅན་ཚ་ནས་ཡིན་པའི་༠༩ལོའི་སྐད་ཡིག་རྩོམ་རིག་འཛིན་གྲྭའི་སློབ་གྲོགས་ལྷ་མགོན་ལགས་ཀྱི་༼སོ་སོ་རང་ཉིད་ནས་འགོ་རྩོམས་པར་གྱིས༽ཞེས་པའི་གཏམ་བཤད་ལ་བྱ་དགའ་ཨང་དང་པོ་འཐོབ་པ་དང་། ཕ་ཡུལ་ཀན་ལྷོ་ཇོ་ནེ་ཡིན་པའི་སློབ་གྲོགས་བསྟན་འཛིན་རགྱ་མཚོ་ལགས་ཀྱི་༼ཞིབ་འཇུག་གླིང་གི་ཞིབ་འཇུག༽ཅེས་པར་བྱ་དགའ་གཉིས་པ། ཕ་ཡུལ་ནགས་ཆུ་ནས་ཡིན་པའི་སློབ་གྲོགས་བློ་བཟངཀུན་མཁྱེན་ལགས་ཀྱི་༼རང་དང་འབྲེལ་བའི་གཏམ་རགྱུད་ཁག་བཞི༽ ཞེས་པར་ཡང་བྱ་དགའ་ཨང་གཉིས་པ་དང་། གཞན་ཕ་ཡུལ་མདོ་ཁམས་དཀར་མཛེས་ནས་ཡིན་པའི་སློབ་གྲོགས་སགྲོལ་མ་ཆོས་སྐྱིད་ཀྱི་༼རྫུན་ལ་དགའ་བའི་ང་ཚོ་༽དང་སློབ་གྲོགས་མང་མཚོའི༼སྤྱི་སྐད་སྐོར་གྱི་གལ་ཆེན་རང་བཞིན༽ཕ་ཡུལ་མདོ་སྨད་ཀན་ལྷོ་གཙོས་ནས་ཡིན་པའི་སློབ་གྲོགས་སངས་རགྱས་ཚེ་རིང་གི་༼དྲ་ནང་གི་བོད་པ་༽ཞེས་པ་གསུམ་ལ་བྱ་དགའ་ཨང་གསུམ་པ་འཐོབ་པ་དང་། ད་དུང་ད་ལོ་ཀ་ཁ་འཛིན་གྲྭའི་རགྱ་རིགས་སློབ་གྲོགས་ཡང་ཡས་དང་སོ་ཅ་ཆའི་གཉིས་ལ་ཕུལ་བྱུང་གི་བྱ་དགའ་གནང་ནས། ཐུན་མོང་ཞིག་གི་སླད་དུ་རང་ཉིད་ནས་འགོ་བརྩམ་འོས་པར་འདོད་པའི་དོན་སྙིང་གི་བརྟས་པའི་གཏམ་བཤད་ཚོགས་འདུ་འདི་བདེ་ལེགས་ངང་ནས་གྲོལ།&#xD;
མཚོ་སྔོན་རླུང་འཕྲིན་ཁང་གི་མགོ་འཛིན་པ་ཡོངས་དང་ནང་སགོས་སུ་སློབ་རྭའི་འགྱུར་ཁུགས་ཀྱི་མགོ་འཛིན་པ་ཨ་ཅེ་སགྲོལ་མ་ཁྱེད་རྣམ་པའི་སྐུ་ཁམས་བདེ་མོ།&#xD;
ཕྲན་གྱི་མིང་ལ་རྡོ་རྗེ་ཟེར་ཞིང་ཕ་ཡུལ་མདོ་སྨད་རྫོང་ཁམས་བཅོ་བརགྱད་ཀྱི་ཡ་གྱལ་གནམ་རྫོང་ཕྱུགས་མོའི་ཉེ་འགྲམ་དུ་འཚེར་ལོངས་བྱུང་།ད་ལྟ་ཕ་ཡུལ་གཅན་ཚ་ཕྱུགས་མོ་ན་དགེ་མིང་འཛིན་པ་ཞིག་གི་ལས་གནས་ལ་འགྱི་བཞིན་མི་རིགས་ཀྱི་རྐང་འཛིན་པ་སྐོར་ཞིག་ལ་རང་ནུས་ཅི་ལྕོགས་ཀྱི་འབད་པ་གང་ལེགས་བྱེད་བཞིན་ཡོད།ཡིན་ཏེ།ད་ལྟ་དགུན་གནངས་གཏོར་ལ་ཉེ་སྟེ་ཁོ་ཚོས་སློབ་སྐབས་ཤིག་གི་སྦྱངས་འབྲས་རྣམ་འཁྱེར་ཏེ་ཁྱིམ་མི་དང་གཉེན་ཉེ་རྣམ་ལ་འབུལ་སྤྲོད་བྱེད་དུ་འགྲོ་དགོས་པས།ཁོ་ཚོས་ཁྱིམ་མི་རྣམས་ཀྱི་བསྟོད་པའི་མཐེ་བོང་ཤིག་ཐོབ་ཕྱིར་ཁྱེད་མགོ་འཛིན་པའི་ངའི་སློབ་མ་རྣམ་ལ་གླུ་བ་བློ་བཟང་གི་བླངས་བས་བོད་རིགས་སྤུན་ཟླ་ཞེས་བ་དེ་འཕུལ་བར་སྙིང་ཁུངས་ནས་བཀའ་དྲིན་ཆེ་ཞུ་བ་ཡིན། རེ་སྨོན་དང་ཡིད་ཆེས་ཁྲི་ཕྲག་གི་ཀློང་ན་མི་ཚེ་འོད་དུ་སགྲོན་བཞིན་པའི་སློབ་རའི་འགྱུར་ཁུགས་ཀྱི་ལས་བྱེད་ཚོ་ཉེ་ལམ་བདེ་མོ་ཡིན་ན།&#xD;
ཐེངས་འདིར་ཁྱེད་ཅག་གི་བཀོད་སགྲིག་བྱས་པའི་ལག་སྐྱེས་དེ་ཐོག་མར་བདག་གི་རགྱང་ཐག་རིང་བའི་ཕ་ཡུལ་སོག་རྫོང་ན་བཞུགས་པའི་དྲིན་ཆེན་གྱི་ཕ་མ་གཉིས་གཙོ་བྱས་པའི་ཤ་མི་ཉེ་འབྲེལ་ཡོངས་ཀྱི་ཅི་བསམ་ལྷུན་གྱིས་འགྲུབ་པ་དང་ནད་མེད་ཚེ་རིང་ཡོང་བའི་བཀྲིས་སྨོན་འདུན་དང་ཆབ་གཅིག མོས་མཐུན་གྱི་གྲོགས་དང་གྲོགས་མོ་ཚོར་ལྷད་མེད་ཁ་ཏགས་ཤིག་གི་ཚུལ་དུ་ཕུལ་བ་ལགས། མཚུངས་སུ་ཁྱེད་བརྙན་རླུང་འཕྲིན་ཁང་གི་ལས་བྱེད་ཚོའི་ཕ་སྐད་གཙང་མའི་བཞུར་རགྱུན་རྨ་ཆུའི་སྔོན་མོའི་ཀློང་དང་བསྡོང་ཐུབ་པའི་བཀྲིས་སྨོན་འདུན་སྙིང་ནས་ཞུ། བཀྲིས་བདེ་ལེགས། རིག་པ་བར་སྣང་གློག་ལས་མྱུར་ཞིང་བརྩོན་པ་ཆུ་བོ་རགྱུན་ལས་རིང་བས་སློབ་རའི་འགྱུར་ཁུགས་ཀྱི་འགོ་འཛིན་པ་&#xD;
ལགས།ཉེ་ལམ་སྐུ་བདེ་འམ། ང་ནི་རེབ་གོང་རིག་པ་འབྱུང་བའི་གྲོང་ཁྱེར་གི་ཡིན་ལ་ངའི་མིང་ལ་སྙན་སྐྱེས ་ཟེར།ངས་བོད་ཆོལ་ཁ་གསུམ་གྱིས་བྱ་བ་ལམ་འགྲོ་དང་ནང་སགོས་སུ་བདག་གི་གྲོགས་པོ་རིག་འཛིན་རྡོ་རྗེ་ལགས་ཀྱི་བྱ་བ་ཐམས་བཅད་ཡར་ངོས་ཟླ་ལྟར་འཕེལ་བའི་སྨོན་འདུན་དུ་གླུ་དང་རྡུང་ལེན་གང་རུང་ཞིག་འཕུལ་བ་ཡིན་པས་མདོ་འཛིན་པས་བཀོད་སགྲིག་བྱེད་རགྱུ་མཁྱེན་མཁྱེན།&#xD;
བྱ་བཞག་དབྱར་མཚོ་བཞིན་རགྱས་པར་སྨོན། དེང་སྐབས་འུ་ཚོར་ཕྲད་དང་འཕྲད་ཀྱིན་ཡོད་པ་ནི་ནང་གི་བསམ་བློའི་འགྱུར་ལྡོག་དང་ཕྱིའི་ཁྲ་ཁྲ་རིག་རིག་གིའགྱུར་ལྡོག་གཉིས་ལས་&#xD;
མ་འདས། དེ་བས། ང་ཚོས་རང་ལ་སྔར་ནས་ཡོད་པའི་སྲོལ་རགྱུན་གྱི་ཡོ་བྱད་འཛད་མཐའ་མེད་པ་ཞིག་བོར་ཟིན་ལ། ད་ལྟའང་འབོར་&#xD;
བཞིན་འདུག ཕྱིས་ཀྱང་བོར་ངོས་ཡིན་པར་བསམ་ན་ཇི་འདྲའི་ཕངས་པ་ལའང། སྐབས་འདིར། མཚོ་སྔོན་བོད་སྐད་ རླུང་འཕྲིན་གྱི་གསར་འགོད་པས་མཚོ་ལྷོ་ཁུལ་ཐུན་ཏེ་རྫོང་གོང་མ་བཅའ་སྡོད་སློབ་གྲྭའི་ལག་བཟོ་བ་སྟེ་སློབ་མ་རྣམས་དང་ ཁྱིམ་བདག་ལ་ཡུལ་དངོས་ནས་བཅར་འདྲི་བྱས་ཏེ་ཁོ་ཚོས་རང་གི་སྲོལ་རགྱུན་གྱི་ཐོནརྫས་མོད་པོ་ཞིག་རགྱུན་འཛིན་དང་ཏར་སྤེལ་ གཏོང་བར་རམ་འདེགས་བླ་མེད་གནང་བ་ལ་བཀའ་དྲིན་ཆེ་ཞུས་བ་ཡིན།&#xD;
ཨ་སྐལ་རགྱམ་གྱིས་ཕུལ།</content>
<column>-གཙོ་ངོས།-སྐད་འཇོག་དྲ་ངོས།-སློབ་རའི་འགྱུར་ཁུགས།</column>
</file>
 * 
 */
