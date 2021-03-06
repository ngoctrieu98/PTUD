package controllers.submenu;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.ResourceBundle;

import controllers.topup.TopupThemHoaDonController;
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
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.HoaDon;
import model.TaiKhoan;
import service.ChiTietDichVuService;
import service.HoaDonService;
import service.NhanVienService;
import utils.ThongBao;
import views.HoaDonView;

public class HoaDonPhongController implements Initializable {
	@FXML
	private StackPane panelMain;
	@FXML
	private ComboBox<String> comboboxThang;
	@FXML
	private Label lableHeader;
	@FXML
	private TableView<HoaDonView> tableHoaDon;
	@FXML
	private TableColumn<HoaDonView, String> colSoHoaDon;
	@FXML
	private TableColumn<HoaDonView, String> colPhong;
	@FXML
	private TableColumn<HoaDonView, String> colChuPhong;
	@FXML
	private TableColumn<HoaDonView, String> colTongTien;
	@FXML
	private TableColumn<HoaDonView, Button> colChiTiet;
	@FXML
	private TableColumn<HoaDonView, Button> colXoa;
	
	private ObservableList<HoaDonView> listHoaDon = FXCollections.observableArrayList();
	
	public static TaiKhoan taiKhoan;

	public static void setTaiKhoan(TaiKhoan taiKhoan) {
		HoaDonPhongController.taiKhoan = taiKhoan;
	}

	// Event Listener on JFXButton.onAction
	@FXML
	public void handelTaoMoi(ActionEvent event) {
		if(LocalDate.now().getMonthValue() == Integer.parseInt(comboboxThang.getSelectionModel().getSelectedItem())) {
			Stage stageDatPhong = new Stage();
			Parent root;
			try {
				root = FXMLLoader.load(getClass().getResource("/application/topup/TopupThemHoaDon.fxml"));
				Scene scene = new Scene(root);
				stageDatPhong.setScene(scene);
				stageDatPhong.initModality(Modality.APPLICATION_MODAL);
				stageDatPhong.setFullScreen(false);
				stageDatPhong.setResizable(false);
				stageDatPhong.centerOnScreen();
				stageDatPhong.showAndWait();
				TopupThemHoaDonController.setNhanVien(taiKhoan.getNhanVien());
				loadTable(comboboxThang.getSelectionModel().getSelectedItem());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}else {
			ThongBao.thongBaoLoi("H??a ????n ch??? t???o trong th??ng!");
		}
		// TODO Autogenerated
	}
	
	public void loadTable(String thang) {
		listHoaDon.clear();
	    
        Iterator<HoaDon> it = HoaDonService.getHoaDonByThang(thang).iterator();
        while(it.hasNext()) {
        	HoaDon value = it.next();
            HoaDonView view = new HoaDonView();
            view.setPhong(value.getMaPhong().getMaPhong());
            view.setSoHoadon(value.getMaHoaDon());
            //view.setChuPhong(value .getMaKhachHang().getTenKhachHang());
            view.setTongTien(value.getTongTien());
            Button btnXoa = new Button("X??a");
            Button btnChiTiet = new Button("Chi ti???t");
            view.setBtnChiTiet(btnChiTiet);
            view.setBtnXoa(btnXoa);
            handleChiTiet(btnChiTiet, view);
            handleXoa(btnXoa, view, value);
            listHoaDon.add(view);
        }
        
        colChiTiet.setCellValueFactory(new PropertyValueFactory<>("btnChiTiet"));
        colPhong.setCellValueFactory(new PropertyValueFactory<>("phong"));
        colSoHoaDon.setCellValueFactory(new PropertyValueFactory<>("soHoadon"));
        colChuPhong.setCellValueFactory(new PropertyValueFactory<>("chuPhong"));
        colTongTien.setCellValueFactory(new PropertyValueFactory<>("tongTien"));
        colXoa.setCellValueFactory(new PropertyValueFactory<>("btnXoa"));
        tableHoaDon.setItems(listHoaDon);
	}
	
	private void handleXoa(Button btn, HoaDonView value, HoaDon hoaDon) {
		btn.setOnAction(events -> {
			boolean check = ThongBao.thongBaoXacNhan("B???n c?? ch???c ch???n mu???n x??a h??a ????n ?");
			if (check) {
				listHoaDon.remove(value);
				ChiTietDichVuService.deleteCTDichVu(hoaDon.getMaHoaDon());
				HoaDonService.deleteHoaDon(hoaDon.getMaHoaDon());
			}
		});
	}

	private void handleChiTiet(Button btn, HoaDonView value) {
		btn.setOnAction(events -> {
			ThongBao.thongBaoLoi("Chuc nang chua cap nhat");
		});
	}

	private void handelComboBox() {
		comboboxThang.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
			lableHeader.setText("H??a ????n th??ng " + newValue);
			loadTable(newValue);

		});
	}
	private void initDefault() {
	    comboboxThang.getItems().add("1");
	    comboboxThang.getItems().add("2");
	    comboboxThang.getItems().add("3");
	    comboboxThang.getItems().add("4");
	    comboboxThang.getItems().add("5");
	    comboboxThang.getItems().add("6");
	    comboboxThang.getItems().add("7");
	    comboboxThang.getItems().add("8");
	    comboboxThang.getItems().add("9");
	    comboboxThang.getItems().add("10");
	    comboboxThang.getItems().add("11");
	    comboboxThang.getItems().add("12");
	    comboboxThang.getSelectionModel().select(LocalDate.now().getMonthValue() - 1);
	    lableHeader.setText("H??a ????n th??ng " + LocalDate.now().getMonthValue());
	    loadTable(String.valueOf(LocalDate.now().getMonthValue()));
	    

	} // initCo
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		initDefault();
		handelComboBox();
		 
	
		
		
	}
}
