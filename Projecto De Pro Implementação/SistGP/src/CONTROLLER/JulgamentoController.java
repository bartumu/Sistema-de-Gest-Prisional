/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import MODEL.Julgamento;
import MODEL.JulgamentoPK;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Melhor De Mim
 */
public class JulgamentoController extends CRUDController {

    public JulgamentoController() {
        super("julgamento", "idJulgamento");
        super.setInserirQuery(String.format("INSERT INTO %s (tribunal, data) values (?,?)", this.tabela));
        super.setAtualizarQuery(String.format("UPDATE %s SET tribunal = ?, data = ? WHERE idJulgamento = ?", this.tabela));
        super.setDeletarQuery(String.format("DELETE FROM %s WHERE %s = ?", this.tabela, this.idTabela));
        super.setSelecionarQuery(String.format("SELECT * FROM %s ", this.tabela));

    }

    @Override
    protected void setValoresQuery(PreparedStatement stmt, Object object, boolean update) throws SQLException {
        JulgamentoPK j = (JulgamentoPK) object;
        if (update) {
            stmt.setString(1, j.getTribunal());
            stmt.setString(2, j.getData());
            stmt.setInt(3, j.getIdJulgamento());
        } else {
            stmt.setString(1, j.getTribunal());
            stmt.setString(2, j.getData());
        }
    }

    @Override
    protected ArrayList<JulgamentoPK> criarObjecto(ResultSet rs, boolean all) throws SQLException {
        ArrayList<JulgamentoPK> jLista = new ArrayList<>();
        try {
            if (all) {
                while (rs.next()) {
                    var JPK = new JulgamentoPK();
                    JPK.setData(rs.getDate("data").toString());
                    JPK.setIdJulgamento(rs.getInt("idJulgamento"));
                    JPK.setTribunal(rs.getString("tribunal"));
                    jLista.add(JPK);
                }
                return jLista;
            } else {
                rs.next();
                var JPK = new JulgamentoPK();
                JPK.setData(rs.getDate("data").toString());
                JPK.setIdJulgamento(rs.getInt("idJulgamento"));
                JPK.setTribunal(rs.getString("tribunal"));
                jLista.add(JPK);
                return jLista;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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
    public ArrayList Find(int id) {
        return super.Find(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public ArrayList<JulgamentoPK> find(Object object) {
        JulgamentoPK j = (JulgamentoPK) object;
        return (ArrayList<JulgamentoPK>) super.getObjectosPersonalizados(j); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public ArrayList<JulgamentoPK> findAll() {
        return (ArrayList<JulgamentoPK>) super.getObjectos(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void Actualizar(Object object) {
        JulgamentoPK j = (JulgamentoPK) object;
        super.Actualizar(j); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void Inserir(Object object) {
    JulgamentoPK j = (JulgamentoPK) object;
        super.Inserir(j); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void Delete(int id) {
        super.Delete(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }    

    public int findIdJulgamento(JulgamentoPK jPK) {
        this.AbrirConexao();
        try (PreparedStatement stmt = this.conex.prepareStatement("SELECT idJulgamento FROM julgamento WHERE  tribunal= ? and data = ?")) {
            stmt.setString(1, jPK.getTribunal());
            stmt.setString(2, jPK.getData());
         
            try (ResultSet rs = stmt.executeQuery()) {
                rs.next();
                return rs.getInt("idJulgamento");
            }
            
        } catch (SQLException ex) {
            this.FecharConexao();
            ex.printStackTrace();
            return 0;
        }
    }
}
