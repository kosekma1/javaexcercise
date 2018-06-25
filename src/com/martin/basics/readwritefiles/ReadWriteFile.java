package com.martin.basics.readwritefiles;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadWriteFile {

	public static void main(String[] args) {

		// show arguments put from command line
		for (String arg : args) {
			System.out.println(arg);
		}
				
		fileTest();
				
	}

	public static void fileTest() {
		Path path = Paths.get("C:\\temp\\JakSeZbavitAlergie.txt");

		/*
		try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

			String line = null;
			while ((line = br.readLine()) != null) {
				 System.out.println(line);				
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
		

		List<String> text = null;
		try {
			text = Files.readAllLines(path, StandardCharsets.UTF_8);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (String line : text) {
			System.out.println(line);
		}

		Path outputFile = Paths.get("C:\\temp\\vystup.txt");
		try (BufferedWriter writer = Files.newBufferedWriter(outputFile, StandardCharsets.UTF_8)) {

			writer.write("Ahoj tohle je vìta");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
