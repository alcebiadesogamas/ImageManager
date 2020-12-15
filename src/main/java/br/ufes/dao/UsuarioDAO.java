package br.ufes.dao;

import br.ufes.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alcebiades
 */
public class UsuarioDAO {

    public void createUser(Usuario user, String password) throws Exception {

        Connection conn = ConexaoFactory.getConexao();

        PreparedStatement ps = null;

        if (user == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {

            String SQL = "INSERT INTO usuario (nome, senha, admin) values (?, ?, ?);";

            ps = conn.prepareStatement(SQL);
            ps.setString(1, user.getNome());
            ps.setString(2, password);

            if (user.isAdmin()) {
                ps.setBoolean(3, true);
            } else {
                ps.setBoolean(3, false);
            }

            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados " + sqle);
        } finally {
            ConexaoFactory.fecharConexao(conn, ps);
        }
    }

    public boolean isAdmin(Usuario user) throws Exception {
        Connection conn = ConexaoFactory.getConexao();

        PreparedStatement ps = null;

        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select (admin) from usuario where nome = ?");
            ps.setString(1, user.getNome());

            rs = ps.executeQuery();
            boolean aux = rs.getBoolean(1);
            return aux;

        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConexaoFactory.fecharConexao(conn, ps, rs);
        }

    }

    public boolean findUserByName(String nome) throws Exception {
        Connection conn = ConexaoFactory.getConexao();

        PreparedStatement ps = null;

        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from usuario where nome = ?");
            ps.setString(1, nome);
            rs = ps.executeQuery();

            return !rs.next(); //if not exists a username like nome it returns true.

        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConexaoFactory.fecharConexao(conn, ps, rs);
        }

    }

    public boolean findAnyUser() throws Exception {
        Connection conn = ConexaoFactory.getConexao();
        PreparedStatement ps = null;

        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from usuario");

            rs = ps.executeQuery();

            return rs.next(); //if there is some user it returns true.

        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConexaoFactory.fecharConexao(conn, ps, rs);
        }

    }

    public boolean findUserByNameAndPassword(String username, String pass) throws Exception {
        Connection conn = ConexaoFactory.getConexao();
        PreparedStatement ps = null;
        boolean found = false;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from usuario where nome = ? and senha = ?;");
            ps.setString(1, username);
            ps.setString(2, pass);
            rs = ps.executeQuery();

            found = rs.next(); //returns true or false if exists.

        } catch (SQLException sqle) {
            throw new Exception(sqle);

        } finally {
            ConexaoFactory.fecharConexao(conn, ps, rs);
        }
        return found;
    }

    public Usuario findIdUserByName(Usuario user) throws Exception {
        Connection conn = ConexaoFactory.getConexao();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
         
            ps = conn.prepareStatement("select * from usuario where nome = ?;");
            ps.setString(1, user.getNome());
         
            rs = ps.executeQuery();

            int id = rs.getInt(1);
            user.setId(id);
            user.setAdmin(rs.getBoolean(4));
        
            return user; 

        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConexaoFactory.fecharConexao(conn, ps, rs);
        }

    }

    public ArrayList findAll() throws Exception {
        Connection conn = ConexaoFactory.getConexao();

        PreparedStatement ps = null;

        ResultSet rs = null;
        try {

            ps = conn.prepareStatement("select idusuario, nome, admin from usuario");
            rs = ps.executeQuery();

            ArrayList<Usuario> list = new ArrayList<>();
            Usuario user = new Usuario();
            while (rs.next()) {
                user.setId(rs.getInt(1));
                user.setNome(rs.getString(2));
                user.setAdmin(rs.getBoolean(3));
                list.add(user);
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConexaoFactory.fecharConexao(conn, ps, rs);
        }
    }

    public void delete(Usuario user) throws Exception {
        Connection conn = ConexaoFactory.getConexao();

        PreparedStatement ps = null;

        if (user == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            //delete all notifications and permissions
            ps = conn.prepareStatement("delete from usuario where idusuario = ?");
            ps.setInt(1, user.getId());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados:" + sqle);
        } finally {
            ConexaoFactory.fecharConexao(conn, ps);
        }
    }
}
