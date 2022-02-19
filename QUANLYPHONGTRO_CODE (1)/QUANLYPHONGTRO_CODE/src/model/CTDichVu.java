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
@Table(name = "CT_DichVu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CTDichVu.findAll", query = "SELECT c FROM CTDichVu c"),
    @NamedQuery(name = "CTDichVu.findByMaDichVu", query = "SELECT c FROM CTDichVu c WHERE c.cTDichVuPK.maDichVu = :maDichVu"),
    @NamedQuery(name = "CTDichVu.findByMaHoaDon", query = "SELECT c FROM CTDichVu c WHERE c.cTDichVuPK.maHoaDon = :maHoaDon"),
    @NamedQuery(name = "CTDichVu.findBySoLuong", query = "SELECT c FROM CTDichVu c WHERE c.soLuong = :soLuong"),
    @NamedQuery(name = "CTDichVu.findByTongTien", query = "SELECT c FROM CTDichVu c WHERE c.tongTien = :tongTien")})
public class CTDichVu implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CTDichVuPK cTDichVuPK;
    @Column(name = "soLuong")
    private Integer soLuong;
    @Column(name = "tongTien")
    private Integer tongTien;
    @JoinColumn(name = "maDichVu", referencedColumnName = "maDichVu", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DichVu dichVu;
    @JoinColumn(name = "maHoaDon", referencedColumnName = "maHoaDon", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HoaDon hoaDon;

    public CTDichVu() {
    }

    public CTDichVu(CTDichVuPK cTDichVuPK) {
        this.cTDichVuPK = cTDichVuPK;
    }

    public CTDichVu(String maDichVu, String maHoaDon) {
        this.cTDichVuPK = new CTDichVuPK(maDichVu, maHoaDon);
    }

    public CTDichVuPK getCTDichVuPK() {
        return cTDichVuPK;
    }

    public void setCTDichVuPK(CTDichVuPK cTDichVuPK) {
        this.cTDichVuPK = cTDichVuPK;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Integer getTongTien() {
        return tongTien;
    }

    public void setTongTien(Integer tongTien) {
        this.tongTien = tongTien;
    }

    public DichVu getDichVu() {
        return dichVu;
    }

    public void setDichVu(DichVu dichVu) {
        this.dichVu = dichVu;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cTDichVuPK != null ? cTDichVuPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CTDichVu)) {
            return false;
        }
        CTDichVu other = (CTDichVu) object;
        if ((this.cTDichVuPK == null && other.cTDichVuPK != null) || (this.cTDichVuPK != null && !this.cTDichVuPK.equals(other.cTDichVuPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CTDichVu[ cTDichVuPK=" + cTDichVuPK + " ]";
    }
    
}
