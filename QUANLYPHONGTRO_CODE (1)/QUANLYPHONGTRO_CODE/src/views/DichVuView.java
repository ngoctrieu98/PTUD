package views;

import javafx.scene.control.Button;

public class DichVuView {
	private String maDichVu;
	private String tenDichVu;
	private String soluong;
	private String thanhTien;
	private String donGia;
	private String donViTinh;
	private Button btnXoa;
	public String getMaDichVu() {
		return maDichVu;
	}
	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}
	public String getTenDichVu() {
		return tenDichVu;
	}
	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}
	public String getSoluong() {
		return soluong;
	}
	public void setSoluong(String soluong) {
		this.soluong = soluong;
	}
	public String getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(String thanhTien) {
		this.thanhTien = thanhTien;
	}
	public String getDonGia() {
		return donGia;
	}
	public void setDonGia(String donGia) {
		this.donGia = donGia;
	}
	public String getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	public Button getBtnXoa() {
		return btnXoa;
	}
	public void setBtnXoa(Button btnXoa) {
		this.btnXoa = btnXoa;
	}
}
