package item;

import player.Player;

public class ElvenArmor extends WearableItem {

	public ElvenArmor(String name, String description, double weight) {
		super(name, description, weight);

	}
	public void putOn(Player player) {
		System.out.println("du tar på nu på dig " + this.getName());
		setWearinItem(player);
		
	}
	public void doCommand(String command, Player player) {
		if (command.equals("elvenarmor")) {
			putOn(player);
		}
	}
	public void setWearinItem(Player player) {
		System.out.println("testasd");
		player.setHealthPoints(50);
		System.out.println("Din hälsa ökade med 50! Efter du tog på dig ditt item. tihihi");
	}
}
