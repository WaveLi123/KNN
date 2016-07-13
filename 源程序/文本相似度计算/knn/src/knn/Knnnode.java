package knn;

import java.util.ArrayList;

public class Knnnode {
	// data
	String filename; // 这里用文件名作为文件的标识
	ArrayList<String> content; // 某个训练的内容
	double distance; // 距测试集的距离
	String directory; // 所属类别，空值

	// method
	public Knnnode(String filename, ArrayList<String> content, double distance,
			String directory) {
		this.filename = filename;
		this.content = content;
		this.distance = distance;
		this.directory = directory;
	}

	public Knnnode() {
	}
	
	public ArrayList<String> get_content(){
		return this.content;
	}
}
