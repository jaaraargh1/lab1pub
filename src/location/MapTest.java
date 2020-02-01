package location;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import location.Location;
import java.util.ArrayList;

public class MapTest {

	public static void main(String[] args) {

		Location woods  = new Location("Woods");
		Location sea    = new Location("Seashore");
		Location plains = new Location("Plains");
		Location castle = new Location("Castle");
		
		Map<String, Location> paths = new TreeMap<String, Location>();

		paths.put("north", woods);
		paths.put("south", sea);
		paths.put("west",  plains);
		paths.put("east",  castle);
		
		// Vi låtsas som att användaren har matat in en riktning:
		String userInput = "south";
		Location newLocation = paths.get(userInput);
		System.out.println("We are now at: " + newLocation);
	}

}