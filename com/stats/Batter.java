package com.stats;

import java.util.*;

public class Batter {
	
	public static void main(String[] args) {
		
		Batter newGame = new Batter();
		newGame.runProgram();
	}

	Scanner bb = new Scanner(System.in);
	
	String batterName = null;
	ArrayList<String> nameOfBatters = new ArrayList<>();
	ArrayList<Integer> numAtBatsForEachBatter = new ArrayList<>();
	ArrayList<Integer> numBasesForEachBatter = new ArrayList<>();
	ArrayList<Integer> numHitsForEachBatter = new ArrayList<>();
	int numBatters = 0;
	int numAtBat = 0;
	int numBases = 0;
	int numBasesForAtBat = 0;
	int numHits = 0;
	float battingAverage = 0.0f;
	float sluggingPercentage = 0.0f;
	
	public Batter() {
	}
	
	public void runProgram() {
		addBatterNames();
		addAtBatsForBatters();
		calculateStats();
		printStats();
	}
	
	public void addBatterNames() {
		
		System.out.println("How many batters played in the game?");
		numBatters = bb.nextInt();
		
		for (int i = 0; i < numBatters; i++) {
			System.out.println("What is batter number " + (i + 1) + "'s name?");
			batterName = bb.next();
			nameOfBatters.add(i, batterName);
		}
		
		for (int i = 0; i < nameOfBatters.size(); i++) {
			System.out.println("Batter number " + (i + 1) + "'s name is " + nameOfBatters.get(i));
		}
	}
	
	public void addAtBatsForBatters() {
		
		for (int i = 0; i < nameOfBatters.size(); i++) {
			System.out.println("How many at-bats did " + nameOfBatters.get(i) + " have for the game?");
			numAtBat = bb.nextInt();
			numAtBatsForEachBatter.add(i, numAtBat);
		}
	}
	
	public void calculateStats() {
		
		for (int i = 0; i < numBatters; i++) {
			
			numHits = 0;
			
			for (int j = 0; j < numAtBatsForEachBatter.get(i); j++) {
				System.out.println("How many bases did " + nameOfBatters.get(i) + " have for at-bat number " + (j + 1) + "?");
				numBasesForAtBat = bb.nextInt();
				numBases += numBasesForAtBat;
				if (numBasesForAtBat == 0) {
					numHits += numBasesForAtBat;
				} else {
					numHits++;
				}
			}
			numHitsForEachBatter.add(i, numHits);
			numBasesForEachBatter.add(i, numBases);
		}
	}
	
	public void printStats() {
		
		for (int i = 0; i < numBatters; i++) {
			
			battingAverage = 0.0f;
			sluggingPercentage = 0.0f;
			
			battingAverage = numHitsForEachBatter.get(i) / numAtBatsForEachBatter.get(i);
			sluggingPercentage = numBasesForEachBatter.get(i) / numAtBatsForEachBatter.get(i);
			
			System.out.println(nameOfBatters.get(i) + " is batter number " + (i + 1) + ".");
			System.out.format(nameOfBatters.get(i) + "'s batting average is %.3f \n", battingAverage);
			System.out.format(nameOfBatters.get(i) + "'s slugging percentage is %.3f \n", sluggingPercentage);
			
		}
	}
}
