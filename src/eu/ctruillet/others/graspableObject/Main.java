/*
 * Copyright (c) 2020.
 * Clément Truillet (clement@ctruillet.eu)
 */

package eu.ctruillet.others.graspableObject;


import processing.core.PApplet;

public class Main extends PApplet {
	//Attributs
	public static PApplet processing;
	public GraspableObject graspableObject;
	public GraspableArea graspableArea;

	//Constructeur


	//Méthodes
	public static void main(String[] args) {
		PApplet.main("eu.ctruillet.others.graspableObject.Main",args);
	}

	public void settings(){
		size(1080, 640);
	}

	public void setup(){
		processing = this;
		surface.setTitle("Graspable Object");

		this.graspableObject = new GraspableObject();
		this.graspableArea = new GraspableArea();

		background(255);
	}

	public void draw(){
		background(255);
		//System.out.println("x=" + mouseX + " ;y=" + mouseY);

		this.graspableArea.draw();
		this.graspableObject.draw();

		if(this.graspableArea.isObjectOnArea(graspableObject)){
			this.graspableArea.drawGhostObject(graspableObject);
		}


//		stroke(0);
//		line(width/2,0,width/2,height);
//		line(0,height/2,width,height/2);

	}

	public void mousePressed(){
		if(mouseButton==LEFT){
			if(this.graspableObject.isGrasped()){
				this.graspableObject.beGrasp(true);
			}
		}else if(mouseButton == RIGHT){
			//Action
		}

	}

	public void mouseReleased(){
		this.graspableObject.beGrasp(false);

	}

	/*TODO
	* - Graspable Object
	*		- Move			- OK
	* 		- Action
	* - Graspable Area		- OK
	* - Tabletop
	* - Element
	*/
}