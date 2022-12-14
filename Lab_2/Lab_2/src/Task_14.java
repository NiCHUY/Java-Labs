import java.util.ArrayList;
import java.util.Scanner;
public class Task_14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How you want to read matrix? Type 1 or 2");
        int type = input.nextInt();
        if (type != 1 && type != 2){
            System.exit(0);
        }
        System.out.println("Input your n:");
        int n = input.nextInt();
        System.out.println("Input your matrix:");
        int[][] matrixArray = ArrayInput(type, n);
        ArrayList<ArrayList<Integer>> matrixArrayList = ArrayListInput(matrixArray);
        input.close();
       isMagicalOutput(isMagicalArray(matrixArray));
       isMagicalOutput(isMagicalArrayList(matrixArrayList, n));
    }

    private static boolean isMagicalArray(int[][] square){
        int sum = 0;
        for(int i = 0; i < square.length; i++){
        sum += square[0][i];
        }
        for(int i = 0; i < square.length; i++){
            int sum1 = 0;
            int sum2 = 0;
            int sum3 = 0;
            int sum4 = 0;
            for(int j = 0; j < square.length; j++){
                sum1 += square[i][j];
                sum2 += square[j][i];
                sum3 += square[j][j];
                sum4 += square[j][square.length - 1 - j];
            }
            if(sum1 != sum || sum2 != sum || sum3 != sum || sum4 != sum){
             return false;
            }
        }
        return true;
    }

    private static boolean isMagicalArrayList(ArrayList<ArrayList<Integer>> square, int n){
        int sum = 0;
        for(int i = 0; i < square.size() ; i++){
            sum += square.get(0).get(i);
        }
        for(int i = 0; i < square.size(); i++){
            int sum1 = 0;
            int sum2 = 0;
            int sum3 = 0;
            int sum4 = 0;
            for(int j = 0; j < square.size(); j++){
                sum1 += square.get(i).get(j);
                sum2 += square.get(j).get(i);
                sum3 += square.get(j).get(j);
                sum4 += square.get(j).get((square.size()) - 1 - j);
            }
            if(sum1 != sum || sum2 != sum || sum3 != sum || sum4 != sum){
                return false;
            }
        }
        return true;
    }

    private static void isMagicalOutput(boolean result){
        if (result){
            System.out.println("?????? ?????????????? ????????????????????");
        }else {
            System.out.println("???? ??????");
        }
    }

    private static int[][] ArrayInput(int type, int n){
        Scanner input = new Scanner(System.in);
        int[][] matrixArray = new int[n][n];
        if(type == 1){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    matrixArray[i][j] = input.nextInt();
                }
            }
        }else{
            for(int i = 0; i < n; i++){
                String str = input.nextLine();
                String[] argument = str.split(" ");
                if(argument.length != n){
                    throw new IndexOutOfBoundsException("Invalid number count");
                }
                for(int j = 0; j < n; j++){
                    try{
                        matrixArray[i][j] = Integer.parseInt(argument[j]) ;
                    }
                    catch (NumberFormatException e)
                    {
                        throw new NumberFormatException("Input mismatch");
                    }

                }
            }

        }
        input.close();
        return matrixArray;
    }

    private static ArrayList<ArrayList<Integer>> ArrayListInput(int[][] matrixArray){
        ArrayList<Integer> layer;
        ArrayList<ArrayList<Integer>> matrixArrayList = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < matrixArray.length; i++){
                layer = new ArrayList<>();
                for(int j = 0; j < matrixArray.length; j++){
                    layer.add(matrixArray[i][j]);
                }
                matrixArrayList.add(layer);
            }

        return matrixArrayList;
    }
}
