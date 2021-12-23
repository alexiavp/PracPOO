package visitor;

import dataFrame.DataFrame;
/**
 * Class implements the minimum visitor
 */
public class MinVisitor extends Visitor {

    private final String filtro;
    private int min = Integer.MAX_VALUE;

    /**
     * Constructor
     * @param filtro to do
     */
    public MinVisitor(String filtro) {
        this.filtro = filtro;
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
        if (df.data.containsKey(filtro)) {
            try {
                for (String i : df.data.get(filtro)) {
                    min = Math.min(min, Integer.parseInt(i));
                }
            } catch (NumberFormatException e) {
                System.out.println("Can't filter this, it's not a number");
            }
        }
    }
}
