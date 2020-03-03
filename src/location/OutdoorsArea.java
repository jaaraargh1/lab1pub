package location;

import java.util.Random;

import player.Player;

public class OutdoorsArea extends Location {
	private String weather;

	public OutdoorsArea(String name, String longDescription, String shortDescription) {
		super(name, longDescription, shortDescription);

		this.weather = randomWeather();
	}

	/*
	 * 
	 * 
	 * 
	 * if you're outdoors it will trigger one of X random weathers.
	 * 
	 */
	// TODO: Kommentar: Denna kanske borde vara static, då den inte behöver
	// en instans av objektet för att fungera.
	public static String randomWeather() {
		String[] weatherArray = new String[6];

		final String weather1 = ("Du känner den sköna solen på ditt ansikte.");
		final String weather2 = ("Det regnar sotisar, du inser att du skulle nog tagit med dig ett paraply.");
		final String weather3 = ("Vädret är fyllt av slask, urrrrrrrrrrrgh.");
		final String weather4 = ("Du kollar upp mot skyn och ser enbart moln.");
		final String weather5 = ("Det ÖÖÖÖÖÖÖsregnar.");
		final String weather6 = ("Det är som vanligt i Linköping, konstant vind det vill säga. Du har IAF tur att du inte ska cykla.");
		weatherArray[0] = weather1;
		weatherArray[1] = weather2;
		weatherArray[2] = weather3;
		weatherArray[3] = weather4;
		weatherArray[4] = weather5;
		weatherArray[5] = weather6;

		return weatherArray[randInt(weatherArray.length)];
	}

	/*
	 * @returns random int for the random generator parameter is reservered for the
	 * arrayslength so it wont return a null value.
	 */
	private static int randInt(int arrayLength) {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(arrayLength);
	}

	public String getWeather() {
		return weather;
	}

	public void possibleDirections(String[] strArrayDirectons) {

		for (int i = 0; i < getStrArrayDirections().length; i++) {

			if (getAdjacent(getStrArrayDirections()[i]) != null) {
				System.out.print("Till " + getStrArrayDirections()[i] + " finns det en väg till  ");

				System.out.println(" " + (getAdjacent(getStrArrayDirections()[i])) + ".");
			}

		}
	}

	public void setWeather(String weather) {
		this.weather = weather;

	}

	/*
	 * Prints special message when the player is outdoors.
	 * 
	 */
	@Override
	public void describeYourself(Player player) {
		this.weather = randomWeather();
		player.getLocation().printDescription();

		// TODO: Kommentar: Istället för att bara skriva ut ett väder
		// kanske ni borde faktiskt ändra väder-variabeln.
		System.out.println(this.weather);

	}
}
