/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import MODEL.Funcao;
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
public class FuncaoController extends CRUDController {

    public FuncaoController() {
        super("funcao", "idFuncao");
        super.setInserirQuery(String.format("INSERT INTO %s (funcao) values (?)", this.tabela));
        super.setAtualizarQuery(String.format("UPDATE %s SET funcao = ? WHERE %s = ?", this.tabela, this.idTabela));
        super.setDeletarQuery(String.format("DELETE FROM %s WHERE %s = ?", this.tabela, this.idTabela));
        super.setSelecionarQuery(String.format("SELECT * FROM %s", this.tabela));
    }

    @Override
    protected void setValoresQuery(PreparedStatement stmt, Object object, boolean update) throws SQLException {
        Funcao fun_funcao = (Funcao) object;
        if (update == true) {
            stmt.setString(1, fun_funcao.getFuncao());
            stmt.setInt(2, fun_funcao.getIdFuncao());
        } else {
            stmt.setString(1, fun_funcao.getFuncao());
        }
    }

    @Override
    public void Inserir(Object object) {
        Funcao fun_funcao = (Funcao) object;
        super.Inserir(fun_funcao); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected ArrayList<Funcao> criarObjecto(ResultSet rs, boolean all) throws SQLException {
        ArrayList<Funcao> fLista = new ArrayList<>();
        if (all) {
            while (rs.next()) {
                var f = new Funcao();
                f.setFuncao(rs.getString("funcao"));
                f.setIdFuncao(rs.getInt("idFuncao"));
                fLista.add(f);
            }
            return fLista;
        } else {
            rs.next();
            var f = new Funcao();
            f.setFuncao(rs.getString("funcao"));
            f.setIdFuncao(rs.getInt("idFuncao"));
            fLista.add(f);
            return fLista;
        }

    }

    @Override
    public ArrayList<Funcao> findAll() {
        return (ArrayList<Funcao>) super.getObjectos(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    
    
    @Override
    public ArrayList Find(String id) {
        return super.Find(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void setValoresQueryPersonalizado(PreparedStatement stmt, Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected ArrayList criarObjectoPersonalizado(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int FindId(Funcao f) {
        this.AbrirConexao();
        String sql = String.format("SELECT idFuncao FROM %s WHERE funcao = ?", this.tabela);
        try ( PreparedStatement stmt = this.conex.prepareStatement(sql)) {
            stmt.setString(1, f.getFuncao());
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            rs.next();
             return rs.getInt("idFuncao");
            
        } catch (SQLException ex) {
            this.FecharConexao();
            ex.printStackTrace();
            return 0;
        }
    }
    

    public void CarregarTabela(DefaultTableModel tbModelFunc, JTable tblFuncao) {
        Object[] columnNames = {"Descrição"};
        FuncaoController funcaoController = new FuncaoController();
        tbModelFunc.setColumnIdentifiers(columnNames);
        for (int i = 0; i < funcaoController.findAll().size(); i++) {

            Object[] lista = {
                funcaoController.findAll().get(i).getFuncao()
            };

            tbModelFunc.addRow(lista);
        }
        tblFuncao.setModel(tbModelFunc);
    }
}
