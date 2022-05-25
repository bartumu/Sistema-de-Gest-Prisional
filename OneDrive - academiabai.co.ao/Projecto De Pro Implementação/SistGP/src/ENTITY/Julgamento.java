/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Melhor De Mim
 */
@Entity
@Table(catalog = "sistgp", schema = "")
@NamedQueries({
    @NamedQuery(name = "Julgamento.findAll", query = "SELECT j FROM Julgamento j"),
    @NamedQuery(name = "Julgamento.findByIdJulgamento", query = "SELECT j FROM Julgamento j WHERE j.idJulgamento = :idJulgamento"),
    @NamedQuery(name = "Julgamento.findByTribunal", query = "SELECT j FROM Julgamento j WHERE j.tribunal = :tribunal"),
    @NamedQuery(name = "Julgamento.findByData", query = "SELECT j FROM Julgamento j WHERE j.data = :data")})
public class Julgamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idJulgamento;
    @Column(length = 45)
    private String tribunal;
    @Temporal(TemporalType.DATE)
    private Date data;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "julgamento")
    private List<EJulgado> eJulgadoList;

    public Julgamento() {
    }

    public Julgamento(Integer idJulgamento) {
        this.idJulgamento = idJulgamento;
    }

    public Integer getIdJulgamento() {
        return idJulgamento;
    }

    public void setIdJulgamento(Integer idJulgamento) {
        this.idJulgamento = idJulgamento;
    }

    public String getTribunal() {
        return tribunal;
    }

    public void setTribunal(String tribunal) {
        this.tribunal = tribunal;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<EJulgado> getEJulgadoList() {
        return eJulgadoList;
    }

    public void setEJulgadoList(List<EJulgado> eJulgadoList) {
        this.eJulgadoList = eJulgadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJulgamento != null ? idJulgamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Julgamento)) {
            return false;
        }
        Julgamento other = (Julgamento) object;
        if ((this.idJulgamento == null && other.idJulgamento != null) || (this.idJulgamento != null && !this.idJulgamento.equals(other.idJulgamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITY.Julgamento[ idJulgamento=" + idJulgamento + " ]";
    }
    
}
