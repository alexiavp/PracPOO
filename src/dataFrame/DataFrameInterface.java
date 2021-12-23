package dataFrame;

 import java.util.*;
 import java.util.function.*;

/**
 * Interface fot the DataFrame
 */
public interface DataFrameInterface {

    /**
     * return the value of a single item (row) and column label (name).
     * @param row   row
     * @param label column
     * @return the info
     */
    String at(int row, String label);

    /**
     * access a single value for a row and column by integer position
     * @param row row
     * @param col column
     * @return the info
     */
    String iat(int row, int col);

    /**
     * Method used to know the number of columns
     * @return the number of columns
     */
    int columns();

    /**
     * the size of the DataFrame
     * @return the size
     */
    int size();

    /**
     * Second method sort, optimization of the other one
     * @param label     column
     * @param predicate how to sort
     * @return an ArrayList with the column ordered
     */
    ArrayList<String>  sort2 (String label, Comparator<String> predicate);

    /**
     * Second method query, optimization of the other one
     * @param label     column
     * @param predicate how to sort
     * @return an ArrayList with the column ordered
     */
    ArrayList<String> query2(String label, Predicate<String> predicate);

    /**
     * Method sort return the values of a column in the DataFrame following a certain order
     * @param label      column
     * @param comparator how to sort
     * @return an ArrayList with the column ordered
     */
    ArrayList<String> sort(String label, int comparator);
    /**
     * Method query return all elements where a label value fulfills a certain condition.
     * @param label   column
     * @param option  how to search
     * @param compare what are we searching
     * @return the elements in the defined condition
     */
    DataFrame query(String label, int option, String compare);


}
