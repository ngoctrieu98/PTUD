/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author HOME
 */
@Embeddable
public class CTHopDongPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "maHopDong")
    private String maHopDong;
    @Basic(optional = false)
    @Column(name = "maKhachHang")
    private String maKhachHang;
    @Basic(optional = false)
    @Column(name = "maPhong")
    private String maPhong;

    public CTHopDongPK() {
    }

    public CTHopDongPK(String maHopDong, String maKhachHang, String maPhong) {
        this.maHopDong = maHopDong;
        this.maKhachHang = maKhachHang;
        this.maPhong = maPhong;
    }

    public String getMaHopDong() {
        return maHopDong;
    }

    public void setMaHopDong(String maHopDong) {
        this.maHopDong = maHopDong;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maHopDong != null ? maHopDong.hashCode() : 0);
        hash += (maKhachHang != null ? maKhachHang.hashCode() : 0);
        hash += (maPhong != null ? maPhong.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CTHopDongPK)) {
            return false;
        }
        CTHopDongPK other = (CTHopDongPK) object;
        if ((this.maHopDong == null && other.maHopDong != null) || (this.maHopDong != null && !this.maHopDong.equals(other.maHopDong))) {
            return false;
        }
        if ((this.maKhachHang == null && other.maKhachHang != null) || (this.maKhachHang != null && !this.maKhachHang.equals(other.maKhachHang))) {
            return false;
        }
        if ((this.maPhong == null && other.maPhong != null) || (this.maPhong != null && !this.maPhong.equals(other.maPhong))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CTHopDongPK[ maHopDong=" + maHopDong + ", maKhachHang=" + maKhachHang + ", maPhong=" + maPhong + " ]";
    }
    
}
