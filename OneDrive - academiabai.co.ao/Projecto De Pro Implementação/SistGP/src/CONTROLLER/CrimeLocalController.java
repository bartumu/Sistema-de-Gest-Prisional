/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import MODEL.CrimeLocal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Melhor De Mim
 */
public class CrimeLocalController extends CRUDController {

    public CrimeLocalController() {
        super("crime_local", "numBI");
        super.setInserirQuery(String.format("INSERT INTO %s (local,numBI) values (?,?)", this.tabela));
        super.setAtualizarQuery(String.format("UPDATE %s SET local = ? WHERE %s = ?", this.tabela, this.idTabela));
        super.setDeletarQuery(String.format("DELETE FROM %s WHERE %s = ?", this.tabela, this.idTabela));
        super.setSelecionarQuery(String.format("SELECT * FROM %s", this.tabela));

    }

    @Override
    protected void setValoresQuery(PreparedStatement stmt, Object object, boolean update) throws SQLException {
        CrimeLocal cl = (CrimeLocal) object;
        if (update) {
            stmt.setString(1, cl.getLocal());
            stmt.setString(2, cl.getNumBI());
        } else {
            stmt.setString(1, cl.getLocal());
            stmt.setString(2, cl.getNumBI());
        }
    }

    @Override
    protected ArrayList criarObjecto(ResultSet rs, boolean all) throws SQLException {
        ArrayList<CrimeLocal> clLista = new ArrayList<>();

        if (all) {
            while (rs.next()) {
                CrimeLocal cl = new CrimeLocal();
                cl.setLocal(rs.getString("local"));
                clLista.add(cl);
            }
            return clLista;
        } else {
            rs.next();
            CrimeLocal cl = new CrimeLocal();
            cl.setLocal(rs.getString("local"));
            clLista.add(cl);
            return clLista;
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
    public ArrayList<CrimeLocal> findAll() {
        return (ArrayList<CrimeLocal>)super.getObjectos(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public ArrayList Find(int id) {
        return super.Find(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public ArrayList<CrimeLocal> find(Object object) {
        CrimeLocal cl = (CrimeLocal) object;
        return (ArrayList<CrimeLocal>)super.getObjectosPersonalizados(cl); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void Inserir(Object object) {
        CrimeLocal cl = (CrimeLocal) object;
        super.Inserir(cl); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void Actualizar(Object object) {
        CrimeLocal cl = (CrimeLocal) object;
        super.Actualizar(cl); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void Delete(int id) {
        super.Delete(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
  
}
