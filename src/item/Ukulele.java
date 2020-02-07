package item;

import player.Player;

public class Ukulele extends Tool {

	public Ukulele(String name, String description, double weight) {
		// TODO Auto-generated constructor stub
		super(name, description, weight);
	}
	public void doCommand(String command, Player player) {

		if (command.equals("ukulele")) {
			player.setTorch();
			System.out.println("Du spelar skitdåligt på Ukulelemannens fina Ukulele, du bör nog ge skiten till honom. GgggggGGGGGGgggggGGG annars dödar han dig.");
			}
	
	
	
	}
}
