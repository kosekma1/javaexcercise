package com.martin.basics;

public class NestedClasses {

	public static void main(String[] args) {
						
		NestedClasses nc = new NestedClasses();
		nc.test();
	}
	
	int outer_x = 100;
	
	class Inner {
		int y = 10; // visible only to Inner class
		void display() {
			System.out.println("display: outer_x = " + outer_x);
		}
	}
	
	void test() {
		Inner inner = new Inner();
		inner.display();
		
		System.out.println("LOOP with inner class");
		for(int i=0; i < 10; i++) {
			class InnerClass { // class within a loop
				void display() {
					System.out.println("display: outer_x = " + outer_x);
				}
			}
			
			InnerClass ic = new InnerClass();
			ic.display();
			
		}
		
	
	}
	
}
