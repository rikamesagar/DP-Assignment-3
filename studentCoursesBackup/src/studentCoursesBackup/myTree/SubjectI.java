package myTree;

public interface SubjectI {

	public void removeObserver(ObserverI o);

	public void notifyObserver(int course, String courseFromMain);

	public void registerObserver(ObserverI o, emptyTestInterface f);
}
