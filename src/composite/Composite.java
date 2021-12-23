package composite;

import dataFrame.DataFrame;
import visitor.Visitor;
import java.util.*;

/**
 * Interface for the Composite implementation
 */
public interface Composite {

    /**
     * Get the name
     */
    void ls();

    /**
     * Collects the information
     * @return the info
     */
    List<String> collect();

    /**
     * Transform the info into a List
     * @return List with the info
     */
    List<Composite> toList();

    /**
     * Method that search the dataframe
     * @param name to search
     * @return a list of dataframes
     */
    List<DataFrame> search(String name);

    /**
     * Setter
     * @param parent the info to save
     */
    void setParent(Composite parent);

    /**
     * Getter
     * @return the name
     */
    String getName();

    /**
     * Method toString
     * @return String with the info
     */
    String toString();

    /**
     * To know the size of the info
     * @return an int of the size
     */
    int size();

    /**
     * Method accept for the Visitor implementation
     * @param visitor the visitor to accept
     */
    void accept(Visitor visitor);

}
