package mapReduce;

import dataFrame.DataFrame;
import java.util.ArrayList;
import java.util.List;

/**
 * Class implementation of a mapReduce
 */
public class MapReduce {

    /**
     * Function mapReduce
     * @param list collection of dataframe
     * @param function function to apply
     * @param reduce how to reduce the info of the map
     * @param label what to search
     * @param label2 what to search
     * @param <T> generic implemementation
     * @return the result
     */
    public static <T> ArrayList<T> mapReduce(List<DataFrame> list, IMap<T> function, Reduce<T> reduce, String label, String label2) {
        ArrayList<T> result = new ArrayList<>();
        list.parallelStream().toList().forEach(elem ->result.add(function.apply(elem,label,label2)));
        reduce.reduce(result);
        if (label2 == null) System.out.print(" in column: "+ label +"\n");
        else System.out.print(" of "+ label2 +" in column: "+label+"\n");
        return result;
    }
}
