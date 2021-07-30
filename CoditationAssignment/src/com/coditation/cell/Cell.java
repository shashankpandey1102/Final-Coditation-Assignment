package com.coditation.cell;
/*
 * Author = Shashank Pandey
 */
public class Cell {

	private int id;
	private int status;

	public Cell(int id, int status) { // Constructor
		this.id = id;
		this.status = status;
	}

	@Override
	public String toString() { // toString method to represent object
		return "Cell [id=" + id + ", status=" + status + "]";
	}

	// Getters and Setters for variable manipulation

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
