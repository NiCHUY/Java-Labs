public class ExponentialSeries extends Series{
    public ExponentialSeries(double firstElement,double de,int numOfElements)
    {
        super(firstElement, de, numOfElements);
    }

    public double getElement(int i) {
        return ( Math.pow(de, (i - 1)) * firstElement);
    }
}
