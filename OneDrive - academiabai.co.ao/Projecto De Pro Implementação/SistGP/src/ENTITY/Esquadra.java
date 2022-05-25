/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

import java.io.Serializable;
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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Melhor De Mim
 */
@Entity
@Table(catalog = "sistgp", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idEsquadra"})})
@NamedQueries({
    @NamedQuery(name = "Esquadra.findAll", query = "SELECT e FROM Esquadra e"),
    @NamedQuery(name = "Esquadra.findByIdEsquadra", query = "SELECT e FROM Esquadra e WHERE e.idEsquadra = :idEsquadra"),
    @NamedQuery(name = "Esquadra.findByDescricao", query = "SELECT e FROM Esquadra e WHERE e.descricao = :descricao"),
    @NamedQuery(name = "Esquadra.findByLocal", query = "SELECT e FROM Esquadra e WHERE e.local = :local")})
public class Esquadra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idEsquadra;
    @Column(length = 45)
    private String descricao;
    @Column(length = 45)
    private String local;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEsquadra")
    private List<Crime> crimeList;

    public Esquadra() {
    }

    public Esquadra(Integer idEsquadra) {
        this.idEsquadra = idEsquadra;
    }

    public Integer getIdEsquadra() {
        return idEsquadra;
    }

    public void setIdEsquadra(Integer idEsquadra) {
        this.idEsquadra = idEsquadra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public List<Crime> getCrimeList() {
        return crimeList;
    }

    public void setCrimeList(List<Crime> crimeList) {
        this.crimeList = crimeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEsquadra != null ? idEsquadra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Esquadra)) {
            return false;
        }
        Esquadra other = (Esquadra) object;
        if ((this.idEsquadra == null && other.idEsquadra != null) || (this.idEsquadra != null && !this.idEsquadra.equals(other.idEsquadra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITY.Esquadra[ idEsquadra=" + idEsquadra + " ]";
    }
    
}
