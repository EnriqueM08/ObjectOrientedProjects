package inputHandler;

import Commands.Command;
import Commands.CreateRectangleCommand;

public class CreateRectangleHandler implements InputHandler{
	private InputHandler next;
	
	public CreateRectangleHandler() {
		next = null;
	}
		
	@Override 
	public Command handleInput(String input) {
		String[] words = input.split(" ");
		
		if (words.length == 4 && words[0].toUpperCase().equals("CREATE") && 
			words[1].toUpperCase().equals("RECTANGLE") && 
			checkNums(words[2], words[3])) {
			return new CreateRectangleCommand(Integer.parseInt(words[2]), 
											  Integer.parseInt(words[3]));
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
