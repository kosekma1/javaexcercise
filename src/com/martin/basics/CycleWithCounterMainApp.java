package com.martin.basics;
import java.io.IOException;
import java.util.Scanner;

public class CycleWithCounterMainApp {

	private static Scanner scanner;

	public static void main(String[] args) {
		
		//averageGrade();	
	 	//toUpperCase();
		arrays();
	}
			
	public static void arrays() {
		int[] arr = new int[10];
		arr[0] = 12;
		arr[1] = 5;
		
		for(int i : arr) {
			System.out.println(i);
		}
		
		double[] arrDouble = {12.5, 10.5, 13.6 };
		for(double d : arrDouble) {
			System.out.println(d);
		}
		
	}
	
	public static void toUpperCase() {
		char a = ' ';
		int count = 0;
		System.out.println("Enter few letters. To finish enter \'.\'");
		while(true) {
			try {
				a = (char)System.in.read();
				if(a=='.' || (int)a==13) break;				
				System.out.print((char)(a-32));																	
				count++;				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println();
		System.out.println(count + " letters were changed to uppercase.");
		System.out.println("End");
	}
	
	public static void averageGrade() {
		int total = 0;
		int gradeCounter = 0;
		int grade;
		double averageGrade;
		
		System.out.println("Enter the first grade (-1 to quit): ");
		scanner = new Scanner(System.in);
		grade = scanner.nextInt();
		
		while(grade!=-1) {
			total+=grade;
			gradeCounter++;
			System.out.println("Enter the first grade: ");
			grade = scanner.nextInt();						
		}
		
		if(gradeCounter != 0) {
			averageGrade = (double)total/gradeCounter;
			System.out.printf("Average of the grades is %.2f\n", averageGrade);
		} else {
			System.out.println("No grades were entered");
		}		
		
	}
		

}
