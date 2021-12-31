package visitor;

import dataFrame.DataFrame;
/**
 * Class implements the minimum visitor
 */
public class MinVisitor extends Visitor {

    /**
     * Variable of the class
     */
    private final String filter;
    /**
     * Variable where the minimum is saved
     */
    private int min = Integer.MAX_VALUE;

    /**
     * Constructor
     * @param filter to do
     */
    public MinVisitor(String filter) {
        this.filter = filter;
    }

    /**
     * Getter
     * @return the minimum
     */
    public int getMin() {
        return min;
    }

    /**
     * Method creates the relation with the dataframe
     * @param df with the info
     */
    @Override
    public void visit(DataFrame df) {
        if (df.data.containsKey(filter)) {
            try {
                for (String i : df.data.get(filter)) {
                    min = Math.min(min, Integer.parseInt(i));
                }
            } catch (NumberFormatException e) {
                System.out.println("Can't filter this, it's not a number");
            }
        }
    }
}
