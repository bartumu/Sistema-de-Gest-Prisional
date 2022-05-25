/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Melhor De Mim
 */
public abstract class CRUD {
    private Connection conex;
    private Statement stmt;
    private String inserirQuery;
    private String atualizarQuery;
    private String selecionarQuery;
    protected String tabela;
    protected String idTabela;
     
    public CRUD( String tabela) {
        this.tabela = tabela;
    }
    
    public CRUD( String tabela, String idTabela) {
        this.tabela = tabela;
        this.idTabela = idTabela;
    }
    
//    
    protected abstract void setValoresQuery(PreparedStatement stmt, Object object, boolean update) throws SQLException;
    protected abstract ArrayList criarObjecto(ResultSet rs, boolean all) throws SQLException;
    
    protected void setInserirQuery(String query) {
        this.inserirQuery = query;
    }

    protected void setAtualizarQuery(String query) {
        this.atualizarQuery = query;
    }

    protected void setSelecionarQuery(String query) {
        this.selecionarQuery = query;
    }
    
    public void Inserir(Object object) {
        this.AbrirConexao();
        System.out.println(this.inserirQuery);
        try (PreparedStatement stmt = this.conex.prepareStatement(this.inserirQuery)) {
            this.setValoresQuery(stmt, object,false);
            stmt.execute();
            this.FecharConexao();
        } catch (SQLException ex) {
            this.FecharConexao();
            this.treatException(ex);
        }
    }

    public void Actualizar(Object object) {
        this.AbrirConexao();
        try (PreparedStatement stmt = this.conex.prepareStatement(this.atualizarQuery)) {
            this.setValoresQuery(stmt, object, true);
            stmt.execute();
            this.FecharConexao();
        } catch (SQLException ex) {
            this.FecharConexao();
            this.treatException(ex);
        }
    }

    public void Delete(int id) {
        this.AbrirConexao();
        String sql = String.format("DELETE FROM %s WHERE %s = ?", this.tabela, this.idTabela);
        try (PreparedStatement stmt = this.conex.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
            this.FecharConexao();
        } catch (SQLException ex) {
            this.FecharConexao();
            this.treatException(ex);
        }
    }
    
    public void Delete(String id) {
        this.AbrirConexao();
        String sql = String.format("DELETE FROM %s WHERE %s = ?", this.tabela, this.idTabela);
        try (PreparedStatement stmt = this.conex.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.execute();
            this.FecharConexao();
        } catch (SQLException ex) {
            this.FecharConexao();
            this.treatException(ex);
        }
    }

    public ArrayList Find(int id) {
        boolean all = false;
        this.AbrirConexao();
        String sql = String.format("SELECT * FROM %s WHERE idBloco = ?", this.tabela);
        try (PreparedStatement stmt = this.conex.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
//            rs.next();
            return criarObjecto(rs,all);
        } catch (SQLException ex) {
            this.FecharConexao();
            this.treatException(ex);
            return null;
        }
    }

    @SuppressWarnings("rawtypes")
    public ArrayList findAll() {
        boolean all = true;
        this.AbrirConexao();
        String sql = String.format("SELECT * FROM %s", this.tabela);
        try (Statement stmt = this.conex.createStatement()) {
            stmt.execute(sql);
            try (ResultSet rs = stmt.executeQuery(sql)) {
                return criarObjecto(rs,all);
            }
            
        } catch (SQLException ex) {
            this.FecharConexao();
            this.treatException(ex);
            return null;
        }
    }


    private void treatException(Exception ex) {
        System.out.println(ex.getMessage());
        ex.printStackTrace();
    }
    
    
    private void AbrirConexao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistgp?autoReconnect=true", "root", "");
//            System.out.println("Conexão Aberta com sucesso");
        } 
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally{
            
        }
    }
    
    private void FecharConexao(){
        try {
            if (stmt != null) {
                conex.close();
                stmt.close();
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
