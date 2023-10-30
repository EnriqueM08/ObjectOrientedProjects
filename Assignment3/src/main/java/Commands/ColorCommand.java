package Commands;

import hw3.ShapeEditor;
import memento.Memento;

public class ColorCommand implements Command {
	public enum Color {
	    Red, Blue, Yellow, Orange, Green;
	}
	private Color color;
	
	public ColorCommand(Color color) {
		this.color = color;
	}
	
	@Override
	public void execute() {
		if(ShapeEditor.selectedShape == null) {
			System.out.println("No shape selected");
			return;
		}
		
		ShapeEditor.drawList.addMemento((new Memento(this, 
				ShapeEditor.selectedShape.getColor().toString())));
		
		ShapeEditor.selectedShape.setColor(color);
	}

	@Override
	public void undo(String prevInfo) {
		ShapeEditor.selectedShape.setColor(Color.valueOf(prevInfo));
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
