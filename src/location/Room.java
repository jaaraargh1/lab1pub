package location;
import player.Player;
public class Room extends Location {

    public Room(String name,  String longDescription, String shortDescription) {
	super(name, longDescription, shortDescription);

	
    }
 
    
    public void possibleDirections(String[] strArrayDirectons) {

       	for (int i = 0; i < getStrArrayDirections().length; i++) {

    	    if (getAdjacent(getStrArrayDirections()[i]) != null) {
    		System.out.print("Till " + getStrArrayDirections()[i] + " finns det en dörr till ");
                                  
    		
    		System.out.println(" " + (getAdjacent(getStrArrayDirections()[i])) + ".");
    	    }

    	}
        }
    
    
    
    
    
    
    @Override
    public void describeYourself(Player player) {
	System.out.println("Du är vid " + this.getName());

	player.getLocation().printDescription();
    
	if (player.isLitTorch() == true) {
	    System.out.println("Din torch lyser upp rummet lite mer och du ser dekadensens fotspår längs väggarna.");
	}
    }




	
}



		

	

