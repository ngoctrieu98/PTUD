package service;

import dao.NhanVienDAO;
import model.NhanVien;

public class NhanVienService {
	private static NhanVienDAO nhanVienDAO = new NhanVienDAO();
	
	public static NhanVien findNhanVienByID(String id) {
		return (NhanVien)nhanVienDAO.getOneByCondition(NhanVien.class, "maNhanVien", id);
	}
	public static NhanVien findNhanVienByTaiKhoan(String id) {
		return (NhanVien)nhanVienDAO.getOneByCondition(NhanVien.class, "maTaiKhoan", id);
	}
}
