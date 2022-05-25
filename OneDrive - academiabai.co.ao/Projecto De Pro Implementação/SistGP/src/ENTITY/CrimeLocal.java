/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
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
@Table(name = "crime_local", catalog = "sistgp", schema = "")
@NamedQueries({
    @NamedQuery(name = "CrimeLocal.findAll", query = "SELECT c FROM CrimeLocal c"),
    @NamedQuery(name = "CrimeLocal.findByLocal", query = "SELECT c FROM CrimeLocal c WHERE c.local = :local"),
    @NamedQuery(name = "CrimeLocal.findByNumBI", query = "SELECT c FROM CrimeLocal c WHERE c.numBI = :numBI")})
public class CrimeLocal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(length = 20)
    private String local;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String numBI;
    @JoinColumn(name = "numBI", referencedColumnName = "numBI", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Crime crime;

    public CrimeLocal() {
    }

    public CrimeLocal(String numBI) {
        this.numBI = numBI;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getNumBI() {
        return numBI;
    }

    public void setNumBI(String numBI) {
        this.numBI = numBI;
    }

    public Crime getCrime() {
        return crime;
    }

    public void setCrime(Crime crime) {
        this.crime = crime;
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
        if (!(object instanceof CrimeLocal)) {
            return false;
        }
        CrimeLocal other = (CrimeLocal) object;
        if ((this.numBI == null && other.numBI != null) || (this.numBI != null && !this.numBI.equals(other.numBI))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITY.CrimeLocal[ numBI=" + numBI + " ]";
    }
    
}
