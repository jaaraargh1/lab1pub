package location;

import java.util.ArrayList;
import java.util.Random;
public class OutdoorsArea extends Location {
	private String weather;
	private int random_int;
	private static String[] strArrayDirections = { "north", "east", "south", "west" };
	public OutdoorsArea(String name, Location pos) {
		super(name, pos);
	
        weather = randomWeather();	
 	}

	
	
	
	public int getRandom_int() {
		return random_int;
	}




	public void setRandom_int(int random_int) {
		this.random_int = random_int;
	}




	public static String[] getstrArrayDirections() {
		return strArrayDirections;
	}

	public String randomWeather() {
	ArrayList<String> randomWeathers = new ArrayList<String>();
	randomWeathers.add("Du känner den sköna solen på ditt ansikte.");
	randomWeathers.add("Det regnar sotisar, du inser att du skulle nog tagit med dig ett paraply.");
	randomWeathers.add("Vädret är fyllt av slask, urrrrrrrrrrrgh.");
	randomWeathers.add("Du kollar upp mot skyn och ser enbart moln.");
	randomWeathers.add("Det ÖÖÖÖÖÖÖsregnar.");
	randomWeathers.add("Det är som vanligt i Linköping, konstant vind det vill säga. Du har IAF att du inte ska cykla.");
    Random randomGenerator = new Random();
    //       V arrayn          V tar in random siffra        V på arraynslängd 
    return randomWeathers.get(randomGenerator.nextInt(randomWeathers.size()));
	}
	
	
	public String getWeather() {
	return weather;	
	}
	public void setWeather(String weather) {
		this.weather = weather;
		
	}
 
	
	
	public void possibleDirections(String[] strArrayDirectons) {
		
		for (int i = 0; i < getStrArrayDirections().length; i++) {
			
			if (getAdjacent(getStrArrayDirections()[i]) != null) {
				System.out.println(
						"Till " + getStrArrayDirections()[i] + " hittar du " + (getAdjacent(getStrArrayDirections()[i])));
             		
			}

		}
	}
	
@Override
	public void describeYourself(String[] strArrayDirections) {
		System.out.println("YOu'RE at " + this.getName());
        System.out.println( randomWeather());
	    possibleDirections(strArrayDirections);
	}
}
