package hw5;

public class Elevator {
	public State firstFloorOpenState;
	public State firstFloorClosedState;
	public State secondFloorOpenState;
	public State secondFloorClosedState;
	public State thirdFloorOpenState;
	public State thirdFloorClosedState;
	
	private State state;
	
	public Elevator() {
		firstFloorOpenState = new FirstFloorOpenState(this);
		firstFloorClosedState = new FirstFloorClosedState(this);
		secondFloorOpenState = new SecondFloorOpenState(this);
		secondFloorClosedState = new SecondFloorClosedState(this);
		thirdFloorOpenState = new ThirdFloorOpenState(this);
		thirdFloorClosedState = new ThirdFloorClosedState(this);
		
		state = firstFloorOpenState;
	}
	
	public void floorOnePressed() {
		state.firstFloorPressed();
	}
	
	public void floorTwoPressed() {
		state.secondFloorPressed();
	}
	
	public void floorThreePressed() {
		state.thirdFloorPressed();
	}
	
	public void setState(State toSet) {
		this.state = toSet;
	}
	
	public State getState() {
		return this.state;
	}
}
