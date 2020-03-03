package item;

import player.Player;

//TODO: Komplettering: Här skall ni implementera putOn enligt labbhandledningen. 
public abstract class WearableItem extends Item {

	public WearableItem(String name, String description, double weight) {
		super(name, description, weight);
	}

	@Override
	public abstract void doCommand(String command, Player player);

	public abstract void putOn(Player player);

	public abstract void setWearinItem(Player player);

}
