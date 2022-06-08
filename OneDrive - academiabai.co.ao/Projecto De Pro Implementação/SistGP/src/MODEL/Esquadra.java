/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Melhor De Mim
 */
@Entity
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
    private Integer idEsquadra;
    @Basic(optional = false)
    private String descricao;
    @Basic(optional = false)
    private String local;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEsquadra")
    private Collection<Crime> crimeCollection;

    public Esquadra() {
    }

    public Esquadra(Integer idEsquadra) {
        this.idEsquadra = idEsquadra;
    }

    public Esquadra(Integer idEsquadra, String descricao, String local) {
        this.idEsquadra = idEsquadra;
        this.descricao = descricao;
        this.local = local;
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

    public Collection<Crime> getCrimeCollection() {
        return crimeCollection;
    }

    public void setCrimeCollection(Collection<Crime> crimeCollection) {
        this.crimeCollection = crimeCollection;
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
        return "MODEL.Esquadra[ idEsquadra=" + idEsquadra + " ]";
    }
    
}
