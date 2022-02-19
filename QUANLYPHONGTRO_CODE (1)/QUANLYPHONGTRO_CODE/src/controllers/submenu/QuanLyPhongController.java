package controllers.submenu;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
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
import model.Phong;
import service.KhachHangSerivce;
import service.PhongService;
import utils.ThongBao;
import views.ViewKhachHang;
import views.ViewPhong;

public class QuanLyPhongController implements Initializable{

    @FXML
    private TableView<ViewPhong> tablePhong;

    @FXML
    private TableColumn<ViewPhong, String> colMaPhong;

    @FXML
    private TableColumn<ViewPhong, String> colGiaPhong;

    @FXML
    private TableColumn<ViewPhong,String> colTrangThai;

    @FXML
    private TableColumn<ViewPhong, Button> colXoa;

    @FXML
    private TextField textTimKiem;
    
    @FXML
    private TableColumn<ViewPhong, Button> colBtnTrangThai;
    
    private ObservableList<ViewPhong> listPhong = FXCollections.observableArrayList();

    @FXML
    void handleThemMoi(ActionEvent event) {
    	Stage stageDatPhong = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/application/topup/TopupThemPhong.fxml"));
			Scene scene = new Scene(root);
			stageDatPhong.setScene(scene);
			stageDatPhong.initModality(Modality.APPLICATION_MODAL);
			stageDatPhong.setFullScreen(false);
			stageDatPhong.setResizable(false);
			stageDatPhong.centerOnScreen();
			stageDatPhong.showAndWait();
			
			initValue();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
    }
    public void initValue() {
    	listPhong.clear();
    	Iterator<Phong> it = PhongService.getListMaPhong().iterator();
        while(it.hasNext()) {
        	Phong value = it.next();
            ViewPhong view = new ViewPhong();
            view.setMaPhong(value.getMaPhong());
            view.setGiaPhong(value.getGiaPhong());
            view.setTrangThai(value.getTrangThaiPhong());

            Button btnXoa = new Button("Xóa"); 
            Button btnTrangThai = new Button(); 
            if(value.getTrangThaiPhong().equals("DANGO"))
            	btnTrangThai.setText("Trống");
            else {
            	btnTrangThai.setText("Chuyển sang đang ở");
            }
            view.setBtnXoa(btnXoa);
            view.setBtnTrangThai(btnTrangThai);
           
            handleXoa(btnXoa, view, value);
            handleTrangThai(btnTrangThai, view, value);
        
            listPhong.add(view);
        }
        colGiaPhong.setCellValueFactory(new PropertyValueFactory<>("giaPhong"));
        colMaPhong.setCellValueFactory(new PropertyValueFactory<>("maPhong"));
        colTrangThai.setCellValueFactory(new PropertyValueFactory<>("trangThai"));
        colBtnTrangThai.setCellValueFactory(new PropertyValueFactory<>("btnTrangThai"));
        colXoa.setCellValueFactory(new PropertyValueFactory<>("btnXoa"));
        tablePhong.setItems(listPhong);
    }
    private void handleXoa(Button btn, ViewPhong value, Phong phong) {
    	btn.setOnAction(e -> {
    		boolean check = ThongBao.thongBaoXacNhan("Bạn có muốn xóa phòng!");
    		if(check) {
    			listPhong.remove(value);
    			phong.setTrangThai("fasle");
    			PhongService.updatePhong(phong);
    			
    		}
    	});
    }
    private void handleTrangThai(Button btn, ViewPhong value, Phong phong) {
    	btn.setOnAction(e -> {
    		phong.setTrangThaiPhong(value.getTrangThai().equals("DANGO") ? "TRONG":"DANGO");
    		PhongService.updatePhong(phong);
    		initValue();
    	});
    }
    private void timPhong() {
  	  FilteredList<ViewPhong> filteredData = new FilteredList(listPhong, p -> true);
        textTimKiem.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(khachHang -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (khachHang.getGiaPhong().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                }
                if (khachHang.getMaPhong().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                }
                if (khachHang.getTrangThai().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                }
               
                return false; 
            });
        });
        SortedList<ViewPhong> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tablePhong.comparatorProperty());
        tablePhong.setItems(sortedData);
  }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		initValue();
		timPhong() ;
		
	}

}
