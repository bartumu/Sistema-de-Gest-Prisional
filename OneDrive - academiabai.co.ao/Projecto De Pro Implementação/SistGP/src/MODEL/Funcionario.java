/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Melhor De Mim
 */
@Entity
@Table(name = "funcionario")
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
    @Column(name = "numBI")
    private String numBI;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "endereco")
    private String endereco;
    @Basic(optional = false)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @Column(name = "estadoCivil")
    private String estadoCivil;
    @Basic(optional = false)
    @Column(name = "dataNasc")
    @Temporal(TemporalType.DATE)
    private String dataNasc;
    @Basic(optional = false)
    @Column(name = "dataAdimissao")
    @Temporal(TemporalType.DATE)
    private String dataAdimissao;
    @JoinColumn(name = "idBloco", referencedColumnName = "idBloco")
    @ManyToOne
    private Bloco idBloco;
    @JoinColumn(name = "idFuncao", referencedColumnName = "idFuncao")
    @ManyToOne
    private Funcao idFuncao;
    @JoinColumn(name = "idTurno", referencedColumnName = "idTurno")
    @ManyToOne
    private Turno idTurno;

    public Funcionario() {
    }

    public Funcionario(String numBI) {
        this.numBI = numBI;
    }

    public Funcionario(String numBI, String nome, String endereco, String sexo, String estadoCivil, String dataNasc, String dataAdimissao) {
        this.numBI = numBI;
        this.nome = nome;
        this.endereco = endereco;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.dataNasc = dataNasc;
        this.dataAdimissao = dataAdimissao;
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

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getDataAdimissao() {
        return dataAdimissao;
    }

    public void setDataAdimissao(String dataAdimissao) {
        this.dataAdimissao = dataAdimissao;
    }

    public Bloco getIdBloco() {
        return idBloco;
    }

    public void setIdBloco(Bloco idBloco) {
        this.idBloco = idBloco;
    }

    public Funcao getIdFuncao() {
        return idFuncao;
    }

    public void setIdFuncao(Funcao idFuncao) {
        this.idFuncao = idFuncao;
    }

    public Turno getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Turno idTurno) {
        this.idTurno = idTurno;
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
        return "MODEL.Funcionario[ numBI=" + numBI + " ]";
    }
    
}
