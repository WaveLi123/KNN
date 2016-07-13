package korean_cut;

import java.io.IOException;

public class test {
	
	public static void main(String[] args) throws IOException {
		String [] str = {"李伟康","WaveLi"};
		for(String sen : str){
			System.out.println(sen);
		}
		if("གོ".equalsIgnoreCase("ག")){
			System.out.println("Suceess!");
		}
		else{
			System.out.println("Fail!");
		}
		
	}
}
