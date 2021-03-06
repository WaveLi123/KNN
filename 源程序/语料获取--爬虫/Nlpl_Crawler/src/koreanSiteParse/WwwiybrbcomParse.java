package koreanSiteParse;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
//正则表达式的jar类
import java.util.regex.Pattern;













import languageXMLParse.ImageStorage;
import languageXMLParse.XMLConverter;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WwwiybrbcomParse extends WebCrawler {

    //设置pattern的正则表达式，用于筛选
	//正则表达式：
	//.*(\\.(css|js|bmp|gif|jpe?g：1 “.”表示：可以匹配除了换行符（\n）以外的任意一个字符。2*，让这种情况出现任意次。3  ？前面的e出现0次或者1次 再加G，$指以（）内那堆东西结尾。
	//\\.  先转移一个\ 后面跟任意 除了换行符（\n）以外的任意一个字符，然后是css js等格式的字符。
	private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|bmp|gif|jpe?g" 
                                                      + "|png|tiff?|mid|mp2|mp3|mp4"
                                                      + "|wav|avi|mov|mpeg|ram|m4v|pdf" 
                                                      + "|rm|smil|wmv|swf|wma|zip|rar|gz))$");
	//获取图片的pattern（正则表达式规则）
	private static final Pattern imgPatterns = Pattern.compile(".*(\\.(bmp|gif|jpe?g|png|tiff?))$");

    
    //url 的前缀规则 其中bo是藏文的维基百科
   // private final static String URL_PREFIX = "http://ti.tibet3.com/";
	
	//朝文站点前缀
	private final static String URL_PREFIX = "http://www.iybrb.com";
	
	
	public String templateUrl=" ";
	
	
    
    int i = 0;
   
    
    /**
     * You should implement this function to specify whether
     * the given url should be crawled or not (based on your
     * crawling logic).
     * 下面的代码用于设置爬去逻辑。限制 哪些url可以访问哪些不可以。
     */
    @Override
    public boolean shouldVisit(WebURL url) {
    	    //把url字符串变成全小写的
            String href = url.getURL().toLowerCase();
            //如果FILTERS完全满足匹配（如css，js之类的后缀的都不要的） 或者 不是以URL_PREFIX指定量开始的 则返回false
            if (FILTERS.matcher(href).matches() || !href.startsWith(URL_PREFIX)) {  
                return false;  
            }                 
             //否则返回true
            templateUrl=href;
            return true;  
           
    }

    /**
     * This function is called when a page is fetched and ready 
     * to be processed by your program.
     * 当页面获取抓取后 执行visit 方法
     * 
     * @param Page的实例对象
     */
    @SuppressWarnings("deprecation")
	@Override
    public void visit(Page page) {   
    	

            try{
            	//获取解析后的数据 如果是HtmlParseData实例
            if (page.getParseData() instanceof HtmlParseData) {
            	   //则把page对象解析出来的数据强制转换为htmlparsedata
                    HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
                    //把htmlParseData对象中的html取出来
                    String html = htmlParseData.getHtml();
                    //jsoup把html 解析成document节点类型的 通过html中包含的标签识别（HTML including a <base href> tag）
                    Document doc = Jsoup.parse(html);
                                        
                    
                   
                    //在html文件中通过元素选择取得node节点(html元素对象)
                    //contents_html 获取朝文正文所在div，并合并各段落
                    Elements contents_html = doc.select("body");
                    if(!contents_html.isEmpty()){
                    //正文部分内容
                    String content = doc.select(".f31 p").text();
                    //标题部分
                    String title =doc.select(".f29").text();
                    //发布时间 从对应html节点中获取字符串，然后截取获取需要的字符
                    String timeofpublish =doc.select(".f30").text();
                   // System.out.println("test:"+timeofpublish.isEmpty()+"\n");
                  //  System.out.println("test:"+timeofpublish);
                   /* if(timeofpublish.isEmpty()){                   
                    timeofpublish="0000-00-00 00:00:00";
                    }*/
                    if(!timeofpublish.contains("-"))
                    	//一些网页无法获取日期则用全0取代
                    	{timeofpublish="2014-00-00 00:00:00";}
                    timeofpublish=timeofpublish.substring(timeofpublish.lastIndexOf("-")-6,timeofpublish.lastIndexOf(":")+2);
                    // 本url域名地址
                    String domainname =templateUrl;
                    //提供网站地址 
                    String provider= URL_PREFIX;
                    //作者
                    String author="";
                  /*  if(!doc.select(".f300").isEmpty())
	                    {	
                    	System.out.println("11"+doc.select(".f300"));
                    	author=doc.select(".f300").text();
	                    }*/
                    System.out.println("第"+i+"条记录\n");
                    System.out.println("标题："+title+"\n");
                    System.out.println("作者："+author+"\n");
                    System.out.println("发布时间："+timeofpublish+"\n");
                    System.out.println("正文内容："+content+"\n");
                    System.out.println("本url域名地址："+domainname+"\n");
                    System.out.println("提供网站地址："+provider+"\n");
                    
                    i++;
                    
                    //获取的发布时间并转换成simpleDataFormat格式                     
                    //模版 09:38, September 19, 2014，里面存在英文所以要locale 英文
                    
                    
                    String publishtimeFormation="yyyy-MM-dd HH:mm:ss";
                    SimpleDateFormat dfpt = new SimpleDateFormat(publishtimeFormation);//设置日期格式
                    Date dateOfPublish=dfpt.parse(timeofpublish);
                  System.out.println("获取格式检查"+dateOfPublish+"\n");
                    
                    
                    
                    
                    //下载时间                      
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//设置日期格式
       				//System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
       				String timeofdownload=df.format(new Date()).toString();
       			  //添加附加信息
                    String chinesename="延边网朝语版";
                    String pinyin="ybwcyb";
                    String webencoding="utf-8";
                    String language="朝文";
                    String encodingtype="utf-8";
                    
                    
                    //保存图片模块
                    //http://kr.people.com.cn/NMediaFile/2014/0917/FOREIGN201409170910000504682411330.jpg
                   
                    //获取图片对应url地址
                    Elements E_image=doc.select("table tbody img[onload]");
                    
                    //创建list方便动态分配内存，添加条目 ，这里用于保存图片的url
                    ArrayList<String> imageUrls=new ArrayList<String>();
                 
                    //把迭代器it 放在获取element集合上
                    Iterator<Element> it=E_image.iterator();
                    //如果集合迭代指针所在位置后面还有元素                   
                    for(int j=0;it.hasNext();j++)
                    
	                  //  if(it.hasNext())
	                    {
	                    	//获取图片图片所在url并拼接上域名前缀
	                    //System.out.println("aaa"+it.next().attr("src"));
	                    String imageAdress=URL_PREFIX+"//"+it.next().attr("src");
	                   // System.out.println(imageAdress);	                    
	                    //获取扩展名
	                    String extension = imageAdress.substring(imageAdress.lastIndexOf("."));	                    
	                    //定义唯一图片存储名:网站拼音+1700以后的long数+数量+扩展名
	                    String imageFileName = pinyin + dateOfPublish.getTime() +"number"+j+ extension;
	                    //存储路径连接上图片url
	                    String path="D:\\XHSDATA\\"+language+"\\"+chinesename+"\\"+(dateOfPublish.getYear()+1900)+"\\"+(dateOfPublish.getMonth()+1)+"\\"+dateOfPublish.getDate();
	                          String pathAndimageFileName=path+"\\"+imageFileName;

	                        // 创建 多层目录 
	                           File fp = new File(path);  	                          
	                          if (!fp.exists()) {  
	                               fp.mkdirs();// 目录不存在的情况下，创建目录。  
	                            }  
	                        //   System.out.println("执行结束"+path);  
	                         

	                   // System.out.println("D:\\\\XHSDATA\\ImageFile\\"+imageFileName);                    
	                    //把图片保存进集合中
	                    imageUrls.add(pathAndimageFileName);	                    
	                    //创建图片存储对象，上框架后改用工厂方式	                 
	                   ImageStorage.saveUrlFile(imageAdress, pathAndimageFileName); 
	                    
	                    }
	                    
                    
                    //转换成xml，上框架后改用工厂方式
                    XMLConverter xc=new  XMLConverter();
                    xc.ConvertToXML(title,author,timeofpublish,content,domainname,provider,chinesename,pinyin,webencoding,language,encodingtype,timeofdownload,imageUrls,publishtimeFormation);
                    
                    }
                    
                    
            }
            
            }catch(Exception e){
            	e.printStackTrace();
            }
    }
    
    
    
    
    
    
    
    
    
}  



