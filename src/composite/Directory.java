package composite;

import dataFrame.DataFrame;
import visitor.*;
import java.util.*;

/**
 * Class implementation of Directory for the Composite
 */
public class Directory implements Composite {
    /**
     * Variables of the class
     */
    private final String name;
    /**
     * List with all the children of the directory
     */
    private final List<Composite> children;
    /**
     * Dad of the directory
     */
    private Composite dad;

    /**
     * Constructor
     * @param name of the directory
     */
    public Directory(String name) {
        this.name = name;
        this.children = new LinkedList<>();
        this.dad = null;
    }

    /**
     * Adds a child to the list
     * @param child info to add
     */
    public void addChild(Composite child) {
        children.add(child);
        child.setParent(this);
    }

    /**
     * Deletes a child from the list
     * @param child info to remove
     */
    public void removeChild(Composite child) {
        children.remove(child);
        child.setParent(null);
    }

    /**
     * Get the name
     */
    @Override
    public void ls() {
        System.out.println();
        children.forEach(Composite::ls);
    }

    /**
     * Collects the information
     * @return the info
     */
    @Override
    public List<String> collect() {
        LinkedList<String> result = new LinkedList<>();
        result.add(name);
        for (Composite fill : children) {
            result.addAll(fill.collect());
        }
        return result;
    }

    /**
     * Transform the info into a List
     * @return List with the info
     */
    @Override
    public List<Composite> toList() {
        LinkedList<Composite> result = new LinkedList<>();
        result.add(this);
        for (Composite fill : children) {
            result.addAll(fill.toList());
        }
        return result;
    }

    /**
     * Method that search the dataframe
     * @param name to search
     * @return a list of dataframes
     */
    @Override
    public List<DataFrame> search(String name) {
        LinkedList<DataFrame> result = new LinkedList<>();
        for (Composite child : children) {
            result.addAll(child.search(name));
        }
        return result;
    }

    /**
     * To know the size of the info
     * @return an int of the size
     */
    @Override
    public int size() {
        int result = 0;
        for (Composite child : children) {
            result += child.size();
        }
        return result;
    }

    /**
     * Method accepts for the Visitor implementation
     * @param visitor the visitor to accept
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    /**
     * Setter
     * @param parent the info to save
     */
    @Override
    public void setParent(Composite parent) {
        this.dad = parent;
    }

    /**
     * Getter
     * @return the name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Method toString
     * @return String with the info
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(name).append(":\n");
        for (Composite child : children) {
            result.append(child.toString());
        }
        return result.toString();
    }

    /**
     * Method Getter
     * @return the children
     */
    public List<Composite> getChildren() {
        return this.children;
    }
}
