package Test;

import composite.DataFrameComposite;
import composite.Directory;
import mapReduce.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import factory.*;
import dataFrame.*;
import observer.*;
import visitor.AverageVisitor;
import visitor.MaxVisitor;
import visitor.SumVisitor;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Unit test for some methods implemented
 */
class UnitTest {

    /**
     * Method main to call all the tests
     */
    public static class main{
        /**
         * Test method for Read and operations in DataFrame
         */
        @Test
        void TestReadAndDataFrameOp() {
            CSVFile readTest = new CSVFile();
            TXTFile readTest2 = new TXTFile();
            DataFrame read = readTest.readFile("test.csv");
            DataFrame read2 = readTest2.readFile("test.txt");
            System.out.println("->Testing reading from files and simple DataFrame operations...");
            assertEquals("test.csv", read.getName());
            assertEquals("Europe", read.at(0, "Region"));
            assertEquals("Household", read.iat(0, 2));
            assertEquals(14, read.columns());
            assertEquals(2, read.size());
            assertEquals("test.txt", read2.getName());
            assertEquals("Europe", read2.at(0, "Region"));
            assertEquals("Household", read2.iat(0, 2));
            assertEquals(14, read2.columns());
            assertEquals(2, read2.size());
            ArrayList<String> names = new ArrayList<>();
            names.add("Finland");
            assertEquals(names, read.query2("Country", (String a) -> a.equals("Finland")));
            names.add("Portugal");
            assertEquals(names, read.sort2("Country", Comparator.naturalOrder()));
        }

        /**
         * Test for mapReduce
         */
        @Test
        void TestMapReduce() {
            System.out.println("->Testing MapReduce...");
            CSVFile readTest = new CSVFile();
            TXTFile readTest2 = new TXTFile();
            DataFrame read = readTest.readFile("test.csv");
            DataFrame read2 = readTest2.readFile("test.txt");
            ArrayList<DataFrame> list = new ArrayList<>();
            list.add(read);
            list.add(read2);
            IMap<ArrayList<String>> imap = new Obtain();
            Reduce<ArrayList<String>> red = new ReduceAverage();
            ArrayList<String> names = new ArrayList<>();
            names.add("Finland");
            names.add("Portugal");
            ArrayList<ArrayList<String>> result = new ArrayList<>();
            result.add(names);
            result.add(names);
            assertEquals(result, MapReduce.mapReduce(list, imap, red, "Country", null));
        }

        /**
         * Test for Composite and Visitor
         */
        @Test
        void TestCompositeAndVisitor() {
            System.out.println("->Testing Composite and Visitor...");
            Directory dirDF = new Directory("dataFramesDirectory");
            Directory dirCSV = new Directory("CSVDirectory");
            Directory dirJSON = new Directory("JSONDirectory");
            Directory dirTXT =  new Directory("TXTDirectory");
            dirDF.addChild(dirCSV);
            dirDF.addChild(dirJSON);
            dirDF.addChild(dirTXT);
            DataFrameComposite json = new DataFrameComposite(new JSONFile().readFile("test.json"));
            DataFrameComposite csv = new DataFrameComposite(new CSVFile().readFile("test.csv"));
            DataFrameComposite txt = new DataFrameComposite(new TXTFile().readFile("test.txt"));
            dirJSON.addChild(json);
            dirCSV.addChild(csv);
            dirTXT.addChild(txt);
            assertEquals(6, dirDF.size());
            assertEquals(2, json.size());
            assertEquals(2, csv.size());
            assertEquals(2, txt.size());
            MaxVisitor maxV = new MaxVisitor("Units Sold");
            dirDF.accept(maxV);
            assertEquals(9801, maxV.getMax());
            AverageVisitor avV = new AverageVisitor("Units Sold");
            dirDF.accept(avV);
            assertEquals(6664.5, avV.getAverage());
            SumVisitor sumV = new SumVisitor("Units Sold");
            dirDF.accept(sumV);
            assertEquals(39987.0, sumV.getSum());
        }

        /**
         * Test for Observer
         */
        @Test
        void TestObserver(){
            System.out.println("->Testing Observer...");
            CSVFile readTest = new CSVFile();
            TXTFile readTest2 = new TXTFile();
            LogObserver observer = new LogObserver(readTest.readFile("test.csv"));
            QueryObserver observer2 = new QueryObserver(readTest2.readFile("test.txt"));
            observer.at(0, "Region");
            observer.iat(1, 1);
            observer.columns();
            observer.size();
            String functions = """
                    LOG OBSERVER
                    \tA list of all operations:
                    Function: at
                    Function: iat
                    Function: columns
                    Function: size
                    """;
            assertEquals(functions,observer.getListFunc());

            observer2.query2("Country",(String a) -> a.equals("Portugal"));
            observer2.query("Country",1, "Japan");
            observer2.query("Sales Channel",1, "Offline");
            String queries = """
                    QUERY OBSERVER
                    \tOperations using some filter:
                    Query: Country using predicate
                    Query: Country same than Japan
                    Query: Sales Channel same than Offline
                    """;
            assertEquals(queries,observer2.getListFunc());
        }

    }
}