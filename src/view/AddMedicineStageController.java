/**
 * 
 */package view;

import data.Medicine;
import data.Persistence;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import stage.AddMedicineStage;

/**
 * @author dell
 *
 */
public class AddMedicineStageController {
	@FXML
	private TextField Name;
	@FXML
	private TextField ID;
	@FXML
	private TextField EngName;
	@FXML
	private ChoiceBox<String> chargeClass;
	@FXML
	private ChoiceBox<String> prescriptionMedicineMark;
	public void initialize() {
	prescriptionMedicineMark.setItems(FXCollections.observableArrayList("��","��"));
	chargeClass.setItems(FXCollections.observableArrayList("��ҩ","�г�ҩ","�в�ҩ"));
	chargeItemLevel.setItems(FXCollections.observableArrayList("����","����","����"));
	hospitalPreparationMark.setItems(FXCollections.observableArrayList("��","��"));
	approveMark.setItems(FXCollections.observableArrayList("��","��"));
	hospitalLevel.setItems(FXCollections.observableArrayList("һ��ҽԺ","����ҽԺ","����ҽԺ","����ҽԺ","����ҽԺ"));
	}
	@FXML
	private ChoiceBox<String> chargeItemLevel;
	@FXML
	private TextField dosageUnit;
	@FXML
	private TextField ceilingPrice;
	@FXML
	private ChoiceBox<String> hospitalLevel;
	@FXML
	private ChoiceBox<String> hospitalPreparationMark;
	@FXML
	private ChoiceBox<String> approveMark;
	@FXML
	private TextField form;
	@FXML
	private TextField usageFrequency;
	@FXML
	private TextField usageMethod;
	@FXML
	private TextField unit;
	@FXML
	private TextField specification;
	@FXML
	private TextField limitNumberofDays;
	@FXML
	private TextField tradeName;
	@FXML
	private TextField factoryName;
	@FXML
	private TextField SFDA;
	@FXML
	private TextField remark;
	@FXML
	private TextField NCC;
	@FXML
	private TextField restrictedScope;
	@FXML
	private TextField productionPlace;
	public void saveMedicine() throws Exception {
		Medicine temp=new Medicine(ID.getText(),Name.getText(),EngName.getText(),chargeClass.getValue(),
				prescriptionMedicineMark.getValue(),chargeItemLevel.getValue(),dosageUnit.getText(),ceilingPrice.getText(),
				hospitalPreparationMark.getValue(),approveMark.getValue(),hospitalLevel.getValue(),form.getText(),usageFrequency.getText(),
				usageMethod.getText(),unit.getText(),specification.getText(),limitNumberofDays.getText(),
				tradeName.getText(),factoryName.getText(),SFDA.getText(),remark.getText(),NCC.getText(),
				restrictedScope.getText(),productionPlace.getText());
		Persistence p = Persistence.getObjs();
		p.saveMedicine(ID.getText(), temp);
		Persistence.saveToFile();
		AddMedicineStage.getStage().close();
	}
}
