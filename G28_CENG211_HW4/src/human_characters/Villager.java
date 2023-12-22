package human_characters;

import java.util.concurrent.atomic.AtomicInteger;

import weapon.Weapon;

public class Villager extends Human{
	private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);
	public Villager() {
		super();
	}
	
	public Villager(String name) {
		this.name = name;
		this.id = ID_GENERATOR.getAndIncrement();
	}
	public Villager(String name, int id) {
		this.name = name;
		this.id = ID_GENERATOR.getAndIncrement();
	}

	@Override
	public double specialAction() {
		System.out.println("there is no any special actions for villager!!!");
		return 0;
	}

	@Override
	public String toString() {
		return "Villager " + super.toString() + "]";
	}

	


}
