package hw5;

public class SecondFloorClosedState implements State{
	private Elevator elevator;
	
	public SecondFloorClosedState(Elevator elevator) {
		this.elevator = elevator;
	}

	@Override
	public void firstFloorPressed() {
		System.out.println("1 Pressed");
		System.out.println("Going down...");
		System.out.println("*ding* The elevator arrives at Floor 1");
		System.out.println("Doors are open");
		elevator.setState(elevator.firstFloorOpenState);
	}

	@Override
	public void secondFloorPressed() {
		System.out.println("2 Pressed");
		System.out.println("Nothing happens");
	}

	@Override
	public void thirdFloorPressed() {
		System.out.println("3 Pressed");
		System.out.println("Going up...");
		System.out.println("*ding* The elevator arrives at Floor 3");
		System.out.println("Doors are open");
		elevator.setState(elevator.thirdFloorOpenState); 
	}
}
