package controllers.topup;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import controllers.submenu.HoaDonPhongController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import model.DichVu;
import service.DichVuService;
import views.DichVuView;
import views.ViewTimKhachHang;

public class TopupThemPhiController implements Initializable{

    @FXML
    private ComboBox<String> comboboxLooaiPhi;

    @FXML
    private JFXTextField textMaLoaiPhi;

    @FXML
    private JFXTextField textTenLoaiPhi;

    @FXML
    private JFXTextField textSooLuong;
    
    @FXML
    private JFXTextField textGiaTien;

    @FXML
    private JFXTextField textDonViTinh;

    @FXML
    private JFXTextField textThanhTien;
    private ObservableList<String> listPhi = FXCollections.observableArrayList();
    @FXML
    void handleThem(ActionEvent event) {
    	DichVuView view = new DichVuView();
    	view.setDonGia(textGiaTien.getText());
    	view.setDonViTinh(textDonViTinh.getText());
    	view.setMaDichVu(textMaLoaiPhi.getText());
    	view.setSoluong(textSooLuong.getText());
    	view.setTenDichVu(textTenLoaiPhi.getText());
    	view.setThanhTien(textThanhTien.getText());
    	TopupThemHoaDonController.setDichVuView(view);
    	textThanhTien.getScene().getWindow().hide();

    }
    private void initDefault() {
    	textSooLuong.setText("0");
    	textThanhTien.setText("0");
    	textGiaTien.setText("0");
    	listPhi.addAll(DichVuService.getListNameDichVu());
    	comboboxLooaiPhi.setItems(listPhi);
    	comboboxLooaiPhi.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
			DichVu dichVu = DichVuService.finDichVubyName(newValue);
			textDonViTinh.setText(dichVu.getDonViTinh());
			textMaLoaiPhi.setText(dichVu.getMaDichVu());
			textGiaTien.setText(dichVu.getDonGia());
			textTenLoaiPhi.setText(dichVu.getTenDichVu());
			textSooLuong.setText("0");
	    	textThanhTien.setText("0");

		});
    	
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		initDefault();
		
		textSooLuong.setOnKeyReleased(e -> {
			try {
				textThanhTien.setText(String.valueOf(Long.parseLong(textSooLuong.getText()) * Long.parseLong(textGiaTien.getText())));
			}catch (Exception ex) {
				textThanhTien.setText("0");
				textSooLuong.setText("0");
			}
				
		});
		
	}

}
