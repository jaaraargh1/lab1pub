package location;

public class Room extends Location {


	public Room(String name, Location pos) {

		super(name, pos);

	}

	


@Override
public void describeYourself(String[] strArrayDirections) {
	System.out.println("YOu'RE at " + this.getName());
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
