
/**
 * A class that collects information of each shopper's items.
 */
public class Items {
	/** Class variable that record the item's name. */
	String name;
	
	/** Class variable that record the item's price. */
	double price;
	
	/** Class variable that record the item's category. */
	String category;
	
	/**
     * Create new items with default values.
     */
	public Items() {
		this.name = "item";
		this.price = 0.0;
		this.category = "other";
	} 

}
