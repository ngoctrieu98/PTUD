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
@Table(name = "KhachHang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KhachHang.findAll", query = "SELECT k FROM KhachHang k"),
    @NamedQuery(name = "KhachHang.findByMaKhachHang", query = "SELECT k FROM KhachHang k WHERE k.maKhachHang = :maKhachHang"),
    @NamedQuery(name = "KhachHang.findByTenKhachHang", query = "SELECT k FROM KhachHang k WHERE k.tenKhachHang = :tenKhachHang"),
    @NamedQuery(name = "KhachHang.findByDiaChi", query = "SELECT k FROM KhachHang k WHERE k.diaChi = :diaChi"),
    @NamedQuery(name = "KhachHang.findBySdt", query = "SELECT k FROM KhachHang k WHERE k.sdt = :sdt"),
    @NamedQuery(name = "KhachHang.findByTrangThai", query = "SELECT k FROM KhachHang k WHERE k.trangThai = :trangThai"),
    @NamedQuery(name = "KhachHang.findByMaHopDong", query = "SELECT k FROM KhachHang k WHERE k.maHopDong = :maHopDong")})
public class KhachHang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "maKhachHang")
    private String maKhachHang;
    @Column(name = "tenKhachHang")
    private String tenKhachHang;
    @Column(name = "diaChi")
    private String diaChi;
    @Column(name = "sdt")
    private String sdt;
    @Column(name = "trangThai")
    private String trangThai;
    @Column(name = "maHopDong")
    private String maHopDong;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "khachHang")
    private List<CTHopDong> cTHopDongList;

    public KhachHang() {
    }

    public KhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
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

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaHopDong() {
        return maHopDong;
    }

    public void setMaHopDong(String maHopDong) {
        this.maHopDong = maHopDong;
    }

    @XmlTransient
    public List<CTHopDong> getCTHopDongList() {
        return cTHopDongList;
    }

    public void setCTHopDongList(List<CTHopDong> cTHopDongList) {
        this.cTHopDongList = cTHopDongList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maKhachHang != null ? maKhachHang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KhachHang)) {
            return false;
        }
        KhachHang other = (KhachHang) object;
        if ((this.maKhachHang == null && other.maKhachHang != null) || (this.maKhachHang != null && !this.maKhachHang.equals(other.maKhachHang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.KhachHang[ maKhachHang=" + maKhachHang + " ]";
    }
    
}
