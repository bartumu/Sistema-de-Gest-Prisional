/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Melhor De Mim
 */
@Embeddable
public class EJulgadoPK implements Serializable {

    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String numBI;
    @Basic(optional = false)
    @Column(nullable = false)
    private int idJulgamento;

    public EJulgadoPK() {
    }

    public EJulgadoPK(String numBI, int idJulgamento) {
        this.numBI = numBI;
        this.idJulgamento = idJulgamento;
    }

    public String getNumBI() {
        return numBI;
    }

    public void setNumBI(String numBI) {
        this.numBI = numBI;
    }

    public int getIdJulgamento() {
        return idJulgamento;
    }

    public void setIdJulgamento(int idJulgamento) {
        this.idJulgamento = idJulgamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numBI != null ? numBI.hashCode() : 0);
        hash += (int) idJulgamento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EJulgadoPK)) {
            return false;
        }
        EJulgadoPK other = (EJulgadoPK) object;
        if ((this.numBI == null && other.numBI != null) || (this.numBI != null && !this.numBI.equals(other.numBI))) {
            return false;
        }
        if (this.idJulgamento != other.idJulgamento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITY.EJulgadoPK[ numBI=" + numBI + ", idJulgamento=" + idJulgamento + " ]";
    }
    
}
