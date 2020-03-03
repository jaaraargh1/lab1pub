package item;

import player.Player;

public class Shovel extends Tool {
	private boolean foundItem = false;

	public Shovel(String name, String description, double weight) {
		super(name, description, weight);

	}
/*if u got a shovel and is spending some time at Blåhavet u can probably dig some
 * to find a lovely treasure such as an elvenarmor, which uy can wear. the Shovel
 *  will be destroyed after using it and finding ur item.
 */
	private void dig(Player player) {

		if (player.checkInventory("shovel") == true) {
			System.out.println("Du gräver efter något med din rostiga spade :|");
			System.out.println(player.getLocation());
			if (player.getLocation().getName().equals("Blåhavet") == true)
				if (foundItem == false) {
					ElvenArmor elvenarmor = new ElvenArmor("elvenarmor", "en relik från lajvare", (15.00));

					System.out.println(
							"wtf du hittade ett sjukt ornament, ser ut som om att du blir starkare av den om du hade tagit på dig den.");
					player.addFoundItem(elvenarmor);
					System.out.println("");

					foundItem = true;
					player.deleteItemInventory("shovel");
					System.out.println("OOOOps DIN SPADE GICK SÖNDEr HEHEHEHEHEHhEHEH, rostig som satan var den iofs.");
				}

		} else {
			System.out.println("du har ingen spaaaaaaaaaade g_G samt har redan funnit ditt item :]");
		}
	}
/*
 * Do command for dig.
 * 
 */
    //TODO: Kommentar 2: Här skulle ni exempelvis kunna testa direkt för kommandot dig.
	@Override
	public void doCommand(String command, Player player) {
		if (command.equals("dig"));{
			dig(player);

		}

	}
}
