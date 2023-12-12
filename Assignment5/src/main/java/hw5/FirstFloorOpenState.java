package hw5;

public class FirstFloorOpenState implements State {
	private Elevator elevator;
	
	public FirstFloorOpenState(Elevator elevator) {
		this.elevator = elevator;
	}

	@Override
	public void firstFloorPressed() {
		System.out.println("1 Pressed");
		System.out.println("Doors are closed");
		System.out.println("Nothing happens");
		elevator.setState(elevator.firstFloorClosedState); 
	}

	@Override
	public void secondFloorPressed() {
		System.out.println("2 Pressed");
		System.out.println("Doors are closed");
		System.out.println("Going up...");
		System.out.println("*ding* The elevator arrives at Floor 2");
		System.out.println("Doors are open");
		elevator.setState(elevator.secondFloorOpenState); 
	}

	@Override
	public void thirdFloorPressed() {
		System.out.println("3 Pressed");
		System.out.println("Doors are closed");
		System.out.println("Going up...");
		System.out.println("*ding* The elevator arrives at Floor 3");
		System.out.println("Doors are open");
		elevator.setState(elevator.thirdFloorOpenState); 
	}
}
