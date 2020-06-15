/*
 * Copyright (c) 2020.
 * Clément Truillet (clement@ctruillet.eu)
 */

package eu.ctruillet.others.graspableObject;

import processing.core.PConstants;
import processing.core.PVector;

import java.awt.*;

public class GraspableObject {
	//Attributs
	private PVector position;
	private PVector gapMouseCenter = new PVector(0,0);
	private float lenght = 50;
	private Color color = new Color(200,0,0);
	private boolean isGrasp = false;



	//Constructeur
	public GraspableObject(){
		this.position = new PVector(Main.processing.width/2, Main.processing.height/2);
	}


	//Méthodes
	public void draw(){
		PVector mouse = new PVector(Main.processing.mouseX, Main.processing.mouseY);

		Main.processing.noStroke();
		Main.processing.fill(this.color.getRGB());
		Main.processing.rectMode(PConstants.CENTER);

		if(isGrasp){
			this.position=PVector.add(mouse,gapMouseCenter);
		}
		Main.processing.square(this.position.x,this.position.y,this.lenght);
	}

	public void beGrasp(boolean beGrasp){
		if(beGrasp){
			PVector mouse = new PVector(Main.processing.mouseX, Main.processing.mouseY);
			this.gapMouseCenter = PVector.sub(position, mouse);
			Main.processing.cursor(Main.processing.HAND);
			this.lenght = 54;

		}else{
			this.isGrasp=false;
			this.lenght = 50;
			Main.processing.cursor(Main.processing.ARROW);

		}

	}

	public boolean isGrasped(){
		int mouseX = Main.processing.mouseX;
		int mouseY = Main.processing.mouseY;

		if( mouseX >= this.position.x - this.lenght/2 && mouseX < this.position.x + this.lenght/2 &&
			mouseY >= this.position.y - this.lenght/2 && mouseY < this.position.y + this.lenght/2){

			this.isGrasp = true;
		}

		return this.isGrasp;
	}

	public PVector getPosition() {
		return position;
	}
}
