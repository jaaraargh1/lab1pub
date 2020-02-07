package item;
import player.Player;
public class WearableItem extends Item {

	public WearableItem(String name, String description, double weight) {
		super(name, description, weight);
	}
	
	
	@Override
	public void doCommand(String command1, Player player) {
		// TODO Auto-generated method stub
		
	}

	/*public void putOn(String command1, Player player) {   
		if (player.checkInventory(command1) == true && player.getWearingHatt()== false) {
			player.setWearingHatt();		
		}
	*/
	
}
