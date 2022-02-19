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
@Table(name = "Phong")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Phong.findAll", query = "SELECT p FROM Phong p"),
    @NamedQuery(name = "Phong.findByMaPhong", query = "SELECT p FROM Phong p WHERE p.maPhong = :maPhong"),
    @NamedQuery(name = "Phong.findByGiaPhong", query = "SELECT p FROM Phong p WHERE p.giaPhong = :giaPhong"),
    @NamedQuery(name = "Phong.findByTrangThaiPhong", query = "SELECT p FROM Phong p WHERE p.trangThaiPhong = :trangThaiPhong"),
    @NamedQuery(name = "Phong.findByTrangThai", query = "SELECT p FROM Phong p WHERE p.trangThai = :trangThai")})
public class Phong implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "maPhong")
    private String maPhong;
    @Column(name = "giaPhong")
    private String giaPhong;
    @Column(name = "trangThaiPhong")
    private String trangThaiPhong;
    @Column(name = "trangThai")
    private String trangThai;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "phong")
    private List<CTHopDong> cTHopDongList;
    @OneToMany(mappedBy = "maPhong")
    private List<HoaDon> hoaDonList;

    public Phong() {
    }

    public Phong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(String giaPhong) {
        this.giaPhong = giaPhong;
    }

    public String getTrangThaiPhong() {
        return trangThaiPhong;
    }

    public void setTrangThaiPhong(String trangThaiPhong) {
        this.trangThaiPhong = trangThaiPhong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @XmlTransient
    public List<CTHopDong> getCTHopDongList() {
        return cTHopDongList;
    }

    public void setCTHopDongList(List<CTHopDong> cTHopDongList) {
        this.cTHopDongList = cTHopDongList;
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
        hash += (maPhong != null ? maPhong.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phong)) {
            return false;
        }
        Phong other = (Phong) object;
        if ((this.maPhong == null && other.maPhong != null) || (this.maPhong != null && !this.maPhong.equals(other.maPhong))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Phong[ maPhong=" + maPhong + " ]";
    }
    
}
