package com.martin.basics.analyzerlink;


public class Dvojice2 {	

	String word;
	int count;
	Dvojice2 next;
	
	public Dvojice2(String word) {
		this.word = word;
		this.count = 1;
	}
	
	public void add() {
		++this.count;
	}

	@Override
	public boolean equals(Object x) {
		return this.word.equals(((Dvojice2)x).word);										
	}

	@Override
	public String toString() {			
		return this.word + " : " + this.count;
	}
			
	
}
