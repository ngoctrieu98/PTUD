package service;

import java.util.List;
import java.util.stream.Collectors;

import dao.KhachHangDAO;
import model.KhachHang;
import model.Phong;

public class KhachHangSerivce {
	private static KhachHangDAO khachHangDao = new KhachHangDAO();
	
	
	public static List<KhachHang> findKhachHang() {
		return khachHangDao.getAll(KhachHang.class).stream()
									.filter(fil -> fil.getTrangThai().equals("true"))
									.collect(Collectors.toList());
	}
	public static KhachHang findKhachHangById(String id) {
		return (KhachHang)khachHangDao.getOneByCondition(KhachHang.class, "maKhachHang", id);
	}
	public static void deleteKhachHang(String id) {
		khachHangDao.delete(KhachHang.class, id);
	}
	public static void saveKhachHang(KhachHang t) {
		khachHangDao.save(t);
	}
	public static void updateKhachHang(KhachHang t) {
		khachHangDao.save(t);
	}
}
