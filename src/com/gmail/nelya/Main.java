package com.gmail.nelya;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) {

		String textIn1 = loadFromFile(new File("a.txt"));
		String textIn2 = loadFromFile(new File("b.txt"));
		System.out.println(textIn1);
		System.out.println(textIn2);
	

		try (PrintWriter text = new PrintWriter(new File("c.txt"))) {
			text.println();
		} catch (FileNotFoundException e) {
			System.out.println("Error file write!");
		}

	}
	
	public static String loadFromFile(File file) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String text = "";
			for (; (text = br.readLine()) != null;) {
				sb.append(text).append(System.lineSeparator());
			}
		} catch (IOException e) {
			System.out.println(e);
		}

		return sb.toString();
	}

}
