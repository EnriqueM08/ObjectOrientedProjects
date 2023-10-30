package inputHandler;

import Commands.Command;
import Commands.DeleteCommand;

public class DeleteHandler implements InputHandler {
	private InputHandler next;
	
	public DeleteHandler() {
		next = null;
	}
		
	@Override 
	public Command handleInput(String input) {
		String[] words = input.split(" ");
		
		if (words.length == 1 && words[0].toUpperCase().equals("DELETE")) {
			return new DeleteCommand();
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
