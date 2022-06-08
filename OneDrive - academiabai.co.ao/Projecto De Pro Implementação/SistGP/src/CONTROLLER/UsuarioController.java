/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import MODEL.Funcao;
import java.sql.PreparedStatement;
import MODEL.Funcionario;
import MODEL.Usuario;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Melhor De Mim
 */
public class UsuarioController extends CRUDController {

    public UsuarioController() {
        super("usuario", "numBI");
        super.setInserirQuery(String.format("INSERT %s (senha,acesso,numBI,nome,tipo) VALUES (?,null,?,?,?)", this.tabela));
        super.setAtualizarQuery(String.format("UPDATE %s SET senha = ?, acesso = ?, nome = ? WHERE numBI = ?", this.tabela));
        super.setDeletarQuery(String.format("DELETE FROM %s WHERE %s = ?", this.tabela, this.idTabela));
        super.setSelecionarQuery(String.format("SELECT * FROM %s", this.tabela));
        super.setSeleccaoPersonalizadoQuery(String.format("SELECT acesso,numBI,tipo FROM %s WHERE senha = ? and nome = ?", this.tabela));

    }

    @Override
    protected void setValoresQuery(PreparedStatement stmt, Object object, boolean update) throws SQLException {
        Usuario user = (Usuario) object;
        if (update == true) {
            stmt.setString(1, user.getSenha());
            stmt.setString(2, user.getAcesso());
            stmt.setString(3, user.getNome());
            stmt.setString(4, user.getNumBI().getNumBI());
        } else {
            stmt.setString(1, user.getSenha());
            stmt.setString(2, user.getNumBI().getNumBI());
            stmt.setString(3, user.getNome());
            stmt.setInt(4, user.getTipo());
        }
    }

    @Override
    protected ArrayList criarObjecto(ResultSet rs, boolean all) throws SQLException {
        ArrayList<Usuario> uLista = new ArrayList<>();

        if (all = true) {
            while (rs.next()) {
                Usuario user = new Usuario();
                Funcionario f = new Funcionario();
                user.setAcesso(rs.getString("acesso"));
                user.setNome(rs.getString("nome"));
                user.setSenha(rs.getString("senha"));
                user.setTipo((short) rs.getInt("tipo"));
                f.setNumBI(rs.getString("numBI"));
                user.setNumBI(f);
                uLista.add(user);
            }
            System.out.println("");
            return uLista;
        } else {
            rs.next();
            Funcionario f = new Funcionario();
            Usuario user = new Usuario();
            user.setAcesso(rs.getDate("acesso").toString());
            user.setNome(rs.getString("nome"));
            user.setSenha(rs.getString("senha"));
            user.setTipo((short) rs.getInt("tipo"));
            f.setNumBI(rs.getString("numBI"));
            user.setNumBI(f);
            uLista.add(user);
            return uLista;
        }
    }

    @Override
    public ArrayList<Usuario> findAll() {
        return (ArrayList<Usuario>) super.getObjectos();
    }

    @Override
    public ArrayList<Usuario> find(Object object) {
        Usuario user = (Usuario) object;
        return (ArrayList<Usuario>) super.getObjectosPersonalizados(user); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
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
    public void Inserir(Object object) {
        Usuario user = (Usuario) object;
        super.Inserir(user); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public ArrayList<Usuario> Find(String id) {
        return super.Find(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public int Logar(Usuario user) {
        var f = new Funcao();
        var cU = new UsuarioController();
        int a = 0;
        try {
            for (int i = 0; i < cU.findAll().size(); i++) {
                if (user.getSenha().equals(cU.findAll().get(i).getSenha()) && user.getNome().equals(cU.findAll().get(i).getNome())) {
                    cU.findUFuncTIPO(f, user);
                    if (user.getTipo() == 0 && f.getFuncao().equals("Supervisor") || f.getFuncao().equals("supervisor")) {

                        a = 1;
                        break;
                    } else if (user.getTipo() == 0 && f.getFuncao().equals("Guarda") || f.getFuncao().equals("guarda")) {
                        a = 2;
                        break;
                    } else if (user.getTipo() == 1) {
                        a = 0;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Senha ou nome Errado");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    @Override
    protected void setValoresQueryPersonalizado(PreparedStatement stmt, Object object) throws SQLException {
        Usuario user = (Usuario) object;
        stmt.setString(1, user.getSenha());
        stmt.setString(2, user.getNome());
    }

    @Override
    protected ArrayList criarObjectoPersonalizado(ResultSet rs) throws SQLException {
        ArrayList<Usuario> uLista = new ArrayList<>();
        rs.next();
        Usuario u = new Usuario();
        var f = new Funcionario();
        u.setTipo(rs.getShort("tipo"));
        u.setAcesso(rs.getString("acesso"));
        f.setNumBI(rs.getString("numBI"));
        u.setNumBI(f);
        uLista.add(u);
        return uLista;
    }

    public ArrayList<Funcionario> findEspecificFuncionario(Usuario u, Funcionario f) {
        super.AbrirConexao();
        ArrayList<Funcionario> fLista = new ArrayList<>();
        try ( PreparedStatement stmt = super.conex.prepareStatement("SELECT f.nome,f.numBI FROM funcionario as f"
                + " JOIN usuario as u ON (f.numBI = u.numBI) WHERE u.nome = ?")) {
            stmt.setString(1, u.getNome());

            try ( ResultSet rs = stmt.executeQuery()) {
                rs.next();
                f.setNome(rs.getString("f.nome"));
                f.setNumBI(rs.getString("f.numBI"));
                fLista.add(f);
                return fLista;
            }

        } catch (SQLException ex) {
            super.FecharConexao();
            ex.printStackTrace();
            return null;
        }

    }

    public void findUFuncTIPO(Funcao f, Usuario u) {
        super.AbrirConexao();
//        ArrayList<Funcionario> fLista = new ArrayList<>();
        try ( PreparedStatement stmt = super.conex.prepareStatement("call sistgp.Login(?, ?)")) {
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getSenha());

            try ( ResultSet rs = stmt.executeQuery()) {
                if (!rs.isFirst()) {
                } else {
                    rs.next();
                    f.setFuncao(rs.getString(1));
                    u.setTipo(rs.getShort(2));
                }
            }

        } catch (SQLException ex) {
            super.FecharConexao();
            ex.printStackTrace();
        }

    }

    public void CarregarTabelaUser(DefaultTableModel tbModel, JTable tblUser) {
        Object[] columnNames = {"Nº Do BI", "Nome", "Nome De Utilizador", "Senha"};
        var fController = new FuncionarioController();
        var UController = new UsuarioController();

        tbModel = new DefaultTableModel(columnNames, 0);
        for (int i = 0; i < UController.findAll().size(); i++) {

            Object[] lista = {
                fController.findAll().get(i).getNumBI(),
                fController.findAll().get(i).getNome(),
                UController.Find(fController.findAll().get(i).getNumBI()).get(i).getNome(),
                UController.Find(fController.findAll().get(i).getNumBI()).get(i).getSenha()
            };

            tbModel.addRow(lista);
        }
        tblUser.setModel(tbModel);
    }

}
