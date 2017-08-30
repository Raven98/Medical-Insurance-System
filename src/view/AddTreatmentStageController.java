/**
 * 
 */package view;

import data.Persistence;
import data.Treatment;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import stage.AddTreatmentStage;


public class AddTreatmentStageController {
	@FXML
	private TextField ID;
	@FXML
	private TextField name;
	@FXML
	private ChoiceBox<String> chargeClass;
	@FXML
	private ChoiceBox<String> chargeItemLevel;
	@FXML
	private ChoiceBox<String> hospitalLevel;
	@FXML
	private ChoiceBox<String> approveMark;
	@FXML
	private TextField unit;
	@FXML
	private TextField manufacturer;
	@FXML
	private TextField remark;
	@FXML
	private TextField restrictedScope;
	public void initialize() {
		chargeClass.setItems(FXCollections.observableArrayList("��λ��","�໤��λ��"));
		chargeItemLevel.setItems(FXCollections.observableArrayList("����","����","����"));
		approveMark.setItems(FXCollections.observableArrayList("��","��"));
		hospitalLevel.setItems(FXCollections.observableArrayList("һ��ҽԺ","����ҽԺ","����ҽԺ","����ҽԺ","����ҽԺ"));
		}
	public void saveTreatment() throws Exception{
		Treatment temp= new Treatment(ID.getText(), name.getText(), chargeClass.getValue(), chargeItemLevel.getValue(),
				hospitalLevel.getValue(), approveMark.getValue(), unit.getText(), manufacturer.getText(), remark.getText(),
				restrictedScope.getText());
		Persistence p = Persistence.getObjs();
		p.saveTreatment(ID.getText(), temp);
		Persistence.saveToFile();
		AddTreatmentStage.getStage().close();
	}
	
}
