package visitor;

import composite.*;
import dataFrame.DataFrame;

/**
 * Abstract class for the Visitor implementation
 */
public abstract class Visitor {
    /**
     *
     * @param dir
     */
    public void visit(Directory dir) {
        for (Composite fill : dir.getChildren()) {
            fill.accept(this);
        }
    }

    /**
     *
     * @param df
     */
    public abstract void visit(DataFrame df);

}
