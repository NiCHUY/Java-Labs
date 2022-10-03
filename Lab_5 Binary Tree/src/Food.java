public class Food implements Comparable<Food> {
    int ID;
    String name;

    public Food(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int compareTo(Food food) {
        if (ID != food.ID) {
            return ID - food.ID;
        }
        return name.compareTo(food.name);
    }

    public String toString() {
        return "ID: " + ID + " name: " + name;
    }
}
