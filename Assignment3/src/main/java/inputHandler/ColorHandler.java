package inputHandler;

import Commands.ColorCommand;
import Commands.Command;
import Commands.ColorCommand.Color;

public class ColorHandler implements InputHandler {
	private InputHandler next;
	
	public ColorHandler() {
		next = null;
	}
		
	@Override 
	public Command handleInput(String input) {
		String[] words = input.split(" ");
		
		if (words.length == 2 && words[0].toUpperCase().equals("COLOR")) {
			return new ColorCommand(Color.valueOf(words[1]));
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
