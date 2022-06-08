/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Melhor De Mim
 */
public abstract class CRUDController extends MODEL.CRUD {

    protected ArrayList<Object> objectos;

    public CRUDController(String tabela) {
        super(tabela);
    }

    public CRUDController(String tabela, String idTabela) {
        super(tabela, idTabela);
    }

//    public CRUDController(String tabela, int idTabela) {
//        super(tabela,idTabela);
//    }
    @SuppressWarnings("unchecked")
    protected void CarregarObjectos() throws NullPointerException {
        this.objectos = (ArrayList<Object>) super.findAll();
    }

    protected void CarregarObjectosPersonalizado(Object object) throws NullPointerException {
        this.objectos = (ArrayList<Object>) super.find(object);
    }

    @SuppressWarnings("rawtypes")
    protected ArrayList getObjectos() {
        this.CarregarObjectos();
        return this.objectos;
    }

    protected ArrayList getObjectosPersonalizados(Object object) {
        this.CarregarObjectosPersonalizado(object);
        return this.objectos;
    }

    @Override
    public void Actualizar(Object object) {
        super.Actualizar(object);
        this.CarregarObjectos();
    }

    @Override
    public void Inserir(Object object) {
        super.Inserir(object); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
//        this.objectos.add(this.convertObjecto(object));
    }

    @Override
    public void Delete(int id) {
        super.Delete(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
//        this.CarregarObjectos();
    }

    @Override
    protected abstract void setValoresQuery(PreparedStatement stmt, Object object, boolean update) throws SQLException;

    @Override
    protected abstract ArrayList criarObjecto(ResultSet rs, boolean all) throws SQLException;


    @Override
    protected abstract ArrayList criarObjectoPersonalizado(ResultSet rs) throws SQLException;

    @Override
    protected abstract void setValoresQueryPersonalizado(PreparedStatement stmt, Object object) throws SQLException;

}
