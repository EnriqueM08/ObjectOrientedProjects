package Commands;

import hw3.ShapeEditor;
import memento.Memento;

public class MoveCommand implements Command {
	private int x;
	private int y;
	
	public MoveCommand(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	
	@Override
	public void execute() {
		if(ShapeEditor.selectedShape == null) {
			System.out.println("No shape selected");
			return;
		}
		
		ShapeEditor.drawList.addMemento((new Memento(this, 
				ShapeEditor.selectedShape.getX() + " " + 
		        ShapeEditor.selectedShape.getY())));
		
		ShapeEditor.selectedShape.setX(x);
		ShapeEditor.selectedShape.setY(y);
	}

	@Override
	public void undo(String prevInfo) {
		String[] words = prevInfo.split(" ");
		
		ShapeEditor.selectedShape.setX(Integer.parseInt(words[0]));
		ShapeEditor.selectedShape.setY(Integer.parseInt(words[1]));
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
