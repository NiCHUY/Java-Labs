public class LinearSeries extends Series  {
    public LinearSeries(double firstElement, double de, int numOfElements)
    {
        super(firstElement, de, numOfElements);
    }
    public double getElement(int i)
    {
        return (de * firstElement + (i - 1) );
    }
}
