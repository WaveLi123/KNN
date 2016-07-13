package mainpkg;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;



  /**
  *  Class Name: Logger.java
  *  Function:日志信息
  *  
  *  Modifications:   
  *  
  *  @author xy  DateTime 2012-4-25 上午11:10:08    
  *  @version 1.0 
  */
public class Logger 
{
	public static void append(String fileString) 
	{
		String filenameString=new String("systemlogger.log");
        Date time=new Date();
        fileString=fileString+"\t"+"["+time.toString()+"]\r\n";
        try 
        {
			FileOutputStream outputStream=new FileOutputStream(new File(filenameString),true);
			byte[] b=fileString.getBytes();
			outputStream.write(b);
		}
        catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

}
