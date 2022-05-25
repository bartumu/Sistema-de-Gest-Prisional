/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author Melhor De Mim
 */
public class Esquadra {
    private int idEsquadra;
    private String descricao;
    private String local;

    public Esquadra() {
    }

    public Esquadra(int idEsquadra, String descricao, String local) {
        this.idEsquadra = idEsquadra;
        this.descricao = descricao;
        this.local = local;
    }

    public int getIdEsquadra() {
        return idEsquadra;
    }

    public void setIdEsquadra(int idEsquadra) {
        this.idEsquadra = idEsquadra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
    
    
    
}
