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
	private PVector ghostPosition;
	private PVector gapMouseCenter = new PVector(0,0);
	private float lenght = 50;
	private Color color = new Color(200,0,0);
	private boolean isGrasp = false;
	private Element element = null;


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
		Main.processing.square(this.position.x,this.position.y,this.lenght);

		if(this.element!=null){
			Main.processing.fill(new Color(10, 200, 10, 196).getRGB());
			Main.processing.rect(this.position.x-7, this.position.y-7,(int)(3*this.lenght/7), (int)(4*this.lenght/7));
		}

		if(isGrasp){
			this.position=PVector.add(mouse,gapMouseCenter);
		}


	}

	public void drawGhostPosition(GraspableArea area){
		if(ghostPosition.x < area.getPosition().x || ghostPosition.y < area.getPosition().y){
			Main.processing.noFill();
			Main.processing.strokeWeight(2);
			Main.processing.stroke(200,0,0);
			Main.processing.circle(ghostPosition.x, ghostPosition.y,10);
		}
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


	public void computeNewGhostPosition(GraspableArea area){
		this.ghostPosition = new PVector(
				(this.position.x - area.getPosition().x)/(area.getWidth())  * Main.processing.width,
				(this.position.y - area.getPosition().y)/(area.getHeight())  * Main.processing.height
				);
	}

	public boolean isOnArea(GraspableArea area){
		return (this.position.x >= area.getPosition().x && this.position.y >= this.position.y);
	}


	public Element getElement() {
		return element;
	}

	public boolean isOnElement(Element element){
		return (element.getPosition().x <= position.x &&
				element.getPosition().x + element.getWidth() > position.x &&
				element.getPosition().y <= position.y &&
				element.getPosition().y + element.getHeight() > position.y);
	}

	public boolean isGhostOnElement(GraspableArea area, Element element){
		return (this.isOnArea(area) && (
				element.getPosition().x <= ghostPosition.x &&
				element.getPosition().x + element.getWidth() > ghostPosition.x &&
				element.getPosition().y <= ghostPosition.y &&
				element.getPosition().y + element.getHeight() > ghostPosition.y)
		);
	}

	public void graspElement(GraspableArea area, Element element){
		if(this.element==null){
			if(this.isOnArea(area)){
				element.grasp(this.ghostPosition);
			}else{
				element.grasp(this.position);
			}
			this.element = element;

		}

	}

	public void dropElement(GraspableArea area){
		if(this.element!=null){
			if(this.isOnArea(area)){
				element.drop(this.ghostPosition);
			}else {
				element.drop(this.position);
			}
			this.element = null;
		}
	}

	public boolean isMouseOnObject(int mouseX, int mouseY){
		return (mouseX >= this.position.x - this.lenght/2 &&
				mouseX < this.position.x + this.lenght/2 &&
				mouseY >= this.position.y - this.lenght/2 &&
				mouseY < this.position.y + this.lenght/2
		);
	}
}
