package myTree;

import others.emptyTestInterface;

public class Node implements SubjectI, ObserverI {

    private int bNumber;
    private List<String> courses;
    private Node left;
    private SubjectI subjectNode;
    Node right;
    Node z;
    public boolean isMax;
    private HashMap<ObserverI, emptyTestInterface> observers;
    List<String> courseList;

    public Node() {
        observers = new HashMap<ObserverI, emptyTestInterface>();
    }

    public Node(int bNumber) {
        this.bNumber = bNumber;
    }

    public Node(int bnumberIn, SubjectI subjectNodeIn) {
        bNumber = bnumberIn;
        left = null;
        right = null;
        subjectNode = subjectNodeIn;
        if (subjectNodeIn != null) {
            subjectNode.registerObserver(this, null);
        } else
            observers = new HashMap<ObserverI, emptyTestInterface>();
    }

    public Node(int bNumber, List<String> courses, Node left, Node right) {
        this.bNumber = bNumber;
        this.courses = courses;
        this.left = left;
        this.right = right;
        observers = new HashMap<ObserverI, emptyTestInterface>();
    }

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

    @Override
    public void registerObserver(ObserverI o, emptyTestInterface f) {
        observers.put(o, f);
    }

    @Override
    public void removeObserver(ObserverI o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver(int course, String courseFromMain) {
        for (Map.Entry<ObserverI, emptyTestInterface> entry : observers.entrySet()) {
            z = (Node) entry.getKey();
            this.update(z, courseFromMain);

        }
    }

    @Override
    public void update(Node n, String bnumber1) {
        n.getCourses().remove(bnumber1);
    }

}
