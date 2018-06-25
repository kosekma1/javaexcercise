package com.martin.basics;

import java.util.ArrayList;
import java.util.Scanner;

public class Analyzer2 {

	public static void main(String[] args) {
		
		System.out.println("Zadej slova. Ukonceni CTRL + Z");
		run();		
		
	}

	public static class Dvojice {	
	
		String word;
		int count;
		
		public Dvojice(String word) {
			this.word = word;
			this.count = 1;
		}
		
		public void add() {
			++this.count;
		}

		@Override
		public boolean equals(Object x) {
			return this.word.equals(((Dvojice)x).word);										
		}

		@Override
		public String toString() {			
			return this.word + " : " + this.count;
		}
				
		
	}
		
	public static void run() {
		ArrayList<Dvojice> list = new ArrayList<Dvojice>();
		Scanner sc = new Scanner(System.in);
		String token = null;
		while(sc.hasNext()) {
			token = sc.next();
			add(removeDelimiters(token), list);			
		}
		sc.close();
		System.out.println(list);		
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

	public static void add(String token, ArrayList<Dvojice> sezn) {
								
			Dvojice s = new Dvojice(new String(token));			
			
			int j = sezn.indexOf(s);						
			
			if(j==-1) { 
				sezn.add(s); 
			} else {
				sezn.get(j).add();
			}
								
	}	
		
}
