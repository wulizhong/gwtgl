package com.googlecode.gwtgl.example.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.googlecode.gwtgl.example.client.examples.coloredtriangle.wrapper.ColoredTriangleWrapperExample;
import com.googlecode.gwtgl.example.client.examples.lighting.wrapper.LightingWrapperExample;
import com.googlecode.gwtgl.example.client.examples.skybox.wrapper.SkyboxWrapperExample;
import com.googlecode.gwtgl.example.client.examples.texturedcube.wrapper.TexturedCubeWrapperExample;
import com.googlecode.gwtgl.example.client.examples.texturedsphere.wrapper.TexturedSphereWrapperExample;
import com.googlecode.gwtgl.example.client.examples.whitetriangle.WhiteTriangleExample;
import com.googlecode.gwtgl.example.client.examples.whitetriangle.wrapper.WhiteTriangleWrapperExample;

/**
 * @author Steffen Schäfer
 * @author Sönke Sothmann
 * 
 */
public class GwtGL_examples implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		try{
			TabPanel tp = new TabPanel();
	
			WhiteTriangleExample whiteTriangleExample = new WhiteTriangleExample();
			tp.add(whiteTriangleExample, "White Triangle (Binding)");
	
			WhiteTriangleWrapperExample whiteTriangleWrapperExample = new WhiteTriangleWrapperExample();
			tp.add(whiteTriangleWrapperExample, "White Triangle (Wrapper)");
	
			ColoredTriangleWrapperExample coloredTriangleWrapperExample = new ColoredTriangleWrapperExample();
			tp.add(coloredTriangleWrapperExample, "Colored Triangle (Wrapper)");
	
			TexturedCubeWrapperExample texturedCubeWrapperExample = new TexturedCubeWrapperExample();
			tp.add(texturedCubeWrapperExample, "Textured Cube (Wrapper)");
			
			TexturedSphereWrapperExample texturedSphereWrapperExample = new TexturedSphereWrapperExample();
			tp.add(texturedSphereWrapperExample, "Textured Sphere (Wrapper)");
	
			LightingWrapperExample lightingWrapperExample = new LightingWrapperExample();
			tp.add(lightingWrapperExample, "Lighting (Wrapper)");
			
			SkyboxWrapperExample skyboxWrapperExample = new SkyboxWrapperExample();
			tp.add(skyboxWrapperExample, "Skybox (Wrapper)");
	
			tp.selectTab(3);
			RootPanel.get("gwtgl-examples").add(tp);
		} catch (Exception e) {
			Window.alert("Sorry, Your Browser doesn't support WebGL!");
		}
	}
}
