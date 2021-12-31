package composite;

import dataFrame.DataFrame;
import visitor.Visitor;
import java.util.LinkedList;
import java.util.List;

/**
 * Class that implements the Composite and extends from the DataFrame
 */
public class DataFrameComposite extends DataFrame implements Composite {

    /**
     * Variable of the class
     */
    private Composite dad;

    /**
     * Constructor
     * @param info to pass super
     */
    public DataFrameComposite(DataFrame info) {
        super(info);
        this.dad=null;
    }
    /**
     * Get the name
     */
    @Override
    public void ls() {
        System.out.println(getName());
    }

    /**
     * Collects the information
     * @return the info
     */
    @Override
    public List<String> collect() {
        LinkedList<String> result = new LinkedList<>();
        result.add(getName());
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
        if (getName().equals(name)) {
            result.add(this);
        }
        return result;
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
    public String getName(){
        return super.getName();
    }

    /**
     * Method toString
     * @return String with the info
     */
    public String toString(){
        return super.toString();
    }

    /**
     * To know the size of the info
     * @return an int of the size
     */
    public int size() {
        return super.size();
    }

    /**
     * Method accepts for the Visitor implementation
     * @param visitor the visitor to accept
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }




}
