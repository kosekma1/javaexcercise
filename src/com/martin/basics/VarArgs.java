package com.martin.basics;

public class VarArgs {

	public static void main(String[] args) {
		
		VarArgs va = new VarArgs();		
		va.test("Martin", "Karel", "Emil","Eva","Verca");
		va.test(10,20,20,31,52,33);				
		
	}
	
	public void test(int ... args) {
		
		System.out.println("Number of elements: " + args.length);
		
		for(int x : args) {
			System.out.print(x + " ");
		}
		
		System.out.println();
		
	}
	
	public void test(String ... args) {
		
		System.out.println("Number of elements: " + args.length);
		
		for(String x : args) {
			System.out.print(x + " ");
		}
		
		System.out.println();
	}
	
	
}
