package controllers.topup;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import controllers.submenu.QuanLyKhachHangController;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.KhachHang;
import views.ViewKhachHang;

public class TopupThemKhachHangController implements Initializable{

    @FXML
    private JFXTextField labelMaKhachHang;

    @FXML
    private JFXTextField textTenKhachHang;

    @FXML
    private JFXTextField textSDT;

    @FXML
    private JFXTextField textCMND;

    @FXML
    void handleThem(javafx.event.ActionEvent event) {
    	KhachHang khachHang = new KhachHang();
    	khachHang.setDiaChi(textCMND.getText());
    	khachHang.setCTHopDongList(null);
    	khachHang.setMaKhachHang(labelMaKhachHang.getText());
    	khachHang.setSdt(textSDT.getText());
    	khachHang.setTenKhachHang(textTenKhachHang.getText());
    	khachHang.setTrangThai("true");
    	QuanLyKhachHangController.setKhachHang(khachHang);
    	textCMND.getScene().getWindow().hide();
    }

    @FXML
    void handleThoat(javafx.event.ActionEvent event) {
    	textCMND.getScene().getWindow().hide();
    }
    private void initDefault() {
    	labelMaKhachHang.setText("KH" + new SimpleDateFormat("yyMMddHHmmssSSS").format(new Date()));
    }
   
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		initDefault();
		
	}

}
