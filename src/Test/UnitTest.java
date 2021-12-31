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
        @Test
        void TestCompositeAndVisitor() {
            System.out.println("->Testing Composite and Visitor...");
            Directory dir_dataframes = new Directory("Directory_dataframes");
            Directory dir_csv = new Directory("Directory_csv");
            Directory dir_json = new Directory("Directory_json");
            dir_dataframes.addChild(dir_csv);
            dir_dataframes.addChild(dir_json);
            DataFrameComposite json = new DataFrameComposite(new JSONFile().readFile("cities.json"));
            DataFrameComposite csv = new DataFrameComposite(new CSVFile().readFile("cities.csv"));
            dir_json.addChild(json);
            dir_csv.addChild(csv);
            assertEquals(256, dir_dataframes.size());
            assertEquals(128, json.size());
            assertEquals(128, csv.size());
            MaxVisitor maxV = new MaxVisitor("LatD");
            dir_dataframes.accept(maxV);
            assertEquals(50, maxV.getMax());
            AverageVisitor avV = new AverageVisitor("LatD");
            dir_dataframes.accept(avV);
            assertEquals(38.8203125, avV.getAverage());
            SumVisitor sumV = new SumVisitor("LatD");
            dir_dataframes.accept(sumV);
            assertEquals(9938, sumV.getSuma());
        }

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