package observer;

import dataFrame.DataFrame;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Logs operations that satisfy a filter
 */
public class QueryObserver extends DataFrame implements DataFrameObserver{
    /**
     * Variable of the class
     */
    private ArrayList<String> listFunc;

    /**
     * Constructor
     * @param info to the super
     */
    public QueryObserver(DataFrame info) {
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
    @Override
    public String getListFunc() {
        StringBuilder result = new StringBuilder();
        result.append("QUERY OBSERVER\n\tOperations using some filter:\n");
        for (String fun : listFunc) result.append(fun).append("\n");
        return result.toString();
    }

    /**
     * Second method query, optimization of the other one
     * @param label     column
     * @param predicate how to sort
     * @return an ArrayList with the column ordered
     */
    @Override
    public ArrayList<String> query2(String label, Predicate<String> predicate) {
        this.addOperation("Query: "+label+" using predicate");
        return super.query2(label, predicate);
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
        StringBuilder r = new StringBuilder();
        r.append("Query: ").append(label);
        switch (option){
            case 1 -> r.append(" same than ");
            case 2 -> r.append(" different than ");
            case 3 -> r.append(" the same than ");
            case 4 -> r.append(" bigger than ");
            case 5-> r.append(" smaller than ");
        }
        this.addOperation(r.append(compare).toString());
        return super.query(label, option, compare);
    }
}
