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
	public Element element;
	//Constructeur


	//Méthodes
	public static void main(String[] args) {
		PApplet.main("eu.ctruillet.others.graspableObject.Main",args);
	}

	public void settings(){
		fullScreen();
		//size(1080, 640);
	}

	public void setup(){
		processing = this;
		surface.setTitle("Graspable Object");

		this.graspableObject = new GraspableObject();
		this.graspableArea = new GraspableArea();
		this.element = new Element(100,10,250,350);

		background(255);
	}

	public void draw(){
		background(255);
		//System.out.println("x=" + mouseX + " ;y=" + mouseY);
		this.element.draw();

		this.graspableArea.draw();
		this.graspableObject.draw();

		if(this.graspableObject.isOnArea(graspableArea)){
			this.graspableObject.computeNewGhostPosition(graspableArea);
			this.graspableObject.drawGhostPosition(graspableArea);
		}
	}

	public void mousePressed(){
		if(mouseButton==LEFT){
			if(this.graspableObject.isGrasped()){
				this.graspableObject.beGrasp(true);
			}
		}else if(mouseButton == RIGHT){
			if(this.graspableObject.isMouseOnObject(mouseX,mouseY)) {
				if (this.graspableObject.getElement() == null) {
					if (this.graspableObject.isOnElement(element) || this.graspableObject.isGhostOnElement(graspableArea, element)) {

						//Attraper l'element
						this.graspableObject.graspElement(graspableArea, element);

					}
				}else {

					//Lacher l'element
					this.graspableObject.dropElement(graspableArea);

				}
			}


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