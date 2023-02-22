package application;
	

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class Calc extends Application {
	
	private Label myLabel;
	private Label tipLabel;
	private Label taxLabel;
	private Label totalLabel;
	public int i;
	public double j;
	public double tip1;
	public String tipS;
	

	public void start(Stage primaryStage) {
		
		try {
			
			myLabel = new Label("Meal charge: ");
			tipLabel = new Label();
			taxLabel = new Label();
			totalLabel = new Label();
			
			TextField textField = new TextField ();
			
			final ToggleGroup group = new ToggleGroup();
			RadioButton rb1 = new RadioButton();
			rb1.setToggleGroup(group);
			rb1.setText("15%");
			RadioButton rb2 = new RadioButton();
			rb2.setToggleGroup(group);
			rb2.setText("18%");
			RadioButton rb3 = new RadioButton();
			rb3.setToggleGroup(group);
			rb3.setText("20%");
			Button myButton = new Button("Calculate");
			
			myButton.setOnAction(new EventHandler<ActionEvent>() {

				    public void handle(ActionEvent e) {
				        if ((textField.getText() != null && !textField.getText().isEmpty())) {
				        	String amt = textField.getText();
				        	j = Integer.parseInt(amt);
				        	
				        	RadioButton rb = (RadioButton)group.getSelectedToggle();
			                if (rb != null) {
			                    String str = rb.getText();
			                    str = str.substring(0, str.length() - 1);
			                    // change the label
			                    i = Integer.parseInt(str);
			                    if (i == 15) {
			                    	double tip1 = .15;
			                    	double fin = tip1 * j;
	    				        	String finString = String.format("%.2f",fin);
	    				        	tipLabel.setText("Tip: " + finString);
	    				        	double taxfin = j * .07;
	    				        	String taxfinString = String.format("%.2f",taxfin);
	    				        	taxLabel.setText("Tax: " + taxfinString);
	    				        	double totalfin = j + taxfin + fin;
	    				        	String totalfinString = String.format("%.2f",totalfin);
	    				        	totalLabel.setText("Total: " + totalfinString);
			                    	
			                    }
			                    else if (i == 18) {
			                    	double tip1 = .18;
			                    	double fin = tip1 * j;
	    				        	String finString = String.format("%.2f",fin);
	    				        	tipLabel.setText("Tip: " + finString);
	    				        	double taxfin = j * .07;
	    				        	String taxfinString = String.format("%.2f",taxfin);
	    				        	taxLabel.setText("Tax: " + taxfinString);
	    				        	double totalfin = j + taxfin + fin;
	    				        	String totalfinString = String.format("%.2f",totalfin);
	    				        	totalLabel.setText("Total: " + totalfinString);
			                    	
			                    }
			                    else if (i == 20) {
			                    	double tip1 = .20;
			                    	double fin = tip1 * j;
	    				        	String finString = String.format("%.2f",fin);
	    				        	tipLabel.setText("Tip: " + finString);
	    				        	double taxfin = j * .07;
	    				        	String taxfinString = String.format("%.2f",taxfin);
	    				        	taxLabel.setText("Tax: " + taxfinString);
	    				        	double totalfin = j + taxfin + fin;
	    				        	String totalfinString = String.format("%.2f",totalfin);
	    				        	totalLabel.setText("Total: " + totalfinString);
			                    }
			                }
				        }        
				        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() 
				        {
				            public void changed(ObservableValue<? extends Toggle> ob, 
				                                                    Toggle o, Toggle n)
				            {
				                RadioButton rb = (RadioButton)group.getSelectedToggle();
				  
				                if (rb != null) {
				                    String str = rb.getText();
				                    str = str.substring(0, str.length() - 1);
				                    // change the label
				                    i = Integer.parseInt(str);
				                    if (i == 15) {
				                    	double tip1 = .15;
				                    	// tipLabel.setText("Tip: " + tipS);
				                    	if ((textField.getText() != null && !textField.getText().isEmpty())) {
			    				        	String amt = textField.getText();
			    				        	j = Integer.parseInt(amt);
			    				        	double fin = tip1 * j;
			    				        	String finString = String.format("%.2f",fin);
			    				        	tipLabel.setText("Tip: " + finString);
			    				        	double taxfin = j * .07;
			    				        	String taxfinString = String.format("%.2f",taxfin);
			    				        	taxLabel.setText("Tax: " + taxfinString);
			    				        	double totalfin = j + taxfin + fin;
			    				        	String totalfinString = String.format("%.2f",totalfin);
			    				        	totalLabel.setText("Total: " + totalfinString);
			    				        	}
				        				    
				                    }
				                    else if (i == 18) {
				                    	double tip1 = .18;
				                    	// tipLabel.setText("Tip: " + tipS);
				                    	if ((textField.getText() != null && !textField.getText().isEmpty())) {
			    				        	String amt = textField.getText();
			    				        	j = Integer.parseInt(amt);
			    				        	double fin = tip1 * j;
			    				        	String finString = String.format("%.2f",fin);
			    				        	tipLabel.setText("Tip: " + finString);
			    				        	double taxfin = j * .07;
			    				        	String taxfinString = String.format("%.2f",taxfin);
			    				        	taxLabel.setText("Tax: " + taxfinString);
			    				        	double totalfin = j + taxfin + fin;
			    				        	String totalfinString = String.format("%.2f",totalfin);
			    				        	totalLabel.setText("Total: " + totalfinString);
			    				        	}
				                    }
				                    else if (i == 20) {
				                    	double tip1 = .20;
				                    	// tipLabel.setText("Tip: " + tipS);
				                    	if ((textField.getText() != null && !textField.getText().isEmpty())) {
			    				        	String amt = textField.getText();
			    				        	j = Integer.parseInt(amt);
			    				        	double fin = tip1 * j;
			    				        	String finString = String.format("%.2f",fin);
			    				        	tipLabel.setText("Tip: " + finString);
			    				        	double taxfin = j * .07;
			    				        	String taxfinString = String.format("%.2f",taxfin);
			    				        	taxLabel.setText("Tax: " + taxfinString);
			    				        	double totalfin = j + taxfin + fin;
			    				        	String totalfinString = String.format("%.2f",totalfin);
			    				        	totalLabel.setText("Total: " + totalfinString);
			    				        	}
				                    }
				                }
				            }
				        });
				     }
				 });
			
			HBox hbox = new HBox(10, myLabel, textField);
			HBox hbox2 = new HBox(5, rb1, rb2, rb3);
			VBox vbox1 = new VBox(10, tipLabel, taxLabel, totalLabel);
			VBox vbox = new VBox(10, hbox, hbox2, vbox1, myButton);
			vbox.setAlignment(Pos.CENTER);
			
			Scene scene = new Scene(vbox,300,200);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

/* NOTES:
 * https://docs.oracle.com/javafx/2/ui_controls/text-field.htm
 * https://www.geeksforgeeks.org/javafx-button-with-examples/
 * https://www.geeksforgeeks.org/javafx-textfield/
 * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TextField.html
 */