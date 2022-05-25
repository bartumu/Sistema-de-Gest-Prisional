/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author Melhor De Mim
 */
public class Cidadao {
    private String numBI;
    private String nome;
    private String dataNasc;
    private String estadoCivil;
    private String sexo;

    public Cidadao() {
    }

    public Cidadao(String numBI, String nome, String dataNasc, String estadoCivil, String sexo) {
        this.numBI = numBI;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
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

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
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
    
    
    
}
