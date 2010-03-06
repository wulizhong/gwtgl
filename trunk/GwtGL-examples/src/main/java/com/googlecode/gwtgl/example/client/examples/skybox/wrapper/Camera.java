package com.googlecode.gwtgl.example.client.examples.skybox.wrapper;

import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;

public class Camera implements MouseMoveHandler, MouseDownHandler, MouseUpHandler {

	int oldMouseX = 0;
	int oldMouseY = 0;
	boolean mouseDown = false;
	private int angleX;
	private int angleY;
	
	public int getRotationXAxis() {
		return angleX;
	}

	public int getRotationYAxis() {
		return angleY;
	}

	@Override
	public void onMouseMove(MouseMoveEvent event) {
		int mouseMoveX = event.getX()-oldMouseX;
		int mouseMoveY = event.getY()-oldMouseY;
		oldMouseX = event.getX();
		oldMouseY = event.getY();
		if(mouseDown){
			angleX += (mouseMoveY/10f) % 360;
			angleY += (mouseMoveX/10f) % 360;
		}
		
	}

	@Override
	public void onMouseDown(MouseDownEvent event) {
		mouseDown = true;
		
	}

	@Override
	public void onMouseUp(MouseUpEvent event) {
		mouseDown = false;
	}

}
