/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import MODEL.Bloco;
import MODEL.Cela;
import MODEL.CelaPK;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Melhor De Mim
 */
public class CelaController extends CRUDController {

    public CelaController() {
        super("cela", "idBloco");
        super.setInserirQuery(String.format("INSERT INTO %s (descricao, idBloco, tipo) values (?,?,?)", this.tabela));
        super.setAtualizarQuery(String.format("UPDATE %s SET descricao = ?, tipo = ? WHERE idBloco = ?", this.tabela));
        super.setDeletarQuery(String.format("DELETE FROM %s WHERE %s = ?", this.tabela, this.idTabela));
        super.setSelecionarQuery(String.format("SELECT c.*, b.descricao as Bloco FROM %s as c join bloco as b on (b.idBloco = c.idBloco)", this.tabela));
//        super.setSelecionarQuery(String.format("SELECT b.descricao FROM %s as c join bloco on (b.idBloco = c.idBloco)", this.tabela));
    }

    @Override
    protected void setValoresQuery(PreparedStatement stmt, Object object, boolean update) throws SQLException {
        Cela cela = (Cela) object;
        if (update == true) {
            stmt.setString(1, cela.getCelaPK().getDescricao());
            stmt.setInt(2, cela.getCelaPK().getIdBloco());
            stmt.setString(3, cela.getTipo());
        } else {
            stmt.setString(1, cela.getCelaPK().getDescricao());
            stmt.setInt(2, cela.getCelaPK().getIdBloco());
            stmt.setString(3, cela.getTipo());
        }
    }

    @Override
    protected ArrayList criarObjecto(ResultSet rs, boolean all) throws SQLException {
        ArrayList<Cela> cLista = new ArrayList<>();

        if (all = true) {
            while (rs.next()) {
                Cela c = new Cela();
                var b = new Bloco();
                var celaPK = new CelaPK();
                celaPK.setDescricao(rs.getString("descricao"));
                celaPK.setIdBloco(rs.getInt("idBloco"));
                c.setCelaPK(celaPK);
                b.setDescricao(rs.getString("Bloco"));
                c.setBloco(b);
                c.setTipo(rs.getString("tipo"));
                cLista.add(c);
            }
            System.out.println("");
            return cLista;
        } else {
            var celaPK = new CelaPK();
            rs.next();
            Cela c = new Cela();
            celaPK.setDescricao(rs.getString("descricao"));
            celaPK.setIdBloco(rs.getInt("idBloco"));
            c.setCelaPK(celaPK);
            c.setTipo(rs.getString("tipo"));

            cLista.add(c);
            return cLista;
        }
    }

    @Override
    public void Inserir(Object object) {
        Cela cela = (Cela) object;
        super.Inserir(cela); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public ArrayList<Cela> Find(String id) {
        return super.Find(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    

    @Override
    public void Actualizar(Object object) {
        Cela cela = (Cela) object;
        super.Actualizar(cela); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void Delete(int id) {
        super.Delete(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public ArrayList<Cela> findAll() {
        return (ArrayList<Cela>) super.getObjectos(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    

    @Override
    public ArrayList<Cela> Find(int id) {
        return super.Find(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
   

    @Override
    public ArrayList<Cela> find(Object object) {
       Cela cela = (Cela) object;
        return (ArrayList<Cela>) super.getObjectosPersonalizados(cela); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    

    @Override
    protected void setValoresQueryPersonalizado(PreparedStatement stmt, Object object) throws SQLException {
        Cela cela = (Cela) object;
        
    }

    @Override
    protected ArrayList criarObjectoPersonalizado(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public ArrayList<CelaPK> AcharCelasNormais(CelaPK celaPK) {
        super.AbrirConexao();
        var sql = String.format("SELECT descricao FROM cela where tipo = 'Normal' or tipo = 'normal'");
        ArrayList<CelaPK> cLista = new ArrayList<>();
            try (Statement stmt = this.conex.createStatement()) {
            stmt.execute(sql);
            try (ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {                    
                celaPK.setDescricao(rs.getString("descricao"));
                cLista.add(celaPK);                    
                }
                return cLista;
            }
        } catch (SQLException ex) {
            super.FecharConexao();
            JOptionPane.showMessageDialog(null, ex);
            return null;
        }
    }
    
    public int findIdBloco(CelaPK celaPK) {
        this.AbrirConexao();
        try (PreparedStatement stmt = this.conex.prepareStatement("SELECT idBloco FROM cela WHERE descricao = ?")) {
            stmt.setString(1, celaPK.getDescricao());
         
            try (ResultSet rs = stmt.executeQuery()) {
                rs.next();
                return rs.getInt("idBloco");
            }
            
        } catch (SQLException ex) {
            this.FecharConexao();
            ex.printStackTrace();
            return 0;
        }
    }

}
