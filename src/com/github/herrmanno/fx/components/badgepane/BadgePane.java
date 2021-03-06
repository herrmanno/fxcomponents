package com.github.herrmanno.fx.components.badgepane;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import com.github.herrmanno.fx.components.Helper;

public class BadgePane extends AnchorPane {

	private long delay = 2000;
	
	@FXML private Label badge;
	
	public BadgePane() {
		Helper.load(this);
	}

	public Label getBadge() {
		return badge;
	}
	
	public void showBadge(String text) {
		badge.setText(text);
		show(e -> hide(null));
	}
	
	protected void show(EventHandler<ActionEvent> onfinished) {
		TranslateTransition tt = new TranslateTransition(Duration.millis(500));
		tt.setToY(-80);
		
		FadeTransition ft = new FadeTransition(Duration.millis(200));
		ft.setFromValue(0);
		ft.setToValue(0.8);
		ft.setDelay(Duration.millis(300));
		
		ParallelTransition pt = new ParallelTransition(badge, tt, ft);
		pt.setOnFinished(onfinished);
		
		pt.play();
	}
	
	protected void hide(EventHandler<ActionEvent> onfinished) {
		TranslateTransition tt = new TranslateTransition(Duration.millis(500));
		tt.setToY(50);
		
		FadeTransition ft = new FadeTransition(Duration.millis(200));
		ft.setToValue(0);
		
		ParallelTransition pt = new ParallelTransition(badge, tt, ft);
		pt.setOnFinished(onfinished);
		pt.setDelay(Duration.millis(delay));
		
		pt.play();
	}

}
