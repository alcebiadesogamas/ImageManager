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
    private Connection conn;

    public UsuarioDAO() throws Exception {
        try {
            this.conn = ConexaoSQLITE.getConexao();
        } catch (Exception e) {
            throw new Exception("Erro: \n" + e.getMessage());
        }
    }
    
    public void createUser(Usuario user) throws Exception {
        PreparedStatement ps = null;

        if (user == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
                      
            String SQL = "INSERT INTO usuario (nome, senha, admin) values (?, ?,?);";

            ps = conn.prepareStatement(SQL);
            ps.setString(1, user.getNome());
            ps.setString(2, user.getSenha());
            
            if(user.isAdmin())
                ps.setBoolean(3, true);
            else
                ps.setBoolean(3, false);
            
            ps.executeUpdate();
            
        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados " + sqle);
        } finally {
            ConexaoSQLITE.fecharConexao(conn, ps);
        }
    }
    
     public Usuario findUserByName(String nome) throws Exception {
        PreparedStatement ps = null;

        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from usuario where nome = ?");
            ps.setString(1, nome);
            rs = ps.executeQuery();
            if (!rs.next()) {
                throw new Exception("Não foi encontrado nenhum registro com o Nome: " + nome);
            }
            
            Usuario user = new Usuario();
            user.setId(rs.getInt(1));
            user.setNome(rs.getString(2));
            user.setAdmin(rs.getBoolean(3));
            return user;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConexaoSQLITE.fecharConexao(conn, ps, rs);
        }
        
    }
  
    public ArrayList findAll() throws Exception {
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
            ConexaoSQLITE.fecharConexao(conn, ps, rs);
        }
    }
    
    public void delete(Usuario user) throws Exception {
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
            ConexaoSQLITE.fecharConexao(conn, ps);
        }
        
        
    }
}
