package player;

import location.Location;


public class Player {

	private String name;
	private Location currentPosition;
	public Player(String name, Location currentPosition) {
		this.name = name;
		this.currentPosition = currentPosition;

	}

	public String getName() {

		return this.name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public void setLocation(Location currentPosition) {

		this.currentPosition = currentPosition;

	}

	public Location getLocation() {
		return currentPosition;
	}

	public void doCommand(String command) {
		if (command.equals("help")) {
			System.out.println("Du kan röra dig igenom att skriva North,East,West,South.\n fråga om "
					+ "vart man kan gå igenom att skriva 'directions'.");

		}

	}

     
	/*
	public void moveTo(String command, Location  location) {
		nextLocationTest = (location.getAdjacent(command));
		System.out.println(nextLocationTest);
		if (nextLocationTest != null) {

			setLocation(nextLocationTest);
		}
		*/
	
}

	
	
	