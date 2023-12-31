package app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.UnaryOperator;

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
import weapon.Weapon;

public class TBGame {
	Random random = new Random();
	Initializer init = new Initializer();
	
	
	
	public static void main(String[] args) {
		TBGame app = new TBGame();
		TBGame.Menu menu = app.new Menu();
		TBGame.TurnOrder order = app.new TurnOrder();
		
		
	}
	Scanner scanner = new Scanner(System.in);
	// initialize opponents  +
	// opponents arrayList   +
	// welcome page includes opponents infos + 
	// ask how many characters player wants to create + 
	// add character(s) to arraylist + 
	// print the character info from list + 
	
	// create a queue that has opponents and characters for play turn + 
	// turnOrder Queue. Order is determined according to speed stat. +
	// make the attack attribute
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

		private void displayMenu() {
			System.out.println("Welcome to TBGame");
			opponentInfo();
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
		private void chooseMoveOption(String chosedOption) {
			switch (chosedOption) {
			case "1":
				
				break;
			case "2":
				break;
			case "3":
				break;
			case "4":
				break;
			case "5":
				break;

			default:
				break;
			}
		}
		private void displayPossibleTurnOptions() {
			System.out.println("[1] Punch\n"
					+ "[2] Attack With Weapon\n"
					+ "[3] Guard\n"
					+ "[4] Special Action\n"
					+ "[5] Run");
		}
		
	}
	
	
	private class TurnOrder{
		Queue<GamePlayers> playersQueue = new LinkedList<>();
		List<GamePlayers> playersList = new LinkedList<>();
		int AttackModifier = 0;
		
		
		public TurnOrder() {
			
			addOpponentsToPlayerList();
			addCharsToPlayerList();
			sortPlayersList();
			displayTurnQueue();
			
		}
		
		public void addOpponentsToPlayerList() {
		    // Clear the playersList to start fresh
		    playersList.clear();

		    // Add opponents from the initializer's opponentList
		    playersList.addAll(init.opponentList);
		}

		public void addCharsToPlayerList() {
			playersList.addAll(init.characterList);
		}
		public void sortPlayersList() {
		    // Sort the playersList based on speed in descending order
		    playersList.sort(Comparator.comparingDouble(GamePlayers::getSpeed).reversed());

		    // Clear the playersQueue before adding sorted players
		    playersQueue.clear();

		    // Add the sorted players to the playersQueue
		    playersQueue.addAll(playersList);

		    // Print the sorted playersQueue
		    
		}

		public void displayTurnQueue() {
			System.out.print("Turn Order: ");
			for (GamePlayers gamePlayer : playersQueue) {
		        if(gamePlayer instanceof Opponent) {
		        	Opponent obj = (Opponent) gamePlayer;
		        	System.out.print("Opponent "+obj.getName() + ", ");
		        }
		        else if(gamePlayer instanceof Human) {
		        	Human obj = (Human) gamePlayer;
		        	System.out.print(obj.getName() + ", ");
		        }
		        
		    }
		}
		public void defaultSendHeadToTail() {
			// after currentPlayer make move use this method. If there is no special action 
			GamePlayers currentPlayer = playersQueue.poll();
			
			playersQueue.offer(currentPlayer);
		}
		
		public void removeDeadPlayer() {
			// it must check the dealted player. 
			for (GamePlayers gamePlayer : playersQueue) {
				if(gamePlayer.getPoints() <= 0) {
					playersQueue.remove(gamePlayer);
				}
			}
		}
		
		public GamePlayers turnPlayer(Queue<GamePlayers> playersQeueue) {
			GamePlayers currentPlayer = playersQueue.peek();
			
			if(currentPlayer instanceof Opponent) {
				Opponent currentOpponent = (Opponent) currentPlayer;
				return currentOpponent;
			}else {
				if(currentPlayer instanceof Human) {
					Human currentHuman = (Human) currentPlayer;
					return currentHuman;
				}
			}
			return currentPlayer;
			
		}
		
		public void pickAgainstHuman(Queue<GamePlayers> playersQueue, int opponentId) {
			if(turnPlayer(playersQueue) instanceof Human) {
				Human currentPlayer = (Human) turnPlayer(playersQueue);
			 // check head of queue is human
			for (GamePlayers gamePlayer : playersQueue) {
				if(gamePlayer instanceof Opponent) {
					Opponent pickedOpponent = (Opponent) gamePlayer;
					if(pickedOpponent.getOpponentId() == opponentId) {
						
					}
				}
			}
		}
		}
		public Human pickAgainstOpponent(Queue<GamePlayers> playersQueue) {
			ArrayList<Human> possiblePickHumans = new ArrayList<Human>();
			for (GamePlayers gamePlayer : playersQueue) {
				if(gamePlayer instanceof Human) {
					Human possibleHuman = (Human) gamePlayer;
					possiblePickHumans.add(possibleHuman);
				}
			}
			Human pickedHuman = chooseRandomHuman(possiblePickHumans);
			return pickedHuman;
		}
		public Human chooseRandomHuman(ArrayList<Human> possiblePickHumans) {
			int randomIndex= random.nextInt(possiblePickHumans.size());
			
			return possiblePickHumans.get(randomIndex);
		}
		
		public void chooseRandomMove(Queue<GamePlayers> playersQeueue) {
			int randomMoveNumber = random.nextInt(3);
			if(turnPlayer(playersQeueue) instanceof Opponent) {
				Opponent currentOpponent = (Opponent) turnPlayer(playersQeueue);
				switch (randomMoveNumber) {
				case 0:
					pickAgainstOpponent(playersQueue).setPoints(currentOpponent.attack(pickAgainstOpponent(playersQueue)));
					break;
				case 1:
					// guard flag
					break;
				case 2:
					// special action
					break;

				default:
					break;
				}
			}
		}
//		public void attackModifier(GamePlayers currentPlayer, ArrayList<Opponent> opponentList) {
//			if(currentPlayer instanceof Opponent) {
//				
//				if(currentPlayer instanceof Slime) {
//					Slime currentSlime = (Slime) currentPlayer;
//					currentSlime.specialAction();
//				}
//				else if(currentPlayer instanceof Goblin) {
//					Goblin currentGoblin = (Goblin) currentPlayer;
//					currentGoblin.specialAction();
//				}
//				else if(currentPlayer instanceof Orc) {
//					Orc currentOrc = (Orc) currentPlayer;
//					currentOrc.specialAction();
//				}
//				else if(currentPlayer instanceof Wolf) {
//					Wolf currentWolf = (Wolf) currentPlayer;
//					currentWolf.specialAction(opponentList);
//				}
//			}
//			
//			else if(currentPlayer instanceof Human) {
//				
//				if(currentPlayer instanceof Knight) {
//					Knight currentKnight = (Knight) currentPlayer;
//					currentKnight.specialAction();
//				}
//				else if(currentPlayer instanceof Hunter) {
//					Hunter currentHunter = (Hunter) currentPlayer;
//					currentHunter.specialAction();
//				}
//				else if(currentPlayer instanceof Squire) {
//					Squire currentSquire = (Squire) currentPlayer;
//					currentSquire.specialAction();
//				}
//				else if(currentPlayer instanceof Villager) {
//					Villager currentVillager = (Villager) currentPlayer;
//					currentVillager.specialAction();
//				}
//			}
//		}
		
	}
}
