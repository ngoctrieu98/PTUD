package views;

import javafx.scene.control.Button;

public class HoaDonView {
	private String soHoadon;
	private String phong;
	private String chuPhong;
	private String tongTien;
	private Button btnChiTiet;
	private Button btnXoa;
	public String getSoHoadon() {
		return soHoadon;
	}
	public void setSoHoadon(String soHoadon) {
		this.soHoadon = soHoadon;
	}
	public String getPhong() {
		return phong;
	}
	public void setPhong(String phong) {
		this.phong = phong;
	}
	public String getChuPhong() {
		return chuPhong;
	}
	public void setChuPhong(String chuPhong) {
		this.chuPhong = chuPhong;
	}
	public String getTongTien() {
		return tongTien;
	}
	public void setTongTien(String tongTien) {
		this.tongTien = tongTien;
	}
	public Button getBtnChiTiet() {
		return btnChiTiet;
	}
	public void setBtnChiTiet(Button btnChiTiet) {
		this.btnChiTiet = btnChiTiet;
	}
	public Button getBtnXoa() {
		return btnXoa;
	}
	public void setBtnXoa(Button btnXoa) {
		this.btnXoa = btnXoa;
	}
}
