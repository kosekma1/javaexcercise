package com.martin.basics;

public class ArraysTest {

	public static void main(String[] args) {
		testPole();
	}
	
	public static void testPole() {
		String pole[] = { "Martin", "Emil", "Katka" };

		for (String item : pole) {
			System.out.println(item);
		}

		int arrInt[] = new int[10];

		
		for (int i = 0; i < arrInt.length; i++) {
			arrInt[i] = i;
		}
		

		for (int i : arrInt) {
			System.out.println(i);
		}
		
		int arrIntMulti[][] = new int[2][3];
		for(int k=0; k < arrIntMulti.length ; k++) {
			for(int j = 0; j < arrIntMulti[k].length; j++) {
				System.out.print(arrIntMulti[k][j] + "[" + k + ", " + j + "]");
			}
			System.out.println();
		}
		

	}
}
