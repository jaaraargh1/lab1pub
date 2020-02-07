package item;
import player.Player;
public class Torch extends Tool {
private boolean litTorch = false;
	public Torch(String name, String description, double weight) {
		super(name, description, weight);
		// TODO Auto-generated constructor stub

	}




@Override
public void doCommand(String command, Player player) {
	
		

	if (command.equals("light")) {
		player.setTorch();
		player.deleteItemInventory("torch");
		System.out.println("Torchen försvann ur ditt inventory, men du brinner permanent");
		}




	
}	

}
