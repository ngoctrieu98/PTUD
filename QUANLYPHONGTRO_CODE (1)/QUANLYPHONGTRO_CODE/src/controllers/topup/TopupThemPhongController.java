package controllers.topup;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.Phong;
import service.PhongService;
import utils.ThongBao;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

import javafx.scene.control.TextArea;

public class TopupThemPhongController implements Initializable{
	@FXML
	private TextField textGiaPhong;
	@FXML
	private TextField textMaPhong;
	@FXML
	private TextArea textGhiChu;

	// Event Listener on JFXButton.onAction
	@FXML
	public void handleThoat(ActionEvent event) {
		// TODO Autogenerated
		textGiaPhong.getScene().getWindow().hide();
	}
	// Event Listener on JFXButton.onAction
	@FXML
	public void handleThem(ActionEvent event) {
		// TODO Autogenerated
		Phong phong = new Phong();
		phong.setGiaPhong(textGiaPhong.getText());
		phong.setMaPhong(textMaPhong.getText());
		phong.setTrangThai("true");
		phong.setTrangThaiPhong("TRONG");
		Phong phongDB = PhongService.findPhongById(textMaPhong.getText());
		if(phongDB == null) {
			PhongService.savePhong(phong);
			textGiaPhong.getScene().getWindow().hide();
		}else {
			ThongBao.thongBaoLoi("Ma phong đã tồn tại trong hệ thống");
		}
		
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
