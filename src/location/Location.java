package location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import item.Item;

import player.Player;

public abstract class Location {

	private String name;
	private HashMap<String, Location> adjacentLocations;
	private static final String[] strArrayDirections = { "north", "east", "south", "west" };
	private Location nextLocation;
	private boolean beenHere;
	private String longDescription;
	private String shortDescription;
	private ArrayList<Item> listOfAllItems;

	// TODO: Komplettering: Location skall inte ha en player om ni inte
	// har en väldigt, väldigt bra anledning till det. Lämna en
	// kommentar med förklaring i så fall.

	public Location(String name, String longDescription, String shortDescription) {
		this.name = name;
		this.beenHere = false;
		this.longDescription = longDescription;
		this.shortDescription = shortDescription;
		listOfAllItems = new ArrayList<Item>();
		adjacentLocations = new HashMap<String, Location>();
	}

	/*
	 * prints directions when the player prints directions.
	 */
	public void doCommand(String command, Player player) {
		if (command.contentEquals("directions")) {
			possibleDirections(strArrayDirections);
		}
		if (command.contentEquals("look")) {
			presentItems();
			printDescription();
		}
		if (player.getLocation().checkItems(command) == true) {
			if (player.getLocation().getListOfAllItems().isEmpty()) {
				System.out.println("Finns inget att hämta här");
			} else {
				if (player.getLocation().checkItems(command) == true) {

					player.addItem(command);

				} else
					System.out.println("Itemet finns ej här.");

			}

		}
		if (command.equals("north") || (command.equals("west") || command.equals("east")) || command.equals("south"))
			;
		move(command, player);
	}

	/*
	 * 
	 * checks for items at the certain location
	 */
	public boolean checkItems(String command1) {
		for (Item item : listOfAllItems)
			if (command1.equals(String.valueOf(item))) {
				return true;
			}

		return false;
	}

	/*
	 * returns the items.
	 */
	public ArrayList<Item> getListOfAllItems() {
		return this.listOfAllItems;
	}

	/*
	 * 
	 * removes the items and sends it to a function in player to add it to the
	 * players inventory.
	 */
	public Item removeItem(String command1) {

		Iterator<Item> itemListIterator = listOfAllItems.iterator();

		while (itemListIterator.hasNext()) {

			Item i = itemListIterator.next();
			if (i.getName().equals(command1)) {

				System.out.println("tar nu upp itemet " + (command1));
				itemListIterator.remove();

				return i;
			}
		}
		return null;
	}

	/*
	 * Prints the items at the certain location.
	 */
	public void presentItems() {
		System.out.println("Följande items finns vid platsen :^)");
		for (Item item : getListOfAllItems()) {
			System.out.println(item.getName() + "  " + item.getWeight() + "  " + item.getDescription());

		}

	}

	/*
	 * returns the item if there is one.
	 */
	public Item getItem(String command1) {

		for (Item item : listOfAllItems)

			return item;
		return null;
	}

	/*
	 * 
	 * prints the description if u been there or not .
	 */
	public void printDescription() {
		if (this.beenHere == false) {
			System.out.println(this.getLongDescription());

			this.beenHere = true;
		} else {
			System.out.println(this.getShortDescription());
		}

	}

	// sets short description for the location
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	// returns the short description for the location
	public String getShortDescription() {
		return this.shortDescription;

	}

	// sets long description for the location
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	// returns the long description for the location
	public String getLongDescription() {
		return this.longDescription;

	}

	// set name for the location.
	public void setName(String name) {

		this.name = name;

	}

	// rreturns the name for the location.
	public String getName() {

		return this.name;

	}

	// returns the array wheter its N,E,W,S.
	public static String[] getStrArrayDirections() {
		return strArrayDirections;
	}

	@Override
	public String toString() {

		return this.getName();
	}

	// add neighbors to the location W/ hashmaps.
	public void addAdjacentLocation(String direction, Location place) {
		adjacentLocations.put(direction, place);
	}

	// return the neighbours.
	public Location getAdjacent(String direction) {
		return adjacentLocations.get(direction);
	}

	// abstract method for the describe urself, gets more precise at room & outdoors
	// level.
	public abstract void describeYourself(Player player);

	/*
	 * 
	 * function for the player to change location.
	 */

	public void move(String command, Player name) {

		nextLocation = (getAdjacent(command));
		if (nextLocation != null) {

			name.setLocation(nextLocation);
		}

	}

	/*
	 * returns if u can move N,E,S,W and wheter ifs a door or path to the next
	 * location, depending on its instance.
	 * 
	 */
	public abstract void possibleDirections(String[] strArrayDirectons);

	/*
	 * method to spawn items at specific locations.
	 */
	public void addItems(Item items) {
		listOfAllItems.add(items);

	}

}
