import java.util.Date;


/**
 * A class that implements a shopper for the shopping cart.
 */
public class Shopper {
	/** Class variable that record the shopper's name.*/
    String name;
    
    /** Class variable that record the date using the shopping cart.*/
    Date currentDate = new Date();
    
    /** Class variable that record the country of the shopper.*/
    boolean country;
    
    /**
     * Create a new shopper with default values.
     */
    public Shopper() {
    	this.name = "user";
    	this.currentDate = new Date();
    }
    
}
