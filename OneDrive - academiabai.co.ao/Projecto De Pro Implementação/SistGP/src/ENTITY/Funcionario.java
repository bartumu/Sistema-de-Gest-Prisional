/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Melhor De Mim
 */
@Entity
@Table(catalog = "sistgp", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"numBI"})})
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findByNumBI", query = "SELECT f FROM Funcionario f WHERE f.numBI = :numBI"),
    @NamedQuery(name = "Funcionario.findByNome", query = "SELECT f FROM Funcionario f WHERE f.nome = :nome"),
    @NamedQuery(name = "Funcionario.findByEndereco", query = "SELECT f FROM Funcionario f WHERE f.endereco = :endereco"),
    @NamedQuery(name = "Funcionario.findBySexo", query = "SELECT f FROM Funcionario f WHERE f.sexo = :sexo"),
    @NamedQuery(name = "Funcionario.findByEstadoCivil", query = "SELECT f FROM Funcionario f WHERE f.estadoCivil = :estadoCivil"),
    @NamedQuery(name = "Funcionario.findByDataNasc", query = "SELECT f FROM Funcionario f WHERE f.dataNasc = :dataNasc"),
    @NamedQuery(name = "Funcionario.findByDataAdimissao", query = "SELECT f FROM Funcionario f WHERE f.dataAdimissao = :dataAdimissao")})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String numBI;
    @Column(length = 45)
    private String nome;
    @Column(length = 45)
    private String endereco;
    @Column(length = 9)
    private String sexo;
    @Column(length = 45)
    private String estadoCivil;
    @Temporal(TemporalType.DATE)
    private Date dataNasc;
    @Temporal(TemporalType.DATE)
    private Date dataAdimissao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario")
    private List<FunTurno> funTurnoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario")
    private List<Usuario> usuarioList;
    @JoinColumn(name = "idBloco", referencedColumnName = "idBloco", nullable = false)
    @ManyToOne(optional = false)
    private Bloco idBloco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario")
    private List<FunFuncao> funFuncaoList;

    public Funcionario() {
    }

    public Funcionario(String numBI) {
        this.numBI = numBI;
    }

    public String getNumBI() {
        return numBI;
    }

    public void setNumBI(String numBI) {
        this.numBI = numBI;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Date getDataAdimissao() {
        return dataAdimissao;
    }

    public void setDataAdimissao(Date dataAdimissao) {
        this.dataAdimissao = dataAdimissao;
    }

    public List<FunTurno> getFunTurnoList() {
        return funTurnoList;
    }

    public void setFunTurnoList(List<FunTurno> funTurnoList) {
        this.funTurnoList = funTurnoList;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Bloco getIdBloco() {
        return idBloco;
    }

    public void setIdBloco(Bloco idBloco) {
        this.idBloco = idBloco;
    }

    public List<FunFuncao> getFunFuncaoList() {
        return funFuncaoList;
    }

    public void setFunFuncaoList(List<FunFuncao> funFuncaoList) {
        this.funFuncaoList = funFuncaoList;
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
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.numBI == null && other.numBI != null) || (this.numBI != null && !this.numBI.equals(other.numBI))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITY.Funcionario[ numBI=" + numBI + " ]";
    }
    
}
