package view;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import data.Persistence;
import stage.MainStage;
import stage.WelcomeStage;

public class WelcomeStageController {
	@FXML
	private Label WelPageTime;
	@FXML
	private TextField loginID;
	@FXML
	private PasswordField password;

	@FXML
	public void login() {
		// ���ļ��л�ȡ����Ա�˻��б�
		Persistence p = Persistence.getObjs();
		for (String key : p.getAccountMap().keySet()) {
			if (p.getAccountMap().get(key).getAccountName().equals(loginID.getText())
					&& p.getAccountMap().get(key).getAccountPassword().equals(password.getText()))
			WelcomeStage.getStage().close();
			MainStage.getStage(loginID.getText());
		}
		if (loginID.getText().equals("admin") && password.getText().equals("admin")) {
			WelcomeStage.getStage().close();
			MainStage.getStage(loginID.getText());
		}
	}

	public void initialize() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");// �������ڸ�ʽ
		WelPageTime.setText(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��

	}
}
