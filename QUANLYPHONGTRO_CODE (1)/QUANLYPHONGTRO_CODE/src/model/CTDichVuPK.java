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
public class CTDichVuPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "maDichVu")
    private String maDichVu;
    @Basic(optional = false)
    @Column(name = "maHoaDon")
    private String maHoaDon;

    public CTDichVuPK() {
    }

    public CTDichVuPK(String maDichVu, String maHoaDon) {
        this.maDichVu = maDichVu;
        this.maHoaDon = maHoaDon;
    }

    public String getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maDichVu != null ? maDichVu.hashCode() : 0);
        hash += (maHoaDon != null ? maHoaDon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CTDichVuPK)) {
            return false;
        }
        CTDichVuPK other = (CTDichVuPK) object;
        if ((this.maDichVu == null && other.maDichVu != null) || (this.maDichVu != null && !this.maDichVu.equals(other.maDichVu))) {
            return false;
        }
        if ((this.maHoaDon == null && other.maHoaDon != null) || (this.maHoaDon != null && !this.maHoaDon.equals(other.maHoaDon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CTDichVuPK[ maDichVu=" + maDichVu + ", maHoaDon=" + maHoaDon + " ]";
    }
    
}
