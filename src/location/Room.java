package location;

public class Room extends Location {

	public Room(String name,  String longDescription, String shortDescription) {

		super(name, longDescription, shortDescription);

	}
 
	


@Override
public void describeYourself() {
	System.out.println("Du är vid " + this.getName());
  //  player.getLocation().printDescription(player);

	//longDescription(player.getName());
	//possibleDirections(strArrayDirections);
}




	
}



		

	

