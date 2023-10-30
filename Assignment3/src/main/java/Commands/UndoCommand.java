package Commands;

import hw3.ShapeEditor;
import memento.Memento;

public class UndoCommand implements Command {
	private Memento toUndo;
	
	public UndoCommand() {
		toUndo = ShapeEditor.drawList.getLastMemento();
	}
	
	@Override
	public void execute() {
		if(toUndo == null) {
			System.out.println("ERROR: Nothing to Undo");
			return;
		}
		
		toUndo.getCurCommand().undo(toUndo.getPreviousInfo());
	}

	@Override
	public void undo(String prevInfo) {
		
	}
}
