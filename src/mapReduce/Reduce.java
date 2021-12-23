package mapReduce;

import java.util.ArrayList;

/**
 * Interface for the reduce function
 * @param <T> generic type
 */
public interface Reduce<T> {
    /**
     * Function reduce
     * @param info to reduce
     */
    void reduce (ArrayList<T> info);
}
