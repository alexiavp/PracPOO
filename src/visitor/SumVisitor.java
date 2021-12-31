package visitor;

import dataFrame.DataFrame;

/**
 * Class implements the adder visitor
 */
public class SumVisitor extends Visitor {
    /**
     * Variable of the class
     */
    private final String filter;
    /**
     * Variable where the sum will be saved
     */
    private int sum = 0;

    /**
     * Constructor
     * @param filter to do
     */
    public SumVisitor(String filter) {
        this.filter = filter;
    }

    /**
     * Getter
     * @return the sum
     */
    public int getSum() {
        return sum;
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
                    sum += Integer.parseInt(i);
                }
            } catch (NumberFormatException e) {
                System.out.println("Can't filter this, it's not a number");
            }
        }
    }
}
