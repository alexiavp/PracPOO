package observer;

import factory.CSVFile;
import java.util.Comparator;

/**
 * Class with the test of the Observer and the DynamicProxy implemented
 */
public class TestObserverAndProxy {
    /**
     * Method to test the observer and the proxy
     */
    public void testObserverAndProxy(){
        CSVFile file = new CSVFile();
        DataFrameObserver observer = (DataFrameObserver) DynamicProxy.newInstance(new LogObserver(file.readFile("sales.csv")));
        DataFrameObserver observer2 = (DataFrameObserver) DynamicProxy.newInstance(new QueryObserver(file.readFile("sales.csv")));
        System.out.println("Executing some operations on the observers with the proxy interceptor...\n");

        observer.sort2("City", Comparator.naturalOrder());
        observer.iat(15, 15);
        observer.columns();
        System.out.println(observer.getListFunc());

        observer2.query2("City",(String a) -> a.equals("Winnipeg"));
        observer2.query2("Unit Cost",(String a) -> Integer.parseInt(a)>100.00);
        observer2.query("City",1, "Japan");
        observer2.query("Units Sold",4, "5000");
        System.out.println(observer2.getListFunc());

    }
}
