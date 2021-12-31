package visitor;

import dataFrame.DataFrame;

/**
 * Class implements the max visitor
 */
public class MaxVisitor extends Visitor {
    private final String filter;
    private int max = Integer.MIN_VALUE;

    /**
     * Constructor
     * @param filter to do
     */
    public MaxVisitor(String filter) {
        this.filter = filter;
    }

    /**
     * Getter
     * @return the maximum
     */
    public int getMax() {
        return max;
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
                    max = Math.max(max, Integer.parseInt(i));
                }
            } catch (NumberFormatException e) {
                System.out.println("Can't filter this, it's not a number");
            }
        }
    }
}
