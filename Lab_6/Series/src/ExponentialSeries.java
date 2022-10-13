public class ExponentialSeries extends Series{
    public ExponentialSeries(double firstElement,double de,int numOfElements)
    {
        super(firstElement, de, numOfElements);
    }

    public double GetElement(int i) {
        return (firstElement * Math.pow(de, (i - 1)));
    }
}
