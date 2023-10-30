package inputHandler;

import Commands.Command;

public interface InputHandler {
	public static final InputHandler next = null;
	
	public Command handleInput(String input);
}
