package tbGame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

import characters.Human;
import characters.Hunter;
import characters.Knight;
import characters.Squire;
import characters.Villager;
import exceptions.NotAUniqueNameException;
import opponents.Opponent;
import opponents.Goblin;
import opponents.Orc;
import opponents.Slime;
import opponents.Wolf;
import utils.Utilities;
import weapon.Weapon;
import weapon.Bow;
import weapon.Spear;



public class TBGame {
	private ArrayList<Opponent> opponentList = new ArrayList<Opponent>();
	private ArrayList<Human<Weapon>> characterList = new ArrayList<Human<Weapon>>();
	private LinkedList<Turn> turnQueue = new LinkedList<>();
	private Opponent currentOpponent = null;
	private Human<? extends Weapon> currentHuman = null;
	private Scanner scanner = new Scanner(System.in);
	private boolean run = false;
	
	Initializer init = new Initializer();
	Menu menu = new Menu();
	
	// initialize opponents  +
	// opponents arrayList   +
	// welcome page includes opponents infos + 
	// ask how many characters player wants to create + 
	// add character(s) to arraylist + 
	// print the character info from list + 
	
	// create a queue that has opponents and characters for play turn + 
	// turn Queue. Order is determined according to speed stat. +
	// make the attack attribute + 
	// finish the turn and take it to tail of queue +
	// if special action occures queue might change. +
	// remove who has 0 or less points. +
	private boolean isOpponent(Turn turn) {
		for (Human<? extends Weapon> human : characterList) {
			if (human.getName().equalsIgnoreCase(turn.getTitle()))
				return false;
		}
		return true;
	}
	private void setCurrentOpponent(String id) {
		for (Opponent opponent : opponentList) {
			if (String.valueOf(opponent.getId()).equalsIgnoreCase(id)) {
				currentOpponent = opponent;
			}
		}
	}
	private void setCurrentHuman(String name) {
		for (Human<? extends Weapon> human : characterList) {
			if (human.getName().equalsIgnoreCase(name))
				currentHuman = human;
		}
	}
	private Human<? extends Weapon> getRandomHuman() {
		return characterList.get(Utilities.inclusiveRandomValueCreator(0, characterList.size() - 1));
	}
	private Wolf wolfSpecialAction(Wolf wolf) {
		if (Utilities.inclusiveRandomValueCreator(0, 5) == 0) {
			return wolf.returnNewWolf();
		} else
			return null;
	}
	private void gameRunner(Scanner scanner) {
		while(run !=true && opponentList.size() != 0 && characterList.size() != 0) {
			Turn turn = turnQueue.pollFirst();
			if(isOpponent(turn)) {
				setCurrentOpponent(turn.getTitle());
				currentOpponent.setGuardFlag(false);	
				double damageWithoutModifier = randomMoveOfOpponent(currentOpponent, turn);
				if(turn.getAttackModifier() == 0) {
					if(currentOpponent instanceof Wolf) {
						Wolf currentWolf = (Wolf) currentOpponent;
						Wolf newWolf = wolfSpecialAction(currentWolf);
						if(newWolf != null) {
							opponentList.add(newWolf);
							Turn wolfTurn = new Turn(String.valueOf(newWolf.getId()), (int) newWolf.getSpeed());
							turnQueue.addFirst(wolfTurn);
						}
					}
					if(currentOpponent instanceof Goblin) {
						Goblin currentGoblin = (Goblin) currentOpponent;
						if(currentGoblin.getIsGoblinWaitOneTour() == false) {
							currentGoblin.setIsGoblinWaitOneTour(true);
							turnQueue.addLast(turn);
						}
						else {
							turn.setAttackModifier(1);
							turnQueue.addFirst(turn);
						}
					}
					else {
						turnQueue.addLast(turn);
						turn.setAttackModifier(1);
					}
				}
				else if(turn.getAttackModifier() > 0) {
					randomHitMoveOfOpponent(damageWithoutModifier, turn);
					if(currentOpponent instanceof Orc && turn.getAttackModifier() == 2) {
						turn.setAttackModifier(0);
						turnQueue.add(turn);
					}
					else if(currentOpponent instanceof Goblin && turn.getAttackModifier() == 0.7) {
						((Goblin) currentOpponent).setIsGoblinWaitOneTour(false);
						turn.setAttackModifier(0);
						turnQueue.addLast(turn);
					}
					else if(currentOpponent instanceof Goblin && turn.getAttackModifier() == 1) {
						if(((Goblin) currentOpponent).getIsGoblinWaitOneTour() == true) {
							turnQueue.addFirst(turn);
							((Goblin) currentOpponent).setIsGoblinWaitOneTour(false);
						}
						else {
							turnQueue.addLast(turn);
						}
					}
					else {
						turn.setAttackModifier(1);
						turnQueue.addLast(turn);
					}
				}
			}
			else {
				setCurrentHuman(turn.getTitle());
				System.out.println("Turn of: " + turn.getTitle());
				currentHuman.setGuardFlag(false);
				double damageWithoutModifier = 0;
				if(turn.getAttackModifier() != 0) {
					displayMoveOptions();
					damageWithoutModifier = defatultHumanAttackDamage(scanner, turn);
					while(damageWithoutModifier< 0) {
						damageWithoutModifier = defatultHumanAttackDamage(scanner, turn);
					}
					}
				else {
					System.out.println(turn.getTitle() + "passed the current round");
				}
				if(turn.getAttackModifier() == 0) {
					if(currentHuman instanceof Knight) {
						turnQueue.addLast(turn);
						System.out.println(turn.getTitle() + "passed the current round");
						turn.setAttackModifier(3);
					}
					else if(currentHuman instanceof Hunter) {
						Hunter currentHunter = (Hunter) currentHuman;
						if(currentHunter.isHunterWaitOneTour() == false) {
							currentHunter.setHunterWaitOneTour(true);
							turnQueue.addLast(turn);
							turn.setAttackModifier(1);
						}
						else {
							turn.setAttackModifier(1);
							turnQueue.addFirst(turn);
						}
					}
					else {
						turnQueue.addLast(turn);
						turn.setAttackModifier(1);
					}
				}
				else if(turn.getAttackModifier() > 0) {
					if(turn.getAttackModifier() == 0.5) {
						if(currentHuman instanceof Squire) {
							if(damageWithoutModifier == 0) {
								turnQueue.add(turn);
							}
							else {
								hitOfHuman(damageWithoutModifier, turn, scanner);
								turnQueue.addLast(turn);
								turn.setAttackModifier(1);
							}
						}
						if(currentHuman instanceof Hunter) {
							if(damageWithoutModifier == 0) {
								turnQueue.addFirst(turn);
							}
							else {
								hitOfHuman(damageWithoutModifier, turn, scanner);
								turnQueue.addLast(turn);
								turn.setAttackModifier(0);
							}
						}
					}
					else {
						if(currentHuman instanceof Hunter) {
							Hunter currentHunter = (Hunter) currentHuman;
							if(currentHunter.isHunterWaitOneTour() == false) {
								hitOfHuman(damageWithoutModifier, turn, scanner);
								turnQueue.addLast(turn);
								turn.setAttackModifier(1);
							}
							else {
								turn.setAttackModifier(1);
								hitOfHuman(damageWithoutModifier, turn, scanner);
								turnQueue.addFirst(turn);
								currentHunter.setHunterWaitOneTour(false);
							}
						}
						else {
							hitOfHuman(damageWithoutModifier, turn, scanner);
							turnQueue.addLast(turn);
							turn.setAttackModifier(1);
						}
					}
					
				}
			}
		}
	}
	private double defatultHumanAttackDamage(Scanner sc, Turn turn) {
		
		switch (intInputOfUser(sc, 5, "Please select  move: ")) {
		case 1: {
			return currentHuman.punch();
		}
		case 2: {
			return currentHuman.attackWithWeapon(attackTypeOfSelectedWeapon(menu, sc));

		}
		case 3: {
			System.out.println(turn.getTitle() + " guarded.");
			currentHuman.setGuardFlag(true);
			return 0;
		}
		case 4: {
			double tempAttackModi = currentHuman.specialAction();
			if (tempAttackModi < 0)
				return tempAttackModi;
			else {
				turn.setAttackModifier(tempAttackModi);
				return 0;
			}

		}
		case 5: {
			run = true;
			System.out.println("Your character(s) running away. The battle ends! Thanks for playing!");
			System.exit(0);
			return 0;
		}
		}
		return 0; 
	}
	private int attackTypeOfSelectedWeapon(Menu menu, Scanner sc) {
		if (currentHuman.getWeapon() instanceof Bow) {
			return intInputOfUser(sc, 2,"Please select weapon attack type ([1] SingleArrow [2] TwoArrow):");
		}
					
		else if (currentHuman.getWeapon() instanceof Spear) {
			return intInputOfUser(sc, 2, "Please select weapon attack type ([1] Stap [2] Throw):");
		}
		else {
			return intInputOfUser(sc, 2, "Please select weapon attack type ([1] Slash [2] Stab):");
	}
	}

	private void randomHitMoveOfOpponent(double damageWithOutModifier, Turn turn) {
		Human<? extends Weapon> tempHuman = getRandomHuman();
		int totalDamageGiven = currentOpponent.hitToAnyHuman(turn.getAttackModifier() * damageWithOutModifier,
				tempHuman);
		if(damageWithOutModifier != 0) {
			System.out.println("Opponent" + currentOpponent.getId() + " attacks " + tempHuman.getName() + ". Deals "
					+ totalDamageGiven + " damage.");
			System.out.println(tempHuman.toString());
			if (tempHuman.getPoints() <= 0)
				deleteHuman(tempHuman);
		}else {
			System.out.println("Opponent " +currentOpponent.getId() + " have guarded." );
			System.out.println();
		}
	}
	private void hitOfHuman(double damageWithOutModifier, Turn turn, Scanner sc) {
		if(damageWithOutModifier != 0) {
		Opponent opponent = selectOpponentWithUserInput(sc);
		int givenDamage = opponent.takeDamage(damageWithOutModifier * turn.getAttackModifier());
		System.out.println(turn.getTitle() + " attacks to Opponent " + opponent.getId() + " . Deals " + givenDamage
				+ " damage");
		System.out.println(opponent.toString());
		if(opponent.getPoints()<0) {
			deleteOpponent(opponent);
		}
		}
	}
	private Opponent selectOpponentWithUserInput(Scanner sc) {
		int desiredId = getIdFromUser(sc, getIdsCouldBeSelect());
		for (Opponent opponent : opponentList) {
			if (opponent.getId() == desiredId)
				return opponent;
		}
		return null; 

	}
	private ArrayList<Integer> getIdsCouldBeSelect() {
		ArrayList<Integer> idList = new ArrayList<>();
		for (Opponent opponent : opponentList) {
			idList.add(opponent.getId());
		}
		return idList;
	}
	private int getIdFromUser(Scanner sc, ArrayList<Integer> idList) {
		System.out.print("Please enter an opponent id: ");
		System.out.println();
		int id = sc.nextInt();
		sc.nextLine();
		boolean idExist = idList.contains(id);
		if (idExist) {
			return id;
		} else {
			while (!idExist) {
				System.out.print("that input doesn't relay on opponent list");
				id = sc.nextInt();
				sc.nextLine();
				idExist = idList.contains(id);
			}
			return id;
		}
	}


	private void deleteHuman(Human<? extends Weapon> human) {
		deleteFromCharacterList(human.getName());
		deleteFromQueue(human.getName());
	}
	private void deleteOpponent(Opponent opponent) {
		deleteFromOpponentList(opponent.getId());
		deleteFromQueue(String.valueOf(opponent.getId()));
	}
	
	private void deleteFromOpponentList(int id) {
		Opponent tempOpponent = null;
		for (Opponent Opponent : opponentList) {
			if(Opponent.getId() == id)
				tempOpponent = Opponent;
		}
		opponentList.remove(tempOpponent);
	}
	
	private void deleteFromCharacterList(String name) {
		Human<? extends Weapon> tempHuman = null;
		for (Human<? extends Weapon> human : characterList) {
			if (human.getName().equalsIgnoreCase(name))
				tempHuman = human;
		}
		characterList.remove(tempHuman);
	}

	private void deleteFromQueue(String name) {
		Turn tempTurn = null;
		for (Turn turn : turnQueue) {
			if (turn.getTitle().equalsIgnoreCase(name))
				tempTurn = turn;
		}
		turnQueue.remove(tempTurn);
	}
	private double randomMoveOfOpponent(Opponent opponent, Turn turn) {
		if (turn.getAttackModifier() != 0) {
			switch (Utilities.inclusiveRandomValueCreator(1, 3)) {
			case 1: 
				//punch
				return opponent.attack();
			case 2: 
				opponent.guard();
				return 0;
			case 3: 
				turn.setAttackModifier(opponent.specialAction());
				// attack with modifier
				return opponent.attack();
			}
		}
		return 0;
	}
	private class Initializer{
		
		public Initializer() {}
		
		private void initOpponents() {
			
			for (int i = 0; i < Utilities.inclusiveRandomValueCreator(1, 4); i++) {
				Opponent randomOpponent = pickOpponent();
				opponentList.add(randomOpponent);
				turnQueue.add(new Turn(String.valueOf(randomOpponent.getId()), (int) randomOpponent.getSpeed()));
			}
		}
		private Opponent pickOpponent() {
			switch (Utilities.inclusiveRandomValueCreator(1, 4)) {
			case 1:
				return new Goblin();
			case 2:
				return new Orc();
			case 3:
				return new Slime();
			case 4:
				return new Wolf();
			}
			return null; 
		}
		private void initChars(int number) {
		   
		    int chCreateValue = number;

		    while (chCreateValue > 0) {
		        int randomCharCreateValue = Utilities.inclusiveRandomValueCreator(1, 4);

		        // Ask the user to input the name for each character
		        System.out.print("Enter name for your " + (characterList.size() + 1) + ". character: ");
		        String characterName = scanner.next();

		        try {
		            // Check for name duplication before creating a new character
		            isNameDuplicated(characterName);

		            switch (randomCharCreateValue) {
		                case 1:
		                    Knight<Weapon> tempKnight = new Knight<>(characterName);
		                    characterList.add(tempKnight);
		                    turnQueue.add(new Turn(tempKnight.getName(), (int) tempKnight.getSpeed()));
		                    break;
		                case 2:
		                    Hunter<Weapon> tempHunter = new Hunter<>(characterName);
		                    characterList.add(tempHunter);
		                    turnQueue.add(new Turn(tempHunter.getName(), (int) tempHunter.getSpeed()));
		                    break;
		                case 3:
		                    Squire<Weapon> tempSquire = new Squire<>(characterName);
		                    characterList.add(tempSquire);
		                    turnQueue.add(new Turn(tempSquire.getName(), (int) tempSquire.getSpeed()));
		                    break;
		                case 4:
		                    Villager<Weapon> tempVillager = new Villager<>(characterName);
		                    characterList.add(tempVillager);
		                    turnQueue.add(new Turn(tempVillager.getName(), (int) tempVillager.getSpeed()));
		                    break;
		                default:
		                    throw new IllegalArgumentException("Unexpected value: " + randomCharCreateValue);
		            }
		            
		            chCreateValue--;
		        } catch (NotAUniqueNameException e) {
		            
		            System.out.println(e.getMessage());
		        }
		    }
		}
		
		private void isNameDuplicated(String name) throws NotAUniqueNameException {
			for (Human<? extends Weapon> human : characterList) {
				if (human.getName().equalsIgnoreCase(name))
					throw new NotAUniqueNameException("This name has already given to an another character");
			}
		}
		
	}
	
	private class Menu{
		public Menu() {
			displayMenu();
		}
		private void sortQueue() {
			System.out.print("Turn Queue: ");
			Collections.sort(turnQueue, new Comparator<Turn>() {
				@Override
				public int compare(Turn turn1,  Turn turn2) {
					return turn2.getSpeed() - turn1.getSpeed();
				}
			}
			);
		}
		private void displayMenu() {
			System.out.println("Welcome to TB Game");
			init.initOpponents();
			System.out.println("These opponents appeared in front of you:");
			displayCollection(opponentList);
			init.initChars(intInputOfUser(scanner, 3, "Please enter the number of character(s) to create: "));
			displayCollection(characterList);
			sortQueue();
			displayQueue(turnQueue);
			gameRunner(scanner);
}
		private void displayCollection(Collection<? extends Object> col) {
			for (Object object : col) {
				System.out.print(object.toString());
				System.out.println();
			}
			
		}
		private void displayQueue(Collection<Turn> queue) {
			for (Turn turn : turnQueue) {
				System.out.print(turn.getTitle()+  " ");
			}
			System.out.println();
		}
		}
		private void displayMoveOptions() {
			System.out.println("[1] Punch\n"
					+ "[2] Attack With Weapon\n"
					+ "[3] Guard\n"
					+ "[4] Special Action\n"
					+ "[5] Run");
		}
		private int intInputOfUser(Scanner sc, int upperBoundary, String message) {
			System.out.print(message);
			int selectedNumber = sc.nextInt();
			sc.nextLine();
			while (selectedNumber < 1 || selectedNumber > upperBoundary) {
				System.out.println();
				System.out.print("Please write an proper opinion: ");
				selectedNumber = sc.nextInt();
				sc.nextLine();
			}
			return selectedNumber;
		}
}
