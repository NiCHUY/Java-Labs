import java.util.ArrayList;
import java.util.Arrays;

public class Task_13 {
    public static void main(String[] args) {
        //ArrayList Solution
        int counter = 49;
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < counter; i++) {
            indexes.add(i + 1);
        }
        ArrayList<Integer> chosenOne = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int index = (int) (Math.random() * counter);
            chosenOne.add(indexes.get(index));
            indexes.remove(index);
            counter--;
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (chosenOne.get(j) > chosenOne.get(j + 1)) {
                    int temp = chosenOne.get(j);
                    chosenOne.set(j, chosenOne.get(j + 1));
                    chosenOne.set(j + 1, temp);
                }
            }
        }
        System.out.println("\nArrayList Solution:");
        for (int i = 0; i < 6; i++) {
            System.out.printf(chosenOne.get(i) + " ");
        }

        //Array Solution
        int[] indexesArr = new int[49];
        for (int i = 1; i < indexesArr.length; i++) {
            indexesArr[i] = i;
        }

        int[] answers = new int[6];

        for (int i = 0; i < 6; i++) {
            int index = (int) (Math.random() * counter);
            if (indexesArr[index] != 0) {
                answers[i] = indexesArr[index];
                indexesArr[index] = 0;
            } else i--;
            counter--;
        }
        System.out.println("\nArray Solution:");
        Arrays.sort(answers);
        for (int i = 0; i < 6; i++) {
            System.out.printf(answers[i] + " ");
        }
    }
}