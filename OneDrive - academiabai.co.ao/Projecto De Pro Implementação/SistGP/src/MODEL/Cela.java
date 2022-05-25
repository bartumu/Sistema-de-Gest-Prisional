/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author Melhor De Mim
 */
public class Cela {
    private String descricao;
    private String tipoCela;
    private Bloco bloco;

    public Cela() {
    }

    public Cela(String descricao, String tipoCela, Bloco bloco) {
        this.descricao = descricao;
        this.tipoCela = tipoCela;
        this.bloco = bloco;
    }
    
    

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoCela() {
        return tipoCela;
    }

    public void setTipoCela(String tipoCela) {
        this.tipoCela = tipoCela;
    }

    public Bloco getBloco() {
        return bloco;
    }

    public void setBloco(Bloco bloco) {
        this.bloco = bloco;
    }
    
    
    
}
