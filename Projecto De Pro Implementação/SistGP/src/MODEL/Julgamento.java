/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Melhor De Mim
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Julgamento.findAll", query = "SELECT j FROM Julgamento j"),
    @NamedQuery(name = "Julgamento.findByIdJulgamento", query = "SELECT j FROM Julgamento j WHERE j.julgamentoPK.idJulgamento = :idJulgamento"),
    @NamedQuery(name = "Julgamento.findByTribunal", query = "SELECT j FROM Julgamento j WHERE j.julgamentoPK.tribunal = :tribunal"),
    @NamedQuery(name = "Julgamento.findByData", query = "SELECT j FROM Julgamento j WHERE j.julgamentoPK.data = :data")})
public class Julgamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected JulgamentoPK julgamentoPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "julgamento")
    private Collection<EJulgado> eJulgadoCollection;

    public Julgamento() {
    }

    public Julgamento(JulgamentoPK julgamentoPK) {
        this.julgamentoPK = julgamentoPK;
    }

    public Julgamento(int idJulgamento, String tribunal, String data) {
        this.julgamentoPK = new JulgamentoPK(idJulgamento, tribunal, data);
    }

    public JulgamentoPK getJulgamentoPK() {
        return julgamentoPK;
    }

    public void setJulgamentoPK(JulgamentoPK julgamentoPK) {
        this.julgamentoPK = julgamentoPK;
    }

    public Collection<EJulgado> getEJulgadoCollection() {
        return eJulgadoCollection;
    }

    public void setEJulgadoCollection(Collection<EJulgado> eJulgadoCollection) {
        this.eJulgadoCollection = eJulgadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (julgamentoPK != null ? julgamentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Julgamento)) {
            return false;
        }
        Julgamento other = (Julgamento) object;
        if ((this.julgamentoPK == null && other.julgamentoPK != null) || (this.julgamentoPK != null && !this.julgamentoPK.equals(other.julgamentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MODEL.Julgamento[ julgamentoPK=" + julgamentoPK + " ]";
    }
    
}
