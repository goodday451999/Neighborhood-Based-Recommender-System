package com.nil.recoSys01;

import java.util.ArrayList;

public class Person {
	private int id,age;
	private String userName, gender, occupation, zip;
	private ArrayList<Rating> ratings;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public void addRating(Rating r) {
		ratings.add(r);
	}
	public void clearRaatings() {
		ratings.clear();
	}
	public void removeRatings(ArrayList<Rating> ratingsToRemove) {
		ratings.removeAll(ratingsToRemove);
	}
	
	public String toString() {
		String ret = "id:\t\t" + id;
		ret += "\nage:\t\t" + age;
		ret += "\nuserName:\t\t" + userName;
		ret += "\ngender:\t\t" + gender;
		ret += "\noccupation:\t\t" + occupation;
		ret += "\nzip:\t\t" + zip;
		ret += "\nratings: " + ratings.size() +" total ratings\n";
		ret += ratings.toString();
		
		return ret;
	}
	
	public static void displayCommonMovieRatings(Person p1, Person p2) {
		for(Rating r1:p1.getAllRatings()) {
			for(Rating r2:p2.getAllRatings()) {
				Movie m1 = r1.getMovie();
				Movie m2 = r2.getMovie();
				
				if(m1.getId() == m2.getId()) {
					System.out.println(m1.getName());
					System.out.println("P1: " + r1.getRating());
					System.out.println("P2: " + r2.getRating());
				}
			} 
		}
	}
	public ArrayList<Rating> getAllRatings() {
		return ratings;
	}
	public void addAllRatings(ArrayList<Rating> ratingsToAdd) {
		ratings.addAll(ratingsToAdd);
	}
}
