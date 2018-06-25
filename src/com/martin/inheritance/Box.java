package com.martin.inheritance;

public class Box {
	
	private double width;
	private double height;
	private double depth;
	
	public Box(Box ob) {
		this.width = ob.width;
		this.height = ob.height;
		this.depth = ob.depth;		
	}
	
	public Box(double width, double height, double depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}
	
	public Box() {
		this.width = -1;
		this.height = -1;
		this.depth = -1;
	}
	
	Box(double len){
		width = height = depth = len;
	}
	
	double volume() {
		return width*height*depth;
	}
	
	public String toString() {
		return width + ", " + height + ", " + depth;
	}

}
