/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author Melhor De Mim
 */
public class Julgamento {
    private int idJulgamento;
    private String tribunal;
    private String data;

    public Julgamento() {
    }

    public Julgamento(int idJulgamento, String tribunal, String data) {
        this.idJulgamento = idJulgamento;
        this.tribunal = tribunal;
        this.data = data;
    }

    public int getIdJulgamento() {
        return idJulgamento;
    }

    public void setIdJulgamento(int idJulgamento) {
        this.idJulgamento = idJulgamento;
    }

    public String getTribunal() {
        return tribunal;
    }

    public void setTribunal(String tribunal) {
        this.tribunal = tribunal;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
    
    
}
