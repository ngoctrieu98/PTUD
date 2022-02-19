/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import controllers.submenu.HoaDonPhongController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.NhanVien;
import model.TaiKhoan;
import service.NhanVienService;
import service.TaiKhoanService;
import utils.ThongBao;

public class DangNhapController implements Initializable {

    @FXML
    private JFXTextField txtTenDangNhap;
    @FXML
    private JFXPasswordField psfMatKhau;
    @FXML
    private JFXButton btnDangNhap;
    @FXML
    private JFXButton btnHuy;
    


    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtTenDangNhap.setText("admin");
        psfMatKhau.setText("12345678");
    }

    @FXML
    private void dangNhap(ActionEvent event) {
        String username = txtTenDangNhap.getText();
        String password = psfMatKhau.getText();
        
        TaiKhoan taiKhoan = TaiKhoanService.login(username, password);
        
        
        
        if (taiKhoan != null) {

               NhanVien nv = NhanVienService.findNhanVienByID(taiKhoan.getNhanVien().getMaNhanVien());
               MainFrmController.setNhanVien(nv);
            try {
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/MenuPT.fxml"));
            
                MainFrmController controller = loader.getController();
               
                Parent root = loader.load();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.setFullScreen(false);
                stage.setResizable(false);
                stage.show();
                HoaDonPhongController.setTaiKhoan(taiKhoan);
             
            } catch (IOException ex) {
              ex.printStackTrace();
            }
        } else {
            ThongBao.thongBaoLoi("Tai khoan hoac mat khau khong ton tai");
        }
    }

    @FXML
    private void handleHuy(ActionEvent event) {
        boolean xacNhan = ThongBao.thongBaoXacNhan("Ban co chac chan muon huy");
        if(xacNhan)
            Platform.exit();
    }
    


}
