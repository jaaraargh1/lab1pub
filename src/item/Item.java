package item;
import player.Player;

public abstract class Item {

    private Double weight;
    private String name;
    private String description;

    public Item(String name, String description, Double weight) {
	this.description = description;
	this.name = name;
	this.weight = weight;
		
    }
    	
    	
	
	
	

    /* Prints all the info of the item.
     */
    public void printItemInfo() {

	System.out.println(this.getName()+" " + this.getDescription() +" den väger  "+ this.getWeight()+" kg.");

    }
    // getter 
    public String getDescription() {
	return this.description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public double getWeight() {
	return this.weight;
    }

    public void setWeight(Double weight) {
	this.weight = weight;
    }
    public String toString() {
        return this.getName().toString().toLowerCase();
    }


    public abstract void doCommand(String command1, Player player);








	





	

}
