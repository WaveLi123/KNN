package mainpkg;
import java.util.HashMap;

//import com.sun.org.apache.bcel.internal.verifier.exc.StaticCodeConstraintException;

  /**
  *  Class Name: Globdata.java
  *  Function:�ʵ�������ļ���ȫ�ִ洢�࣬��init������ʼ��
  *  
  *     Modifications:   
  *  
  *  @author xy  DateTime 2012-4-25 ����11:07:52    
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
	public static String[] numbersymbol = null;//���ֱ�ʶ��
	//**********2012/11/1**************
	//***********************basic word,�ϼӣ�Ԫ��***********//
	public static  String[] jizi = null;
	public static  String[] shangjia = null;
	public static  String[] yuanyin = null;
	public static  String[] qianjia = null;
	public static String sgzc = null;
	public static String sgzcbh = null;
	//***********************basic word,�ϼӣ�Ԫ��***********//
	public static  String[] sentensymbol = null;//�Ͼ��ʾ��
	public static String unicodepoint = null;//�������ڵ�
	public static String unicodegzc = null;//�������зֵĸ����ʵ�
	public static String unicodegzc2 = null;//���������зֵĸ����ʵ�
	public static String unicodegzc3 = null;//��ĩ���зֵĸ����ʴʵ�
	public static String unicodegzc4 = null;//��ĩ�зֵĸ����ʴʵ�	
	public static String unicodehjz = null;
	public static String jsg = null;
	public static String line = null;//���б�ʶ
	public static String point = null;
	
	public static int name_found_total = 0;
	public static String fenciString = "";
	public static String and="";
	//��¼�ļ�ѡ������Ĭ�ϴ洢·��
	public static String path = "E:\\�о�������\\��־����ʦ�ִ�\\result";
	
	//��Ϊ����Ϊ2012/10/30����ӣ���Ϊ����ȡ�����õ�
	
	public static String book_content = null;
}
