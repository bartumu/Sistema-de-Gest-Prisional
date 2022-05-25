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
public class UsuarioPK implements Serializable {

    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String senha;
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String numBI;

    public UsuarioPK() {
    }

    public UsuarioPK(String senha, String numBI) {
        this.senha = senha;
        this.numBI = numBI;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
        hash += (senha != null ? senha.hashCode() : 0);
        hash += (numBI != null ? numBI.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioPK)) {
            return false;
        }
        UsuarioPK other = (UsuarioPK) object;
        if ((this.senha == null && other.senha != null) || (this.senha != null && !this.senha.equals(other.senha))) {
            return false;
        }
        if ((this.numBI == null && other.numBI != null) || (this.numBI != null && !this.numBI.equals(other.numBI))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITY.UsuarioPK[ senha=" + senha + ", numBI=" + numBI + " ]";
    }
    
}
