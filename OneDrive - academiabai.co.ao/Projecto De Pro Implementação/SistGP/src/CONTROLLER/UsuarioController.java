/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import MODEL.Funcionario;
import MODEL.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Melhor De Mim
 */
public class UsuarioController extends CRUDController {

    public UsuarioController() {
        super("usuario", "numBI");
        super.setInserirQuery(String.format("INSERT %s (senha,acesso,numBI,nome,tipo) INTO VALUES (?,?,?,?,?)", this.tabela));
        super.setAtualizarQuery(String.format("UPDATE %s SET senha = ?, acesso = ?, nome = ?, tipo = ? WHERE numBI = ?", this.tabela));
    }

    @Override
    protected void setValoresQuery(PreparedStatement stmt, Object object, boolean update) throws SQLException {
        Usuario user = (Usuario) object;
        if (update == true) {
            stmt.setString(1, user.getSenha());
            stmt.setString(2, user.getDataAcesso());
            stmt.setString(3, user.getNome());
            stmt.setBoolean(4, user.getTipo());
            stmt.setString(5, user.getFuncionario().getNumBI());
        } else {
            stmt.setString(1, user.getSenha());
            stmt.setString(2, user.getDataAcesso());
            stmt.setString(4, user.getNome());
            stmt.setBoolean(4, user.getTipo());
            stmt.setString(5, user.getFuncionario().getNumBI());
        }
    }

    @Override
    protected ArrayList criarObjecto(ResultSet rs, boolean all) throws SQLException {
        ArrayList<Usuario> uLista = new ArrayList<>();

        if (all = true) {
            while (rs.next()) {
                Funcionario f = new Funcionario();
                Usuario user = new Usuario();
                user.setDataAcesso(rs.getString("acesso"));
                user.setNome(rs.getString("nome"));
                user.setSenha(rs.getString("senha"));
                int tipo = (rs.getInt("tipo"));
                f.setNumBI(rs.getString("numBI"));
                user.setFuncionario(f);
                uLista.add(user);
            }
            System.out.println("");
            return uLista;
        } else {
            rs.next();
            Funcionario f = new Funcionario();
            Usuario user = new Usuario();
            user.setDataAcesso(rs.getString("acesso"));
            user.setNome(rs.getString("nome"));
            user.setSenha(rs.getString("senha"));
            int tipo = (rs.getInt("tipo"));
            f.setNumBI(rs.getString("numBI"));
            user.setFuncionario(f);
            uLista.add(user);
            return uLista;
        }
    }

    @Override
    protected Object convertObjecto(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Usuario> findAll() {
        return (ArrayList<Usuario>) super.getObjectos();
    }

    @Override
    public ArrayList Find(int id) {
        return super.Find(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void Actualizar(Object object) {
        Usuario user = (Usuario) object;
        super.Actualizar(user); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void Delete(String id) {
        super.Delete(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void Inserir(Object object) {
        Usuario user = (Usuario) object;
        super.Inserir(user); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    

}
