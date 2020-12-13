package br.ufes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alcebiades
 */
public class ConexaoFactory {

    public static Connection getConexao() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:sqlite:bancoDeDados/bdprova.db");
        } catch (SQLException e) {
            System.out.println("falha na conexão: " + e);
        }
        return con;
    }

    public static void fecharConexao(Connection conn) {
        try {
            if (conn.isClosed() == false) {
                conn.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void fecharConexao(Connection conn, PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
              System.err.println(e.getMessage());
        }
    }

    public static void fecharConexao(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
              System.err.println(e.getMessage());
        }
    }
}
