import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Matrix {

    public static double[][] createMatrix(File file) throws NoSuchElementException, FileNotFoundException, IllegalArgumentException {
        Scanner input = new Scanner(file);
        int n = input.nextInt();
        int m = input.nextInt();
        if (n <= 0 || m <= 0) {
            throw new IllegalArgumentException();
        }
        double[][] array = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = input.nextInt();
            }
        }
        if (input.hasNext()) {
        }
        return array;
    }

    public static double[][] inverseMatrix(double[][] matrixInput) {
        double[][] matrixInverse = new double[matrixInput.length][matrixInput.length];
        for (int i = 0; i < matrixInput.length; i++) {
            for (int j = 0; j < matrixInput.length; j++) {
                if (i == j) {
                    matrixInverse[i][j] = 1d;
                } else {
                    matrixInverse[i][j] = 0d;
                }
            }
        }
        double number;
        for (int i = 0; i < matrixInput.length; i++) {
            number = matrixInput[i][i];

            for (int j = 0; j < matrixInput.length; j++) {
                matrixInput[i][j] /= number;
                matrixInverse[i][j] /= number;
            }

            for (int l = i + 1; l < matrixInput.length; l++) {
                number = matrixInput[l][i];

                for (int j = 0; j < matrixInput.length; j++) {
                    matrixInput[i][j] -= matrixInput[i][j] * number;
                    matrixInverse[i][j] -= matrixInverse[i][j] * number;
                }
            }

            for (int k = matrixInput.length - 1; k > 0; k--) {
                for (int j = k - 1; j >= 0; j--) {
                    number = matrixInput[j][k];

                    for (int l = 0; l < matrixInput.length; l++) {
                        matrixInput[j][l] -= matrixInput[k][l] * number;
                        matrixInverse[j][l] -= matrixInverse[k][l] * number;
                    }
                }
            }
        }
        return matrixInverse;
    }

    public static ArrayList<ArrayList<Integer>> localMin(double[][] inputMatrix){
        ArrayList<ArrayList<Integer>> Output = new ArrayList<>();
        for (int i = 0; i < inputMatrix.length; i++){
            for (int j = 0; j < inputMatrix.length; j++){
                int count = 0;
                if (i != 0){
                    if (inputMatrix[i][j] < inputMatrix[i-1][j]){
                        count++;
                    }
                }else {
                    count++;
                }
                if (j != 0){
                    if (inputMatrix[i][j] < inputMatrix[i][j-1]){
                        count++;
                    }
                }else {
                    count++;
                }
                if (i != inputMatrix.length-1){
                    if (inputMatrix[i][j] < inputMatrix[i+1][j]){
                        count++;
                    }
                }else {
                    count++;
                }
                if (j != inputMatrix.length-1){
                    if (inputMatrix[i][j] < inputMatrix[i][j+1]){
                        count++;
                    }
                }else {
                    count++;
                }
                if (count == 4){
                    ArrayList<Integer> lair = new ArrayList<>();
                    lair.add(i);
                    lair.add(j);
                    Output.add(lair);
                }
            }
        }
        return Output;
    }

    public static ArrayList<ArrayList<Integer>> localMax(double[][] inputMatrix){
        ArrayList<ArrayList<Integer>> Output = new ArrayList<>();
        for (int i = 0; i < inputMatrix.length; i++){
            for (int j = 0; j < inputMatrix.length; j++){
                int count = 0;
                if (i != 0){
                    if (inputMatrix[i][j] > inputMatrix[i-1][j]){
                        count++;
                    }
                }else {
                    count++;
                }
                if (j != 0){
                    if (inputMatrix[i][j] > inputMatrix[i][j-1]){
                        count++;
                    }
                }else {
                    count++;
                }
                if (i != inputMatrix.length-1){
                    if (inputMatrix[i][j] > inputMatrix[i+1][j]){
                        count++;
                    }
                }else {
                    count++;
                }
                if (j != inputMatrix.length-1){
                    if (inputMatrix[i][j] > inputMatrix[i][j+1]){
                        count++;
                    }
                }else {
                    count++;
                }
                if (count == 4){
                    ArrayList<Integer> lair = new ArrayList<>();
                    lair.add(i);
                    lair.add(j);
                    Output.add(lair);
                }
            }
        }
        return Output;
    }
}