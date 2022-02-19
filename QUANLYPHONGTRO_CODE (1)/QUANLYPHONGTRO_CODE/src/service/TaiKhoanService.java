package service;

import dao.TaiKhoanDAO;
import model.TaiKhoan;

public class TaiKhoanService {
	private static TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
	
	public static TaiKhoan login(String userName, String pass) {
		TaiKhoan taiKhoan = (TaiKhoan)taiKhoanDAO.getOneByCondition(TaiKhoan.class, "tenTaiKhoan", userName);
		if(taiKhoan != null)
			if(taiKhoan.getMatKhau().equals(pass)) {
				return taiKhoan;
			}
		return null;
	}
	
}
