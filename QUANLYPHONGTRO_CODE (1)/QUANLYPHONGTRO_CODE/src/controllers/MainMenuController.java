/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.NhanVien;

/**
 *
 * @author HOME
 */
public class MainMenuController implements Initializable{

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      
    }

    @FXML
    private void HandleHopDong(ActionEvent event) {
         load("/application/submenu/HoaDonPhong.fxml");
    }

    @FXML
    private void handlehoaDon(ActionEvent event) {
         load("/application/submenu/HoaDonPhong.fxml");
    }

    @FXML
    private void handleQuanLyPhong(ActionEvent event) {
         load("/application/submenu/QuanLyPhong.fxml");
    }

    @FXML
    private void handleQuanLyKhachHang(ActionEvent event) {
         load("/application/submenu/QuanLyKhachHang.fxml");
    }

    @FXML
    private void handleQuanLyNhanVien(ActionEvent event) {
         load("/application/submenu/QuanLyNhanVien.fxml");
    }

    @FXML
    private void handleQuanLyDichVu(ActionEvent event) {
         load("/application/submenu/QuanLyDichVu.fxml");
    }

    @FXML
    private void handleThongKe(ActionEvent event) {
         load("/application/submenu/QuanLyNhanVien.fxml");
    }

    @FXML
    private void handleDangXuat(ActionEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/DangNhapFXML.fxml"));
            Parent root = loader.load();
            DangNhapController controller = loader.getController();
            stage.setScene(new Scene(root));
            stage.setFullScreen(false);
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(DangNhapController.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    public static NhanVien nhanVien;
	
	public static void setNhanVien(NhanVien nhanVien) {
		MainMenuController.nhanVien = nhanVien;
	}

	
	public void isNotAdmin() {
		
	}
    
    public void load(String resource){
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
        Parent root;
        try {
            root = loader.load();        
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.setFullScreen(false);
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
