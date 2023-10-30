package Commands;

import hw3.ShapeEditor;
import memento.Memento;
import shapes.Shape;

public class SelectCommand implements Command {
	private int selectedShapeID;
	
	public SelectCommand(int selectedShapeID) {
		this.selectedShapeID = selectedShapeID;
	}
	
	@Override
	public void execute() {
		try {
			Shape toSet = getShapeToSet();
			
			if(ShapeEditor.selectedShape != null)
				ShapeEditor.drawList.addMemento((new Memento(this, 
					Integer.toString(ShapeEditor.selectedShape.getIdNumber()))));
			else 
				ShapeEditor.drawList.addMemento(new Memento(this, null));
			
			ShapeEditor.selectedShape = toSet;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("ERROR: invalid shape for SELECT");
		}
	}
	
	private Shape getShapeToSet() {
		int i = 0;
		Shape toSet = ShapeEditor.shapes.get(i);
		
		while (toSet != null) {
			if(toSet.getIdNumber() == selectedShapeID)
				return toSet;
			i++;
			toSet = ShapeEditor.shapes.get(i);
		}
		
		return null;
	}

	@Override
	public void undo(String prevInfo) {
		if(prevInfo == null)
			ShapeEditor.selectedShape = null;
		else 
			ShapeEditor.selectedShape = ShapeEditor.shapes.get(Integer.parseInt(prevInfo)-1);
	}

	public int getSelectedShapeID() {
		return selectedShapeID;
	}

	public void setSelectedShapeID(int selectedShapeID) {
		this.selectedShapeID = selectedShapeID;
	}
}
