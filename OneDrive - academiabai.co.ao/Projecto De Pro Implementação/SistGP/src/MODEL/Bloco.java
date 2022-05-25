/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author Melhor De Mim
 */
public class Bloco {
//    private int idBloco;
    private String descricao;
    private int idBloco;

    public Bloco() {
    }

    public Bloco(String descricao) {
//        this.idBloco = idBloco;
        this.descricao = descricao;
    }
    
       

//    public int getIdBloco() {
//        return idBloco;
//    }
//
//    public void setIdBloco(int idBloco) {
//        this.idBloco = idBloco;
//    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdBloco() {
        return idBloco;
    }

    public void setIdBloco(int idBloco) {
        this.idBloco = idBloco;
    }
    
    
}
