package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class OrderSummaryController {
	@FXML
	private Button OrderCancelBtn;
	@FXML
	private Button OrderConfirmBtn;
	@FXML
	public Label OrdererNameLabel;
	@FXML
	public Label OrderDescriptionLabel;
	@FXML
	private AnchorPane summaryPane;
	@FXML
	private PlaceOrderController callingPageController; 
	//get controller
	public void setCallingController(PlaceOrderController c) {
		callingPageController = c;
	}
	
	//Set Name Label
	@FXML
	public void setOrdererNameLabel(String s) {
		OrdererNameLabel.setText(s);
	}
	
	//Set Order Label
	@FXML
	public void setOrderDescriptionLabel(String s) {
		OrderDescriptionLabel.setText(s);
	}
	
	@FXML
	public void OrderCancelBtnClick(ActionEvent event) {
		System.out.println("Order Cancel Button Clicked");
		//hide window
		summaryPane.getScene().getWindow().hide();
	}
	//Button handlers
	@FXML
	public void OrderConfirmBtnClick(ActionEvent event) {
		System.out.println("Order Confirm Button Clicked");
		//The instructions were not clear on which methods should clear out data
		callingPageController.ClearOrder();
		//hide window
		summaryPane.getScene().getWindow().hide();
	}
}
