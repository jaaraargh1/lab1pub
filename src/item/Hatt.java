package item;

import player.Player;

public class Hatt extends WearableItem {

	public Hatt(String name, String description, Double weight) {
		super(name,description,weight);
		// TODO Auto-generated constructor stub
	}
	public void putOn(Player player) {
		System.out.println("du tar på nu på dig " + this.getName() + " du ser lika fräsch ut som en person som bär Fedora.");
		setWearinItem(player);
	}
	public void doCommand(String command, Player player) {
		if (command.equals("hatt")) {
			putOn(player);
		}
	}
	public void setWearinItem(Player player) {
		player.setHealthPoints(25);
		System.out.println("Din hälsa ökade med 25! Efter du tog på dig ditt item. tihihi");
	}

}
