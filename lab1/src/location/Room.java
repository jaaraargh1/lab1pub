package location;


public class Room extends Location {


	public Room(String name, Location pos, String longDescription, String shortDescription) {

		super(name, pos, longDescription, shortDescription);

	}
 
	


@Override
public void describeYourself(String[] strArrayDirections) {
	System.out.println("Du är vid " + this.getName());
	//longDescription(player.getName());
	possibleDirections(strArrayDirections);
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
