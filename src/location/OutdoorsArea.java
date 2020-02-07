package location;

import java.util.ArrayList;
import java.util.Random;

public class OutdoorsArea extends Location {
	private String weather;

	public OutdoorsArea(String name, String longDescription, String shortDescription) {
		super(name, longDescription, shortDescription);

		weather = randomWeather();
	}

	public String randomWeather() {
		ArrayList<String> randomWeathers = new ArrayList<String>();
		randomWeathers.add("Du känner den sköna solen på ditt ansikte.");
		randomWeathers.add("Det regnar sotisar, du inser att du skulle nog tagit med dig ett paraply.");
		randomWeathers.add("Vädret är fyllt av slask, urrrrrrrrrrrgh.");
		randomWeathers.add("Du kollar upp mot skyn och ser enbart moln.");
		randomWeathers.add("Det ÖÖÖÖÖÖÖsregnar.");
		randomWeathers.add(
				"Det är som vanligt i Linköping, konstant vind det vill säga. Du har IAF tur att du inte ska cykla.");
		Random randomGenerator = new Random();
		// V arrayn V tar in random siffra V på arraynslängd
		return randomWeathers.get(randomGenerator.nextInt(randomWeathers.size()));
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;

	}

	@Override
	public void describeYourself() {
		// player.getLocation().printDescription(player);

		System.out.println(randomWeather());

		// possibleDirections(strArrayDirections);

	}
}
