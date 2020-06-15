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

	//Constructeur
	public GraspableArea(){
		this.position = new PVector(3*Main.processing.width/4,3*Main.processing.height/4);
	}


	//Méthodes
	public void draw(){
		Main.processing.strokeWeight(1);
		Main.processing.stroke(0);
		Main.processing.fill(100,100,100,100);
		Main.processing.rectMode(PConstants.CORNER);
		Main.processing.rect(position.x, position.y, Main.processing.width-position.x, Main.processing.height-position.y);
	}

	public boolean isObjectOnArea(GraspableObject graspableObject){
		return (this.position.x <= graspableObject.getPosition().x && this.position.y <= graspableObject.getPosition().y);
	}

	public void drawGhostObject(GraspableObject graspableObject){
		PVector positionInArea = PVector.sub(graspableObject.getPosition(), this.position);

		PVector ghostPosition = new PVector((positionInArea.x)*4, (positionInArea.y)*4);

		if(ghostPosition.x<position.x || ghostPosition.y < position.y){
			Main.processing.noFill();
			Main.processing.strokeWeight(2);
			Main.processing.stroke(200,0,0);
			Main.processing.circle(ghostPosition.x, ghostPosition.y,10);
		}

	}


}
