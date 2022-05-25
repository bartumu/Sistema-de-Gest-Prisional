/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author Melhor De Mim
 */
public class Prisioneiro extends Cidadao{
    private Crime crime;
    private String dataEntrada;
    private String descricao;
    private Cela cela;

    public Prisioneiro() {
    }

    public Prisioneiro(Crime crime, String dataEntrada, String descricao, Cela cela, String numBI, String nome, String dataNasc, String estadoCivil, String sexo) {
        super(numBI, nome, dataNasc, estadoCivil, sexo);
        this.crime = crime;
        this.dataEntrada = dataEntrada;
        this.descricao = descricao;
        this.cela = cela;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    

    
    
    

    public Crime getCrime() {
        return crime;
    }

    public void setCrime(Crime crime) {
        this.crime = crime;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Cela getCela() {
        return cela;
    }

    public void setCela(Cela cela) {
        this.cela = cela;
    }
    
    
}
