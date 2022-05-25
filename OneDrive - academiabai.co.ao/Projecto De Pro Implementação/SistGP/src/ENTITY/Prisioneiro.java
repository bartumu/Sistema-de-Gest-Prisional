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
import javax.persistence.OneToOne;
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
    @NamedQuery(name = "Prisioneiro.findAll", query = "SELECT p FROM Prisioneiro p"),
    @NamedQuery(name = "Prisioneiro.findByNumBI", query = "SELECT p FROM Prisioneiro p WHERE p.numBI = :numBI"),
    @NamedQuery(name = "Prisioneiro.findByNome", query = "SELECT p FROM Prisioneiro p WHERE p.nome = :nome"),
    @NamedQuery(name = "Prisioneiro.findByEndereco", query = "SELECT p FROM Prisioneiro p WHERE p.endereco = :endereco"),
    @NamedQuery(name = "Prisioneiro.findByEstadoCivil", query = "SELECT p FROM Prisioneiro p WHERE p.estadoCivil = :estadoCivil"),
    @NamedQuery(name = "Prisioneiro.findBySexo", query = "SELECT p FROM Prisioneiro p WHERE p.sexo = :sexo"),
    @NamedQuery(name = "Prisioneiro.findByDataEntrada", query = "SELECT p FROM Prisioneiro p WHERE p.dataEntrada = :dataEntrada"),
    @NamedQuery(name = "Prisioneiro.findByDataNasc", query = "SELECT p FROM Prisioneiro p WHERE p.dataNasc = :dataNasc")})
public class Prisioneiro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String numBI;
    @Column(length = 45)
    private String nome;
    @Column(length = 45)
    private String endereco;
    @Column(length = 45)
    private String estadoCivil;
    @Column(length = 45)
    private String sexo;
    @Temporal(TemporalType.DATE)
    private Date dataEntrada;
    @Temporal(TemporalType.DATE)
    private Date dataNasc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prisioneiro")
    private List<EJulgado> eJulgadoList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "prisioneiro")
    private PrisPertences prisPertences;
    @JoinColumn(name = "idBloco", referencedColumnName = "idBloco", nullable = false)
    @ManyToOne(optional = false)
    private Cela idBloco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prisioneiro")
    private List<Crime> crimeList;

    public Prisioneiro() {
    }

    public Prisioneiro(String numBI) {
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

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public List<EJulgado> getEJulgadoList() {
        return eJulgadoList;
    }

    public void setEJulgadoList(List<EJulgado> eJulgadoList) {
        this.eJulgadoList = eJulgadoList;
    }

    public PrisPertences getPrisPertences() {
        return prisPertences;
    }

    public void setPrisPertences(PrisPertences prisPertences) {
        this.prisPertences = prisPertences;
    }

    public Cela getIdBloco() {
        return idBloco;
    }

    public void setIdBloco(Cela idBloco) {
        this.idBloco = idBloco;
    }

    public List<Crime> getCrimeList() {
        return crimeList;
    }

    public void setCrimeList(List<Crime> crimeList) {
        this.crimeList = crimeList;
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
        if (!(object instanceof Prisioneiro)) {
            return false;
        }
        Prisioneiro other = (Prisioneiro) object;
        if ((this.numBI == null && other.numBI != null) || (this.numBI != null && !this.numBI.equals(other.numBI))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITY.Prisioneiro[ numBI=" + numBI + " ]";
    }
    
}
