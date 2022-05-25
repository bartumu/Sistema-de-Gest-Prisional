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
public class FunFuncaoPK implements Serializable {

    @Basic(optional = false)
    @Column(nullable = false, length = 43)
    private String funcao;
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String numBI;

    public FunFuncaoPK() {
    }

    public FunFuncaoPK(String funcao, String numBI) {
        this.funcao = funcao;
        this.numBI = numBI;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
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
        hash += (funcao != null ? funcao.hashCode() : 0);
        hash += (numBI != null ? numBI.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FunFuncaoPK)) {
            return false;
        }
        FunFuncaoPK other = (FunFuncaoPK) object;
        if ((this.funcao == null && other.funcao != null) || (this.funcao != null && !this.funcao.equals(other.funcao))) {
            return false;
        }
        if ((this.numBI == null && other.numBI != null) || (this.numBI != null && !this.numBI.equals(other.numBI))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITY.FunFuncaoPK[ funcao=" + funcao + ", numBI=" + numBI + " ]";
    }
    
}
