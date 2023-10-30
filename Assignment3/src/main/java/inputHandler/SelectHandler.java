package inputHandler;

import Commands.Command;
import Commands.SelectCommand;

public class SelectHandler implements InputHandler{
	private InputHandler next;
	
	public SelectHandler() {
		next = null;
	}
		
	@Override 
	public Command handleInput(String input) {
		String[] words = input.split(" ");
		
		if (words.length == 2 && words[0].toUpperCase().equals("SELECT") &&  
			checkNum(words[1])) {
			return new SelectCommand(Integer.parseInt(words[1]));
		}
		
		if(next == null) {
			return null;
		}
		
		return next.handleInput(input);
	}

	public boolean checkNum(String numOne) {
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
