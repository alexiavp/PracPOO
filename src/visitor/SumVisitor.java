package visitor;

import dataFrame.DataFrame;

/**
 * Class implements the adder visitor
 */
public class SumVisitor extends Visitor {
    private final String filtro;
    private int suma = 0;

    /**
     * Constructor
     * @param filtro to do
     */
    public SumVisitor(String filtro) {
        this.filtro = filtro;
    }

    /**
     * Getter
     * @return the suma
     */
    public int getSuma() {
        return suma;
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
                    suma += Integer.parseInt(i);
                }
            } catch (NumberFormatException e) {
                System.out.println("Can't filter this, it's not a number");
            }
        }
    }
}
