package location;

import java.util.HashMap;
import player.Player;


public abstract class Location {
	private String name;
	private HashMap<String, Location> adjacentLocations;
	private static String[] strArrayDirections = { "north", "east", "south", "west" };
	//private static String[] longDescriptionLocations = {"Blåhavet" ,"Korallen","A-huset","Pulen","B-huset"};
	private Location nextLocation;
	private boolean beenHere;
    private String longDescription;
    private String shortDescription;

	public Location(String name, Location pos, String longDescription, String shortDescription) {
		this.name = name;
		this.beenHere = false;
		this.longDescription = longDescription;
		this.shortDescription = shortDescription;

		adjacentLocations = new HashMap<String, Location>();
		}
	
	public void printDescription(Player player) {
		//String content = player.getLocation().toString();

	//	if (content.equals("Blåhavet"))  {
	        if (this.beenHere == false) {
                System.out.println(this.getLongDescription());
	        	
                System.out.println("xdddddddddddd");
	        	this.beenHere = true;	
	        } 
	        else {
               System.out.println(this.getShortDescription());
	        }	
			
 		}
	//}
	
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

	public static void setStrArrayDirections(String[] strArrayDirections) {
		Location.strArrayDirections = strArrayDirections;
	}

	@Override
	public String toString() {
		// Nu kan vi konvertera Location-objekt
		// till strängar och det blir snyggt!
		return this.getName();
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