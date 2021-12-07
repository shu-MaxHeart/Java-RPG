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
	// CSV�t�@�C����ǂݍ���1�s���o��
	public String[] Reader_File(String args,String job_name) {
		//System.out.println(args + " " + job_name);
		BufferedReader br = null;
		String file_name = args; // ���̓t�@�C��
		String line; // �ǂݍ��ݍs
		String[] data = new String[this.i]; // ������̃f�[�^��ێ�����z��
		try {
			File file = new File(file_name);
			br = new BufferedReader(new FileReader(file));
			// readLine�ň�s���ǂݍ���
			
			while (((line = br.readLine()) != null)) {
				// line���J���}�ŕ������A�z��data�ɐݒ�
				data = line.split(",");
				// 1�s���̓ǂݍ��݃f�[�^��\���i�f�[�^�ԂɃX�y�[�X�j
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