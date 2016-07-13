package SwingPackage;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFrame;

import korean_cut.Text_Deal;
import Text_Analysis.Text_Analysis;
import Text_Analysis_2.Text_Participle_2;
import Text_Participle.Text_Participle;


class Corpus_DevListener implements ActionListener
{
	JPanel jplDisplay;
	JInternalFrame jifShow;//显示面板窗口
	JButton file_choose; 
	JPanel displayMid,displayDown;
	String filename = "";//结果路径
	//Management operate=null;
	public Corpus_DevListener(JPanel jpl)
	{
		this.jplDisplay=jpl;
	}
	public void actionPerformed(ActionEvent e)
	{
		jplDisplay.removeAll();
		
		//显示提示信息			
		boolean path_valid = false;		
		while(!path_valid){
			filename = JOptionPane.showInputDialog("请输入结果文件名(需要包括结果文件的路径)：","F:/Course/Npl/Results/");
			File infile = new File(filename);
			if(infile.isFile()||infile.isDirectory()){
				path_valid = true;
			}
			else{
				JOptionPane.showMessageDialog(jifShow, "您输入的路径错误,请重新输入！","警告", 1);
			}
		}
		
		jifShow=new JInternalFrame("设置文件路径面板",true,true,true);
		//顶层面板
		file_choose=new JButton("选择文件");
//		JLabel jTitle=new JLabel("选择文件");
//		jTitle.setFont(new Font("华文行楷", 2, 28));
//		jTitle.setForeground(Color.BLACK);
//		file_choose.add(jTitle);
		file_choose.setSize(2, 28);
		file_choose.setBackground(Color.GREEN);
		
		//右侧面板
		//用于选择产品类型的面板
		JPanel jplButton=new JPanel();
		jplButton.setBackground(new Color(250,250,240));
		String[] productName={"Word_Top20","Words_Cover80%","信息熵","困惑度"};
		
		final JComboBox productBox_1=new JComboBox();		//设置下拉菜单
		productBox_1.setModel(new DefaultComboBoxModel(productName));
		final JComboBox productBox_2=new JComboBox();		//设置下拉菜单
		productBox_2.setModel(new DefaultComboBoxModel(productName));
		final JComboBox productBox_3=new JComboBox();		//设置下拉菜单
		productBox_3.setModel(new DefaultComboBoxModel(productName));
		
		JLabel advise_1=new JLabel("字频处理");
		JLabel advise_2=new JLabel("词频处理_1");
		JLabel advise_3=new JLabel("词频处理_2");
		advise_1.setFont(new Font("华文行楷", 1, 25));
		advise_1.setForeground(Color.BLACK);
		advise_2.setFont(new Font("华文行楷", 1, 25));
		advise_2.setForeground(Color.BLACK);
		advise_3.setFont(new Font("华文行楷", 1, 25));
		advise_3.setForeground(Color.BLACK);
		jplButton.setLayout(new GridLayout(12,1));
		
		
		for(int i=0;i<12;i++)
		{
			switch(i)
			{
			case 0:jplButton.add(advise_1,BorderLayout.CENTER);break;
			case 1:jplButton.add(productBox_1,BorderLayout.CENTER);break;
			case 2:jplButton.add(advise_2,BorderLayout.CENTER);break;
			case 3:jplButton.add(productBox_2,BorderLayout.CENTER);break;
			case 4:jplButton.add(advise_3,BorderLayout.CENTER);break;
			case 5:jplButton.add(productBox_3,BorderLayout.CENTER);break;
			default:jplButton.add(new JLabel());
			}
		}
		jplButton.setVisible(true);
//		jifShow.add(jplButton,BorderLayout.LINE_END);
		
		//中间面板		
		displayMid=new JPanel();
				
		String name = "文件路径：";													
		JLabel temp_name = new JLabel(name);
		temp_name.setLocation(5, 0);
//		displayMid.add(temp_name);
		
		//构建文本信息输入框		
		final JTextField columnValue;	//存放对应的值
		columnValue = new JTextField(64);
		columnValue.setText("F:/Course/Npl/Resources");
		columnValue.setLocation(6, 0);
//		displayMid.add(columnValue);

		displayMid.setVisible(true);	//设置可见性
		jifShow.add(displayMid,BorderLayout.CENTER);
		jplDisplay.add(jifShow);		//添加对象		
		
		//构建文本信息输入框		
		final JTextArea textArea_O = new JTextArea(
                "Please wait......" 
        );
        textArea_O.setFont(new Font("Serif", Font.ITALIC, 16));
        textArea_O.setLineWrap(true);
        textArea_O.setWrapStyleWord(true);
        
        JScrollPane areaScrollPane_1 = new JScrollPane(textArea_O);
        areaScrollPane_1.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane_1.setPreferredSize(new Dimension(800, 400));
        areaScrollPane_1.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("结果信息"),
                                BorderFactory.createEmptyBorder(5,5,5,5)),
                areaScrollPane_1.getBorder()));
		displayMid.add(areaScrollPane_1,BorderLayout.CENTER);
		
		//底层面板		
		JButton jbStore=new JButton("确定");			//设置按钮
		JButton jbReset=new JButton("重置");
		JButton jbQuit=new JButton("处理");
		displayDown=new JPanel(new FlowLayout());
		displayDown.add(jbStore);
		displayDown.add(jbReset);
		displayDown.add(jbQuit);
		displayDown.setBackground(Color.BLACK);
		
		jifShow.add(file_choose,BorderLayout.NORTH);
		jifShow.add(displayDown,BorderLayout.SOUTH);
		jifShow.setVisible(true);
		jplDisplay.add(jifShow);
		
		
		//为jbQuit按钮添加监听器
		jbQuit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jifShow.dispose();
			}
		});
		//为jbReset按钮添加监听器
		jbReset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				columnValue.setText(null);
			}
		});
		//为jbStore按钮添加监听器
		jbStore.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String tableValue = new String(columnValue.getText());				
				JOptionPane.showMessageDialog(jifShow, "您的信息已保存，请在右侧选择相应处理","提示", 1);				
			}
		});
		
		//为选择的处理选项添加监听器
		productBox_1.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {	
				textArea_O.setText("Please wait ...");
				JOptionPane.showMessageDialog(jifShow, "请确认您输入的信息","提示", 1);
				
				String choice = productBox_1.getSelectedItem().toString();
				Text_Analysis ta = new Text_Analysis();
				//get the contents from the articles
				String t_string = ""; 
				File fileroot = new File(columnValue.getText());
				File files [] = fileroot.listFiles();
				System.out.println("files.length = "+files.length);
				for(File file : files){
					try {
						t_string += ta.text_parse(columnValue.getText()+"/"+file.getName());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}										
				//calculate				
				//test
				System.out.println("【Test】："+t_string);
				ta.C_vocabulary(t_string);
				//receive results
				String content = "";
				
				if(choice.equalsIgnoreCase("Word_Top20")){						
					//get top20 					
					content = ta.SelectSort(ta.vocabulary,(ta.vocabulary.size()-1),filename);					
					//show the results to users
					textArea_O.setText(content);					
				}
				if(choice.equalsIgnoreCase("Words_Cover80%")){
					//get 80%
					content = ta.R_80(ta.vocabulary,filename);
					//show the results to users
					textArea_O.setText(content);					
				}
				if(choice.equalsIgnoreCase("信息熵")){					
					//get 信息熵
					content = ta.C_comentropy(ta.vocabulary,filename);					
					//show the results to users
					textArea_O.setText(content);					
				}
				if(choice.equalsIgnoreCase("困惑度")){									
					//get 困惑度							
					content = ta.Cpp_q(ta.vocabulary,filename);
					//show the results to users
					textArea_O.setText(content);					
				}
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			
		});
		
		productBox_2.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea_O.setText("Please wait ...");
				JOptionPane.showMessageDialog(jifShow, "请确认您输入的信息","提示", 1);
				
				String choice = productBox_1.getSelectedItem().toString();
				Text_Participle ta = new Text_Participle();
				//get the contents from the articles
				String t_string = ""; 
				File fileroot = new File(columnValue.getText());
				File files [] = fileroot.listFiles();
				System.out.println("files.length = "+files.length);
				for(File file : files){
					try {
						t_string += ta.text_parse(columnValue.getText()+"/"+file.getName());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}				
				//store the results
				String content = "";
				//to participle		
				ta.T_S(t_string);
				
				if(choice.equalsIgnoreCase("Word_Top20")){																				
					//get top20
					content = ta.SelectSort(ta.s_vocabulary,ta.s_vocabulary.size()-1,filename);
					//show the results to users
					textArea_O.setText(content);				
				}
				if(choice.equalsIgnoreCase("Words_Cover80%")){
					//get 80%
					content = ta.R_80(ta.s_vocabulary, filename);					
					//show the results to users
					textArea_O.setText(content);
				}
				if(choice.equalsIgnoreCase("信息熵")){
					//get 信息熵
					content = ta.C_comentropy(ta.s_vocabulary,filename);					
					//show the results to users
					textArea_O.setText(content);
				}
				if(choice.equalsIgnoreCase("困惑度")){
					//get 困惑度
					content = ta.Cpp_q(ta.s_vocabulary, filename);
					//show the results to users
					textArea_O.setText(content);
				}
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			
		});		
		productBox_3.addMouseListener(new MouseListener(){			
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea_O.setText("Please wait ...");
				JOptionPane.showMessageDialog(jifShow, "请确认您输入的信息为分完词后的文本信息","提示", 1);								
				
				String choice = productBox_3.getSelectedItem().toString();				
				Text_Participle_2 ta = new Text_Participle_2();
				//get the contents from the articles
				String t_string = ""; 
				File fileroot = new File(columnValue.getText());
				File files [] = fileroot.listFiles();
				System.out.println("files.length = "+files.length);
				for(File file : files){
					try {
						t_string += ta.text_parse(columnValue.getText()+"/"+file.getName());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}			
				//calculate				
				ta.C_vocabulary(t_string);
				//store results
				String content = "";		
				
				if(choice.equalsIgnoreCase("Word_Top20")){
					//get top20 
					content = ta.SelectSort(ta.vocabulary,(ta.vocabulary.size()-1),filename);
					//show the results to users
					textArea_O.setText(content);
				}
				if(choice.equalsIgnoreCase("Words_Cover80%")){
					//get 80%
					content = ta.R_80(ta.vocabulary,filename);
					//show the results to users
					textArea_O.setText(content);					
				}
				if(choice.equalsIgnoreCase("信息熵")){					
					//get 信息熵
					content = ta.C_comentropy(ta.vocabulary,filename);					
					//show the results to users
					textArea_O.setText(content);					
				}
				if(choice.equalsIgnoreCase("困惑度")){									
					//get 困惑度							
					content = ta.Cpp_q(ta.vocabulary,filename);
					//show the results to users
					textArea_O.setText(content);					
				}
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}			
		});
		file_choose.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String info = "文本内容格式要求：\r\n"
							+ "가까스로 adv\r\n"
							+ "가까워지다 v\r\n"
							+ "가까이 n\r\n"
							+ "가까이하다 v\r\n"
							+ "가깝다 adj\r\n"
							+ "가꾸다 v\r\n"
							+ "가끔 adv\r\n"
							;
				String content = "";
				textArea_O.setText(info);
				File fp = new File(mainpkg.Globdata.path);
				JFileChooser sFile = new JFileChooser(fp);
				//设置文件过滤器
				FileNameExtensionFilter filter = new FileNameExtensionFilter("txt fileFileter", "txt");
				sFile.setFileFilter(filter);
				sFile.setFileSelectionMode(JFileChooser.FILES_ONLY);
				sFile.setDialogType(JFileChooser.OPEN_DIALOG);
				int answer = sFile.showOpenDialog(null);
				if(answer == JFileChooser.APPROVE_OPTION)
				{
					File infile = sFile.getSelectedFile();
					info = (infile.getPath()).replace('\\','/');
					Text_Analysis text_analysis = new Text_Analysis(); 					
					try {
						content = text_analysis.text_parse(info);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					info = "文件路径如下：\r\n"
							+ info + "\r\n"
							+ "文件内容如下：\r\n"
							+ content + "\r\n"
							;
					//得到根路径作为默认路径保存
					mainpkg.Globdata.path = infile.getParent();
				}
				else
				{
					info = "未选择文件！\r\n";
				}
				textArea_O.setText(info);
				Text_Deal text_deal = new Text_Deal();
				try {
					text_deal.Corpus_Dev("", content);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(jifShow, "您添加的词语已经完成！","提示", 1);
			}			
		});		
		file_choose.setBounds(10, 58, 135, 30);		
	}
}
