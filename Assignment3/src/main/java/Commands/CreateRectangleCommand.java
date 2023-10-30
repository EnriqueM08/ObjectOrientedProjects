package Commands;

import hw3.ShapeEditor;
import memento.Memento;
import shapes.Rectangle;

public class CreateRectangleCommand implements Command{
	private int width;
	private int height;
	
	public CreateRectangleCommand(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void execute() {
		Rectangle createdRectangle = new Rectangle(width, height);
		createdRectangle.setIdNumber(ShapeEditor.curLastIDNum + 1);
		
		ShapeEditor.curLastIDNum += 1;
		ShapeEditor.shapes.add(createdRectangle);
		
		ShapeEditor.drawList.addMemento((new Memento(this, 
				Integer.toString(ShapeEditor.curLastIDNum))));
	}

	@Override
	public void undo(String prevInfo) {
		ShapeEditor.shapes.remove(Integer.parseInt(prevInfo)-1);
		ShapeEditor.curLastIDNum -= 1;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
