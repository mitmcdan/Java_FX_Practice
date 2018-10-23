package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import javafx.scene.control.RadioButton;

public class PlaceOrderController {
	@FXML
	private Label MainHeader;
	@FXML
	private Label NameLabel;
	@FXML
	private TextField NameField;
	@FXML
	private Label PleasureLabel;
	@FXML
	private RadioButton CappRadio;
	@FXML
	private ToggleGroup PleasureGroup;
	@FXML
	private RadioButton LatteRadio;
	@FXML
	private RadioButton MochaRadio;
	@FXML
	private RadioButton EspRadio;
	@FXML
	private Label SizeLabel;
	@FXML
	private RadioButton LargeRadio;
	@FXML
	private ToggleGroup SizeGroup;
	@FXML
	private RadioButton MediumRadio;
	@FXML
	private RadioButton SmallRadio;
	@FXML
	private Label CaffLabel;
	@FXML
	private RadioButton RegularRadio;
	@FXML
	private ToggleGroup CafGroup;
	@FXML
	private RadioButton DecafRadio;
	@FXML
	private Button ClearBtn;
	@FXML
	private Button PlaceOrderBtn;
	@FXML
	private Stage dialogStage;
	@FXML
	private OrderSummaryController dialogController;
	
	@FXML
	private void clearBtnClick(ActionEvent event) {
		System.out.println("Clear Button Clicked");
	}
	
	@FXML
	private void placeOrderBtnClicked(ActionEvent event) {
		System.out.println("Place Order Button Clicked");
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/OrderSummary.fxml"));
		AnchorPane dialogRoot;
		//make dialog
		if (dialogStage == null) {
			try {
				dialogRoot = (AnchorPane) loader.load();
				Scene dialogScene = new Scene(dialogRoot);
				dialogStage = new Stage();
				dialogStage.setScene(dialogScene);
				dialogController = (OrderSummaryController) loader.getController();
				dialogController.setCallingController(this);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//Show window
		dialogStage.show();
		System.out.println("After dialogStage.show()");
		
		//default values if none selected
		if (SizeGroup.getSelectedToggle() == null) {
			SmallRadio.setSelected(true);
		}
		if (PleasureGroup.getSelectedToggle() == null) {
			CappRadio.setSelected(true);
		}
		if (CafGroup.getSelectedToggle() == null) {
			RegularRadio.setSelected(true);
		}
		if (NameField.getText().isEmpty()) {
			NameField.setText("No Name");
		}
		
		//set name label in OrderSummaryController method
		dialogController.setOrdererNameLabel(NameField.getText());
		
		//set description label in OrderSummaryController
		//set size
		String size = "";
		if (SmallRadio.isSelected()) {
			size = "Small";
		} else if (MediumRadio.isSelected()) {
			size = "Medium";
		} else if (LargeRadio.isSelected()) {
			size = "Large";
		}
		
		//set tpye of drink
		String type = "";
		if (CappRadio.isSelected()) {
			type = "Cappucino";
		} else if (LatteRadio.isSelected()) {
			type = "Latte";
		} else if (EspRadio.isSelected()) {
			type = "Espresso";
		} else if (MochaRadio.isSelected()) {
			type = "Mocha";
		}
		
		//set defac or reg
		String caf = "";
		if (RegularRadio.isSelected()) {
			caf = "Regular";
		} else if (DecafRadio.isSelected()) {
			caf = "Decaf";
		}
		String s = size + " " + caf + " " + type;
				
		dialogController.setOrderDescriptionLabel(s);
	}
	@FXML
	public void ClearOrder() {
		//clear values out
		NameField.clear();
		CafGroup.selectToggle(null);
		SizeGroup.selectToggle(null);
		PleasureGroup.selectToggle(null);
	}
}
