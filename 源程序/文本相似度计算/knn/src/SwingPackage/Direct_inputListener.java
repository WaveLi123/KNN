package SwingPackage;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.swing.*;

import korean_cut.Corpus_Deal;
import Text_Analysis.Text_Analysis;
import Text_Analysis_2.Text_Participle_2;
import Text_Participle.Text_Participle;



class Direct_inputListener implements ActionListener
{
	JPanel jplDisplay;
	JInternalFrame jifShow;
	JPanel displayUp,displayMidL,displayMidR,displayDown;
	JPanel jplButton;
	String filename = "";
	//Management operate=null;
	public Direct_inputListener(JPanel jpl)
	{
		this.jplDisplay=jpl;
	}
	public void actionPerformed(ActionEvent e)
	{
		jplDisplay.removeAll();
		//
		boolean path_valid = false;		
		while(!path_valid){
			filename = JOptionPane.showInputDialog("请输入结果的存储路径","F:/Course/Npl/Results/");
			File infile = new File(filename);
			if(infile.isFile()||infile.isDirectory()){
				path_valid = true;
			}
			else{
				JOptionPane.showMessageDialog(jifShow, "您输入的路径错误,请重新输入","警告", 1);
			}

		}
				
		jifShow=new JInternalFrame("设置文件路径面板 ",true,true,true);
		//
		displayUp=new JPanel();
		JLabel jTitle=new JLabel("选择文件路径");
		jTitle.setFont(new Font("华文行楷", 2, 28));
		jTitle.setForeground(Color.BLACK);
		displayUp.add(jTitle);
		displayUp.setBackground(Color.GREEN);
		
		//
		//
		jplButton=new JPanel();
		jplButton.setBackground(new Color(250,250,240));
		String[] productName={"Word_Top20","Words_Cover80%","信息熵","困惑度"};
		
		final JComboBox productBox_1=new JComboBox();		//
		productBox_1.setModel(new DefaultComboBoxModel(productName));
		final JComboBox productBox_2=new JComboBox();		//
		productBox_2.setModel(new DefaultComboBoxModel(productName));
		final JComboBox productBox_3=new JComboBox();		//
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
		//changed by WaveLi Feb 23st in 2015
//		jifShow.add(jplButton,BorderLayout.LINE_END);		
		
		//
		displayMidL = new JPanel(new BorderLayout());
		displayMidR = new JPanel(new BorderLayout());		
						
		
		//		
		final JTextArea textArea_O = new JTextArea(
                "Please wait......" 
        );
        textArea_O.setFont(new Font("Serif", Font.ITALIC, 16));
        textArea_O.setLineWrap(true);
        textArea_O.setWrapStyleWord(true);
        
        JScrollPane areaScrollPane_1 = new JScrollPane(textArea_O);
        areaScrollPane_1.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane_1.setPreferredSize(new Dimension(500, 200));
        areaScrollPane_1.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("结果信息"),
                                BorderFactory.createEmptyBorder(5,5,5,5)),
                areaScrollPane_1.getBorder()));
		displayMidL.add(areaScrollPane_1,BorderLayout.CENTER);
		
		
		final JTextArea textArea_I = new JTextArea(
                "Please input your information......" 
        );
        textArea_I.setFont(new Font("Serif", Font.ITALIC, 16));
        textArea_I.setLineWrap(true);
        textArea_I.setWrapStyleWord(true);
		JScrollPane areaScrollPane_2 = new JScrollPane(textArea_I);
        areaScrollPane_2.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane_2.setPreferredSize(new Dimension(500, 200));
        areaScrollPane_2.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("输入信息"),
                                BorderFactory.createEmptyBorder(5,5,5,5)),
                areaScrollPane_2.getBorder()));
		displayMidR.add(areaScrollPane_2,BorderLayout.CENTER);
		
		displayMidL.setVisible(true);	//
		displayMidR.setVisible(true);	//
		jifShow.add(displayMidL,BorderLayout.CENTER);
		jifShow.add(displayMidR,BorderLayout.PAGE_START);
		jplDisplay.add(jifShow);		//		

		//底层面板		
		JButton jbStore=new JButton("确定");			//设置按钮
		JButton jbReset=new JButton("重置");
		JButton jbQuit=new JButton("处理");
		displayDown=new JPanel(new FlowLayout());
		displayDown.add(jbStore);
		displayDown.add(jbReset);
		displayDown.add(jbQuit);
		displayDown.setBackground(Color.BLACK);
		
		jifShow.add(displayUp,BorderLayout.NORTH);
		jifShow.add(displayDown,BorderLayout.SOUTH);
		jifShow.setVisible(true);
		jplDisplay.add(jifShow);
				
		
		
		
		//
		textArea_I.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea_I.setText(null);
			}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}			
		});
		//
		jbQuit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				textArea_O.setText("Please Wait......");
				Corpus_Deal corpus_deal = new Corpus_Deal();
				try {
					textArea_O.setText(corpus_deal.main_test(textArea_I.getText(), filename));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		//
		jbReset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				textArea_I.setText(null);
			}
		});
		//为jbStore按钮添加监听器
		jbStore.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String tableValue = new String(textArea_I.getText());						
				JOptionPane.showMessageDialog(jifShow, "您的信息已保存，请在点击处理按钮进行处理","提示", 1);				
			}
		});
				
		
		//
		productBox_1.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {	
				textArea_O.setText("Please wait ...");
				JOptionPane.showMessageDialog(jifShow, "请确认您输入的消息","提示", 1);
				
				String choice = productBox_1.getSelectedItem().toString();
				//get information from users
				String t_string = textArea_I.getText();										
				//calculate
				Text_Analysis ta = new Text_Analysis();
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
					//get 
					content = ta.C_comentropy(ta.vocabulary,filename);					
					//show the results to users
					textArea_O.setText(content);					
				}
				if(choice.equalsIgnoreCase("困惑度")){									
					//get 							
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
				JOptionPane.showMessageDialog(jifShow, "请确认您输入的消息","提示", 1);
				String choice = productBox_2.getSelectedItem().toString();				
				//get information from users
				String t_string = textArea_I.getText();
				//store the results
				String content = "";
				//to participle		
				Text_Participle ta = new Text_Participle();
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
					//get 
					content = ta.C_comentropy(ta.s_vocabulary,filename);					
					//show the results to users
					textArea_O.setText(content);
				}
				if(choice.equalsIgnoreCase("困惑度")){
					//get 
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
				JOptionPane.showMessageDialog(jifShow, "请确认您输入的消息","提示", 1);								
				
				String choice = productBox_3.getSelectedItem().toString();				
				//get information from users
				String t_string = textArea_I.getText();				
				//calculate
				Text_Participle_2 ta = new Text_Participle_2();
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
					//get 
					content = ta.C_comentropy(ta.vocabulary,filename);					
					//show the results to users
					textArea_O.setText(content);					
				}
				if(choice.equalsIgnoreCase("困惑度")){									
					//get 							
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
	}
}