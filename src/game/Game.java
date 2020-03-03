package game;

import java.util.*;
import location.Location;
import player.Player;
import location.Room;
import location.OutdoorsArea;
import item.*;

public class Game {
	private Scanner keyboard;
	private Player player;

	public Game() {
		/*
		 * Create locations.
		 * 
		 */
		keyboard = new Scanner(System.in);
		Location ute = new OutdoorsArea("Blåhavet",
				"Du står i mitten av det Blåhavet, där allt är blått. Helt plötsligt så kommer Ukulelemannen med en gitarr i full fart i riktning mot"
						+ "det okända. Han tvärnitar och skriker -WHERE THE FUCK IS MY UKULELE??????. Du bör leta upp hans ukulele ",
				"Ukulele mannen åker runt i cirklar av förtvivlan vid det Blåhavet.");
		Location korallen = new Room("Korallen",
				"korallen, kaffet har kokat över och T.J flyter i ett hav av havremjök",
				"Snart kommer Korallen att svämma över av kaffe och havremjölk. T.J är sockret till kaffet. ");
		Location ahuset = new Room("A-huset",
				"Alla trappor har försvunnit, du behöver hitta ett sätt att ta dig till Pulen.",
				"Vad gör du fortfarande i A-huset, du behöver hitta ett sätt att ta dig vidare.");
		Location pulen = new Room("Pulen",
				"Pulen, ett rum som har tagit många människosjälar, det bör finnas något av värde här bland dessa tangenter. ",
				"Har du inte hittat något här så dör du leta runt, må finnas en bortglömd hatt här.");
		Location bhuset = new Room("B-huset",
				"B-huset, du har nu kommit till JAVA. Se till att yoinka en dryck då du inte fick något kaffe i Korallen.",
				"Java, Se till att konsumera koffein och undvik alla kodmonster");
		Location donken = new OutdoorsArea("Donken",
				"Du har vaknat vid Donken, när du väl lämnar den här platsen så kommer du aldrig att kunna komma tillbaka"
						+ "",
				"Du är vid Donken.");
		/*
		 * Create character
		 */
		String name;
		System.out.println("Welcome to the adventure game!\nWhat is your name?");
		name = keyboard.nextLine();

		player = new Player(name, donken, keyboard);
		System.out.println("Hello " + name
				+ "t. Du vaknar upp vid donken Ryd med en vacker minneslucka, något känns inte riktigt rätt. det är baserat på liv & död.! (Hint: there is a command \"help\").");

		/*
		 * Creating neighbours to our locations.
		 */
		ute.addAdjacentLocation("east", korallen);
		ute.addAdjacentLocation("west", ahuset);
		ute.addAdjacentLocation("south", bhuset);
		donken.addAdjacentLocation("south", ute);
		ahuset.addAdjacentLocation("north", pulen);
		ahuset.addAdjacentLocation("east", ute);

		korallen.addAdjacentLocation("west", ute);

		pulen.addAdjacentLocation("south", ahuset);

		bhuset.addAdjacentLocation("north", ute);

		player.setLocation(donken);
		/*
		 * Creating items.
		 */
		Shovel shovel = new Shovel("shovel",
				"A VERY RUSTY SHOVEL SHOULD PROBABLY NOT USE IT IN COMBAT, BUT YOU COULD PROBABLY DIG A SHALLOW HOLE.",
				(3.00));
		Ukulele ukulele = new Ukulele("ukulele",
				" Du bär just nu Ukulelemannens fina ukulele, ge den till honom innan hela campus går under.",
				(200.00));
		Hatt hatt = new Hatt("hatt", "En rosa fiskehatt med kaveldun", (0.02));
		Torch torch = new Torch("torch", "Använd den här för att få lite ljus", (8.00));
		/*
		 * Spawning our items at certain locations
		 */
		ute.addItems(ukulele);
		ute.addItems(shovel);
		pulen.addItems(hatt);
		bhuset.addItems(torch);

	}

	public void doCommand(String command) {
		if (command.equals("help")) {

			System.out.println("Du kan röra dig igenom att skriva North,East,West,South.\n  "
					+ "'directions', 'look'. har'u en torch så kan du använda 'light', 'ukulele'."
					+ "Finns även kommandon för 'use'.'items', 'inventory' .");
		} else
			player.doCommand(command, keyboard);

	}

	public void run() {

		while (true) {
			String command;
			player.getLocation().describeYourself(player);
			System.out.println("What do you want to do?");
			command = keyboard.nextLine();
			doCommand(command);
			// player.doCommand(command, keyboard);

		}
	}

}