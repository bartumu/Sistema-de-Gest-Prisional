/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Melhor De Mim
 */
@Entity
@Table(name = "pris_pertences")
@NamedQueries({
    @NamedQuery(name = "PrisPertences.findAll", query = "SELECT p FROM PrisPertences p"),
    @NamedQuery(name = "PrisPertences.findByPertences", query = "SELECT p FROM PrisPertences p WHERE p.pertences = :pertences"),
    @NamedQuery(name = "PrisPertences.findByNumBI", query = "SELECT p FROM PrisPertences p WHERE p.numBI = :numBI")})
public class PrisPertences implements Serializable {

    private static final long serialVersionUID = 1L;
    private String pertences;
    @Id
    @Basic(optional = false)
    private String numBI;
    @JoinColumn(name = "numBI", referencedColumnName = "numBI", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Prisioneiro prisioneiro;

    public PrisPertences() {
    }

    public PrisPertences(String numBI) {
        this.numBI = numBI;
    }

    public String getPertences() {
        return pertences;
    }

    public void setPertences(String pertences) {
        this.pertences = pertences;
    }

    public String getNumBI() {
        return numBI;
    }

    public void setNumBI(String numBI) {
        this.numBI = numBI;
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
        hash += (numBI != null ? numBI.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrisPertences)) {
            return false;
        }
        PrisPertences other = (PrisPertences) object;
        if ((this.numBI == null && other.numBI != null) || (this.numBI != null && !this.numBI.equals(other.numBI))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MODEL.PrisPertences[ numBI=" + numBI + " ]";
    }
    
}
