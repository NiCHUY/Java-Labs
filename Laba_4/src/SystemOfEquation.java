public class SystemOfEquation {
    public
    static double[][] system;
    static double[] equals;
    public
    SystemOfEquation(double[][] system, double[] equals){
        SystemOfEquation.system = system;
        SystemOfEquation.equals = equals;
    }
    public static double[] FindAnswerInSystemOfEquation(SystemOfEquation example){
        for (int indexVertical = system.length-1; indexVertical >= 0; indexVertical--){
            equals[indexVertical] /= system[indexVertical][indexVertical];
            system[indexVertical][indexVertical] = 1;

            for (int index = 0; index < system.length; index++){
                if(index != indexVertical){
                    equals[index] -= equals[indexVertical] * system[index][indexVertical];
                    system[index][indexVertical] = 0;
                }

            }
        }

        return equals;
    }
}
