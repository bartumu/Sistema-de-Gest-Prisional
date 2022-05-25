/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author Melhor De Mim
 */
public class Funcionario extends Cidadao {
    private String dataAdmissao;
    private Bloco bloco;

    public Funcionario() {
    }

    public Funcionario(String dataAdmissao, Bloco bloco, String numBI, String nome, String dataNasc, String estadoCivil, String sexo) {
        super(numBI, nome, dataNasc, estadoCivil, sexo);
        this.dataAdmissao = dataAdmissao;
        this.bloco = bloco;
    }
   
    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Bloco getBloco() {
        return bloco;
    }

    public void setBloco(Bloco bloco) {
        this.bloco = bloco;
    }
    
    
}
