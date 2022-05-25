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

/**
 *
 * @author Melhor De Mim
 */
@Entity
@Table(name = "fun_funcao", catalog = "sistgp", schema = "")
@NamedQueries({
    @NamedQuery(name = "FunFuncao.findAll", query = "SELECT f FROM FunFuncao f"),
    @NamedQuery(name = "FunFuncao.findByFuncao", query = "SELECT f FROM FunFuncao f WHERE f.funFuncaoPK.funcao = :funcao"),
    @NamedQuery(name = "FunFuncao.findByNumBI", query = "SELECT f FROM FunFuncao f WHERE f.funFuncaoPK.numBI = :numBI")})
public class FunFuncao implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FunFuncaoPK funFuncaoPK;
    @JoinColumn(name = "numBI", referencedColumnName = "numBI", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Funcionario funcionario;

    public FunFuncao() {
    }

    public FunFuncao(FunFuncaoPK funFuncaoPK) {
        this.funFuncaoPK = funFuncaoPK;
    }

    public FunFuncao(String funcao, String numBI) {
        this.funFuncaoPK = new FunFuncaoPK(funcao, numBI);
    }

    public FunFuncaoPK getFunFuncaoPK() {
        return funFuncaoPK;
    }

    public void setFunFuncaoPK(FunFuncaoPK funFuncaoPK) {
        this.funFuncaoPK = funFuncaoPK;
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
        hash += (funFuncaoPK != null ? funFuncaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FunFuncao)) {
            return false;
        }
        FunFuncao other = (FunFuncao) object;
        if ((this.funFuncaoPK == null && other.funFuncaoPK != null) || (this.funFuncaoPK != null && !this.funFuncaoPK.equals(other.funFuncaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITY.FunFuncao[ funFuncaoPK=" + funFuncaoPK + " ]";
    }
    
}
