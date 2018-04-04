package com.nil.recoSys01;

public class Main {
	public static void main(String[] ars) {
		Tester tester = new Tester();
		Recommender r = new Recommender();
		tester.setRecommender(r);
		tester.loadDataFromFile();
	}
}
