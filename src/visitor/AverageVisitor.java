package visitor;

import dataFrame.DataFrame;

/**
 * Class implements the average visitor
 */
public class AverageVisitor extends Visitor {
    private final String filtro;
    private int average = 0;
    private int nItems = 0;

    /**
     * Constructor
     * @param filtro to do
     */
    public AverageVisitor(String filtro) {
        this.filtro = filtro;
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
        if (df.data.containsKey(filtro)) {
            try {
                for (String i : df.data.get(filtro)) {
                    nItems++;
                    average += Integer.parseInt(i);
                }
            } catch (NumberFormatException e) {
                System.out.println("Can't filter this, it's not a number");
            }
        }
    }
}
