package utils;

import java.util.Random;

public class Utilities {
	// it creates a random value inclusive two boundary
		public static int inclusiveRandomValueCreator(int lowerBoundary , int upperBoundary) {
			Random rand = new Random();
			return rand.nextInt(upperBoundary-lowerBoundary+1) + lowerBoundary;				
		}
}
