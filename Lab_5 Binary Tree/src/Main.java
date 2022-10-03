
public class Main {
    public static void main(String[] args) {
        BinaryTree<Food> tree = new BinaryTree<>();
        Food Burger = new Food(1, "Burger");

        tree.addNodeByValue(new Food(213, "burger"));
        tree.addNodeByValue(new Food(12, "drink"));
        tree.addNodeByValue(new Food(4321, "cheese"));
        tree.addNodeByValue(new Food(122, "bread"));
        tree.addNodeByValue(new Food(1, "milk"));
        tree.inorderTreeWalk();
    }

}