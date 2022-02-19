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
@Table(name = "HopDongThue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HopDongThue.findAll", query = "SELECT h FROM HopDongThue h"),
    @NamedQuery(name = "HopDongThue.findByMaHopDong", query = "SELECT h FROM HopDongThue h WHERE h.maHopDong = :maHopDong"),
    @NamedQuery(name = "HopDongThue.findByNgayTao", query = "SELECT h FROM HopDongThue h WHERE h.ngayTao = :ngayTao"),
    @NamedQuery(name = "HopDongThue.findByGhiChu", query = "SELECT h FROM HopDongThue h WHERE h.ghiChu = :ghiChu"),
    @NamedQuery(name = "HopDongThue.findByTrangThaiHopDong", query = "SELECT h FROM HopDongThue h WHERE h.trangThaiHopDong = :trangThaiHopDong")})
public class HopDongThue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "maHopDong")
    private String maHopDong;
    @Column(name = "ngayTao")
    private String ngayTao;
    @Column(name = "ghiChu")
    private String ghiChu;
    @Column(name = "trangThaiHopDong")
    private String trangThaiHopDong;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hopDongThue")
    private List<CTHopDong> cTHopDongList;

    public HopDongThue() {
    }

    public HopDongThue(String maHopDong) {
        this.maHopDong = maHopDong;
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

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTrangThaiHopDong() {
        return trangThaiHopDong;
    }

    public void setTrangThaiHopDong(String trangThaiHopDong) {
        this.trangThaiHopDong = trangThaiHopDong;
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
        hash += (maHopDong != null ? maHopDong.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HopDongThue)) {
            return false;
        }
        HopDongThue other = (HopDongThue) object;
        if ((this.maHopDong == null && other.maHopDong != null) || (this.maHopDong != null && !this.maHopDong.equals(other.maHopDong))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.HopDongThue[ maHopDong=" + maHopDong + " ]";
    }
    
}
