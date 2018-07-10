/**
 *Tree Builder class to build the original and clones of the trees
 */

package util;

/**
 *Importing the required inbuilt Java classes
 */
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import myTree.Node;

public class TreeBuilder {
    Results res = new Results();
    BST bst;
    public List<BST> backupList;
    Node mainNode;
    private int counter = 0;

    /**
     *Default Constructor
     */
    public TreeBuilder() {
        bst = new BST();
        backupList = new ArrayList<BST>();
        BST backup;
        for (int i = 0; i < 2; i++) {
            backup = new BST();
            backupList.add(backup);
        }
    }

    /**
     *method to create the tree
     */
    public void create(String inputFile) {

        String str = null;
        FileProcessor fp = new FileProcessor();
        List<String> strVal = new ArrayList<String>();
        Node observerNode = null;
        while ((str = fp.ReadLine(inputFile)) != null) {

            int i = 0;
            String course = null;
            Pattern pattern = Pattern.compile("\\w+");
            Matcher matcher = pattern.matcher(str);

            int intVal = 0;

            while (matcher.find()) {

                if (i == 0) {
                    intVal = Integer.parseInt(matcher.group());
                    i++;
                } else {

                    course = matcher.group();
                    strVal.add(matcher.group());
                }

            }
            counter++;
            mainNode = new Node(intVal, null);
            bst.insert(mainNode, course);

            for (BST b : backupList) {
                observerNode = new Node(intVal, mainNode);
                b.insert(observerNode, course);
            }
        }

    }

    /**
     *Method to delete courses
     */
    public void deleteValues(int deleteIn, String Course_deleteIn) {

        Node n1;
        n1 = new Node(deleteIn, null);
        bst.remove(n1, Course_deleteIn);
    }

    /**
     *Method to print the nodes
     */
    public void printNodes() {
        //res.printToStdout("Printing the original Tree");
        res.printToFile("Printing the original Tree");
        bst.printNodes();

        //res.printToStdout("\n\nPrinting the backup");
        res.printToFile("\n\nPrinting the backups");

        //res.printToStdout("--------------------------");
        res.printToFile("--------------------------");

        for (BST bst : backupList) {
            bst.printNodes();
            System.out.println();
            res.writeToFile("\n");
        }
    }

    public void deleteCreateValue(String deleteFileIn) {
        int k = 1;
        String str = null;
        FileProcessor fp = new FileProcessor();
        List<String> strVal = new ArrayList<String>();

        while ((str = fp.ReadLine(deleteFileIn)) != null) {

            int i = 0;
            String course = null;
            Pattern pattern = Pattern.compile("\\w+");
            Matcher matcher = pattern.matcher(str);

            int intVal = 0;

            while (matcher.find()) {

                if (i == 0) {
                    intVal = Integer.parseInt(matcher.group());
                    i++;
                } else {

                    course = matcher.group();
                    strVal.add(matcher.group());
                }

            }

            res.printToFile("Printing elements Deleting element :" + k);

            res.printToFile("__________________________________");

            k++;
            deleteValues(intVal, course);
            printNodes();

        }

    }

}