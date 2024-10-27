import java.util.LinkedList;

public class Store {
    private LinkedList<DigitalVideoDisc> itemsInStore = new LinkedList<>();

    public boolean checkDVD(DigitalVideoDisc disc) {
        return itemsInStore.contains(disc);
    }

    public void removeDVD(DigitalVideoDisc disc) {
        if (checkDVD(disc)) {
            itemsInStore.remove(disc);
            System.out.printf("The DVD \"%s\" has been removed from the store!\n", disc.getTitle());
        } else {
            System.out.printf("The DVD \"%s\" is not found in the store!\n", disc.getTitle());
        }
    }

    public void addDVD(DigitalVideoDisc disc) {
        if (!checkDVD(disc)) {
            itemsInStore.add(disc);
            System.out.printf("The DVD \"%s\" has been added to the store!\n", disc.getTitle());
        } else {
            System.out.printf("The DVD \"%s\" already exists in the store!\n", disc.getTitle());
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("STORE\nItems in the store:\n");
        if (itemsInStore.isEmpty()) {
            output.append("There are no DVDs in the store!\n");
        } else {
            for (DigitalVideoDisc dvd : itemsInStore) {
                output.append(String.format("%s - %.2f $\n", dvd.getTitle(), dvd.getCost()));
            }
        }
        return output.toString();
    }
}
