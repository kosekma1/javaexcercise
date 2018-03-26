package com.martin.basics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Scanner;

public class FileOperationsMainApp {

	public static void main(String[] args) {
		readAndWriteFiles();
	}

	public static void readAndWriteFiles() {

		//String fileNameInput = "C://temp//input.txt";
		//String fileNameOutput = "C://temp//output.txt";
		
		String fileNameInput = "input.txt";
		String fileNameOutput = "output.txt";

		File inputFile = new File(fileNameInput);
		File outputFile = new File(fileNameOutput);

		// classical way
		FileReader fr;
		BufferedReader br;
		FileWriter fw;
		BufferedWriter bw;

		try {
			fr = new FileReader(inputFile);
			br = new BufferedReader(fr);
			
			fw = new FileWriter(outputFile);
			bw = new BufferedWriter(fw);
			
			/*
			//reading from file with set encoding
			Charset inputCharset = Charset.forName("UTF-8");			
			FileInputStream fis = new FileInputStream(inputFile);
			BufferedReader in = new BufferedReader(
			           new InputStreamReader(fis, inputCharset));			
			*/
			
			String tempLine;
			while ((tempLine = br.readLine()) != null) {
				System.out.println(tempLine);
				String arr[] = tempLine.split(";"); // split each line
				for (String item : arr) {
					System.out.println(item.trim());
					bw.write(item.trim() + "\n"); // write each item
				}
			}
			bw.close();
			br.close();
			fr.close();
			fw.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
							

				
		// using scanner - reading is different, writing is the same
		Scanner scannerInput;
		try {
			scannerInput = new Scanner(inputFile);
			while (scannerInput.hasNext()) {
				System.out.println(scannerInput.nextLine());
			}					
			scannerInput.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("END");
	}

}
