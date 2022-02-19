package service;

import java.util.List;
import java.util.stream.Collectors;

import dao.DichVuDAO;
import model.DichVu;

public class DichVuService {
	private static DichVuDAO dichVuDAO = new DichVuDAO();
	
	public static List<String> getListNameDichVu() {
		return dichVuDAO.getAll(DichVu.class).stream()
											.filter(fil -> fil.getTrangThai().equals("true"))
											.map(map -> map.getTenDichVu())
											.collect(Collectors.toList());
		
	}
	public static DichVu finDichVubyName(String name) {
		return (DichVu)dichVuDAO.getOneByCondition(DichVu.class, "tenDichVu", name);
		
	}
	public static DichVu finDichVubyID(String id) {
		return (DichVu)dichVuDAO.getOneByCondition(DichVu.class, "maDichVu", id);
		
	}
}
