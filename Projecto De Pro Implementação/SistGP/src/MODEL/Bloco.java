/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "bloco")
@NamedQueries({
    @NamedQuery(name = "Bloco_1.findAll", query = "SELECT b FROM Bloco_1 b"),
    @NamedQuery(name = "Bloco_1.findByIdBloco", query = "SELECT b FROM Bloco_1 b WHERE b.idBloco = :idBloco"),
    @NamedQuery(name = "Bloco_1.findByDescricao", query = "SELECT b FROM Bloco_1 b WHERE b.descricao = :descricao")})
public class Bloco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBloco")
    private Integer idBloco;
    @Basic(optional = false)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "idBloco")
    private Collection<Funcionario> funcionarioCollection;

    public Bloco() {
    }

    public Bloco(Integer idBloco) {
        this.idBloco = idBloco;
    }

    public Bloco(Integer idBloco, String descricao) {
        this.idBloco = idBloco;
        this.descricao = descricao;
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

    public Collection<Funcionario> getFuncionarioCollection() {
        return funcionarioCollection;
    }

    public void setFuncionarioCollection(Collection<Funcionario> funcionarioCollection) {
        this.funcionarioCollection = funcionarioCollection;
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
        return "MODEL.Bloco_1[ idBloco=" + idBloco + " ]";
    }
    
}
