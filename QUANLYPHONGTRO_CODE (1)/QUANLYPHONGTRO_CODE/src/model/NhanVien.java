/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HOME
 */
@Entity
@Table(name = "NhanVien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NhanVien.findAll", query = "SELECT n FROM NhanVien n"),
    @NamedQuery(name = "NhanVien.findByMaNhanVien", query = "SELECT n FROM NhanVien n WHERE n.maNhanVien = :maNhanVien"),
    @NamedQuery(name = "NhanVien.findByTenNhanVien", query = "SELECT n FROM NhanVien n WHERE n.tenNhanVien = :tenNhanVien"),
    @NamedQuery(name = "NhanVien.findByDiaChi", query = "SELECT n FROM NhanVien n WHERE n.diaChi = :diaChi"),
    @NamedQuery(name = "NhanVien.findBySdt", query = "SELECT n FROM NhanVien n WHERE n.sdt = :sdt"),
    @NamedQuery(name = "NhanVien.findByCmnd", query = "SELECT n FROM NhanVien n WHERE n.cmnd = :cmnd"),
    @NamedQuery(name = "NhanVien.findByTrangThai", query = "SELECT n FROM NhanVien n WHERE n.trangThai = :trangThai"),
    @NamedQuery(name = "NhanVien.findByChucVu", query = "SELECT n FROM NhanVien n WHERE n.chucVu = :chucVu")})
public class NhanVien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "maNhanVien")
    private String maNhanVien;
    @Column(name = "tenNhanVien")
    private String tenNhanVien;
    @Column(name = "diaChi")
    private String diaChi;
    @Column(name = "sdt")
    private String sdt;
    @Column(name = "cmnd")
    private String cmnd;
    @Column(name = "trangThai")
    private String trangThai;
    @Column(name = "chucVu")
    private String chucVu;
    @JoinColumn(name = "maTaiKhoan", referencedColumnName = "maTaiKhoan")
    @OneToOne
    private TaiKhoan maTaiKhoan;
    @OneToMany(mappedBy = "maNhanVien")
    private List<HoaDon> hoaDonList;

    public NhanVien() {
    }

    public NhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public TaiKhoan getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(TaiKhoan maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    @XmlTransient
    public List<HoaDon> getHoaDonList() {
        return hoaDonList;
    }

    public void setHoaDonList(List<HoaDon> hoaDonList) {
        this.hoaDonList = hoaDonList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maNhanVien != null ? maNhanVien.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NhanVien)) {
            return false;
        }
        NhanVien other = (NhanVien) object;
        if ((this.maNhanVien == null && other.maNhanVien != null) || (this.maNhanVien != null && !this.maNhanVien.equals(other.maNhanVien))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.NhanVien[ maNhanVien=" + maNhanVien + " ]";
    }
    
}
