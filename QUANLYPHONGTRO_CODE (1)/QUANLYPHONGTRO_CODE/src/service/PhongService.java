package service;

import java.util.List;
import java.util.stream.Collectors;

import dao.PhongDAO;
import model.Phong;

public class PhongService {
	private static PhongDAO phongDao = new PhongDAO();
	
	public static List<String> getListMaPhongDangO() {
		return phongDao.getAll(Phong.class).stream()
											.filter(fil -> fil.getTrangThaiPhong().equals("DANGO") && fil.getTrangThai().equals("true"))
											.map(map -> map.getMaPhong())
											.collect(Collectors.toList());
	}
	public static List<Phong> getListMaPhong() {
		return phongDao.getAllByCondition(Phong.class, "trangThai", "true");
	}
	public static Phong findPhongById(String id) {
		List<Phong> list = phongDao.getAll(Phong.class).stream()
				.filter(fil -> fil.getTrangThai().equals("true") && fil.getMaPhong().equals(id))
				.collect(Collectors.toList());
		return list.size() != 0 ? list.get(0): null;
	}
	public static void updatePhong(Phong p) {
		phongDao.update(p);
	}
	public static void savePhong(Phong p) {
		phongDao.save(p);
	}
}
