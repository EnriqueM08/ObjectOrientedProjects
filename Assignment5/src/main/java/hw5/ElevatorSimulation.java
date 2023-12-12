package hw5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ElevatorSimulation {
	public static void main(String args[]) {
		String fileName = args[0];
		Elevator elevator = new Elevator();
		try {
			File inputFile = new File(fileName);
		    Scanner fileScanner = new Scanner(inputFile);
		    
		    while (fileScanner.hasNextInt()) {
		    	int floor = fileScanner.nextInt();
		    	changeState(elevator, floor);
		    }
		    
		    fileScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred while opening file please check file"
					+ " name.");
		    e.printStackTrace();
		}
	}
	
	private static void changeState(Elevator elevator, int floor) {
		switch (floor) {
		case 1:
			elevator.floorOnePressed();
			break;
		case 2:
			elevator.floorTwoPressed();
			break;
		case 3:
			elevator.floorThreePressed();
			break;
		default:
			break;
		}
	}
}
