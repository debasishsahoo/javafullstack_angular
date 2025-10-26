package com.java.collection.list.vector.stack;

import java.util.Stack;

public class UndoRedoExample {
	private Stack<String> undoStack;
	private Stack<String> redoStack;
	private String currentText;

	public UndoRedoExample() {
		undoStack = new Stack<>();
		redoStack = new Stack<>();
		currentText = "";
	}

	public void write(String text) {
		undoStack.push(currentText);
		currentText = text;
		redoStack.clear(); // Clear redo stack on new action
		System.out.println("Written: " + text);
	}

	public void undo() {
		if (undoStack.empty()) {
			System.out.println("Nothing to undo");
			return;
		}
		redoStack.push(currentText);
		currentText = undoStack.pop();
		System.out.println("Undo -> Current text: " + currentText);
	}

	public void redo() {
		if (redoStack.empty()) {
			System.out.println("Nothing to redo");
			return;
		}
		undoStack.push(currentText);
		currentText = redoStack.pop();
		System.out.println("Redo -> Current text: " + currentText);
	}

	public void display() {
		System.out.println("Current: " + currentText);
	}

	public static void main(String[] args) {
		System.out.println("=== Undo/Redo Functionality ===\n");

		UndoRedoExample editor = new UndoRedoExample();

		editor.write("Hello");
		editor.write("Hello World");
		editor.write("Hello World!");
		editor.display();

		System.out.println();
		editor.undo();
		editor.undo();
		editor.display();

		System.out.println();
		editor.redo();
		editor.display();

		System.out.println();
		editor.write("New text");
		editor.display();
		editor.redo(); // Should show nothing to redo
	}
}
