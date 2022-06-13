/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Melhor De Mim
 */
@Entity
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
    private String numBI;
    @Basic(optional = false)
    private String nome;
    private String endereco;
    @Basic(optional = false)
    private String estadoCivil;
    @Basic(optional = false)
    private String sexo;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private String dataEntrada;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private String dataNasc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prisioneiro")
    private Collection<EJulgado> eJulgadoCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "prisioneiro")
    private PrisPertences prisPertences;
    @JoinColumn(name = "idBloco", referencedColumnName = "idBloco")
    @ManyToOne(optional = false)
    private Cela idBloco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prisioneiro")
    private Collection<Crime> crimeCollection;
    
    private Short estado;

    public Prisioneiro() {
    }

    public Prisioneiro(String numBI) {
        this.numBI = numBI;
    }

    public Prisioneiro(String numBI, String nome, String estadoCivil, String sexo, String dataEntrada, String dataNasc) {
        this.numBI = numBI;
        this.nome = nome;
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
        this.dataEntrada = dataEntrada;
        this.dataNasc = dataNasc;
    }

    public Short getEstado() {
        return estado;
    }

    public void setEstado(Short estado) {
        this.estado = estado;
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

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Collection<EJulgado> getEJulgadoCollection() {
        return eJulgadoCollection;
    }

    public void setEJulgadoCollection(Collection<EJulgado> eJulgadoCollection) {
        this.eJulgadoCollection = eJulgadoCollection;
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

    public Collection<Crime> getCrimeCollection() {
        return crimeCollection;
    }

    public void setCrimeCollection(Collection<Crime> crimeCollection) {
        this.crimeCollection = crimeCollection;
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
        return "MODEL.Prisioneiro[ numBI=" + numBI + " ]";
    }
    
}
