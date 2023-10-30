package Commands;

import hw3.ShapeEditor;
import shapes.Shape;

public class DrawSceneCommand implements Command {
	
	public DrawSceneCommand() {
		
	}
	
	@Override
	public void execute() {
		Shape shape = null;
		
		for(int i = 1; i <= ShapeEditor.curLastIDNum; i++) {
			for(int j = 0; j < ShapeEditor.shapes.size(); j++) {
				shape = ShapeEditor.shapes.get(j);
			    
				if(shape.getIdNumber() == i) {
			    	System.out.println(shape);
                    j = ShapeEditor.shapes.size();
			    }
			}
		}
	}

	@Override
	public void undo(String prevInfo) {
		
	}
}
