import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Series series1 = new LinearSeries(1, 3, 20);
        File LinearSeriesOutput  = new File("src\\LinearSeriesOutput.txt");
        series1.Save(LinearSeriesOutput);

        Series series2 = new ExponentialSeries(1, 3, 20);
        File ExponentialSeriesOutput  = new File("src\\ExponentialSeriesOutput.txt");
        series2.Save(ExponentialSeriesOutput);
    }
}