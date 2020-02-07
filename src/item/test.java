package item;

public class test {

	public test() {
		// TODO Auto-generated constructor stub
	}

}


/**








    WearableItems kan man ta på sig och ger oftast någon effekt 
    (mer hälsa, skydd av något slag, vissa NPC:er beter sig annorlunda). 
    Man skall kunna ta på sig saker med kommandot "wear".
    
    För att användaren skall kunna veta vilka föremål den har ska den kunna skriva "items", då skall spelet lista dem, och vad man har på sig för tillfället.
    När det nu börjar bli lite mer att göra för spelaren så kan det vara bra för den att ha ett sätt att åter få reda på vad som fanns på platsen (vägar/dörrar, saker i rummet), lägg därför till kommandot "look" som skriver ut dessa saker igen.
    När man vill plocka upp ett föremål som ligger i ett rum skall man använda kommandot "take".
    Det skall finnas minst fem föremål i spelet. Vi rekommenderar shovel (som man kan gräva och hitta saker med), elven_robe (som man kan ta på sig), och torch (som lyser upp rum som annars är mörka). Hitta på två helt egna föremål också.
    Du kanske kommer fram till att du behöver ändra lite i tidigare klasser. Hur ser du till att framtida tillägg kommer kräva minimal (eller ingen) förändring i den nuvarande koden?

Icke-Funktionella krav:

    Klassen Item skall vara en superklass som alla andra föremål ärver ifrån. Den innehåller gemensamma attribut för alla föremål (namn, vikt och pris).
    Item skall ha en metod doCommand som definierar vad föremålet kan göra (eller tillåta att spelaren gör). Tänk noga över vilka parametrar den metoden behöver.
    Det skall finnas minst två subklasser till Item, Tool och WearableItem. (Weapon implementeras i del C).
    Tool är klassen (eller snarare superklassen) för diverse verktyg, t.ex. spaden. Tools definierar själva vilket kommando man behöver skriva för att använda dem i metoden use. Det är därför inte konstigt om alla Tools blir egna klasser, som ärver av klassen Tool.
    WearableItem är klassen (eller snarare superklassen) för diverse kläder, t.ex. elven_robe. WearableItems definierar själva vad som händer när man anropar metoden putOn(). Det är därför inte konstigt om alla föremål blir egna klasser, som ärver av klassen WearbleItem

















**/