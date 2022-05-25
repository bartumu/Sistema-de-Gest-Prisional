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
public class CelaPK implements Serializable {

    @Basic(optional = false)
    @Column(nullable = false, length = 10)
    private String descricao;
    @Basic(optional = false)
    @Column(nullable = false)
    private int idBloco;

    public CelaPK() {
    }

    public CelaPK(String descricao, int idBloco) {
        this.descricao = descricao;
        this.idBloco = idBloco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdBloco() {
        return idBloco;
    }

    public void setIdBloco(int idBloco) {
        this.idBloco = idBloco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (descricao != null ? descricao.hashCode() : 0);
        hash += (int) idBloco;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CelaPK)) {
            return false;
        }
        CelaPK other = (CelaPK) object;
        if ((this.descricao == null && other.descricao != null) || (this.descricao != null && !this.descricao.equals(other.descricao))) {
            return false;
        }
        if (this.idBloco != other.idBloco) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITY.CelaPK[ descricao=" + descricao + ", idBloco=" + idBloco + " ]";
    }
    
}
