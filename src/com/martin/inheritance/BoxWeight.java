package com.martin.inheritance;

public class BoxWeight extends Box {
	
	double weight;
	
	public BoxWeight(BoxWeight ob) {
		super(ob);
		weight = ob.weight;			
	}
	
	public BoxWeight(double width, double height, double depth, double weight) {
		super(width, height, depth);
		this.weight = weight;
	}
	
	public BoxWeight() {
		super();
		weight = -1;
	}
	
	public BoxWeight(double len, double m) {
		super(len);
		weight = m;
	}
	
	public static void main(String[] args) {
		Box box1 = new Box(100,20,20);
		Box box2 = new Box(box1);
		
		System.out.println(box1);
		System.out.println(box2);
	}
	
	

}
