package mapReduce;

import Test.Examples;
import dataFrame.DataFrame;
import factory.CSVFile;
import factory.JSONFile;
import java.util.ArrayList;
import java.util.List;

/**
 * Class with the test of the mapReduce
 */
public class TestMapReduce extends Examples {

    /**
     * Function testMapReduce
     */
    public void testMapReduce(){
        List<DataFrame> list = new ArrayList<>();
        CSVFile csvfile = new CSVFile();
        DataFrame result=csvfile.readFile("sales.csv");
        list.add(result);
        CSVFile csvfile2 = new CSVFile();
        DataFrame result2=csvfile2.readFile("cities.csv");
        list.add(result2);
        JSONFile jsonfile = new JSONFile();
        DataFrame result3=jsonfile.readFile("cities.json");
        list.add(result3);

        IMap<ArrayList<String>> imap = new Obtain();
        Reduce<ArrayList<String>> red = new ReduceAverage();
        MapReduce.mapReduce(list,imap,red,"City", null);
        IMap<DataFrame> imap2 = new Obtain2();
        Reduce<DataFrame> red2 = new ReduceAverage2();
        MapReduce.mapReduce(list,imap2,red2,"City", "Japan");
        IMap<DataFrame> imap3 = new Obtain2();
        Reduce<DataFrame> red3 = new ReduceJoin();
        MapReduce.mapReduce(list,imap3,red3,"City", "Japan");
    }
}
