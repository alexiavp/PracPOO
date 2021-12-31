package visitor;

import factory.*;
import composite.*;

/**
 * Class with the test to the Visitor and the Composite implemented
 */
public class TestVisitor {
    /**
     * Method of the test for the visitor and the composite
     */
    public void testCompositeAndVisitor(){
        Directory dirDF = new Directory("dataFramesDirectory");
        Directory dirCSV = new Directory("CSVDirectory");
        Directory dirJSON = new Directory("JSONDirectory");
        Directory dirTXT =  new Directory("TXTDirectory");
        dirDF.addChild(dirCSV);
        dirDF.addChild(dirJSON);
        dirDF.addChild(dirTXT);
        DataFrameComposite json = new DataFrameComposite(new JSONFile().readFile("cities.json"));
        DataFrameComposite csv = new DataFrameComposite(new CSVFile().readFile("cities.csv"));
        DataFrameComposite txt = new DataFrameComposite(new TXTFile().readFile("cities.txt"));
        DataFrameComposite csv2 = new DataFrameComposite(new CSVFile().readFile("cities2.csv"));
        dirJSON.addChild(json);
        dirCSV.addChild(csv);
        dirCSV.addChild(csv2);
        dirTXT.addChild(txt);
        System.out.println("The size of the directory of the DataFrames: "+dirDF.size());
        System.out.println("The size of the JSON file: "+json.size());
        System.out.println("The size of the CSV file: "+csv.size());
        System.out.println("The size of the CSV file 2: "+csv2.size());
        System.out.println("The size of the TXT file: "+csv.size());
        MaxVisitor maxV = new MaxVisitor("LatD");
        dirDF.accept(maxV);
        System.out.println("The maximum value in LatD: "+maxV.getMax());
        AverageVisitor avV = new AverageVisitor("LatD");
        dirDF.accept(avV);
        System.out.println("The average value in LatD: "+avV.getAverage());
        SumVisitor sumV = new SumVisitor("LatD");
        dirDF.accept(sumV);
        System.out.println("The sum of all the values in LatD: "+sumV.getSum());
        dirCSV.removeChild(csv2);
        System.out.println("The size of the directory of the DataFrames after removing CSV file 2: "+dirDF.size());
    }
}
