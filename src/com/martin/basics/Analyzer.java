package com.martin.basics;

import java.util.ArrayList;
import java.util.Scanner;

public class Analyzer {

	public static void main(String[] args) {
		
		System.out.println("Zadej slova. Ukonceni CTRL + Z");
		beh();		
		
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
	
	static String oddelovace = " .,;?";
	
	public static void beh() {
		ArrayList<Dvojice> list = new ArrayList<Dvojice>();
		Scanner sc = new Scanner(System.in);
		String line = "";
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			analyzuj(line, list);			
		}
		sc.close();
		System.out.println(list);		
	}
	
	public static void analyzuj(String radek, ArrayList<Dvojice> sezn) {
						
		if(radek.equals("")) {return;}
		int i = 0;
		StringBuffer slovo = null;
		i = preskocOddelovace(radek, i);
		while(i>=0) {
			slovo = new StringBuffer("");
			while((i < radek.length() && oddelovace.indexOf(radek.charAt(i))==-1)){
				slovo.append(radek.charAt(i++));
			}
			
			Dvojice s = new Dvojice(new String(slovo));			
			
			int j = sezn.indexOf(s);
			if(j==-1) { 
				sezn.add(s); 
			} else {
				sezn.get(j).add();
			}
			
			i = preskocOddelovace(radek, i);					
		}
	}
	
	public static int preskocOddelovace(String rad, int od) {
		if(od >= rad.length()) { return -1;}
		while(oddelovace.indexOf(rad.charAt(od)) >= 0){
			if(++od == rad.length()) { return -1; }			
		}
		return od;
	}
	
}
