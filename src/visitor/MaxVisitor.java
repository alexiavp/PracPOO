package visitor;

import dataFrame.DataFrame;

/**
 * Class implements the max visitor
 */
public class MaxVisitor extends Visitor {
    private final String filtro;
    private int max = Integer.MIN_VALUE;

    /**
     * Constructor
     * @param filtro to do
     */
    public MaxVisitor(String filtro) {
        this.filtro = filtro;
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
        if (df.data.containsKey(filtro)) {
            try {
                for (String i : df.data.get(filtro)) {
                    max = Math.max(max, Integer.parseInt(i));
                }
            } catch (NumberFormatException e) {
                System.out.println("Can't filter this, it's not a number");
            }
        }
    }
}
