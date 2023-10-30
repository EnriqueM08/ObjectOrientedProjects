package Commands;

import hw3.ShapeEditor;
import memento.Memento;
import shapes.Circle;
import shapes.Shape;

public class CreateCircleCommand implements Command {
	private int radius;
	
	public CreateCircleCommand(int radius) {
		this.radius = radius;
	}
	
	@Override
	public void execute() {
		Shape createdCircle = new Circle(radius);
		createdCircle.setIdNumber(ShapeEditor.curLastIDNum + 1);
		
		ShapeEditor.curLastIDNum += 1;
		ShapeEditor.shapes.add(createdCircle);
		
		ShapeEditor.drawList.addMemento((new Memento(this, 
				Integer.toString(ShapeEditor.curLastIDNum))));
	}

	@Override
	public void undo(String prevInfo) {
		ShapeEditor.shapes.remove(Integer.parseInt(prevInfo)-1);
		ShapeEditor.curLastIDNum -= 1;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
}