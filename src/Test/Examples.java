package Test;

import factory.TestFactory;
import mapReduce.TestMapReduce;
import observer.TestObserverAndProxy;
import visitor.*;

/**
 * Class with the general test
 */
public class Examples {
    /**
     * General main
     * @param args for the main
     */
    public static void main(String[] args) {
        System.out.println("\nTesting factory methods...\n");
        TestFactory test = new TestFactory();
        test.testFactory();

        System.out.println("\nTesting Visitor and Composite methods...\n");
        TestVisitor test2 = new TestVisitor();
        test2.testCompositeAndVisitor();

        System.out.println("\nTesting MapReduce methods...\n");
        TestMapReduce test3 = new TestMapReduce();
        test3.testMapReduce();

        System.out.println("\nTesting Proxy and Observer methods...\n");
        TestObserverAndProxy test4 = new TestObserverAndProxy();
        test4.testObserverAndProxy();
    }
}
