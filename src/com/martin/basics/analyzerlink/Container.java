package com.martin.basics.analyzerlink;

public class Container {
	
	Dvojice2 head;		
	
	public void add(Dvojice2 dvojice) {
		
		if(head==null) {
			head = dvojice;
		} else {
			Dvojice2 item = head;
			
			do {
				if(item.equals(dvojice)) {
					item.add();
					break;
				} else {
					if(item.next == null) {
						item.next = dvojice;					
						item = item.next;
					}
				}
				item = item.next;
			}
			while(item!=null); 													
			
		}			
		
	}
	
	public void printItems() {
		Dvojice2 item = head;
		do {
			System.out.println(item);
			item = item.next;
		} while(item!=null); 
	}
	
}
