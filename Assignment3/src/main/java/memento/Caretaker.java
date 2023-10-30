package memento;

import java.util.ArrayList;

public class Caretaker {
	private ArrayList<Memento> mementos;
	
	public Caretaker() {
		mementos = new ArrayList<Memento>();
	}
	
	public void addMemento(Memento mementoToAdd) {
		mementos.add(mementoToAdd);
	}
	
	public Memento getLastMemento() {
		if(mementos.size() == 0)
			return null;
		
		return mementos.remove(mementos.size()-1);
	}
}
