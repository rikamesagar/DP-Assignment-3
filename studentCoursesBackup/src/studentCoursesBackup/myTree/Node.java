/**
 *Node class that is used to define the Node Structure
 */
package myTree;

import others.EmptyClassForHashMap;

/**
 *Importing the required Java Classes
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node implements SubjectI, ObserverI {

    private int bNumber;
    private List<String> courses;
    private Node left;
    private SubjectI subjectNode;
    public Node right;
    Node z;
    public boolean isMax;
    private HashMap<ObserverI, EmptyClassForHashMap> observers;
    List<String> courseList;

    /**
     *Default Constructor to initialize the list(HashMap) of Observers
     */
    public Node() {
        observers = new HashMap<ObserverI, EmptyClassForHashMap>();
    }

    /**
     *Parameterized constructor passing the
     * @param bNumber
     */
    public Node(int bNumber) {

        this.bNumber = bNumber;
    }

    /**
     *Parameterized constructor passing
     * @param bnumberIn and
     * @param subjectNodeIn
     */
    public Node(int bnumberIn, SubjectI subjectNodeIn) {
        bNumber = bnumberIn;
        left = null;
        right = null;
        subjectNode = subjectNodeIn;
        if (subjectNodeIn != null) {
            subjectNode.registerObserver(this, null);
        } else
            observers = new HashMap<ObserverI, EmptyClassForHashMap>();
    }

    /**
     *Parameterized Constructor passing
     * @param bNumber
     * @param courses
     * @param left
     * @param right
     */
    public Node(int bNumber, List<String> courses, Node left, Node right) {
        this.bNumber = bNumber;
        this.courses = courses;
        this.left = left;
        this.right = right;
        observers = new HashMap<ObserverI, EmptyClassForHashMap>();
    }

    /**
     *Getter and setter methods to get and set various member elements
     */
    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getbNumber() {
        return bNumber;
    }

    public void setbNumber(int bNumber) {
        this.bNumber = bNumber;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    /**
     *Methods overridden from the interface and implemented
     */

    @Override
    public void registerObserver(ObserverI o, EmptyClassForHashMap f) {
        observers.put(o, f);
    }

    @Override
    public void removeObserver(ObserverI o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver(int course, String courseFromMain) {
        for (Map.Entry<ObserverI, EmptyClassForHashMap> entry : observers.entrySet()) {
            z = (Node) entry.getKey();
            this.update(z, courseFromMain);
        }
    }

    @Override
    public void update(Node n, String bnumber1) {
        n.getCourses().remove(bnumber1);
    }
}
