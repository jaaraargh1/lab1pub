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
	private ArrayList<Item> currentlyWearing;
	private int healthPoints;

	private boolean litTorch;

	public Player(String name, Location currentPosition, Scanner keyboard) {
		this.name = name;
		this.currentPosition = currentPosition;
		this.healthPoints = 100;
		inventory = new ArrayList<Item>();
		currentlyWearing = new ArrayList<Item>();
		// TODO: Komplettering: Här bör ni inte skapa en ny
		// scanner. Ifall ni behöver flera scanners i ert projekt,
		// skicka den ni redan har skapat som en parameter istället.
		this.litTorch = false;

	}

	/*
	 * checks if the torch is lit and returns t/f
	 */
	public boolean isLitTorch() {
		return litTorch;
	}

	/*
	 * 
	 * turns the torch on and lights up rooms.
	 */
	public void setTorch() {

		this.litTorch = true;
		System.out.println("din torch brinner nu herpderp.");
	}

	/*
	 * 
	 * equips a wearble item
	 */
	public void setWearingItem(Item item) {
		currentlyWearing.add(item);
	}
	/*
	 * 
	 * syso on what the player is currently wearing such as boots, hat, armor etc.
	 */

	public void printCurrentlyWearing() {

		if (currentlyWearing != null) {
			System.out.println("Du bär följande: ");

			for (Item item : currentlyWearing)
				item.printItemInfo();
		} else {
			System.out.println("Du bär inget, varför går du runt naken?");
		}
	}

	/*
	 * 
	 * 
	 * adds an item u have found.
	 */
	public void addFoundItem(Item item) {

		inventory.add(item);
	}

	/*
	 * 
	 * checks ur inventory for wearables.
	 */
	public boolean checkInventoryForWearable(String command1) {
		for (Item item : inventory) {
			if (command1.equals(String.valueOf(item)) && (item instanceof WearableItem)) {
				return true;
			}

		}
		return false;

	}

	/*
	 * 
	 * checks inventory if u have an object.
	 */
	public boolean checkInventory(String command1) {
		for (Item item : inventory) {
			if (command1.equals(String.valueOf(item))) {
				return true;
			}

		}
		return false;

	}

	/*
	 * 
	 * 
	 * equips an item of ur wearables.
	 */
	public void equipItem(String command) {

		Iterator<Item> itemListIterator = inventory.iterator();

		while (itemListIterator.hasNext()) {

			Item i = itemListIterator.next();
			if (i.getName().equals(command)) {

				System.out.println("tar nu upp på dig " + (command));
				currentlyWearing.add(i);
				itemListIterator.remove();

			}
		}
	}

	/*
	 * 
	 * 
	 * deletes items from ur inventroy
	 */
	public void deleteItemInventory(String command1) {

		Iterator<Item> itemListIterator = inventory.iterator();

		while (itemListIterator.hasNext()) {

			Item i = itemListIterator.next();
			if (i.getName().equals(command1)) {

				itemListIterator.remove();
			}
		}
	}
	/*
	 * 
	 * 
	 * sets HP bonus for wearables.
	 */

	// TODO: Komplettering: Denna funktionalitet hör snarare hemma i
	// putOn( .. ) i item-klassen

	/*
	 * 
	 * 
	 * returns current healthspoints.
	 */
	public int getHealthPoints() {

		return this.healthPoints;
	}

	public void setHealthPoints(int hp) {

		this.healthPoints = healthPoints + (hp);

	}

	/*
	 * 
	 * prints ur inventory.
	 */
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

	// returns the inventory.
	public ArrayList<Item> getInventory() {
		return this.inventory;
	}

	// calls a function in location that returns an item and delets it from the
	// location.
	public void addItem(String command1) {

		this.inventory.add(getLocation().removeItem(command1));
	}

	// gets player name
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
	/*
	 * 
	 * do command for lots of different functions, movement, directions, take
	 * commands etc. directs most of players functions in-game.
	 */

	// TODO: Komplettering: Ni behöver inte skicka in player som en
	// parameter i denna. Ni har ju redan åtkomst till spelar-objektet
	// genom att använda "this".

	// TODO: Komplettering: doCommand i player bör inte kolla efter
	// kommandon som rör andra klasser. Den bör istället
	// 'vidarebefodra' kommandot till de klasser som kan vara
	// intresserade av den. Ifall vi, som det ser ut nu, skulle lägga
	// till ett tool så skulle vi få lägga till ännu en if-sats i
	// spelarens doCommand. Skulle vi lägga till flera tools så skulle
	// det snabbt bli ohållbart och vår doCommand skulle bli
	// jättelång. Låt istället klasserna själva kolla på kommandot och
	// avgöra om de skall göra något.
	public void doCommand(String command, Scanner keyboard) {
		// TODO: Kommentar 2: Help hör antagligen inte till
		// player heller utan snarare till game.

		if (command.equals("north") || (command.equals("west") || command.equals("east")) || command.equals("south"))
			;
		getLocation().doCommand(command, this);
		// TODO: Komplettering 2: Samma komplettering
		// nedanför. Ge location kommandot utan några
		// kontroller och låt den testa själv. Som det ser ut
		// nu gör ni dubbla kontroller. En i player och en i
		// location.
		if (command.equals("directions")) {

			getLocation().doCommand(command, this);

		}
		if (command.equals("look")) {
			getLocation().doCommand(command, this);

		}

		// TODO: Kommentar 2: Detta är väldigt liknande
		// kompletteringen nedanför. Istället för att lägga
		// hela kontrollen i player så är det snarare något som
		// Location-klassen skulle kunna sköta själv.
		if (command.equals("take")) {
			System.out.println("What do you want to take?");
			command = keyboard.nextLine();
			getLocation().doCommand(command, this);

		}

		if (command.equals("items")) {
			System.out.println("ditt nuvarande HP är följande " + getHealthPoints() + ".");

			printInventory();
		}
		// TODO: Komplettering 2: Detta gäller både "wear"- och
		// "use"-kommandot. När ni gör på det här sättet så gör
		// doCommand ingenting med själva kommandot. Den agerar
		// snarare som en "use" eller "wear"-metod. Kommandot
		// som ni skickar med fyller inget syfte. Dessutom görs
		// kontrollen fortfarande i "Player" klassen. Låt alla
		// items ta emot kommandot och låt kontrollen av
		// kommandot ligga i item-klasserna själva istället.

		if (command.equals("wear")) {
			System.out.println("Vad vill du ta på dig herpderp? ");
			command = keyboard.nextLine();
			for (Item item : inventory) {

				item.doCommand(command, this);

			}
			equipItem(command);

		}

		if (command.equals("use"))

		{
			System.out.println("What item do you want to use?");
			command = keyboard.nextLine();
			System.out.println("what do u want to do with it? hint dig");

			for (Item item : inventory) {
				command = keyboard.nextLine();
				item.doCommand(command, this);

			}
		}

	}

}
