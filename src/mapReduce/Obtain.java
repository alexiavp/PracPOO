package mapReduce;

import dataFrame.DataFrame;
import java.util.ArrayList;

/**
 * Class with the implementation of the function
 */
public class Obtain implements IMap<ArrayList<String>> {

    /**
     * Sort the DataFrame by the label
     * @param elem the element to apply the function
     * @param label where tot search
     * @param label2 what to search
     * @return a list with the result
     */
    @Override
    public ArrayList<String> apply(DataFrame elem, String label, String label2) {
        return elem.sort(label, 0);
    }
}
