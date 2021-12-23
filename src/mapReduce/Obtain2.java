package mapReduce;

import dataFrame.DataFrame;

/**
 * Class implements the function for the map
 */
public class Obtain2 implements IMap<DataFrame> {
    /**
     * Query the DataFrame depending on the labels
     * @param elem the element to apply the function
     * @param label where tot search
     * @param label2 what to search
     * @return result of the query
     */
    @Override
    public DataFrame apply(DataFrame elem, String label, String label2) { return elem.query(label, 1, label2); }
}
