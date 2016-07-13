package languageXMLParse;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageStorage {

	//获取网络文件，转存到fileDes中，fileDes需要带文件后缀名  
    public static void saveUrlFile(String fileUrl,String fileDes) throws Exception  
    {  
        File toFile = new File(fileDes);  
        if (toFile.exists())  
        {  
//          throw new Exception("file exist");  
            return;  
        }  
        toFile.createNewFile();   
        FileOutputStream outImgStream = new FileOutputStream(toFile);  
        outImgStream.write(getUrlFileData(fileUrl));  
        outImgStream.close();  
    }  
      
    //获取链接地址文件的byte数据  
    public static byte[] getUrlFileData(String fileUrl) throws Exception  
    {  
        URL url = new URL(fileUrl);  
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();  
        httpConn.connect();  
        InputStream cin = httpConn.getInputStream();  
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
        byte[] buffer = new byte[1024];  
        int len = 0;  
        while ((len = cin.read(buffer)) != -1) {  
            outStream.write(buffer, 0, len);  
        }  
        cin.close();  
        byte[] fileData = outStream.toByteArray();  
        outStream.close();  
        return fileData;  
    }  
    
	
	
}
