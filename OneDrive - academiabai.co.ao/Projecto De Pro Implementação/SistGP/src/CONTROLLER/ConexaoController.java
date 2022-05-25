/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Melhor De Mim
 */
public class ConexaoController {
    private Connection conex;
    private Statement stmt;
    
    public void Abrir() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistgp?autoReconnect=true", "root", "");
            System.out.println("Conexão Aberta com sucesso");
        } 
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally{
            
        }
    }
    
    public void Fechar(){
        try {
            if (stmt != null) {
                stmt.close();
                conex.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}
