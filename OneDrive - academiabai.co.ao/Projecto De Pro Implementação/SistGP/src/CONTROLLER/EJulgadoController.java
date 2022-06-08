/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import MODEL.EJulgado;
import MODEL.EJulgadoPK;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Melhor De Mim
 */
public class EJulgadoController extends CRUDController {
    
    public EJulgadoController() {
        super("e_julgado", "numBI");
        super.setInserirQuery(String.format("INSERT INTO %s (numBI,idJulgamento,pena) values (?,?,?)", this.tabela));
        super.setAtualizarQuery(String.format("UPDATE %s SET idJulgamento = ?, pena = ? WHERE %s = ?", this.tabela, this.idTabela));
        super.setDeletarQuery(String.format("DELETE FROM %s WHERE %s = ?", this.tabela, this.idTabela));
        super.setSelecionarQuery(String.format("SELECT * FROM %s", this.tabela));
        
    }
    
    @Override
    protected void setValoresQuery(PreparedStatement stmt, Object object, boolean update) throws SQLException {
        EJulgado ej = (EJulgado) object;
        try {
        if (update) {
            stmt.setInt(1, ej.getEJulgadoPK().getIdJulgamento());
            stmt.setString(2, ej.getPena());
            stmt.setString(3, ej.getEJulgadoPK().getNumBI());
        } else {
            stmt.setString(1, ej.getEJulgadoPK().getNumBI());
            stmt.setInt(2, ej.getEJulgadoPK().getIdJulgamento());
            stmt.setString(3, ej.getPena());
        }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    @Override
    protected ArrayList criarObjecto(ResultSet rs, boolean all) throws SQLException {
        ArrayList<EJulgado> ejLista = new ArrayList<>();
        if (all) {
            while (rs.next()) {
                EJulgado ej = new EJulgado();
                EJulgadoPK ejulgadoPK = new EJulgadoPK();
                
                ejulgadoPK.setIdJulgamento(rs.getInt("idJulgamento"));
                ejulgadoPK.setNumBI(rs.getString("numBI"));
                ej.setEJulgadoPK(ejulgadoPK);
                ej.setPena(rs.getString("pena"));
                ejLista.add(ej);
            }
            return ejLista;
        } else {
            rs.next();
            EJulgado ej = new EJulgado();
            EJulgadoPK ejulgadoPK = new EJulgadoPK();
            
            ejulgadoPK.setIdJulgamento(rs.getInt("idJulgamento"));
            ejulgadoPK.setNumBI(rs.getString("numBI"));
            ej.setEJulgadoPK(ejulgadoPK);
            ej.setPena(rs.getString("pena"));
            ejLista.add(ej);
            return ejLista;
        }
    }

    @Override
    public ArrayList<EJulgado> Find(String id) {
        return super.Find(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    @Override
    protected ArrayList criarObjectoPersonalizado(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    protected void setValoresQueryPersonalizado(PreparedStatement stmt, Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public ArrayList find(Object object) {
        EJulgado ej = (EJulgado) object;
        return (ArrayList<EJulgado>) super.getObjectosPersonalizados(ej);
    }

    @Override
    public ArrayList Find(int id) {
        return super.Find(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    

    @Override
    public ArrayList<EJulgado> findAll() {
        return (ArrayList<EJulgado>) super.getObjectos(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void Actualizar(Object object) {
        EJulgado ej = (EJulgado) object;
        super.Actualizar(ej); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void Delete(int id) {
        super.Delete(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void Inserir(Object object) {
        EJulgado ej = (EJulgado) object;
        super.Inserir(ej); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    
   
}
