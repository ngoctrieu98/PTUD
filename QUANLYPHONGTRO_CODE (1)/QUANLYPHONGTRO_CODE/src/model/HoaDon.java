/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HOME
 */
@Entity
@Table(name = "HoaDon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HoaDon.findAll", query = "SELECT h FROM HoaDon h"),
    @NamedQuery(name = "HoaDon.findByMaHoaDon", query = "SELECT h FROM HoaDon h WHERE h.maHoaDon = :maHoaDon"),
    @NamedQuery(name = "HoaDon.findByMaHopDong", query = "SELECT h FROM HoaDon h WHERE h.maHopDong = :maHopDong"),
    @NamedQuery(name = "HoaDon.findByNgayTao", query = "SELECT h FROM HoaDon h WHERE h.ngayTao = :ngayTao"),
    @NamedQuery(name = "HoaDon.findByTienDaThu", query = "SELECT h FROM HoaDon h WHERE h.tienDaThu = :tienDaThu"),
    @NamedQuery(name = "HoaDon.findByTongTien", query = "SELECT h FROM HoaDon h WHERE h.tongTien = :tongTien"),
    @NamedQuery(name = "HoaDon.findByTrangThai", query = "SELECT h FROM HoaDon h WHERE h.trangThai = :trangThai"),
    @NamedQuery(name = "HoaDon.findByGhiChu", query = "SELECT h FROM HoaDon h WHERE h.ghiChu = :ghiChu")})
public class HoaDon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "maHoaDon")
    private String maHoaDon;
    @Column(name = "maHopDong")
    private String maHopDong;
    @Column(name = "ngayTao")
    private String ngayTao;
    @Column(name = "tienDaThu")
    private String tienDaThu;
    @Column(name = "tongTien")
    private String tongTien;
    @Column(name = "trangThai")
    private String trangThai;
    @Column(name = "ghiChu")
    private String ghiChu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hoaDon")
    private List<CTDichVu> cTDichVuList;
    @JoinColumn(name = "maNhanVien", referencedColumnName = "maNhanVien")
    @ManyToOne
    private NhanVien maNhanVien;
    @JoinColumn(name = "maPhong", referencedColumnName = "maPhong")
    @ManyToOne
    private Phong maPhong;

    public HoaDon() {
    }

    public HoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaHopDong() {
        return maHopDong;
    }

    public void setMaHopDong(String maHopDong) {
        this.maHopDong = maHopDong;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTienDaThu() {
        return tienDaThu;
    }

    public void setTienDaThu(String tienDaThu) {
        this.tienDaThu = tienDaThu;
    }

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @XmlTransient
    public List<CTDichVu> getCTDichVuList() {
        return cTDichVuList;
    }

    public void setCTDichVuList(List<CTDichVu> cTDichVuList) {
        this.cTDichVuList = cTDichVuList;
    }

    public NhanVien getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(NhanVien maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public Phong getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(Phong maPhong) {
        this.maPhong = maPhong;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maHoaDon != null ? maHoaDon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HoaDon)) {
            return false;
        }
        HoaDon other = (HoaDon) object;
        if ((this.maHoaDon == null && other.maHoaDon != null) || (this.maHoaDon != null && !this.maHoaDon.equals(other.maHoaDon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.HoaDon[ maHoaDon=" + maHoaDon + " ]";
    }
    
}
