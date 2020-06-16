/*
 * Copyright (c) 2020.
 * Clément Truillet (clement@ctruillet.eu)
 */

package eu.ctruillet.others.graspableObject;

import processing.core.PConstants;
import processing.core.PVector;

public class GraspableArea {
	//Attributs
	private PVector position;
	private int width;
	private int height;

	//Constructeur
	public GraspableArea(){
		this.position = new PVector(3*Main.processing.width/4,3*Main.processing.height/4);
		this.width=Main.processing.width/4;
		this.height=Main.processing.height/4;
	}

	//Méthodes
	public void draw(){
		Main.processing.strokeWeight(1);
		Main.processing.stroke(0);
		Main.processing.fill(100,100,100,100);
		Main.processing.rectMode(PConstants.CORNER);
		Main.processing.rect(position.x, position.y, Main.processing.width-position.x, Main.processing.height-position.y);
	}

	public PVector getPosition() {
		return position;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
