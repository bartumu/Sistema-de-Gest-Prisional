/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import MODEL.Esquadra;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Melhor De Mim
 */
public class EsquadraController extends CRUDController {

    public EsquadraController() {
        super("esquadra", "idEsquadra");
        super.setInserirQuery(String.format("INSERT INTO %s (descricao, local) VALUES (?,?)", this.tabela));
        super.setAtualizarQuery(String.format("UPDATE esquadra SET descricao = ?, local = ? WHERE idEsquadra = ?", this.tabela, this.idTabela));
    }

    @Override
    protected void setValoresQuery(PreparedStatement stmt, Object object, boolean update) throws SQLException {
        Esquadra esquadra = (Esquadra) object;
        if (update == true) {
            stmt.setString(1, esquadra.getDescricao());
            stmt.setString(2, esquadra.getLocal());
            stmt.setInt(3, esquadra.getIdEsquadra());
        }else{
            stmt.setString(1, esquadra.getDescricao());
            stmt.setString(2, esquadra.getLocal());
        }
    }

    @Override
    protected ArrayList criarObjecto(ResultSet rs, boolean all) throws SQLException {
        ArrayList<Esquadra> eLista = new ArrayList<>();
        if (all = true) {
            while (rs.next()) {

                Esquadra e = new Esquadra();
                e.setIdEsquadra(rs.getInt("idEsquadra"));
                e.setDescricao(rs.getString("descricao"));
                e.setLocal(rs.getString("local"));

                eLista.add(e);
            }
            System.out.println("");
            return eLista;
        } else {
            rs.next();
            Esquadra e = new Esquadra();
            e.setIdEsquadra(rs.getInt("idEsquadra"));
            e.setDescricao(rs.getString("descricao"));
            e.setLocal(rs.getString("local"));

            eLista.add(e);
            return eLista;
        }
    }

    @Override
    public void Inserir(Object object) {
        Esquadra esquadra = (Esquadra) object;
        super.Inserir(esquadra); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void Actualizar(Object object) {
        Esquadra esquadra = (Esquadra) object;
        super.Actualizar(esquadra); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void Delete(int id) {
        super.Delete(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public ArrayList<Esquadra> Find(int id) {
        return super.Find(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public ArrayList<Esquadra> findAll() {
        return (ArrayList<Esquadra>) super.getObjectos(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
//    public static void main(String[] args) {
//        EsquadraController ec = new EsquadraController();
//        ec.Delete(3);
//        System.out.println("Eliminado com sucesso");
//    }
//    
//    
    @Override
    protected Object convertObjecto(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
