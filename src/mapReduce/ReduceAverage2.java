package mapReduce;

import dataFrame.DataFrame;
import java.util.ArrayList;

/**
 * Class with method reduce implemented
 */
public class ReduceAverage2 implements Reduce<DataFrame>{

    /**
     * Reduce an array of DataFrames to an average
     * @param info to reduce
     */
    @Override
    public void reduce(ArrayList<DataFrame> info) {
        float average=info.stream().mapToInt(DataFrame::size).sum();
        System.out.print("Average: "+ average/info.size());
    }
}
