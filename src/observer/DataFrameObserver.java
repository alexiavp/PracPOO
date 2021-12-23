package observer;

import dataFrame.DataFrameInterface;

/**
 * Interface for the implementation of the observer
 */
public interface DataFrameObserver extends DataFrameInterface {

    /**
     * Adds the name of the operation to the list
     * @param name of operation
     */
    void addOperation(String name);

    /**
     * Returns the info in String format
     * @return the info
     */
    String getListFunc();
}
