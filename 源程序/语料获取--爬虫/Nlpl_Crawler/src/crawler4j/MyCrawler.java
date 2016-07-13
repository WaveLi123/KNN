package crawler4j;


import java.io.FileOutputStream;
//正则表达式的jar类
import java.util.regex.Pattern;

import languageXMLParse.XMLConverter;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;







import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;  
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MyCrawler extends WebCrawler {

    //设置pattern的正则表达式，用于筛选
	//正则表达式：
	//.*(\\.(css|js|bmp|gif|jpe?g：1 “.”表示：可以匹配除了换行符（\n）以外的任意一个字符。2*，让这种情况出现任意次。3  ？前面的e出现0次或者1次 再加G，$指以（）内那堆东西结尾。
	//\\.  先转移一个\ 后面跟任意 除了换行符（\n）以外的任意一个字符，然后是css js等格式的字符。
	private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|bmp|gif|jpe?g" 
                                                      + "|png|tiff?|mid|mp2|mp3|mp4"
                                                      + "|wav|avi|mov|mpeg|ram|m4v|pdf" 
                                                      + "|rm|smil|wmv|swf|wma|zip|rar|gz))$");

    
    //url 的前缀规则 其中bo是藏文的维基百科
   // private final static String URL_PREFIX = "http://ti.tibet3.com/";
	
	//朝文站点前缀
	private final static String URL_PREFIX = "http://kr.people.com.cn/";
	
	
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
                    Elements contents_html = doc.select(".wb_1");
                    if(!contents_html.isEmpty()){
                    //正文部分内容
                    String content = contents_html.select("p").text();
                    //标题部分
                    String title =doc.select("h1").text();
                    //发布时间
                    String timeofpublish =doc.select("#p_publishtime").text();
                    // 本url域名地址
                    String domainname =templateUrl;
                    //提供网站地址 
                    String provider= URL_PREFIX;
                    //作者
                    String author=doc.select(".wb_2").text();;
                    
                    System.out.println("第"+i+"条记录\n");
                    System.out.println("标题："+title+"\n");
                    System.out.println("作者："+author+"\n");
                    System.out.println("发布时间："+timeofpublish+"\n");
                    System.out.println("正文内容："+content+"\n");
                    System.out.println("本url域名地址："+domainname+"\n");
                    System.out.println("提供网站地址："+provider+"\n");
                    
                    i++;
                    
                    //添加附加信息
                    String chinesename="人民网朝语版";
                    String pinyin="rmwcyb";
                    String webencoding="utf-8";
                    String language="朝文";
                    String encodingtype="utf-8";
                    //转换成xml
                  XMLConverter xc=new  XMLConverter();
                    xc.ConvertToXML(title,author,timeofpublish,content,domainname,provider,chinesename,pinyin,webencoding,language,encodingtype);
                    
                    }
                    
                    
            }
            
            }catch(Exception e){
            	e.printStackTrace();
            }
    }
    
    
}                   
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                   /* //如果内容不为空
                    if(!contents2.isEmpty()){
                    //在该节点，内容选择器中选择出a元素中lang=zh的所有 元素中 属性为href，即超链接
                   //<li class="interlanguage-link interwiki-zh"><a href="//zh.wikipedia.org/wiki/%E4%B8%AD%E5%8D%8E%E4%BA%BA%E6%B0%91%E5%85%B1%E5%92%8C%E5%9B%BD" title="中华人民共和国 – རྒྱ་སྐད་" lang="zh" hreflang="zh">中文</a></li>
                   //里面是该网页的对照中文
                    String link = contents2.select("a[lang=zh]").attr("href");
                    String link1 = "http:"+link;
                    System.out.println("获取的对照中文的超链接地址："+link1);
                    
                    if (!link1.equals("http:")){
                    	//if(!link1.equals("http://zh.wikipedia.org/wiki/%E8%A5%BF%E8%97%8F%E5%8E%86%E5%8F%B2")){
                    	//	if(!link1.equals("http://zh.wikipedia.org/wiki/%E8%87%BA%E7%81%A3")){
                    	//在excel中被创建的表中再创建一列对象
                    	HSSFRow hssfrow = hssfsheet.createRow(i);
                    	//添加一个合并的区域（合并单元格），从（i，1）到（i，10）其实就是合并第一格到到第十格
                    	//再从从（i，12）到（i，21）其实就是合并第一格到到第十格
                    	hssfsheet.addMergedRegion(new Region(i,(short)1,i,(short)10));
                    	hssfsheet.addMergedRegion(new Region(i,(short)12,i,(short)21));
                    	
                    	//��ò���ʵ�����
                    	//获取body主要内容中的：藏文node 元素 <div id="content" class="mw-body" role="main">
                        Elements contents = doc.select("div.mw-body"); 
                        if(!contents.isEmpty()){
                        	//获取第一标题的元素数组中的第一个 然后取出里面内容 string类型
                            String title = contents.select("h1").first().text();
                            //在第i行中创建单元格（第0号单元格），把title里面的字符塞进去。 
                            hssfrow.createCell((short)0).setCellValue(title);
                            System.out.println("第"+i+"行，第0个单元格元素为藏文标题："+title);
                            
                            
                          //p元素为段落 里面内容为藏文文本类容，把所有藏文内容都合并到一起，转换成string
                            String text1 = contents.select("p").text(); 
                          //  String newText1 = new String(text1.getBytes(), "UTF-8"); 
                           //如果不超过3万字
                            if(text1.length()<30000)
                            //创建一个单元格（编号为1），把内容放进去，这其实是藏文的段内内容
                            hssfrow.createCell((short)1).setCellValue(text1);
                            System.out.println("藏语内容："+text1);
                            System.out.println("共有 "+text1.length()+"字");
                            
                        }
                        
                        
                        
                    	
                    	//获取汉语内容部分
                        //通过jsoup开源工具，连接link1（之前获取的对应汉文的链接），设置超时时间为10秒，通过提供的URL，执行xhrget，然后返回结果并解析
                		Document doc1 = Jsoup.connect(link1).timeout(10000).get();
                		
                		//<div id="content" class="mw-body" role="main">  根据选择器 在html获取对应元素
                    	Elements contents1 = doc1.select("div.mw-body");  
                    	//如果内容不为空
                    	if(!contents1.isEmpty()){
                    	//首先获取标题部分的内容
                        String title1 = contents1.select("h1").first().text();
                        //创建一个单元格放汉文 string类型的标题
                        hssfrow.createCell((short)11).setCellValue(title1);
                        
                        System.out.println("第"+i+"行，第11个单元格元素为汉文标题："+title1);
                    	
                    	
                        //��ú�������
                        System.out.println("11111111111111��                     "+contents1.size());
                        //整合内容中的各个段落
                        String text2 = contents1.select("p").text();
                        if(text2.length()<30000)
                        //把内容的全部放入excel的第十二个（已经合并过）的单元格中
                        hssfrow.createCell((short)12).setCellValue(text2);
                        
                        System.out.println("汉语内容："+text2);
                        System.out.println("共有 "+text2.length()+"字");
                        
                    	
                    	}       		
                    	
                    	 System.out.println("---------------------"+"第"+i+"条记录完毕"+"-----------------------");	 
                    	 i++;  
                    		//}
                    	//}
                 }   
               } */


/**
 * xml格式样式：
 * <?xml version="1.0" encoding="UTF-8"?>
 *<file>
 *<domainname>http://www.qhtb.cn</domainname>
 *<chinesename>青海藏语广播网</chinesename>
 *<pinyin>qhzygbw</pinyin>
 *<webencoding>utf-8</webencoding>
 *<language>藏文</language>
 *<encodingtype>Himalaya</encodingtype>
 *<registrationnumber>默认</registrationnumber>
 *<provider>http://www.qhtb.cn</provider>
 *<corpustype>网络</corpustype>
 *<filename>0_qhzygbw_0_1_2012-02-06_24_1.xml</filename>
 *<title/><subtitle/>
 *<author>ཨ་སྐལ་རྒྱམ་གྱིས་ཕུལ།</author>
 *<timeofpublish>2012-02-06</timeofpublish>
 *<timeofdownload>2012-08-24</timeofdownload>
 *<url>C:\_webBug_Backup\藏文\qhtb.cn\2012\index172a.html</url>
 *<clicktimes>0</clicktimes>
 *<codeofclassification>0</codeofclassification>
 *<nameofclassification>无类</nameofclassification>
 *<methodofclassification>无法分类</methodofclassification>
 *<keywordsofclassification/>
 *<content> ན་བཀའ་དྲིན་ཆེ། ས་མཐོའི་རི་ཀློང་འདི་ཡི་བར་ཐག་ལ་བཀའ་དྲིན་ཆེ་ཞུས་བ་ཡིན། ཨ་སྐལ་རགྱམ་གྱིས་ཕུལ།</content>
 *<column>-གཙོ་ངོས།-སྐད་འཇོག་དྲ་ངོས།-སློབ་རའི་འགྱུར་ཁུགས།</column>
 *</file>
 * 
 * 
 */

