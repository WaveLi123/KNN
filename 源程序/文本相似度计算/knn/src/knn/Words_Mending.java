package knn;

import java.util.ArrayList;

public class Words_Mending {
	// form vocabulary
	public static New_knnnode C_Words(Knnnode node) {
		int length = 0;
		// two loop values
		int loop_1;
		int loop_2;
		// get all the words from an article,char
		String[] words = new String[node.content.size()];
		for (int count = 0; count < node.content.size(); count++) {
			words[count] = node.content.get(count);
		}
		length += words.length;

		New_knnnode newnode = new New_knnnode();
		newnode.content = new ArrayList<New_Words>();
		New_Words temp_R;

		for (loop_1 = 0; loop_1 < words.length; loop_1++) {
			// to form words' library
			for (loop_2 = 0; loop_2 < newnode.content.size(); loop_2++) {
				if (words[loop_1]
						.equalsIgnoreCase(newnode.content.get(loop_2).value)) {
					break;
				}
			}
			// there is no similar word in the vocabulary
			if (loop_2 == newnode.content.size()) {
				temp_R = new New_Words();
				temp_R.value = words[loop_1];
				temp_R.number = 1;
				temp_R.percent = ((double) temp_R.number / (double) length);
				newnode.content.add(temp_R);
			}
			// there is some word in the vocabulary,to calculate the number and
			// the percent
			else {
				temp_R = new New_Words();
				temp_R.value = newnode.content.get(loop_2).value;
				temp_R.number += 1;
				temp_R.percent = ((double) temp_R.number / (double) length);
				newnode.content.set(loop_2, temp_R);
			}
		}
		return newnode;
	}
	//获取窗口数据,规范测试集格式
	public static New_knnnode form_test(String content) {
		ArrayList<String> key_words = new ArrayList<String>();
		for(String word : content.split("\r\n")){
			key_words.add(word);
		}
		Knnnode test = new Knnnode(key_words.get(0).split("【")[1].split("】")[0],key_words,0,null);
		New_knnnode test_n = Words_Mending.C_Words(test);
		return test_n;
	}
	//获取窗口数据,规范训练集格式	
	public static ArrayList<New_knnnode> form_exer(String content) {
		ArrayList<String> key_words = new ArrayList<String>();
		ArrayList<New_knnnode> exercise = new ArrayList<New_knnnode>();
		
		for(String word : content.split("\r\n")){
			key_words.add(word);
		}
		
		//用"*********"作为分割各个文本的标记行
		ArrayList<String> temp = new ArrayList<String>();
		for(String line : key_words){
			if(line.equalsIgnoreCase("*********")){
				Knnnode test = new Knnnode(temp.get(0).split("【")[1].split("】")[0],temp,0,null);
				New_knnnode test_n = Words_Mending.C_Words(test);
				exercise.add(test_n);
				temp = new ArrayList<String>();
			}
			else{
				temp.add(line);
			}						
		}		
		
		return exercise;
	}
}