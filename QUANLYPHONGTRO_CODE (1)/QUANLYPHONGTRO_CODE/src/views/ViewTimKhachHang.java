package views;

import javafx.scene.control.Button;

public class ViewTimKhachHang {
	private String maKhachHang;
	private String tenKhachHang;
	private String SDT;
	private String CMND;
	private Button btnChon;
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
	}
	public Button getBtnChon() {
		return btnChon;
	}
	public void setBtnChon(Button btnChon) {
		this.btnChon = btnChon;
	}
	
}
