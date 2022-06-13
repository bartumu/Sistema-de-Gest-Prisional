/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import MODEL.Bloco;
import MODEL.Funcao;
import MODEL.Funcionario;
import MODEL.Turno;
import MODEL.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Melhor De Mim
 */
public class FuncionarioController extends CRUDController {

    public FuncionarioController() {
        super("funcionario", "numBI");
        super.setInserirQuery(String.format("INSERT INTO %s (nome,endereco,sexo,estadoCivil,dataNasc,dataAdimissao,numBI,idFuncao) "
                + "values (?, ?, ?, ?, ?, ?, ?,?)", this.tabela));
        super.setAtualizarQuery(String.format("UPDATE %s SET nome = ?, endereco = ?,"
                + " sexo = ?, estadoCivil = ?, dataNasc = ?, dataAdimissao = ?, idFuncao = ?, idBloco = ?, idTurno = ?"
                + " WHERE numBI = ?", this.tabela));
        super.setDeletarQuery(String.format("DELETE FROM %s WHERE %s = ?", this.tabela, this.idTabela));
        super.setSelecionarQuery(String.format("SELECT * FROM %s", this.tabela));
        super.setSeleccaoPersonalizadoQuery(String.format("SELECT numBI FROM %s WHERE nome = ? and dataNasc = ?", this.tabela));

    }

    @Override
    protected void setValoresQuery(PreparedStatement stmt, Object object, boolean update) throws SQLException {
        Funcionario func = (Funcionario) object;
        if (update == true) {
            stmt.setString(1, func.getNome());
            stmt.setString(2, func.getEndereco());
            stmt.setString(3, func.getSexo());
            stmt.setString(4, func.getEstadoCivil());
            stmt.setString(5, func.getDataNasc());
            stmt.setString(6, func.getDataAdimissao());
            stmt.setInt(7, func.getIdFuncao().getIdFuncao());
            stmt.setInt(8, func.getIdBloco().getIdBloco());
            stmt.setInt(9, func.getIdTurno().getIdTurno());
        } else {
            stmt.setString(1, func.getNome());
            stmt.setString(2, func.getEndereco());
            stmt.setString(3, func.getSexo());
            stmt.setString(4, func.getEstadoCivil());
            stmt.setString(5, func.getDataNasc());
            stmt.setString(6, func.getDataAdimissao());
            stmt.setString(7, func.getNumBI());
            stmt.setInt(8, func.getIdFuncao().getIdFuncao());
        }
    }

    @Override
    protected ArrayList criarObjecto(ResultSet rs, boolean all) throws SQLException {
        ArrayList<Funcionario> fLista = new ArrayList<>();
        if (all = true) {
            while (rs.next()) {
                var b = new Bloco();
                var fu = new Funcao();
                Funcionario f = new Funcionario();
                f.setNumBI(rs.getString("numBI"));
                f.setNome(rs.getString("nome"));
                f.setEndereco(rs.getString("endereco"));
                f.setSexo(rs.getString("sexo"));
                f.setEstadoCivil(rs.getString("estadoCivil"));
                f.setDataNasc(rs.getDate("dataNasc").toString());
                f.setDataAdimissao(rs.getDate("dataAdimissao").toString());
                b.setIdBloco(rs.getInt("idBloco"));
                fu.setFuncao(rs.getString("idFuncao"));
                f.setIdFuncao(fu);
                f.setIdBloco(b);
                fLista.add(f);
            }
            System.out.println("");
            return fLista;
        } else {
            rs.next();
            var b = new Bloco();
            var fu = new Funcao();
            Funcionario f = new Funcionario();
            f.setNumBI(rs.getString("numBI"));
            f.setNome(rs.getString("nome"));
            f.setEndereco(rs.getString("endereco"));
            f.setSexo(rs.getString("sexo"));
            f.setEstadoCivil(rs.getString("estadoCivil"));
            f.setDataNasc(rs.getDate("dataNasc").toString());
            f.setDataAdimissao(rs.getDate("dataAdimissao").toString());
            fu.setFuncao(rs.getString("idFuncao"));
            f.setIdFuncao(fu);
            b.setIdBloco(rs.getInt("idBloco"));
            f.setIdBloco(b);
            fLista.add(f);
            return fLista;
        }
    }

    @Override
    public ArrayList<Funcionario> findAll() {
        return (ArrayList<Funcionario>) super.getObjectos(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public ArrayList find(Object object) {
        Funcionario func = (Funcionario) object;
        return (ArrayList<Funcionario>) super.getObjectosPersonalizados(func); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public ArrayList Find(int id) {
        return super.Find(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void Actualizar(Object object) {
        Funcionario func = (Funcionario) object;
        super.Actualizar(func); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void Delete(String id) {
        super.Delete(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public void Inserir(Object object, Usuario user) {
        Funcionario func = (Funcionario) object;
        super.Inserir(func); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody

        user.setNumBI(func);
        user.setNome(func.getNumBI());
        user.setSenha("1234");
    }

    @Override
    protected void setValoresQueryPersonalizado(PreparedStatement stmt, Object object) throws SQLException {
        Funcionario f = (Funcionario) object;
        stmt.setString(1, f.getNome());
        stmt.setString(2, f.getDataNasc());
    }

    @Override
    protected ArrayList criarObjectoPersonalizado(ResultSet rs) throws SQLException {
        ArrayList<Funcionario> fLista = new ArrayList<>();
        var f = new Funcionario();

        rs.next();
        f.setNumBI(rs.getString("numBI"));
        fLista.add(f);
        return fLista;
    }

    public void CarregarTabela(DefaultTableModel tbModelF, JTable tblFuncionario) {
        Object[] columnNames = {"Nº Do BI", "Nome", "Endereço", "Sexo", "Data de Nascimento", "Data De Admissão"};
        var fController = new FuncionarioController();
        tbModelF.setColumnIdentifiers(columnNames);
        for (int i = 0; i < fController.findAll().size(); i++) {

            Object[] lista = {
                fController.findAll().get(i).getNumBI(),
                fController.findAll().get(i).getNome(),
                fController.findAll().get(i).getEndereco(),
                fController.findAll().get(i).getSexo(),
                fController.findAll().get(i).getDataNasc(),
                fController.findAll().get(i).getDataAdimissao()
            };

            tbModelF.addRow(lista);
        }
        tblFuncionario.setModel(tbModelF);
    }
    
    
    public void Escalar(Funcionario f, Bloco b, Turno t) {
        this.AbrirConexao();
        String sql = String.format("call sistgp.Escalar(?, ?, ?)");
        try ( PreparedStatement stmt = this.conex.prepareStatement(sql)) {
            stmt.setString(1, t.getTurno());
            stmt.setString(2, b.getDescricao());
            stmt.setString(3, f.getNumBI());
            stmt.execute();
        } catch (SQLException ex) {
            this.FecharConexao();
        }
    }
    
    public void CarregarTabelaG(DefaultTableModel tbModelF, JTable tblFuncionario) {
        this.AbrirConexao();
        Object[] lista = new Object[5];
        Object[] columnNames = {"Nº Do BI", "Nome", "Função", "Sexo", "Data De Admissão"};
        
        tbModelF.setColumnIdentifiers(columnNames);
        
        String sql = String.format("SELECT * FROM funcionario as f inner join funcao as fu on fu.`idFuncao` = f.`idFuncao`"
                + "where  f.idBloco is null");
        try ( Statement stmt = this.conex.createStatement()) {
            stmt.execute(sql);
            try ( ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    lista [0] = (rs.getString("numBI"));
                    lista [1] =(rs.getString("nome"));
                    lista [2] =(rs.getString("funcao"));
                    lista [3] =(rs.getString("sexo"));
                    lista [4] =(rs.getDate("dataAdimissao").toString());
                    tbModelF.addRow(lista);
                }
                tblFuncionario.setModel(tbModelF);
            }

        } catch (SQLException ex) {
            this.FecharConexao();
        }
    }
    
    public void CarregarTabelaG1(DefaultTableModel tbModelF, JTable tblFuncionario) {
        this.AbrirConexao();
        Object[] lista = new Object[5];
        Object[] columnNames = {"Nº Do BI", "Nome", "Função", "Sexo", "Data De Admissão"};
        
        tbModelF.setColumnIdentifiers(columnNames);
        
        String sql = String.format("SELECT * FROM funcionario as f inner join funcao as fu on fu.`idFuncao` = f.`idFuncao`"
                + "where  f.idBloco is not null");
        try ( Statement stmt = this.conex.createStatement()) {
            stmt.execute(sql);
            try ( ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    lista [0] = (rs.getString("numBI"));
                    lista [1] =(rs.getString("nome"));
                    lista [2] =(rs.getString("funcao"));
                    lista [3] =(rs.getString("sexo"));
                    lista [4] =(rs.getDate("dataAdimissao").toString());
                    tbModelF.addRow(lista);
                }
                tblFuncionario.setModel(tbModelF);
            }

        } catch (SQLException ex) {
            this.FecharConexao();
        }
    }

}
