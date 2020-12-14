package br.ufes.dao;

import br.ufes.model.Permissao;
import br.ufes.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Alcebiades
 */
public class PermissaoDAO {

    public void AddPermission(Permissao permission) throws Exception {
        Connection conn = ConexaoFactory.getConexao();

        PreparedStatement ps = null;

        if (permission == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {

            String SQL = "INSERT INTO permissao (idusuario, idimagem, excluir, visualizar, compartilhar)"
                    + " values (?, ?, ?, ?, ?);";

            ps = conn.prepareStatement(SQL);
            ps.setInt(1, permission.getUsuario().getId());
            ps.setInt(2, permission.getImagem().getId());
            ps.setBoolean(3, permission.isExcluir());
            ps.setBoolean(4, permission.isVizualizar());
            ps.setBoolean(5, permission.isCompartilhar());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados " + sqle);
        } finally {
            ConexaoFactory.fecharConexao(conn, ps);
        }
    }

    public Usuario getAllPermissionOf(Usuario user) throws Exception {
        Connection conn = ConexaoFactory.getConexao();

        PreparedStatement ps = null;
        ResultSet rs = null;
        if (user == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            //a procedure to get a user and you id;
            UsuarioDAO udao = new UsuarioDAO();
            Usuario aux = udao.findIdUserByName(user);

            String SQL = "select * from permissao where idusuario = ?;";
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, aux.getId());
            rs = ps.executeQuery();
            Permissao p = new Permissao();
            p.setExcluir(rs.getBoolean(3));
            p.setVizualizar(rs.getBoolean(4));

            p.setCompartilhar(rs.getBoolean(5));

            user.setPermissoes(p);
            return user;

        } catch (Exception e) {

        }
        return null;
    }

    public void AddPermissionExcluir(Permissao permission) throws Exception {
        Connection conn = ConexaoFactory.getConexao();

        PreparedStatement ps = null;

        if (permission == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {

            String SQL = "INSERT INTO permissao (idusuario, idimagem, excluir)"
                    + " values (?, ?, ?);";

            ps = conn.prepareStatement(SQL);
            ps.setInt(1, permission.getUsuario().getId());
            ps.setInt(2, permission.getImagem().getId());
            ps.setBoolean(3, permission.isExcluir());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados " + sqle);
        } finally {
            ConexaoFactory.fecharConexao(conn, ps);
        }
    }

    public void AddPermissionVizualizar(Permissao permission) throws Exception {
        Connection conn = ConexaoFactory.getConexao();

        PreparedStatement ps = null;

        if (permission == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {

            String SQL = "INSERT INTO permissao (idusuario, idimagem, visualizar)"
                    + " values (?, ?, ?);";

            ps = conn.prepareStatement(SQL);
            ps.setInt(1, permission.getUsuario().getId());
            ps.setInt(2, permission.getImagem().getId());
            ps.setBoolean(3, permission.isVizualizar());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados " + sqle);
        } finally {
            ConexaoFactory.fecharConexao(conn, ps);
        }
    }

    public void AddPermissionCompartilhar(Permissao permission) throws Exception {
        Connection conn = ConexaoFactory.getConexao();

        PreparedStatement ps = null;

        if (permission == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {

            String SQL = "INSERT INTO permissao (idusuario, idimagem, compartilhar)"
                    + " values (?, ?, ?);";

            ps = conn.prepareStatement(SQL);
            ps.setInt(1, permission.getUsuario().getId());
            ps.setInt(2, permission.getImagem().getId());
            ps.setBoolean(3, permission.isCompartilhar());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados " + sqle);
        } finally {
            ConexaoFactory.fecharConexao(conn, ps);
        }
    }
}
