package inputHandler;

import Commands.Command;
import Commands.DrawSceneCommand;

public class DrawSceneHandler implements InputHandler {
	private InputHandler next;
	
	public DrawSceneHandler() {
		next = null;
	}
		
	@Override 
	public Command handleInput(String input) {
		String[] words = input.split(" ");
		
		if (words.length == 1 && words[0].toUpperCase().equals("DRAWSCENE")) {
			return new DrawSceneCommand();
		}
		
		if(next == null) {
			return null;
		}
		
		return next.handleInput(input);
	}

	public InputHandler getNext() {
		return next;
	}

	public void setNext(InputHandler next) {
		this.next = next;
	}
}
