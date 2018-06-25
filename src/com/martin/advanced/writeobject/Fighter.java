package com.martin.advanced.writeobject;

public class Fighter extends Person {

	private int fighterLevel;
	
	public Fighter(int level) {
		super();
		this.fighterLevel = level;
		
	}

	public int getFighterLevel() {
		return fighterLevel;
	}

	public void setFighterLevel(int fighterLevel) {
		this.fighterLevel = fighterLevel;
	}
	
	
	
}
