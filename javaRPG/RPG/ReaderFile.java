package RPG;
import RPG.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReaderFile{
	//String[] data;
	int i;
	public ReaderFile(int i){
	//	data = new String[i];
		this.i = i;
	}
	// CSVファイルを読み込み1行ずつ出力
	public String[] Reader_File(String args,String job_name) {
		//System.out.println(args + " " + job_name);
		BufferedReader br = null;
		String file_name = args; // 入力ファイル
		String line; // 読み込み行
		String[] data = new String[this.i]; // 分割後のデータを保持する配列
		try {
			File file = new File(file_name);
			br = new BufferedReader(new FileReader(file));
			// readLineで一行ずつ読み込む
			
			while (((line = br.readLine()) != null)) {
				// lineをカンマで分割し、配列dataに設定
				data = line.split(",");
				// 1行分の読み込みデータを表示（データ間にスペース）
				/**
				for (int i = 0; i < data.length; i++) {
					System.out.print(data[i] + " ");
				}
				System.out.println();/**/
				if(job_name.equals(data[0])) break;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				br.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return data;
	}
}