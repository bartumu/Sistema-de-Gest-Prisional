/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import MODEL.Bloco;
import MODEL.Cela;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Melhor De Mim
 */
public class CelaController extends CRUDController {

    public CelaController() {
        super("cela", "idBloco");
        super.setInserirQuery(String.format("INSERT INTO %s (descricao, idBloco, tipo) values (?,?,?)", this.tabela));
        super.setAtualizarQuery(String.format("UPDATE cela SET descricao = ?, tipo = ? WHERE idBloco = ?", this.tabela));
    }

    @Override
    protected void setValoresQuery(PreparedStatement stmt, Object object, boolean update) throws SQLException {
        Cela cela = (Cela) object;
        if (update == true) {
            stmt.setString(1, cela.getDescricao());
            stmt.setInt(2, cela.getBloco().getIdBloco());
            stmt.setString(3, cela.getTipoCela());
        } else {
            stmt.setString(1, cela.getDescricao());
            stmt.setString(2, cela.getTipoCela());
            stmt.setInt(3, cela.getBloco().getIdBloco());
        }
    }

    @Override
    protected ArrayList criarObjecto(ResultSet rs, boolean all) throws SQLException {
        ArrayList<Cela> cLista = new ArrayList<>();

        if (all = true) {
            while (rs.next()) {
                Bloco b = new Bloco();
                Cela c = new Cela();
                c.setDescricao(rs.getString("descricao"));
                b.setIdBloco(rs.getInt("idBloco"));
                c.setBloco(b);
                c.setTipoCela(rs.getString("tipo"));
                cLista.add(c);
            }
            System.out.println("");
            return cLista;
        } else {
            rs.next();
            Bloco b = new Bloco();
            Cela c = new Cela();
            c.setDescricao(rs.getString("descricao"));
            b.setIdBloco(rs.getInt("idBloco"));
            c.setBloco(b);
            c.setTipoCela(rs.getString("tipo"));

            cLista.add(c);
            return cLista;
        }
    }

    @Override
    protected Object convertObjecto(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Inserir(Object object) {
        Cela cela = (Cela) object;
        super.Inserir(cela); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
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

}
