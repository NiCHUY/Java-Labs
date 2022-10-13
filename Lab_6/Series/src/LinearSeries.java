public class LinearSeries extends Series  {
    public LinearSeries(double firstElement, double de, int numOfElements)
    {
        super(firstElement, de, numOfElements);
    }
    public double GetElement(int i)
    {
        return (firstElement + (i - 1) * de);
    }
}
