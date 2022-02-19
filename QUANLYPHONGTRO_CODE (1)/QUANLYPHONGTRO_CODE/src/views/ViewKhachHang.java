package views;

import javafx.scene.control.Button;

public class ViewKhachHang {
	private String maKhachHang;
	private String tenKhachHang;
	private String CMND;
	private String SDT;
	private Button btnXoa;
	public Button getBtnXoa() {
		return btnXoa;
	}
	public void setBtnXoa(Button btnXoa) {
		this.btnXoa = btnXoa;
	}
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
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	
}
