/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Melhor De Mim
 */
@Entity
@Table(catalog = "sistgp", schema = "")
@NamedQueries({
    @NamedQuery(name = "Cela.findAll", query = "SELECT c FROM Cela c"),
    @NamedQuery(name = "Cela.findByDescricao", query = "SELECT c FROM Cela c WHERE c.celaPK.descricao = :descricao"),
    @NamedQuery(name = "Cela.findByIdBloco", query = "SELECT c FROM Cela c WHERE c.celaPK.idBloco = :idBloco"),
    @NamedQuery(name = "Cela.findByTipo", query = "SELECT c FROM Cela c WHERE c.tipo = :tipo")})
public class Cela implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CelaPK celaPK;
    @Column(length = 45)
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBloco")
    private List<Prisioneiro> prisioneiroList;
    @JoinColumn(name = "idBloco", referencedColumnName = "idBloco", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Bloco bloco;

    public Cela() {
    }

    public Cela(CelaPK celaPK) {
        this.celaPK = celaPK;
    }

    public Cela(String descricao, int idBloco) {
        this.celaPK = new CelaPK(descricao, idBloco);
    }

    public CelaPK getCelaPK() {
        return celaPK;
    }

    public void setCelaPK(CelaPK celaPK) {
        this.celaPK = celaPK;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Prisioneiro> getPrisioneiroList() {
        return prisioneiroList;
    }

    public void setPrisioneiroList(List<Prisioneiro> prisioneiroList) {
        this.prisioneiroList = prisioneiroList;
    }

    public Bloco getBloco() {
        return bloco;
    }

    public void setBloco(Bloco bloco) {
        this.bloco = bloco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (celaPK != null ? celaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cela)) {
            return false;
        }
        Cela other = (Cela) object;
        if ((this.celaPK == null && other.celaPK != null) || (this.celaPK != null && !this.celaPK.equals(other.celaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITY.Cela[ celaPK=" + celaPK + " ]";
    }
    
}
