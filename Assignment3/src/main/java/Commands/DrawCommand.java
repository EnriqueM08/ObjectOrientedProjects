package Commands;

import hw3.ShapeEditor;
import memento.Memento;

public class DrawCommand implements Command {
	
	public DrawCommand() {
		
	}
	
	@Override
	public void execute() {
		if(ShapeEditor.selectedShape == null) {
			System.out.println("No shape selected");
			return;
		}
		
		ShapeEditor.drawList.addMemento((new Memento(this, null)));
		System.out.println(ShapeEditor.selectedShape);
	}

	@Override
	public void undo(String prevInfo) {
		
	}
}
