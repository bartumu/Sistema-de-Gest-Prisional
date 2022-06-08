/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import MODEL.Turno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Melhor De Mim
 */
public class TurnoController extends CRUDController {

    public TurnoController() {
        super("turno", "idTurno");
        super.setInserirQuery(String.format("INSERT INTO %s (turno) values (?)", this.tabela));
        super.setAtualizarQuery(String.format("UPDATE %s SET turno = ? WHERE %s = ?", this.tabela, this.idTabela));
        super.setDeletarQuery(String.format("DELETE FROM %s WHERE %s = ?", this.tabela, this.idTabela));
        super.setSelecionarQuery(String.format("SELECT * FROM %s", this.tabela));
    }

    @Override
    protected void setValoresQuery(PreparedStatement stmt, Object object, boolean update) throws SQLException {
        Turno t = (Turno) object;
        if (update) {
            stmt.setString(1, t.getTurno());
            stmt.setInt(2, t.getIdTurno());
        } else {
            stmt.setString(1, t.getTurno());
        }
    }

    @Override
    protected ArrayList<Turno> criarObjecto(ResultSet rs, boolean all) throws SQLException {
        ArrayList<Turno> tLista = new ArrayList<>();
        if (all) {
            while (rs.next()) {
                var t = new Turno();
                t.setIdTurno(rs.getInt("idTurno"));
                t.setTurno(rs.getString("turno"));
                tLista.add(t);
            }
            return tLista;
        } else {
            rs.next();
            var t = new Turno();
            t.setIdTurno(rs.getInt("idTurno"));
            t.setTurno("turno");
            tLista.add(t);
            return tLista;
        }
    }

    @Override
    public void Inserir(Object object) {
        Turno t = (Turno) object;
        super.Inserir(t); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void Actualizar(Object object) {
        Turno t = (Turno) object;
        super.Actualizar(t); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void Delete(int id) {
        super.Delete(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    

    @Override
    public ArrayList Find(int id) {
        return super.Find(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public ArrayList<Turno> findAll() {
        return (ArrayList<Turno>) super.getObjectos(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected ArrayList criarObjectoPersonalizado(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void setValoresQueryPersonalizado(PreparedStatement stmt, Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void CarregarTabela(DefaultTableModel tbModelT, JTable tblTurno) {
        
        Object[] columnNames = {"Descrição"};
        var tController = new TurnoController();
        tbModelT.setColumnIdentifiers(columnNames);
        for (int i = 0; i < tController.findAll().size(); i++) {

            Object[] lista = {
                tController.findAll().get(i).getTurno()
            };

            tbModelT.addRow(lista);
        }
        tblTurno.setModel(tbModelT);
    }
    
    public int FindId(String turno) {
        boolean all = false;
        this.AbrirConexao();
        String sql = String.format("SELECT idTurno FROM %s WHERE turno = ?", this.tabela);
        try ( PreparedStatement stmt = this.conex.prepareStatement(sql)) {
            stmt.setString(1, turno);
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt("idTurno");
        } catch (SQLException ex) {
            this.FecharConexao();
            ex.printStackTrace();
            return 0;
        }
    }

}
