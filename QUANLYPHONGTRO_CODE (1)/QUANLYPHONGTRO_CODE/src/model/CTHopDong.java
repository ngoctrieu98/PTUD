/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HOME
 */
@Entity
@Table(name = "CT_HopDong")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CTHopDong.findAll", query = "SELECT c FROM CTHopDong c"),
    @NamedQuery(name = "CTHopDong.findByMaHopDong", query = "SELECT c FROM CTHopDong c WHERE c.cTHopDongPK.maHopDong = :maHopDong"),
    @NamedQuery(name = "CTHopDong.findByMaKhachHang", query = "SELECT c FROM CTHopDong c WHERE c.cTHopDongPK.maKhachHang = :maKhachHang"),
    @NamedQuery(name = "CTHopDong.findByChuPhong", query = "SELECT c FROM CTHopDong c WHERE c.chuPhong = :chuPhong"),
    @NamedQuery(name = "CTHopDong.findByMaPhong", query = "SELECT c FROM CTHopDong c WHERE c.cTHopDongPK.maPhong = :maPhong")})
public class CTHopDong implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CTHopDongPK cTHopDongPK;
    @Column(name = "chuPhong")
    private String chuPhong;
    @JoinColumn(name = "maHopDong", referencedColumnName = "maHopDong", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HopDongThue hopDongThue;
    @JoinColumn(name = "maKhachHang", referencedColumnName = "maKhachHang", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private KhachHang khachHang;
    @JoinColumn(name = "maPhong", referencedColumnName = "maPhong", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Phong phong;

    public CTHopDong() {
    }

    public CTHopDong(CTHopDongPK cTHopDongPK) {
        this.cTHopDongPK = cTHopDongPK;
    }

    public CTHopDong(String maHopDong, String maKhachHang, String maPhong) {
        this.cTHopDongPK = new CTHopDongPK(maHopDong, maKhachHang, maPhong);
    }

    public CTHopDongPK getCTHopDongPK() {
        return cTHopDongPK;
    }

    public void setCTHopDongPK(CTHopDongPK cTHopDongPK) {
        this.cTHopDongPK = cTHopDongPK;
    }

    public String getChuPhong() {
        return chuPhong;
    }

    public void setChuPhong(String chuPhong) {
        this.chuPhong = chuPhong;
    }

    public HopDongThue getHopDongThue() {
        return hopDongThue;
    }

    public void setHopDongThue(HopDongThue hopDongThue) {
        this.hopDongThue = hopDongThue;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cTHopDongPK != null ? cTHopDongPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CTHopDong)) {
            return false;
        }
        CTHopDong other = (CTHopDong) object;
        if ((this.cTHopDongPK == null && other.cTHopDongPK != null) || (this.cTHopDongPK != null && !this.cTHopDongPK.equals(other.cTHopDongPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CTHopDong[ cTHopDongPK=" + cTHopDongPK + " ]";
    }
    
}
