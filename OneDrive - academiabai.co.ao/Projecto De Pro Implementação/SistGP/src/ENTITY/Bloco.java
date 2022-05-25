/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Melhor De Mim
 */
@Entity
@Table(catalog = "sistgp", schema = "")
@NamedQueries({
    @NamedQuery(name = "Bloco.findAll", query = "SELECT b FROM Bloco b"),
    @NamedQuery(name = "Bloco.findByIdBloco", query = "SELECT b FROM Bloco b WHERE b.idBloco = :idBloco"),
    @NamedQuery(name = "Bloco.findByDescricao", query = "SELECT b FROM Bloco b WHERE b.descricao = :descricao")})
public class Bloco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idBloco;
    @Column(length = 45)
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bloco")
    private List<Cela> celaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBloco")
    private List<Funcionario> funcionarioList;

    public Bloco() {
    }

    public Bloco(Integer idBloco) {
        this.idBloco = idBloco;
    }

    public Integer getIdBloco() {
        return idBloco;
    }

    public void setIdBloco(Integer idBloco) {
        this.idBloco = idBloco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Cela> getCelaList() {
        return celaList;
    }

    public void setCelaList(List<Cela> celaList) {
        this.celaList = celaList;
    }

    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBloco != null ? idBloco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bloco)) {
            return false;
        }
        Bloco other = (Bloco) object;
        if ((this.idBloco == null && other.idBloco != null) || (this.idBloco != null && !this.idBloco.equals(other.idBloco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITY.Bloco[ idBloco=" + idBloco + " ]";
    }
    
}
