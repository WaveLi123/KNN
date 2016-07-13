package test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.filechooser.FileNameExtensionFilter;

import knn.Knn_computing;
import knn.Knnnode;
import knn.New_knnnode;
import knn.Words_Mending;
import korean_cut.Text_Deal;
import Text_Analysis.Text_Analysis;

import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JTextPane;

public class GUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setAlwaysOnTop(false);
		frame.getContentPane().setBackground(Color.BLUE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 744, 423);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(248, 161, 93, 153);
		frame.getContentPane().add(scrollPane_1);
		
        
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setName("训练集");
		scrollPane_1.setViewportView(textArea_1);
		textArea_1.setEditable(false);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(423, 161, 224, 153);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setName("结果信息");
		scrollPane.setViewportView(textArea_2);
		textArea_2.setEditable(false);
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(105, 161, 91, 151);
		frame.getContentPane().add(scrollPane_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setName("\u6D4B\u8BD5\u96C6");
		scrollPane_2.setViewportView(textArea);
		textArea.setEditable(false);
		
		JButton button = new JButton("\u6587\u4EF6\u9009\u62E9");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//文本选择1--单一文件
				String content = "";		
				File fp = new File(mainpkg.Globdata.path);
				JFileChooser sFile = new JFileChooser(fp);
				//设置文件过滤器
				FileNameExtensionFilter filter = new FileNameExtensionFilter("txt fileFileter", "txt");
				sFile.setFileFilter(filter);
				sFile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				sFile.setDialogType(JFileChooser.OPEN_DIALOG);
				int answer = sFile.showOpenDialog(null);
				String filePath = "";
				if(answer == JFileChooser.APPROVE_OPTION)
				{					
					File infile = sFile.getSelectedFile();
					String filename = infile.getName();   
					filePath = (infile.getPath()).replace('\\','/');
					Text_Deal text_deal = new Text_Deal();
					//当前选择文件集
					if(!filePath.contains(".txt")){
						textArea.setText("Please Wait ......!");
						JOptionPane.showMessageDialog(frame, "请您耐心等待处理！","提示", 1);						
						File FileLists = new File(filePath);
						String show = "";
						System.out.println(filePath);
						
						for(File file : FileLists.listFiles()){
							filename = file.getName();
							filePath = file.getPath().replace('\\', '/');								
							show += "【"+filename+"】"+"\r\n";						
							try {
								show += text_deal.To_String(text_deal.main_test(filePath));
							} catch (IOException e) {
								e.printStackTrace();
							}
							show += "*********"+"\r\n";
						}
							//得到根路径作为默认路径保存
							mainpkg.Globdata.path = infile.getParent();
						
							textArea.setText(show);
						}														
					}
					else{//当前选择不是文件集，选择错误
						JOptionPane.showMessageDialog(frame, "您的选择错误，请选择文件夹进行处理！","错误", 1);
					}
//				if(answer == JFileChooser.APPROVE_OPTION)
//				{					
//					File infile = sFile.getSelectedFile();
//					String filename = infile.getName();   
//					filePath = (infile.getPath()).replace('\\','/');
//					Text_Deal text_deal = new Text_Deal();
//					try {						
//						textArea.setText("Please Wait ......!");
//						JOptionPane.showMessageDialog(frame, "请您耐心等待处理！","提示", 1);						
//						
//						textArea.setText("【"+filename+"】"+"\r\n");								
//						textArea.append(text_deal.To_String(text_deal.main_test(filePath)));
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					//得到根路径作为默认路径保存
//					mainpkg.Globdata.path = infile.getParent();
//				}
//				else
//				{
//					filePath = "未选择文件！\r\n";
//					textArea.setText(filePath);
//				}						
			}				
		});		
		button.setBounds(103, 102, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u6587\u4EF6\u9009\u62E9");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//文本选择--文件集
				String content = "";		
				File fp = new File(mainpkg.Globdata.path);
				JFileChooser sFile = new JFileChooser(fp);
				//设置文件过滤器
				FileNameExtensionFilter filter = new FileNameExtensionFilter("txt fileFileter", "txt");				
				sFile.setFileFilter(filter);
				sFile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				sFile.setDialogType(JFileChooser.OPEN_DIALOG);
				int answer = sFile.showOpenDialog(null);

				
				if(answer == JFileChooser.APPROVE_OPTION)
				{
					String filePath = "";
					File infile = sFile.getSelectedFile();
					String filename = infile.getName();   
					filePath = (infile.getPath()).replace('\\','/');
					Text_Deal text_deal = new Text_Deal();
					//当前选择文件集
					if(!filePath.contains(".txt")){
						textArea_1.setText("Please Wait ......!");
						JOptionPane.showMessageDialog(frame, "请您耐心等待处理！","提示", 1);						
						
						File FileLists = new File(filePath);
						String show = "";
						System.out.println(filePath);
						
						for(File file : FileLists.listFiles()){
							filename = file.getName();
							filePath = file.getPath().replace('\\', '/');								
							show += "【"+filename+"】"+"\r\n";						
							try {
								show += text_deal.To_String(text_deal.main_test(filePath));
							} catch (IOException e) {
								e.printStackTrace();
							}
							show += "*********"+"\r\n";
						}
						textArea_1.setText(show);
							//得到根路径作为默认路径保存
							mainpkg.Globdata.path = infile.getParent();
						}											
					}
					else{//当前选择不是文件集，选择错误
						JOptionPane.showMessageDialog(frame, "您的选择错误，请选择文件夹进行处理！","错误", 1);
					}
				}
			});
		button_1.setBounds(248, 102, 93, 23);
		frame.getContentPane().add(button_1);
		
		JLabel label = new JLabel("\u671D\u9C9C\u6587\u6587\u672C\u8BED\u4E49\u5206\u7C7B\u7CFB\u7EDF");
		label.setFont(new Font("宋体", Font.PLAIN, 23));
		label.setForeground(Color.GREEN);
		label.setBackground(Color.WHITE);
		label.setBounds(235, 34, 253, 33);
		frame.getContentPane().add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		comboBox.setBounds(459, 102, 81, 23);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("\u5904\u7406");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frame, "请您耐心等待处理！","提示", 1);
				textArea_2.setText("Please Wait ......!");
		
				//处理按钮			
				//形成测试文件
//				New_knnnode test_n = new New_knnnode();
//				test_n = Words_Mending.form_test(textArea.getText());
				ArrayList<New_knnnode> test_n = new ArrayList<New_knnnode>(); 
				test_n = Words_Mending.form_exer(textArea.getText());

				//形成训练集
				ArrayList<New_knnnode> exer_n = new ArrayList<New_knnnode>(); 
				exer_n = Words_Mending.form_exer(textArea_1.getText());
				
				Knn_computing knn_c = new Knn_computing();
				//textArea_2.setText(String.valueOf(knn_c.Knn_computing_s(test, exer)));				
//				textArea_2.setText(knn_c.knn_computing_all(test_n, exer_n,comboBox.getSelectedIndex()));
				textArea_2.setText(knn_c.knn_computing_more(test_n, exer_n,comboBox.getSelectedIndex()+1));
			}
		});
		
		btnNewButton.setBounds(541, 102, 66, 23);
		frame.getContentPane().add(btnNewButton);							
	}
}