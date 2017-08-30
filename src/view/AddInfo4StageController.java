/**
 * 
 */
package view;

import java.text.SimpleDateFormat;
import java.util.Date;

import data.Record;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import stage.AddInfo4Stage;

/**
 * @author dell
 *
 */
public class AddInfo4StageController {

	@FXML
	private Label personID;
	@FXML
	private Label personName;
	@FXML
	private Label hospitalID;
	@FXML
	private Label hospitalLevel;
	@FXML
	private Label money;
	@FXML
	private Label year;
	@FXML
	private Label month;
	@FXML
	private Label day;
	@FXML
	private TextArea info;

	private String ID;
	private String name;
	private Record record = new Record();

	public void setMain(String ID, String name, Record record) {
		this.ID = ID;
		this.name = name;
		this.record = record;
		initialize();
	}

	public void initialize() {
		personID.setText(ID);
		personName.setText(name);
		hospitalID.setText(record.getTreatmentInfo().getHospitalID());
		hospitalLevel.setText(record.getTreatmentInfo().getHospitalLevel());
		money.setText(String.valueOf(record.getRecipe().getMoney()));
		for (int i = 0; i < record.getRecipe().getItems().size(); i++) {
			info.appendText("��ĿID" + record.getRecipe().getItems().get(i).getID() + "\n" + "��Ŀ����"
					+ record.getRecipe().getItems().get(i).getName() + "\n" + "��Ŀ����"
					+ record.getRecipe().getItems().get(i).getPrice() + "\n" + "��Ŀ����"
					+ record.getRecipe().getItems().get(i).getNum() + "\n");
		}
		SimpleDateFormat years = new SimpleDateFormat("yyyy");// �������ڸ�ʽ
		SimpleDateFormat months = new SimpleDateFormat("mm");
		SimpleDateFormat days = new SimpleDateFormat("dd");
		year.setText(years.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
		month.setText(months.format(new Date()));
		day.setText(days.format(new Date()));
	}

	public void print() {
		
	}

	public void exit() {
		AddInfo4Stage.getStage(ID, name, record).close();
	}
}
