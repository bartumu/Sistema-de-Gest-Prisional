/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Melhor De Mim
 */
@Entity
@Table(name = "fun_turno", catalog = "sistgp", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"turno"})})
@NamedQueries({
    @NamedQuery(name = "FunTurno.findAll", query = "SELECT f FROM FunTurno f"),
    @NamedQuery(name = "FunTurno.findByTurno", query = "SELECT f FROM FunTurno f WHERE f.funTurnoPK.turno = :turno"),
    @NamedQuery(name = "FunTurno.findByNumBI", query = "SELECT f FROM FunTurno f WHERE f.funTurnoPK.numBI = :numBI")})
public class FunTurno implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FunTurnoPK funTurnoPK;
    @JoinColumn(name = "numBI", referencedColumnName = "numBI", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Funcionario funcionario;

    public FunTurno() {
    }

    public FunTurno(FunTurnoPK funTurnoPK) {
        this.funTurnoPK = funTurnoPK;
    }

    public FunTurno(String turno, String numBI) {
        this.funTurnoPK = new FunTurnoPK(turno, numBI);
    }

    public FunTurnoPK getFunTurnoPK() {
        return funTurnoPK;
    }

    public void setFunTurnoPK(FunTurnoPK funTurnoPK) {
        this.funTurnoPK = funTurnoPK;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (funTurnoPK != null ? funTurnoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FunTurno)) {
            return false;
        }
        FunTurno other = (FunTurno) object;
        if ((this.funTurnoPK == null && other.funTurnoPK != null) || (this.funTurnoPK != null && !this.funTurnoPK.equals(other.funTurnoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITY.FunTurno[ funTurnoPK=" + funTurnoPK + " ]";
    }
    
}
