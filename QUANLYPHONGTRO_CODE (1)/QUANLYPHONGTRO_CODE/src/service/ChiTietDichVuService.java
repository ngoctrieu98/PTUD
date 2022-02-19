package service;

import dao.CTDichVuDAO;
import model.CTDichVu;
import model.CTDichVuPK;

public class ChiTietDichVuService {
	private static CTDichVuDAO ctDichVuDAO = new CTDichVuDAO();
	
	public static boolean saveCTDichVu(CTDichVu ct) {
		return ctDichVuDAO.save(ct);
	}
	public static void deleteCTDichVu(String id) {

		ctDichVuDAO.delete(CTDichVu.class, id);
	}
}
