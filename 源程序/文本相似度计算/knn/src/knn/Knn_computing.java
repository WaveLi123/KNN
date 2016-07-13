package knn;

import java.util.ArrayList;
import java.util.Collections;

public class Knn_computing {
	public double Knn_computing_s(Knnnode test, Knnnode exercise) {
		double all_words = 0;
		double famliar_words = 0;
		if (test.content.size() > exercise.content.size()) {
			all_words = test.content.size();
		} else {
			all_words = exercise.content.size();
		}
		// 计算距离
		for (String str_test : test.content) {
			System.out.println("str_test" + str_test);
			for (String str_exer : exercise.content) {
				if (str_exer.equalsIgnoreCase(str_test)) {
					famliar_words++;
				}
			}
			System.out.println("famliar_words" + famliar_words);
		}
		System.out.println("famliar_words :" + famliar_words);
		System.out.println("all_words :" + all_words);
		System.out.println("results :" + (1 - (famliar_words / all_words)));
		return (1 - (famliar_words / all_words));
	}

	public String knn_computing_more(ArrayList<New_knnnode> test,ArrayList<New_knnnode> exer,int number) {
		System.out.println("number = "+number);
		String results = "";
		int count = 0;
		for(New_knnnode t_content : test){
			results += knn_computing_all(t_content,exer,number);
			results += "=================================="+"\r\n";
		}		
		return results;
	}
	
	public String knn_computing_all(New_knnnode test,ArrayList<New_knnnode> exer,int number) {
		System.out.println("number = "+number);
		String results = "";
		int count = 0;
		//计算各个训练和测试的距离
		for(New_knnnode value : exer){
			Knn_computing_s(test,value);
		}
		//对训练集进行排序
		ArrayList<New_knnnode> exer_new = new ArrayList<New_knnnode>();
		exer_new = SelectSort_Base(exer,(exer.size()-1),number);
		//构成显示输出
		for(New_knnnode value : exer_new){
			System.out.println("test = "+test.filename);
			System.out.println("exer = "+value.filename);
			results += test.content.get(0).value.split("【")[1].split("】")[0] + " :: " + value.content.get(0).value.split("【")[1].split("】")[0] + " == "+value.distance + "\r\n" ;
			if(count == number){
				break;
			}
			count ++;
		}
		
		return results;
	}

	public New_knnnode Knn_computing_s(New_knnnode test, New_knnnode exercise) {
		double all_words = 0;
		double famliar_words = 0;
		if (test.content.size() > exercise.content.size()) {
			all_words = test.content.size();
		} else {
			all_words = exercise.content.size();
		}
		// 计算距离
		for (New_Words str_test : test.content) {
			System.out.println("str_test :" + str_test.value);
			for (New_Words str_exer : exercise.content) {
				if (str_exer.value.equalsIgnoreCase(str_test.value)) {
					famliar_words++;
				}
			}
			System.out.println("famliar_words :" + famliar_words);
		}
		System.out.println("famliar_words :" + famliar_words);
		System.out.println("all_words :" + all_words);
		System.out.println("results :" + (1 - (famliar_words / all_words)));
		// 训练集信息完善
		exercise.distance = (1 - (famliar_words / all_words));
		exercise.filename = exercise.content.get(0).value.split("【")[1]
				.split("】")[0];
//		exercise.content = Clear_Name(exercise.content);
		return exercise;
	}

//	public ArrayList<New_Words> Clear_Name(ArrayList<New_Words> exer) {
//		ArrayList<New_Words> fianl = new ArrayList<New_Words>();
//		for (int c = 1; c < exer.size(); c++) {
//			fianl.add(exer.get(c));
//		}
//		return fianl;
//	}

	public ArrayList<New_knnnode> SelectSort_Base(ArrayList<New_knnnode> R,
			int n, int number) {
		int i, j, k = 0;
		New_knnnode temp = new New_knnnode();
		for (i = 0; i < n; i++) {
			k = i; // 选择具有最小排序码的对象
			for (j = i + 1; j <= n; j++) {
				if (R.get(j).distance < R.get(k).distance) {
					k = j; // 当前具最小排序码的对象
				}
			}
			if (k != i) { // 对换到第 i 个位置
				temp = R.get(i);
				R.set(i, R.get(k));
				R.set(k, temp);
			}
		}
		ArrayList<New_knnnode> result = new ArrayList<New_knnnode>();
		for (int c = 0; c < number; c++) {
			result.add(R.get(c));
		}
		return result;
	}

	public static void main(String args[]) {
		System.out.println("I Love China!");
	}
}