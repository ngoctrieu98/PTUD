package views;

import javafx.scene.control.Button;

public class ViewPhong {
	private String maPhong;
	private String giaPhong;
	private String trangThai;
	private Button btnTrangThai;
	private Button btnXoa;
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public String getGiaPhong() {
		return giaPhong;
	}
	public void setGiaPhong(String giaPhong) {
		this.giaPhong = giaPhong;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public Button getBtnTrangThai() {
		return btnTrangThai;
	}
	public void setBtnTrangThai(Button btnTrangThai) {
		this.btnTrangThai = btnTrangThai;
	}
	public Button getBtnXoa() {
		return btnXoa;
	}
	public void setBtnXoa(Button btnXoa) {
		this.btnXoa = btnXoa;
	}
}
