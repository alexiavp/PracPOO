package factory;

import Test.*;
import dataFrame.*;
import java.util.*;

/**
 * Class with the test for the factory
 */
public class TestFactory extends Examples {

    /**
     * Method testFactory
     */
    public void testFactory(){
        int[] comparators = {0,1,2,3};
        CSVFile csvfile = new CSVFile();
        System.out.println("CSV File Test");
        DataFrame result=csvfile.readFile("cities.csv");
        System.out.println("Labels of the columns\n" + result.data.keySet());

        JSONFile jsonfile = new JSONFile();
        System.out.println("JSON File Test");
        DataFrame result2=jsonfile.readFile("cities.json");
        System.out.println("Labels of the columns\n" + result2.data.keySet());

        TXTFile txtfile = new TXTFile();
        System.out.println("TXT File Test");
        DataFrame result3=txtfile.readFile("cities.txt");
        System.out.println("Labels of the columns\n" + result3.data.keySet());

        System.out.println("\nTesting functions...");
        System.out.println("rows and columns: CSV  "+result.size()+" "+result.columns()+"  JSON  "+result2.size()+" "+result2.columns());
        System.out.println("size: CSV  "+result.size()+"  JSON  "+result2.size());
        System.out.println("at: CSV  "+result.at(12, "LatD")+"  JSON  "+result2.at(12, "LatD"));
        System.out.println("iat: CSV  "+result.iat(0, 7)+"  JSON  "+result2.iat(0, 7));
        System.out.println("sort: \nCSV Ascending:\n"+result.sort("City",comparators[0]).toString()+"\nJSON Descending\n"+result2.sort("LatM",comparators[1]).toString());
        System.out.println("query: Printing only info from the W");
        System.out.println(result.query("EW",1,"W"));
        System.out.println("\nTesting functions query and sort optimized...");
        System.out.println("Function query2, shows cities named Winnipeg:\n"+result.query2("City", (String a) -> a.equals("Winnipeg")));
        System.out.println("sort2: \nCSV Descending:\n"+result.sort2("City", Comparator.reverseOrder())+"\nJSON Ascending\n"+result2.sort2("LatM", Comparator.naturalOrder()));
    }
}
