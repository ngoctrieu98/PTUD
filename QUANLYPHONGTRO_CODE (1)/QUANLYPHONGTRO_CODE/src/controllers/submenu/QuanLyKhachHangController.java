package controllers.submenu;


import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.KhachHang;
import service.KhachHangSerivce;
import utils.ThongBao;
import views.ViewKhachHang;

public class QuanLyKhachHangController implements Initializable{

    @FXML
    private TableView<ViewKhachHang> tableKhachHang;

    @FXML
    private TableColumn<ViewKhachHang, String> colMaKhachHang;

    @FXML
    private TableColumn<ViewKhachHang, String> colTenKhachHang;

    @FXML
    private TableColumn<ViewKhachHang, String> colCMND;

    @FXML
    private TableColumn<ViewKhachHang, String> colSDT;

    @FXML
    private TextField textTimKiem;
    
    @FXML
    private TableColumn<ViewKhachHang, Button> colXoa;
    
    private ObservableList<ViewKhachHang> listKhachHang = FXCollections.observableArrayList();
    
    public static KhachHang khachHang;
    
	public static void setKhachHang(KhachHang khachHang) {
		QuanLyKhachHangController.khachHang = khachHang;
	}
	private void loadTable() {
    	listKhachHang.clear();
    	Iterator<KhachHang> it = KhachHangSerivce.findKhachHang().iterator();
        while(it.hasNext()) {
        	KhachHang value = it.next();
            ViewKhachHang view = new ViewKhachHang();
            view.setCMND(value.getDiaChi());
            view.setMaKhachHang(value.getMaKhachHang());
            view.setSDT(value.getSdt());
            view.setTenKhachHang(value.getTenKhachHang());

            Button btnXoa = new Button("Xóa"); 
            
            view.setBtnXoa(btnXoa);
           
            handleXoa(btnXoa, view, value);
        
            listKhachHang.add(view);
        }
        colCMND.setCellValueFactory(new PropertyValueFactory<>("CMND"));
        colMaKhachHang.setCellValueFactory(new PropertyValueFactory<>("maKhachHang"));
        colSDT.setCellValueFactory(new PropertyValueFactory<>("SDT"));
        colTenKhachHang.setCellValueFactory(new PropertyValueFactory<>("tenKhachHang"));
        colXoa.setCellValueFactory(new PropertyValueFactory<>("btnXoa"));
        tableKhachHang.setItems(listKhachHang);
	}
    private void handleXoa(Button btn, ViewKhachHang value, KhachHang khachHang) {
    	btn.setOnAction(e -> {
    		boolean check = ThongBao.thongBaoXacNhan("Bạn có muốn xóa khách hàng!");
    		if(check) {
    			listKhachHang.remove(value);
    			khachHang.setTrangThai("false");
    			KhachHangSerivce.updateKhachHang(khachHang);
    		}
    	});
    }
    private void timKhachHang() {
    	  FilteredList<ViewKhachHang> filteredData = new FilteredList(listKhachHang, p -> true);
          textTimKiem.textProperty().addListener((observable, oldValue, newValue) -> {
              filteredData.setPredicate(khachHang -> {
                  if (newValue == null || newValue.isEmpty()) {
                      return true;
                  }
                  String lowerCaseFilter = newValue.toLowerCase();
                  if (khachHang.getMaKhachHang().toLowerCase().contains(lowerCaseFilter)) {
                      return true; 
                  }
                  if (khachHang.getTenKhachHang().toLowerCase().contains(lowerCaseFilter)) {
                      return true; 
                  }
                  if (khachHang.getSDT().toLowerCase().contains(lowerCaseFilter)) {
                      return true; 
                  }
                  if (khachHang.getCMND().toLowerCase().contains(lowerCaseFilter)) {
                      return true; 
                  }
                  return false; 
              });
          });
          SortedList<ViewKhachHang> sortedData = new SortedList<>(filteredData);
          sortedData.comparatorProperty().bind(tableKhachHang.comparatorProperty());
          tableKhachHang.setItems(sortedData);
    }
    @FXML
    void handleThemMoi(javafx.event.ActionEvent event) {
    	Stage stageDatPhong = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/application/topup/TopupThemKhachHang.fxml"));
			Scene scene = new Scene(root);
			stageDatPhong.setScene(scene);
			stageDatPhong.initModality(Modality.APPLICATION_MODAL);
			stageDatPhong.setFullScreen(false);
			stageDatPhong.setResizable(false);
			stageDatPhong.centerOnScreen();
			stageDatPhong.showAndWait();
			
			if(khachHang != null) {
				ViewKhachHang view = new ViewKhachHang();
				view.setCMND(khachHang.getDiaChi());
				view.setMaKhachHang(khachHang.getMaKhachHang());
				view.setSDT(khachHang.getSdt());
				view.setTenKhachHang(khachHang.getTenKhachHang());
				
				Button btnXoa = new Button("Xóa");
				view.setBtnXoa(btnXoa);
				
				listKhachHang.add(view);
				handleXoa(btnXoa, view, khachHang);
				
				KhachHangSerivce.saveKhachHang(khachHang);
				khachHang = null;
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		loadTable();
		timKhachHang();
		
	}

}
