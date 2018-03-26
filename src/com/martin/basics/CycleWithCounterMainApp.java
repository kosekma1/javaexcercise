package com.martin.basics;
import java.util.Scanner;

public class CycleWithCounterMainApp {

	private static Scanner scanner;

	public static void main(String[] args) {
		
		averageGrade();

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
