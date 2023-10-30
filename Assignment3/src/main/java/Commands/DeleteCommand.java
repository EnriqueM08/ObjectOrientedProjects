package Commands;

import hw3.ShapeEditor;
import memento.Memento;
import shapes.Shape;

public class DeleteCommand implements Command {
	private Shape toDelete;
	
	public DeleteCommand() {
		toDelete = ShapeEditor.selectedShape;
	}
	
	@Override
	public void execute() {
		if(ShapeEditor.selectedShape == null) {
			System.out.println("No shape selected");
			return;
		}
		
		ShapeEditor.drawList.addMemento((new Memento(this, null)));
		
		ShapeEditor.shapes.remove(toDelete);
		ShapeEditor.selectedShape = null;
	}

	@Override
	public void undo(String prevInfo) {
		ShapeEditor.shapes.add(toDelete);
		ShapeEditor.selectedShape = toDelete;
	}
	
	public Shape getToDelete() {
		return toDelete;
	}
	
	public void setToDelete(Shape toDelete) {
		this.toDelete = toDelete;
	}
}
