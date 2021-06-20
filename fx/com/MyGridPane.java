package fx.com;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class MyGridPane extends GridPane {
	
	public MyGridPane(Stage stage) {
		
		MyButton copyButton = new MyButton("复  制");
		MyButton converButton = new MyButton("转  换");
		MyButton exitButton = new MyButton("退  出");
		MyButton clearButton = new MyButton("清  空");
		
		TextField tf = new TextField();
		tf.setPrefHeight(28.0);
		tf.setPrefWidth(360.0);
		tf.setStyle("-fx-background-radius: 5");
		
		Text text = new Text("");
		
		TextFlow tfw = new TextFlow();
		tfw.setStyle("-fx-background-color: #fff;-fx-background-radius: 5");
		tfw.setPrefHeight(100.0);
		tfw.setMaxWidth(360.0);
		tfw.setPadding(new Insets(5));
		tfw.setStyle("-fx-background-color: #FDF5E6");
		tfw.getChildren().add(text);
		
		Border border = new Border(new BorderStroke(Paint.valueOf("blue"), BorderStrokeStyle.SOLID, new CornerRadii(5.0), BorderWidths.DEFAULT));
		tfw.setBorder(border);
		
		ChoiceBox<String> cbox = new ChoiceBox<>();
		cbox.getItems().addAll("192.168.31.110", "127.0.0.1", "192.168.1.106");
		cbox.getSelectionModel().select(0);
		GridPane.setMargin(cbox, new Insets(0, 0, 0, 5));
		
		Clipboard clip = Clipboard.getSystemClipboard();
		
		ClipboardContent content = new ClipboardContent();
		
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.CENTER_LEFT);
		vbox.setSpacing(10.0);
		vbox.setPadding(new Insets(10));
		
		vbox.getChildren().addAll(copyButton, clearButton);
		
		HBox hbox = new HBox();
		hbox.setAlignment(Pos.CENTER_LEFT);
		hbox.setSpacing(220.0);
		
		hbox.getChildren().addAll(converButton, exitButton);

		
		
		this.setStyle("-fx-background-color: #FFFAF0");
		
		GridPane.setMargin(tfw, new Insets(5, 0, 5, 0));
		
		this.add(tf, 0, 0);
		this.add(cbox, 1, 0);
		this.add(tfw, 0, 1);
		this.add(vbox, 1, 1);
		this.add(hbox, 0, 2);
		
		this.setAlignment(Pos.CENTER);
		
		
		//事件
		copyButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				Text outputText = (Text)tfw.getChildren().get(0);
				
				if(!outputText.getText().equals("")) {
					
					content.put(DataFormat.PLAIN_TEXT, outputText.getText());
					clip.setContent(content);
					
				}			
				
			}
		});
		
		converButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				if(tf.getText().equals("")) {
					Text text = (Text)tfw.getChildren().get(0);
					text.setText("The input is empty, please reenter it.");
				}
				else {
					new Trans(tf, tfw, cbox);
				}

			}
		});
		
		exitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				stage.close();
			}
		});
		
		clearButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				tf.setText("");
				Text text = (Text)tfw.getChildren().get(0);
				text.setText("");
			}
		});
		
		
		tf.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				
				if(event.getCode().equals(KeyCode.ENTER)) {
					converButton.fire();
				}
				
			}
		});
		
		
	}
}

class MyButton extends Button{
	
	public MyButton(String text) {
		this.setText(text);
		this.setFont(Font.font(13));
		this.setPrefWidth(70);
		
	}
	
}
