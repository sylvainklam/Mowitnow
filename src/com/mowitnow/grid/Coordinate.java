package com.mowitnow.grid;

import com.mowitnow.constants.Orientation;

/**
 * Objet Coordinate
 * 
 * Position de la tondeuse (x,y,orientation)
 * 
 * @author sylva
 *
 */
public class Coordinate {

	private int x;
	private int y;
	private Orientation orientation;

	public Coordinate(int x, int y, Orientation orientation) {
		this.x = x;
		this.y = y;
		this.orientation = orientation;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public String toString() {
		return (this.getX() + " " + this.getY() + " " + this.getOrientation());
	}
}
