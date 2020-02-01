package game;

import java.util.*;
import location.Location;
import player.Player;
import location.Room;
import location.OutdoorsArea;
public class Game {
	private Scanner keyboard;
	private Player player;
	private String[] strArrayDirections;
	//private Location nextLocation;

	public Game() {

		keyboard = new Scanner(System.in);
		// locations = new ArrayList<>();

		// HashMap<String, Location> paths = new HashMap<String, Location>();


		// Provide information for the new items that are to be created.

		// Skapa platser
		Location ute = new OutdoorsArea("Blåhavet", null);
		Location korallen = new Room("Korallen", null);
		Location ahuset = new Room("A-huset", null);
		Location pulen = new Room("Pulen", null);
		Location bhuset = new Room("B-huset", null);
		// spelare
		String name;
		System.out.println("Welcome to the adventure game!\nWhat is your name?");
		name = keyboard.nextLine();

		player = new Player(name, ute);
		System.out.println("Hello " + name
				+ ", welcome to this magical world of wonder! You can move around by typing north/south/west/east. You will have to learn more commands as you play the game! (Hint: there is a command \"help\").");
		;

		// Lägg till pekare så att ute får lite hjälp :))))))
		ute.addAdjacentLocation("east", korallen);
		ute.addAdjacentLocation("west", ahuset);
		ute.addAdjacentLocation("south", bhuset);

		ahuset.addAdjacentLocation("north", pulen);
		ahuset.addAdjacentLocation("east", ute);
		
		korallen.addAdjacentLocation("west", ute);
          
		pulen.addAdjacentLocation("south", ahuset);

		bhuset.addAdjacentLocation("north", ute);
		
		// currentPosition = Ahuset;
		player.setLocation(ute);

	}
	// private HashMap <String, Location> adjacentLocations;

	public void run() {

		while (true) {
			String command;
			player.getLocation().describeYourself(strArrayDirections);

			System.out.println("What do you want to do?");
			command = keyboard.nextLine();
		   player.getLocation().move(command, player);
            // player.moveTo(command,location);

			player.doCommand(command);
            //moveTo(String command, Location  location
		}
	}

}