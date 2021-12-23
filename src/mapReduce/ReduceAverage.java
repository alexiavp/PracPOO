package mapReduce;

import java.util.ArrayList;

/**
 * Class with the reduce method implemented
 */
public class ReduceAverage implements Reduce<ArrayList<String>>{
    /**
     * Reduce an Array of Arrays of Strings to an average
     * @param info to reduce
     */
    @Override
    public void reduce(ArrayList<ArrayList<String>> info) {
        int average= info.stream().mapToInt(ArrayList::size).sum();
        System.out.print("Average: "+ average/info.size());
    }
}
