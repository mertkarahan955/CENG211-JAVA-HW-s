package app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import human_characters.Human;
import human_characters.Knight;
import human_characters.Hunter;
import human_characters.Squire;
import human_characters.Villager;
import opponents.Goblin;
import opponents.Opponent;
import opponents.Orc;
import opponents.Slime;
import opponents.Wolf;

public class TBGame {
	public static void main(String[] args) {
		TBGame app = new TBGame();
		TBGame.Menu menu = app.new Menu();
	}
	Scanner scanner = new Scanner(System.in);
	// initialize opponents  +
	// opponents arrayList   +
	// welcome page includes opponents infos + 
	// ask how many characters player wants to create + 
	// add character(s) to arraylist + 
	// print the character info from list + 
	
	// create a queue that has opponents and characters for play turn
	// turnOrder Queue. Order is determined according to speed stat.
	// finish the turn and take it to tail of queue
	// if special action occures queue might change.
	// remove who has 0 or less points.
	
	private class Initializer{
		private int MAX_CREATE_OPPONENT_VALUE = 4;
		private AtomicInteger ID_GENERATOR = new AtomicInteger(0);
		Random random = new Random();
		ArrayList<Opponent> opponentList = new ArrayList<Opponent>();
		ArrayList<Human> characterList = new ArrayList<Human>();
		
		public Initializer() {
			createAndAddToOpponentList();
		}
		private void createAndAddToOpponentList() {
		    int maxOpponents = 4; // Set the maximum number of opponents you want to generate
		    int numOpponents = 1 + random.nextInt(maxOpponents); // Generate a random number of opponents

		    int opponentId = 1; // Start with an initial opponentId
		    while (numOpponents > 0) {
		        int createValue = 1 + random.nextInt(4);
		        switch (createValue) {
		            case 1:
		                opponentList.add(new Goblin(opponentId++));
		                numOpponents--;
		                break;
		            case 2:
		                opponentList.add(new Orc(opponentId++));
		                numOpponents--;
		                break;
		            case 3:
		                opponentList.add(new Slime(opponentId++));
		                numOpponents--;
		                break;
		            case 4:
		                opponentList.add(new Wolf(opponentId++));
		                numOpponents--;
		                break;
		            default:
		                throw new IllegalArgumentException("Unexpected value: " + createValue);
		        }
		    }
		}


		
		private void initializeChars() {
	        ID_GENERATOR.set(0); // Reset the ID_GENERATOR before generating characters

	        System.out.print("Please enter the number of characters to create: ");
	        int chCreateValue = scanner.nextInt();

	        while (chCreateValue > 0) {
	            int randomCharCreateValue = (1 + random.nextInt(4));

	            // Ask the user to input the name for each character
	            System.out.print("Enter name for your " + (characterList.size() + 1) + ". character: ");
	            String characterName = scanner.next();

	            switch (randomCharCreateValue) {
	                case 1:
	                    characterList.add(new Knight(characterName, ID_GENERATOR.getAndIncrement()));
	                    break;
	                case 2:
	                    characterList.add(new Hunter(characterName, ID_GENERATOR.getAndIncrement()));
	                    break;
	                case 3:
	                    characterList.add(new Squire(characterName, ID_GENERATOR.getAndIncrement()));
	                    break;
	                case 4:
	                    characterList.add(new Villager(characterName, ID_GENERATOR.getAndIncrement()));
	                    break;
	                default:
	                    throw new IllegalArgumentException("Unexpected value: " + randomCharCreateValue);
	            }

	            chCreateValue--;
	        }
	    }
		
	}
	
	private class Menu{
		public Menu() {
			displayMenu();
			
		}
		
		Initializer init = new Initializer();
		
		private void displayMenu() {
			System.out.println("Welcome to TBGame");
			opponentInfo();
			init.createAndAddToOpponentList();
			init.initializeChars();
			charsInfo();
			System.out.println("The battle starts");
			

		}
		private void opponentInfo() {
			
			System.out.println("These opponents appeared in front of you:");
			for (Opponent opponent : init.opponentList) {
				System.out.println(opponent.toString());
			}
		}
		private void charsInfo() {
			for (Human human : init.characterList) {
				int currentIndex = init.characterList.indexOf(human);
				System.out.println("The stats of your " + (currentIndex +1)+ ". character:" + human.toString());
				human.toString();
			}
		}
		private void arrayListSizeChecker() {
		// check the size of the lists if one of them is empty: exit 	
		}
		
	}
}
