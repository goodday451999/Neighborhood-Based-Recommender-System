package com.nil.recoSys01;

import java.util.ArrayList;
import java.util.*;

public class Recommender {

	public void init() {
		
	}
	//To predict the Rating 
	public double predictRating(Person person, Movie movie) {
		ArrayList<Person> neighbourhood = createNeighbourhood(person, 1);
		
		for(Person p:neighbourhood) {
			Person.displayCommonMovieRatings(person, p);
		}
		//double prediction = createPredictionFromNeighbourhood(neighbourhood,movie);
		return 4;
	}
	
	//private double createPredictionFromNeighbourhood(ArrayList<Person> neighbourhood, Movie movie) {
	//	// TODO Auto-generated method stub
	//	return 0;
	//}
	
	private ArrayList<Person> createNeighbourhood(Person activeUser, double similarityThresold) {
		ArrayList<Person> neighbourhood = new ArrayList<Person>();
		for(Person otherUser:Tester.getAllPeople()) {
			if(otherUser.getId() != activeUser.getId()) {
				double similarity = checkSimilarity(activeUser, otherUser);
				
				if(similarity < similarityThresold) {
					neighbourhood.add(otherUser);
				}			
			}
		}
		return neighbourhood;
	}
	
	private double checkSimilarity(Person activeUser, Person otherUser) {
		int moviesInCommon = 0;
		double differenceSum = 0;
		for(Rating r1:activeUser.getAllRatings()) {
			for(Rating r2:otherUser.getAllRatings()) {
				Movie m1 = r1.getMovie();
				Movie m2 = r2.getMovie();
				
				if(m1.getId() == m2.getId()) {
					moviesInCommon++;
					differenceSum += Math.abs(r1.getRating() - r2.getRating());
				}
			} 
		}
		if(moviesInCommon > 0) {
			return (differenceSum / moviesInCommon);
		}
		return Integer.MAX_VALUE;
	}
}



