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
public class FunTurnoPK implements Serializable {

    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String turno;
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String numBI;

    public FunTurnoPK() {
    }

    public FunTurnoPK(String turno, String numBI) {
        this.turno = turno;
        this.numBI = numBI;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getNumBI() {
        return numBI;
    }

    public void setNumBI(String numBI) {
        this.numBI = numBI;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (turno != null ? turno.hashCode() : 0);
        hash += (numBI != null ? numBI.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FunTurnoPK)) {
            return false;
        }
        FunTurnoPK other = (FunTurnoPK) object;
        if ((this.turno == null && other.turno != null) || (this.turno != null && !this.turno.equals(other.turno))) {
            return false;
        }
        if ((this.numBI == null && other.numBI != null) || (this.numBI != null && !this.numBI.equals(other.numBI))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITY.FunTurnoPK[ turno=" + turno + ", numBI=" + numBI + " ]";
    }
    
}
