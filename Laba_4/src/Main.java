import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main  {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\roman\\Documents\\Input.txt");
        double[][] matrixK = Matrix.createMatrix(file);

        double[] equals = {1, 3, 4};

        TriangleSystem System1 = new TriangleSystem(matrixK, equals);
        equals = TriangleSystem.FindAnswerInSystem(System1);
        for (double equal : equals) {
            System.out.println(equal);
        }

        ArrayList<ArrayList<Integer>> OutputMin = Matrix.localMin(matrixK);
        ArrayList<ArrayList<Integer>> OutputMax = Matrix.localMax(matrixK);
        double[][] matrixInverse = Matrix.inverseMatrix(matrixK);
    }
}
