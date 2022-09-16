import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Task_15 {
    public static void main(String[] args) {
        System.out.println("Input your n:");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();
        System.out.println("Array Version:");
        int[][] triangleArr = creatingTriangleUsingArray(n);
        Arrays.stream(triangleArr).forEach(arr -> System.out.println(Arrays.toString(arr)));
        System.out.println("ArrayList Version:");
        ArrayList<ArrayList<Integer>> triangleArrList = creatingTriangleUsingArrayList(n);
        System.out.println(triangleArrList);
    }
    private static int[][] creatingTriangleUsingArray(int n){
        int[][] triangle = new int[n][];
        int iteration = 1;
        int[] currentLayer = new int[0];
        int[] previousLayer = new int[0];

        while (iteration <= n){
            if (iteration == 1){
                currentLayer = new int[]{1};
            }
            else {
                currentLayer = new int[iteration];
                for (int i = 0; i < iteration; i++)
                    if(i == 0 || i == iteration - 1){
                        currentLayer[i] = 1;
                    }
                else{
                    currentLayer[i] = previousLayer[i-1] + previousLayer[i];
                    }
            }
            triangle[iteration-1] = currentLayer;
            previousLayer = currentLayer;
            iteration++;
        }
        return triangle;
    }

    private static ArrayList<ArrayList<Integer>> creatingTriangleUsingArrayList(int n){
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
        int iteration = 1;
        ArrayList<Integer> currentLayer = new ArrayList<>();
        ArrayList<Integer> previousLayer = new ArrayList<>();
        while (iteration <= n){
            currentLayer = new ArrayList<>();
            if (iteration == 1){
                currentLayer.add(1);
            }
            else {
                for (int i = 0; i < iteration; i++)
                    if(i == 0 || i == iteration - 1){
                        currentLayer.add(1);
                    }
                    else{
                        currentLayer.add(previousLayer.get(i-1) + previousLayer.get(i));
                    }
            }
            triangle.add(currentLayer);
            previousLayer = currentLayer;
            iteration++;
        }
        return triangle;
    }
}
