package visitor;

import factory.*;
import composite.*;

/**
 * Class with the test to the Visitor and the Composite implemente
 */
public class TestVisitor {
    /**
     * Method of the test for the visitor and the composite
     */
    public void testCompositeAndVisitor(){
        Directory dir_dataframes = new Directory("Directory_dataframes");
        Directory dir_csv = new Directory("Directory_csv");
        Directory dir_json = new Directory("Directory_json");
        dir_dataframes.addChild(dir_csv);
        dir_dataframes.addChild(dir_json);
        DataFrameComposite json = new DataFrameComposite( new JSONFile().readFile("cities.json"));
        DataFrameComposite csv = new DataFrameComposite( new CSVFile().readFile("cities.csv"));
        dir_json.addChild(json);
        dir_csv.addChild(csv);
        System.out.println("The size of the directory of the DataFrames: "+dir_dataframes.size());
        System.out.println("The size of the JSON file: "+json.size());
        System.out.println("The size of the CSV file: "+csv.size());
        MaxVisitor maxV = new MaxVisitor("LatD");
        dir_dataframes.accept(maxV);
        System.out.println("The maximum value in LatD: "+maxV.getMax());
        AverageVisitor avV = new AverageVisitor("LatD");
        dir_dataframes.accept(avV);
        System.out.println("The average value in LatD: "+avV.getAverage());
        SumVisitor sumV = new SumVisitor("LatD");
        dir_dataframes.accept(sumV);
        System.out.println("The sum of all the values in LatD: "+sumV.getSuma());
        dir_csv.removeChild(csv);

        //TODO: ACABAR DE FER EL TEST PER AL VISITOR
    }
}
