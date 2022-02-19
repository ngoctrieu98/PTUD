package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.HoaDonDAO;
import model.HoaDon;
import views.HoaDonView;

public class HoaDonService {
	private static HoaDonDAO hoaDonDao = new HoaDonDAO();
	
	public static List<HoaDon> getHoaDonByThang(String thang) {
		List<HoaDon> listHoaDon = hoaDonDao.getAll(HoaDon.class);
		List<HoaDon> temp = new ArrayList<>();
		try {
			for (HoaDon hoaDon : listHoaDon) {
				String thangSplit = hoaDon.getNgayTao().split("-")[1];
				thang = thang.length() < 2 ? "0" + thang : thang;
				System.out.println(hoaDon.getNgayTao());
				System.out.println(thangSplit);
				System.out.println(thang);
				if (thangSplit.equals(thang)) {
					temp.add(hoaDon);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}

		return temp;
	}
	public static void deleteHoaDon(String id) {
		hoaDonDao.delete(HoaDon.class, id);
	}
	public static boolean saveHoaDon(HoaDon t) {
		return hoaDonDao.save(t);
	}
}
