public class TriangleSystem {
    public
    static double[][] system;
    static double[] equals;
    public
    TriangleSystem(double[][] system, double[] equals){
        TriangleSystem.system = system;
        TriangleSystem.equals = equals;
    }
   public static double[] FindAnswerInSystem(TriangleSystem example){
        for (int indexVertical = system.length-1; indexVertical >= 0; indexVertical--){
            equals[indexVertical] /= system[indexVertical][indexVertical];
            system[indexVertical][indexVertical] = 1;

            for (int index = 0; index < indexVertical; index++){
                equals[index] -= equals[indexVertical] * system[index][indexVertical];
                system[index][indexVertical] = 0;
            }
        }
        return equals;
    }
}
