package com.martin.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.SocketAddress;
import java.net.URL;
import java.net.URLConnection;

public class ULRsourceReadingMainApp {
	
	public static void main(String[] args) {
		readingFromUrlWithouProxy();
	}
	
	public static void readingFromUrlWithouProxy() {
		try {									
			URL expobank = new URL("https://www.expobank.cz");
			BufferedReader in = new BufferedReader(new InputStreamReader(expobank.openStream(), "UTF8")); //with encoding settings
			
			String inputLine;
			while((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
			}
			
		} catch (MalformedURLException e) { 
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void readingFromUrlWithProxy() {		
	}
	

}
