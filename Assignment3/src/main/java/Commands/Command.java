package Commands;

public interface Command {
	
	public void execute();

	public void undo(String prevInfo);
}
