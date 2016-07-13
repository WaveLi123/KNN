package crawler4j;

import chinaSiteParse.Httpnews163com;
import chinaSiteParse.HttpnewsxinhuanetcomParse;
import koreanSiteParse.KrpeoplecomcnParse;
import koreanSiteParse.WwwhljxinwencnParse;
import koreanSiteParse.WwwiybrbcomParse;
import tibetanSiteParse.Httptibetpeoplecomcn;
import tibetanSiteParse.Httptitibetcn;
import tibetanSiteParse.WwwxhskxcomParse;
import tibetanSiteParse.XizangnewscnParse;
import uyghurSiteParse.Httpuyghurpeoplecomcn;
import uyghurSiteParse.UyghurnewscnParse;
import uyghurSiteParse.WwwmirxapcomParse;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class Controller {
    public static void main(String[] args) throws Exception {
            String crawlStorageFolder = "/data/crawl/root111";
            //定义爬虫数量
            int numberOfCrawlers = 1;

            //创建爬虫的配置对象
            CrawlConfig config = new CrawlConfig();
            //设置爬虫存储的文件
            config.setCrawlStorageFolder(crawlStorageFolder);

            /*
             * Instantiate the controller for this crawl.
             * 实例化爬虫的控制器
             */
            //创建PageFetcher（页面访问者对象），并传入配置信息
            PageFetcher pageFetcher = new PageFetcher(config);
            //创建Robotstxt对象 分别设置Robotstxt配置对象和Robotstxt服务器对象
            RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
            RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
            //初始化爬虫控制器 并传入配置文件对象，页面访问者对象和Robotstxt服务器对象
            CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

            /*
             * For each crawl, you need to add some seed urls. These are the first
             * URLs that are fetched and then the crawler starts following links
             * which are found in these pages
             * 需要向服务器添加一些种子url，用于爬虫的初始爬去页面
             * 这里设置了3个url 分别都是维基百科的1藏文阿里地区；2可能是通用藏文；3藏文另一个url
             */
            
           // controller.addSeed("http://ti.tibet3.com/culture/2014-03/17/content_489760.htm");
          //  controller.addSeed("http://ti.tibet3.com");
            
            
            

            //朝文站点  http://kr.people.com.cn 爬去人民网朝语版            
            controller.addSeed("http://kr.people.com.cn");                                         
             // 开始爬取数据，会阻塞当前线程。知道爬虫线程的任务完成才执行最后一句             
              KrpeoplecomcnParse kp =new  KrpeoplecomcnParse();
            controller.start(KrpeoplecomcnParse.class, numberOfCrawlers);
            System.out.println("人民网朝语版：kr.people.com.cn crawling process has been finished!!!");
//            
//              
              //朝文站点  http://www.hljxinwen.cn/ 黑龙江新闻朝语版
//            controller.addSeed("http://www.hljxinwen.cn");                            
//		      //开始爬取数据，会阻塞当前线程。知道爬虫线程的任务完成才执行最后一句             
//            WwwhljxinwencnParse kp =new  WwwhljxinwencnParse();
//            controller.start(WwwhljxinwencnParse.class, numberOfCrawlers);            
//            System.out.println("黑龙江新闻朝语版：www.hljxinwen.cn crawling process has been finished!!!");
//                        
                
         	//朝文站点  http://www.iybrb.com/ 延边网朝语版             
//            controller.addSeed("http://www.iybrb.com/news_vew.aspx?id=30497"); 
//            // 开始爬取数据，会阻塞当前线程。知道爬虫线程的任务完成才执行最后一句             
//            WwwiybrbcomParse kp =new  WwwiybrbcomParse();
//            controller.start(WwwiybrbcomParse.class, numberOfCrawlers);            
//            System.out.println("延边网朝语版：http://www.iybrb.com crawling process has been finished!!!");
            
            
            //added by jkd,27th Oct in 2014
         //Tibetan Sites Test 
            //1
//            controller.addSeed("http://www.xhskx.com/");
//            controller.start(WwwxhskxcomParse.class, numberOfCrawlers);
//            System.out.println("Succeed!\n");
            //2
//            controller.addSeed("http://xizang.news.cn");            
//            controller.start(XizangnewscnParse.class, numberOfCrawlers);
//            System.out.println("Succeed!\n");
            //3
//	          controller.addSeed("http://tibet.people.com.cn/");            
//	          controller.start(Httptibetpeoplecomcn.class, numberOfCrawlers);
//	          System.out.println("Succeed!\n");
            //4
//	          controller.addSeed("http://ti.tibet.cn/");            
//	          controller.start(Httptitibetcn.class, numberOfCrawlers);
//	          System.out.println("Succeed!\n");
//	          
          //UyghurSite Sites Test
            //1
//            controller.addSeed("http://uyghur.news.cn");            
//            controller.start(UyghurnewscnParse.class, numberOfCrawlers);
//            System.out.println("Succeed!\n");
            //2
//            controller.addSeed("http://www.mirxap.com");
//            controller.start(WwwmirxapcomParse.class, numberOfCrawlers);
//            System.out.println("Succeed!\n");
            
            //3
//            controller.addSeed("http://uyghur.people.com.cn/");
//            controller.start(Httpuyghurpeoplecomcn.class, numberOfCrawlers);
//            System.out.println("Succeed!\n");
            //chinese news for course
            //1
//	          controller.addSeed("http://www.xinhuanet.com/");
//	          controller.start(HttpnewsxinhuanetcomParse.class, numberOfCrawlers);
//	          System.out.println("Succeed!\n");
            //2
//	          controller.addSeed("http://news.163.com/");
//	          controller.start(Httpnews163com.class, numberOfCrawlers);
//	          System.out.println("Succeed!\n");            
    }
}