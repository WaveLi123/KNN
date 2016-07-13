package mainpkg;
import java.util.HashMap;

//import com.sun.org.apache.bcel.internal.verifier.exc.StaticCodeConstraintException;

  /**
  *  Class Name: Globdata.java
  *  Function:词典和配置文件的全局存储类，在init函数初始化
  *  
  *     Modifications:   
  *  
  *  @author xy  DateTime 2012-4-25 上午11:07:52    
  *  @version 1.0 
  */
public class Globdata 
{
	public static  HashMap<String, String> wordgezhuciDic = new HashMap<String, String>();
	public static  HashMap<String, String> gezhuciDic = new HashMap<String, String>();
	public static  HashMap<String, String> wordFrequencyDic = new HashMap<String, String>();
	public static  HashMap<String, String> singleword = new HashMap<String, String>();
	public static  HashMap<String, String> numberDic = new HashMap<String, String>();
	public static  HashMap<String, String> wordDic = new HashMap<String, String>();
	public static  HashMap<String, String> hjzDic = new HashMap<String, String>();
	public static  HashMap<String, String> NameDict = new HashMap<String,String>();
	public static  HashMap<String, String> namefeature = new HashMap<String,String>();
	public static  HashMap<String, String> name_translated = new HashMap<String,String>();
	public static  HashMap<String, String> name_high_freq = new HashMap<String,String>();
	public static  HashMap<String, String> name_ancient = new HashMap<String,String>();
	public static  HashMap<String, String> name_shot = new HashMap<String,String>();
	public static  HashMap<String, String> nameDict2 = new HashMap<String,String>();
	public static  HashMap<String, String> address = new HashMap<String, String>();
	public static  HashMap<String, String> placedic = new HashMap<String,String>();
	public static  HashMap<String, String> institution = new HashMap<String,String>();
	public static String posDic = null;

	//**********2012/11/1**************
	public static String[] numbersymbol = null;//数字标识符
	//**********2012/11/1**************
	//***********************basic word,上加，元音***********//
	public static  String[] jizi = null;
	public static  String[] shangjia = null;
	public static  String[] yuanyin = null;
	public static  String[] qianjia = null;
	public static String sgzc = null;
	public static String sgzcbh = null;
	//***********************basic word,上加，元音***********//
	public static  String[] sentensymbol = null;//断句标示符
	public static String unicodepoint = null;//藏语音节点
	public static String unicodegzc = null;//遇到就切分的格助词典
	public static String unicodegzc2 = null;//大多数情况切分的格助词典
	public static String unicodegzc3 = null;//句末才切分的格助词词典
	public static String unicodegzc4 = null;//段末切分的格助词词典	
	public static String unicodehjz = null;
	public static String jsg = null;
	public static String line = null;//分行标识
	public static String point = null;
	
	public static int name_found_total = 0;
	public static String fenciString = "";
	public static String and="";
	//记录文件选择器的默认存储路径
	public static String path = "E:\\研究生工作\\王志娟老师分词\\result";
	
	//以为内容为2012/10/30日添加，是为了提取语料用的
	
	public static String book_content = null;
}
