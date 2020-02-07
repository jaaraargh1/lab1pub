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
	private Location currentPositionforLocation;
	


	public Location(String name, String longDescription, String shortDescription) {
		this.name = name;
		this.beenHere = false;
		this.longDescription = longDescription;
		this.shortDescription = shortDescription;
		listOfAllItems = new ArrayList<Item>();
		adjacentLocations = new HashMap<String, Location>();
	}



	public boolean checkItems(String command1) {
		for (Item item : listOfAllItems)
			if (command1.equals(String.valueOf(item))) {
				return true;
			}

		return false;
	}

	public ArrayList<Item> getListOfAllItems() {
		return this.listOfAllItems;
	}

	public void setLocation(Location currentPositionforLocation) {

		this.currentPositionforLocation = currentPositionforLocation;

	}

	public Location getLocation() {

		return this.currentPositionforLocation;
	}

	public Item removeItem(String command1) {

		Iterator<Item> itemListIterator = listOfAllItems.iterator();

		while (itemListIterator.hasNext()) {

			Item i = itemListIterator.next();
			// Item b = i;
			if (i.getName().equals(command1)) {

				System.out.println("tar nu upp itemet " + (command1));
				// System.out.println(player.getLocation());
				itemListIterator.remove();

				return i;
			}
		}
		return null;
	}

	public void presentItems() {
		System.out.println("Följande items finns vid platsen :^)");
		for (Item item : getListOfAllItems()) {
			System.out.println(item.getName() + "  " + item.getWeight() + "  " + item.getDescription());

		}

	}

	public Item getItem(String command1) {

		for (Item item : listOfAllItems)

			return item;
		return null;
	}

	public void printDescription() {
		if (this.beenHere == false) {
			System.out.println(this.getLongDescription());

			this.beenHere = true;
		} else {
			System.out.println(this.getShortDescription());
		}

	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getShortDescription() {
		return this.shortDescription;

	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getLongDescription() {
		return this.longDescription;

	}

	public void setName(String name) {

		this.name = name;

	}

	public String getName() {

		return this.name;

	}

	public static String[] getStrArrayDirections() {
		return strArrayDirections;
	}

	



	@Override
	public String toString() {

		return this.getName();
	}

	public void addAdjacentLocation(String direction, Location place) {
		adjacentLocations.put(direction, place);
	}

	public Location getAdjacent(String direction) {
		return adjacentLocations.get(direction);
	}

	public abstract void describeYourself();

	public void move(String command, Player name) {

		nextLocation = (getAdjacent(command));
		if (nextLocation != null) {

			name.setLocation(nextLocation);
		}

	}

	public void possibleDirections(String[] strArrayDirectons) {

		for (int i = 0; i < getStrArrayDirections().length; i++) {
            
                if (getAdjacent(getStrArrayDirections()[i]) != null) {
				System.out.print("Till " + getStrArrayDirections()[i]);
			    if(getAdjacent(getStrArrayDirections()[i]) instanceof Room)
                {System.out.print(" finns det en dörr  som leder till ");} else 
                {System.out.print(" finns det en väg som leder till ");}
System.out.println(" "+(getAdjacent(getStrArrayDirections()[i]))+ ".");
			}

		}
	}

	public void addItems(Item items) {
		listOfAllItems.add(items);
    
	}
}