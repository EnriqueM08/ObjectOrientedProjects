package inputHandler;

import Commands.Command;
import Commands.CreateCircleCommand;

public class CreateCircleHandler implements InputHandler{
	private InputHandler next;
	
	public CreateCircleHandler() {
		next = null;
	}
		
	@Override 
	public Command handleInput(String input) {
		String[] words = input.split(" ");
		
		if (words.length == 3 && words[0].toUpperCase().equals("CREATE") && 
			words[1].toUpperCase().equals("CIRCLE") && 
			checkNum(words[2])) {
			return new CreateCircleCommand(Integer.parseInt(words[2]));
		}
		
		if(next == null) {
			return null;
		}
		
		return next.handleInput(input);
	}

	private boolean checkNum(String numOne) {
		try{
	        Integer.parseInt(numOne);
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
