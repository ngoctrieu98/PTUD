/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HOME
 */
@Entity
@Table(name = "TaiKhoan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TaiKhoan.findAll", query = "SELECT t FROM TaiKhoan t"),
    @NamedQuery(name = "TaiKhoan.findByMaTaiKhoan", query = "SELECT t FROM TaiKhoan t WHERE t.maTaiKhoan = :maTaiKhoan"),
    @NamedQuery(name = "TaiKhoan.findByTenTaiKhoan", query = "SELECT t FROM TaiKhoan t WHERE t.tenTaiKhoan = :tenTaiKhoan"),
    @NamedQuery(name = "TaiKhoan.findByMatKhau", query = "SELECT t FROM TaiKhoan t WHERE t.matKhau = :matKhau"),
    @NamedQuery(name = "TaiKhoan.findByTrangThai", query = "SELECT t FROM TaiKhoan t WHERE t.trangThai = :trangThai")})
public class TaiKhoan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "maTaiKhoan")
    private String maTaiKhoan;
    @Column(name = "tenTaiKhoan")
    private String tenTaiKhoan;
    @Column(name = "matKhau")
    private String matKhau;
    @Column(name = "trangThai")
    private String trangThai;
    @OneToOne(mappedBy = "maTaiKhoan")
    private NhanVien nhanVien;

    public TaiKhoan() {
    }

    public TaiKhoan(String maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(String maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maTaiKhoan != null ? maTaiKhoan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaiKhoan)) {
            return false;
        }
        TaiKhoan other = (TaiKhoan) object;
        if ((this.maTaiKhoan == null && other.maTaiKhoan != null) || (this.maTaiKhoan != null && !this.maTaiKhoan.equals(other.maTaiKhoan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TaiKhoan[ maTaiKhoan=" + maTaiKhoan + " ]";
    }
    
}
