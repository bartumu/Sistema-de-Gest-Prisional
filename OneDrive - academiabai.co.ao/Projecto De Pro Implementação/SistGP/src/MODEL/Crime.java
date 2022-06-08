/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author Melhor De Mim
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Crime.findAll", query = "SELECT c FROM Crime c"),
    @NamedQuery(name = "Crime.findByData", query = "SELECT c FROM Crime c WHERE c.crimePK.data = :data"),
    @NamedQuery(name = "Crime.findByDescricao", query = "SELECT c FROM Crime c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "Crime.findByNumBI", query = "SELECT c FROM Crime c WHERE c.crimePK.numBI = :numBI")})
public class Crime implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CrimePK crimePK;
    @Basic(optional = false)
    private String descricao;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "crime")
    private CrimeLocal crimeLocal;
    @JoinColumn(name = "idEsquadra", referencedColumnName = "idEsquadra")
    @ManyToOne(optional = false)
    private Esquadra idEsquadra;
    @JoinColumn(name = "numBI", referencedColumnName = "numBI", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Prisioneiro prisioneiro;

    public Crime() {
    }

    public Crime(CrimePK crimePK) {
        this.crimePK = crimePK;
    }

    public Crime(CrimePK crimePK, String descricao) {
        this.crimePK = crimePK;
        this.descricao = descricao;
    }

    public Crime(String data, String numBI) {
        this.crimePK = new CrimePK(data, numBI);
    }

    public CrimePK getCrimePK() {
        return crimePK;
    }

    public void setCrimePK(CrimePK crimePK) {
        this.crimePK = crimePK;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CrimeLocal getCrimeLocal() {
        return crimeLocal;
    }

    public void setCrimeLocal(CrimeLocal crimeLocal) {
        this.crimeLocal = crimeLocal;
    }

    public Esquadra getIdEsquadra() {
        return idEsquadra;
    }

    public void setIdEsquadra(Esquadra idEsquadra) {
        this.idEsquadra = idEsquadra;
    }

    public Prisioneiro getPrisioneiro() {
        return prisioneiro;
    }

    public void setPrisioneiro(Prisioneiro prisioneiro) {
        this.prisioneiro = prisioneiro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (crimePK != null ? crimePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Crime)) {
            return false;
        }
        Crime other = (Crime) object;
        if ((this.crimePK == null && other.crimePK != null) || (this.crimePK != null && !this.crimePK.equals(other.crimePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MODEL.Crime[ crimePK=" + crimePK + " ]";
    }
    
}
