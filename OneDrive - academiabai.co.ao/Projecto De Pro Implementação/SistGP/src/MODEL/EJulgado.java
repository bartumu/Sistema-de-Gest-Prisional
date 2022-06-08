/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Melhor De Mim
 */
@Entity
@Table(name = "e_julgado")
@NamedQueries({
    @NamedQuery(name = "EJulgado.findAll", query = "SELECT e FROM EJulgado e"),
    @NamedQuery(name = "EJulgado.findByNumBI", query = "SELECT e FROM EJulgado e WHERE e.eJulgadoPK.numBI = :numBI"),
    @NamedQuery(name = "EJulgado.findByIdJulgamento", query = "SELECT e FROM EJulgado e WHERE e.eJulgadoPK.idJulgamento = :idJulgamento"),
    @NamedQuery(name = "EJulgado.findByPena", query = "SELECT e FROM EJulgado e WHERE e.pena = :pena")})
public class EJulgado implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EJulgadoPK eJulgadoPK;
    @Basic(optional = false)
    private String pena;
    @JoinColumn(name = "idJulgamento", referencedColumnName = "idJulgamento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Julgamento julgamento;
    @JoinColumn(name = "numBI", referencedColumnName = "numBI", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Prisioneiro prisioneiro;

    public EJulgado() {
    }

    public EJulgado(EJulgadoPK eJulgadoPK) {
        this.eJulgadoPK = eJulgadoPK;
    }

    public EJulgado(EJulgadoPK eJulgadoPK, String pena) {
        this.eJulgadoPK = eJulgadoPK;
        this.pena = pena;
    }

    public EJulgado(String numBI, int idJulgamento) {
        this.eJulgadoPK = new EJulgadoPK(numBI, idJulgamento);
    }

    public EJulgadoPK getEJulgadoPK() {
        return eJulgadoPK;
    }

    public void setEJulgadoPK(EJulgadoPK eJulgadoPK) {
        this.eJulgadoPK = eJulgadoPK;
    }

    public String getPena() {
        return pena;
    }

    public void setPena(String pena) {
        this.pena = pena;
    }

    public Julgamento getJulgamento() {
        return julgamento;
    }

    public void setJulgamento(Julgamento julgamento) {
        this.julgamento = julgamento;
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
        hash += (eJulgadoPK != null ? eJulgadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EJulgado)) {
            return false;
        }
        EJulgado other = (EJulgado) object;
        if ((this.eJulgadoPK == null && other.eJulgadoPK != null) || (this.eJulgadoPK != null && !this.eJulgadoPK.equals(other.eJulgadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MODEL.EJulgado[ eJulgadoPK=" + eJulgadoPK + " ]";
    }
    
}
