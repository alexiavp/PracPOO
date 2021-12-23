package mapReduce;

import dataFrame.DataFrame;
import java.util.ArrayList;

/**
 * Class with the method reduce implemented
 */
public class ReduceJoin implements Reduce<DataFrame>{
    /**
     * Join an Array of DataFrames
     * @param info to reduce
     */
    @Override
    public void reduce(ArrayList<DataFrame> info) {
        float total=info.stream().mapToInt(DataFrame::size).sum();
        info.forEach(System.out::println);
        System.out.print("\nTotal: "+ total);
    }
}
