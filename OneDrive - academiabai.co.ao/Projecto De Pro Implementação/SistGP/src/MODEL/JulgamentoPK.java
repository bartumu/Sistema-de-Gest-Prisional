/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Melhor De Mim
 */
@Embeddable
public class JulgamentoPK implements Serializable {

    @Basic(optional = false)
    private int idJulgamento;
    @Basic(optional = false)
    private String tribunal;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private String data;

    public JulgamentoPK() {
    }

    public JulgamentoPK(int idJulgamento, String tribunal, String data) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idJulgamento;
        hash += (tribunal != null ? tribunal.hashCode() : 0);
        hash += (data != null ? data.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JulgamentoPK)) {
            return false;
        }
        JulgamentoPK other = (JulgamentoPK) object;
        if (this.idJulgamento != other.idJulgamento) {
            return false;
        }
        if ((this.tribunal == null && other.tribunal != null) || (this.tribunal != null && !this.tribunal.equals(other.tribunal))) {
            return false;
        }
        if ((this.data == null && other.data != null) || (this.data != null && !this.data.equals(other.data))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MODEL.JulgamentoPK[ idJulgamento=" + idJulgamento + ", tribunal=" + tribunal + ", data=" + data + " ]";
    }
    
}
