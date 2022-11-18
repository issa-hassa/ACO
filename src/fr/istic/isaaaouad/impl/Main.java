package fr.istic.isaaaouad.impl;

public class Main {

	public static void main(String[] args) {
		Engine e = new Engine();
		System.out.println(e.getName());
		Engine e2 = new Engine();
		System.out.println(e.equals(e2));

	}

}
