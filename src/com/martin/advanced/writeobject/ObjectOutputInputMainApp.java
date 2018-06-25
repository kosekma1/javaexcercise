package com.martin.advanced.writeobject;

import java.io.*;

public class ObjectOutputInputMainApp {
	public static void main(String[] args) {

		Person p = new Person();
		p.setFirstName("Joe");
		p.setLastName("Shmoe");
		writeObject(p);

		readObject();
		
	}

	public static void writeObject(Object o) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("c:\\temp\\person.dat"));
			oos.writeObject(o);
			System.out.println("Object is written...");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void readObject() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("c:\\temp\\person.dat"));
			Person p1 = (Person) ois.readObject();
			System.out.println(p1);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (ois != null) {
					ois.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
