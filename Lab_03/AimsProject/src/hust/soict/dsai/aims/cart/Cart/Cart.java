package hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
public class Cart {
    public static final int MAX_ITEMS = 20; 
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_ITEMS];
    private int qtyOrdered = 0; 

    public int addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == MAX_ITEMS) {
            System.out.println("The cart is full. Can't add more discs.");
            return 0;
        } else {
            itemsOrdered[qtyOrdered++] = disc;
            System.out.println("The DVD \"" + disc.getTitle() + "\" has been added!");
            return 1;
        }
    }

    public int addDigitalVideoDisc(DigitalVideoDisc... dvdArray) {
        int countAdded = 0;
        for (DigitalVideoDisc disc : dvdArray) {
            if (qtyOrdered == MAX_ITEMS) {
                System.out.println("The cart is full. Can't add more discs.");
                break;
            } else {
                itemsOrdered[qtyOrdered++] = disc;
                System.out.println("The DVD \"" + disc.getTitle() + "\" has been added!");
                countAdded++;
            }
        }
        return countAdded;
    }

    public int addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered + 2 > MAX_ITEMS) {
            System.out.println("The cart is full or almost full. Can't add more discs.");
            return 0;
        } else {
            itemsOrdered[qtyOrdered++] = dvd1;
            System.out.println("The DVD \"" + dvd1.getTitle() + "\" has been added!");

            itemsOrdered[qtyOrdered++] = dvd2;
            System.out.println("The DVD \"" + dvd2.getTitle() + "\" has been added!");
            return 2;
        }
    }

    public int removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == 0) {
            System.out.println("Your cart is empty!");
            return 0;
        }
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[--qtyOrdered] = null;
                System.out.println("Removed DVD \"" + disc.getTitle() + "\" successfully!");
                return 1;
            }
        }
        System.out.println("No matching DVD found!");
        return 0;
    }

    public float totalCost() {
        float sum = 0.0f;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] != null) {
                sum += itemsOrdered[i].getCost();
            }
        }
        return sum;
    }

    public void print() {
        if (qtyOrdered == 0) {
            System.out.println("Cart is empty.");
            return;
        }
        StringBuilder output = new StringBuilder("*********************CART************************** \nOrdered items: \n");
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] != null) {
                output.append(i + 1).append(". [").append(itemsOrdered[i].getTitle()).append("] - [")
                      .append(itemsOrdered[i].getCategory()).append("] - [")
                      .append(itemsOrdered[i].getDirector()).append("] - [")
                      .append(itemsOrdered[i].getLength()).append("]: ")
                      .append(itemsOrdered[i].getCost()).append(" $\n");
            }
        }
        output.append("Total: ").append(totalCost()).append(" $\n");
        output.append("***************************************************\n");
        System.out.println(output);
    }

    public void searchById(int id) {
        if (id <= 0 || id > qtyOrdered) {
            System.out.println("No match found!");
        } else {
            DigitalVideoDisc disc = itemsOrdered[id - 1];
            System.out.println("Result: [" + disc.getTitle() + "] - [" + disc.getCategory() + "] - ["
                    + disc.getDirector() + "] - [" + disc.getLength() + "]: " + disc.getCost() + " $\n");
        }
    }

    public void searchByTitle(String title) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getTitle().equalsIgnoreCase(title)) {
                System.out.println("Result: [" + itemsOrdered[i].getTitle() + "] - [" + itemsOrdered[i].getCategory()
                        + "] - [" + itemsOrdered[i].getDirector() + "] - [" + itemsOrdered[i].getLength()
                        + "]: " + itemsOrdered[i].getCost() + " $\n");
                return;
            }
        }
        System.out.println("No match found!");
    }
}
