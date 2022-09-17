import java.util.ArrayList;
import java.util.Arrays;

public class Task_13 {
    public static void main(String[] args) {
        //ArrayList Solution
        int counter = 49;
        System.out.println("\nArrayList Solution:");
        ArrayList<Integer> answer = ArrayListMethod(counter);
        for (int i = 0; i < 6; i++) {
            System.out.printf(answer.get(i) + " ");
        }

        //Array Solution
        System.out.println("\nArray Solution:");
        int[] answers = ArrayMethod(counter);
        for (int i = 0; i < 6; i++) {
            System.out.printf(answers[i] + " ");
        }
    }
    private static int[] ArrayMethod(int counter){
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
        Arrays.sort(answers);
        return answers;
    }

    private static ArrayList<Integer> ArrayListMethod(int counter){
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < counter; i++) {
            indexes.add(i + 1);
        }
        ArrayList<Integer> answers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int index = (int) (Math.random() * counter);
            answers.add(indexes.get(index));
            indexes.remove(index);
            counter--;
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (answers.get(j) > answers.get(j + 1)) {
                    int temp = answers.get(j);
                    answers.set(j, answers.get(j + 1));
                    answers.set(j + 1, temp);
                }
            }
        }
        return answers;
    }
}