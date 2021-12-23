package mapReduce;

import dataFrame.DataFrame;

/**
 * Interface for the function for the mapReduce
 * @param <T> generic variable
 */
public interface IMap<T> {
    /**
     * Function for the map
     * @param elem the element to apply the function
     * @param label where tot search
     * @param label2 what to search
     * @return
     */
    T apply(DataFrame elem, String label, String label2);
}
