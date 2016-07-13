package main_entrance;

import java.io.IOException;
import java.util.*;
import Text_Participle.Test_tp;

class NumberException extends Exception{
	public NumberException(){
		System.out.println("the Number is too illeal!!!");
	}
}

public class Main_Entr{

	static void Menu_M(){
		System.out.println("***Welcome to use NPL System****");
		System.out.println("*1.字处理                                                            *");		
		System.out.println("*2.词处理(含分词模块)           *");
		System.out.println("*3.词处理(不含分词模块)         *");
		System.out.println("*4.退出                                                                 *");
		System.out.println("********************************");
	}
	
	static void Menu_S1(){
		System.out.println("************字处理**************");
		System.out.println("*1.出现频率最大的前20个字.       *");		
		System.out.println("*2.覆盖80%语料所需的字数.        *");		
		System.out.println("*3.信息熵 .                      *");
		System.out.println("*4.困惑度 .                      *");
		System.out.println("*5.退出 .                        *");
		System.out.println("*********************************");
	}
	
	static void Menu_S2(){
		System.out.println("*************词处理(含分词模块)*************");
		System.out.println("*1.出现频率最大的前20个词.                  *");		
		System.out.println("*2.覆盖80%语料所需的词数.                   *");		
		System.out.println("*3.信息熵 .                                 *");
		System.out.println("*4.困惑度 .                                 *");
		System.out.println("*5.退出 .                                   *");
		System.out.println("********************************************");
	}
	
	static void Menu_S3(){
		System.out.println("*************词处理(不含分词模块)*************");
		System.out.println("*1.出现频率最大的前20个字.                    *");		
		System.out.println("*2.覆盖80%语料所需的字数.                     *");		
		System.out.println("*3.信息熵 .                                   *");
		System.out.println("*4.困惑度 .                                   *");
		System.out.println("*5.退出 .                                     *");
		System.out.println("**********************************************");
	}
	//main entrance
	public static void main(String[] args) throws IOException {
		while(true){
			Menu_M();
			Scanner in = new Scanner(System.in);
			System.out.println("Please input your choice:");
			boolean valid = false;
			int choice = 0;
			while(!valid){
				try{				
					choice = in.nextInt();
					if(choice >= 5||choice <= 0){
						throw new NumberException();
					}
					valid = true;				
				}
				catch(NumberException e){
					e.getMessage();
					System.out.println("Warning,Your input is wrong,Please input again:");
				}
				catch(Exception e){
					e.printStackTrace();
					System.out.println("Warning,Your input is wrong,Please input again:");
				}			
			}		
			valid = false;
			switch(choice){
				case 1:	
						Menu_S1();
						int choice_1 = 0;
						System.out.println("Please input your choice:");
						while(!valid){
							try{				
								choice_1 = in.nextInt();
								if(choice_1 >= 6||choice_1 <= 0){
									throw new NumberException();
								}
								valid = true;				
							}
							catch(NumberException e){
								e.getMessage();
								System.out.println("Warning,Your input is wrong,Please input again:");
							}
							catch(Exception e){
								e.printStackTrace();
								System.out.println("Warning,Your input is wrong,Please input again:");
							}			
						}		
						valid = false;
						switch(choice_1){
							case 1:	
									System.out.println("please wait...");
									Text_Analysis.Test_as.main_20();								
									break;
									
							case 2:
									System.out.println("please wait...");
									Text_Analysis.Test_as.main_80();
									break;
								
							case 3:
									System.out.println("please wait...");
									Text_Analysis.Test_as.main_xv();
									break;
									
							case 4:
									System.out.println("please wait...");
									Text_Analysis.Test_as.main_ppq();
									break;
								
							case 5:
									System.exit(0);
									break;							
						}					
						break;
						
				case 2: 
						Menu_S2();
						int choice_2 = 0;
						System.out.println("Please input your choice:");
						while(!valid){
							try{				
								choice_2 = in.nextInt();
								if(choice_2 >= 6||choice_2 <= 0){
									throw new NumberException();
								}
								valid = true;				
							}
							catch(NumberException e){
								e.getMessage();
								System.out.println("Warning,Your input is wrong,Please input again:");
							}
							catch(Exception e){
								e.printStackTrace();
								System.out.println("Warning,Your input is wrong,Please input again:");
							}			
						}		
						valid = false;
						switch(choice_2){
							case 1:	
									System.out.println("please wait...");
									Text_Participle.Test_tp.main_tp_20();								
									break;
									
							case 2:
									System.out.println("please wait...");
									Text_Participle.Test_tp.main_tp_80();
									break;
								
							case 3:
									System.out.println("please wait...");
									Text_Participle.Test_tp.main_tp_xv();
									break;
							case 4:
									System.out.println("please wait...");
									Text_Participle.Test_tp.main_tp_ppq();
									break;
								
							case 5:
									System.exit(0);
									break;							
						}					
						break;
						
				case 3:	
					Menu_S3();
					choice_1 = 0;
					System.out.println("Please input your choice:");
					while(!valid){
						try{				
							choice_1 = in.nextInt();
							if(choice_1 >= 6||choice_1 <= 0){
								throw new NumberException();
							}
							valid = true;				
						}
						catch(NumberException e){
							e.getMessage();
							System.out.println("Warning,Your input is wrong,Please input again:");
						}
						catch(Exception e){
							e.printStackTrace();
							System.out.println("Warning,Your input is wrong,Please input again:");
						}			
					}		
					valid = false;
					switch(choice_1){
						case 1:	
								System.out.println("please wait...");
								Text_Analysis_2.Test_tp_2.main_20();								
								break;
								
						case 2:
								System.out.println("please wait...");
								Text_Analysis_2.Test_tp_2.main_80();
								break;
							
						case 3:
								System.out.println("please wait...");
								Text_Analysis_2.Test_tp_2.main_xv();
								break;
								
						case 4:
								System.out.println("please wait...");
								Text_Analysis_2.Test_tp_2.main_ppq();
								break;
							
						case 5:
								System.exit(0);
								break;							
					}					
					break;
			
						
				case 4: System.exit(0);
						break;
						
				default: System.out.println("Warning,Wrong input!\n");
						System.exit(0);					
			}

		}
	}
}
