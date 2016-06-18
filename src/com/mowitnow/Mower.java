package com.mowitnow;

import com.mowitnow.constants.Instruction;
import com.mowitnow.constants.Orientation;
import com.mowitnow.grid.Coordinate;

/**
 * Objet tondeuse
 * 
 * @author sylva
 *
 */
public class Mower {

	/**
	 * Constructeur
	 * 
	 * @param id
	 *            identifiant de la tondeuse
	 * @param coordinate
	 *            position de la tondeuse
	 */
	public Mower(int id, Coordinate coordinate) {
		setId(id);
		setPosition(coordinate);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Mise à jour de la position de la tondeuse
	 * 
	 * @param coordinate
	 * @param x
	 * @param y
	 * @param orientation
	 */
	private void updatePosition(Coordinate coordinate, int x, int y, Orientation orientation) {
		coordinate.setX(x);
		coordinate.setY(y);
		coordinate.setOrientation(orientation);
		setPosition(coordinate);
	}

	/**
	 * Déplacer la tondeuse
	 * 
	 * @param coordinate
	 * @return
	 */
	private void move(Instruction instruction) {
		Coordinate coordinate = this.getPosition();

		switch (instruction) {
		case A:
			if (coordinate.getOrientation() == Orientation.N) {
				updatePosition(coordinate, coordinate.getX(), coordinate.getY() + 1, coordinate.getOrientation());
				break;
			}
			if (coordinate.getOrientation() == Orientation.E) {
				updatePosition(coordinate, coordinate.getX() + 1, coordinate.getY(), coordinate.getOrientation());
				break;
			}

			if (coordinate.getOrientation() == Orientation.W) {
				updatePosition(coordinate, coordinate.getX() - 1, coordinate.getY(), coordinate.getOrientation());
				break;
			}
			if (coordinate.getOrientation() == Orientation.S) {
				updatePosition(coordinate, coordinate.getX(), coordinate.getY() - 1, coordinate.getOrientation());
				break;
			}
		case D:
			if (coordinate.getOrientation() == Orientation.N) {
				updatePosition(coordinate, coordinate.getX(), coordinate.getY(), Orientation.E);
				break;
			}
			if (coordinate.getOrientation() == Orientation.E) {
				updatePosition(coordinate, coordinate.getX(), coordinate.getY(), Orientation.S);
				break;
			}
			if (coordinate.getOrientation() == Orientation.W) {
				updatePosition(coordinate, coordinate.getX(), coordinate.getY(), Orientation.N);
				break;
			}
			if (coordinate.getOrientation() == Orientation.S) {
				updatePosition(coordinate, coordinate.getX(), coordinate.getY(), Orientation.W);
				break;
			}
		case G:
			if (coordinate.getOrientation() == Orientation.N) {
				updatePosition(coordinate, coordinate.getX(), coordinate.getY(), Orientation.W);
				break;
			}
			if (coordinate.getOrientation() == Orientation.E) {
				updatePosition(coordinate, coordinate.getX(), coordinate.getY(), Orientation.N);
				break;
			}
			if (coordinate.getOrientation() == Orientation.W) {
				updatePosition(coordinate, coordinate.getX(), coordinate.getY(), Orientation.S);
				break;
			}
			if (coordinate.getOrientation() == Orientation.S) {
				updatePosition(coordinate, coordinate.getX(), coordinate.getY(), Orientation.E);
				break;
			}
		}
	}

	/**
	 * Déplacement de la tondeuse dans la grille en fonction des instructions
	 * données
	 * 
	 * @param instructions
	 */
	public void move(String instructions) {
		System.out.println("Déplacement tondeuse " + this.getId());
		System.out.println("Position de départ : " + this.getPosition().toString());
		for (int i = 0; i < instructions.length(); i++) {
			Instruction instruction = Instruction.valueOf(instructions.substring(i, i + 1));
			this.move(instruction);
		}
		System.out.println("Position finale " + this.getPosition().toString());
	}

	public Coordinate getPosition() {
		return position;
	}

	public void setPosition(Coordinate position) {
		this.position = position;
	}

	private int id;

	private Coordinate position;
}