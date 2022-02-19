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
@Table(name = "DichVu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DichVu.findAll", query = "SELECT d FROM DichVu d"),
    @NamedQuery(name = "DichVu.findByMaDichVu", query = "SELECT d FROM DichVu d WHERE d.maDichVu = :maDichVu"),
    @NamedQuery(name = "DichVu.findByTenDichVu", query = "SELECT d FROM DichVu d WHERE d.tenDichVu = :tenDichVu"),
    @NamedQuery(name = "DichVu.findByTrangThai", query = "SELECT d FROM DichVu d WHERE d.trangThai = :trangThai"),
    @NamedQuery(name = "DichVu.findByDonGia", query = "SELECT d FROM DichVu d WHERE d.donGia = :donGia"),
    @NamedQuery(name = "DichVu.findByDonViTinh", query = "SELECT d FROM DichVu d WHERE d.donViTinh = :donViTinh")})
public class DichVu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "maDichVu")
    private String maDichVu;
    @Column(name = "tenDichVu")
    private String tenDichVu;
    @Column(name = "trangThai")
    private String trangThai;
    @Column(name = "donGia")
    private String donGia;
    @Column(name = "donViTinh")
    private String donViTinh;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dichVu")
    private List<CTDichVu> cTDichVuList;

    public DichVu() {
    }

    public DichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }

    public String getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getDonGia() {
        return donGia;
    }

    public void setDonGia(String donGia) {
        this.donGia = donGia;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    @XmlTransient
    public List<CTDichVu> getCTDichVuList() {
        return cTDichVuList;
    }

    public void setCTDichVuList(List<CTDichVu> cTDichVuList) {
        this.cTDichVuList = cTDichVuList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maDichVu != null ? maDichVu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DichVu)) {
            return false;
        }
        DichVu other = (DichVu) object;
        if ((this.maDichVu == null && other.maDichVu != null) || (this.maDichVu != null && !this.maDichVu.equals(other.maDichVu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.DichVu[ maDichVu=" + maDichVu + " ]";
    }
    
}
