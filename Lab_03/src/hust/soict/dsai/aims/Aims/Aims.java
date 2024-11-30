package hust.soict.dsai.aims.Aims;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store.Store;
public class Aims {
	
    public static void main(String[] args) {
        
        // Create a new store and a new cart
        Store store = new Store();
        Cart anOrder = new Cart();
        
        // Create new DVD objects and add them to the store
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        // Display store inventory
        System.out.println(store);

        // Add DVDs from store to cart
        System.out.println("Adding DVDs to the cart:");
        if (store.checkDVD(dvd1)) {
            anOrder.addDigitalVideoDisc(dvd1);
        }
        if (store.checkDVD(dvd2)) {
            anOrder.addDigitalVideoDisc(dvd2);
        }
        if (store.checkDVD(dvd3)) {
            anOrder.addDigitalVideoDisc(dvd3);
        }

        // Test remove and add operations in the cart
        System.out.println("\nTesting cart operations:");
        anOrder.removeDigitalVideoDisc(dvd2);
        anOrder.addDigitalVideoDisc(dvd2);

        // Print total cost of the items in the cart
        System.out.println("\nTotal cost in the cart is: " + anOrder.totalCost() + " $");

        // Display cart contents
        System.out.println("\nCart contents:");
        anOrder.print();
    }
}
