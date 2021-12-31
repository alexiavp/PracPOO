package Test;

import factory.TestFactory;
import mapReduce.TestMapReduce;
import observer.TestObserverAndProxy;
import visitor.*;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class with the general test
 */
public class Examples {

    static Scanner key = new Scanner(System.in);

    /**
     * General main
     * @param args for the main
     */
    public static void main(String[] args) {
        int option;
        showMenu();
        option = readOption("", 0, 4);
        if (option != 0) {
            do {
                switch (option) {
                    case 1 -> {
                        System.out.println("\nTesting factory methods...\n");
                        TestFactory test = new TestFactory();
                        test.testFactory();
                        pause();
                    }
                    case 2 -> {
                        System.out.println("\nTesting Visitor and Composite methods...\n");
                        TestVisitor test2 = new TestVisitor();
                        test2.testCompositeAndVisitor();
                        pause();
                    }
                    case 3 -> {
                        System.out.println("\nTesting MapReduce methods...\n");
                        TestMapReduce test3 = new TestMapReduce();
                        test3.testMapReduce();
                        pause();
                    }
                    case 4 -> {
                        System.out.println("\nTesting Proxy and Observer methods...\n");
                        TestObserverAndProxy test4 = new TestObserverAndProxy();
                        test4.testObserverAndProxy();
                        pause();
                    }
                }
                showMenu();
                option = readOption("",0,4);
            }while (option!=0);
            System.out.println("\n\tSee you later!");
        }
        key.close();
    }

    /**
     * Menu
     */
    public static void showMenu(){
        System.out.println("\n Options:");
        System.out.println("\t0.  Exit.");
        System.out.println("\t1.  Test Factory methods.");
        System.out.println("\t2.  Test Visitor and Composite methods.");
        System.out.println("\t3.  Test MapReduce methods.");
        System.out.println("\t4.  Test Proxy and Observer methods.");
        System.out.print("\n\t\t\tSelect an option,");
    }

    /**
     * Method to read the option of the menu controlling InputMismatchException
     * @param message to show
     * @param min     minimum number
     * @param max     maximum number
     * @return the correct number
     */
    public static int readOption(String message, int min, int max) {
        int result = 0;
        boolean read = false;
        do {
            try {
                System.out.print(message + "the number has to be between " + min + " and  " + max + ": ");
                result = key.nextInt();
                read = true;
            } catch (InputMismatchException e) {
                System.out.println("It has to be an Integer");
                key.nextLine();
            } finally {
                if (result > max || result < min) {
                    read = false;
                }
            }
        } while (!read);
        return result;
    }

    /**
     * The program stops util the user press enter
     */
    public static void pause() {
        System.out.println("\n\tPress \"ENTER\" to proceed...");
        try {
            if (System.in.read() == -1)
                System.out.println("\t\tYou shouldn't have written anything!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
