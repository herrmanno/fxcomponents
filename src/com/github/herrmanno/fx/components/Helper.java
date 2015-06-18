package com.github.herrmanno.fx.components;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class Helper {

	public static void load(Parent node) {
		URL fxmlRes = node.getClass().getResource(node.getClass().getSimpleName()+".fxml");
		FXMLLoader loader = new FXMLLoader(fxmlRes);
		loader.setRoot(node);
		loader.setController(node);
		
		URL cssRes = node.getClass().getResource(node.getClass().getSimpleName()+".css");
		if(cssRes != null) node.getStylesheets().add(cssRes.toExternalForm());
		
		try {
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
