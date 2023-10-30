package inputHandler;

import Commands.Command;
import Commands.MoveCommand;

public class MoveHandler implements InputHandler {
	private InputHandler next;
	
	public MoveHandler() {
		next = null;
	}
		
	@Override 
	public Command handleInput(String input) {
		String[] words = input.split(" ");
		
		if (words.length == 3 && words[0].toUpperCase().equals("MOVE") &&  
			checkNums(words[1], words[2])) {
			return new MoveCommand(Integer.parseInt(words[1]), 
								   Integer.parseInt(words[2]));
		}
		
		if(next == null) {
			return null;
		}
		
		return next.handleInput(input);
	}

	private boolean checkNums(String numOne, String numTwo) {
		try{
	        Integer.parseInt(numOne);
	        Integer.parseInt(numTwo);
	        return true;
	    }
	    catch(NumberFormatException e){
	       return false;
	    }
	}

	public InputHandler getNext() {
		return next;
	}

	public void setNext(InputHandler next) {
		this.next = next;
	}
}
