package player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import item.*;
import location.*;

public class Player {
	private String name;
	private Location currentPosition;
	private ArrayList<Item> inventory;
	private int healthPoints;
	private Scanner keyboard;
	private boolean wearingHatt;
	private boolean litTorch = false;

	public Player(String name, Location currentPosition) {
		this.name = name;
		this.currentPosition = currentPosition;
		this.healthPoints = 100;
		inventory = new ArrayList<Item>();
		keyboard = new Scanner(System.in);

	}

	public void setTorch() {

		this.litTorch = true;
		System.out.println("din torch brinner nu herpderp.");
	}

	public boolean getWearingHatt() {
		return this.wearingHatt;

	}

	public void addFoundItem(Item item) {

		inventory.add(item);
	}

	public boolean checkInventory(String command1) {
		for (Item item : inventory) {
			if (command1.equals(String.valueOf(item))) {
				return true;
			}

		}
		return false;

	}

	public void deleteItemInventory(String command1) {

		Iterator<Item> itemListIterator = inventory.iterator();

		while (itemListIterator.hasNext()) {

			Item i = itemListIterator.next();
			if (i.getName().equals(command1)) {

				System.out.println("tar nu upp itemet " + (command1));
				itemListIterator.remove();
			}
		}
	}

	public void setWearinItem() {

		this.healthPoints = healthPoints + 25;

	}

	public int getHealthPoints() {

		return this.healthPoints;
	}

	public void printInventory() {
		if (inventory != null) {
			System.out.println("players inventory");

			for (Item item : inventory) {
				item.printItemInfo();
			}
		}

		else {
			System.out.println("Du har inget i ditt inventory");
		}
	}

	public ArrayList<Item> getInventory() {
		return this.inventory;
	}

	public void addItem(String command1) {
		System.out.println(this.getLocation().getListOfAllItems());

		this.inventory.add(getLocation().removeItem(command1));
	}

	public String getName() {

		return this.name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public void setLocation(Location currentPosition) {

		this.currentPosition = currentPosition;

	}

	public Location getLocation() {
		return this.currentPosition;
	}

	public void doCommand(String command, Player player, String[] strArrayDirections) {
		String command1;
		if (command.equals("help")) {
			System.out.println("Du kan röra dig igenom att skriva North,East,West,South.\n fråga om "
					+ "vart man kan gå igenom att skriva 'directions', 'look'. har'u en torch så kan du använda 'light'");

		}
		if (command.equals("north") || (command.equals("west") || command.equals("east")) || command.equals("south"))
			;
		getLocation().move(command, player);

		if (command.equals("directions")) {
			player.getLocation().possibleDirections(strArrayDirections);

		}
		if (command.equals("look")) {
			if (this.getWearingHatt() == true) {
				System.out.println("Du bär en snygg hatt du ser väldigt Gucci ut");
			}

			player.getLocation().presentItems();
			player.getLocation().printDescription();

		}
		if (command.equals("take")) {
			System.out.println("What do you want to take?");
			command1 = keyboard.nextLine();
			System.out.println(command1);
			if (this.getLocation().getListOfAllItems().isEmpty()) {
				System.out.println("Finns inget att hämta här");
			} else {
				if (this.getLocation().checkItems(command1) == true) {

					this.addItem(command1);

				} else
					System.out.println("Itemet finns ej här.");
			}
		}

		if (command.equals("items")) {

			player.printInventory();
		}

		if (command.equals("wear")) {
			System.out.println("Vad vill du ta på dig herpderp? Notera att du bara kan bära en hatt & en gömd relik "
					+ "allt annat är för fairies, UwU ");
			command1 = keyboard.nextLine();

			if (player.checkInventory(command1) == true) {
				player.setWearinItem();
				deleteItemInventory(command1);
			}

		}

		if (command.equals("dig")) {

			System.out.println("test dig");
			for (Item item : inventory) {
				if (checkInventory("shovel") == true) {
					item.doCommand(command, player);

				}
			}

		}
		if (command.equals("light"))

		{
			for (Item item : inventory) {
				if (checkInventory("torch") == true) {
					item.doCommand(command, player);

				}

			}
		}

		if (command.equals("ukulele"))

		{
			for (Item item : inventory) {
				if (checkInventory("ukulele") == true) {
					item.doCommand(command, player);

				}

			}
		}
	}
}