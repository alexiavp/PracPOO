package visitor;

import dataFrame.DataFrame;

/**
 * Class implements the average visitor
 */
public class AverageVisitor extends Visitor {

    /**
     * Variables of the class
      */
    private final String filter;
    /**
     * Variable where the average is saved
     */
    private int average;
    /**
     * Variable where the number of items are saved
     */
    private int nItems ;

    /**
     * Constructor
     * @param filter to do
     */
    public AverageVisitor(String filter) {
        this.filter = filter;
        average=0;
        nItems=0;
    }

    /**
     * Getter
     * @return the average
     */
    public float getAverage() {
        return (float) average / nItems;
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
                    nItems++;
                    average += Integer.parseInt(i);
                }
            } catch (NumberFormatException e) {
                System.out.println("Can't filter this, it's not a number");
            }
        }
    }
}
