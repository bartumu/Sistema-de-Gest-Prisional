/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import MODEL.Bloco;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Melhor De Mim
 */
public class BlocoController extends CRUDController {

    public BlocoController() {
        super("bloco", "idBloco");
        super.setInserirQuery(String.format("INSERT INTO %s (descricao) values (?)", this.tabela));
        super.setAtualizarQuery(String.format("UPDATE %s SET descricao = ? WHERE idBloco = ?", this.tabela));
        super.setDeletarQuery(String.format("DELETE FROM %s WHERE %s = ?", this.tabela, this.idTabela));
        super.setSelecionarQuery(String.format("SELECT * FROM %s", this.tabela));
        super.setSeleccaoPersonalizadoQuery(String.format("SELECT idBloco FROM %s WHERE descricao = ?", this.tabela));
    }

    @Override
    public void Inserir(Object object) {
        Bloco bloco = (Bloco) object;
        super.Inserir(bloco);
    }

    @Override
    public void Actualizar(Object object) {
        Bloco bloco = (Bloco) object;
        super.Actualizar(bloco); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void setValoresQuery(PreparedStatement stmt, Object object, boolean update) throws SQLException {
        Bloco bloco = (Bloco) object;
        if (update == true) {
            stmt.setString(1, bloco.getDescricao());
            stmt.setInt(2, bloco.getIdBloco());
        } else {
            stmt.setString(1, bloco.getDescricao());
        }

    }

    @Override
    protected ArrayList criarObjecto(ResultSet rs, boolean all) throws SQLException {
        ArrayList<Bloco> bLista = new ArrayList<>();
        if (all = true) {
            while (rs.next()) {

                Bloco b = new Bloco();
                b.setIdBloco(rs.getInt("idBloco"));
                b.setDescricao(rs.getString("descricao"));

                bLista.add(b);
            }
            System.out.println("");
            return bLista;
        } else {
            rs.next();
            Bloco b = new Bloco();
            b.setIdBloco(rs.getInt("idBloco"));
            b.setDescricao(rs.getString("descricao"));

            bLista.add(b);
            return bLista;
        }
    }

    @Override
    public ArrayList<Bloco> findAll() {
        return (ArrayList<Bloco>) super.getObjectos(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public ArrayList<Bloco> find(Object object) {
        Bloco b = (Bloco) object;
        return (ArrayList<Bloco>) super.getObjectosPersonalizados(b); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public ArrayList<Bloco> Find(int id) {
        return super.Find(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public static void main(String[] args) {
        BlocoController bc = new BlocoController();
        Bloco b = new Bloco();
//        b.setIdBloco(7);
        b.setDescricao("B61");
        bc.Delete(6);
//        System.out.println(" " + bc.Find(10).get(0).getDescricao());
    }

    public int FindId(Bloco b) {
        this.AbrirConexao();
        String sql = String.format("SELECT idBloco FROM %s WHERE descricao = ?", this.tabela);
        try ( PreparedStatement stmt = this.conex.prepareStatement(sql)) {
            stmt.setString(1, b.getDescricao());
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            rs.next();
             return rs.getInt("idBloco");
            
        } catch (SQLException ex) {
            this.FecharConexao();
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    protected void setValoresQueryPersonalizado(PreparedStatement stmt, Object object) throws SQLException {
        Bloco b = (Bloco) object;
        stmt.setString(1, b.getDescricao());
    }

    @Override
    protected ArrayList criarObjectoPersonalizado(ResultSet rs) throws SQLException {
        ArrayList<Bloco> bLista = new ArrayList<>();
        var b = new Bloco();
        rs.next();
        b.setIdBloco(rs.getInt("idBloco"));
        bLista.add(b);
        return bLista;
    }

    public void CarregarTabela(DefaultTableModel tbModelB, JTable tblBloco) {
        Object[] columnNames = {"Descrição"};
        var bController = new BlocoController();
        tbModelB.setColumnIdentifiers(columnNames);
        for (int i = 0; i < bController.findAll().size(); i++) {

            Object[] lista = {
                bController.findAll().get(i).getDescricao()
            };

            tbModelB.addRow(lista);
        }
        tblBloco.setModel(tbModelB);
    }

}
