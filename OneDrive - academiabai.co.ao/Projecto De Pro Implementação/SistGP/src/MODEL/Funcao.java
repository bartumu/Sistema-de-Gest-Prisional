/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author Melhor De Mim
 */
public class Funcao {
    private String funcao;
    private Funcionario funcionario;

    public Funcao() {
    }

    public Funcao(String funcao, Funcionario funcionario) {
        this.funcao = funcao;
        this.funcionario = funcionario;
    }
    
    

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

   
    
    
}
