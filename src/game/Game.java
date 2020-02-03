package game;

import java.util.*;
import location.Location;
import player.Player;
import location.Room;
import location.OutdoorsArea;
import item.Item;
import item.Tool;

public class Game {
	private Scanner keyboard;
	private Player player;
	private String[] strArrayDirections;
	private Item item;
	private Location location;

	// private Location location;
	public Game() {

		keyboard = new Scanner(System.in);
		// locations = new ArrayList<>();

		// HashMap<String, Location> paths = new HashMap<String, Location>();

		// Provide information for the new items that are to be created.

		// Skapa platser
		Location ute = new OutdoorsArea("Blåhavet", null, "rofl rofl rofl rofl rofl rofl", "ute very short");
		Location korallen = new Room("Korallen", null, "Long discription korallen", "Short description KORALLEN");
		Location ahuset = new Room("A-huset", null, "EN JÄTTE BRA LÅNG DESCRIPTION FÖR A HUSET", "very short");
		Location pulen = new Room("Pulen", null, "PULEN LÅNG", "EN JÄTTE BRA kort DESCRIPTION FÖR PULEN");
		Location bhuset = new Room("B-huset", null, "BB HUSET LÅÅÅÅÅÅÅÅNG",
				"KOOOOOOOOOOOOOOOOOORT DESCRIPTION B HUSEt");
		Location donken = new OutdoorsArea("Donken", null, "Long discription Donken", "Short description Donken");

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
        donken.addAdjacentLocation("south", ute);
		ahuset.addAdjacentLocation("north", pulen);
		ahuset.addAdjacentLocation("east", ute);

		korallen.addAdjacentLocation("west", ute);

		pulen.addAdjacentLocation("south", ahuset);

		bhuset.addAdjacentLocation("north", ute);

		Tool shovel = new Tool("Shovel","A VERY RUSTY SHOVEL SHOULD PROBABLY NOT USE IT IN COMBAT, BUT YOU COULD PROBABLY DIG A SHALLOW HOLE.",(3.00));
		Tool pen = new Tool("Pen ", " test", (2.00));
		// currentPosition = Ahuset;
   		player.setLocation(ute);
        
   		ahuset.addItems(shovel);
        ute.addItems(pen);

	}
	// private HashMap <String, Location> adjacentLocations;

	public void run() {
		while (true) {
			String command;
		    player.getLocation().presentItems();
			player.getLocation().getLongDescription();
			// player.getLocation().getLongDescription();
			player.getLocation().describeYourself(strArrayDirections);
			player.getLocation().printDescription(player);
			System.out.println("What do you want to do?");
			command = keyboard.nextLine();
			player.getLocation().move(command, player);
			// player.moveTo(command,location);
			// player.getLocation().longDescription(player);

			player.doCommand(command);
			// moveTo(String command, Location location
		}
	}

}