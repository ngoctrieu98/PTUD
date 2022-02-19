package controllers.topup;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.CTDichVu;
import model.CTDichVuPK;
import model.DichVu;
import model.HoaDon;
import model.KhachHang;
import model.NhanVien;
import model.Phong;
import service.ChiTietDichVuService;
import service.DichVuService;
import service.HoaDonService;
import service.KhachHangSerivce;
import service.NhanVienService;
import service.PhongService;
import views.DichVuView;
import views.HoaDonView;

public class TopupThemHoaDonController implements Initializable {
	
    @FXML
    private TableView<DichVuView> tablePhi;

    @FXML
    private TableColumn<DichVuView, String> colMaPhi;

    @FXML
    private TableColumn<DichVuView, String> colTenPhi;

    @FXML
    private TableColumn<DichVuView, String> colDonGia;

    @FXML
    private TableColumn<DichVuView, String> colSoLuong;

    @FXML
    private TableColumn<DichVuView, String> colDonViTinh;

    @FXML
    private TableColumn<DichVuView, String> colThanhTien;

    @FXML
    private TableColumn<DichVuView, Button> colXoa;

    @FXML
    private Label lableMaKhachHang;

    @FXML
    private JFXTextField textTenKhachHang;

    @FXML
    private JFXTextField textSoDienThoai;

    @FXML
    private JFXTextField textCmnd;

    @FXML
    private JFXTextField textGiaPhong;

    @FXML
    private ComboBox<String> comboboxMaPhong;

    private ObservableList<String> listPhong = FXCollections.observableArrayList();
    
    private ObservableList<DichVuView> listDV = FXCollections.observableArrayList();
    
    public static KhachHang khachHang;
    
    public static DichVuView dichVuView;
    
    public static NhanVien nhanVien;
    
    
	

	@FXML
    void handelThem(ActionEvent event) {
		Stage stageDatPhong = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/application/topup/TopupThemPhi.fxml"));
			Scene scene = new Scene(root);
			stageDatPhong.setScene(scene);
			stageDatPhong.initModality(Modality.APPLICATION_MODAL);
			stageDatPhong.setFullScreen(false);
			stageDatPhong.setResizable(false);
			stageDatPhong.centerOnScreen();
			stageDatPhong.showAndWait();
			if(dichVuView != null) {
				Button btnXoa = new Button("X�a");
				dichVuView.setBtnXoa(btnXoa);
				listDV.add(dichVuView);
				handleXoa(btnXoa, dichVuView);
				loadTable();
				dichVuView = null;
			}
				
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
    }
	private void handleXoa(Button btn, DichVuView value) {
		btn.setOnAction(events -> {
			listDV.remove(value);
		});
	}

    @FXML
    void handelTim(ActionEvent event) {
    	Stage stageDatPhong = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/application/topup/TopupTimKhachHang.fxml"));
			Scene scene = new Scene(root);
			stageDatPhong.setScene(scene);
			stageDatPhong.initModality(Modality.APPLICATION_MODAL);
			stageDatPhong.setFullScreen(false);
			stageDatPhong.setResizable(false);
			stageDatPhong.centerOnScreen();
			stageDatPhong.showAndWait();
			initKhachHang();
			this.khachHang = null;
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
    }

    @FXML
    void handleThoat(ActionEvent event) {

    }
    private void initKhachHang() {
    	if(khachHang != null) {
    		lableMaKhachHang.setText(khachHang.getMaKhachHang());
    		textCmnd.setText(khachHang.getDiaChi());
    		textSoDienThoai.setText(khachHang.getSdt());
    		textTenKhachHang.setText(khachHang.getTenKhachHang());
    	}
    }
    private void initDefault() {
    	listPhong.addAll(PhongService.getListMaPhongDangO());
    	comboboxMaPhong.setItems(listPhong);
    }
    private void handelComboBox() {
    	comboboxMaPhong.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
			textGiaPhong.setText(PhongService.findPhongById(newValue).getGiaPhong());

		});
	}
    private void loadTable() {
    	 colDonGia.setCellValueFactory(new PropertyValueFactory<>("donGia"));
         colDonViTinh.setCellValueFactory(new PropertyValueFactory<>("donViTinh"));
         colMaPhi.setCellValueFactory(new PropertyValueFactory<>("maDichVu"));
         colTenPhi.setCellValueFactory(new PropertyValueFactory<>("tenDichVu"));
         colThanhTien.setCellValueFactory(new PropertyValueFactory<>("thanhTien"));
         colSoLuong.setCellValueFactory(new PropertyValueFactory<>("soluong"));
         colXoa.setCellValueFactory(new PropertyValueFactory<>("btnXoa"));
         tablePhi.setItems(listDV);
    	
    }
    public static void setKhachHang(KhachHang khachHang) {
		TopupThemHoaDonController.khachHang = khachHang;
	}

	public static void setDichVuView(DichVuView dichVuView) {
		TopupThemHoaDonController.dichVuView = dichVuView;
	}
	public static void setNhanVien(NhanVien nhanVien) {
		TopupThemHoaDonController.nhanVien = nhanVien;
	}
	@FXML
    void handleThem(ActionEvent event) {
		long tienDichVu = listDV.stream().mapToLong(mapper -> Long.parseLong(mapper.getThanhTien())).sum();
		long tienPhong = Long.parseLong(textGiaPhong.getText());
		String maHoaDon = "HD" + new SimpleDateFormat("yyMMddHHmmssSSS").format(new Date());
		
		
    	KhachHang khachHang = KhachHangSerivce.findKhachHangById(lableMaKhachHang.getText());
    	Phong phong = PhongService.findPhongById(comboboxMaPhong.getSelectionModel().getSelectedItem());
    	HoaDon hoaDon = new HoaDon();
    	hoaDon.setMaPhong(phong);
    	//hoaDon.setMaKhachHang(khachHang);
    	hoaDon.setMaNhanVien(nhanVien);
    	hoaDon.setMaHoaDon(maHoaDon);
    	
    	hoaDon.setTongTien(tienDichVu + tienPhong + "");
    	hoaDon.setNgayTao(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
    	hoaDon.setTrangThai("true");
    	
    	CTDichVuPK ctDichVuPk = new CTDichVuPK();
    	ctDichVuPk.setMaHoaDon(maHoaDon);
    	
    	HoaDonService.saveHoaDon(hoaDon);
    	
    	if(listDV.size() != 0) {
	    	for(DichVuView dichVuview:listDV) {
	    		ctDichVuPk.setMaDichVu(dichVuview.getMaDichVu());
	    		DichVu dichVu = DichVuService.finDichVubyID(dichVuview.getMaDichVu());
	    		
	    		CTDichVu ctDichVu = new CTDichVu();
	    		ctDichVu.setCTDichVuPK(ctDichVuPk);
	    		ctDichVu.setDichVu(dichVu);
	    		ctDichVu.setHoaDon(hoaDon);
	    		ctDichVu.setSoLuong(Integer.parseInt(dichVuview.getSoluong()));
	    		ctDichVu.setTongTien(Integer.parseInt(dichVuview.getThanhTien()));
	    		
	    		ChiTietDichVuService.saveCTDichVu(ctDichVu);
	    	}
    	}
    	textCmnd.getScene().getWindow().hide();
    	
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		initDefault();
		handelComboBox();
	}
	


}