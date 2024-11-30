package hust.soict.dsai.aims.disc.DigitalVideoDisc;
public class DigitalVideoDisc {
    
    private static int nbDigitalVideoDiscs = 0; // Class attribute to track number of discs created
    private final int id; // Unique ID for each disc
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // Constructor by title
    public DigitalVideoDisc(String title) {
        this(title, null, null, 0, 0.0f);
    }

    // Constructor by category, title, and cost
    public DigitalVideoDisc(String title, String category, float cost) {
        this(title, category, null, 0, cost);
    }

    // Constructor by title, category, director, and cost
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this(title, category, director, 0, cost);
    }

    // Full constructor with all attributes
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }

    // Getters
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getDirector() { return director; }
    public int getLength() { return length; }
    public float getCost() { return cost; }
    public int getId() { return id; }

    // Setters with method names reflecting the attribute they modify
    public void setTitle(String title) { this.title = title; }
    public void setCategory(String category) { this.category = category; }
    public void setDirector(String director) { this.director = director; }
    public void setLength(int length) { this.length = length; }
    public void setCost(float cost) { this.cost = cost; }
}
