/**
 *Subject Interface with the declaration for methods removeObserver(), notifyObserver() and registerObserver()
 */

package myTree;

import others.EmptyClassForHashMap;

public interface SubjectI {

	public void removeObserver(ObserverI o);

	public void notifyObserver(int course, String courseFromMain);

	public void registerObserver(ObserverI o, EmptyClassForHashMap f);
}
