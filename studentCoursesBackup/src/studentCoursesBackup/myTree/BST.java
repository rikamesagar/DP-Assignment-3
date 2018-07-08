package myTree;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;

import util.Results;

class BST
{
    Results res = new Results();
    public Node root;

    public BST() {
        root = null;
    }

    private Node isPresentInList(Node n, Node currentNode) {
        if (currentNode == null) {
            return null;
        }
        if (n.getbNumber() == currentNode.getbNumber()) {
            return currentNode;
        } else if (n.getbNumber() < currentNode.getbNumber()) {
            if (currentNode.getLeft() == null) {
                return null;
            } else {
                return isPresent(n, currentNode.getLeft());
            }
        } else if (n.getbNumber() > currentNode.getbNumber()) {
            if (currentNode.getRight() == null) {
                return null;
            } else {
                return isPresent(n, currentNode.getRight());
            }
        }
        return currentNode;
    }

    private Node isPresent(Node n, Node currentNode) {
        if (currentNode == null) {
            return null;
        }
        if (n.getbNumber() == currentNode.getbNumber()) {
            return currentNode;
        } else if (n.getbNumber() < currentNode.getbNumber()) {
            if (currentNode.getLeft() == null) {
                return null;
            } else {
                return isPresent(n, currentNode.getLeft());
            }
        } else if (n.getbNumber() > currentNode.getbNumber()) {
            if (currentNode.getRight() == null) {
                return null;
            } else {
                return isPresent(n, currentNode.getRight());
            }
        }
        return currentNode;

    }

    public void remove(Node node, String course) {
        Node n = isPresentInList(node, root);
        if (n == null) {
            System.out.println("Invalid Node to be deleted");
            return;

        } else {
            if (n.getCourses().contains(course)) {
                n.getCourses().remove(course);
                int bnum = 1234;
                n.notifyObserver(bnum, course);
            } else {
                System.out.println("No element found");
            }
        }

    }

    public void insert(Node node, String course) {
        List<String> courseList;
        Node n = isPresent(node, root);
        if (n == null) {
            if (root == null) {
                courseList = new ArrayList<String>();
                courseList.add(course);
                node.setCourses(courseList);
                root = node;
                return;
            }
            Node currentNode = root;
            Node parentNode = null;
            courseList = new ArrayList<String>();
            courseList.add(course);
            node.setCourses(courseList);

            while (true) {
                parentNode = currentNode;
                if (node.getbNumber() < currentNode.getbNumber()) {
                    currentNode = currentNode.getLeft();
                    if (currentNode == null) {
                        parentNode.setLeft(node);
                        return;
                    }
                } else {
                    currentNode = currentNode.right;
                    if (currentNode == null) {
                        parentNode.right = node;
                        return;
                    }
                }
            }
        } else {
            courseList = n.getCourses();
            courseList.add(course);
            node.setCourses(courseList);
        }

        public Node getRoot() {
            return this.root;
        }

        public void printInOrder() {
            displayTree(root);
        }

        private void displayTree(Node catchingRootIn) {
            if (catchingRootIn == null) {
                return;
            }
            displayTree(catchingRootIn.getLeft());
            res.printViaStd(
                    "B-Number Number: " + catchingRootIn.getbNumber() + " Courses :" + catchingRootIn.getCourses());
            res.printViaFile(
                    "B-Number Number: " + catchingRootIn.getbNumber() + " and courses are :" + catchingRootIn.getCourses());
            displayTree(catchingRootIn.right);

        }
    }

}