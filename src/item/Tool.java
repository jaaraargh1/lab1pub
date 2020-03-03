package item;

import player.Player;

public abstract class Tool extends Item {

	public Tool(String name, String description, double weight) {
		super(name, description, weight);

	}

	
	public abstract void doCommand(String command, Player player );

	
	
	
}
