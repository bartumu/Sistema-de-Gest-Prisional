/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import MODEL.Crime;
import MODEL.CrimePK;
import MODEL.Esquadra;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Melhor De Mim
 */
public class CrimeController extends CRUDController {
    
    public CrimeController() {
        super("crime", "numBI");
        super.setInserirQuery(String.format("INSERT INTO %s (data,descricao,numBI,idEsquadra) values (?,?,?,?)", this.tabela));
        super.setAtualizarQuery(String.format("UPDATE %s SET data = ? , descricao = ?, idEsquadra = ? WHERE %s = ?", this.tabela, this.idTabela));
        super.setDeletarQuery(String.format("DELETE FROM %s WHERE %s = ?", this.tabela, this.idTabela));
        super.setSelecionarQuery(String.format("SELECT * FROM %s", this.tabela));
    }
    
    @Override
    protected void setValoresQuery(PreparedStatement stmt, Object object, boolean update) throws SQLException {
        Crime crime = (Crime) object;
        try {
            if (update == true) {
                stmt.setString(1, crime.getCrimePK().getData());
                stmt.setString(2, crime.getDescricao());
                stmt.setInt(3, crime.getIdEsquadra().getIdEsquadra());
                stmt.setString(4, crime.getCrimePK().getNumBI());
            } else {
                stmt.setString(1, crime.getCrimePK().getData());
                stmt.setString(2, crime.getDescricao());
                stmt.setString(3, crime.getCrimePK().getNumBI());
                stmt.setInt(4, crime.getIdEsquadra().getIdEsquadra());
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    @Override
    protected ArrayList<Crime> criarObjecto(ResultSet rs, boolean all) throws SQLException {
        ArrayList<Crime> crimeLista = new ArrayList<>();
        if (all) {
            while (rs.next()) {
                Crime crime = new Crime();
                CrimePK crimePK = new CrimePK();
                Esquadra esq = new Esquadra();
                
                crimePK.setData(rs.getDate("data").toString());
                crimePK.setNumBI(rs.getString("numBI"));
                crime.setCrimePK(crimePK);
                
                esq.setIdEsquadra(rs.getInt("idEsquadra"));
                crime.setIdEsquadra(esq);
                
                crime.setDescricao(rs.getString("descricao"));
                
                crimeLista.add(crime);
            }
            return crimeLista;
        } else {
            rs.next();
            Crime crime = new Crime();
            CrimePK crimePK = new CrimePK();
            Esquadra esq = new Esquadra();
            
            crimePK.setData(rs.getDate("data").toString());
            crimePK.setNumBI(rs.getString("numBI"));
            crime.setCrimePK(crimePK);
            
            esq.setIdEsquadra(rs.getInt("idEsquadra"));
            crime.setIdEsquadra(esq);
            
            crime.setDescricao(rs.getString("descricao"));
            
            crimeLista.add(crime);
            return crimeLista;
        }
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
    public ArrayList findAll() {
        return (ArrayList<Crime>) super.getObjectos(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    @Override
    public ArrayList Find(int id) {
        return super.Find(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public ArrayList<Crime> Find(String id) {
        return super.Find(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    
    @Override
    public ArrayList<Crime> find(Object object) {
        Crime c = (Crime) object;
        return (ArrayList<Crime>) super.getObjectosPersonalizados(c); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    @Override
    public void Actualizar(Object object) {
        Crime c = (Crime) object;
        super.Actualizar(c); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    @Override
    public void Inserir(Object object) {
        Crime c = (Crime) object;
        super.Inserir(c); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    @Override
    public void Delete(int id) {
        super.Delete(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
