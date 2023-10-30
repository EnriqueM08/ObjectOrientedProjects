package memento;

import Commands.Command;

public class Memento {
	private Command curCommand;
	private String previousInfo;
	
	public Memento(Command command, String prevInfo) {
		setCurCommand(command);
		setPreviousInfo(prevInfo);
	}

	public Command getCurCommand() {
		return curCommand;
	}

	public void setCurCommand(Command curCommand) {
		this.curCommand = curCommand;
	}

	public String getPreviousInfo() {
		return previousInfo;
	}

	public void setPreviousInfo(String previousInfo) {
		this.previousInfo = previousInfo;
	}
}
