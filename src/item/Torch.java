package item;
import player.Player;
public class Torch extends Tool {
	public Torch(String name, String description, double weight) {
		super(name, description, weight);
		// TODO Auto-generated constructor stub

	}




@Override
public void doCommand(String command, Player player) {
	
		

	if (command.equals("use")) {
		player.setTorch();
		System.out.println("din ljuskälla ser ut att vara oändlig? what is this SORCERY?");
		}




	
}	

}
