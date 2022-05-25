/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author Melhor De Mim
 */
public class E_Julgado {
    private Prisioneiro prisioneiro;
    private Julgamento julgamento;
    private String pena;

    public E_Julgado() {
    }

    public E_Julgado(Prisioneiro prisioneiro, Julgamento julgamento, String pena) {
        this.prisioneiro = prisioneiro;
        this.julgamento = julgamento;
        this.pena = pena;
    }

    public Prisioneiro getPrisioneiro() {
        return prisioneiro;
    }

    public void setPrisioneiro(Prisioneiro prisioneiro) {
        this.prisioneiro = prisioneiro;
    }

    public Julgamento getJulgamento() {
        return julgamento;
    }

    public void setJulgamento(Julgamento julgamento) {
        this.julgamento = julgamento;
    }

    public String getPena() {
        return pena;
    }

    public void setPena(String pena) {
        this.pena = pena;
    }
    
    
}
