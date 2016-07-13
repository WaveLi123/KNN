package SwingPackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainWindow extends JFrame
{	
	final int MIN_WIDTH=400;
	final int MIN_HIGHT=300;
	Point point=new Point(0,0);		//窗口的当前坐标
	
	//菜单设计
	JMenuBar myMenubar;
	JMenu menuFile,menuEdit;
	JMenuItem menuitemExit, menuitemAbout;
	
	//按钮
	Icon iconTitle;
	JButton jbnButtons[];
	JPanel jplTitle,jplDisplay,jplButton;
	
	//文本信息设置
	Font f12 = new Font("Times New Roman", 0, 10);
	Font f121 = new Font("Times New Roman", 1,10);
	Font fbutton=new Font("华文行楷", 1, 20);
	
	String[] name={" ","直接输入","选择文件","扩展词典"};
	/** Creates new form MainWindow */
	public MainWindow()
	{
		this.initComponents();
	}
	private void initComponents()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//添加菜单栏
		menuFile=new JMenu("File");
		menuFile.setFont(f121);			
		menuitemExit=new JMenuItem("Exit");
		menuitemExit.setFont(f12);
		menuFile.add(menuitemExit);
		
		menuEdit=new JMenu("Help");
		menuEdit.setFont(f121);
		menuitemAbout=new JMenuItem("About");
		menuitemAbout.setFont(f12);
		menuEdit.add(menuitemAbout);
		
		myMenubar=new JMenuBar();
		myMenubar.add(menuFile);
		myMenubar.add(menuEdit);		
		this.setJMenuBar(myMenubar);
		
		//设置主窗口的位置
		this.setMinimumSize(new Dimension(MIN_WIDTH,MIN_HIGHT));
		this.setSize(900,700);
		this.setTitle("朝文地名识别系统");
		this.setLocationRelativeTo(null);//在屏幕正中间显示

		final JFrame jfmain=this;
		this.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e){}	//鼠标点击
			public void mouseEntered(MouseEvent e){}	//鼠标进入
			public void mouseExited(MouseEvent e){}		//鼠标退出
			public void mouseReleased(MouseEvent e){}	//鼠标松开
			public void mousePressed(MouseEvent e){		//鼠标按下
				point=e.getPoint();//获取当前鼠标坐标
			}
		});
		/*this.addMouseMotionListener(new MouseMotionListener(){
			public void mouseDragged(MouseEvent e) {	//鼠标按下并拖动
				Point newPoint=e.getPoint();//获取新坐标,并移动窗口哭的位置
				jfmain.setLocation(jfmain.getX()+(newPoint.x-point.x),jfmain.getY()+(newPoint.y-point.y)); //设置新位置
			}
			public void mouseMoved(MouseEvent e) {}	
		});*/
		
		//添加按钮面板
		jbnButtons=new JButton[4];		
		for(int i=0;i<jbnButtons.length;i++)
		{
			// set the style of each Jbutton label
			jbnButtons[i]=new JButton(name[i]);
			jbnButtons[i].setFont(fbutton);
			jbnButtons[i].setForeground(Color.BLACK);
		}
		
		jplButton=new JPanel();		//create the panel to store Button
		jplButton.setBackground(new Color(250,250,240));
		jplButton.setLayout(new GridLayout(6,1));
		for(int i=1;i<7;i++)
		{
			if((i%2)==0)
				jplButton.add(jbnButtons[i/2],BorderLayout.CENTER);
			else
				jplButton.add(new JLabel());
		}
		this.add(jplButton,BorderLayout.WEST);
		
		//添加显示面板		
		jplDisplay=new JPanel();
		jplDisplay.setLayout(new BorderLayout());
		jplDisplay.setBackground(new Color(230,230,230));
		final JTextArea textArea_I = new JTextArea(
                "Welcome to our System! \n" +
                "Author : WaveLi\n"+
                "Institution : MUC"                	
        );
        textArea_I.setFont(new Font("Serif", Font.CENTER_BASELINE, 24));
        textArea_I.setLineWrap(true);
        textArea_I.setWrapStyleWord(true);
        jplDisplay.add(textArea_I);
        jplDisplay.setVisible(true);
		this.add(jplDisplay,BorderLayout.CENTER);
		this.pack();
		
		//为组件添加监听器
		jbnButtons[1].addActionListener(new Direct_inputListener(jplDisplay));
		jbnButtons[2].addActionListener(new FileChooserListener(jplDisplay));
		jbnButtons[3].addActionListener(new Corpus_DevListener(jplDisplay));
						
		menuitemExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
	}
}																
