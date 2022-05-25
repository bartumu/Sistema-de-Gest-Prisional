/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author Melhor De Mim
 */
public class Crime {
    private Prisioneiro prisioneiro;
    private String data;
    private Pris_Pertence pertences;
    private Esquadra esquadra;

    public Crime() {
    }

    public Crime(Prisioneiro prisioneiro, String data, Pris_Pertence pertences, Esquadra esquadra) {
        this.prisioneiro = prisioneiro;
        this.data = data;
        this.pertences = pertences;
        this.esquadra = esquadra;
    }

    public Prisioneiro getPrisioneiro() {
        return prisioneiro;
    }

    public void setPrisioneiro(Prisioneiro prisioneiro) {
        this.prisioneiro = prisioneiro;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Pris_Pertence getPertences() {
        return pertences;
    }

    public void setPertences(Pris_Pertence pertences) {
        this.pertences = pertences;
    }

    public Esquadra getEsquadra() {
        return esquadra;
    }

    public void setEsquadra(Esquadra esquadra) {
        this.esquadra = esquadra;
    }

    
    
    
}
