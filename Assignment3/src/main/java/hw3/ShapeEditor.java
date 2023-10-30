package hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import Commands.Command;
import inputHandler.ColorHandler;
import inputHandler.CreateCircleHandler;
import inputHandler.CreateRectangleHandler;
import inputHandler.DeleteHandler;
import inputHandler.DrawHandler;
import inputHandler.DrawSceneHandler;
import inputHandler.InputHandler;
import inputHandler.MoveHandler;
import inputHandler.SelectHandler;
import inputHandler.UndoHandler;
import memento.Caretaker;
import shapes.Shape;

public class ShapeEditor {
	public static Shape selectedShape;
	public static ArrayList<Shape> shapes;
	public static Caretaker drawList;
	public static int curLastIDNum;
	
	public static void main(String args[]) {
		InputHandler firstHandler = createHandlers();
		shapes = new ArrayList<Shape>();
		drawList = new Caretaker();
		curLastIDNum = 0;
		
		performDrawings(args[0], firstHandler);
	}
	
	private static InputHandler createHandlers() {
		CreateRectangleHandler crh = new CreateRectangleHandler();
		CreateCircleHandler cch = new CreateCircleHandler();
		SelectHandler sh = new SelectHandler();
		MoveHandler mh = new MoveHandler();
		DrawHandler dh = new DrawHandler();
		ColorHandler ch = new ColorHandler();
		DeleteHandler dh2 = new DeleteHandler();
		DrawSceneHandler dsh = new DrawSceneHandler();
		UndoHandler uh = new UndoHandler();
		
		crh.setNext(cch);
		cch.setNext(sh);
		sh.setNext(mh);
		mh.setNext(dh);
		dh.setNext(ch);
		ch.setNext(dh2);
		dh2.setNext(dsh);
		dsh.setNext(uh);
		
		return crh;
	}
	
	private static void performDrawings(String fileName, InputHandler firstHandler) {
		try {
			File inputFile = new File(fileName);
		    Scanner fileScanner = new Scanner(inputFile);
		    
		    while (fileScanner.hasNextLine()) {
		    	String line = fileScanner.nextLine();
		    	Command commandToExecute = firstHandler.handleInput(line);
		    	if(commandToExecute == null)
		    		System.out.println("Error: Unsupported Input");
		    	else 
		    		commandToExecute.execute();
		    }
		    
		    fileScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred while opening file please check file"
					+ " name.");
		    e.printStackTrace();
		}
	}
}
