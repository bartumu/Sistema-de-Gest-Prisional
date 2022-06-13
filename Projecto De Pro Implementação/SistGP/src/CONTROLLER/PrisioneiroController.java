/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import MODEL.Bloco;
import MODEL.Cela;
import MODEL.CelaPK;
import MODEL.Crime;
import MODEL.EJulgado;
import MODEL.Esquadra;
import MODEL.Julgamento;
import MODEL.JulgamentoPK;
import MODEL.Prisioneiro;
import com.mysql.cj.xdevapi.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Melhor De Mim
 */
public class PrisioneiroController extends CRUDController {

    public PrisioneiroController() {
        super("prisioneiro", "numBI");
        super.setInserirQuery(String.format("INSERT INTO %s (numBI,nome,endereco,estadoCivil,sexo,dataEntrada,dataNasc,idBloco) "
                + "values (?, ?, ?, ?, ?, ?, ?, ?)", this.tabela));
        super.setAtualizarQuery(String.format("UPDATE %s SET nome = ?, endereco = ?, estadoCivil = ?, sexo = ?, dataEntrada = ?, dataNasc = ?,"
                + " idBloco = ? WHERE numBI = ?", this.tabela));
        super.setDeletarQuery(String.format("DELETE FROM %s WHERE %s = ?", this.tabela, this.idTabela));
        super.setSelecionarQuery(String.format("SELECT * FROM %s where estado = 1", this.tabela));
        super.setSeleccaoPersonalizadoQuery(String.format("SELECT numBI FROM %s WHERE nome = ? and dataNasc = ?", this.tabela));

    }

    @Override
    protected void setValoresQuery(PreparedStatement stmt, Object object, boolean update) throws SQLException {
        Prisioneiro pris = (Prisioneiro) object;
        if (update) {
            stmt.setString(1, pris.getNome());
            stmt.setString(2, pris.getEndereco());
            stmt.setString(3, pris.getEstadoCivil());
            stmt.setString(4, pris.getSexo());
            stmt.setString(5, pris.getDataEntrada());
            stmt.setString(6, pris.getDataNasc());
            stmt.setInt(7, pris.getIdBloco().getCelaPK().getIdBloco());
            stmt.setString(8, pris.getNumBI());
        } else {
            stmt.setString(1, pris.getNumBI());
            stmt.setString(2, pris.getNome());
            stmt.setString(3, pris.getEndereco());
            stmt.setString(4, pris.getEstadoCivil());
            stmt.setString(5, pris.getSexo());
            stmt.setString(6, pris.getDataEntrada());
            stmt.setString(7, pris.getDataNasc());
            stmt.setInt(8, pris.getIdBloco().getCelaPK().getIdBloco());

        }
    }

    @Override
    protected ArrayList<Prisioneiro> criarObjecto(ResultSet rs, boolean all) throws SQLException {
        ArrayList<Prisioneiro> prisLista = new ArrayList<>();

        try {
            if (all) {
                while (rs.next()) {
                    Prisioneiro pris = new Prisioneiro();
                    CelaPK celaPK = new CelaPK();
                    Cela c = new Cela();

                    pris.setNumBI(rs.getString("numBI"));
                    pris.setNome(rs.getString("nome"));
                    pris.setEndereco(rs.getString("endereco"));
                    pris.setEstadoCivil(rs.getString("estadoCivil"));
                    pris.setDataEntrada(rs.getDate("dataEntrada").toString());
                    pris.setSexo(rs.getString("sexo"));
                    pris.setDataNasc(rs.getDate("dataNasc").toString());
                    pris.setEstado(rs.getShort("estado"));
                    celaPK.setIdBloco(rs.getInt("idBloco"));
                    c.setCelaPK(celaPK);
                    pris.setIdBloco(c);

                    prisLista.add(pris);
                }
                return prisLista;
            } else {
                rs.next();
                Prisioneiro pris = new Prisioneiro();
                CelaPK celaPK = new CelaPK();
                Cela c = new Cela();

                pris.setNumBI(rs.getString("numBI"));
                pris.setNome(rs.getString("nome"));
                pris.setEndereco(rs.getString("endereco"));
                pris.setEstadoCivil(rs.getString("estadoCivil"));
                pris.setDataEntrada(rs.getDate("dataEntreda").toString());
                pris.setSexo(rs.getString("sexo"));
                pris.setEstado(rs.getShort("estado"));
                pris.setDataNasc(rs.getDate("dataNasc").toString());
                celaPK.setIdBloco(rs.getInt("idBloco"));
                c.setCelaPK(celaPK);
                pris.setIdBloco(c);

                prisLista.add(pris);
                return prisLista;
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
    public ArrayList<Prisioneiro> findAll() {
        return (ArrayList<Prisioneiro>) super.getObjectos(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public ArrayList<Prisioneiro> find(Object object) {
        Prisioneiro pris = (Prisioneiro) object;
        return (ArrayList<Prisioneiro>) super.getObjectosPersonalizados(pris); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void Actualizar(Object object) {
        Prisioneiro pris = (Prisioneiro) object;
        super.Actualizar(pris); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public ArrayList<Prisioneiro> Find(String id) {
        return super.Find(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    

    @Override
    public void Delete(int id) {
        super.Delete(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public void Inserir(Object object, Cela c) {
        Prisioneiro pris = (Prisioneiro) object;
        if (this.QtdEmCelaNormal(c) < 2) {
            super.Inserir(pris); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody

        } else {
            JOptionPane.showMessageDialog(null, "A Cela já Está Cheia");
        }
    }

    public int QtdEmCelaNormal(Cela c) {
        super.AbrirConexao();
        int qtd = 0;
        try ( PreparedStatement stmt = super.conex.prepareStatement("SELECT count(c.idBloco) as qtdEmCela FROM "
                + "sistgp.cela as c join prisioneiro as p on (c.idBloco = p.idBloco) where c.descricao = ?")) {
            stmt.setString(1, c.getCelaPK().getDescricao());

            try ( ResultSet rs = stmt.executeQuery()) {
                rs.next();
                qtd = rs.getInt("qtdEmCela");

                return qtd;
            }

        } catch (SQLException ex) {
            super.FecharConexao();
            JOptionPane.showMessageDialog(null, ex);
            return 0;
        }
    }

//    public ArrayList findEspecifico(CelaPK celaPK) {
//        this.AbrirConexao();
//        try (PreparedStatement stmt = this.conex.prepareStatement("SELECT idBloco FROM cela WHERE descricao = ?")) {
//            stmt.setString(1, celaPK.getDescricao());
//         
//            try (ResultSet rs = stmt.executeQuery()) {
//                rs.next();
//                return rs.getInt("idBloco");
//            }
//            
//        } catch (SQLException ex) {
//            this.FecharConexao();
//            ex.printStackTrace();
//            return 0;
//        }
//    select p.nome,p.`dataEntrada`,c.descricao,esq.descricao,j.tribunal,ej.pena ,cl.descricao,b.descricao
//from prisioneiro as p join crime as c on (p.`numBI` = c.`numBI`)
//join esquadra as esq on (esq.`idEsquadra`=c.`idEsquadra`)
//join e_julgado as ej on (ej.`numBI` = p.`numBI`)
//join julgamento as j on (j.`idJulgamento` = ej.`idJulgamento`)
//join cela as cl on (cl.`idBloco` = p.`idBloco`)
//join bloco as b on (cl.`idBloco` = b.`idBloco`)
    public Object[] ListaTabela() {
        this.AbrirConexao();
        Object[] b = {};
        String sql = String.format("select p.nome,p.`dataEntrada`,c.descricao,esq.descricao,j.tribunal,ej.pena ,cl.descricao,b.descricao"
                + "from prisioneiro as p join crime as c on (p.`numBI` = c.`numBI`)"
                + "join esquadra as esq on (esq.`idEsquadra`=c.`idEsquadra`)"
                + "join e_julgado as ej on (ej.`numBI` = p.`numBI`)"
                + "join julgamento as j on (j.`idJulgamento` = ej.`idJulgamento`)"
                + "join cela as cl on (cl.`idBloco` = p.`idBloco`)"
                + "join bloco as b on (cl.`idBloco` = b.`idBloco`)");
        try ( java.sql.Statement stmt = this.conex.createStatement()) {
            stmt.execute(sql);
            try ( ResultSet rs = stmt.executeQuery(sql)) {
                 while (rs.next()) {                    
                    Object[] a = { rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)}; 
                    b=a;
                 }
                 return b;
            }

        } catch (SQLException ex) {
            this.FecharConexao();
            ex.printStackTrace();
            return null;
        }
    }
    
    public void CarregarRelact(Prisioneiro p, Crime crime, CelaPK c, Bloco b, EJulgado ej, JulgamentoPK j, Esquadra esq){
    this.AbrirConexao();
        String sql = String.format("call RelactorioPris(?)");
        try ( PreparedStatement stmt = this.conex.prepareStatement(sql)) {
            stmt.setString(1, p.getNumBI());
            try ( ResultSet rs = stmt.executeQuery(sql)) {
                rs.next();
                p.setNome(rs.getString(1));
                p.setDataEntrada(rs.getString(2));
                crime.setDescricao(rs.getString(3));
                esq.setDescricao(rs.getString(4));
                j.setTribunal(rs.getString(5));
                ej.setPena(rs.getString(6));
                b.setDescricao(rs.getString(7));
                c.setDescricao(rs.getString(8));
            }

        } catch (SQLException ex) {
            this.FecharConexao();
            ex.printStackTrace();
        }
    }

}
