package com.internshala.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.Optional;

public class MyMain extends Application {
public static void main(String[] args){
	System.out.println("main");
launch(args);
}

	@Override
	public void init() throws Exception {
		System.out.println("init");
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("Start");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();
		//MenuBar menuBar = createMenu();
		//rootNode.getChildren().add(0,menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Convertor Tool");
		primaryStage.show();
	}
	private MenuBar createMenu(){
	    // File Menu
		Menu filemenu = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");
		newMenuItem.setOnAction(event -> System.out.println("New  menu Item  CLicked"));
		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem quitMenuItem = new MenuItem("Quit");
		quitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});
		filemenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);
		// Help Menu
		Menu Helpmenu = new Menu("Help");
		MenuItem aboutMenuItem = new MenuItem("About");
		Helpmenu.getItems().addAll(aboutMenuItem);
		aboutMenuItem.setOnAction(event -> aboutMenuItem());
		// Menu Bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(filemenu,Helpmenu);
		return menuBar;
	}

	private void aboutMenuItem() {
		Alert alertdailog =  new Alert(Alert.AlertType.INFORMATION);
		alertdailog.setTitle("My First Desktop App");
		alertdailog.setHeaderText("Learning JavaFx");
		alertdailog.setContentText("I m just a beginner but soon I will be Pro and start developing awesome Java Games");

		ButtonType yesbtn = new ButtonType("Yes");
		ButtonType nobtn =  new ButtonType("No");
		alertdailog.getButtonTypes().setAll(yesbtn,nobtn);
		Optional<ButtonType> clickedbtn =  alertdailog.showAndWait();
		if(clickedbtn.isPresent()&&clickedbtn.get()==yesbtn){
			System.out.println("Yes btn is clicked");
		}
		else{
			System.out.println("No btn is clicked");
		}
}

	@Override
	public void stop() throws Exception {
		System.out.println("Stop");
		super.stop();
	}
}
