package util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import others.BST;
import myTree.Node;
import util.Results;
import util.FileProcessor;

public class TreeBuilder {
    Results res = new Results();
    BST bst;
    public List<BST> backupList;
    Node mainNode;
    private int counter = 0;

    public TreeBuilder() {
        bst = new BST();
        backupList = new ArrayList<BST>();
        BST backup;
        for (int i = 0; i < 2; i++) {
            backup = new BST();
            backupList.add(backup);
        }
    }

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

    public void deleteValues(int deleteIn, String C_deleteIn) {

        Node n1;
        n1 = new Node(deleteIn, null);
        bst.remove(n1, C_deleteIn);
    }

    public void printNodes() {
        res.printToStdout("Printing the original BST");
        res.printToFile("Printing the original BST");
        bst.printNodes();

        res.printToStdout("\n\nPrinting the backup");
        res.printToFile("\n\nPrinting both backups");

        res.printToStdout("--------------------------");
        res.printToFile("--------------------------");

        for (BST bst : backupList) {
            bst.printInOrder();
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
            res.printToStdout("Printing elements Deleting element :" + k);

            res.printToStdout("__________________________________");
            res.printToFile("__________________________________");

            k++;
            deleteValues(intVal, course);
            printInOrder();

        }

    }

}