package com.martin.basics.analyzerlink;

import java.util.Scanner;

public class Analyzer3 {

	public static void main(String[] args) {
		
		System.out.println("Zadej slova. Ukonceni CTRL + Z");
		run();		
		
	}								

		
	public static void run() {
		Container list = new Container();
		Scanner sc = new Scanner(System.in);
		String token = null;
		while(sc.hasNext()) {
			token = sc.next();
			add(removeDelimiters(token), list);			
		}
		sc.close();
		list.printItems();		
	}
	
	public final static String DELIMITERS = " .,;?";
	
	private static String removeDelimiters(String token) {
		
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while(i<token.length() && DELIMITERS.indexOf(token.charAt(i))==-1) {							
				sb.append(token.charAt(i++));
		}
						
		return sb.toString();
	}

	public static void add(String token, Container sezn) {
								
			Dvojice2 s = new Dvojice2(new String(token));						
			sezn.add(s);
								
	}	
		
}
