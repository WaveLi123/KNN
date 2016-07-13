package knn;

import java.util.ArrayList;

public class New_knnnode {
	// data
	String filename; // 这里用文件名作为文件的标识
	ArrayList<New_Words> content; // 某个训练的内容
	double distance; // 距测试集的距离
	String directory; // 所属类别，空值

	// method
	public New_knnnode(String filename, ArrayList<New_Words> content,
			double distance, String directory) {
		this.filename = filename;
		this.content = content;
		this.distance = distance;
		this.directory = directory;
	}

	public New_knnnode() {
	}

	public String get_filename() {
		return this.filename;
	}
	
	public ArrayList<New_Words> get_content() {
		return this.content;
	}
	
	public double get_distance() {
		return this.distance;
	}
	
	public String get_directory() {
		return this.directory;
	}
}
