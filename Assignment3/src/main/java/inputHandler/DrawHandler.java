package inputHandler;

import Commands.Command;
import Commands.DrawCommand;

public class DrawHandler implements InputHandler {
	private InputHandler next;
	
	public DrawHandler() {
		next = null;
	}
		
	@Override 
	public Command handleInput(String input) {
		String[] words = input.split(" ");
		
		if (words.length == 1 && words[0].toUpperCase().equals("DRAW")) {
			return new DrawCommand();
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
