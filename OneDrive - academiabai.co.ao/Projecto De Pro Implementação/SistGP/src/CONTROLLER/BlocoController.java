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

/**
 *
 * @author Melhor De Mim
 */
public class BlocoController extends CRUDController {

    public BlocoController() {
        super("bloco","idBloco");
        super.setInserirQuery(String.format("INSERT INTO %s (descricao) values (?)", this.tabela));
        super.setAtualizarQuery(String.format("UPDATE bloco SET descricao = ? WHERE idBloco = ?", this.tabela));
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
        }else 
            stmt.setString(1, bloco.getDescricao());

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

    @Override
    protected Object convertObjecto(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void Cadastrar(Bloco b) {

    }

}
