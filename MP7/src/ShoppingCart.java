import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ShoppingCart {
	
    /** Input scanner. Use this to take in user's input for name.*/
    static Scanner myScan;
    
    static Shopper shopperInfo;
    
    static ArrayList<Items> itemsInfo;
    
    static Shopper tempShopper;
    
    static ArrayList<Items> items;
    
    static double sum = 0.0;
    
    static double discount = 0.0;
    
    static double shipping;
	
    /**
     * Create the new shopper.
     * 
     * @return the shopper's information
     */
    public static Shopper buildShopper() {
    	tempShopper = new Shopper();
    	System.out.println("Please enter your name");
    	tempShopper.name = myScan.next();
    	tempShopper.currentDate = new Date();
    	System.out.println("Do you reside inside the U.S.?(Please enter 'Y' for yes, 'N' for no.)");
    	char answer = ' ';
    		answer = myScan.next().charAt(0);
    	while (answer != 'Y' && answer != 'N') {
    		System.out.println("This is an invalid answer. Please try again.");
    		answer = myScan.next().charAt(0);
    	}
    	if (answer == 'Y') {
    		tempShopper.country = true;
    	} else if (answer == 'N') {
    		tempShopper.country = false;
    	} 
    	return tempShopper;
    }
    
    /** To collect the information of items.
     * 
     * @return items information of items
     */   
	public static ArrayList<Items> buildItems() {
		items = new ArrayList<Items>();		
		System.out.println("This is used to collect information of your items. After"
				+ "finish entering all items, please enter 'exit' to exit.");
		int i = 1;
		
		do {
			Items newItem = new Items();
			System.out.println("Please enter your #" + i + " item");
			newItem.name = myScan.next();
			if (newItem.name.equals("exit")) {
				break;
			}
			System.out.println("Please enter the price of the item(only the number)");
			newItem.price = myScan.nextDouble();
			System.out.println("Please enter the category of the item");
			newItem.category = myScan.next();
			if (newItem.category.equals("exit")) {
				break;
			}
			items.add(newItem);
			i++;
		}
		while (true);
		System.out.println("Please enter a coupon code if you have one");
		String coupon = myScan.next();
		if (coupon.equals("MerryXMas53")) {
			System.out.println("You receive 20% discount!");
			sum = sum() * 0.8;
			discount = sum * 0.2;
		} else if (coupon.equals("Winter10")) {
			System.out.println("Great! You get $10 off your purchase.");
			sum = sum() - 10;
			discount = 10.0;
		} else if (coupon.equals("newUser")) {
			System.out.println("You receive 50% discount!!!");
			sum = sum() * 0.5;
			discount = sum * 0.5;
		} else {
			System.out.println("This is an invalid coupon.");
		}
		return items;
	}
	
	/**
	 * get the total of all items.
	 */
	public static double sum() {
		for (int i = 0; i < items.size(); i++) {
			sum = sum + items.get(i).price;
		}
		return sum;
	}
	
	public static double shipping() {
		if (tempShopper.country == true && sum >= 49.0) {
			shipping = 0.0;
		} else if (tempShopper.country == true && sum < 49.0) {
			shipping = 5.0;
		} else if (tempShopper.country == false && sum >= 200.0) {
			shipping = 0.0;
		} else {
			shipping = 10.0;
		}
		return shipping;
	}
	
	/**
	 * Collect information.
	 */
	public static void collectInfo() {
        shopperInfo = buildShopper();
        itemsInfo = buildItems();
	}
	
	/** Print the receipt for the current shopper.
	 * 
	 */
	public static void printReceipt() {
		System.out.println(" ");
		System.out.println("Here is your shopping cart summary");
        System.out.println("=================");
        System.out.println("Name: " + tempShopper.name);
        System.out.println("Date " + tempShopper.currentDate);
        System.out.println("Item" + "\t" + "Category" + "\t"  + "Price");
        for (int i = 0; i < items.size(); i++) {
        System.out.println(items.get(i).name + "\t" + items.get(i).category + "\t" + items.get(i).price);
        }
        System.out.println("Great! You have saved $" + Math.round(discount * 100.0) / 100.0);
        System.out.println("Total Items: $" + Math.round(sum * 100.0) / 100.0);
        System.out.println("Shipping: $" + shipping());
        System.out.println("Total: $" + (Math.round(sum * 100.0) / 100.0 + shipping()));
        
        
	}
	
	public static void main(final String[] unused) {
		myScan = new Scanner(System.in);
		collectInfo();
		printReceipt();
	}

}
