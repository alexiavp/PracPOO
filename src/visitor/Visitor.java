package visitor;

import composite.*;
import dataFrame.DataFrame;

/**
 * Abstract class for the Visitor implementation
 */
public abstract class Visitor {
    /**
     *
     * @param dir name of the directory
     */
    public void visit(Directory dir) {
        for (Composite fill : dir.getChildren()) {
            fill.accept(this);
        }
    }

    /**
     * Interface for visit method
     * @param df DataFrame info
     */
    public abstract void visit(DataFrame df);

}
