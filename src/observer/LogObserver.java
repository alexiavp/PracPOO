package observer;


import dataFrame.DataFrame;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

/**
 * Logs all operations executed in a DataFrame
 */
public class LogObserver extends DataFrame implements DataFrameObserver {

    private ArrayList<String> listFunc;

    /**
     * Constructor
     * @param info to the super
     */
    public LogObserver(DataFrame info) {
        super(info);
        listFunc = new ArrayList<>();
    }

    /**
     * Adds the name of the operation
     * @param name of operation
     */
    @Override
    public void addOperation(String name) {
        listFunc.add(name);
    }

    /**
     * Returns the info in String format
     * @return the info
     */
    public String getListFunc(){
        StringBuilder result = new StringBuilder();
        result.append("LOG OBSERVER\n\tA list of all operations:\n");
        for (String fun : listFunc) result.append("Function: ").append(fun).append("\n");
        return result.toString();
    }

    /**
     * Method used to know the number of columns
     * @return the number of columns
     */
    @Override
    public int columns() {
        this.addOperation("columns");
        return super.columns();
    }

    /**
     * return the value of a single item (row) and column label (name).
     * @param row   row
     * @param label column
     * @return the info
     */
    @Override
    public String at(int row, String label) {
        this.addOperation("at");
        return super.at(row, label);
    }

    /**
     * access a single value for a row and column by integer position
     * @param row row
     * @param col column
     * @return the info
     */
    @Override
    public String iat(int row, int col) {
        this.addOperation("iat");
        return super.iat(row, col);
    }

    /**
     * the size of the DataFrame
     * @return the size
     */
    @Override
    public int size() {
        this.addOperation("size");
        return super.size();
    }

    /**
     * Getter
     * @return the name
     */
    @Override
    public String getName() {
        this.addOperation("getName");
        return super.getName();
    }

    /**
     * Second method sort, optimization of the other one
     * @param label     column
     * @param predicate how to sort
     * @return an ArrayList with the column ordered
     */
    @Override
    public ArrayList<String> sort2(String label, Comparator<String> predicate) {
        this.addOperation("sort");
        return super.sort2(label, predicate);
    }

    /**
     * Second method query, optimization of the other one
     * @param label     column
     * @param predicate how to sort
     * @return an ArrayList with the column ordered
     */
    @Override
    public ArrayList<String> query2(String label, Predicate<String> predicate) {
        this.addOperation("query");
        return super.query2(label, predicate);
    }

    /**
     * Method sort return the values of a column in the DataFrame following a certain order
     * @param label      column
     * @param comparator how to sort
     * @return an ArrayList with the column ordered
     */
    @Override
    public ArrayList<String> sort(String label, int comparator) {
        this.addOperation("sort");
        return super.sort(label, comparator);
    }

    /**
     * Method query return all elements where a label value fulfills a certain condition.
     *
     * @param label   column
     * @param option  how to search
     * @param compare what are we searching
     * @return the elements in the defined condition
     */
    @Override
    public DataFrame query(String label, int option, String compare) {
        this.addOperation("query");
        return super.query(label, option, compare);
    }
}
