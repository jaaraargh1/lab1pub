package location;

import java.util.HashMap;
import player.Player;

public abstract class Location {
	private String name;
	private HashMap<String, Location> adjacentLocations;
	private static String[] strArrayDirections = { "north", "east", "south", "west" };

	private Location nextLocation;

	public Location(String name, Location pos) {
		this.name = name;
		adjacentLocations = new HashMap<String, Location>();
		}

	
	

	
	public String getName() {

		return this.name;

	}
	public static String[] getStrArrayDirections() {
		return strArrayDirections;
	}

	public static void setStrArrayDirections(String[] strArrayDirections) {
		Location.strArrayDirections = strArrayDirections;
	}

	@Override
	public String toString() {
		// Nu kan vi konvertera Location-objekt
		// till strängar och det blir snyggt!
		return name;
	}


	public void addAdjacentLocation(String direction, Location place) {
		adjacentLocations.put(direction, place);
	}

	public Location getAdjacent(String direction) {
		return adjacentLocations.get(direction);
	}

	public abstract void describeYourself(String[] strArrayDirections);

	public void move(String command, Player name) {

		nextLocation = (getAdjacent(command));
		if (nextLocation != null) {

			name.setLocation(nextLocation);
		}
		
	}
		public void possibleDirections(String[] strArrayDirectons) {
			
			for (int i = 0; i < getStrArrayDirections().length; i++) {
				
				if (getAdjacent(getStrArrayDirections()[i]) != null) {
					System.out.println(
							"Till " + getStrArrayDirections()[i] + " hittar du " + (getAdjacent(getStrArrayDirections()[i])));
	             		
				}

	}
		}
}