/*
 * Copyright (c) 2020.
 * Clément Truillet (clement@ctruillet.eu)
 */

package eu.ctruillet.others.graspableObject;

import processing.core.PConstants;
import processing.core.PVector;

import java.awt.*;

public class Element {
	//Attributs
	private PVector position;
	private PVector gapCursorCenter = new PVector(0,0);
	private int width;
	private int height;
	private boolean isGrasp = false;

	//Constructeur
	public Element(int x, int y, int width, int height){
		this.position = new PVector(x,y);
		this.width=width;
		this.height=height;
	}


	//Méthodes
	public void draw(){
		if(!isGrasp){
			Main.processing.noStroke();
			Main.processing.fill(new Color(10,200,10).getRGB());
			Main.processing.rectMode(PConstants.CORNER);
			Main.processing.rect(this.position.x, this.position.y, this.width, this.height);
		}
	}

	public PVector getPosition() {
		return position;
	}

	public PVector getGapCursorCenter() {
		return gapCursorCenter;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public boolean isGrasp() {
		return isGrasp;
	}

	public void grasp(PVector objectPosition){
		this.gapCursorCenter = PVector.sub(this.position,objectPosition);
		this.isGrasp=true;
	}

	public void drop(PVector objectPosition){
		this.position = PVector.add(this.gapCursorCenter,objectPosition);
		this.isGrasp=false;
	}
}
